package jiaoxi.crazyit.image;

public class GpsParam {
	public double GPS_CS_a;
	public double GPS_CS_f;
	public double GPS_CS_a84;
	public double GPS_CS_f84;
	public double GPS_CS_a54; 
	public double GPS_CS_f54;
	public double GPS_CS_ZYZWX;  //������������

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

	public double GPS_UTM_Scale;		//UTMͶӰ��

	public int GPS_CS_Mode;

		///////////////// ��ϵͳ�У��еĵ��������Ǿ���һ��С�Ƕ���ת��
	public boolean  bLocalChange;		///�Ƿ���õ�������
	public double fRotateCenterX;	///��ת����X
	public double fRotateCenterY;	///��ת����Y
	public double fRotateAngle;		///��ת�Ƕ�
	public double fRotateScale;		///��ת����
}
