package jiaoxi.crazyit.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Str_TraceLine implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3655872964175508490L;
	public List<Str_Line> strLines;
	public int currentTraceLine;
	public int currentSectionLine;
	public Str_TraceLine(){
		strLines=new ArrayList<Str_Line>();
		
	}
}
