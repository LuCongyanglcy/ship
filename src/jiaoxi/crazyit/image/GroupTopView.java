package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupTopView {
	static final int Valve_NUM = 2; // final表示是一个常量	
	static final Graph_TopView[] pipetop = new Graph_TopView[Valve_NUM];
	
	public static void InitValve()		///初始化
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			pipetop[i] = new Graph_TopView();
		}			

	}
	public static void FillValveData(Caculate cacuData)
	   {
		
		 //左耙
//		 pipetop[0].depth1 = cacuData.anlogData[485];
//		 pipetop[0].depth2 = cacuData.anlogData[488];
//		 pipetop[0].depth0 = cacuData.anlogData[477];
//		 pipetop[0].tideDepth = cacuData.anlogData[472];
//		 pipetop[0].grayDepth = 20;
//		 
//		//右耙
//		 pipetop[1].depth1 = cacuData.anlogData[504];
//		 pipetop[1].depth2 = cacuData.anlogData[507];
//		 pipetop[1].depth0 = cacuData.anlogData[496];
//		 pipetop[1].tideDepth = cacuData.anlogData[472];
//		 pipetop[1].grayDepth = 20;
	   }	
}
