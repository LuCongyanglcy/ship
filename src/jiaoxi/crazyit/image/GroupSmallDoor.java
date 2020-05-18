package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupSmallDoor {
	static final int Valve_NUM = 12; // final表示是一个常量	
	static final Graph_SmallDoor[]  smalldoor = new Graph_SmallDoor[Valve_NUM];
	
	public static void InitValve()		///初始化阀的位置信息 
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			smalldoor[i] = new Graph_SmallDoor();
		}			

	}
	public static void FillValveData(Caculate cacuData,int index)
	   {
		int a;
		for(int i = 0;i<Valve_NUM;i++)
		{
			smalldoor[i].aiData = index;
		}
		// 1号小泥门
		smalldoor[0].percent = cacuData.anlogData[206];
		a = (cacuData.digitData[222] >> 7) & 0x01; // 打开状态
		if (a == 1)
			smalldoor[0].open_state = true;
		else if (a == -1)
			smalldoor[0].open_state = true;
		else
			smalldoor[0].open_state = false;

		a = (cacuData.digitData[222] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			smalldoor[0].close_state = true;
		else if (a == -1)
			smalldoor[0].close_state = true;
		else
			smalldoor[0].close_state = false;
		
		a = (cacuData.digitData[254] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			smalldoor[0].opening = true;
		else if (a == -1)
			smalldoor[0].opening = true;
		else
			smalldoor[0].opening = false;

		a = (cacuData.digitData[254] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			smalldoor[0].closing = true;
		else if (a == -1)
			smalldoor[0].closing = true;
		else
			smalldoor[0].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			smalldoor[0].compelling = true;
		else if (a == -1)
			smalldoor[0].compelling = true;
		else
			smalldoor[0].compelling = false;
		
		a = (cacuData.digitData[254] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			smalldoor[0].enjoin = true;
		else if (a == -1)
			smalldoor[0].enjoin = true;
		else
			smalldoor[0].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			smalldoor[0].failure = true;
		else if (a == -1)
			smalldoor[0].failure = true;
		else
			smalldoor[0].failure = false;
		


		// 2号小泥门
		smalldoor[1].percent = cacuData.anlogData[210];
		a = (cacuData.digitData[222] >> 7) & 0x01; // 打开状态
		if (a == 1)
			smalldoor[1].open_state = true;
		else if (a == -1)
			smalldoor[1].open_state = true;
		else
			smalldoor[1].open_state = false;

		a = (cacuData.digitData[222] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			smalldoor[1].close_state = true;
		else if (a == -1)
			smalldoor[1].close_state = true;
		else
			smalldoor[1].close_state = false;
		
		a = (cacuData.digitData[255] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			smalldoor[1].opening = true;
		else if (a == -1)
			smalldoor[1].opening = true;
		else
			smalldoor[1].opening = false;

		a = (cacuData.digitData[255] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			smalldoor[1].closing = true;
		else if (a == -1)
			smalldoor[1].closing = true;
		else
			smalldoor[1].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			smalldoor[1].compelling = true;
		else if (a == -1)
			smalldoor[1].compelling = true;
		else
			smalldoor[1].compelling = false;
		
		a = (cacuData.digitData[255] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			smalldoor[1].enjoin = true;
		else if (a == -1)
			smalldoor[1].enjoin =true;
		else
			smalldoor[1].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			smalldoor[1].failure = true;
		else if (a == -1)
			smalldoor[1].failure = true;
		else
			smalldoor[1].failure = false;

		


		// 3号小泥门
		smalldoor[2].percent = cacuData.anlogData[207];
		a = (cacuData.digitData[222] >> 7) & 0x01; // 打开状态
		if (a == 1)
			smalldoor[2].open_state = true;
		else if (a == -1)
			smalldoor[2].open_state = true;
		else
			smalldoor[2].open_state = false;

		a = (cacuData.digitData[222] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			smalldoor[2].close_state = true;
		else if (a == -1)
			smalldoor[2].close_state = true;
		else
			smalldoor[2].close_state = false;
		
		a = (cacuData.digitData[256] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			smalldoor[2].opening = true;
		else if (a == -1)
			smalldoor[2].opening = true;
		else
			smalldoor[2].opening = false;

		a = (cacuData.digitData[256] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			smalldoor[2].closing = true;
		else if (a == -1)
			smalldoor[2].closing = true;
		else
			smalldoor[2].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			smalldoor[2].compelling =true;
		else if (a == -1)
			smalldoor[2].compelling = true;
		else
			smalldoor[2].compelling = false;
		
		a = (cacuData.digitData[256] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			smalldoor[2].enjoin = true;
		else if (a == -1)
			smalldoor[2].enjoin = true;
		else
			smalldoor[2].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			smalldoor[2].failure = true;
		else if (a == -1)
			smalldoor[2].failure = true;
		else
			smalldoor[2].failure = false;

		


		// 4号小泥门
		smalldoor[3].percent = cacuData.anlogData[210];
		a = (cacuData.digitData[222] >> 7) & 0x01; // 打开状态
		if (a == 1)
			smalldoor[3].open_state = true;
		else if (a == -1)
			smalldoor[3].open_state = true;
		else
			smalldoor[3].open_state = false;

		a = (cacuData.digitData[222] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			smalldoor[3].close_state = true;
		else if (a == -1)
			smalldoor[3].close_state = true;
		else
			smalldoor[3].close_state = false;
		
		a = (cacuData.digitData[257] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			smalldoor[3].opening = true;
		else if (a == -1)
			smalldoor[3].opening = true;
		else
			smalldoor[3].opening = false;

		a = (cacuData.digitData[257] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			smalldoor[3].closing = true;
		else if (a == -1)
			smalldoor[3].closing = true;
		else
			smalldoor[3].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			smalldoor[3].compelling = true;
		else if (a == -1)
			smalldoor[3].compelling = true;
		else
			smalldoor[3].compelling = false;
		
		a = (cacuData.digitData[257] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			smalldoor[3].enjoin = true;
		else if (a == -1)
			smalldoor[3].enjoin = true;
		else
			smalldoor[3].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			smalldoor[3].failure = true;
		else if (a == -1)
			smalldoor[3].failure = true;
		else
			smalldoor[3].failure = false;

		


		// 5号小泥门
		smalldoor[4].percent = cacuData.anlogData[208];
		a = (cacuData.digitData[222] >> 7) & 0x01; // 打开状态
		if (a == 1)
			smalldoor[4].open_state = true;
		else if (a == -1)
			smalldoor[4].open_state = true;
		else
			smalldoor[4].open_state = false;

		a = (cacuData.digitData[222] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			smalldoor[4].close_state = true;
		else if (a == -1)
			smalldoor[4].close_state = true;
		else
			smalldoor[4].close_state = false;
		
		a = (cacuData.digitData[258] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			smalldoor[4].opening = true;
		else if (a == -1)
			smalldoor[4].opening = true;
		else
			smalldoor[4].opening = false;

		a = (cacuData.digitData[258] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			smalldoor[4].closing = true;
		else if (a == -1)
			smalldoor[4].closing = true;
		else
			smalldoor[4].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			smalldoor[4].compelling = true;
		else if (a == -1)
			smalldoor[4].compelling = true;
		else
			smalldoor[4].compelling = false;
		
		a = (cacuData.digitData[258] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			smalldoor[4].enjoin = true;
		else if (a == -1)
			smalldoor[4].enjoin = true;
		else
			smalldoor[4].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			smalldoor[4].failure = true;
		else if (a == -1)
			smalldoor[4].failure = true;
		else
			smalldoor[4].failure = false;

		


		// 6号小泥门
		smalldoor[5].percent = cacuData.anlogData[212];
		a = (cacuData.digitData[222] >> 7) & 0x01; // 打开状态
		if (a == 1)
			smalldoor[5].open_state = true;
		else if (a == -1)
			smalldoor[5].open_state = true;
		else
			smalldoor[5].open_state = false;

		a = (cacuData.digitData[222] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			smalldoor[5].close_state = true;
		else if (a == -1)
			smalldoor[5].close_state = true;
		else
			smalldoor[5].close_state = false;
		
		a = (cacuData.digitData[259] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			smalldoor[5].opening = true;
		else if (a == -1)
			smalldoor[5].opening = true;
		else
			smalldoor[5].opening = false;

		a = (cacuData.digitData[259] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			smalldoor[5].closing =true;
		else if (a == -1)
			smalldoor[5].closing = true;
		else
			smalldoor[5].closing =false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			smalldoor[5].compelling = true;
		else if (a == -1)
			smalldoor[5].compelling = true;
		else
			smalldoor[5].compelling = false;
		
		a = (cacuData.digitData[259] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			smalldoor[5].enjoin = true;
		else if (a == -1)
			smalldoor[5].enjoin = true;
		else
			smalldoor[5].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			smalldoor[5].failure = true;
		else if (a == -1)
			smalldoor[5].failure = true;
		else
			smalldoor[5].failure = false;

		


		// 7号小泥门
		smalldoor[6].percent = cacuData.anlogData[215];
		a = (cacuData.digitData[222] >> 7) & 0x01; // 打开状态
		if (a == 1)
			smalldoor[6].open_state = true;
		else if (a == -1)
			smalldoor[6].open_state = true;
		else
			smalldoor[6].open_state = false;

		a = (cacuData.digitData[222] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			smalldoor[6].close_state = true;
		else if (a == -1)
			smalldoor[6].close_state = true;
		else
			smalldoor[6].close_state = false;
		
		a = (cacuData.digitData[260] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			smalldoor[6].opening = true;
		else if (a == -1)
			smalldoor[6].opening = true;
		else
			smalldoor[6].opening = false;

		a = (cacuData.digitData[260] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			smalldoor[6].closing = true;
		else if (a == -1)
			smalldoor[6].closing = true;
		else
			smalldoor[6].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			smalldoor[6].compelling = true;
		else if (a == -1)
			smalldoor[6].compelling = true;
		else
			smalldoor[6].compelling = false;
		
		a = (cacuData.digitData[260] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			smalldoor[6].enjoin = true;
		else if (a == -1)
			smalldoor[6].enjoin = true;
		else
			smalldoor[6].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			smalldoor[6].failure =true;
		else if (a == -1)
			smalldoor[6].failure = true;
		else
			smalldoor[6].failure = false;

		


		// 8号小泥门
		smalldoor[7].percent = cacuData.anlogData[222];
		a = (cacuData.digitData[222] >> 7) & 0x01; // 打开状态
		if (a == 1)
			smalldoor[7].open_state = true;
		else if (a == -1)
			smalldoor[7].open_state = true;
		else
			smalldoor[7].open_state = false;

		a = (cacuData.digitData[222] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			smalldoor[7].close_state = true;
		else if (a == -1)
			smalldoor[7].close_state = true;
		else
			smalldoor[7].close_state =false;
		
		a = (cacuData.digitData[261] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			smalldoor[7].opening = true;
		else if (a == -1)
			smalldoor[7].opening = true;
		else
			smalldoor[7].opening = false;

		a = (cacuData.digitData[261] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			smalldoor[7].closing = true;
		else if (a == -1)
			smalldoor[7].closing = true;
		else
			smalldoor[7].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			smalldoor[7].compelling = true;
		else if (a == -1)
			smalldoor[7].compelling = true;
		else
			smalldoor[7].compelling =false;
		
		a = (cacuData.digitData[261] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			smalldoor[7].enjoin = true;
		else if (a == -1)
			smalldoor[7].enjoin = true;
		else
			smalldoor[7].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			smalldoor[7].failure = true;
		else if (a == -1)
			smalldoor[7].failure = true;
		else
			smalldoor[7].failure =false;

		


		// 9号小泥门
		smalldoor[8].percent = cacuData.anlogData[216];
		a = (cacuData.digitData[222] >> 7) & 0x01; // 打开状态
		if (a == 1)
			smalldoor[8].open_state = true;
		else if (a == -1)
			smalldoor[8].open_state = true;
		else
			smalldoor[8].open_state = false;

		a = (cacuData.digitData[222] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			smalldoor[8].close_state = true;
		else if (a == -1)
			smalldoor[8].close_state = true;
		else
			smalldoor[8].close_state = false;
		
		a = (cacuData.digitData[262] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			smalldoor[8].opening = true;
		else if (a == -1)
			smalldoor[8].opening = true;
		else
			smalldoor[8].opening = false;

		a = (cacuData.digitData[262] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			smalldoor[8].closing = true;
		else if (a == -1)
			smalldoor[8].closing = true;
		else
			smalldoor[8].closing = false;
		
		a = (cacuData.digitData[224] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			smalldoor[8].compelling = true;
		else if (a == -1)
			smalldoor[8].compelling = true;
		else
			smalldoor[8].compelling = false;
		
		a = (cacuData.digitData[262] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			smalldoor[8].enjoin = true;
		else if (a == -1)
			smalldoor[8].enjoin = true;
		else
			smalldoor[8].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			smalldoor[8].failure = true;
		else if (a == -1)
			smalldoor[8].failure = true;
		else
			smalldoor[8].failure = false;

		


		// 10号小泥门
		smalldoor[9].percent = cacuData.anlogData[223];
		a = (cacuData.digitData[222] >> 7) & 0x01; // 打开状态
		if (a == 1)
			smalldoor[9].open_state = true;
		else if (a == -1)
			smalldoor[9].open_state = true;
		else
			smalldoor[9].open_state = false;

		a = (cacuData.digitData[222] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			smalldoor[9].close_state = true;
		else if (a == -1)
			smalldoor[9].close_state = true;
		else
			smalldoor[9].close_state = false;
		
		a = (cacuData.digitData[263] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			smalldoor[9].opening = true;
		else if (a == -1)
			smalldoor[9].opening = true;
		else
			smalldoor[9].opening = false;

		a = (cacuData.digitData[263] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			smalldoor[9].closing = true;
		else if (a == -1)
			smalldoor[9].closing = true;
		else
			smalldoor[9].closing = false;
		
		a = (cacuData.digitData[224] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			smalldoor[9].compelling = true;
		else if (a == -1)
			smalldoor[9].compelling = true;
		else
			smalldoor[9].compelling = false;
		
		a = (cacuData.digitData[263] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			smalldoor[9].enjoin = true;
		else if (a == -1)
			smalldoor[9].enjoin = true;
		else
			smalldoor[9].enjoin = false;
		
		a = (cacuData.digitData[224] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			smalldoor[9].failure = true;
		else if (a == -1)
			smalldoor[9].failure = true;
		else
			smalldoor[9].failure = false;

		


		// 11号小泥门
		smalldoor[10].percent = cacuData.anlogData[217];
		a = (cacuData.digitData[222] >> 7) & 0x01; // 打开状态
		if (a == 1)
			smalldoor[10].open_state = true;
		else if (a == -1)
			smalldoor[10].open_state = true;
		else
			smalldoor[10].open_state = false;

		a = (cacuData.digitData[222] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			smalldoor[10].close_state = true;
		else if (a == -1)
			smalldoor[10].close_state = true;
		else
			smalldoor[10].close_state = false;
		
		a = (cacuData.digitData[264] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			smalldoor[10].opening = true;
		else if (a == -1)
			smalldoor[10].opening = true;
		else
			smalldoor[10].opening = false;

		a = (cacuData.digitData[264] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			smalldoor[10].closing = true;
		else if (a == -1)
			smalldoor[10].closing = true;
		else
			smalldoor[10].closing = false;
		
		a = (cacuData.digitData[266] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			smalldoor[10].compelling = true;
		else if (a == -1)
			smalldoor[10].compelling = true;
		else
			smalldoor[10].compelling = false;
		
		a = (cacuData.digitData[264] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			smalldoor[10].enjoin = true;
		else if (a == -1)
			smalldoor[10].enjoin =true;
		else
			smalldoor[10].enjoin = false;
		
		a = (cacuData.digitData[266] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			smalldoor[10].failure = true;
		else if (a == -1)
			smalldoor[10].failure = true;
		else
			smalldoor[10].failure =false;

		


		// 12号小泥门
		smalldoor[11].aiData = cacuData.anlogData[224];
		a = (cacuData.digitData[222] >> 7) & 0x01; // 打开状态
		if (a == 1)
			smalldoor[11].open_state = true;
		else if (a == -1)
			smalldoor[11].open_state = true;
		else
			smalldoor[11].open_state = false;

		a = (cacuData.digitData[222] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			smalldoor[11].close_state =true;
		else if (a == -1)
			smalldoor[11].close_state = true;
		else
			smalldoor[11].close_state = false;
		
		a = (cacuData.digitData[265] >> 0) & 0x01; // 正在打开状态
		if (a == 1)
			smalldoor[11].opening = true;
		else if (a == -1)
			smalldoor[11].opening = true;
		else
			smalldoor[11].opening = false;

		a = (cacuData.digitData[265] >> 1) & 0x01; // 正在关闭状态
		if (a == 1)
			smalldoor[11].closing = true;
		else if (a == -1)
			smalldoor[11].closing = true;
		else
			smalldoor[11].closing = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; // 被强制状态
		if (a == 1)
			smalldoor[11].compelling =true;
		else if (a == -1)
			smalldoor[11].compelling = true;
		else
			smalldoor[11].compelling =false;
		
		a = (cacuData.digitData[265] >> 7) & 0x01; // 禁止状态
		if (a == 1)
			smalldoor[11].enjoin = true;
		else if (a == -1)
			smalldoor[11].enjoin = true;
		else
			smalldoor[11].enjoin = false;
		
		a = (cacuData.digitData[222] >> 7) & 0x01; ///设备故障或抑制
		if (a == 1)
			smalldoor[11].failure = true;
		else if (a == -1)
			smalldoor[11].failure = true;
		else
			smalldoor[11].failure = false;
	}
}
