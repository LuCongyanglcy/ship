package jiaoxi.crazyit.classes.dig;

import java.io.Serializable;

import android.graphics.Color;

public class Str_Dykeline implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5165480126280973565L;

	public int PenStyle;		//线形名
	public int Width;		//宽度
	public int color;		//颜色
	public double BeginPoint_x;
	public double BeginPoint_y;
	public double EndPoint_x;
	public double EndPoint_y;
	public boolean Selected;
	
	/*public Str_Dykeline(){
		color=new Color();
	}*/
}
