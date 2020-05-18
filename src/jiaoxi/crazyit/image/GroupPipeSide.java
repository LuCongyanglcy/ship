package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupPipeSide {
	static final int Valve_NUM = 2; // final表示是一个常量	
	static final Graph_Pipeside[] pipeside = new Graph_Pipeside[Valve_NUM];
	
	public static void InitValve()		///初始化阀的位置信息 
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			pipeside[i] = new Graph_Pipeside();
		}			

	}
	public static void FillValveData(Caculate cacuData)
	   {
		
		 //左耙
		 pipeside[0].depth0 = cacuData.anlogData[477];
		 pipeside[0].depth1 = cacuData.anlogData[485];
		 pipeside[0].depth2 = cacuData.anlogData[488];		 
//		 pipeside[0].tideDepth = cacuData.anlogData[472];
		 pipeside[0].tideDepth = 2;
		 pipeside[0].grayDepth = 20;
		 
		//右耙
		 pipeside[1].depth0 = cacuData.anlogData[496];
		 pipeside[1].depth1 = cacuData.anlogData[504];
		 pipeside[1].depth2 = cacuData.anlogData[507];		 
//		 pipeside[1].tideDepth = cacuData.anlogData[472];
		 pipeside[1].tideDepth = 2;
		 pipeside[1].grayDepth = 20;
	   }	
}
