package jiaoxi.crazyit.image;

import android.os.SystemClock;

public class GpsConvertClass {
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
		int i;
		double XX,YY,ZZ;
		double a1,a2,a3,a4,a5,a6;
		double aa,bb,cc,dd,ee,ff;
		double A,C,x2,x4,x6,x8,x10;
		double r0,r1,r2,r3;
		double K1,K2,K3;
		double M0,M2;
		double X0;
		double N,Tb;
		//double b11[5],r11[5],d11[5];
		double []b11=new double[5];
		double []r11=new double[5];
		double [] d11=new double[5];
		
		double Nf,Bf,Tf,Y2,Vf2,Mb,Ml;
		
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
		
		double LocalX,LocalY,LocalZ;
		if(strgpsparam.bLocalChange){
			LocalX = strgpsparam.fRotateCenterX + strgpsparam.fRotateScale*(gcpc.xx*Math.cos(strgpsparam.fRotateAngle*3.1415926535898/180) + gcpc.yy*Math.sin(strgpsparam.fRotateAngle*3.1415926535898/180));
			LocalY=strgpsparam.fRotateCenterY + strgpsparam.fRotateScale*(gcpc.yy*Math.cos(strgpsparam.fRotateAngle*3.1415926535898/180) - gcpc.xx*Math.sin(strgpsparam.fRotateAngle*3.1415926535898/180));
			gcpc.xx = LocalX;
			gcpc.yy = LocalY;
		}
	}
	
}
