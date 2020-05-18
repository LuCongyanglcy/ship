package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupBigDoor {
	static final int Valve_NUM = 12; // final表示是一个常量	
	static final Graph_BigDoor[]  bigdoor = new Graph_BigDoor[Valve_NUM];
	
	public static void InitValve()		///初始化阀的位置信息 
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			bigdoor[i] = new Graph_BigDoor();
		}			

	}
	public static void FillValveData(Caculate cacuData, int index)
	   {
		int a;
		// 1号大泥门
		bigdoor[0].aiData = index;
		a = (cacuData.digitData[21] >>4) & 0x01; // 打开状态
		if (a == 1)
			bigdoor[0].open_state = true;
		else if (a == -1)
			bigdoor[0].open_state = true;
		else
			bigdoor[0].open_state = false;

		a = (cacuData.digitData[21] >> 5) & 0x01; // 关闭状态
		if (a == 1)
			bigdoor[0].close_state = true;
		else if (a == -1)
			bigdoor[0].close_state = true;
		else
			bigdoor[0].close_state = false;
		
		a = (cacuData.digitData[229] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			bigdoor[0].opening = true;
		else if (a == -1)
			bigdoor[0].opening = true;
		else
			bigdoor[0].opening = false;

		a = (cacuData.digitData[229] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			bigdoor[0].closing = true;
		else if (a == -1)
			bigdoor[0].closing = true;
		else
			bigdoor[0].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			bigdoor[0].compelling = true;
		else if (a == -1)
			bigdoor[0].compelling = true;
		else
			bigdoor[0].compelling = false;
		
		a = (cacuData.digitData[229] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			bigdoor[0].enjoin = true;
		else if (a == -1)
			bigdoor[0].enjoin = true;
		else
			bigdoor[0].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			bigdoor[0].failure = true;
		else if (a == -1)
			bigdoor[0].failure = true;
		else
			bigdoor[0].failure = false;
		


		// 2号大泥门
		bigdoor[1].aiData = index;
		a = (cacuData.digitData[23] >> 0) & 0x01; // 打开状态
		if (a == 1)
			bigdoor[1].open_state = true;
		else if (a == -1)
			bigdoor[1].open_state = true;
		else
			bigdoor[1].open_state = false;

		a = (cacuData.digitData[23] >> 1) & 0x01; // 关闭状态
		if (a == 1)
			bigdoor[1].close_state = true;
		else if (a == -1)
			bigdoor[1].close_state = true;
		else
			bigdoor[1].close_state = false;
		
		a = (cacuData.digitData[230] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			bigdoor[1].opening = true;
		else if (a == -1)
			bigdoor[1].opening = true;
		else
			bigdoor[1].opening = false;

		a = (cacuData.digitData[230] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			bigdoor[1].closing = true;
		else if (a == -1)
			bigdoor[1].closing = true;
		else
			bigdoor[1].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			bigdoor[1].compelling = true;
		else if (a == -1)
			bigdoor[1].compelling = true;
		else
			bigdoor[1].compelling = false;
		
		a = (cacuData.digitData[230] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			bigdoor[1].enjoin = true;
		else if (a == -1)
			bigdoor[1].enjoin = true;
		else
			bigdoor[1].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			bigdoor[1].failure =true;
		else if (a == -1)
			bigdoor[1].failure = true;
		else
			bigdoor[1].failure = false;


              // 3号大泥门
		bigdoor[2].aiData = index;
		a = (cacuData.digitData[21] >>6) & 0x01; // 打开状态
		if (a == 1)
			bigdoor[2].open_state = true;
		else if (a == -1)
			bigdoor[2].open_state = true;
		else
			bigdoor[2].open_state = false;

		a = (cacuData.digitData[21] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			bigdoor[2].close_state = true;
		else if (a == -1)
			bigdoor[2].close_state = true;
		else
			bigdoor[2].close_state = false;
		
		a = (cacuData.digitData[231] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			bigdoor[2].opening = true;
		else if (a == -1)
			bigdoor[2].opening = true;
		else
			bigdoor[2].opening = false;

		a = (cacuData.digitData[231] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			bigdoor[2].closing = true;
		else if (a == -1)
			bigdoor[2].closing = true;
		else
			bigdoor[2].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			bigdoor[2].compelling = true;
		else if (a == -1)
			bigdoor[2].compelling = true;
		else
			bigdoor[2].compelling = false;
		
		a = (cacuData.digitData[231] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			bigdoor[2].enjoin = true;
		else if (a == -1)
			bigdoor[2].enjoin = true;
		else
			bigdoor[2].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			bigdoor[2].failure = true;
		else if (a == -1)
			bigdoor[2].failure = true;
		else
			bigdoor[2].failure = false;



              // 4号大泥门
		bigdoor[3].aiData = index;
		a = (cacuData.digitData[23] >>2) & 0x01; // 打开状态
		if (a == 1)
			bigdoor[3].open_state = true;
		else if (a == -1)
			bigdoor[3].open_state = true;
		else
			bigdoor[3].open_state = false;

		a = (cacuData.digitData[23] >> 3) & 0x01; // 关闭状态
		if (a == 1)
			bigdoor[3].close_state = true;
		else if (a == -1)
			bigdoor[3].close_state = true;
		else
			bigdoor[3].close_state = false;
		
		a = (cacuData.digitData[232] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			bigdoor[3].opening = true;
		else if (a == -1)
			bigdoor[3].opening = true;
		else
			bigdoor[3].opening = false;

		a = (cacuData.digitData[232] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			bigdoor[3].closing = true;
		else if (a == -1)
			bigdoor[3].closing = true;
		else
			bigdoor[3].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			bigdoor[3].compelling = true;
		else if (a == -1)
			bigdoor[3].compelling = true;
		else
			bigdoor[3].compelling = false;
		
		a = (cacuData.digitData[232] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			bigdoor[3].enjoin = true;
		else if (a == -1)
			bigdoor[3].enjoin = true;
		else
			bigdoor[3].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			bigdoor[3].failure = true;
		else if (a == -1)
			bigdoor[3].failure = true;
		else
			bigdoor[3].failure = false;



              // 5号大泥门
		bigdoor[4].aiData = index;
		a = (cacuData.digitData[22] >>0) & 0x01; // 打开状态
		if (a == 1)
			bigdoor[4].open_state = true;
		else if (a == -1)
			bigdoor[4].open_state = true;
		else
			bigdoor[4].open_state = false;

		a = (cacuData.digitData[22] >> 1) & 0x01; // 关闭状态
		if (a == 1)
			bigdoor[4].close_state = true;
		else if (a == -1)
			bigdoor[4].close_state = true;
		else
			bigdoor[4].close_state = false;
		
		a = (cacuData.digitData[233] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			bigdoor[4].opening = true;
		else if (a == -1)
			bigdoor[4].opening = true;
		else
			bigdoor[4].opening = false;

		a = (cacuData.digitData[233] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			bigdoor[4].closing = true;
		else if (a == -1)
			bigdoor[4].closing = true;
		else
			bigdoor[4].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			bigdoor[4].compelling = true;
		else if (a == -1)
			bigdoor[4].compelling = true;
		else
			bigdoor[4].compelling = false;
		
		a = (cacuData.digitData[233] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			bigdoor[4].enjoin = true;
		else if (a == -1)
			bigdoor[4].enjoin = true;
		else
			bigdoor[4].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			bigdoor[4].failure = true;
		else if (a == -1)
			bigdoor[4].failure = true;
		else
			bigdoor[4].failure = false;


              // 6号大泥门
		bigdoor[5].aiData = index;
		a = (cacuData.digitData[23] >>4) & 0x01; // 打开状态
		if (a == 1)
			bigdoor[5].open_state = true;
		else if (a == -1)
			bigdoor[5].open_state = true;
		else
			bigdoor[5].open_state = false;

		a = (cacuData.digitData[23] >> 5) & 0x01; // 关闭状态
		if (a == 1)
			bigdoor[5].close_state =  true;
		else if (a == -1)
			bigdoor[5].close_state =  true;
		else
			bigdoor[5].close_state = false;
		
		a = (cacuData.digitData[234] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			bigdoor[5].opening = true;
		else if (a == -1)
			bigdoor[5].opening = true;
		else
			bigdoor[5].opening = false;

		a = (cacuData.digitData[234] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			bigdoor[5].closing =  true;
		else if (a == -1)
			bigdoor[5].closing =  true;
		else
			bigdoor[5].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			bigdoor[5].compelling =  true;
		else if (a == -1)
			bigdoor[5].compelling =  true;
		else
			bigdoor[5].compelling = false;
		
		a = (cacuData.digitData[234] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			bigdoor[5].enjoin =  true;
		else if (a == -1)
			bigdoor[5].enjoin =  true;
		else
			bigdoor[5].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			bigdoor[5].failure =  true;
		else if (a == -1)
			bigdoor[5].failure =  true;
		else
			bigdoor[5].failure = false;



              // 7号大泥门
		bigdoor[6].aiData = index;
		a = (cacuData.digitData[24] >>4) & 0x01; // 打开状态
		if (a == 1)
			bigdoor[6].open_state = true;
		else if (a == -1)
			bigdoor[6].open_state = true;
		else
			bigdoor[6].open_state = false;

		a = (cacuData.digitData[24] >> 5) & 0x01; // 关闭状态
		if (a == 1)
			bigdoor[6].close_state =true;
		else if (a == -1)
			bigdoor[6].close_state = true;
		else
			bigdoor[6].close_state = false;

		
		a = (cacuData.digitData[235] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			bigdoor[6].opening = true;
		else if (a == -1)
			bigdoor[6].opening = true;
		else
			bigdoor[6].opening = false;

		a = (cacuData.digitData[235] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			bigdoor[6].closing = true;
		else if (a == -1)
			bigdoor[6].closing = true;
		else
			bigdoor[6].closing = false;

		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			bigdoor[6].compelling = true;
		else if (a == -1)
			bigdoor[6].compelling = true;
		else
			bigdoor[6].compelling = false;

		
		a = (cacuData.digitData[235] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			bigdoor[6].enjoin = true;
		else if (a == -1)
			bigdoor[6].enjoin = true;
		else
			bigdoor[6].enjoin = false;

		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			bigdoor[6].failure = true;
		else if (a == -1)
			bigdoor[6].failure = true;
		else
			bigdoor[6].failure = false;




              // 8号大泥门
		bigdoor[7].aiData = index;
		a = (cacuData.digitData[26] >>0) & 0x01; // 打开状态
		if (a == 1)
			bigdoor[7].open_state = true;
		else if (a == -1)
			bigdoor[7].open_state = true;
		else
			bigdoor[7].open_state = false;

		a = (cacuData.digitData[26] >> 1) & 0x01; // 关闭状态
		if (a == 1)
			bigdoor[7].close_state =true;
		else if (a == -1)
			bigdoor[7].close_state = true;
		else
			bigdoor[7].close_state = false;
		
		a = (cacuData.digitData[236] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			bigdoor[7].opening = true;
		else if (a == -1)
			bigdoor[7].opening = true;
		else
			bigdoor[7].opening = false;

		a = (cacuData.digitData[236] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			bigdoor[7].closing = true;
		else if (a == -1)
			bigdoor[7].closing = true;
		else
			bigdoor[7].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			bigdoor[7].compelling = true;
		else if (a == -1)
			bigdoor[7].compelling =true;
		else
			bigdoor[7].compelling = false;
		
		a = (cacuData.digitData[236] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			bigdoor[7].enjoin = true;
		else if (a == -1)
			bigdoor[7].enjoin = true;
		else
			bigdoor[7].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			bigdoor[7].failure = true;
		else if (a == -1)
			bigdoor[7].failure = true;
		else
			bigdoor[7].failure =false;



              // 9号大泥门
		bigdoor[8].aiData = index;
		a = (cacuData.digitData[24] >>6) & 0x01; // 打开状态
		if (a == 1)
			bigdoor[8].open_state = true;
		else if (a == -1)
			bigdoor[8].open_state = true;
		else
			bigdoor[8].open_state = false;

		a = (cacuData.digitData[24] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			bigdoor[8].close_state = true;
		else if (a == -1)
			bigdoor[8].close_state = true;
		else
			bigdoor[8].close_state = false;
		
		a = (cacuData.digitData[237] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			bigdoor[8].opening = true;
		else if (a == -1)
			bigdoor[8].opening = true;
		else
			bigdoor[8].opening = false;

		a = (cacuData.digitData[237] >> 0) & 0x01; // 正在关闭状态
		if (a == 1)
			bigdoor[8].closing = true;
		else if (a == -1)
			bigdoor[8].closing = true;
		else
			bigdoor[8].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			bigdoor[8].compelling = true;
		else if (a == -1)
			bigdoor[8].compelling = true;
		else
			bigdoor[8].compelling = false;
		
		a = (cacuData.digitData[237] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			bigdoor[8].enjoin = true;
		else if (a == -1)
			bigdoor[8].enjoin = true;
		else
			bigdoor[8].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			bigdoor[8].failure = true;
		else if (a == -1)
			bigdoor[8].failure = true;
		else
			bigdoor[8].failure = false;



              // 10号大泥门
		bigdoor[9].aiData = index;
		a = (cacuData.digitData[26] >>2) & 0x01; // 打开状态
		if (a == 1)
			bigdoor[9].open_state = true;
		else if (a == -1)
			bigdoor[9].open_state = true;
		else
			bigdoor[9].open_state = false;

		a = (cacuData.digitData[26] >> 3) & 0x01; // 关闭状态
		if (a == 1)
			bigdoor[9].close_state = true;
		else if (a == -1)
			bigdoor[9].close_state = true;
		else
			bigdoor[9].close_state = false;
		
		a = (cacuData.digitData[238] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			bigdoor[9].opening = true;
		else if (a == -1)
			bigdoor[9].opening = true;
		else
			bigdoor[9].opening = false;

		a = (cacuData.digitData[238] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			bigdoor[9].closing = true;
		else if (a == -1)
			bigdoor[9].closing = true;
		else
			bigdoor[9].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			bigdoor[9].compelling = true;
		else if (a == -1)
			bigdoor[9].compelling = true;
		else
			bigdoor[9].compelling = false;
		
		a = (cacuData.digitData[238] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			bigdoor[9].enjoin = true;
		else if (a == -1)
			bigdoor[9].enjoin = true;
		else
			bigdoor[9].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			bigdoor[9].failure = true;
		else if (a == -1)
			bigdoor[9].failure = true;
		else
			bigdoor[9].failure = false;



              // 11号大泥门
		bigdoor[10].aiData = index;
		a = (cacuData.digitData[25] >>0) & 0x01; // 打开状态
		if (a == 1)
			bigdoor[10].open_state = true;
		else if (a == -1)
			bigdoor[10].open_state = true;
		else
			bigdoor[10].open_state = false;

		a = (cacuData.digitData[25] >> 1) & 0x01; // 关闭状态
		if (a == 1)
			bigdoor[10].close_state = true;
		else if (a == -1)
			bigdoor[10].close_state = true;
		else
			bigdoor[10].close_state = false;
		
		a = (cacuData.digitData[239] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			bigdoor[10].opening = true;
		else if (a == -1)
			bigdoor[10].opening = true;
		else
			bigdoor[10].opening = false;

		a = (cacuData.digitData[239] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			bigdoor[10].closing = true;
		else if (a == -1)
			bigdoor[10].closing = true;
		else
			bigdoor[10].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			bigdoor[10].compelling = true;
		else if (a == -1)
			bigdoor[10].compelling = true;
		else
			bigdoor[10].compelling = false;
		
		a = (cacuData.digitData[239] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			bigdoor[10].enjoin = true;
		else if (a == -1)
			bigdoor[10].enjoin = true;
		else
			bigdoor[10].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			bigdoor[10].failure = true;
		else if (a == -1)
			bigdoor[10].failure = true;
		else
			bigdoor[10].failure = false;



              // 12号大泥门
		bigdoor[11].aiData = index;
		a = (cacuData.digitData[26] >>4) & 0x01; // 打开状态
		if (a == 1)
			bigdoor[11].open_state = true;
		else if (a == -1)
			bigdoor[11].open_state = true;
		else
			bigdoor[11].open_state = false;

		a = (cacuData.digitData[26] >> 5) & 0x01; // 关闭状态
		if (a == 1)
			bigdoor[11].close_state = true;
		else if (a == -1)
			bigdoor[11].close_state = true;
		else
			bigdoor[11].close_state = false;
		
		a = (cacuData.digitData[240] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			bigdoor[11].opening = true;
		else if (a == -1)
			bigdoor[11].opening = true;
		else
			bigdoor[11].opening = false;

		a = (cacuData.digitData[240] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			bigdoor[11].closing = true;
		else if (a == -1)
			bigdoor[11].closing = true;
		else
			bigdoor[11].closing = false;
		
		a = (cacuData.digitData[223] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			bigdoor[11].compelling = true;
		else if (a == -1)
			bigdoor[11].compelling = true;
		else
			bigdoor[11].compelling = false;
		
		a = (cacuData.digitData[240] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			bigdoor[11].enjoin = true;
		else if (a == -1)
			bigdoor[11].enjoin = true;
		else
			bigdoor[11].enjoin = false;
		
		a = (cacuData.digitData[223] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			bigdoor[11].failure = true;
		else if (a == -1)
			bigdoor[11].failure = true;
		else
			bigdoor[11].failure = false;
	}
}

