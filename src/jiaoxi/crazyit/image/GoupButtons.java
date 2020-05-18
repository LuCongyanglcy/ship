package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GoupButtons {
	static final int Valve_NUM = 100; // final��ʾ��һ������	
	static final Graph_Button[] button = new Graph_Button[Valve_NUM];
	
	public static void InitValve()		///��ʼ������λ����Ϣ 
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			button[i] = new Graph_Button();
		}			

	}
	public static void FillValveData(Caculate cacuData,boolean status)
	   {
		for(int i=0;i<Valve_NUM;i++)
		{
			button[i].blinkStatus = status;
		}
		int a;
		// ��ť1
		a = (cacuData.digitData[12] >> 0) & 0x01; // ����ִ��״̬
		if (a == 1)
			button[0].blink = true;
		else if (a == -1)
			button[0].blink = true;
		else
			button[0].blink = false;
		
		a = (cacuData.digitData[12] >> 0) & 0x01; // ����������״̬
		if (a == 1)
			button[0].bDown = true;
		else if (a == -1)
			button[0].bDown = true;
		else
			button[0].bDown = false;

	
	}
}
