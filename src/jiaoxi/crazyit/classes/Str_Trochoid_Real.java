package jiaoxi.crazyit.classes;

import java.io.Serializable;

public  class Str_Trochoid_Real implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1231498281008341822L;
	public  int trochoidLenReal=0;	///////�켣������
	public int trochoidRealIndex=-1;///////�켣����ʼλ��
	public Str_Ship_Point[] strTrochoidReals;
	public Str_Trochoid_Real(){
		strTrochoidReals=new Str_Ship_Point[10000];/////���켣����
	}
}
