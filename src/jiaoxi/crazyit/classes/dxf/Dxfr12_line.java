package jiaoxi.crazyit.classes.dxf;

import java.io.Serializable;

public class Dxfr12_line implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4130810362515703160L;
	public int penStyle;	////线形
	public int width;	///宽度
	public int color;	////颜色
	public double beginPoint_x;
	public double beginPoint_y;
	public double endPoint_x;
	public double endPoint_y;
}
