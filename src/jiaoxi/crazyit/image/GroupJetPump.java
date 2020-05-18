package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupJetPump {

//	static final int Valve_NUM = 2; // final表示是一个常量	
	static final Graph_JetPump[] jetpump = new Graph_JetPump[2];
	
	public static void InitValve()		///初始化阀的位置信息 
	{
		for(int i=0;i<2;i++)
		{
			jetpump[i] = new Graph_JetPump();
		}			

	}
	public static void FillValveData(Caculate cacuData)
	   {
		int a;
		// 高压冲水泵1
		a = (cacuData.digitData[116] >> 4) & 0x01; // 打开状态
		if (a == 1)
			jetpump[0].run_state = true;
		else if (a == -1)
			jetpump[0].run_state = true;
		else
			jetpump[0].run_state = false;

		a = (cacuData.digitData[116] >> 4) & 0x01; // 关闭状态
		if (a == 1)
			jetpump[0].run_stop = false;
		else if (a == -1)
			jetpump[0].run_stop = false;
		else
			jetpump[0].run_stop = true;

		// 高压冲水泵2
		a = (cacuData.digitData[117] >> 1) & 0x01; // 打开状态
		if (a == 1)
			jetpump[1].run_state = true;
		else if (a == -1)
			jetpump[1].run_state = true;
		else
			jetpump[1].run_state = false;

		a = (cacuData.digitData[117] >> 1) & 0x01; // 关闭状态
		if (a == 1)
			jetpump[1].run_stop = false;
		else if (a == -1)
			jetpump[1].run_stop = false;
		else
			jetpump[1].run_stop = true;

	}
}
