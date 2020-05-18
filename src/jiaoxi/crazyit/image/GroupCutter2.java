package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupCutter2 {

	static final Graph_Cutter2 cutter2 = new Graph_Cutter2();
	public static void InitValve()		///初始化阀的位置信息 
	{
	  	Graph_Cutter2 cutter2 = new Graph_Cutter2();
	}
	public static void FillValveData(Caculate cacuDat,int index)
	   {		
		int a;
		int b;
		cutter2.aiData = index;

		cutter2.waterdeep = cacuDat.anlogData[100+42];//耳轴吃水
		cutter2.design_Deep = cacuDat.anlogData[100+72];//桥架下放深度
//		cutter2.rotateAngle = cacuDat.anlogData[100+43];//桥架角度
		
//		cutter2.waterdeep = 1.9F;
//		cutter2.design_Deep = 29;//桥架下放深度
//		cutter2.rotateAngle = 30;//桥架角度
		a = (cacuDat.digitData[0] >> 6) & 0x01;
		b = (cacuDat.digitData[0] >> 7) & 0x01;
		if(a==1||a==-1||b==1||b==-1) {
			cutter2.bRun = true;
			if(a==1||a==-1) {
				cutter2.reversal=false;
			}else {
				cutter2.reversal=true;
			}
		}else {
			cutter2.bRun = false;
		}
//		
//		a = (cacuDat.digitData[0] >> 7) & 0x01; // 打开状态
//		if (a == 1) {
//			cutter2.bRun = true;
//			cutter2.reversal=true;
//		}else if (a == -1) {
//			cutter2.bRun = true;
//			cutter2.reversal=true;	
//		}
//		else {
//			cutter2.bRun = false;
//		}
			
		//1
//		a = (((cacuDat.digitData[11] >> 0) & 0x01)|((cacuDat.digitData[11] >> 2) & 0x01)); // 打开状态
//		if (a == 1)
//			cutter2.bRun = true;
//		else if (a == -1)
//			cutter2.bRun = true;
//		else
//			cutter2.bRun = false;for(int i=0;i<Valve_NUM;i++) {
		if(cutter2.bRun) {
			if(cutter2.reversal) {
				cutter2.rotate=cutter2.rotate+15;
				if(cutter2.rotate>=360) {
					cutter2.rotate=0;
				}
			}else {
				cutter2.rotate=cutter2.rotate-15;
				if(cutter2.rotate<=-360) {
					cutter2.rotate=0;
				}
			}
		}else {
			cutter2.rotate=0;
		}
	}
}
