package jiaoxi.crazyit.classes.xyz;

import java.io.Serializable;

public class Str_Colors implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6575475975083271477L;
	public int[] colors;
	public float[] deeps;
	public boolean[] enables;
	public boolean colorModel;
	public Str_Colors(){
		colors=new int[20];
		deeps=new float[20];
		enables=new boolean[20];
	}
}
