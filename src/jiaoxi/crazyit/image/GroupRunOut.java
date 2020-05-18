package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

////横移摆宽
public class GroupRunOut {

	static final int Valve_NUM = 2; // final表示是一个常量	
	public static final Graph_RunOut[] runout = new Graph_RunOut[Valve_NUM];
	
	public static void InitValve()		
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			runout[i] = new Graph_RunOut();
		}			

	}
	public static void FillValveData(Caculate cacuData)
	{
//		for(int i=0;i<Valve_NUM;i++)
//		{
//			runout[i].staff = cacuData.anlogData[100 + i];
//		}
		runout[0].staff = cacuData.anlogData[631];
	}
}
