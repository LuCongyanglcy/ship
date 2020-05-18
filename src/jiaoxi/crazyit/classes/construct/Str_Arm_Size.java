package jiaoxi.crazyit.classes.construct;

import java.io.Serializable;

public class Str_Arm_Size implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8776766556858064330L;

	public float BridgeLength;		//桥架长度
	public float CutterRadum;		//绞刀半径或斗轮半径
	public float CutterLength;		//绞刀长度或斗轮宽度
	public float CutterHeadAngle;	//桥架与绞刀头夹角，为斗轮时，应等于0
	public float PipeRadum;		//管路半径，显示半径
	public float TrunnionZ;	//耳轴吃水高度
	public float VelocityRadum;	///流量计管径
	//public boolean  HeadAngleFrom;	//绞刀头角度来源 0：不可调绞刀 1：可调绞刀
	public byte CutterStyle;		///绞刀或斗轮  为0：绞刀 1：斗轮
}
