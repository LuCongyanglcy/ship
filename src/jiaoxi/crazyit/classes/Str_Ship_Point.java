package jiaoxi.crazyit.classes;

import java.io.Serializable;
import java.util.Date;

////////计算数据
public class Str_Ship_Point implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4162957570602918843L;
	public double[] GPSPoint;				//GPS点-----实际GPS点
	public double[] VirtualGPSPoint;		//虚拟的GPS点
	public double[] GPS2Point;	//GPS2点 只是显示用
	public double[] P1;	//
	public double[] P2;	//
	public double[] P3;	//
	public double[] P4;	//
	public double[] P5;	//
	public double[] P6;	//

	public PO_XY[] ShipPlane;	//船舶平面点
	public float[] MainStackPivot;	//主桩支点
	public float[] MainStack;			//主桩
	public float[] AssitantStack;		//辅桩

	public float[] AnchorRodPivot_Left;		///左横移锚支点
	public float[] AnchorRodPivot_Right;		///右横移锚支点
	//////////////////// 各个锚的位置
	public float[] AnchorLeftMove;		////左锚位置------实时位置,可以使用GPS定位
	public float[] AnchorRightMove;		////右锚位置------实时位置,可以使用GPS定位
	public float[] AnchorLeftTail;		////左尾锚
	public float[] AnchorCenterTail;		////中艉锚
	public float[] AnchorRightTail;		////右艉锚



	public Date Time;		//当前时间
	
	public Str_Ship_Point(){
		GPSPoint=new double[3];				//GPS点-----实际GPS点
		VirtualGPSPoint=new double[3];		//虚拟的GPS点
		GPS2Point=new double[3];	//GPS2点 只是显示用
		P1=new double[3];	//
		P2=new double[3];	//
		P3=new double[3];	//
		P4=new double[3];	//
		P5=new double[3];	//
		P6=new double[3];	//

		ShipPlane=new PO_XY[12];	//船舶平面点
		for(int i=0;i<12;i++){
			ShipPlane[i]=new PO_XY();
		}
		MainStackPivot=new float[2];	//主桩支点
		MainStack=new float[2];			//主桩
		AssitantStack=new float[2];		//辅桩

		AnchorRodPivot_Left=new float[2];		///左横移锚支点
		AnchorRodPivot_Right=new float[2];		///右横移锚支点
		//////////////////// 各个锚的位置
		AnchorLeftMove=new float[2];		////左锚位置------实时位置,可以使用GPS定位
		AnchorRightMove=new float[2];		////右锚位置------实时位置,可以使用GPS定位
		AnchorLeftTail=new float[2];		////左尾锚
		AnchorCenterTail=new float[2];		////中艉锚
		AnchorRightTail=new float[2];		////右艉锚
	}
}
