package jiaoxi.crazyit.classes.dig;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Str_ShoreLine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8051933779845841255L;

	public List<Double> x;
	public List<Double> y;
	public boolean Selected;
	
	public Str_ShoreLine(){
		x=new ArrayList<Double>();
		y=new ArrayList<Double>();
	}

}
