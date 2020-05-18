package jiaoxi.crazyit.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class OperaStrTrochoidReal {
	public static void saveTrochoidReal(String path,Str_Trochoid_Real str){
		File f=new File(path);
		if(f.exists()){
			f.delete();
		}
		try {
			OutputStream os=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(os);
			oos.writeObject(str);
			oos.close();
			os.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public static Str_Trochoid_Real readSerTrochoidReal(String path){
		Str_Trochoid_Real str=null;
		try {
			FileInputStream in=new FileInputStream(path);
			ObjectInputStream ois=new ObjectInputStream(in);
			str=(Str_Trochoid_Real)ois.readObject();
			ois.close();
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			str=new Str_Trochoid_Real();
			
		}
		
		return str;
	}
}
