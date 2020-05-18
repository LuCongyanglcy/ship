package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupHDPump {

	static final int Valve_NUM = 11; // final表示是一个常量	
	static final Graph_HDPump[] hdpump = new Graph_HDPump[Valve_NUM];
	
	public static void InitValve()		///初始化阀的位置信息 
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			hdpump[i] = new Graph_HDPump();
		}			

	}

	public static void FillValveData(Caculate cacuData, int index) {
		
//		for (int i = 0; i < Valve_NUM; i++) {
//			hdpump[i].aiData = index;
//		}

		int a;//0液压1封水2总用3应急4消防
		if(cacuData.anlogData[100 + 26] >= 0.5)
			hdpump[1].run_status = true;
		else
			hdpump[1].run_status = false;
		
		a = (cacuData.digitData[8] >> 7) & 0x01; // 运行状态
		if (a == 1)
			hdpump[3].run_status = true;
		else if (a == -1)
			hdpump[3].run_status = true;
		else
			hdpump[3].run_status = false;
		
		a = (cacuData.digitData[8] >> 4) & 0x01; // 运行状态
		if (a == 1)
			hdpump[4].run_status = true;
		else if (a == -1)
			hdpump[4].run_status = true;
		else
			hdpump[4].run_status = false;
	}
}
