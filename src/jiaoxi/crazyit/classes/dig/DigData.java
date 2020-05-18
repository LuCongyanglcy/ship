package jiaoxi.crazyit.classes.dig;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;

public class DigData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2329511553703447457L;

	public List<Str_General> StrWhiteBuoy;		/////白浮筒	B
	
	public List<Str_General> StrGreenBuoy;		/////绿浮筒	M
	
	public List<Str_General> StrRedBuoy;			/////红浮筒	F
	
	public List<Str_ShoreLine> StrShoreLine;		/////岸线	S
	
	public List<Str_General> StrNavigateMark;	//////航标	N
	
	public List<Str_General> StrPicket;				///////桩	P
	
	public List<Str_General> StrLight;				//////灯	L
	
	public List<Str_General> StrRack;				//////岩石		R
	
	public List<Str_General> StrText;				//////文本		T

	public List<Str_General> StrKettle;				//////罐		K

	public List<Str_General> StrTideStation;		////// 潮位站 G

	public List<Str_General> StrWrecks;		////// 残骸 w
	
	public List<Str_General> StrSettleShip;		////// 沉船a
	
	public List<Str_General> StrLightShip;		////// 灯船b

	public List<Str_General> StrOilWell;		////// 油井c

	public List<Str_General> StrWaterStand;		////// 引水站d

	public List<Str_General> StrReportPoint;		////// 报告点e
	
	public List<Str_General> StrBeacon;		////// 灯塔f

	public List<Str_General> StrRedFlag;		////// 红旗g
		
	public List<Str_General> StrHospital;		////// 医院h
	
	public List<Str_General> StrTree;		//////树i
	
	public List<Str_General> StrAnchor;		//////锚j
	
	public List<Str_General> StrChimney;		//////烟囱k	

	public List<Str_General> StrWaterTower;		//////水塔l	

	public List<Str_General> StrRadarReflector;		//////雷达反射器m
	
	public List<Str_General> StrIslandReef;		//////岛礁n
	
	public List<Str_General> StrAquatic;		//////水草o
	
	public List<Str_General> StrBuoy1;		//////浮筒1	p
	
	public List<Str_General> StrBuoy2;		//////浮筒2	q	
	
	public List<Str_General> StrBuoy3;		//////浮筒3	r	
	
	public List<Str_General> StrBuoy4;		//////浮筒4	s	
	
	public List<Str_General> StrBuoy5;		//////浮筒5	t
	
	public List<Str_General> StrBuoy6;		//////浮筒6	u	
	
	public List<Str_General> StrBuoy7;		//////浮筒7	v
		
	public List<Str_General> StrBuoy8;		//////浮筒8 w
	
	public List<Str_General> StrBuoy9;		//////浮筒9 x
	
	public List<Str_General> StrBuoy10;		//////浮筒10 y
	
	public List<Str_General> StrFishNet;	////鱼网  E
	
	public List<Str_General> StrBuoyBlackYellow;	//////黑黄浮筒 Q

	public List<Str_General> StrNum;			//数字U	

	public List<Str_Dykeline> StrDykeline;		//堤坝线 z	

