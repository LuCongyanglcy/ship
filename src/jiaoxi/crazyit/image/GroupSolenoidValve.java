package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupSolenoidValve {
	static final int Valve_NUM = 80; // final表示是一个常量	
	static final int Valve_NUM0 =4; //说明书的3个
	public static final Graph_SolenoidValve[] SolenoidValve = new Graph_SolenoidValve[Valve_NUM];
	static final Graph_SolenoidValve[] SolenoidValve0 = new Graph_SolenoidValve[Valve_NUM0];//说明书的3个
	public static void InitValve()		///初始化阀的位置信息 
	{
		for(int i=0;i<Valve_NUM0;i++)
		{
			SolenoidValve0[i] = new Graph_SolenoidValve();
		}
		for(int i=0;i<Valve_NUM;i++)
		{
			SolenoidValve[i] = new Graph_SolenoidValve();
		}			

	}
	public static void FillValveData(Caculate cacuData)
	   {
		int a;
		// 电磁阀

		a = (cacuData.digitData[27] >> 0) & 0x01; // 变绿
		if (a == 1)
			SolenoidValve[37].blink_sign = true;
		else if (a == -1)
			SolenoidValve[37].blink_sign = true;
		else
			SolenoidValve[37].blink_sign = false;

		a = (cacuData.digitData[27] >> 1) & 0x01; // 变绿
		if (a == 1)
			SolenoidValve[38].blink_sign = true;
		else if (a == -1)
			SolenoidValve[38].blink_sign = true;
		else
			SolenoidValve[38].blink_sign = false;

		a = (cacuData.digitData[27] >> 2) & 0x01; // 变绿
		if (a == 1)
			SolenoidValve[39].blink_sign = true;
		else if (a == -1)
			SolenoidValve[39].blink_sign = true;
		else
			SolenoidValve[39].blink_sign = false;
		//////////////////////////////////////////////


		a = (cacuData.digitData[27] >> 4) & 0x01; // 变绿
		if (a == 1)
			SolenoidValve[1].blink_sign = true;
		else if (a == -1)
			SolenoidValve[1].blink_sign = true;
		else
			SolenoidValve[1].blink_sign = false;

		a = (cacuData.digitData[27] >> 5) & 0x01; // 变绿
		if (a == 1)
			SolenoidValve[2].blink_sign = true;
		else if (a == -1)
			SolenoidValve[2].blink_sign = true;
		else
			SolenoidValve[2].blink_sign = false;

		a = (cacuData.digitData[27] >> 6) & 0x01; // 变绿
		if (a == 1)
			SolenoidValve[3].blink_sign = true;
		else if (a == -1)
			SolenoidValve[3].blink_sign = true;
		else
			SolenoidValve[3].blink_sign = false;

		a = (cacuData.digitData[27] >> 7) & 0x01; // 变绿
		if (a == 1)
			SolenoidValve[4].blink_sign = true;
		else if (a == -1)
			SolenoidValve[4].blink_sign = true;
		else
			SolenoidValve[4].blink_sign = false;
//////////////////////////////////////////////////////////////////////////////////////////////
		for(int i=0;i<8;i++) {
			a = (cacuData.digitData[28] >> i) & 0x01; // 变绿
			if (a == 1)
				SolenoidValve[5+i].blink_sign = true;
			else if (a == -1)
				SolenoidValve[5+i].blink_sign = true;
			else
				SolenoidValve[5+i].blink_sign = false;
		}
		for(int i=0;i<8;i++) {
			a = (cacuData.digitData[29] >> i) & 0x01; // 变绿
			if (a == 1)
				SolenoidValve[13+i].blink_sign = true;
			else if (a == -1)
				SolenoidValve[13+i].blink_sign = true;
			else
				SolenoidValve[13+i].blink_sign = false;
		}
		for(int i=0;i<8;i++) {
			a = (cacuData.digitData[30] >> i) & 0x01; // 变绿
			if (a == 1)
				SolenoidValve[21+i].blink_sign = true;
			else if (a == -1)
				SolenoidValve[21+i].blink_sign = true;
			else
				SolenoidValve[21+i].blink_sign = false;
		}
		for(int i=0;i<8;i++) {
			a = (cacuData.digitData[31] >> i) & 0x01; // 变绿
			if (a == 1)
				SolenoidValve[29+i].blink_sign = true;
			else if (a == -1)
				SolenoidValve[29+i].blink_sign = true;
			else
				SolenoidValve[29+i].blink_sign = false;
		}
	}
	
}
