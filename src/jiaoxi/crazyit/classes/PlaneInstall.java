package jiaoxi.crazyit.classes;

import java.io.Serializable;

public class PlaneInstall implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3757995902530287458L;
	public PO_XY gps1;/////gps1安装位置
	public PO_XY gps2;////gps2安装位置
	public PO_XY leftSuction;////左吸口位置
	public PO_XY rightSuction;////右吸口位置
	
	public PO_XY[] shipPlane;	///船舶形状
	public PO_XY[] navigatorRoom;////驾驶室
	public PO_XY[] bigDoor;/////泥舱
	public int shipAngleFrom;	////角度来源
	public PO_XY dischargePort;////艏吹口
	public float dischargeRadum;////艏吹口半径
	public int gpsSpeedUnit;
	public int iCurrentLocationGps;////使用哪个gps定位
	public boolean bUseGps2BackGps1;////当gps1没数据时,使用gps2数据当gps1数据的备用
	public boolean bShowZX;////航向线
	
	public PlaneInstall() {
		// TODO 自动生成的构造函数存根
		gps1=new PO_XY();
		gps2=new PO_XY();
		leftSuction=new PO_XY();
		rightSuction=new PO_XY();
		
		shipPlane=new PO_XY[7];
		for(int i=0;i<7;i++){
			shipPlane[i]=new PO_XY();
		}
		
		navigatorRoom=new PO_XY[4];
		for(int i=0;i<4;i++){
			navigatorRoom[i]=new PO_XY();
		}
		
		bigDoor=new PO_XY[4];
		for(int i=0;i<4;i++){
			bigDoor[i]=new PO_XY();
		}
		
		dischargePort=new PO_XY();
	}
}
