package jiaoxi.crazyit.classes;

public class Str_RealTimeSignal {
	public float Tide;					//潮位------可能从多个地方获得
	public double GPS_X;				//转换过的GPS信号
	public double COG;//对地航向
	public double SOG;//对地航速
	public double GPS_Y;
	public double GPS_Z;
	public double GPS2_X;
	public double GPS2_Y;
	public double heading;
	public double MoveGPS_X;
	public double MoveGPS_Y;
	public float GPS_Speed;
	public float GPS_Direct;
	public float MoveSpeed_Left;			//左横移速度
	public float MoveSpeed_Right;			//右横移速度
	public boolean  MainStackDown;			//主桩下信号
	public boolean  AssitantStackDown;		//辅助桩下信号
	public double ShipAngle;				//船体角度-------可能从多个地方获得
	public float TrunnionGaugeDeep;		//耳轴吃水深度
	public float TrunnionGaugeDeep1;		//桥架下放深度
	public float CutterHeadAngle;			//绞刀头角度-------固定角度/可调角度
	public float BridgeAngle;				//桥架角度	
	public float Trim_Ver;
	public float Trim_Hor;
	public float MainStackLength;			//主桩行程
	public float PlaneLen;

	public float CutterDeep;		///挖泥厚度
	public float OriginDeep;		///原始厚度
	public float SMSpeed;			////水下泵转速
	public float SpeedCutter;		////绞刀转速
	public float CutterPress;		////绞刀工作压力
	public float CabinPumpSpeed;	//	舱内泵转速1
	public float CabinPumpSpeed1;	//	舱内泵转速2
	public float MoveSpeed;		////横移速度

	public float PercentDensity;	///百分比浓度
	public float Velocity;			///流速
	public float ProductRate;		///小时产量率
	public float SuctionPress;		//	水下泵吸入真空
	public float SuctionPress1;	//	水下泵排出压力
	public float SuctionPress2;	//	水下泵封水压力
	public float DischargePress1;	//	1#舱内泵排出压力
	public float DischargePress2;	//	2#舱内泵排出压力

	public int MoveDirect;				//横移方向


	///////////////// 下锚信号 /////////////////////
	public boolean LeftAnchorIsUp;			/////左抛锚竿正在移动
	public boolean RightAnchorIsUp;			/////右抛锚竿正在移动
	public boolean LeftTailIsUp;			/////左定位锚正在移动
	public boolean CenterTailIsUp;			/////中定位锚正在移动
	public boolean RightTailIsUp;			/////右定位锚正在移动

	public float LeftMoveAngle;			/////左横移角度
	public float RightMoveAngle;			/////右横移角度

	public float LeftTailLen;				////左艉锚长度
	public float LeftTailAngle;			////左艉锚角度
	public float CenterTailLen;			////中艉锚长度
	public float CenterTailAngle;			////中艉锚角度
	public float RightTailLen;				////右艉锚长度
	public float RightTailAngle;			////右艉锚角度
	////////////////////// 抛锚位置 ////////////////////
	////////////////////// 抛锚命令时，记录下来的位置,作为中间过程，不需要直接使用StrShipPoint计算 //////////////////
	public float LeftMove_X;
	public float LeftMove_Y;
	public float RightMove_X;
	public float RightMove_Y;			///////横移锚

	public float LeftTail_X;
	public float LeftTail_Y;
	public float CenterTail_X;
	public float CenterTail_Y;
	public float RightTail_X;
	public float RightTail_Y;

	public boolean MoveAnchor;		////0:抛锚竿 1:移动GPS


	public float VirtualGPSDistance;		/////虚拟的GPS点到GPS实际点的距离
	public float AvergeDensity;
	public float R;

	public boolean bJG1;	//	进关1正在进行
	public boolean bJG2;	//	进关2正在进行
	public boolean bTG1;	//	退关1正在进行
	public boolean bTG2;	//	退关2正在进行

	
	public int currGroup;
	public double groupProduct;
	public double lastProduct;
	public double GPS_E;	
	public double GPS_N;
	public float  CutterDis;
	public double GPS2_E;
	public double GPS2_N;

	
	public double currentTraceLineAngle;
}
