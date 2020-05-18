package jiaoxi.crazyit.image;

public class GpsParam {
	public double GPS_CS_a;
	public double GPS_CS_f;
	public double GPS_CS_a84;
	public double GPS_CS_f84;
	public double GPS_CS_a54; 
	public double GPS_CS_f54;
	public double GPS_CS_ZYZWX;  //中中央子午线

	public double GPS_CS_Tx;
	public double GPS_CS_Ty;
	public double GPS_CS_Tz;
	public double GPS_CS_S;
	public double GPS_CS_Rx;
	public double GPS_CS_Ry;
	public double GPS_CS_Rz;

	public double GPS_CS_DeltaX;
	public double GPS_CS_DeltaY;
	public double GPS_CS_DeltaZ;

	public double GPS_UTM_Scale;		//UTM投影比

	public int GPS_CS_Mode;

		///////////////// 在系统中，有的当地坐标是经过一个小角度旋转的
	public boolean  bLocalChange;		///是否采用当地坐标
	public double fRotateCenterX;	///旋转中心X
	public double fRotateCenterY;	///旋转中心Y
	public double fRotateAngle;		///旋转角度
	public double fRotateScale;		///旋转缩放
}
