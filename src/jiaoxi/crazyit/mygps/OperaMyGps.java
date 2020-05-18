package jiaoxi.crazyit.mygps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;

public class OperaMyGps {
	public static boolean gpsValid=false;
	public static boolean networkValid=false;
	private static LocationManager locationManager;
	public static double lat=0;	/////南纬
	public static double lng=0;///东经
	public static double speed=0;///速度
	public static double bearing=0;/////方向
	public static double altitude=0;///高度
	public static float accuracy=0;///精度
	private static GpsStatus status;////状态
	public static boolean isLocation=false;/////是否正在定位
//////卫星状态
	public static List<GpsSatellite> numSatelliteList = new ArrayList<GpsSatellite>(); // 卫星信号
	//////////////////////////////平板自带gps数据,网络定位,又是麻烦事
	///////确定gps,和agps是否开启
	public static final void isOpen(Context contex){
		locationManager=(LocationManager)contex.getSystemService(Context.LOCATION_SERVICE);
		// 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）
		gpsValid = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		// 通过WLAN或移动网络(3G/2G)确定的位置（也称作AGPS，辅助GPS定位。主要用于在室内或遮盖物（建筑群或茂密的深林等）密集的地方定位）
		networkValid = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
	}
	
	//////////强制打开gps,这个在4.0以上版本用不起来
	public static final void openGps(Context context){
		Intent gpsIntent=new Intent();
		gpsIntent.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
		gpsIntent.setData(Uri.parse("custom:3"));
		try {
			PendingIntent.getBroadcast(context, 0, gpsIntent, 0).send();
		} catch (CanceledException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//////////////跟gps服务关联,通过回调方法获取数据
	public static final void setRequestLocation(Context context){
		isOpen(context);
		if(gpsValid){
			///////先获取现在的gps数据,再绑定
			Location location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			/*lat=location.getLatitude();
			lng=location.getLongitude();
			speed=location.getSpeed();
			bearing=location.getBearing();*/
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 0, locationListener);
			locationManager.addGpsStatusListener(statusListener);
		}
	}
	/////////gps监听事件
	public static final LocationListener locationListener=new LocationListener() {
		
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO 自动生成的方法存根
			
		}
		
		@Override
		public void onProviderEnabled(String provider) {
			// TODO 自动生成的方法存根
			
		}
		
		@Override
		public void onProviderDisabled(String provider) {
			// TODO 自动生成的方法存根
			
		}
		
		@Override
		public void onLocationChanged(Location location) {
			// TODO 自动生成的方法存根
			/////////当gps位置改变时,获取数据
			lat=location.getLatitude();
			lng=location.getLongitude();
			speed=location.getSpeed();
			bearing=location.getBearing();
			altitude=location.getAltitude();
			accuracy=location.getAccuracy();
		}
	};
	
	
	
	private final static GpsStatus.Listener statusListener = new GpsStatus.Listener() {

		@Override
		public void onGpsStatusChanged(int event) {
			// TODO 自动生成的方法存根
			status = locationManager.getGpsStatus(null);
			if(event==GpsStatus.GPS_EVENT_FIRST_FIX){
				isLocation=true;
			}
			if (event == GpsStatus.GPS_EVENT_SATELLITE_STATUS) { 
				
				int maxSatellites = status.getMaxSatellites();
				Iterator<GpsSatellite> it = status.getSatellites().iterator();
				numSatelliteList.clear();
				int count = 0;
				while (it.hasNext() && count <= maxSatellites) {
					GpsSatellite s = it.next();
					numSatelliteList.add(s);
					count++;
				}

			}
		}

	};
}
