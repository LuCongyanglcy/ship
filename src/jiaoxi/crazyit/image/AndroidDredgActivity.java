package jiaoxi.crazyit.image;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import jiaoxi.crazyit.image.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidDredgActivity extends Activity {
    /** Called when the activity is first created. */
	Button mConnectBtn;
	Button mExitBtn;
	
	TextView mTxtIp;
	EditText mServerPortTxt;
	
	private MyReceiver receiver;
	private MyReceiverCommand reciverCommand;
	
	
	private NewMyService.MyBinder myBinder;
	private ServiceConnection connection=new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			myBinder=(NewMyService.MyBinder)service;

		}
	};
	
	public String getLocalIpAddress() {  
        String ipaddress="";
        
        try {  
        	for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {  
        		NetworkInterface intf = en.nextElement();  
        		for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {  
                InetAddress inetAddress = enumIpAddr.nextElement();  
                if (!inetAddress.isLoopbackAddress()) {  
                        ipaddress=inetAddress.getHostAddress().toString();  
                	}  
        		}  
        	}  
        } catch (SocketException ex) {  
        	Log.e("WifiPreference IpAddress", ex.toString());  
        }  
        return ipaddress; 
    }
    @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
    	unregisterReceiver(receiver);
		unregisterReceiver(reciverCommand);
		if(connection!=null){
			unbindService(connection);
			connection=null;
		}
//		Intent stopIntent=new Intent(AndroidDredgActivity.this,MyService.class);
//		stopService(stopIntent);
		super.onDestroy();
	}

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setdredg);
        
        mConnectBtn=(Button)findViewById(R.id.connect);

        mExitBtn=(Button)findViewById(R.id.exit);
        
        mServerPortTxt=(EditText)findViewById(R.id.serverPort);
        
        mTxtIp=(TextView)findViewById(R.id.localIp);
        
        Intent bindIntent=new Intent(AndroidDredgActivity.this,NewMyService.class);
		bindService(bindIntent,connection,BIND_AUTO_CREATE);
		
		//Intent startIntent=new Intent(OperaServerCamActivity.this,MyService.class);
		startService(bindIntent);
		
		receiver=new MyReceiver();
		IntentFilter filter=new IntentFilter();
		filter.addAction("android.intent.action.MY_RECEIVER");
		registerReceiver(receiver, filter);
		
		reciverCommand=new MyReceiverCommand();
		IntentFilter filterCommand=new IntentFilter();
		filterCommand.addAction("android.intent.action.MY_RECEIVER_COM");
		registerReceiver(reciverCommand, filterCommand);
		String ip=getLocalIpAddress();
		mTxtIp.setText(ip);
		
		mExitBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(connection!=null){
					unbindService(connection);
					connection=null;
				}
				Intent stopIntent=new Intent(AndroidDredgActivity.this,NewMyService.class);
				stopService(stopIntent);
			}
		});
        
        //////////连接按钮
        mConnectBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String sPort=mServerPortTxt.getText().toString();
				if(sPort!=""){
					//myBinder.setApplyClassName("Decode11000", myBinder.getSocket());
					//myBinder.createListen(Integer.parseInt(sPort));
					
				}
				else{
					Toast.makeText(AndroidDredgActivity.this, "请输入服务器端口", Toast.LENGTH_SHORT).show();
				}
			}
		});

    }
    private class MyReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			Bundle bundle=intent.getExtras();
			boolean connectState=bundle.getBoolean("connectState");
			if(connectState){
				Toast.makeText(AndroidDredgActivity.this, "疏浚服务已开启", Toast.LENGTH_SHORT).show();
				Intent intent1=new Intent();
				intent1.setClass(AndroidDredgActivity.this, HandDraw1.class);
				
				startActivity(intent1); 
				overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
				finish();
				
			}
			else{
				Toast.makeText(AndroidDredgActivity.this, "客户端断开连接", Toast.LENGTH_SHORT).show();
			}
			
		}
    	
    }
    
    private class MyReceiverCommand extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			Bundle bundle=intent.getExtras();
			
			boolean commandState=bundle.getBoolean("commandState");
			if(commandState){
				Toast.makeText(AndroidDredgActivity.this, "命令成功执行", Toast.LENGTH_SHORT).show();
			}
		}
    	
    }
}