package jiaoxi.crazyit.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

import jiaoxi.crazyit.classes.dxf.Dxf_r12;


public class OperaTraceLine {
	public void readFromFile_TraceLine(Str_TraceLine strTraceLine,String fileName){
		File f=new File(fileName);
		int len=(int) f.length();
		byte[] s=new byte[len];
		byte[] s0=new byte[256];
		InputStream in=null;
		try {
			in=new FileInputStream(f);
			in.read(s);
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
		finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		int seek=0;
		seek=readLineData(s, s0, len, seek, 20);
		int maxLine=Integer.parseInt((new String(s0)).trim());
		if(maxLine<=0){
			return;
		}
		seek=readLineData(s, s0, len, seek, 20);
		strTraceLine.currentTraceLine=Integer.parseInt((new String(s0)).trim());
		for(int i=0;i<maxLine;i++){
			Str_Line sl=new Str_Line();
			seek=readLineData(s, s0, len, seek, 20);
			sl.GroupNum=Integer.parseInt((new String(s0)).trim());
			seek=readLineData(s, s0, len, seek, 20);
			sl.LineBeginPointX=Float.parseFloat((new String(s0)).trim());
			seek=readLineData(s, s0, len, seek, 20);
			sl.LineBeginPointY=Float.parseFloat((new String(s0)).trim());
			seek=readLineData(s, s0, len, seek, 20);
			sl.LineEndPointX=Float.parseFloat((new String(s0)).trim());
			seek=readLineData(s, s0, len, seek, 20);
			sl.LineEndPointY=Float.parseFloat((new String(s0)).trim());
			
			seek=readLineData(s, s0, len, seek, 20);
			sl.DesignDeep=Float.parseFloat((new String(s0)).trim());
			seek=readLineData(s, s0, len, seek, 200);
			sl.SectionName=new String(s0);
			sl.LineAngle=getAngle_TraceLine(sl.LineBeginPointX, sl.LineBeginPointY, sl.LineEndPointX, sl.LineEndPointY);
			sl.LineLength=getLength_TraceLine(sl.LineBeginPointX, sl.LineBeginPointY, sl.LineEndPointX, sl.LineEndPointY);
			strTraceLine.strLines.add(sl);
		}
	}
	public double getLength_TraceLine(double x1,double y1,double x2,double y2){
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	public double getAngle_TraceLine(double x1,double y1,double x2,double y2){
		double alpha;
		if(x2-x1==0){
			if(y2-y1>0)
			alpha=Math.PI/2;
			else alpha=-Math.PI/2;
		}
		else{
			if(x2-x1>0){
				alpha=Math.atan((y2-y1)/(x2-x1));
			}
			else{
				if(y2-y1>=0)
					alpha=Math.atan((y2-y1)/(x2-x1))+Math.PI;
				else
					alpha=Math.atan((y2-y1)/(x2-x1))-Math.PI;
			}
		}
		if(alpha<0)
			alpha+=2*Math.PI;
		return alpha;
	}
	public int  readLineData(byte[] s,byte[] s0,int FileLen,int seek,int MaxLen){
		int i,k;
		for(i=0;i<MaxLen;i++){
			s0[i]=0;
		}
		for(i=seek;i<FileLen;i++){
			if(s[i]==',')
				break;
			}
		if(i-seek<MaxLen){
			for(k=0;k<i-seek;k++)
				s0[k]=s[seek+k];
		}
		return i+1;
	}
	
	public Str_TraceLine readSerStrTraceLine(String path){
		Str_TraceLine st=null;
		try {
			
			InputStream in=new FileInputStream(path);
			ObjectInputStream ois=new ObjectInputStream(in);
			st=(Str_TraceLine)ois.readObject();
			ois.close();
			in.close();
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			st=new Str_TraceLine();
			e.printStackTrace();
		}
		return st;
	}
	public void saveSerStrTraceLine(String path,Str_TraceLine strTraceLine){
		File f=new File(path);
		if(f.exists()){
			f.delete();
		}
		try {
			OutputStream os=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(os);
			oos.writeObject(strTraceLine);
			oos.close();
			os.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
