package jiaoxi.crazyit.classes;

import java.io.Serializable;

public  class Str_Trochoid_Real implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1231498281008341822L;
	public  int trochoidLenReal=0;	///////轨迹点数量
	public int trochoidRealIndex=-1;///////轨迹点起始位置
	public Str_Ship_Point[] strTrochoidReals;
	public Str_Trochoid_Real(){
		strTrochoidReals=new Str_Ship_Point[10000];/////画轨迹线用
	}
}
