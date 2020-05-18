package jiaoxi.crazyit.classes.dxf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dxfr12_polyline implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 133119111623038018L;
	public int penStyle;
	public int width;
	public int color;
	public List<Double> point_x;
	public List<Double> point_y;
	public int lx;///类型?
	
	public Dxfr12_polyline() {
		// TODO 自动生成的构造函数存根
		point_x=new ArrayList<Double>();
		point_y=new ArrayList<Double>();
	}
}
