package jiaoxi.crazyit.classes.xyz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Str_Xyz implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9007350673803302589L;
	
	public double maxX;
	public double maxY;
	public float maxZ;
	public double minX;
	public double minY;
	public float minZ;
	public List<Double> x;
	public List<Double> y;
	public List<Float> z;
	public Str_Xyz(){
		x=new ArrayList<Double>();
		y=new ArrayList<Double>();
		z=new ArrayList<Float>();
	}
}
