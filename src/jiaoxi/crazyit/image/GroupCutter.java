package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupCutter {
//	static final int Valve_NUM = 2; // final表示是一个常量	
//	static final Graph_Cutter cutter = new Graph_Cutter[];
	static final Graph_Cutter cutter = new Graph_Cutter();
	public static void InitValve()		///初始化阀的位置信息 
	{
	//	for(int i=0;i<Valve_NUM;i++)
//		{
	  	Graph_Cutter cutter = new Graph_Cutter();
//		}			

	}
	public static void FillValveData(Caculate cacuDat)
	   {		
//		cutter.cutterDeep = cacuDat.anlogData[116];
		cutter.cutterDeep = 25;
	}
}
