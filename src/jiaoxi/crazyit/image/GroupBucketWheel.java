package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.Caculate;

public class GroupBucketWheel {
	static final int Valve_NUM = 3; // final表示是一个常量	
	public static final Graph_BucketWheel[] bucketwheel = new Graph_BucketWheel[Valve_NUM];
	
	public static void InitValve()		///初始化阀的位置信息 
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			bucketwheel[i] = new Graph_BucketWheel();
		}			

	}

	public static void FillValveData(Caculate cacuData,int index) {
		for(int i=0;i<Valve_NUM;i++) {
			if(bucketwheel[i].run) {
				if(bucketwheel[i].reversal) {
					bucketwheel[i].rotate=bucketwheel[i].rotate+15;
					if(bucketwheel[i].rotate>=360) {
						bucketwheel[i].rotate=0;
					}
				}else {
					bucketwheel[i].rotate=bucketwheel[i].rotate-15;
					if(bucketwheel[i].rotate<=-360) {
						bucketwheel[i].rotate=0;
					}
				}
			}else {
				bucketwheel[i].rotate=0;
			}
		}
	}
}
