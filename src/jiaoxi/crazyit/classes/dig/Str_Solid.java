package jiaoxi.crazyit.classes.dig;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;

public class Str_Solid implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5286196732619337142L;

	public List<Double> x;
	public List<Double> y;
	public int PenStyle;
	public int FillColor;
	public int LineColor;
	public int FillMode;		//0:与背景反色 1：填充
	public boolean Selected;
	
	public Str_Solid(){
		x=new ArrayList<Double>();
		y=new ArrayList<Double>();
	}
}
