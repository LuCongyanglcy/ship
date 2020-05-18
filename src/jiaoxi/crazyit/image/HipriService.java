package jiaoxi.crazyit.image;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.IBinder;

public class HipriService extends Service {

	private static final String TAG = "ss";
	private AtomicBoolean enabledMobile = new AtomicBoolean(false);

    public boolean enableMobileConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null == cm) {
            //Log.d(TAG, "ConnectivityManager is null, cannot try to force a mobile connection");
            return false;
        }

        /*
         * Don't do anything if we are connecting. On the other hands re-new
         * connection if we are connected.
         */
        State state = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE_HIPRI).getState();
        //Log.d(TAG, "TYPE_MOBILE_HIPRI network state: " + state);
        if (0 == state.compareTo(State.CONNECTING))
            return true;

        /*
         * Re-activate mobile connection in addition to other connection already
         * activated
         */
        int resultInt = cm.startUsingNetworkFeature(ConnectivityManager.TYPE_MOBILE, "enableHIPRI");
        //Log.d(TAG, "startUsingNetworkFeature for enableHIPRI result: " + resultInt);

        //-1 means errors
        // 0 means already enabled
        // 1 means enabled
        // other values can be returned, because this method is vendor specific
        if (-1 == resultInt) {
            //Log.e(TAG, "Wrong result of startUsingNetworkFeature, maybe problems");
            return false;
        }
        if (0 == resultInt) {
            //Log.d(TAG, "No need to perform additional network settings");
            return true;
        }

        return requestRouteToHost(this, "112.83.126.129");
    }

    private Thread pingerThread = null;

    private void startMobileConnection() {
        enabledMobile.set(true);
        pingerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (enabledMobile.get()) {
                    /*
                     * Renew mobile connection. No routing setup is needed. This
                     * should be moved to 3g monitoring service one day.
                     */
                    enableMobileConnection();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // do nothing
                    }
                }
            }
        });
        pingerThread.start();
    }

    private void stopMobileConnection() {
        enabledMobile.set(false);
        disableMobileConnection();
        pingerThread.interrupt();
        pingerThread = null;
    }

    public void disableMobileConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        cm.stopUsingNetworkFeature(ConnectivityManager.TYPE_MOBILE, "enableHIPRI");
    }

    public final static int inetAddressToInt(InetAddress inetAddress) {
        byte[] addrBytes;
        int addr;
        addrBytes = inetAddress.getAddress();
        addr = ((addrBytes[3] & 0xff) << 24) | ((addrBytes[2] & 0xff) << 16) | ((addrBytes[1] & 0xff) << 8)
                | (addrBytes[0] & 0xff);
        return addr;
    }

    public final static InetAddress lookupHost(String hostname) {
        try {
            return InetAddress.getByName(hostname);
        } catch (UnknownHostException e) {
            return null;
        }
    }

    private boolean requestRouteToHost(Context context, String hostname) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null == cm) {
            //Log.d(TAG, "ConnectivityManager is null, cannot try to force a mobile connection");
            return false;
        }

        /* Wait some time needed to connection manager for waking up */
        try {
            for (int counter = 0; enabledMobile.get() && counter < 30; counter++) {
                State checkState = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE_HIPRI).getState();
                //Log.i(TAG, "Waiting for mobile data on. State " + checkState);
                if (0 == checkState.compareTo(State.CONNECTED))
                    break;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            //nothing to do
        }

        if (!enabledMobile.get()) {
           // Log.d(TAG, "Mobile data is turned off while waiting for routing.");
            return false;
        }

        State checkState = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE_HIPRI).getState();
        if (0 != checkState.compareTo(State.CONNECTED)) {
            //Log.e(TAG, "Mobile data is still turned off after 30 sec of waiting.");
            return false;
        }
        //Log.i(TAG, "Adding routing for " + hostname);

        InetAddress inetAddress = lookupHost(hostname);
        if (inetAddress == null) {
            //Log.e(TAG, "Failed to resolve " + hostname);
            return false;
        }
        int hostAddress = inetAddressToInt(inetAddress);

        boolean resultBool = cm.requestRouteToHost(ConnectivityManager.TYPE_MOBILE_HIPRI, hostAddress);
        /*Log.d(TAG, "requestRouteToHost result: " + resultBool);
        if (!resultBool)
            Log.e(TAG, "Wrong requestRouteToHost result: expected true, but was false");*/

        return resultBool;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        startMobileConnection();
    }

    @Override
    public void onDestroy() {
        stopMobileConnection();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
