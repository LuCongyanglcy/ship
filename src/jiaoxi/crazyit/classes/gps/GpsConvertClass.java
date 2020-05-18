package jiaoxi.crazyit.classes.gps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import android.os.SystemClock;


public class GpsConvertClass {
	
	public static GpsParam ReadGpsParam(String fileName){

		GpsParam gpsParam;
		try {
			FileInputStream in=new FileInputStream(fileName);
			ObjectInputStream ois=new ObjectInputStream(in);
			gpsParam=(GpsParam)ois.readObject();
			ois.close();
			in.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			gpsParam=new GpsParam();
			gpsParam.GPS_CS_a=6378245;
			gpsParam.GPS_CS_f=298.3;
			gpsParam.GPS_CS_ZYZWX=123;
			gpsParam.GPS_CS_S=1;
			gpsParam.GPS_CS_DeltaY=500000;
			gpsParam.GPS_UTM_Scale=1;
		}
		
		return gpsParam;
	}
	
	public static void saveGpsParam(String fileName,GpsParam gp){
		File f=new File(fileName);
		if(f.exists()){
			f.delete();
		}
		try {
			OutputStream os=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(os);
			oos.writeObject(gp);
			oos.close();
			os.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	private static double bytesToDouble(byte[] sourceData,int begin){
		//return Float.intBitsToFloat(getInt(sourceData, begin));
		byte[] ss=new byte[8];
		ss[0]=sourceData[begin+7];
		ss[1]=sourceData[begin+6];
		ss[2]=sourceData[begin+5];
		ss[3]=sourceData[begin+4];
		ss[4]=sourceData[begin+3];
		ss[5]=sourceData[begin+2];
		ss[6]=sourceData[begin+1];
		ss[7]=sourceData[begin+0];
		ByteBuffer bb=ByteBuffer.wrap(ss);
		return bb.asDoubleBuffer().get();
	}
	
	private static int bytesToInt(byte[] sourceData,int begin){
		//return Float.intBitsToFloat(getInt(sourceData, begin));
		byte[] ss=new byte[4];
		ss[0]=sourceData[begin];
		ss[1]=sourceData[begin+1];
		ss[2]=sourceData[begin+2];
		ss[3]=sourceData[begin+4];
		
		ByteBuffer bb=ByteBuffer.wrap(ss);
		return bb.asIntBuffer().get();
	}
	
	public static GpsParam readGpsParamFromFile(String fileName){
		GpsParam gp=new GpsParam();
		File f=new File(fileName);
		int len=(int) f.length();
		InputStream in=null;
		byte[] s=new byte[len];
		try {
			in=new FileInputStream(f);
			in.read(s);
		} catch (Exception e) {
			// TODO: handle exception
			gp.GPS_CS_a=6378245;
			gp.GPS_CS_f=298.3;
			gp.GPS_CS_ZYZWX=123;
			gp.GPS_CS_S=1;
			gp.GPS_CS_DeltaY=500000;
			gp.GPS_UTM_Scale=1;
		}
		finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		int index=0;
		gp.GPS_CS_a=bytesToDouble(s, index);
		index+=8;
		gp.GPS_CS_f=bytesToDouble(s, index);
		index+=40;
		gp.GPS_CS_ZYZWX=bytesToDouble(s, index);
		index+=8;
		gp.GPS_CS_Tx=bytesToDouble(s, index);
		index+=8;
		gp.GPS_CS_Ty=bytesToDouble(s, index);
		index+=8;
		gp.GPS_CS_Tz=bytesToDouble(s, index);
		index+=8;
		gp.GPS_CS_S=bytesToDouble(s, index);
		index+=8;
		gp.GPS_CS_Rx=bytesToDouble(s, index);
		index+=8;
		gp.GPS_CS_Ry=bytesToDouble(s, index);
		index+=8;
		gp.GPS_CS_Rz=bytesToDouble(s, index);
		index+=8;
		gp.GPS_CS_DeltaX=bytesToDouble(s, index);
		index+=8;
		gp.GPS_CS_DeltaY=bytesToDouble(s, index);
		index+=8;
		gp.GPS_CS_DeltaZ=bytesToDouble(s, index);
		index+=8;
		gp.GPS_UTM_Scale=bytesToDouble(s, index);
		index+=8;
		gp.GPS_CS_Mode=bytesToInt(s, index);
		index+=4;
		if(s[index]==0x01){
			gp.bLocalChange=true;
		}
		else{
			gp.bLocalChange=false;
		}
		index+=1;
		gp.fRotateCenterX=bytesToDouble(s, index);
		index+=8;
		gp.fRotateCenterY=bytesToDouble(s, index);
		index+=8;
		gp.fRotateAngle=bytesToDouble(s, index);
		index+=8;
		gp.fRotateScale=bytesToDouble(s, index);
		//gp.bLocalChange=s[index];
		/*String ss=new String(s);
		String[] arrayss=ss.split(",");
		gp.GPS_CS_a=Double.parseDouble(arrayss[0]);
		gp.GPS_CS_f=Double.parseDouble(arrayss[1]);
		gp.GPS_CS_ZYZWX=Double.parseDouble(arrayss[2]);
		gp.GPS_CS_Tx=Double.parseDouble(arrayss[3]);
		gp.GPS_CS_Ty=Double.parseDouble(arrayss[4]);
		gp.GPS_CS_Tz=Double.parseDouble(arrayss[5]);
		gp.GPS_CS_S=Double.parseDouble(arrayss[6]);
		gp.GPS_CS_Rx=Double.parseDouble(arrayss[7]);
		gp.GPS_CS_Ry=Double.parseDouble(arrayss[8]);
		gp.GPS_CS_Rz=Double.parseDouble(arrayss[9]);
		gp.GPS_CS_DeltaX=Double.parseDouble(arrayss[10]);
		gp.GPS_CS_DeltaY=Double.parseDouble(arrayss[11]);
		gp.GPS_CS_DeltaZ=Double.parseDouble(arrayss[12]);
		gp.GPS_UTM_Scale=Double.parseDouble(arrayss[13]);
		gp.GPS_CS_Mode=Integer.parseInt(arrayss[14]);
		int tmp=Integer.parseInt(arrayss[15]);
		if(tmp==0){
			gp.bLocalChange=false;
		}
		else{
			gp.bLocalChange=true;
		}
		gp.fRotateCenterX=Double.parseDouble(arrayss[16]);
		gp.fRotateCenterY=Double.parseDouble(arrayss[17]);
		gp.fRotateAngle=Double.parseDouble(arrayss[18]);
		gp.fRotateScale=Double.parseDouble(arrayss[19]);*/
		return gp;
	}
	public static void WGS84BLH_XYZ(double x0,double y0,double z0,GpsConvertParamClass gcpc, GpsParam strgpsparam){
		double n;
		double e=0.00669437999013;
		n=6378137/Math.sqrt(1.0-e*Math.sin(x0)*Math.sin(x0));
		gcpc.gx=(n+z0)*Math.cos(x0)*Math.cos(y0);
		gcpc.gy=(n+z0)*Math.cos(x0)*Math.sin(y0);
		gcpc.gz=(n*(1.0-e)+z0)*Math.sin(x0); 
	}
	public static void XYZ_BEJ54XYZ(double x0,double y0,double z0,GpsConvertParamClass gcpc,GpsParam strgpsparam){
		double gps_cs_rx=0.0000048481368*strgpsparam.GPS_CS_Rx;
		double gps_cs_ry=0.0000048481368*strgpsparam.GPS_CS_Ry;
		double gps_cs_rz=0.0000048481368*strgpsparam.GPS_CS_Rz;

		gcpc.x54=strgpsparam.GPS_CS_Tx+strgpsparam.GPS_CS_S*x0-gps_cs_rz*y0+gps_cs_ry*z0;
		gcpc.y54=strgpsparam.GPS_CS_Ty+strgpsparam.GPS_CS_S*y0+gps_cs_rz*x0-gps_cs_rx*z0;
		gcpc.z54=strgpsparam.GPS_CS_Tz+strgpsparam.GPS_CS_S*z0-gps_cs_ry*x0+gps_cs_rx*y0;
	}
	public static void BEJ54XYZ_BEJ54BLH(double x0,double y0,double z0,GpsConvertParamClass gcpc,GpsParam strgpsparam){
		double B0,R,N=0;

		double b=strgpsparam.GPS_CS_a-1.0/strgpsparam.GPS_CS_f*strgpsparam.GPS_CS_a;
		double a=strgpsparam.GPS_CS_a;

		double e=(a*a-b*b)/(a*a);
		double GPS_CS_a54=strgpsparam.GPS_CS_a;
		R=Math.sqrt(x0*x0+y0*y0);
		B0=Math.atan2(z0,R);
		long tick1=SystemClock.elapsedRealtime();
		while(SystemClock.elapsedRealtime()-tick1<1000){
			N=GPS_CS_a54/Math.sqrt(1.0-e*Math.sin(B0)*Math.sin(B0));
			gcpc.b=Math.atan2(z0+N*e*Math.sin(B0),R);
			if(Math.abs(gcpc.b-B0)<1.0e-10)
				break;
			B0=gcpc.b;
		}
		gcpc.l=Math.atan2(y0,x0);
		gcpc.h=R/Math.cos(gcpc.b)-N;
	}
	public static void BEJ545BLH_GAOSXYZ(double B,double L,double H1,GpsConvertParamClass gcpc,GpsParam strgpsparam){
		double a1,a2,a3,a4;
		double aa,bb,cc,dd;
		double x2,x4,x6,x8,x10;
		double r0,r1,r2,r3;
		double M0,M2;
		double X0;
		double N,Tb;
		//double b11[5],r11[5],d11[5];

		
		double Y2;
		
		double GPS_CS_a54=strgpsparam.GPS_CS_a;
		double a=strgpsparam.GPS_CS_a;
		//double GPS_CS_ZYZWX=123*3.1415926535898/180;
		double gps_cs_zyzwx=strgpsparam.GPS_CS_ZYZWX*3.1415926535898/180;
		double b=strgpsparam.GPS_CS_a-1.0/strgpsparam.GPS_CS_f*strgpsparam.GPS_CS_a;
		//double e=strgpsparam.GPS_CS_f;
		double e=(a*a-b*b)/(a*a);
		//double e=strgpsparam.GPS_CS_f;
		x2=e;
		x4=x2*x2;
		x6=x4*x2;
		x8=x4*x4;
		x10=x2*x8;
		
		aa=1.0+3.0*x2/4.0+45*x4/64.0+175*x6/256.0;   
		aa=aa+11025*x8/16384.0+43659*x10/65536.0;     //A
		bb=3.0*x2/4.0+15*x4/16.0+525*x6/512.0;       
		bb=bb+2205*x8/2048.0+72765*x10/65536.0;       //B
		cc=15.0*x4/64.0+105*x6/256.0;
		cc=cc+2205*x8/4096.0+10395*x10/16384.0;       //C
		dd=35*x6/512.0+315*x8/2048.0+31185*x10/13072.0;   //D
		
		a1=aa*strgpsparam.GPS_CS_a*(1-e);
		a2=-bb*strgpsparam.GPS_CS_a*(1-e)/2.0;
		a3=cc*strgpsparam.GPS_CS_a*(1-e)/4.0;
		a4=-dd*strgpsparam.GPS_CS_a*(1-e)/6.0;
		
		r0=a1;
		r1=2*a2+4*a3+6*a4;
		r2=-8*a3-32*a4;
		r3=32*a4;
		
		Tb=Math.tan(B);
		Y2=x2*Math.cos(B)*Math.cos(B)/(1.0-x2);
		N=GPS_CS_a54/Math.sqrt(1-e*Math.sin(B)*Math.sin(B));
		M0=Math.cos(B)*(L-gps_cs_zyzwx);
		M2=M0*M0;
		X0=r0*B+Math.cos(B)*Math.sin(B)*(r1+Math.sin(B)*Math.sin(B)*(r2+Math.sin(B)*Math.sin(B)*r3));
		
		gcpc.xx=(X0+M2*N*Tb/2.0+M2*M2*N*Tb/24*(5.0-Tb*Tb+9.0*Y2+4.0*Y2*Y2)+
		M2*M2*M2*N*Tb/720.0*(61.0+(Tb*Tb-58)*Tb*Tb))*strgpsparam.GPS_UTM_Scale + strgpsparam.GPS_CS_DeltaX;
		gcpc.yy=strgpsparam.GPS_CS_DeltaY+(N*M0+N*M0*M2/6*(1.0+Y2-Tb*Tb)+
		N*M2*M2*M2/120*(5.0+(Tb*Tb-18)*Tb*Tb-(58*Tb*Tb-14)*Y2))*strgpsparam.GPS_UTM_Scale;
		gcpc.zz=strgpsparam.GPS_CS_DeltaZ+H1;    
		
		double LocalX,LocalY;
		if(strgpsparam.bLocalChange){
			LocalX = strgpsparam.fRotateCenterX + strgpsparam.fRotateScale*(gcpc.xx*Math.cos(strgpsparam.fRotateAngle*3.1415926535898/180) + gcpc.yy*Math.sin(strgpsparam.fRotateAngle*3.1415926535898/180));
			LocalY=strgpsparam.fRotateCenterY + strgpsparam.fRotateScale*(gcpc.yy*Math.cos(strgpsparam.fRotateAngle*3.1415926535898/180) - gcpc.xx*Math.sin(strgpsparam.fRotateAngle*3.1415926535898/180));
			gcpc.xx = LocalX;
			gcpc.yy = LocalY;
		}
	}
	
}
