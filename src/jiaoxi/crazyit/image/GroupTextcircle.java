package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupTextcircle {
	static final int Valve_NUM = 10; // final表示是一个常量	
	public static final Graph_Textcircle[] Textcircle = new Graph_Textcircle[Valve_NUM];
	
	public static void InitValve()		///初始化阀的位置信息 
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			Textcircle[i] = new Graph_Textcircle();
		}			

	}
	public static void FillValveData(Caculate cacuData)
	{
		int a =0;
		a = ((cacuData.digitData[148] >> 4) & 0x01); // 绞刀电机
		if (a == 1)
			Textcircle[0].ifcolor = true;
		else if (a == -1)
			Textcircle[0].ifcolor = true;
		else
			Textcircle[0].ifcolor = false;
		
		a = ((cacuData.digitData[150] >> 0) & 0x01); // 水下泵电机
		if (a == 1)
			Textcircle[1].ifcolor = true;
		else if (a == -1)
			Textcircle[1].ifcolor = true;
		else
			Textcircle[1].ifcolor = false;
		
		a = ((cacuData.digitData[128] >> 2) & 0x01); // 左横移电机
		if (a == 1)
			Textcircle[2].ifcolor = true;
		else if (a == -1)
			Textcircle[2].ifcolor = true;
		else
			Textcircle[2].ifcolor = false;
		
		
		a = ((cacuData.digitData[128] >> 6) & 0x01); // 右横移电机
		if (a == 1)
			Textcircle[3].ifcolor = true;
		else if (a == -1)
			Textcircle[3].ifcolor = true;
		else
			Textcircle[3].ifcolor = false;
		
		a = ((cacuData.digitData[129] >> 2) & 0x01); // 左桥架电机
		if (a == 1)
			Textcircle[4].ifcolor = true;
		else if (a == -1)
			Textcircle[4].ifcolor = true;
		else
			Textcircle[4].ifcolor = false;
		
		
		a = ((cacuData.digitData[129] >> 6) & 0x01); // 右桥架电机
		if (a == 1)
			Textcircle[5].ifcolor = true;
		else if (a == -1)
			Textcircle[5].ifcolor = true;
		else
			Textcircle[5].ifcolor = false;
		
		a = ((cacuData.digitData[130] >> 2) & 0x01); // 左起锚电机
		if (a == 1)
			Textcircle[6].ifcolor = true;
		else if (a == -1)
			Textcircle[6].ifcolor = true;
		else
			Textcircle[6].ifcolor = false;
		
		
		a = ((cacuData.digitData[131] >> 2) & 0x01); // 左抛锚电机
		if (a == 1)
			Textcircle[7].ifcolor = true;
		else if (a == -1)
			Textcircle[7].ifcolor = true;
		else
			Textcircle[7].ifcolor = false;
		
		a = ((cacuData.digitData[130] >> 6) & 0x01); // 右起锚电机
		if (a == 1)
			Textcircle[8].ifcolor = true;
		else if (a == -1)
			Textcircle[8].ifcolor = true;
		else
			Textcircle[8].ifcolor = false;
		
		
		a = ((cacuData.digitData[131] >> 6) & 0x01); // 右抛锚电机
		if (a == 1)
			Textcircle[9].ifcolor = true;
		else if (a == -1)
			Textcircle[9].ifcolor = true;
		else
			Textcircle[9].ifcolor = false;
	
	}
	
}


