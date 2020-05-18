package jiaoxi.crazyit.classes.dig;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;

public class Str_ColorPolyline implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2472151161381871620L;

	public int PenStyle;
	public int Width;
	public int color;
	public List<Double> x;
	public List<Double> y;
	public int LX;		//类型
	public boolean Selected;
	
	public Str_ColorPolyline(){
		x=new ArrayList<Double>();
		y=new ArrayList<Double>();
	}
}
