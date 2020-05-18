package jiaoxi.crazyit.classes.dxf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dxf_r12 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4321303577875253652L;
	public List<Dxfr12_point> strPoint;
	public List<Dxfr12_line> strLine;
	public List<Dxfr12_circle> strCircle;
	public List<Dxfr12_arc> strArc;
	public List<Dxfr12_polyline> strPolyline;
	public List<Dxfr12_solid> strSolid;
	public List<Dxfr12_text> strText;
	
	public double extMin_x;
	public double extMin_y;
	public double extMax_x;
	public double extMax_y;
	public double limMin_x;
	public double limMin_y;
	public double limMax_x;
	public double limMax_y;
	
	public int backMode;
	
	public Dxf_r12() {
		// TODO 自动生成的构造函数存根
		strPoint=new ArrayList<Dxfr12_point>();
		strLine=new ArrayList<Dxfr12_line>();
		strCircle=new ArrayList<Dxfr12_circle>();
		strArc=new ArrayList<Dxfr12_arc>();
		strPolyline=new ArrayList<Dxfr12_polyline>();
		strSolid=new ArrayList<Dxfr12_solid>();
		strText=new ArrayList<Dxfr12_text>();
		backMode=0;
	}
}
