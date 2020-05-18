package jiaoxi.crazyit.classes.dig;

import java.io.Serializable;

import android.graphics.Color;

public class Str_ColorLine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3761529571775895850L;

	public int PenStyle;		//线形名
	public int Width;		//宽度
	public int color;		//颜色
	public double BeginPoint_x;
	public double BeginPoint_y;
	public double EndPoint_x;
	public double EndPoint_y;
	public boolean Selected;
}
