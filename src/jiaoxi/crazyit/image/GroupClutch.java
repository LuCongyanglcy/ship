package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupClutch {

	// static final int Valve_NUM = 2; // final表示是一个常量
	public static final Graph_Clutch[] clutch = new Graph_Clutch[2];

	public static void InitValve() // /初始化阀的位置信息
	{
		for (int i = 0; i < 2; i++) {
			clutch[i] = new Graph_Clutch();
		}

	}

	public static void FillValveData(Caculate cacuData) {
		int a;
		//ps 离合器
//		a = Math.abs((cacuData.digitData[134] >> 5) & 0x01); // 打开状态
//		if (a == 1)
//			clutch[0].running = true;
//		else if (a == -1)
//			clutch[0].running = true;
//		else
//			clutch[0].running = false;
		
		a = Math.abs((cacuData.digitData[8] >> 1) & 0x01); // 打开状态
		if (a == 1)
			clutch[0].running = true;
		else if (a == -1)
			clutch[0].running = true;
		else
			clutch[0].running = false;
	}
}
