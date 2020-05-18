package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupRuler {

	static final int Valve_NUM = 30; // final表示是一个常量	
	static final Graph_Ruler[] ruler = new Graph_Ruler[Valve_NUM];
	
	public static void InitValve()		///初始化阀的位置信息 
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			ruler[i] = new Graph_Ruler();
		}			

	}
	public static void FillValveData(Caculate cacuData){
		//////////////////////page001
		ruler[0].staff = cacuData.anlogData[100 + 23];//斗轮油压
		ruler[1].staff = cacuData.anlogData[100 + 24];//横移油压
		ruler[2].staff = cacuData.anlogData[100 + 25];//其他油压
		ruler[3].staff = cacuData.anlogData[100 + 30];//台车行程
		
		//////////////////////page003
		ruler[4].staff = cacuData.anlogData[100 + 42];//耳轴吃水
		
		//////////////////////page004
		ruler[5].staff = cacuData.anlogData[100 + 17];//1
		ruler[6].staff = cacuData.anlogData[100 + 16];//2
		ruler[7].staff = cacuData.anlogData[100 + 10];//3
		ruler[8].staff = cacuData.anlogData[100 + 11];//4
		ruler[9].staff = cacuData.anlogData[100 + 13];//5
		ruler[10].staff = cacuData.anlogData[100 + 18];//6
		ruler[11].staff = cacuData.anlogData[100 + 8];//7
		ruler[12].staff = cacuData.anlogData[100 + 9];//8
		ruler[13].staff = cacuData.anlogData[100 + 12];//9
		ruler[14].staff = cacuData.anlogData[100 + 14];//10
		ruler[15].staff = cacuData.anlogData[100 + 15];//11
		ruler[16].staff = cacuData.anlogData[100 + 20];//12
		ruler[17].staff = cacuData.anlogData[100 + 19];//13
		
		int a=0;
		a = (cacuData.digitData[36] >> 7) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[6].alert = true;
		else if (a == -1)
			ruler[6].alert = true;
		else
			ruler[6].alert = false;	
		
		a = (cacuData.digitData[36] >> 1) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[7].alert = true;
		else if (a == -1)
			ruler[7].alert = true;
		else
			ruler[7].alert = false;	
		
		a = (cacuData.digitData[36] >> 2) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[8].alert = true;
		else if (a == -1)
			ruler[8].alert = true;
		else
			ruler[8].alert = false;	
		
		a = (cacuData.digitData[36] >> 4) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[9].alert = true;
		else if (a == -1)
			ruler[9].alert = true;
		else
			ruler[9].alert = false;	
		
		a = (cacuData.digitData[37] >> 0) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[10].alert = true;
		else if (a == -1)
			ruler[10].alert = true;
		else
			ruler[10].alert = false;	
		
		a = (cacuData.digitData[36] >> 0) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[12].alert = true;
		else if (a == -1)
			ruler[12].alert = true;
		else
			ruler[12].alert = false;	
		
		a = (cacuData.digitData[36] >> 3) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[13].alert = true;
		else if (a == -1)
			ruler[13].alert = true;
		else
			ruler[13].alert = false;	
		
		a = (cacuData.digitData[36] >> 5) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[14].alert = true;
		else if (a == -1)
			ruler[14].alert = true;
		else
			ruler[14].alert = false;	
		
		a = (cacuData.digitData[36] >> 6) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[15].alert = true;
		else if (a == -1)
			ruler[15].alert = true;
		else
			ruler[15].alert = false;	
		
		a = (cacuData.digitData[37] >> 2) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[16].alert = true;
		else if (a == -1)
			ruler[16].alert = true;
		else
			ruler[16].alert = false;	
		
		a = (cacuData.digitData[37] >> 1) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[17].alert = true;
		else if (a == -1)
			ruler[17].alert = true;
		else
			ruler[17].alert = false;	
		
		//////////////////////page005
		ruler[18].staff = cacuData.anlogData[100 + 3];//1
		ruler[19].staff = cacuData.anlogData[100 + 2];//2
		ruler[20].staff = cacuData.anlogData[100 + 0];//3
		ruler[21].staff = cacuData.anlogData[100 + 4];//4
		ruler[22].staff = cacuData.anlogData[100 + 7];//5
		ruler[23].staff = cacuData.anlogData[100 + 1];//6
		ruler[24].staff = cacuData.anlogData[100 + 5];//7
		ruler[25].staff = cacuData.anlogData[100 + 6];//8
		

		
		a = (cacuData.digitData[37] >> 5) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[19].alert = true;
		else if (a == -1)
			ruler[19].alert = true;
		else
			ruler[19].alert = false;
		
		a = (cacuData.digitData[37] >> 3) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[20].alert = true;
		else if (a == -1)
			ruler[20].alert = true;
		else
			ruler[20].alert = false;
		
		a = (cacuData.digitData[37] >>6) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[21].alert = true;
		else if (a == -1)
			ruler[21].alert = true;
		else
			ruler[21].alert = false;
		
		a = (cacuData.digitData[38] >>1) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[22].alert = true;
		else if (a == -1)
			ruler[22].alert = true;
		else
			ruler[22].alert = false;
		
		a = (cacuData.digitData[37] >> 4) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[23].alert = true;
		else if (a == -1)
			ruler[23].alert = true;
		else
			ruler[23].alert = false;
		
		a = (cacuData.digitData[37] >> 7) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[24].alert = true;
		else if (a == -1)
			ruler[24].alert = true;
		else
			ruler[24].alert = false;
		
		a = (cacuData.digitData[38] >> 0) & 0x01; // 运行指示状态
		if (a == 1)
			ruler[25].alert = true;
		else if (a == -1)
			ruler[25].alert = true;
		else
			ruler[25].alert = false;
		
		
	}
}
