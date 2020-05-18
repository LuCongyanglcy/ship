package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GoupShowButtons {
	static final int Valve_NUM = 100; // final表示是一个常量	
	static final Graph_ShowButton[] Showbutton = new Graph_ShowButton[Valve_NUM];
	
	public static void InitValve()		///初始化阀的位置信息 
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			Showbutton[i] = new Graph_ShowButton();
		}			

	}
	public static void FillValveData(Caculate cacuData)
	   {
		int a;
		// 1号按钮
		a = (cacuData.digitData[12] >> 0) & 0x01; // 运行状态
		if (a == 1)
			Showbutton[0].status = true;
		else if (a == -1)
			Showbutton[0].status = true;
		else
			Showbutton[0].status = false;

		// 2号按钮
		a = (cacuData.digitData[12] >> 0) & 0x01; // 打开状态
		if (a == 1)
			Showbutton[1].status = true;
		else if (a == -1)
			Showbutton[1].status = true;
		else
			Showbutton[1].status = false;

	}
}
