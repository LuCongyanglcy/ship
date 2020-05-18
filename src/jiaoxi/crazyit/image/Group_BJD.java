package jiaoxi.crazyit.image;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.database.sqlite.SQLiteDatabase;
import jiaoxi.crazyit.classes.Caculate;
import jiaoxi.crazyit.sql.DBHelper;

public class Group_BJD {
	static final int Valve_NUM = 80; // final表示是一个常量	
	static final Graph_BJD[] bjd = new Graph_BJD[Valve_NUM];
	public static void InitValve()		///初始化
	{
		for(int i=0;i<Valve_NUM;i++)
		{
			bjd[i] = new Graph_BJD();
		}			

	}
	public static void FillValveData(Caculate cacuData)
	   {
		int a;

		for(int i=0;i<8;i++) {
			a = (cacuData.digitData[16] >> i) & 0x01; // 运行指示状态
			if (a == 1)
				bjd[0+i].show_status = true;
			else if (a == -1)
				bjd[0+i].show_status = true;
			else
				bjd[0+i].show_status = false;	
		}
		for(int i=0;i<8;i++) {
			a = (cacuData.digitData[17] >> i) & 0x01; // 运行指示状态
			if (a == 1)
				bjd[8+i].show_status = true;
			else if (a == -1)
				bjd[8+i].show_status = true;
			else
				bjd[8+i].show_status = false;	
		}
		for(int i=0;i<8;i++) {
			a = (cacuData.digitData[18] >> i) & 0x01; // 运行指示状态
			if (a == 1)
				bjd[16+i].show_status = true;
			else if (a == -1)
				bjd[16+i].show_status = true;
			else
				bjd[16+i].show_status = false;	
		}
		for(int i=0;i<5;i++) {
			a = (cacuData.digitData[19] >> i) & 0x01; // 运行指示状态
			if (a == 1)
				bjd[24+i].show_status = true;
			else if (a == -1)
				bjd[24+i].show_status = true;
			else
				bjd[24+i].show_status = false;	
		}
		///////////////////////////////////////////////////////////////////////////////////////////
		for(int i=0;i<8;i++) {
			a = (cacuData.digitData[32] >> i) & 0x01; // 运行指示状态
			if (a == 1)
				bjd[29+i].show_status = true;
			else if (a == -1)
				bjd[29+i].show_status = true;
			else
				bjd[29+i].show_status = false;	
		}
		for(int i=0;i<8;i++) {
			a = (cacuData.digitData[33] >> i) & 0x01; // 运行指示状态
			if (a == 1)
				bjd[37+i].show_status = true;
			else if (a == -1)
				bjd[37+i].show_status = true;
			else
				bjd[37+i].show_status = false;	
		}
		///////////////////////////////////////////////////////////////////////////////////////////
		for(int i=0;i<8;i++) {
			a = (cacuData.digitData[34] >> i) & 0x01; // 运行指示状态
			if (a == 1)
				bjd[46+i].show_status = true;
			else if (a == -1)
				bjd[46+i].show_status = true;
			else
				bjd[46+i].show_status = false;	
		}
		for(int i=0;i<6;i++) {
			a = (cacuData.digitData[35] >> i) & 0x01; // 运行指示状态
			if (a == 1)
				bjd[54+i].show_status = true;
			else if (a == -1)
				bjd[54+i].show_status = true;
			else
				bjd[54+i].show_status = false;	
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////////////

		a = (cacuData.digitData[12] >> 0) & 0x01; // 运行指示状态//桥架上限位
		if (a == 1)
			bjd[72].show_status = true;
		else if (a == -1)
			bjd[72].show_status = true;
		else
			bjd[72].show_status = false;
		
		a = (cacuData.digitData[23] >> 0) & 0x01; // 运行指示状态//主桩起
		if (a == 1)
			bjd[60].show_status = true;
		else if (a == -1)
			bjd[60].show_status = true;
		else
			bjd[60].show_status = false;	
		
		a = (cacuData.digitData[23] >> 1) & 0x01; // 运行指示状态//主桩落
		if (a == 1)
			bjd[61].show_status = true;
		else if (a == -1)
			bjd[61].show_status = true;
		else
			bjd[61].show_status = false;	
		
		a = (cacuData.digitData[23] >> 2) & 0x01; // 运行指示状态//副桩起
		if (a == 1)
			bjd[62].show_status = true;
		else if (a == -1)
			bjd[62].show_status = true;
		else
			bjd[62].show_status = false;	
		
		a = (cacuData.digitData[23] >> 3) & 0x01; // 运行指示状态//副桩落
		if (a == 1)
			bjd[63].show_status = true;
		else if (a == -1)
			bjd[63].show_status = true;
		else
			bjd[63].show_status = false;	
		
		a = (cacuData.digitData[4] >> 0) & 0x01; // 运行指示状态 台车油缸伸出
		if (a == 1)
			bjd[64].show_status = true;
		else if (a == -1)
			bjd[64].show_status = true;
		else
			bjd[64].show_status = false;	
		
		a = (cacuData.digitData[16] >> 2) & 0x01; // 运行指示状态 台车油缸缩回
		if (a == 1)
			bjd[65].show_status = true;
		else if (a == -1)
			bjd[65].show_status = true;
		else
			bjd[65].show_status = false;	
		
		a = (cacuData.digitData[12] >> 2) & 0x01; // 运行指示状态 台车伸出限位
		if (a == 1)
			bjd[66].show_status = true;
		else if (a == -1)
			bjd[66].show_status = true;
		else
			bjd[66].show_status = false;	
		
		a = (cacuData.digitData[12] >> 3) & 0x01; // 运行指示状态 台车缩回限位
		if (a == 1)
			bjd[67].show_status = true;
		else if (a == -1)
			bjd[67].show_status = true;
		else
			bjd[67].show_status = false;	
		
		a = (cacuData.digitData[0] >> 6) & 0x01; // 运行指示状态
		if (a == 1)
			bjd[68].show_status = true;
		else if (a == -1)
			bjd[68].show_status = true;
		else
			bjd[68].show_status = false;	
		
		a = (cacuData.digitData[0] >> 7) & 0x01; // 运行指示状态
		if (a == 1)
			bjd[69].show_status = true;
		else if (a == -1)
			bjd[69].show_status = true;
		else
			bjd[69].show_status = false;	
		
		a = (cacuData.digitData[5] >> 1) & 0x01; // 闸阀开
		if (a == 1)
			bjd[70].show_status = true;
		else if (a == -1)
			bjd[70].show_status = true;
		else
			bjd[70].show_status = false;	
		
		a = (cacuData.digitData[5] >> 2) & 0x01; // 闸阀关
		if (a == 1)
			bjd[71].show_status = true;
		else if (a == -1)
			bjd[71].show_status = true;
		else
			bjd[71].show_status = false;	
		
		a = (cacuData.digitData[19] >> 4) & 0x01; //////////// 新增的
		if (a == 1)
			bjd[72].show_status = true;
		else if (a == -1)
			bjd[72].show_status = true;
		else
			bjd[72].show_status = false;	
		
		

	}
}