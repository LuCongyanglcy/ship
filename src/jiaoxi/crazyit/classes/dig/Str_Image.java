package jiaoxi.crazyit.classes.dig;

import java.io.Serializable;

import android.graphics.Bitmap;
import android.graphics.Color;

public class Str_Image implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -954185528253822907L;

	public int PenStyle;
	public int Width;
	public  int color;
	public double x;
	public double y;
	public float RectLen;
	public float RectWidth;
	public float Angle;		////旋转角度
	public boolean Selected;
	public String PathName;
	public String FileName;
	public String Label;
	Bitmap image1;
}
