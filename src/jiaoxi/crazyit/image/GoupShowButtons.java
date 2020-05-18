package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GoupShowButtons {
	static final int Valve_NUM = 100; // final��ʾ��һ������	
	static final Graph_ShowButton[] Showbutton = new Graph_ShowButton[Valve_NUM];
	
	public static void InitValve()		///��ʼ������λ����Ϣ 
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			Showbutton[i] = new Graph_ShowButton();
		}			

	}
	public static void FillValveData(Caculate cacuData)
	   {
		int a;
		// 1�Ű�ť
		a = (cacuData.digitData[12] >> 0) & 0x01; // ����״̬
		if (a == 1)
			Showbutton[0].status = true;
		else if (a == -1)
			Showbutton[0].status = true;
		else
			Showbutton[0].status = false;

		// 2�Ű�ť
		a = (cacuData.digitData[12] >> 0) & 0x01; // ��״̬
		if (a == 1)
			Showbutton[1].status = true;
		else if (a == -1)
			Showbutton[1].status = true;
		else
			Showbutton[1].status = false;

	}
}
