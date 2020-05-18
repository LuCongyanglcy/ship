package jiaoxi.crazyit.classes.dig;

import java.io.Serializable;

import android.graphics.Color;

public class Str_BigText implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1028575978194104289L;

	public double Point_x;
	public double Point_y;
	public int Width;
	public int color;
	public float Angle;			//旋转角度
	public int Style;			//0:不变字体 1：可调字体
	public String Text;
	public boolean Selected;
	public int FontSize;		//字体大小
	public String FontName;	//字体
}
