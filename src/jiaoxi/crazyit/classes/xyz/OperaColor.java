package jiaoxi.crazyit.classes.xyz;

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

import android.graphics.Color;


public class OperaColor {
	
	public Str_Colors readSer_color(String fileName){
		Str_Colors colors=null;
		try {
			
			InputStream in=new FileInputStream(fileName);
			ObjectInputStream ois=new ObjectInputStream(in);
			colors=(Str_Colors)ois.readObject();
			ois.close();
			in.close();
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			colors=new Str_Colors();
			for(int i=0;i<20;i++){
				colors.deeps[0]=i+1;
			}
			
			colors.colors[0]=Color.rgb(255, 255, 128);
			colors.colors[1]=Color.rgb(255, 255, 64);
			colors.colors[2]=Color.rgb(255, 255, 17);
			colors.colors[3]=Color.rgb(255, 251, 0);
			colors.colors[4]=Color.rgb(232,232,0);
			colors.colors[5]=Color.rgb(221,221,0);
			colors.colors[6]=Color.rgb(198,198,0);
			colors.colors[7]=Color.rgb(145,145,0);
			colors.colors[8]=Color.rgb(115,115,0);
			colors.colors[9]=Color.rgb(128,255,128);
			colors.colors[10]=Color.rgb(85,255,85);
			colors.colors[11]=Color.rgb(80,182,92);
			colors.colors[12]=Color.rgb(60,255,60);
			colors.colors[13]=Color.rgb(2,255,2);
			colors.colors[14]=Color.rgb(0,206,0);
			colors.colors[15]=Color.rgb(0,168,0);
			colors.colors[16]=Color.rgb(0,121,0);
			colors.colors[17]=Color.rgb(198,138,128);
			colors.colors[18]=Color.rgb(124,68,44);
			colors.colors[19]=Color.rgb(98,49,49);
			e.printStackTrace();
		}
		return colors;
	}
	public void saveSer_color(String fileName,Str_Colors colors){
		File f=new File(fileName);
		if(f.exists()){
			f.delete();
		}
		try {
			OutputStream os=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(os);
			oos.writeObject(colors);
			oos.close();
			os.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public Str_Colors read_color(String fileName){
		Str_Colors colors=new Str_Colors();
		File f=new File(fileName);
		InputStream in=null;
		int fileLen=(int) f.length();
		byte[] s=new byte[fileLen];
		try {
			in=new FileInputStream(f);
			in.read(s);
		} catch (Exception e) {
			// TODO: handle exception
			colors.colorModel=false;
			return colors;
		}
		finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		byte[] s0=new byte[100];
		int seek=0;
		for(int i=0;i<20;i++){
			seek=readLineData(s, s0, fileLen, seek, 100);
			colors.deeps[i]=Float.parseFloat((new String(s0)).trim());
			seek=readLineData(s, s0, fileLen, seek, 100);
			int color=Integer.parseInt((new String(s0)).trim());
			int blue=(color & 0xff0000)>>16;
			int green=(color & 0x00ff00)>>8;
			int red=(color & 0x0000ff);
			colors.colors[i]=Color.rgb(red, green, blue);
			seek=readLineData(s, s0, fileLen, seek, 100);
			int tmp=Integer.parseInt((new String(s0)).trim());
			if(tmp==0){
				colors.enables[i]=false;
			}
			else
				colors.enables[i]=true;
		}
		seek=readLineData(s, s0, fileLen, seek, 100);
		int tmp=Integer.parseInt((new String(s0)).trim());
		if(tmp==0){
			colors.colorModel=false;
		}
		else
			colors.colorModel=true;
		return colors;
	}
	public int readLineData(byte[] s,byte[] s0,int fileLen,int seek,int maxLen){
		int i,k;
		for(i=0;i<maxLen;i++){
			s0[i]=0;
		}
		for(i=seek;i<fileLen;i++){
			if(s[i]==',')
				break;
			}
		if(i-seek<maxLen){
			for(k=0;k<i-seek;k++)
				s0[k]=s[seek+k];
		}
		return i+1;
	}
}
