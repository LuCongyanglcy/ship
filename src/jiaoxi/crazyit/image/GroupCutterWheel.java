package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupCutterWheel {
	static final Graph_CutterWheel cutterwheel = new Graph_CutterWheel();

	public static void InitValve() // /初始化
	{

		Graph_CutterWheel cutterwheel = new Graph_CutterWheel();

	}

	public static void FillValveData(Caculate cacuData,int indext) {
		
		cutterwheel.sAngle = indext;
		int a;
		// 绞刀头
		a = (((cacuData.digitData[0] >> 6) & 0x01)|((cacuData.digitData[0] >> 7) & 0x01)); // 打开状态
		if (a == 1)
			cutterwheel.bRun = true;
		else if (a == -1)
			cutterwheel.bRun = true;
		else
			cutterwheel.bRun = false;
	}
}
