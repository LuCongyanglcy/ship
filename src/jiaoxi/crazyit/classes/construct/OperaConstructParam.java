package jiaoxi.crazyit.classes.construct;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import jiaoxi.crazyit.classes.xyz.Str_Xyz;


public class OperaConstructParam {
	public Str_Arm_Size readArmSize(String fileName){
		Str_Arm_Size sas=new Str_Arm_Size();
		File f=new File(fileName);
		int len=(int) f.length();
		byte[] s=new byte[len];
		
		InputStream in=null;
		try {
			in=new FileInputStream(f);
			in.read(s);
		} catch (Exception e) {
			// TODO: handle exception
			sas.BridgeLength=40.40f;
			sas.CutterRadum=1.01f;
			sas.CutterLength=1.01f;
			sas.PipeRadum=0.425f;
			sas.CutterHeadAngle=15f;
			sas.TrunnionZ=6.2f;
			sas.VelocityRadum=0.85f;
			sas.CutterStyle=0;
			return sas;
		}
		finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String tmpString=new String(s);
		String[] tmpValues=tmpString.split(",");
		sas.BridgeLength=Float.parseFloat(tmpValues[0]);
		sas.CutterRadum=Float.parseFloat(tmpValues[1]);
		sas.CutterLength=Float.parseFloat(tmpValues[2]);
		sas.PipeRadum=Float.parseFloat(tmpValues[3]);
		sas.CutterHeadAngle=Float.parseFloat(tmpValues[4]);
		sas.TrunnionZ=Float.parseFloat(tmpValues[5]);
		sas.VelocityRadum=Float.parseFloat(tmpValues[6]);
		sas.CutterStyle=Byte.parseByte(tmpValues[7]);
		
		return sas;
	}
	public void saveSerArmSize(String path,Str_Arm_Size sas){
		File f=new File(path);
		if(f.exists()){
			f.delete();
		}
		try {
			OutputStream os=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(os);
			oos.writeObject(sas);
			oos.close();
			os.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	public Str_Arm_Size readSerArmSize(String path){
		Str_Arm_Size sas=null;
		try {
			
			InputStream in=new FileInputStream(path);
			ObjectInputStream ois=new ObjectInputStream(in);
			sas=(Str_Arm_Size)ois.readObject();
			ois.close();
			in.close();
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			sas=new Str_Arm_Size();
			sas.BridgeLength=40.40f;
			sas.CutterRadum=1.01f;
			sas.CutterLength=1.01f;
			sas.PipeRadum=0.425f;
			sas.CutterHeadAngle=15f;
			sas.TrunnionZ=6.2f;
			sas.VelocityRadum=0.85f;
			sas.CutterStyle=0;
			//e.printStackTrace();
		}
		return sas;
	}
}
