package jiaoxi.crazyit.image;

import java.util.ArrayList;

import jiaoxi.crazyit.classes.Caculate;


public class GroupValves {

	static final int Valve_NUM = 50; // final表示是一个常量
//	ArrayList <DrawValve> ValveGroup = new  ArrayList <DrawValve>();
	
	static DrawValve[] ValveItems = new DrawValve[Valve_NUM] ;
	
	public static void InitValve()		///初始化阀的位置信息 
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			ValveItems[i] = new DrawValve();
		}			

			for (int i=0; i<Valve_NUM; i++)
			{
				ValveItems[i].left = 100+ i*40;
				ValveItems[i].right = 120 + i*40;
				ValveItems[i].top = 100;
				ValveItems[i].bottom = 140;
				ValveItems[i].RotateAngle = (float)(20.0*3.1415926/180.0);
				ValveItems[i].GetRectPoint();  //获得选择区域大小

			}

	}

	//////填数据,需要不断的填值
   public static void FillValveData(Caculate cacuData)
   {
	   int a;
	   a = (cacuData.digitData[12]>>0)&0x01;
	   if( a==1)ValveItems[0].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[0].OpenStatus = true;		   
	       else ValveItems[0].OpenStatus = false;
	   
	   a = (cacuData.digitData[12]>>1)&0x01;
	   if( a==1)ValveItems[1].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[1].OpenStatus = true;		   
	       else ValveItems[1].OpenStatus = false;
	   
	   a = (cacuData.digitData[12]>>2)&0x01;
	   if( a==1)ValveItems[2].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[2].OpenStatus = true;		   
	       else ValveItems[2].OpenStatus = false;
	   
	   a = (cacuData.digitData[12]>>3)&0x01;
	   if( a==1)ValveItems[3].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[3].OpenStatus = true;		   
	       else ValveItems[3].OpenStatus = false;
	   
	   a = (cacuData.digitData[12]>>4)&0x01;
	   if( a==1)ValveItems[4].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[4].OpenStatus = true;		   
	       else ValveItems[4].OpenStatus = false;
	   
	   a = (cacuData.digitData[12]>>5)&0x01;
	   if( a==1)ValveItems[5].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[5].OpenStatus = true;		   
	       else ValveItems[5].OpenStatus = false;
	   
	   a = (cacuData.digitData[12]>>6)&0x01;
	   if( a==1)ValveItems[6].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[6].OpenStatus = true;		   
	       else ValveItems[6].OpenStatus = false;
	   
	   a = (cacuData.digitData[12]>>7)&0x01;
	   if( a==1)ValveItems[7].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[7].OpenStatus = true;		   
	       else ValveItems[7].OpenStatus = false;
	   
	   a = (cacuData.digitData[13]>>0)&0x01;
	   if( a==1)ValveItems[8].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[8].OpenStatus = true;		   
	       else ValveItems[8].OpenStatus = false;
	   
	   a = (cacuData.digitData[13]>>1)&0x01;
	   if( a==1)ValveItems[9].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[9].OpenStatus = true;		   
	       else ValveItems[9].OpenStatus = false;
	   
	   a = (cacuData.digitData[13]>>2)&0x01;
	   if( a==1)ValveItems[10].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[10].OpenStatus = true;		   
	       else ValveItems[10].OpenStatus = false;
	   
	   a = (cacuData.digitData[13]>>3)&0x01;
	   if( a==1)ValveItems[11].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[11].OpenStatus = true;		   
	       else ValveItems[11].OpenStatus = false;
	   
	   a = (cacuData.digitData[13]>>4)&0x01;
	   if( a==1)ValveItems[12].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[12].OpenStatus = true;		   
	       else ValveItems[12].OpenStatus = false;
	   
	   a = (cacuData.digitData[13]>>5)&0x01;
	   if( a==1)ValveItems[13].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[13].OpenStatus = true;		   
	       else ValveItems[13].OpenStatus = false;
	   
	   a = (cacuData.digitData[13]>>6)&0x01;
	   if( a==1)ValveItems[14].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[14].OpenStatus = true;		   
	       else ValveItems[14].OpenStatus = false;
	   
	   a = (cacuData.digitData[13]>>7)&0x01;
	   if( a==1)ValveItems[15].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[15].OpenStatus = true;		   
	       else ValveItems[15].OpenStatus = false;
	   
	   a = (cacuData.digitData[14]>>0)&0x01;
	   if( a==1)ValveItems[16].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[16].OpenStatus = true;		   
	       else ValveItems[16].OpenStatus = false;
	   
	   a = (cacuData.digitData[14]>>1)&0x01;
	   if( a==1)ValveItems[17].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[17].OpenStatus = true;		   
	       else ValveItems[17].OpenStatus = false;
	   
	   a = (cacuData.digitData[14]>>2)&0x01;
	   if( a==1)ValveItems[18].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[18].OpenStatus = true;		   
	       else ValveItems[18].OpenStatus = false;
	   
	   a = (cacuData.digitData[14]>>3)&0x01;
	   if( a==1)ValveItems[19].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[19].OpenStatus = true;		   
	       else ValveItems[19].OpenStatus = false;
	   
	   a = (cacuData.digitData[14]>>4)&0x01;
	   if( a==1)ValveItems[20].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[20].OpenStatus = true;		   
	       else ValveItems[20].OpenStatus = false;
	  
	   a = (cacuData.digitData[14]>>5)&0x01;
	   if( a==1)ValveItems[21].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[21].OpenStatus = true;		   
	       else ValveItems[21].OpenStatus = false;
	   
	   a = (cacuData.digitData[14]>>6)&0x01;
	   if( a==1)ValveItems[22].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[22].OpenStatus = true;		   
	       else ValveItems[22].OpenStatus = false;
	   
	   a = (cacuData.digitData[14]>>7)&0x01;
	   if( a==1)ValveItems[23].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[23].OpenStatus = true;		   
	       else ValveItems[23].OpenStatus = false;
	   
	   a = (cacuData.digitData[15]>>0)&0x01;
	   if( a==1)ValveItems[24].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[24].OpenStatus = true;		   
	       else ValveItems[24].OpenStatus = false;
	   
	   a = (cacuData.digitData[15]>>1)&0x01;
	   if( a==1)ValveItems[25].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[25].OpenStatus = true;		   
	       else ValveItems[25].OpenStatus = false;
	   
	   a = (cacuData.digitData[15]>>2)&0x01;
	   if( a==1)ValveItems[26].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[26].OpenStatus = true;		   
	       else ValveItems[26].OpenStatus = false;
	   
	   a = (cacuData.digitData[15]>>3)&0x01;
	   if( a==1)ValveItems[27].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[27].OpenStatus = true;		   
	       else ValveItems[27].OpenStatus = false;
	   
	   a = (cacuData.digitData[15]>>4)&0x01;
	   if( a==1)ValveItems[28].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[28].OpenStatus = true;		   
	       else ValveItems[28].OpenStatus = false;
	   
	   a = (cacuData.digitData[15]>>5)&0x01;
	   if( a==1)ValveItems[29].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[29].OpenStatus = true;		   
	       else ValveItems[29].OpenStatus = false;
	   
	   a = (cacuData.digitData[15]>>6)&0x01;
	   if( a==1)ValveItems[30].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[30].OpenStatus = true;		   
	       else ValveItems[30].OpenStatus = false;
	   
	   a = (cacuData.digitData[15]>>7)&0x01;
	   if( a==1)ValveItems[31].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[31].OpenStatus = true;		   
	       else ValveItems[31].OpenStatus = false;
	   
	   a = (cacuData.digitData[16]>>0)&0x01;
	   if( a==1)ValveItems[32].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[32].OpenStatus = true;		   
	       else ValveItems[32].OpenStatus = false;
	   
	   a = (cacuData.digitData[16]>>1)&0x01;
	   if( a==1)ValveItems[33].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[33].OpenStatus = true;		   
	       else ValveItems[33].OpenStatus = false;
	   
	   a = (cacuData.digitData[16]>>2)&0x01;
	   if( a==1)ValveItems[34].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[34].OpenStatus = true;		   
	       else ValveItems[34].OpenStatus = false;
	   
	   a = (cacuData.digitData[16]>>3)&0x01;
	   if( a==1)ValveItems[35].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[35].OpenStatus = true;		   
	       else ValveItems[35].OpenStatus = false;
	   
	   a = (cacuData.digitData[16]>>4)&0x01;
	   if( a==1)ValveItems[36].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[36].OpenStatus = true;		   
	       else ValveItems[36].OpenStatus = false;
	   
	   a = (cacuData.digitData[16]>>5)&0x01;
	   if( a==1)ValveItems[37].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[37].OpenStatus = true;		   
	       else ValveItems[37].OpenStatus = false;
	   
	   a = (cacuData.digitData[16]>>6)&0x01;
	   if( a==1)ValveItems[38].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[38].OpenStatus = true;		   
	       else ValveItems[38].OpenStatus = false;
	   
	   a = (cacuData.digitData[16]>>7)&0x01;
	   if( a==1)ValveItems[39].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[39].OpenStatus = true;		   
	       else ValveItems[39].OpenStatus = false;
	   
	   a = (cacuData.digitData[17]>>0)&0x01;
	   if( a==1)ValveItems[40].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[40].OpenStatus = true;		   
	       else ValveItems[40].OpenStatus = false;
	   
	   a = (cacuData.digitData[17]>>1)&0x01;
	   if( a==1)ValveItems[41].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[41].OpenStatus = true;		   
	       else ValveItems[41].OpenStatus = false;
	   
	   a = (cacuData.digitData[17]>>2)&0x01;
	   if( a==1)ValveItems[42].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[42].OpenStatus = true;		   
	       else ValveItems[42].OpenStatus = false;
	   
	   a = (cacuData.digitData[17]>>3)&0x01;
	   if( a==1)ValveItems[43].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[43].OpenStatus = true;		   
	       else ValveItems[43].OpenStatus = false;
	   
	   a = (cacuData.digitData[17]>>4)&0x01;
	   if( a==1)ValveItems[44].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[44].OpenStatus = true;		   
	       else ValveItems[44].OpenStatus = false;
	   
	   a = (cacuData.digitData[17]>>5)&0x01;
	   if( a==1)ValveItems[45].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[45].OpenStatus = true;		   
	       else ValveItems[45].OpenStatus = false;
	   
	   a = (cacuData.digitData[17]>>6)&0x01;
	   if( a==1)ValveItems[46].OpenStatus = true;
	   else
		   if( a==-1)ValveItems[46].OpenStatus = true;		   
	       else ValveItems[46].OpenStatus = false;
	   
	   a = (cacuData.digitData[17]>>7)&0x01;
	   if( a==1)ValveItems[47].OpenStatus = false;
	   else
		   if( a==-1)ValveItems[47].OpenStatus = true;		   
	       else ValveItems[47].OpenStatus = false;
	   
	   a = (cacuData.digitData[18]>>0)&0x01;
	   if( a==1)ValveItems[48].OpenStatus = false;
	   else
		   if( a==-1)ValveItems[48].OpenStatus = true;		   
	       else ValveItems[48].OpenStatus = false;
	   
	   a = (cacuData.digitData[18]>>1)&0x01;
	   if( a==1)ValveItems[49].OpenStatus = false;
	   else
		   if( a==-1)ValveItems[49].OpenStatus = true;		   
	       else ValveItems[49].OpenStatus = false;
	   

	   

   }

}