/////////////
	public List<Str_Circle> StrCircle;		///////		C
	
	public List<Str_Arc> StrArc;		///////		
	public List<Str_Solid> StrSolid;		///////Y
	
	public List<Str_BigText> StrBigText;	///////Z
	
	public List<Str_ColorLine> StrColorLine;	////////////X	

	public List<Str_ColorPolyline> StrColorPolyline;	////////////I
	
	public List<Str_PolyBezier> StrPolyBezier;		////////	D

	public List<Str_Rectangle> StrRectangle;		/////// O
	
	public List<Str_Image>  StrImage;		/////// O
	
	public int BackMode;			//////////////缺少椭圆？？？
	
	public DigData(){
		StrWhiteBuoy=new ArrayList<Str_General>();		/////白浮筒	B
		
		StrGreenBuoy=new ArrayList<Str_General>();		/////绿浮筒	M
		
		StrRedBuoy=new ArrayList<Str_General>();			/////红浮筒	F
		
		StrShoreLine=new ArrayList<Str_ShoreLine>();		/////岸线	S
		
		StrNavigateMark=new ArrayList<Str_General>();	//////航标	N
		
		StrPicket=new ArrayList<Str_General>();				///////桩	P
		
		StrLight=new ArrayList<Str_General>();				//////灯	L
		
		StrRack=new ArrayList<Str_General>();				//////岩石		R
		
		StrText=new ArrayList<Str_General>();				//////文本		T

		StrKettle=new ArrayList<Str_General>();				//////罐		K

		StrTideStation=new ArrayList<Str_General>();		////// 潮位站 G

		StrWrecks=new ArrayList<Str_General>();		////// 残骸 w
		
		StrSettleShip=new ArrayList<Str_General>();		////// 沉船a
		
		StrLightShip=new ArrayList<Str_General>();		////// 灯船b

		StrOilWell=new ArrayList<Str_General>();		////// 油井c

		StrWaterStand=new ArrayList<Str_General>();		////// 引水站d

		StrReportPoint=new ArrayList<Str_General>();		////// 报告点e
		
		StrBeacon=new ArrayList<Str_General>();		////// 灯塔f

		StrRedFlag=new ArrayList<Str_General>();		////// 红旗g
			
		StrHospital=new ArrayList<Str_General>();		////// 医院h
		
		StrTree=new ArrayList<Str_General>();		//////树i
		
		StrAnchor=new ArrayList<Str_General>();		//////锚j
		
		StrChimney=new ArrayList<Str_General>();		//////烟囱k	

		StrWaterTower=new ArrayList<Str_General>();		//////水塔l	

		StrRadarReflector=new ArrayList<Str_General>();		//////雷达反射器m
		
		StrIslandReef=new ArrayList<Str_General>();		//////岛礁n
		
		StrAquatic=new ArrayList<Str_General>();		//////水草o
		
		StrBuoy1=new ArrayList<Str_General>();		//////浮筒1	p
		
		StrBuoy2=new ArrayList<Str_General>();		//////浮筒2	q	
		
		StrBuoy3=new ArrayList<Str_General>();		//////浮筒3	r	
		
		StrBuoy4=new ArrayList<Str_General>();		//////浮筒4	s	
		
		StrBuoy5=new ArrayList<Str_General>();		//////浮筒5	t
		
		StrBuoy6=new ArrayList<Str_General>();		//////浮筒6	u	
		
		StrBuoy7=new ArrayList<Str_General>();		//////浮筒7	v
			
		StrBuoy8=new ArrayList<Str_General>();		//////浮筒8 w
		
		StrBuoy9=new ArrayList<Str_General>();		//////浮筒9 x
		
		StrBuoy10=new ArrayList<Str_General>();		//////浮筒10 y
		
		StrFishNet=new ArrayList<Str_General>();	////鱼网  E
		
		StrBuoyBlackYellow=new ArrayList<Str_General>();	//////黑黄浮筒 Q

		StrNum=new ArrayList<Str_General>();			//数字U	

		StrDykeline=new ArrayList<Str_Dykeline>();		//堤坝线 z	

	/////////////
		StrCircle=new ArrayList<Str_Circle>();		///////		C
		
		StrArc=new ArrayList<Str_Arc>();		///////		
		StrSolid=new ArrayList<Str_Solid>();		///////Y
		
		StrBigText=new ArrayList<Str_BigText>();	///////Z
		
		StrColorLine=new ArrayList<Str_ColorLine>();	////////////X	

		StrColorPolyline=new ArrayList<Str_ColorPolyline>();	////////////I
		
		StrPolyBezier=new ArrayList<Str_PolyBezier>();		////////	D

		StrRectangle=new ArrayList<Str_Rectangle>();		/////// O
		
		StrImage=new ArrayList<Str_Image>();		/////// O
	}
	
	
}
