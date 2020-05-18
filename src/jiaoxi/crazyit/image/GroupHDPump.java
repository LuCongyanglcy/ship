package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupHDPump {

	static final int Valve_NUM = 11; // final��ʾ��һ������	
	static final Graph_HDPump[] hdpump = new Graph_HDPump[Valve_NUM];
	
	public static void InitValve()		///��ʼ������λ����Ϣ 
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

		int a;//0Һѹ1��ˮ2����3Ӧ��4����
		if(cacuData.anlogData[100 + 26] >= 0.5)
			hdpump[1].run_status = true;
		else
			hdpump[1].run_status = false;
		
		a = (cacuData.digitData[8] >> 7) & 0x01; // ����״̬
		if (a == 1)
			hdpump[3].run_status = true;
		else if (a == -1)
			hdpump[3].run_status = true;
		else
			hdpump[3].run_status = false;
		
		a = (cacuData.digitData[8] >> 4) & 0x01; // ����״̬
		if (a == 1)
			hdpump[4].run_status = true;
		else if (a == -1)
			hdpump[4].run_status = true;
		else
			hdpump[4].run_status = false;
	}
}
