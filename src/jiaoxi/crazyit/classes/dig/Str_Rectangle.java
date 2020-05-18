package jiaoxi.crazyit.classes.dig;

import java.io.Serializable;

import android.graphics.Color;

public class Str_Rectangle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4196398127290360493L;

	public int PenStyle;
	public int Width;
	public int color;
	public double TopLeftX;
	public double TopLeftY;
	public float RectLen;
	public float RectWidth;
	public float Angle;		////旋转角度
	public boolean Selected;
}
