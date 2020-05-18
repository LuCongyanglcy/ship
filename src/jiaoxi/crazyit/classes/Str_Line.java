package jiaoxi.crazyit.classes;

import java.io.Serializable;

public class Str_Line implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5123355431050342364L;
	public int GroupNum;		//组号
	public double LineBeginPointX;	//起始点
	public double LineBeginPointY;	//起始点
	public double LineEndPointX;	//终止点
	public double LineEndPointY;	//终止点
	public float DesignDeep;		//挖深
	public String SectionName;		//断面名称
	public double LineAngle;			//线角度
	public double LineLength;			//线长度
}
