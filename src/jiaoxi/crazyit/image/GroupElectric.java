package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupElectric {
	static final int Valve_NUM = 2; // final表示是一个常量	
	static final Graph_Electric[] electric = new Graph_Electric[Valve_NUM];
	
	public static void InitValve()		///初始化阀的位置信息 
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			electric[i] = new Graph_Electric();
		}			

	}
	public static void FillValveData(Caculate cacuData)
	   {
		int a;
		// G
		a = (cacuData.digitData[226] >> 7) & 0x01; // 打开状态
		if (a == 1)
			electric[0].ifcolor = true;
		else if (a == -1)
			electric[0].ifcolor = true;
		else
			electric[0].ifcolor = false;
	}
}