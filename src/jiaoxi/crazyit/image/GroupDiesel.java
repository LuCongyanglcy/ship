package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupDiesel {
	public static final Graph_Diesel[] diesel = new Graph_Diesel[2];

	public static void InitValve() // /初始化阀的位置信息
	{
		for (int i = 0; i < 2; i++) {
			diesel[i] = new Graph_Diesel();
		}

	}

	public static void FillValveData(Caculate cacuData) {
		
		int a;

		a = (cacuData.digitData[35] >> 1) & 0x01; // 运行状态 泥泵
		if (a == 1)
			diesel[0].runing = true;
		else if (a == -1)
			diesel[0].runing = true;
		else
			diesel[0].runing = false;
		
		a = (cacuData.digitData[33] >> 5) & 0x01; // 运行状态 液压
		if (a == 1)
			diesel[1].runing = true;
		else if (a == -1)
			diesel[1].runing = true;
		else
			diesel[1].runing = false;
	}
}
