package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

////���ưڿ�
public class GroupRunOut {

	static final int Valve_NUM = 2; // final��ʾ��һ������	
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
