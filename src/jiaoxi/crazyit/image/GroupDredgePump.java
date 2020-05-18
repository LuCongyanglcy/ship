package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupDredgePump {
	static final int Valve_NUM = 3; // final表示是一个常量	
	static final Graph_DredgePump[] dredgepump = new Graph_DredgePump[Valve_NUM];
	
	public static void InitValve()		///初始化
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			dredgepump[i] = new Graph_DredgePump();
		}			

	}
	public static void FillValveData(Caculate cacuData)
	   {
		int a;
		// 泥泵1
		a = (cacuData.digitData[8] >> 1) & 0x01; // 打开状态
		if (a == 1)
			dredgepump[0].run_status = true;
		else if (a == -1)
			dredgepump[0].run_status = true;
		else
			dredgepump[0].run_status = false;
	}
}
