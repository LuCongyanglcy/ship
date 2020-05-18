package jiaoxi.crazyit.classes.dig;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;

public class Str_PolyBezier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4163553316316610670L;

	public int PenStyle;
	public int Width;
	public int color;
	public List<Double> x;
	public List<Double> y;
	public boolean Selected;
	
	public Str_PolyBezier(){
		x=new ArrayList<Double>();
		y=new ArrayList<Double>();
		
	}
}
