package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class NewGroupValves {

	static final int Valve_NUM = 60; // final表示是一个常量
	static final Graph_Value[] graph1 = new Graph_Value[Valve_NUM];

	public static void InitValve() // /初始化阀的位置信息
	{
		for (int i = 0; i < Valve_NUM; i++) {
			graph1[i] = new Graph_Value();
		}

	}

	public static void FillValveData(Caculate cacuData, int index) {
		int a;
		for (int i = 0; i < Valve_NUM; i++) {
			graph1[i].aiData = index;
		}
		// 阀1左舷水泵吸入闸阀JWV1
		a = (cacuData.digitData[16] >> 6) & 0x01; // 打开状态
		if (a == 1)
			graph1[0].open_state = true;
		else if (a == -1)
			graph1[0].open_state = true;
		else
			graph1[0].open_state = false;

		a = (cacuData.digitData[16] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			graph1[0].close_state = true;
		else if (a == -1)
			graph1[0].close_state = true;
		else
			graph1[0].close_state = false;

		a = (cacuData.digitData[138] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[0].open_false = true;
		else if (a == -1)
			graph1[0].open_false = true;
		else
			graph1[0].open_false = false;

		a = (cacuData.digitData[138] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[0].close_false = true;
		else if (a == -1)
			graph1[0].close_false = true;
		else
			graph1[0].close_false = false;

		a = (cacuData.digitData[138] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[0].opening = true;
		else if (a == -1)
			graph1[0].opening = true;
		else
			graph1[0].opening = false;

		a = (cacuData.digitData[138] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[0].closeing = true;
		else if (a == -1)
			graph1[0].closeing = true;
		else
			graph1[0].closeing = false;

		a = (cacuData.digitData[138] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[0].open_fail= true;
		else if (a == -1)
			graph1[0].open_fail = true;
		else
			graph1[0].open_fail = false;

		a = (cacuData.digitData[138] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[0].close_fail = true;
		else if (a == -1)
			graph1[0].close_fail = true;
		else
			graph1[0].close_fail = false;

		a = (cacuData.digitData[138] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[0].open_allow = true;
		else if (a == -1)
			graph1[0].open_allow = true;
		else
			graph1[0].open_allow = false;

		a = (cacuData.digitData[138] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[0].close_allow = true;
		else if (a == -1)
			graph1[0].close_allow = true;
		else
			graph1[0].close_allow = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[0].enjoin = true;
		else if (a == -1)
			graph1[0].enjoin = true;
		else
			graph1[0].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[0].compelling = true;
		else if (a == -1)
			graph1[0].compelling = true;
		else
			graph1[0].compelling = false;

		// 右舷水泵吸入闸阀JWV2
		a = (cacuData.digitData[19] >> 4) & 0x01; // 打开状态
		if (a == 1)
			graph1[1].open_state = true;
		else if (a == -1)
			graph1[1].open_state = true;
		else
			graph1[1].open_state = false;

		a = (cacuData.digitData[19] >> 5) & 0x01; // 关闭状态
		if (a == 1)
			graph1[1].close_state = true;
		else if (a == -1)
			graph1[1].close_state = true;
		else
			graph1[1].close_state = false;

		a = (cacuData.digitData[139] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[1].open_false = true;
		else if (a == -1)
			graph1[1].open_false = true;
		else
			graph1[1].open_false = false;

		a = (cacuData.digitData[139] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[1].close_false = true;
		else if (a == -1)
			graph1[1].close_false = true;
		else
			graph1[1].close_false = false;

		a = (cacuData.digitData[139] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[1].opening = true;
		else if (a == -1)
			graph1[1].opening = true;
		else
			graph1[1].opening = false;

		a = (cacuData.digitData[139] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[1].closeing = true;
		else if (a == -1)
			graph1[1].closeing = true;
		else
			graph1[1].closeing = false;

		a = (cacuData.digitData[139] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[1].open_fail = true;
		else if (a == -1)
			graph1[1].open_fail = true;
		else
			graph1[1].open_fail = false;

		a = (cacuData.digitData[139] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[1].close_fail = true;
		else if (a == -1)
			graph1[1].close_fail = true;
		else
			graph1[1].close_fail = false;

		a = (cacuData.digitData[139] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[1].open_allow   = true;
		else if (a == -1)
			graph1[1].open_allow   = true;
		else
			graph1[1].open_allow   = false;

		a = (cacuData.digitData[139] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[1].close_allow   = true;
		else if (a == -1)
			graph1[1].close_allow   = true;
		else
			graph1[1].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[1].enjoin = true;
		else if (a == -1)
			graph1[1].enjoin = true;
		else
			graph1[1].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[1].compelling = true;
		else if (a == -1)
			graph1[1].compelling = true;
		else
			graph1[1].compelling = false;

		// 左舷水泵排出蝶阀JWV3
		a = (cacuData.digitData[17] >> 0) & 0x01; // 打开状态
		if (a == 1)
			graph1[2].open_state = true;
		else if (a == -1)
			graph1[2].open_state = true;
		else
			graph1[2].open_state = false;

		a = (cacuData.digitData[17] >> 1) & 0x01; // 关闭状态
		if (a == 1)
			graph1[2].close_state = true;
		else if (a == -1)
			graph1[2].close_state = true;
		else
			graph1[2].close_state = false;

		a = (cacuData.digitData[140] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[2].open_false = true;
		else if (a == -1)
			graph1[2].open_false = true;
		else
			graph1[2].open_false = false;

		a = (cacuData.digitData[140] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[2].close_false = true;
		else if (a == -1)
			graph1[2].close_false = true;
		else
			graph1[2].close_false = false;

		a = (cacuData.digitData[140] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[2].opening = true;
		else if (a == -1)
			graph1[2].opening = true;
		else
			graph1[2].opening = false;

		a = (cacuData.digitData[140] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[2].closeing = true;
		else if (a == -1)
			graph1[2].closeing = true;
		else
			graph1[2].closeing = false;

		a = (cacuData.digitData[140] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[2].open_fail   = true;
		else if (a == -1)
			graph1[2].open_fail   = true;
		else
			graph1[2].open_fail   = false;

		a = (cacuData.digitData[140] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[2].close_fail   = true;
		else if (a == -1)
			graph1[2].close_fail   = true;
		else
			graph1[2].close_fail   = false;

		a = (cacuData.digitData[140] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[2].open_allow   = true;
		else if (a == -1)
			graph1[2].open_allow   = true;
		else
			graph1[2].open_allow   = false;

		a = (cacuData.digitData[140] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[2].close_allow   = true;
		else if (a == -1)
			graph1[2].close_allow   = true;
		else
			graph1[2].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[2].enjoin = true;
		else if (a == -1)
			graph1[2].enjoin = true;
		else
			graph1[2].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[2].compelling = true;
		else if (a == -1)
			graph1[2].compelling = true;
		else
			graph1[2].compelling = false;

		// 右舷水泵排出蝶阀JWV4
		a = (cacuData.digitData[19] >> 6) & 0x01; // 打开状态
		if (a == 1)
			graph1[3].open_state = true;
		else if (a == -1)
			graph1[3].open_state = true;
		else
			graph1[3].open_state = false;

		a = (cacuData.digitData[19] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			graph1[3].close_state = true;
		else if (a == -1)
			graph1[3].close_state = true;
		else
			graph1[3].close_state = false;

		a = (cacuData.digitData[141] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[3].open_false = true;
		else if (a == -1)
			graph1[3].open_false = true;
		else
			graph1[3].open_false = false;

		a = (cacuData.digitData[141] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[3].close_false = true;
		else if (a == -1)
			graph1[3].close_false = true;
		else
			graph1[3].close_false = false;

		a = (cacuData.digitData[141] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[3].opening = true;
		else if (a == -1)
			graph1[3].opening = true;
		else
			graph1[3].opening = false;

		a = (cacuData.digitData[141] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[3].closeing = true;
		else if (a == -1)
			graph1[3].closeing = true;
		else
			graph1[3].closeing = false;

		a = (cacuData.digitData[141] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[3].open_fail   = true;
		else if (a == -1)
			graph1[3].open_fail   = true;
		else
			graph1[3].open_fail   = false;

		a = (cacuData.digitData[141] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[3].close_fail   = true;
		else if (a == -1)
			graph1[3].close_fail   = true;
		else
			graph1[3].close_fail   = false;

		a = (cacuData.digitData[141] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[3].open_allow   = true;
		else if (a == -1)
			graph1[3].open_allow   = true;
		else
			graph1[3].open_allow   = false;

		a = (cacuData.digitData[141] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[3].close_allow   = true;
		else if (a == -1)
			graph1[3].close_allow   = true;
		else
			graph1[3].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[3].enjoin = true;
		else if (a == -1)
			graph1[3].enjoin = true;
		else
			graph1[3].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[3].compelling = true;
		else if (a == -1)
			graph1[3].compelling = true;
		else
			graph1[3].compelling = false;

		// 左耙头冲水蝶阀Jwv7
		a = (cacuData.digitData[17] >> 4) & 0x01; // 打开状态
		if (a == 1)
			graph1[4].open_state = true;
		else if (a == -1)
			graph1[4].open_state = true;
		else
			graph1[4].open_state = false;

		a = (cacuData.digitData[17] >> 5) & 0x01; // 关闭状态
		if (a == 1)
			graph1[4].close_state = true;
		else if (a == -1)
			graph1[4].close_state = true;
		else
			graph1[4].close_state = false;

		a = (cacuData.digitData[142] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[4].open_false = true;
		else if (a == -1)
			graph1[4].open_false = true;
		else
			graph1[4].open_false = false;

		a = (cacuData.digitData[142] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[4].close_false = true;
		else if (a == -1)
			graph1[4].close_false = true;
		else
			graph1[4].close_false = false;

		a = (cacuData.digitData[142] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[4].opening = true;
		else if (a == -1)
			graph1[4].opening = true;
		else
			graph1[4].opening = false;

		a = (cacuData.digitData[142] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[4].closeing = true;
		else if (a == -1)
			graph1[4].closeing = true;
		else
			graph1[4].closeing = false;

		a = (cacuData.digitData[142] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[4].open_fail   = true;
		else if (a == -1)
			graph1[4].open_fail   = true;
		else
			graph1[4].open_fail   = false;

		a = (cacuData.digitData[142] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[4].close_fail   = true;
		else if (a == -1)
			graph1[4].close_fail   = true;
		else 
			graph1[4].close_fail   = false;

		a = (cacuData.digitData[142] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[4].open_allow   = true;
		else if (a == -1)
			graph1[4].open_allow   = true;
		else
			graph1[4].open_allow   = false;

		a = (cacuData.digitData[142] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[4].close_allow   = true;
		else if (a == -1)
			graph1[4].close_allow   = true;
		else
			graph1[4].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[4].enjoin = true;
		else if (a == -1)
			graph1[4].enjoin = true;
		else
			graph1[4].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[4].compelling = true;
		else if (a == -1)
			graph1[4].compelling = true;
		else
			graph1[4].compelling = false;

		// 右耙头冲水蝶阀Jwv8
		a = (cacuData.digitData[20] >> 0) & 0x01; // 打开状态
		if (a == 1)
			graph1[5].open_state = true;
		else if (a == -1)
			graph1[5].open_state = true;
		else
			graph1[5].open_state = false;

		a = (cacuData.digitData[20] >> 1) & 0x01; // 关闭状态
		if (a == 1)
			graph1[5].close_state = true;
		else if (a == -1)
			graph1[5].close_state = true;
		else
			graph1[5].close_state = false;

		a = (cacuData.digitData[143] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[5].open_false = true;
		else if (a == -1)
			graph1[5].open_false = true;
		else
			graph1[5].open_false = false;

		a = (cacuData.digitData[143] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[5].close_false = true;
		else if (a == -1)
			graph1[5].close_false = true;
		else
			graph1[5].close_false = false;

		a = (cacuData.digitData[143] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[5].opening = true;
		else if (a == -1)
			graph1[5].opening = true;
		else
			graph1[5].opening = false;

		a = (cacuData.digitData[143] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[5].closeing = true;
		else if (a == -1)
			graph1[5].closeing = true;
		else
			graph1[5].closeing = false;

		a = (cacuData.digitData[143] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[5].open_fail   = true;
		else if (a == -1)
			graph1[5].open_fail   = true;
		else
			graph1[5].open_fail   = false;

		a = (cacuData.digitData[143] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[5].close_fail   = true;
		else if (a == -1)
			graph1[5].close_fail   = true;
		else
			graph1[5].close_fail   = false;

		a = (cacuData.digitData[143] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[5].open_allow   = true;
		else if (a == -1)
			graph1[5].open_allow   = true;
		else
			graph1[5].open_allow   = false;

		a = (cacuData.digitData[143] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[5].close_allow   = true;
		else if (a == -1)
			graph1[5].close_allow   = true;
		else
			graph1[5].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[5].enjoin = true;
		else if (a == -1)
			graph1[5].enjoin = true;
		else
			graph1[5].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[5].compelling = true;
		else if (a == -1)
			graph1[5].compelling = true;
		else
			graph1[5].compelling = false;

		// 左泵泥舱冲水蝶阀Jwv9
		a = (cacuData.digitData[17] >> 2) & 0x01; // 打开状态
		if (a == 1)
			graph1[6].open_state = true;
		else if (a == -1)
			graph1[6].open_state = true;
		else
			graph1[6].open_state = false;

		a = (cacuData.digitData[17] >> 3) & 0x01; // 关闭状态
		if (a == 1)
			graph1[6].close_state = true;
		else if (a == -1)
			graph1[6].close_state = true;
		else
			graph1[6].close_state = false;

		a = (cacuData.digitData[144] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[6].open_false = true;
		else if (a == -1)
			graph1[6].open_false = true;
		else
			graph1[6].open_false = false;

		a = (cacuData.digitData[144] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[6].close_false = true;
		else if (a == -1)
			graph1[6].close_false = true;
		else
			graph1[6].close_false = false;

		a = (cacuData.digitData[144] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[6].opening = true;
		else if (a == -1)
			graph1[6].opening = true;
		else
			graph1[6].opening = false;

		a = (cacuData.digitData[144] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[6].closeing = true;
		else if (a == -1)
			graph1[6].closeing = true;
		else
			graph1[6].closeing = false;

		a = (cacuData.digitData[144] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[6].open_fail   = true;
		else if (a == -1)
			graph1[6].open_fail   = true;
		else
			graph1[6].open_fail   = false;

		a = (cacuData.digitData[144] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[6].close_fail   = true;
		else if (a == -1)
			graph1[6].close_fail   = true;
		else
			graph1[6].close_fail   = false;

		a = (cacuData.digitData[144] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[6].open_allow   = true;
		else if (a == -1)
			graph1[6].open_allow   = true;
		else
			graph1[6].open_allow   = false;

		a = (cacuData.digitData[144] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[6].close_allow   = true;
		else if (a == -1)
			graph1[6].close_allow   = true;
		else
			graph1[6].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[6].enjoin = true;
		else if (a == -1)
			graph1[6].enjoin = true;
		else
			graph1[6].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[6].compelling = true;
		else if (a == -1)
			graph1[6].compelling = true;
		else
			graph1[6].compelling = false;

		// 右泵泥舱冲水蝶阀Jwv10
		a = (cacuData.digitData[21] >> 0) & 0x01; // 打开状态
		if (a == 1)
			graph1[7].open_state = true;
		else if (a == -1)
			graph1[7].open_state = true;
		else
			graph1[7].open_state = false;

		a = (cacuData.digitData[21] >> 1) & 0x01; // 关闭状态
		if (a == 1)
			graph1[7].close_state = true;
		else if (a == -1)
			graph1[7].close_state = true;
		else
			graph1[7].close_state = false;

		a = (cacuData.digitData[145] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[7].open_false = true;
		else if (a == -1)
			graph1[7].open_false = true;
		else
			graph1[7].open_false = false;

		a = (cacuData.digitData[145] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[7].close_false = true;
		else if (a == -1)
			graph1[7].close_false = true;
		else
			graph1[7].close_false = false;

		a = (cacuData.digitData[145] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[7].opening = true;
		else if (a == -1)
			graph1[7].opening = true;
		else
			graph1[7].opening = false;

		a = (cacuData.digitData[145] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[7].closeing = true;
		else if (a == -1)
			graph1[7].closeing = true;
		else
			graph1[7].closeing = false;

		a = (cacuData.digitData[145] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[7].open_fail   = true;
		else if (a == -1)
			graph1[7].open_fail   = true;
		else
			graph1[7].open_fail   = false;

		a = (cacuData.digitData[145] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[7].close_fail   = true;
		else if (a == -1)
			graph1[7].close_fail   = true;
		else
			graph1[7].close_fail   = false;

		a = (cacuData.digitData[145] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[7].open_allow   = true;
		else if (a == -1)
			graph1[7].open_allow   = true;
		else
			graph1[7].open_allow   = false;

		a = (cacuData.digitData[145] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[7].close_allow   = true;
		else if (a == -1)
			graph1[7].close_allow   = true;
		else
			graph1[7].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[7].enjoin = true;
		else if (a == -1)
			graph1[7].enjoin = true;
		else
			graph1[7].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[7].compelling = true;
		else if (a == -1)
			graph1[7].compelling = true;
		else
			graph1[7].compelling = false;

		// #1&#2泥舱冲水蝶阀Jwv11
		a = (cacuData.digitData[28] >> 0) & 0x01; // 打开状态
		if (a == 1)
			graph1[8].open_state = true;
		else if (a == -1)
			graph1[8].open_state = true;
		else
			graph1[8].open_state = false;

		a = (cacuData.digitData[28] >> 1) & 0x01; // 关闭状态
		if (a == 1)
			graph1[8].close_state = true;
		else if (a == -1)
			graph1[8].close_state = true;
		else
			graph1[8].close_state = false;

		a = (cacuData.digitData[146] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[8].open_false = true;
		else if (a == -1)
			graph1[8].open_false = true;
		else
			graph1[8].open_false = false;

		a = (cacuData.digitData[146] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[8].close_false = true;
		else if (a == -1)
			graph1[8].close_false = true;
		else
			graph1[8].close_false = false;

		a = (cacuData.digitData[146] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[8].opening = true;
		else if (a == -1)
			graph1[8].opening = true;
		else
			graph1[8].opening = false;

		a = (cacuData.digitData[146] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[8].closeing = true;
		else if (a == -1)
			graph1[8].closeing = true;
		else
			graph1[8].closeing = false;

		a = (cacuData.digitData[146] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[8].open_fail   = true;
		else if (a == -1)
			graph1[8].open_fail   = true;
		else
			graph1[8].open_fail   = false;

		a = (cacuData.digitData[146] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[8].close_fail   = true;
		else if (a == -1)
			graph1[8].close_fail   = true;
		else
			graph1[8].close_fail   = false;

		a = (cacuData.digitData[146] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[8].open_allow   = true;
		else if (a == -1)
			graph1[8].open_allow   = true;
		else
			graph1[8].open_allow   = false;

		a = (cacuData.digitData[146] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[8].close_allow   = true;
		else if (a == -1)
			graph1[8].close_allow   = true;
		else
			graph1[8].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[8].enjoin = true;
		else if (a == -1)
			graph1[8].enjoin = true;
		else
			graph1[8].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[8].compelling = true;
		else if (a == -1)
			graph1[8].compelling = true;
		else
			graph1[8].compelling = false;

		// #3&#4泥舱冲水蝶阀Jwv12
		a = (cacuData.digitData[28] >> 2) & 0x01; // 打开状态
		if (a == 1)
			graph1[9].open_state = true;
		else if (a == -1)
			graph1[9].open_state = true;
		else
			graph1[9].open_state = false;

		a = (cacuData.digitData[28] >> 3) & 0x01; // 关闭状态
		if (a == 1)
			graph1[9].close_state = true;
		else if (a == -1)
			graph1[9].close_state = true;
		else
			graph1[9].close_state = false;

		a = (cacuData.digitData[147] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[9].open_false = true;
		else if (a == -1)
			graph1[9].open_false = true;
		else
			graph1[9].open_false = false;

		a = (cacuData.digitData[147] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[9].close_false = true;
		else if (a == -1)
			graph1[9].close_false = true;
		else
			graph1[9].close_false = false;

		a = (cacuData.digitData[147] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[9].opening = true;
		else if (a == -1)
			graph1[9].opening = true;
		else
			graph1[9].opening = false;

		a = (cacuData.digitData[147] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[9].closeing = true;
		else if (a == -1)
			graph1[9].closeing = true;
		else
			graph1[9].closeing = false;

		a = (cacuData.digitData[147] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[9].open_fail   = true;
		else if (a == -1)
			graph1[9].open_fail   = true;
		else
			graph1[9].open_fail   = false;

		a = (cacuData.digitData[147] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[9].close_fail   = true;
		else if (a == -1)
			graph1[9].close_fail   = true;
		else
			graph1[9].close_fail   = false;

		a = (cacuData.digitData[147] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[9].open_allow   = true;
		else if (a == -1)
			graph1[9].open_allow   = true;
		else
			graph1[9].open_allow   = false;

		a = (cacuData.digitData[147] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[9].close_allow   = true;
		else if (a == -1)
			graph1[9].close_allow   = true;
		else
			graph1[9].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[9].enjoin = true;
		else if (a == -1)
			graph1[9].enjoin = true;
		else
			graph1[9].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[9].compelling = true;
		else if (a == -1)
			graph1[9].compelling = true;
		else
			graph1[9].compelling = false;

		// #5&#6泥舱冲水蝶阀Jwv13
		a = (cacuData.digitData[28] >> 4) & 0x01; // 打开状态
		if (a == 1)
			graph1[10].open_state = true;
		else if (a == -1)
			graph1[10].open_state = true;
		else
			graph1[10].open_state = false;

		a = (cacuData.digitData[28] >> 5) & 0x01; // 关闭状态
		if (a == 1)
			graph1[10].close_state = true;
		else if (a == -1)
			graph1[10].close_state = true;
		else
			graph1[10].close_state = false;

		a = (cacuData.digitData[148] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[10].open_false = true;
		else if (a == -1)
			graph1[10].open_false = true;
		else
			graph1[10].open_false = false;

		a = (cacuData.digitData[148] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[10].close_false = true;
		else if (a == -1)
			graph1[10].close_false = true;
		else
			graph1[10].close_false = false;

		a = (cacuData.digitData[148] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[10].opening = true;
		else if (a == -1)
			graph1[10].opening = true;
		else
			graph1[10].opening = false;

		a = (cacuData.digitData[148] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[10].closeing = true;
		else if (a == -1)
			graph1[10].closeing = true;
		else
			graph1[10].closeing = false;

		a = (cacuData.digitData[148] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[10].open_fail   = true;
		else if (a == -1)
			graph1[10].open_fail   = true;
		else
			graph1[10].open_fail   = false;

		a = (cacuData.digitData[148] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[10].close_fail   = true;
		else if (a == -1)
			graph1[10].close_fail   = true;
		else
			graph1[10].close_fail   = false;

		a = (cacuData.digitData[148] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[10].open_allow   = true;
		else if (a == -1)
			graph1[10].open_allow   = true;
		else
			graph1[10].open_allow   = false;

		a = (cacuData.digitData[148] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[10].close_allow   = true;
		else if (a == -1)
			graph1[10].close_allow   = true;
		else
			graph1[10].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[10].enjoin = true;
		else if (a == -1)
			graph1[10].enjoin = true;
		else
			graph1[10].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[10].compelling = true;
		else if (a == -1)
			graph1[10].compelling = true;
		else
			graph1[10].compelling = false;

		// #7&#8泥舱冲水蝶阀Jwv14
		a = (cacuData.digitData[28] >> 6) & 0x01; // 打开状态
		if (a == 1)
			graph1[11].open_state = true;
		else if (a == -1)
			graph1[11].open_state = true;
		else
			graph1[11].open_state = false;

		a = (cacuData.digitData[28] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			graph1[11].close_state = true;
		else if (a == -1)
			graph1[11].close_state = true;
		else
			graph1[11].close_state = false;

		a = (cacuData.digitData[149] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[11].open_false = true;
		else if (a == -1)
			graph1[11].open_false = true;
		else
			graph1[11].open_false = false;

		a = (cacuData.digitData[149] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[11].close_false = true;
		else if (a == -1)
			graph1[11].close_false = true;
		else
			graph1[11].close_false = false;

		a = (cacuData.digitData[149] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[11].opening = true;
		else if (a == -1)
			graph1[11].opening = true;
		else
			graph1[11].opening = false;

		a = (cacuData.digitData[149] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[11].closeing = true;
		else if (a == -1)
			graph1[11].closeing = true;
		else
			graph1[11].closeing = false;

		a = (cacuData.digitData[149] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[11].open_fail   = true;
		else if (a == -1)
			graph1[11].open_fail   = true;
		else
			graph1[11].open_fail   = false;

		a = (cacuData.digitData[149] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[11].close_fail   = true;
		else if (a == -1)
			graph1[11].close_fail   = true;
		else
			graph1[11].close_fail   = false;

		a = (cacuData.digitData[149] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[11].open_allow   = true;
		else if (a == -1)
			graph1[11].open_allow   = true;
		else
			graph1[11].open_allow   = false;

		a = (cacuData.digitData[149] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[11].close_allow   = true;
		else if (a == -1)
			graph1[11].close_allow   = true;
		else
			graph1[11].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[11].enjoin = true;
		else if (a == -1)
			graph1[11].enjoin = true;
		else
			graph1[11].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[11].compelling = true;
		else if (a == -1)
			graph1[11].compelling = true;
		else
			graph1[11].compelling = false;

		// #9&#10泥舱冲水蝶阀Jwv15
		a = (cacuData.digitData[29] >> 0) & 0x01; // 打开状态
		if (a == 1)
			graph1[12].open_state = true;
		else if (a == -1)
			graph1[12].open_state = true;
		else
			graph1[12].open_state = false;

		a = (cacuData.digitData[29] >> 1) & 0x01; // 关闭状态
		if (a == 1)
			graph1[12].close_state = true;
		else if (a == -1)
			graph1[12].close_state = true;
		else
			graph1[12].close_state = false;

		a = (cacuData.digitData[150] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[12].open_false = true;
		else if (a == -1)
			graph1[12].open_false = true;
		else
			graph1[12].open_false = false;

		a = (cacuData.digitData[150] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[12].close_false = true;
		else if (a == -1)
			graph1[12].close_false = true;
		else
			graph1[12].close_false = false;

		a = (cacuData.digitData[150] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[12].opening = true;
		else if (a == -1)
			graph1[12].opening = true;
		else
			graph1[12].opening = false;

		a = (cacuData.digitData[150] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[12].closeing = true;
		else if (a == -1)
			graph1[12].closeing = true;
		else
			graph1[12].closeing = false;

		a = (cacuData.digitData[150] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[12].open_fail   = true;
		else if (a == -1)
			graph1[12].open_fail   = true;
		else
			graph1[12].open_fail   = false;

		a = (cacuData.digitData[150] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[12].close_fail   = true;
		else if (a == -1)
			graph1[12].close_fail   = true;
		else
			graph1[12].close_fail   = false;

		a = (cacuData.digitData[150] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[12].open_allow   = true;
		else if (a == -1)
			graph1[12].open_allow   = true;
		else
			graph1[12].open_allow   = false;

		a = (cacuData.digitData[150] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[12].close_allow   = true;
		else if (a == -1)
			graph1[12].close_allow   = true;
		else
			graph1[12].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[12].enjoin = true;
		else if (a == -1)
			graph1[12].enjoin = true;
		else
			graph1[12].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[12].compelling = true;
		else if (a == -1)
			graph1[12].compelling = true;
		else
			graph1[12].compelling = false;

		// #11&#12泥舱冲水蝶阀Jwv16
		a = (cacuData.digitData[29] >> 2) & 0x01; // 打开状态
		if (a == 1)
			graph1[13].open_state = true;
		else if (a == -1)
			graph1[13].open_state = true;
		else
			graph1[13].open_state = false;

		a = (cacuData.digitData[29] >> 3) & 0x01; // 关闭状态
		if (a == 1)
			graph1[13].close_state = true;
		else if (a == -1)
			graph1[13].close_state = true;
		else
			graph1[13].close_state = false;

		a = (cacuData.digitData[151] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[13].open_false = true;
		else if (a == -1)
			graph1[13].open_false = true;
		else
			graph1[13].open_false = false;

		a = (cacuData.digitData[151] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[13].close_false = true;
		else if (a == -1)
			graph1[13].close_false = true;
		else
			graph1[13].close_false = false;

		a = (cacuData.digitData[151] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[13].opening = true;
		else if (a == -1)
			graph1[13].opening = true;
		else
			graph1[13].opening = false;

		a = (cacuData.digitData[151] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[13].closeing = true;
		else if (a == -1)
			graph1[13].closeing = true;
		else
			graph1[13].closeing = false;

		a = (cacuData.digitData[151] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[13].open_fail   = true;
		else if (a == -1)
			graph1[13].open_fail   = true;
		else
			graph1[13].open_fail   = false;

		a = (cacuData.digitData[151] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[13].close_fail   = true;
		else if (a == -1)
			graph1[13].close_fail   = true;
		else
			graph1[13].close_fail   = false;

		a = (cacuData.digitData[151] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[13].open_allow   = true;
		else if (a == -1)
			graph1[13].open_allow   = true;
		else
			graph1[13].open_allow   = false;

		a = (cacuData.digitData[151] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[13].close_allow   = true;
		else if (a == -1)
			graph1[13].close_allow   = true;
		else
			graph1[13].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[13].enjoin = true;
		else if (a == -1)
			graph1[13].enjoin = true;
		else
			graph1[13].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[13].compelling = true;
		else if (a == -1)
			graph1[13].compelling = true;
		else
			graph1[13].compelling = false;

		// 左泵循环管蝶阀Jwv21
		a = (cacuData.digitData[18] >> 4) & 0x01; // 打开状态
		if (a == 1)
			graph1[14].open_state = true;
		else if (a == -1)
			graph1[14].open_state = true;
		else
			graph1[14].open_state = false;

		a = (cacuData.digitData[18] >> 5) & 0x01; // 关闭状态
		if (a == 1)
			graph1[14].close_state = true;
		else if (a == -1)
			graph1[14].close_state = true;
		else
			graph1[14].close_state = false;

		a = (cacuData.digitData[152] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[14].open_false = true;
		else if (a == -1)
			graph1[14].open_false = true;
		else
			graph1[14].open_false = false;

		a = (cacuData.digitData[152] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[14].close_false = true;
		else if (a == -1)
			graph1[14].close_false = true;
		else
			graph1[14].close_false = false;

		a = (cacuData.digitData[152] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[14].opening = true;
		else if (a == -1)
			graph1[14].opening = true;
		else
			graph1[14].opening = false;

		a = (cacuData.digitData[152] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[14].closeing = true;
		else if (a == -1)
			graph1[14].closeing = true;
		else
			graph1[14].closeing = false;

		a = (cacuData.digitData[152] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[14].open_fail   = true;
		else if (a == -1)
			graph1[14].open_fail   = true;
		else
			graph1[14].open_fail   = false;

		a = (cacuData.digitData[152] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[14].close_fail   = true;
		else if (a == -1)
			graph1[14].close_fail   = true;
		else
			graph1[14].close_fail   = false;

		a = (cacuData.digitData[152] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[14].open_allow   = true;
		else if (a == -1)
			graph1[14].open_allow   = true;
		else
			graph1[14].open_allow   = false;

		a = (cacuData.digitData[152] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[14].close_allow   = true;
		else if (a == -1)
			graph1[14].close_allow   = true;
		else
			graph1[14].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[14].enjoin = true;
		else if (a == -1)
			graph1[14].enjoin = true;
		else
			graph1[14].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[14].compelling = true;
		else if (a == -1)
			graph1[14].compelling = true;
		else
			graph1[14].compelling = false;

		// 右泵循环管蝶阀Jwv22
		a = (cacuData.digitData[21] >> 2) & 0x01; // 打开状态
		if (a == 1)
			graph1[15].open_state = true;
		else if (a == -1)
			graph1[15].open_state = true;
		else
			graph1[15].open_state = false;

		a = (cacuData.digitData[21] >> 3) & 0x01; // 关闭状态
		if (a == 1)
			graph1[15].close_state = true;
		else if (a == -1)
			graph1[15].close_state = true;
		else
			graph1[15].close_state = false;

		a = (cacuData.digitData[153] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[15].open_false = true;
		else if (a == -1)
			graph1[15].open_false = true;
		else
			graph1[15].open_false = false;

		a = (cacuData.digitData[153] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[15].close_false = true;
		else if (a == -1)
			graph1[15].close_false = true;
		else
			graph1[15].close_false = false;

		a = (cacuData.digitData[153] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[15].opening = true;
		else if (a == -1)
			graph1[15].opening = true;
		else
			graph1[15].opening = false;

		a = (cacuData.digitData[153] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[15].closeing = true;
		else if (a == -1)
			graph1[15].closeing = true;
		else
			graph1[15].closeing = false;

		a = (cacuData.digitData[153] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[15].open_fail   = true;
		else if (a == -1)
			graph1[15].open_fail   = true;
		else
			graph1[15].open_fail   = false;

		a = (cacuData.digitData[153] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[15].close_fail   = true;
		else if (a == -1)
			graph1[15].close_fail   = true;
		else
			graph1[15].close_fail   = false;

		a = (cacuData.digitData[153] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[15].open_allow   = true;
		else if (a == -1)
			graph1[15].open_allow   = true;
		else
			graph1[15].open_allow   = false;

		a = (cacuData.digitData[153] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[15].close_allow   = true;
		else if (a == -1)
			graph1[15].close_allow   = true;
		else
			graph1[15].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[15].enjoin = true;
		else if (a == -1)
			graph1[15].enjoin = true;
		else
			graph1[15].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[15].compelling = true;
		else if (a == -1)
			graph1[15].compelling = true;
		else
			graph1[15].compelling = false;

		// 抽舱引水闸阀Gv4
		a = (cacuData.digitData[29] >> 4) & 0x01; // 打开状态
		if (a == 1)
			graph1[28].open_state = true;
		else if (a == -1)
			graph1[28].open_state = true;
		else
			graph1[28].open_state = false;

		a = (cacuData.digitData[29] >> 5) & 0x01; // 关闭状态
		if (a == 1)
			graph1[28].close_state = true;
		else if (a == -1)
			graph1[28].close_state = true;
		else
			graph1[28].close_state = false;

		a = (cacuData.digitData[165] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[28].open_false = true;
		else if (a == -1)
			graph1[28].open_false = true;
		else
			graph1[28].open_false = false;

		a = (cacuData.digitData[165] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[28].close_false = true;
		else if (a == -1)
			graph1[28].close_false = true;
		else
			graph1[28].close_false = false;

		a = (cacuData.digitData[165] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[28].opening = true;
		else if (a == -1)
			graph1[28].opening = true;
		else
			graph1[28].opening = false;

		a = (cacuData.digitData[165] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[28].closeing = true;
		else if (a == -1)
			graph1[28].closeing = true;
		else
			graph1[28].closeing = false;

		a = (cacuData.digitData[165] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[28].open_fail   = true;
		else if (a == -1)
			graph1[28].open_fail   = true;
		else
			graph1[28].open_fail   = false;

		a = (cacuData.digitData[165] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[28].close_fail   = true;
		else if (a == -1)
			graph1[28].close_fail   = true;
		else
			graph1[28].close_fail   = false;

		a = (cacuData.digitData[165] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[28].open_allow   = true;
		else if (a == -1)
			graph1[28].open_allow   = true;
		else
			graph1[28].open_allow   = false;

		a = (cacuData.digitData[165] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[28].close_allow   = true;
		else if (a == -1)
			graph1[28].close_allow   = true;
		else
			graph1[28].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[28].enjoin = true;
		else if (a == -1)
			graph1[28].enjoin = true;
		else
			graph1[28].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[28].compelling = true;
		else if (a == -1)
			graph1[28].compelling = true;
		else
			graph1[28].compelling = false;

		// 左吸口闸阀Gv11
		a = (cacuData.digitData[15] >> 4) & 0x01; // 打开状态
		if (a == 1)
			graph1[29].open_state = true;
		else if (a == -1)
			graph1[29].open_state = true;
		else
			graph1[29].open_state = false;

		a = (cacuData.digitData[15] >> 5) & 0x01; // 关闭状态
		if (a == 1)
			graph1[29].close_state = true;
		else if (a == -1)
			graph1[29].close_state = true;
		else
			graph1[29].close_state = false;

		a = (cacuData.digitData[166] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[29].open_false = true;
		else if (a == -1)
			graph1[29].open_false = true;
		else
			graph1[29].open_false = false;

		a = (cacuData.digitData[166] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[29].close_false = true;
		else if (a == -1)
			graph1[29].close_false = true;
		else
			graph1[29].close_false = false;

		a = (cacuData.digitData[166] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[29].opening = true;
		else if (a == -1)
			graph1[29].opening = true;
		else
			graph1[29].opening = false;

		a = (cacuData.digitData[166] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[29].closeing = true;
		else if (a == -1)
			graph1[29].closeing = true;
		else
			graph1[29].closeing = false;

		a = (cacuData.digitData[166] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[29].open_fail   = true;
		else if (a == -1)
			graph1[29].open_fail   = true;
		else
			graph1[29].open_fail   = false;

		a = (cacuData.digitData[166] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[29].close_fail   = true;
		else if (a == -1)
			graph1[29].close_fail   = true;
		else
			graph1[29].close_fail   = false;

		a = (cacuData.digitData[166] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[29].open_allow   = true;
		else if (a == -1)
			graph1[29].open_allow   = true;
		else
			graph1[29].open_allow   = false;

		a = (cacuData.digitData[166] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[29].close_allow   = true;
		else if (a == -1)
			graph1[29].close_allow   = true;
		else
			graph1[29].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[29].enjoin = true;
		else if (a == -1)
			graph1[29].enjoin = true;
		else
			graph1[29].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[29].compelling = true;
		else if (a == -1)
			graph1[29].compelling = true;
		else
			graph1[29].compelling = false;

		// 右舷吸口闸阀Gv12
		a = (cacuData.digitData[18] >> 6) & 0x01; // 打开状态
		if (a == 1)
			graph1[30].open_state = true;
		else if (a == -1)
			graph1[30].open_state = true;
		else
			graph1[30].open_state = false;

		a = (cacuData.digitData[18] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			graph1[30].close_state = true;
		else if (a == -1)
			graph1[30].close_state = true;
		else
			graph1[30].close_state = false;

		a = (cacuData.digitData[167] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[30].open_false = true;
		else if (a == -1)
			graph1[30].open_false = true;
		else
			graph1[30].open_false = false;

		a = (cacuData.digitData[167] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[30].close_false = true;
		else if (a == -1)
			graph1[30].close_false = true;
		else
			graph1[30].close_false = false;

		a = (cacuData.digitData[167] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[30].opening = true;
		else if (a == -1)
			graph1[30].opening = true;
		else
			graph1[30].opening = false;

		a = (cacuData.digitData[167] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[30].closeing = true;
		else if (a == -1)
			graph1[30].closeing = true;
		else
			graph1[30].closeing = false;

		a = (cacuData.digitData[167] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[30].open_fail   = true;
		else if (a == -1)
			graph1[30].open_fail   = true;
		else
			graph1[30].open_fail   = false;

		a = (cacuData.digitData[167] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[30].close_fail   = true;
		else if (a == -1)
			graph1[30].close_fail   = true;
		else
			graph1[30].close_fail   = false;

		a = (cacuData.digitData[167] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[30].open_allow   = true;
		else if (a == -1)
			graph1[30].open_allow   = true;
		else
			graph1[30].open_allow   = false;

		a = (cacuData.digitData[167] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[30].close_allow   = true;
		else if (a == -1)
			graph1[30].close_allow   = true;
		else
			graph1[30].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[30].enjoin = true;
		else if (a == -1)
			graph1[30].enjoin = true;
		else
			graph1[30].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[30].compelling = true;
		else if (a == -1)
			graph1[30].compelling = true;
		else
			graph1[30].compelling = false;

		// 抽舱总闸阀Gv13
		a = (cacuData.digitData[15] >> 6) & 0x01; // 打开状态
		if (a == 1)
			graph1[31].open_state = true;
		else if (a == -1)
			graph1[31].open_state = true;
		else
			graph1[31].open_state = false;

		a = (cacuData.digitData[15] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			graph1[31].close_state = true;
		else if (a == -1)
			graph1[31].close_state = true;
		else
			graph1[31].close_state = false;

		a = (cacuData.digitData[168] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[31].open_false = true;
		else if (a == -1)
			graph1[31].open_false = true;
		else
			graph1[31].open_false = false;

		a = (cacuData.digitData[168] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[31].close_false = true;
		else if (a == -1)
			graph1[31].close_false = true;
		else
			graph1[31].close_false = false;

		a = (cacuData.digitData[168] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[31].opening = true;
		else if (a == -1)
			graph1[31].opening = true;
		else
			graph1[31].opening = false;

		a = (cacuData.digitData[168] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[31].closeing = true;
		else if (a == -1)
			graph1[31].closeing = true;
		else
			graph1[31].closeing = false;

		a = (cacuData.digitData[168] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[31].open_fail   = true;
		else if (a == -1)
			graph1[31].open_fail   = true;
		else
			graph1[31].open_fail   = false;

		a = (cacuData.digitData[168] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[31].close_fail   = true;
		else if (a == -1)
			graph1[31].close_fail   = true;
		else
			graph1[31].close_fail   = false;

		a = (cacuData.digitData[168] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[31].open_allow   = true;
		else if (a == -1)
			graph1[31].open_allow   = true;
		else
			graph1[31].open_allow   = false;

		a = (cacuData.digitData[168] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[31].close_allow   = true;
		else if (a == -1)
			graph1[31].close_allow   = true;
		else
			graph1[31].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[31].enjoin = true;
		else if (a == -1)
			graph1[31].enjoin = true;
		else
			graph1[31].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[31].compelling = true;
		else if (a == -1)
			graph1[31].compelling = true;
		else
			graph1[31].compelling = false;

		// 平衡装舱闸阀Gv18
		a = (cacuData.digitData[27] >> 6) & 0x01; // 打开状态
		if (a == 1)
			graph1[32].open_state = true;
		else if (a == -1)
			graph1[32].open_state = true;
		else
			graph1[32].open_state = false;

		a = (cacuData.digitData[27] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			graph1[32].close_state = true;
		else if (a == -1)
			graph1[32].close_state = true;
		else
			graph1[32].close_state = false;

		a = (cacuData.digitData[169] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[32].open_false = true;
		else if (a == -1)
			graph1[32].open_false = true;
		else
			graph1[32].open_false = false;

		a = (cacuData.digitData[169] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[32].close_false = true;
		else if (a == -1)
			graph1[32].close_false = true;
		else
			graph1[32].close_false = false;

		a = (cacuData.digitData[169] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[32].opening = true;
		else if (a == -1)
			graph1[32].opening = true;
		else
			graph1[32].opening = false;

		a = (cacuData.digitData[169] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[32].closeing = true;
		else if (a == -1)
			graph1[32].closeing = true;
		else
			graph1[32].closeing = false;

		a = (cacuData.digitData[169] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[32].open_fail   = true;
		else if (a == -1)
			graph1[32].open_fail   = true;
		else
			graph1[32].open_fail   = false;

		a = (cacuData.digitData[169] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[32].close_fail   = true;
		else if (a == -1)
			graph1[32].close_fail   = true;
		else
			graph1[32].close_fail   = false;

		a = (cacuData.digitData[169] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[32].open_allow   = true;
		else if (a == -1)
			graph1[32].open_allow   = true;
		else
			graph1[32].open_allow   = false;

		a = (cacuData.digitData[169] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[32].close_allow   = true;
		else if (a == -1)
			graph1[32].close_allow   = true;
		else
			graph1[32].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[32].enjoin = true;
		else if (a == -1)
			graph1[32].enjoin = true;
		else
			graph1[32].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[32].compelling = true;
		else if (a == -1)
			graph1[32].compelling = true;
		else
			graph1[32].compelling = false;

		// 左泵串联右泵闸阀Gv3
		a = (cacuData.digitData[16] >> 0) & 0x01; // 打开状态
		if (a == 1)
			graph1[33].open_state = true;
		else if (a == -1)
			graph1[33].open_state = true;
		else
			graph1[33].open_state = false;

		a = (cacuData.digitData[16] >> 1) & 0x01; // 关闭状态
		if (a == 1)
			graph1[33].close_state = true;
		else if (a == -1)
			graph1[33].close_state = true;
		else
			graph1[33].close_state = false;

		a = (cacuData.digitData[170] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[33].open_false = true;
		else if (a == -1)
			graph1[33].open_false = true;
		else
			graph1[33].open_false = false;

		a = (cacuData.digitData[170] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[33].close_false = true;
		else if (a == -1)
			graph1[33].close_false = true;
		else
			graph1[33].close_false = false;

		a = (cacuData.digitData[170] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[33].opening = true;
		else if (a == -1)
			graph1[33].opening = true;
		else
			graph1[33].opening = false;

		a = (cacuData.digitData[170] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[33].closeing = true;
		else if (a == -1)
			graph1[33].closeing = true;
		else
			graph1[33].closeing = false;

		a = (cacuData.digitData[170] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[33].open_fail   = true;
		else if (a == -1)
			graph1[33].open_fail   = true;
		else
			graph1[33].open_fail   = false;

		a = (cacuData.digitData[170] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[33].close_fail   = true;
		else if (a == -1)
			graph1[33].close_fail   = true;
		else
			graph1[33].close_fail   = false;

		a = (cacuData.digitData[170] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[33].open_allow   = true;
		else if (a == -1)
			graph1[33].open_allow   = true;
		else
			graph1[33].open_allow   = false;

		a = (cacuData.digitData[170] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[33].close_allow   = true;
		else if (a == -1)
			graph1[33].close_allow   = true;
		else
			graph1[33].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[33].enjoin = true;
		else if (a == -1)
			graph1[33].enjoin = true;
		else
			graph1[33].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[33].compelling = true;
		else if (a == -1)
			graph1[33].compelling = true;
		else
			graph1[33].compelling = false;

		// 左低浓度排放闸阀Gv7
		a = (cacuData.digitData[16] >> 2) & 0x01; // 打开状态
		if (a == 1)
			graph1[34].open_state = true;
		else if (a == -1)
			graph1[34].open_state = true;
		else
			graph1[34].open_state = false;

		a = (cacuData.digitData[16] >> 3) & 0x01; // 关闭状态
		if (a == 1)
			graph1[34].close_state = true;
		else if (a == -1)
			graph1[34].close_state = true;
		else
			graph1[34].close_state = false;

		a = (cacuData.digitData[171] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[34].open_false = true;
		else if (a == -1)
			graph1[34].open_false = true;
		else
			graph1[34].open_false = false;

		a = (cacuData.digitData[171] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[34].close_false = true;
		else if (a == -1)
			graph1[34].close_false = true;
		else
			graph1[34].close_false = false;

		a = (cacuData.digitData[171] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[34].opening = true;
		else if (a == -1)
			graph1[34].opening = true;
		else
			graph1[34].opening = false;

		a = (cacuData.digitData[171] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[34].closeing = true;
		else if (a == -1)
			graph1[34].closeing = true;
		else
			graph1[34].closeing = false;

		a = (cacuData.digitData[171] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[34].open_fail   = true;
		else if (a == -1)
			graph1[34].open_fail   = true;
		else
			graph1[34].open_fail   = false;

		a = (cacuData.digitData[171] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[34].close_fail   = true;
		else if (a == -1)
			graph1[34].close_fail   = true;
		else
			graph1[34].close_fail   = false;

		a = (cacuData.digitData[171] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[34].open_allow   = true;
		else if (a == -1)
			graph1[34].open_allow   = true;
		else
			graph1[34].open_allow   = false;

		a = (cacuData.digitData[171] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[34].close_allow   = true;
		else if (a == -1)
			graph1[34].close_allow   = true;
		else
			graph1[34].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[34].enjoin = true;
		else if (a == -1)
			graph1[34].enjoin = true;
		else
			graph1[34].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[34].compelling = true;
		else if (a == -1)
			graph1[34].compelling = true;
		else
			graph1[34].compelling = false;

		// 右低浓度排放闸阀Gv8
		a = (cacuData.digitData[19] >> 0) & 0x01; // 打开状态
		if (a == 1)
			graph1[35].open_state = true;
		else if (a == -1)
			graph1[35].open_state = true;
		else
			graph1[35].open_state = false;

		a = (cacuData.digitData[19] >> 1) & 0x01; // 关闭状态
		if (a == 1)
			graph1[35].close_state = true;
		else if (a == -1)
			graph1[35].close_state = true;
		else
			graph1[35].close_state = false;

		a = (cacuData.digitData[172] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[35].open_false = true;
		else if (a == -1)
			graph1[35].open_false = true;
		else
			graph1[35].open_false = false;

		a = (cacuData.digitData[172] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[35].close_false = true;
		else if (a == -1)
			graph1[35].close_false = true;
		else
			graph1[35].close_false = false;

		a = (cacuData.digitData[172] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[35].opening = true;
		else if (a == -1)
			graph1[35].opening = true;
		else
			graph1[35].opening = false;

		a = (cacuData.digitData[172] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[35].closeing = true;
		else if (a == -1)
			graph1[35].closeing = true;
		else
			graph1[35].closeing = false;

		a = (cacuData.digitData[172] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[35].open_fail   = true;
		else if (a == -1)
			graph1[35].open_fail   = true;
		else
			graph1[35].open_fail   = false;

		a = (cacuData.digitData[172] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[35].close_fail   = true;
		else if (a == -1)
			graph1[35].close_fail   = true;
		else
			graph1[35].close_fail   = false;

		a = (cacuData.digitData[172] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[35].open_allow   = true;
		else if (a == -1)
			graph1[35].open_allow   = true;
		else
			graph1[35].open_allow   = false;

		a = (cacuData.digitData[172] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[35].close_allow   = true;
		else if (a == -1)
			graph1[35].close_allow   = true;
		else
			graph1[35].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[35].enjoin = true;
		else if (a == -1)
			graph1[35].enjoin = true;
		else
			graph1[35].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[35].compelling = true;
		else if (a == -1)
			graph1[35].compelling = true;
		else
			graph1[35].compelling = false;

		// 左泵装舱闸阀Gv9
		a = (cacuData.digitData[16] >> 4) & 0x01; // 打开状态
		if (a == 1)
			graph1[36].open_state = true;
		else if (a == -1)
			graph1[36].open_state = true;
		else
			graph1[36].open_state = false;

		a = (cacuData.digitData[16] >> 5) & 0x01; // 关闭状态
		if (a == 1)
			graph1[36].close_state = true;
		else if (a == -1)
			graph1[36].close_state = true;
		else
			graph1[36].close_state = false;

		a = (cacuData.digitData[173] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[36].open_false = true;
		else if (a == -1)
			graph1[36].open_false = true;
		else
			graph1[36].open_false = false;

		a = (cacuData.digitData[173] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[36].close_false = true;
		else if (a == -1)
			graph1[36].close_false = true;
		else
			graph1[36].close_false = false;

		a = (cacuData.digitData[173] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[36].opening = true;
		else if (a == -1)
			graph1[36].opening = true;
		else
			graph1[36].opening = false;

		a = (cacuData.digitData[173] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[36].closeing = true;
		else if (a == -1)
			graph1[36].closeing = true;
		else
			graph1[36].closeing = false;

		a = (cacuData.digitData[173] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[36].open_fail   = true;
		else if (a == -1)
			graph1[36].open_fail   = true;
		else
			graph1[36].open_fail   = false;

		a = (cacuData.digitData[173] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[36].close_fail   = true;
		else if (a == -1)
			graph1[36].close_fail   = true;
		else
			graph1[36].close_fail   = false;

		a = (cacuData.digitData[173] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[36].open_allow   = true;
		else if (a == -1)
			graph1[36].open_allow   = true;
		else
			graph1[36].open_allow   = false;

		a = (cacuData.digitData[173] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[36].close_allow   = true;
		else if (a == -1)
			graph1[36].close_allow   = true;
		else
			graph1[36].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[36].enjoin = true;
		else if (a == -1)
			graph1[36].enjoin = true;
		else
			graph1[36].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[36].compelling = true;
		else if (a == -1)
			graph1[36].compelling = true;
		else
			graph1[36].compelling = false;

		// 右泵装舱闸阀Gv10
		a = (cacuData.digitData[19] >> 2) & 0x01; // 打开状态
		if (a == 1)
			graph1[37].open_state = true;
		else if (a == -1)
			graph1[37].open_state = true;
		else
			graph1[37].open_state = false;

		a = (cacuData.digitData[19] >> 3) & 0x01; // 关闭状态
		if (a == 1)
			graph1[37].close_state = true;
		else if (a == -1)
			graph1[37].close_state = true;
		else
			graph1[37].close_state = false;

		a = (cacuData.digitData[174] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[37].open_false = true;
		else if (a == -1)
			graph1[37].open_false = true;
		else
			graph1[37].open_false = false;

		a = (cacuData.digitData[174] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[37].close_false = true;
		else if (a == -1)
			graph1[37].close_false = true;
		else
			graph1[37].close_false = false;

		a = (cacuData.digitData[174] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[37].opening = true;
		else if (a == -1)
			graph1[37].opening = true;
		else
			graph1[37].opening = false;

		a = (cacuData.digitData[174] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[37].closeing = true;
		else if (a == -1)
			graph1[37].closeing = true;
		else
			graph1[37].closeing = false;

		a = (cacuData.digitData[174] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[37].open_fail   = true;
		else if (a == -1)
			graph1[37].open_fail   = true;
		else
			graph1[37].open_fail   = false;

		a = (cacuData.digitData[174] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[37].close_fail   = true;
		else if (a == -1)
			graph1[37].close_fail   = true;
		else
			graph1[37].close_fail   = false;

		a = (cacuData.digitData[174] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[37].open_allow   = true;
		else if (a == -1)
			graph1[37].open_allow   = true;
		else
			graph1[37].open_allow   = false;

		a = (cacuData.digitData[174] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[37].close_allow   = true;
		else if (a == -1)
			graph1[37].close_allow   = true;
		else
			graph1[37].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[37].enjoin = true;
		else if (a == -1)
			graph1[37].enjoin = true;
		else
			graph1[37].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[37].compelling = true;
		else if (a == -1)
			graph1[37].compelling = true;
		else
			graph1[37].compelling = false;

		// 左后装舱闸阀Gv16 
		a = (cacuData.digitData[25] >> 2) & 0x01; // 打开状态
		if (a == 1)
			graph1[38].open_state = true;
		else if (a == -1)
			graph1[38].open_state = true;
		else
			graph1[38].open_state = false;

		a = (cacuData.digitData[25] >> 3) & 0x01; // 关闭状态
		if (a == 1)
			graph1[38].close_state = true;
		else if (a == -1)
			graph1[38].close_state = true;
		else
			graph1[38].close_state = false;

		a = (cacuData.digitData[175] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[38].open_false = true;
		else if (a == -1)
			graph1[38].open_false = true;
		else
			graph1[38].open_false = false;

		a = (cacuData.digitData[175] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[38].close_false = true;
		else if (a == -1)
			graph1[38].close_false = true;
		else
			graph1[38].close_false = false;

		a = (cacuData.digitData[175] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[38].opening = true;
		else if (a == -1)
			graph1[38].opening = true;
		else
			graph1[38].opening = false;

		a = (cacuData.digitData[175] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[38].closeing = true;
		else if (a == -1)
			graph1[38].closeing = true;
		else
			graph1[38].closeing = false;

		a = (cacuData.digitData[175] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[38].open_fail   = true;
		else if (a == -1)
			graph1[38].open_fail   = true;
		else
			graph1[38].open_fail   = false;

		a = (cacuData.digitData[175] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[38].close_fail   = true;
		else if (a == -1)
			graph1[38].close_fail   = true;
		else
			graph1[38].close_fail   = false;

		a = (cacuData.digitData[175] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[38].open_allow   = true;
		else if (a == -1)
			graph1[38].open_allow   = true;
		else
			graph1[38].open_allow   = false;

		a = (cacuData.digitData[175] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[38].close_allow   = true;
		else if (a == -1)
			graph1[38].close_allow   = true;
		else
			graph1[38].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[38].enjoin = true;
		else if (a == -1)
			graph1[38].enjoin = true;
		else
			graph1[38].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[38].compelling = true;
		else if (a == -1)
			graph1[38].compelling = true;
		else
			graph1[38].compelling = false;

		// 右后装舱闸阀Gv17 
		a = (cacuData.digitData[26] >> 6) & 0x01; // 打开状态
		if (a == 1)
			graph1[39].open_state = true;
		else if (a == -1)
			graph1[39].open_state = true;
		else
			graph1[39].open_state = false;

		a = (cacuData.digitData[26] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			graph1[39].close_state = true;
		else if (a == -1)
			graph1[39].close_state = true;
		else
			graph1[39].close_state = false;

		a = (cacuData.digitData[176] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[39].open_false = true;
		else if (a == -1)
			graph1[39].open_false = true;
		else
			graph1[39].open_false = false;

		a = (cacuData.digitData[176] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[39].close_false = true;
		else if (a == -1)
			graph1[39].close_false = true;
		else
			graph1[39].close_false = false;

		a = (cacuData.digitData[176] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[39].opening = true;
		else if (a == -1)
			graph1[39].opening = true;
		else
			graph1[39].opening = false;

		a = (cacuData.digitData[176] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[39].closeing = true;
		else if (a == -1)
			graph1[39].closeing = true;
		else
			graph1[39].closeing = false;

		a = (cacuData.digitData[176] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[39].open_fail   = true;
		else if (a == -1)
			graph1[39].open_fail   = true;
		else
			graph1[39].open_fail   = false;

		a = (cacuData.digitData[176] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[39].close_fail   = true;
		else if (a == -1)
			graph1[39].close_fail   = true;
		else
			graph1[39].close_fail   = false;

		a = (cacuData.digitData[176] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[39].open_allow   = true;
		else if (a == -1)
			graph1[39].open_allow   = true;
		else
			graph1[39].open_allow   = false;

		a = (cacuData.digitData[176] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[39].close_allow   = true;
		else if (a == -1)
			graph1[39].close_allow   = true;
		else
			graph1[39].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[39].enjoin = true;
		else if (a == -1)
			graph1[39].enjoin = true;
		else
			graph1[39].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[39].compelling = true;
		else if (a == -1)
			graph1[39].compelling = true;
		else
			graph1[39].compelling = false;

		// 左舯装舱闸阀Gv14 
		a = (cacuData.digitData[22] >> 2) & 0x01; // 打开状态
		if (a == 1)
			graph1[40].open_state = true;
		else if (a == -1)
			graph1[40].open_state = true;
		else
			graph1[40].open_state = false;

		a = (cacuData.digitData[22] >> 3) & 0x01; // 关闭状态
		if (a == 1)
			graph1[40].close_state = true;
		else if (a == -1)
			graph1[40].close_state = true;
		else
			graph1[40].close_state = false;

		a = (cacuData.digitData[177] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[40].open_false = true;
		else if (a == -1)
			graph1[40].open_false = true;
		else
			graph1[40].open_false = false;

		a = (cacuData.digitData[177] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[40].close_false = true;
		else if (a == -1)
			graph1[40].close_false = true;
		else
			graph1[40].close_false = false;

		a = (cacuData.digitData[177] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[40].opening = true;
		else if (a == -1)
			graph1[40].opening = true;
		else
			graph1[40].opening = false;

		a = (cacuData.digitData[177] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[40].closeing = true;
		else if (a == -1)
			graph1[40].closeing = true;
		else
			graph1[40].closeing = false;

		a = (cacuData.digitData[177] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[40].open_fail   = true;
		else if (a == -1)
			graph1[40].open_fail   = true;
		else
			graph1[40].open_fail   = false;

		a = (cacuData.digitData[177] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[40].close_fail   = true;
		else if (a == -1)
			graph1[40].close_fail   = true;
		else
			graph1[40].close_fail   = false;

		a = (cacuData.digitData[177] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[40].open_allow   = true;
		else if (a == -1)
			graph1[40].open_allow   = true;
		else
			graph1[40].open_allow   = false;

		a = (cacuData.digitData[177] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[40].close_allow   = true;
		else if (a == -1)
			graph1[40].close_allow   = true;
		else
			graph1[40].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[40].enjoin = true;
		else if (a == -1)
			graph1[40].enjoin = true;
		else
			graph1[40].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[40].compelling = true;
		else if (a == -1)
			graph1[40].compelling = true;
		else
			graph1[40].compelling = false;

		// 右舯装舱闸阀Gv15 
		a = (cacuData.digitData[23] >> 6) & 0x01; // 打开状态
		if (a == 1)
			graph1[41].open_state = true;
		else if (a == -1)
			graph1[41].open_state = true;
		else
			graph1[41].open_state = false;

		a = (cacuData.digitData[23] >> 7) & 0x01; // 关闭状态
		if (a == 1)
			graph1[41].close_state = true;
		else if (a == -1)
			graph1[41].close_state = true;
		else
			graph1[41].close_state = false;

		a = (cacuData.digitData[178] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[41].open_false = true;
		else if (a == -1)
			graph1[41].open_false = true;
		else
			graph1[41].open_false = false;

		a = (cacuData.digitData[178] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[41].close_false = true;
		else if (a == -1)
			graph1[41].close_false = true;
		else
			graph1[41].close_false = false;

		a = (cacuData.digitData[178] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[41].opening = true;
		else if (a == -1)
			graph1[41].opening = true;
		else
			graph1[41].opening = false;

		a = (cacuData.digitData[178] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[41].closeing = true;
		else if (a == -1)
			graph1[41].closeing = true;
		else
			graph1[41].closeing = false;

		a = (cacuData.digitData[178] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[41].open_fail   = true;
		else if (a == -1)
			graph1[41].open_fail   = true;
		else
			graph1[41].open_fail   = false;

		a = (cacuData.digitData[178] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[41].close_fail   = true;
		else if (a == -1)
			graph1[41].close_fail   = true;
		else
			graph1[41].close_fail   = false;

		a = (cacuData.digitData[178] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[41].open_allow   = true;
		else if (a == -1)
			graph1[41].open_allow   = true;
		else
			graph1[41].open_allow   = false;

		a = (cacuData.digitData[178] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[41].close_allow   = true;
		else if (a == -1)
			graph1[41].close_allow   = true;
		else
			graph1[41].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[41].enjoin = true;
		else if (a == -1)
			graph1[41].enjoin = true;
		else
			graph1[41].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[41].compelling = true;
		else if (a == -1)
			graph1[41].compelling = true;
		else
			graph1[41].compelling = false;

		// 左泵排岸闸阀Gv5
		a = (cacuData.digitData[15] >> 0) & 0x01; // 打开状态
		if (a == 1)
			graph1[42].open_state = true;
		else if (a == -1)
			graph1[42].open_state = true;
		else
			graph1[42].open_state = false;

		a = (cacuData.digitData[15] >> 1) & 0x01; // 关闭状态
		if (a == 1)
			graph1[42].close_state = true;
		else if (a == -1)
			graph1[42].close_state = true;
		else
			graph1[42].close_state = false;

		a = (cacuData.digitData[179] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[42].open_false = true;
		else if (a == -1)
			graph1[42].open_false = true;
		else
			graph1[42].open_false = false;

		a = (cacuData.digitData[179] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[42].close_false = true;
		else if (a == -1)
			graph1[42].close_false = true;
		else
			graph1[42].close_false = false;

		a = (cacuData.digitData[179] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[42].opening = true;
		else if (a == -1)
			graph1[42].opening = true;
		else
			graph1[42].opening = false;

		a = (cacuData.digitData[179] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[42].closeing = true;
		else if (a == -1)
			graph1[42].closeing = true;
		else
			graph1[42].closeing = false;

		a = (cacuData.digitData[179] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[42].open_fail   = true;
		else if (a == -1)
			graph1[42].open_fail   = true;
		else
			graph1[42].open_fail   = false;

		a = (cacuData.digitData[179] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[42].close_fail   = true;
		else if (a == -1)
			graph1[42].close_fail   = true;
		else
			graph1[42].close_fail   = false;

		a = (cacuData.digitData[179] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[42].open_allow   = true;
		else if (a == -1)
			graph1[42].open_allow   = true;
		else
			graph1[42].open_allow   = false;

		a = (cacuData.digitData[179] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[42].close_allow   = true;
		else if (a == -1)
			graph1[42].close_allow   = true;
		else
			graph1[42].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[42].enjoin = true;
		else if (a == -1)
			graph1[42].enjoin = true;
		else
			graph1[42].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[42].compelling = true;
		else if (a == -1)
			graph1[42].compelling = true;
		else
			graph1[42].compelling = false;

		// 右泵排岸闸阀Gv6
		a = (cacuData.digitData[15] >> 2) & 0x01; // 打开状态
		if (a == 1)
			graph1[43].open_state = true;
		else if (a == -1)
			graph1[43].open_state = true;
		else
			graph1[43].open_state = false;

		a = (cacuData.digitData[15] >> 3) & 0x01; // 关闭状态
		if (a == 1)
			graph1[43].close_state = true;
		else if (a == -1)
			graph1[43].close_state = true;
		else
			graph1[43].close_state = false;

		a = (cacuData.digitData[180] >> 6) & 0x01; // 假开
		if (a == 1)
			graph1[43].open_false = true;
		else if (a == -1)
			graph1[43].open_false = true;
		else
			graph1[43].open_false = false;

		a = (cacuData.digitData[180] >> 7) & 0x01; // 假关
		if (a == 1)
			graph1[43].close_false = true;
		else if (a == -1)
			graph1[43].close_false = true;
		else
			graph1[43].close_false = false;

		a = (cacuData.digitData[180] >> 0) & 0x01; // 正在打开
		if (a == 1)
			graph1[43].opening = true;
		else if (a == -1)
			graph1[43].opening = true;
		else
			graph1[43].opening = false;

		a = (cacuData.digitData[180] >> 1) & 0x01; // 正在关闭
		if (a == 1)
			graph1[43].closeing = true;
		else if (a == -1)
			graph1[43].closeing = true;
		else
			graph1[43].closeing = false;

		a = (cacuData.digitData[180] >> 2) & 0x01; // 打开失败
		if (a == 1)
			graph1[43].open_fail   = true;
		else if (a == -1)
			graph1[43].open_fail   = true;
		else
			graph1[43].open_fail   = false;

		a = (cacuData.digitData[180] >> 3) & 0x01; // 关闭失败
		if (a == 1)
			graph1[43].close_fail   = true;
		else if (a == -1)
			graph1[43].close_fail   = true;
		else
			graph1[43].close_fail   = false;

		a = (cacuData.digitData[180] >> 4) & 0x01; // 打开条件成立
		if (a == 1)
			graph1[43].open_allow   = true;
		else if (a == -1)
			graph1[43].open_allow   = true;
		else
			graph1[43].open_allow   = false;

		a = (cacuData.digitData[180] >> 5) & 0x01; // 关闭条件成立
		if (a == 1)
			graph1[43].close_allow   = true;
		else if (a == -1)
			graph1[43].close_allow   = true;
		else
			graph1[43].close_allow   = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 禁止使用
		if (a == 1)
			graph1[43].enjoin = true;
		else if (a == -1)
			graph1[43].enjoin = true;
		else
			graph1[43].enjoin = false;
		
		a = (cacuData.digitData[1] >> 7) & 0x01; // 被强制
		if (a == 1)
			graph1[43].compelling = true;
		else if (a == -1)
			graph1[43].compelling = true;
		else
			graph1[43].compelling = false;

		// SK8
		a = (cacuData.digitData[9] >> 2) & 0x01; // 打开状态
		if (a == 1)
			graph1[50].open_state = true;
		else if (a == -1)
			graph1[50].open_state = true;
		else
			graph1[50].open_state = false;
		
		// SK4
		a = (cacuData.digitData[9] >> 0) & 0x01; // 打开状态
		if (a == 1)
			graph1[51].open_state = true;
		else if (a == -1)
			graph1[51].open_state = true;
		else
			graph1[51].open_state = false;
		
		// SK1
		a = (cacuData.digitData[8] >> 6) & 0x01; // 打开状态
		if (a == 1)
			graph1[52].open_state = true;
		else if (a == -1)
			graph1[52].open_state = true;
		else
			graph1[52].open_state = false;
		
		// SK7
		a = (cacuData.digitData[9] >> 1) & 0x01; // 打开状态
		if (a == 1)
			graph1[53].open_state = true;
		else if (a == -1)
			graph1[53].open_state = true;
		else
			graph1[53].open_state = false;
		
		// SK2
		a = (cacuData.digitData[8] >> 7) & 0x01; // 打开状态
		if (a == 1)
			graph1[54].open_state = true;
		else if (a == -1)
			graph1[54].open_state = true;
		else
			graph1[54].open_state = false;
	}

}
