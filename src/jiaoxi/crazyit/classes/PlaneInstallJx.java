package jiaoxi.crazyit.classes;

import java.io.Serializable;

import jiaoxi.crazyit.classes.UISet.DrawShip;

public class PlaneInstallJx implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -109349549819464043L;
	public PO_XY gps1;
	public PO_XY gps2;

	public PO_XY Trunnion;				//耳轴
	public PO_XY Winch_Left;			//横移绞车位置-----
	public PO_XY Winch_Right;
	public PO_XY MainStackPivot;		//主桩支点
	public PO_XY AssitantStack;		//辅桩
	public PO_XY[] ShipPlane;
	public int  ShipAngleFrom;
	public int SeekType;				///船舶类型---0：定位桩台车，1：三缆定位 2：双钢桩
	public boolean MainStackCorrect;		/////定位桩信号正常
	
	public PlaneInstallJx() {
		// TODO 自动生成的构造函数存根
		gps1=new PO_XY();
		gps2=new PO_XY();
		Trunnion=new PO_XY();
		Winch_Left=new PO_XY();
		Winch_Right=new PO_XY();
		MainStackPivot=new PO_XY();
		AssitantStack=new PO_XY();
		ShipPlane=new PO_XY[12];
		for(int i = 0; i< DrawShip.shipArrSize(); i++){
			ShipPlane[i]=new PO_XY();
		}
	}
}
