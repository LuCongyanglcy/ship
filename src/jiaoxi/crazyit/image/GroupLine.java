package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupLine {
	static final int Valve_NUM = 100; // final表示是一个常量	
	static final Graph_Line[] line = new Graph_Line[Valve_NUM];
	
	public static void InitValve()		///初始化
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			line[i] = new Graph_Line();
		}			

	}
	public static void FillValveData(Caculate cacuData)
	   {
		int a;
		// 线1
		a = (Math.abs(cacuData.digitData[8] >> 1) & 0x01); // 信号状态1
		if (a == 1) {
			line[0].state1 = true;
		}
		else {
			line[0].state1 = false;	
		}

		if(cacuData.anlogData[100 + 26] >= 0.5) {//连封水泵
			line[1].state1 = true;
		}
		else {
			line[1].state1 = false;	
		}
		
		a = (Math.abs(cacuData.digitData[5] >> 1) & 0x01); // 闸阀打开后绿
		if (a == 1) {
			line[2].state1 = true;
		}
		else {
			line[2].state1 = false;	
		}
		
		a = (Math.abs(cacuData.digitData[35] >> 1) & 0x01); // 离合器连柴油机  要改 主机运行时绿(泥泵柴油机)
		if (a == 1) {
			line[3].state1 = true;
		}
		else {
			line[3].state1 = false;	
		}
	}
}

