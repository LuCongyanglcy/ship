package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupFlowmeter {

	static final int Valve_NUM = 1; // final表示是一个常量	
	public static final Graph_Flowmeter[] flowmeter = new Graph_Flowmeter[Valve_NUM];
	
	public static void InitValve()		
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			flowmeter[i] = new Graph_Flowmeter();
		}			
	}
	
	public static void FillValveData(Caculate cacuData)
	{
//		for(int i=0;i<Valve_NUM;i++)
//		{
//			flowmeter[i].staff = cacuData.anlogData[100 + i];
//		}
		flowmeter[0].staff = cacuData.anlogData[100+160];
//		flowmeter[0].staff = 30;
	}
}
