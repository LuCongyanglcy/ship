package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupText {
	static final int Valve_NUM = 900; // final表示是一个常量	
	static final Graph_Text[] text = new Graph_Text[Valve_NUM];
	
	public static void InitValve()		///初始化
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			text[i] = new Graph_Text();
		}			

	}
	public static void FillValveData(Caculate cacuData)
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			text[i].sValue = cacuData.anlogData[100 + i];
		}
		int a=0;
		a = (cacuData.digitData[37] >> 3) & 0x01; // 运行指示状态
		if (a == 1)
			text[0].bStatus = true;
		else if (a == -1)
			text[0].bStatus = true;
		else
			text[0].bStatus = false;

		a = (cacuData.digitData[37] >> 4) & 0x01; // 运行指示状态
		if (a == 1)
			text[1].bStatus = true;
		else if (a == -1)
			text[1].bStatus = true;
		else
			text[1].bStatus = false;

		a = (cacuData.digitData[37] >> 5) & 0x01; // 运行指示状态
		if (a == 1)
			text[2].bStatus = true;
		else if (a == -1)
			text[2].bStatus = true;
		else
			text[2].bStatus = false;

		a = (cacuData.digitData[37] >> 6) & 0x01; // 运行指示状态
		if (a == 1)
			text[4].bStatus = true;
		else if (a == -1)
			text[4].bStatus = true;
		else
			text[4].bStatus = false;

		a = (cacuData.digitData[37] >> 7) & 0x01; // 运行指示状态
		if (a == 1)
			text[5].bStatus = true;
		else if (a == -1)
			text[5].bStatus = true;
		else
			text[5].bStatus = false;

		a = (cacuData.digitData[38] >> 0) & 0x01; // 运行指示状态
		if (a == 1)
			text[6].bStatus = true;
		else if (a == -1)
			text[6].bStatus = true;
		else
			text[6].bStatus = false;

		a = (cacuData.digitData[38] >> 1) & 0x01; // 运行指示状态
		if (a == 1)
			text[7].bStatus = true;
		else if (a == -1)
			text[7].bStatus = true;
		else
			text[7].bStatus = false;

		a = (cacuData.digitData[36] >> 0) & 0x01; // 运行指示状态
		if (a == 1)
			text[9].bStatus = true;
		else if (a == -1)
			text[9].bStatus = true;
		else
			text[9].bStatus = false;

		a = (cacuData.digitData[36] >> 1) & 0x01; // 运行指示状态
		if (a == 1)
			text[10].bStatus = true;
		else if (a == -1)
			text[10].bStatus = true;
		else
			text[10].bStatus = false;

		a = (cacuData.digitData[36] >> 2) & 0x01; // 运行指示状态
		if (a == 1)
			text[11].bStatus = true;
		else if (a == -1)
			text[11].bStatus = true;
		else
			text[11].bStatus = false;

		a = (cacuData.digitData[36] >> 3) & 0x01; // 运行指示状态
		if (a == 1)
			text[12].bStatus = true;
		else if (a == -1)
			text[12].bStatus = true;
		else
			text[12].bStatus = false;

		a = (cacuData.digitData[36] >> 4) & 0x01; // 运行指示状态
		if (a == 1)
			text[13].bStatus = true;
		else if (a == -1)
			text[13].bStatus = true;
		else
			text[13].bStatus = false;

		a = (cacuData.digitData[36] >> 5) & 0x01; // 运行指示状态
		if (a == 1)
			text[14].bStatus = true;
		else if (a == -1)
			text[14].bStatus = true;
		else
			text[14].bStatus = false;

		a = (cacuData.digitData[36] >> 6) & 0x01; // 运行指示状态
		if (a == 1)
			text[15].bStatus = true;
		else if (a == -1)
			text[15].bStatus = true;
		else
			text[15].bStatus = false;

		a = (cacuData.digitData[36] >> 7) & 0x01; // 运行指示状态
		if (a == 1)
			text[16].bStatus = true;
		else if (a == -1)
			text[16].bStatus = true;
		else
			text[16].bStatus = false;

		a = (cacuData.digitData[37] >> 0) & 0x01; // 运行指示状态
		if (a == 1)
			text[18].bStatus = true;
		else if (a == -1)
			text[18].bStatus = true;
		else
			text[18].bStatus = false;

		a = (cacuData.digitData[37] >> 1) & 0x01; // 运行指示状态
		if (a == 1)
			text[19].bStatus = true;
		else if (a == -1)
			text[19].bStatus = true;
		else
			text[19].bStatus = false;

		a = (cacuData.digitData[37] >> 2) & 0x01; // 运行指示状态
		if (a == 1)
			text[20].bStatus = true;
		else if (a == -1)
			text[20].bStatus = true;
		else
			text[20].bStatus = false;

		a = (cacuData.digitData[35] >> 6) & 0x01; // 运行指示状态
		if (a == 1)
			text[27].bStatus = true;
		else if (a == -1)
			text[27].bStatus = true;
		else
			text[27].bStatus = false;

		a = (cacuData.digitData[35] >> 7) & 0x01; // 运行指示状态
		if (a == 1)
			text[28].bStatus = true;
		else if (a == -1)
			text[28].bStatus = true;
		else
			text[28].bStatus = false;
	}
}
