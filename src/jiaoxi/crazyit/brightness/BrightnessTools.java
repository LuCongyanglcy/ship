package jiaoxi.crazyit.brightness;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.view.WindowManager;



public class BrightnessTools {
	public static int nowBrightnessValue;/////当前亮度
	private static ContentResolver resolver;
	///////判断是否是自动调节
	private static boolean isAutoBrightness(ContentResolver aContentResolver){
		boolean automicBrightness=false;
		try {
			automicBrightness=Settings.System.getInt(aContentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE)==Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
		} catch (SettingNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return automicBrightness;
	}
	
	////////////获取亮度
	public static void getScreenBrightness(Activity activity){
		resolver=activity.getContentResolver();
		try {
			nowBrightnessValue=android.provider.Settings.System.getInt(resolver, Settings.System.SCREEN_BRIGHTNESS);
		} catch (SettingNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
	}
	///////设置亮度
	public static void setBrightness(Activity activity,int brightness){
		/*if(isAutoBrightness(resolver)){
			stopAutoBrightness(resolver);
		}*/
		float b=brightness*1.0f/255f;
		if(b>1.0f){
			b=1.0f;
		}
		if(b<0.04f){
			b=0.04f;
		}
		WindowManager.LayoutParams lp=activity.getWindow().getAttributes();
		lp.screenBrightness=b;
		activity.getWindow().setAttributes(lp);
	}
	
	///////保存亮度
	public static void saveBrightness(int brightness){
		Uri uri=Settings.System.getUriFor("screen_brightness");
		Settings.System.putInt(resolver, "screen_brightness", brightness);
		resolver.notifyChange(uri, null);
	}
	////////取消亮度自动调节
	public static void stopAutoBrightness(ContentResolver resolver){
		Settings.System.putInt(resolver, Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
	}
	//////开启亮度自动调节
	public static void startAutoBrightness(ContentResolver resolver){
		Settings.System.putInt(resolver, Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC);
	}
}
