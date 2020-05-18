package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GoupButtons {
	static final int Valve_NUM = 100; // final表示是一个常量	
	static final Graph_Button[] button = new Graph_Button[Valve_NUM];
	
	public static void InitValve()		///初始化阀的位置信息 
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			button[i] = new Graph_Button();
		}			

	}
	public static void FillValveData(Caculate cacuData,boolean status)
	   {
		for(int i=0;i<Valve_NUM;i++)
		{
			button[i].blinkStatus = status;
		}
		int a;
		// 按钮1
		a = (cacuData.digitData[12] >> 0) & 0x01; // 正在执行状态
		if (a == 1)
			button[0].blink = true;
		else if (a == -1)
			button[0].blink = true;
		else
			button[0].blink = false;
		
		a = (cacuData.digitData[12] >> 0) & 0x01; // 条件不满足状态
		if (a == 1)
			button[0].bDown = true;
		else if (a == -1)
			button[0].bDown = true;
		else
			button[0].bDown = false;

	
	}
}
