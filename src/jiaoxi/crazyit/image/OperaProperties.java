package jiaoxi.crazyit.image;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import android.content.Context;

public class OperaProperties {
	public Properties getProperties(Context context, String propertiesName){
		Properties props=new Properties();
		try {
			FileInputStream s=context.openFileInput(propertiesName);
			props.load(s);
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return props;
	}
	
	public void saveProperties(Context context,String propertiesName,Properties properties){
		try {
			FileOutputStream s=context.openFileOutput(propertiesName, Context.MODE_PRIVATE);
			properties.store(s, "");
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
