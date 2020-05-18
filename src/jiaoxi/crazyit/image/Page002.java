package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.text.TextPaint;

////////////// 主界面001
public class Page002 {

	public static void DrawPage(Canvas canvas) {

//		if (GateValveActivity.control_limite) {
//			canvas.drawBitmap(GateValveActivity.bmp11, 2150, 70, null);
//		} else {
//			canvas.drawBitmap(GateValveActivity.bmp10, 2150, 70, null);
//		}
		//////////////////////////////////////////////////////////////////////////////////
		Paint paint = new Paint();
		//下面说明中    电磁阀失电
		GroupSolenoidValve.SolenoidValve0[0].cx =240+300-100;//不配信号
		GroupSolenoidValve.SolenoidValve0[0].cy = 1570;
		GroupSolenoidValve.SolenoidValve0[0].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[0].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[0].blink_sign = false;
		GroupSolenoidValve.SolenoidValve0[0].electricity =true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[0].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[0].adjustable = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[0].drawGraph(canvas);
		//下面说明中    电磁铁有条件得电
		GroupSolenoidValve.SolenoidValve0[1].cx =520+300;//不配信号
		GroupSolenoidValve.SolenoidValve0[1].cy = 1570;
		GroupSolenoidValve.SolenoidValve0[1].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[1].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[1].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[1].conditional_electricity =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[1].adjustable = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[1].drawGraph(canvas);
		//下面说明中    比例电磁铁处可调节状态
		GroupSolenoidValve.SolenoidValve0[2].cx = 900+300+150;// 不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 1570;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 43;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 40;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false; // 电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false; // 电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable = true; // 电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);
		// 下面说明中 电磁阀得电
		GroupSolenoidValve.SolenoidValve0[3].cx = 1370+300+400;// 不配信号
		GroupSolenoidValve.SolenoidValve0[3].cy = 1570;
		GroupSolenoidValve.SolenoidValve0[3].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[3].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[3].blink_sign = true;
		GroupSolenoidValve.SolenoidValve0[3].electricity = false; // 电磁阀得电
		GroupSolenoidValve.SolenoidValve0[3].conditional_electricity = false; // 电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[3].adjustable = false; // 电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[3].drawGraph(canvas);


////////////////1速
		GroupSolenoidValve.SolenoidValve[1].cx =660+44*1;
		GroupSolenoidValve.SolenoidValve[1].cy =154+44*1;
		GroupSolenoidValve.SolenoidValve[1].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[1].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[1].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[1].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[1].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[1].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[2].cx =660+44*2;
		GroupSolenoidValve.SolenoidValve[2].cy =154+44*1;
		GroupSolenoidValve.SolenoidValve[2].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[2].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[2].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[2].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[11].cx =660+44*11;
		GroupSolenoidValve.SolenoidValve[11].cy =154+44*1;
		GroupSolenoidValve.SolenoidValve[11].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[11].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[11].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[11].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[11].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[11].drawGraph(canvas);

////////////////2速
		GroupSolenoidValve.SolenoidValve[1].cx =660+44*1;
		GroupSolenoidValve.SolenoidValve[1].cy =154+44*2;
		GroupSolenoidValve.SolenoidValve[1].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[1].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[1].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[1].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[1].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[1].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[2].cx =660+44*2;
		GroupSolenoidValve.SolenoidValve[2].cy =154+44*2;
		GroupSolenoidValve.SolenoidValve[2].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[2].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[2].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[2].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[2].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[3].cx =660+44*3;
		GroupSolenoidValve.SolenoidValve[3].cy =154+44*2;
		GroupSolenoidValve.SolenoidValve[3].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[3].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[3].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[3].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[3].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[11].cx =660+44*11;
		GroupSolenoidValve.SolenoidValve[11].cy =154+44*2;
		GroupSolenoidValve.SolenoidValve[11].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[11].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[11].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[11].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[11].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[11].drawGraph(canvas);
		
////////////////3速
		GroupSolenoidValve.SolenoidValve[1].cx =660+44*1;
		GroupSolenoidValve.SolenoidValve[1].cy =154+44*3;
		GroupSolenoidValve.SolenoidValve[1].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[1].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[1].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[1].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[1].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[1].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[2].cx =660+44*2;
		GroupSolenoidValve.SolenoidValve[2].cy =154+44*3;
		GroupSolenoidValve.SolenoidValve[2].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[2].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[2].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[2].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[2].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[3].cx =660+44*3;
		GroupSolenoidValve.SolenoidValve[3].cy =154+44*3;
		GroupSolenoidValve.SolenoidValve[3].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[3].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[3].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[3].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[3].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[4].cx =660+44*4;
		GroupSolenoidValve.SolenoidValve[4].cy =154+44*3;
		GroupSolenoidValve.SolenoidValve[4].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[4].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[4].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[4].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[4].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[4].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[11].cx =660+44*11;
		GroupSolenoidValve.SolenoidValve[11].cy =154+44*3;
		GroupSolenoidValve.SolenoidValve[11].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[11].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[11].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[11].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[11].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[11].drawGraph(canvas);
		
////////////////盘车正转
		GroupSolenoidValve.SolenoidValve[6].cx =660+44*6;
		GroupSolenoidValve.SolenoidValve[6].cy =154+44*4;
		GroupSolenoidValve.SolenoidValve[6].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[6].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[6].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[6].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[6].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[6].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[8].cx =660+44*8;
		GroupSolenoidValve.SolenoidValve[8].cy =154+44*4;
		GroupSolenoidValve.SolenoidValve[8].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[8].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[8].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[8].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[8].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[8].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[10].cx =660+44*10;
		GroupSolenoidValve.SolenoidValve[10].cy =154+44*4;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

////////////////盘车反转
		
		GroupSolenoidValve.SolenoidValve[6].cx =660+44*6;
		GroupSolenoidValve.SolenoidValve[6].cy =154+44*5;
		GroupSolenoidValve.SolenoidValve[6].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[6].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[6].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[6].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[6].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[6].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[8].cx =660+44*8;
		GroupSolenoidValve.SolenoidValve[8].cy =154+44*5;
		GroupSolenoidValve.SolenoidValve[8].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[8].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[8].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[8].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[8].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[8].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[9].cx =660+44*9;
		GroupSolenoidValve.SolenoidValve[9].cy =154+44*5;
		GroupSolenoidValve.SolenoidValve[9].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[9].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[9].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[9].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[9].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[9].drawGraph(canvas);
		
////////////////左横移绞车 收缆
		
		GroupSolenoidValve.SolenoidValve[8].cx =660+44*8;
		GroupSolenoidValve.SolenoidValve[8].cy =154+44*6;
		GroupSolenoidValve.SolenoidValve[8].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[8].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[8].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[8].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[8].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[8].drawGraph(canvas);
	
		GroupSolenoidValve.SolenoidValve[13].cx =660+44*13;
		GroupSolenoidValve.SolenoidValve[13].cy =154+44*6;
		GroupSolenoidValve.SolenoidValve[13].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[13].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[13].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[13].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[13].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[13].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[38].cx =660+44*38;
		GroupSolenoidValve.SolenoidValve[38].cy =154+44*6;
		GroupSolenoidValve.SolenoidValve[38].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[38].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[38].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[38].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[38].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[38].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[39].cx =660+44*39;
		GroupSolenoidValve.SolenoidValve[39].cy =154+44*6;
		GroupSolenoidValve.SolenoidValve[39].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[39].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[39].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[39].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[39].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[39	].drawGraph(canvas);

////////////////左横移绞车 放缆
		
		GroupSolenoidValve.SolenoidValve[8].cx =660+44*8;
		GroupSolenoidValve.SolenoidValve[8].cy =154+44*7;
		GroupSolenoidValve.SolenoidValve[8].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[8].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[8].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[8].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[8].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[8].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[12].cx =660+44*12;
		GroupSolenoidValve.SolenoidValve[12].cy =154+44*7;
		GroupSolenoidValve.SolenoidValve[12].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[12].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[12].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[12].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[12].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[12].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[38].cx =660+44*38;
		GroupSolenoidValve.SolenoidValve[38].cy =154+44*7;
		GroupSolenoidValve.SolenoidValve[38].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[38].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[38].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[38].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[38].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[38].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[39].cx =660+44*39;
		GroupSolenoidValve.SolenoidValve[39].cy =154+44*7;
		GroupSolenoidValve.SolenoidValve[39].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[39].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[39].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[39].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[39].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[39].drawGraph(canvas);
		
////////////////右横移绞车 收缆
				
		GroupSolenoidValve.SolenoidValve[8].cx =660+44*8;
		GroupSolenoidValve.SolenoidValve[8].cy =154+44*8;
		GroupSolenoidValve.SolenoidValve[8].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[8].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[8].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[8].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[8].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[8].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[15].cx =660+44*15;
		GroupSolenoidValve.SolenoidValve[15].cy =154+44*8;
		GroupSolenoidValve.SolenoidValve[15].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[15].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[15].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[15].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[15].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[15].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[38].cx =660+44*38;
		GroupSolenoidValve.SolenoidValve[38].cy =154+44*8;
		GroupSolenoidValve.SolenoidValve[38].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[38].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[38].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[38].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[38].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[38].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[39].cx =660+44*39;
		GroupSolenoidValve.SolenoidValve[39].cy =154+44*8;
		GroupSolenoidValve.SolenoidValve[39].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[39].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[39].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[39].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[39].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[39].drawGraph(canvas);

////////////////右横移绞车 放缆
		
		GroupSolenoidValve.SolenoidValve[8].cx =660+44*8;
		GroupSolenoidValve.SolenoidValve[8].cy =154+44*9;
		GroupSolenoidValve.SolenoidValve[8].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[8].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[8].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[8].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[8].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[8].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[14].cx =660+44*14;
		GroupSolenoidValve.SolenoidValve[14].cy =154+44*9;
		GroupSolenoidValve.SolenoidValve[14].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[14].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[14].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[14].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[14].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[14].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[38].cx =660+44*38;
		GroupSolenoidValve.SolenoidValve[38].cy =154+44*9;
		GroupSolenoidValve.SolenoidValve[38].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[38].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[38].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[38].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[38].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[38].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[39].cx =660+44*39;
		GroupSolenoidValve.SolenoidValve[39].cy =154+44*9;
		GroupSolenoidValve.SolenoidValve[39].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[39].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[39].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[39].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[39].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[39].drawGraph(canvas);

////////////////左收右放
				
		GroupSolenoidValve.SolenoidValve[8].cx =660+44*8;
		GroupSolenoidValve.SolenoidValve[8].cy =154+44*10;
		GroupSolenoidValve.SolenoidValve[8].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[8].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[8].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[8].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[8].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[8].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[13].cx =660+44*13;
		GroupSolenoidValve.SolenoidValve[13].cy =154+44*10;
		GroupSolenoidValve.SolenoidValve[13].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[13].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[13].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[13].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[13].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[13].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[17].cx =660+44*17;
		GroupSolenoidValve.SolenoidValve[17].cy =154+44*10;
		GroupSolenoidValve.SolenoidValve[17].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[17].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[17].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[17].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[17].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[17].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[38].cx =660+44*38;
		GroupSolenoidValve.SolenoidValve[38].cy =154+44*10;
		GroupSolenoidValve.SolenoidValve[38].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[38].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[38].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[38].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[38].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[38].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[39].cx =660+44*39;
		GroupSolenoidValve.SolenoidValve[39].cy =154+44*10;
		GroupSolenoidValve.SolenoidValve[39].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[39].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[39].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[39].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[39].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[39].drawGraph(canvas);

////////////////右收左放
		
		GroupSolenoidValve.SolenoidValve[8].cx =660+44*8;
		GroupSolenoidValve.SolenoidValve[8].cy =154+44*11;
		GroupSolenoidValve.SolenoidValve[8].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[8].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[8].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[8].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[8].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[8].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[15].cx =660+44*15;
		GroupSolenoidValve.SolenoidValve[15].cy =154+44*11;
		GroupSolenoidValve.SolenoidValve[15].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[15].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[15].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[15].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[15].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[15].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[16].cx =660+44*16;
		GroupSolenoidValve.SolenoidValve[16].cy =154+44*11;
		GroupSolenoidValve.SolenoidValve[16].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[16].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[16].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[16].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[16].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[16].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[38].cx =660+44*38;
		GroupSolenoidValve.SolenoidValve[38].cy =154+44*11;
		GroupSolenoidValve.SolenoidValve[38].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[38].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[38].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[38].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[38].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[38].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[39].cx =660+44*39;
		GroupSolenoidValve.SolenoidValve[39].cy =154+44*11;
		GroupSolenoidValve.SolenoidValve[39].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[39].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[39].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[39].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[39].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[39].drawGraph(canvas);

////////////////左桩起桩
		
		GroupSolenoidValve.SolenoidValve[5].cx =660+44*5;
		GroupSolenoidValve.SolenoidValve[5].cy =154+44*12;
		GroupSolenoidValve.SolenoidValve[5].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[5].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[5].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[5].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[5].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[28].cx =660+44*28;
		GroupSolenoidValve.SolenoidValve[28].cy =154+44*12;
		GroupSolenoidValve.SolenoidValve[28].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[28].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[28].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[28].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[28].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[28].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[37].cx =660+44*37;
		GroupSolenoidValve.SolenoidValve[37].cy =154+44*12;
		GroupSolenoidValve.SolenoidValve[37].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[37].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[37].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[37].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[37].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[37].drawGraph(canvas);

////////////////左桩落桩
		
		GroupSolenoidValve.SolenoidValve[6].cx =660+44*6;
		GroupSolenoidValve.SolenoidValve[6].cy =154+44*13;
		GroupSolenoidValve.SolenoidValve[6].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[6].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[6].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[6].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[6].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[6].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[29].cx =660+44*29;
		GroupSolenoidValve.SolenoidValve[29].cy =154+44*13;
		GroupSolenoidValve.SolenoidValve[29].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[29].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[29].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[29].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[29].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[29].drawGraph(canvas);
		

////////////////右桩起桩
		
		GroupSolenoidValve.SolenoidValve[5].cx =660+44*5;
		GroupSolenoidValve.SolenoidValve[5].cy =154+44*14;
		GroupSolenoidValve.SolenoidValve[5].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[5].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[5].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[5].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[5].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[27].cx =660+44*27;
		GroupSolenoidValve.SolenoidValve[27].cy =154+44*14;
		GroupSolenoidValve.SolenoidValve[27].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[27].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[27].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[27].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[27].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[27].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[37].cx =660+44*37;
		GroupSolenoidValve.SolenoidValve[37].cy =154+44*14;
		GroupSolenoidValve.SolenoidValve[37].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[37].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[37].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[37].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[37].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[37].drawGraph(canvas);

////////////////左桩落桩
		
		GroupSolenoidValve.SolenoidValve[6].cx =660+44*6;
		GroupSolenoidValve.SolenoidValve[6].cy =154+44*15;
		GroupSolenoidValve.SolenoidValve[6].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[6].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[6].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[6].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[6].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[6].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[30].cx =660+44*30;
		GroupSolenoidValve.SolenoidValve[30].cy =154+44*15;
		GroupSolenoidValve.SolenoidValve[30].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[30].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[30].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[30].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[30].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[30].drawGraph(canvas);
		

////////////////桥架绞车 提升
		
		GroupSolenoidValve.SolenoidValve[5].cx =660+44*5;
		GroupSolenoidValve.SolenoidValve[5].cy =154+44*16;
		GroupSolenoidValve.SolenoidValve[5].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[5].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[5].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[5].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[5].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[25].cx =660+44*25;
		GroupSolenoidValve.SolenoidValve[25].cy =154+44*16;
		GroupSolenoidValve.SolenoidValve[25].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[25].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[25].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[25].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[25].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[25].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[37].cx =660+44*37;
		GroupSolenoidValve.SolenoidValve[37].cy =154+44*16;
		GroupSolenoidValve.SolenoidValve[37].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[37].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[37].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[37].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[37].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[37].drawGraph(canvas);

////////////////桥架绞车 下降
		
		GroupSolenoidValve.SolenoidValve[5].cx =660+44*5;
		GroupSolenoidValve.SolenoidValve[5].cy =154+44*17;
		GroupSolenoidValve.SolenoidValve[5].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[5].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[5].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[5].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[5].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[26].cx =660+44*26;
		GroupSolenoidValve.SolenoidValve[26].cy =154+44*17;
		GroupSolenoidValve.SolenoidValve[26].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[26].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[26].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[26].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[26].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[26].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[37].cx =660+44*37;
		GroupSolenoidValve.SolenoidValve[37].cy =154+44*17;
		GroupSolenoidValve.SolenoidValve[37].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[37].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[37].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[37].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[37].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[37].drawGraph(canvas);

////////////////左抛锚绞车 收缆
		
		GroupSolenoidValve.SolenoidValve[5].cx =660+44*5;
		GroupSolenoidValve.SolenoidValve[5].cy =154+44*18;
		GroupSolenoidValve.SolenoidValve[5].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[5].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[5].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[5].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[5].drawGraph(canvas);
	
		GroupSolenoidValve.SolenoidValve[19].cx =660+44*19;
		GroupSolenoidValve.SolenoidValve[19].cy =154+44*18;
		GroupSolenoidValve.SolenoidValve[19].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[19].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[19].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[19].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[19].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[19].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[37].cx =660+44*37;
		GroupSolenoidValve.SolenoidValve[37].cy =154+44*18;
		GroupSolenoidValve.SolenoidValve[37].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[37].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[37].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[37].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[37].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[37].drawGraph(canvas);
		

////////////////右抛锚绞车 放缆
		
		GroupSolenoidValve.SolenoidValve[5].cx =660+44*5;
		GroupSolenoidValve.SolenoidValve[5].cy =154+44*19;
		GroupSolenoidValve.SolenoidValve[5].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[5].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[5].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[5].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[5].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[18].cx =660+44*18;
		GroupSolenoidValve.SolenoidValve[18].cy =154+44*19;
		GroupSolenoidValve.SolenoidValve[18].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[18].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[18].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[18].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[18].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[18].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[37].cx =660+44*37;
		GroupSolenoidValve.SolenoidValve[37].cy =154+44*19;
		GroupSolenoidValve.SolenoidValve[37].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[37].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[37].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[37].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[37].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[37].drawGraph(canvas);
		

////////////////左抛锚绞车 收缆
		
		GroupSolenoidValve.SolenoidValve[5].cx =660+44*5;
		GroupSolenoidValve.SolenoidValve[5].cy =154+44*20;
		GroupSolenoidValve.SolenoidValve[5].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[5].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[5].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[5].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[5].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[21].cx =660+44*21;
		GroupSolenoidValve.SolenoidValve[21].cy =154+44*20;
		GroupSolenoidValve.SolenoidValve[21].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[21].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[21].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[21].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[21].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[21].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[37].cx =660+44*37;
		GroupSolenoidValve.SolenoidValve[37].cy =154+44*20;
		GroupSolenoidValve.SolenoidValve[37].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[37].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[37].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[37].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[37].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[37].drawGraph(canvas);


////////////////右抛锚绞车 放缆
		
		GroupSolenoidValve.SolenoidValve[5].cx =660+44*5;
		GroupSolenoidValve.SolenoidValve[5].cy =154+44*21;
		GroupSolenoidValve.SolenoidValve[5].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[5].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[5].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[5].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[5].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[20].cx =660+44*20;
		GroupSolenoidValve.SolenoidValve[20].cy =154+44*21;
		GroupSolenoidValve.SolenoidValve[20].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[20].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[20].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[20].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[20].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[20].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[37].cx =660+44*37;
		GroupSolenoidValve.SolenoidValve[37].cy =154+44*21;
		GroupSolenoidValve.SolenoidValve[37].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[37].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[37].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[37].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[37].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[37].drawGraph(canvas);

////////////////抛锚联动
		
		GroupSolenoidValve.SolenoidValve[22].cx =660+44*22;
		GroupSolenoidValve.SolenoidValve[22].cy =154+44*22;
		GroupSolenoidValve.SolenoidValve[22].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[22].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[22].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[22].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[22].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[22].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[23].cx =660+44*23;
		GroupSolenoidValve.SolenoidValve[23].cy =154+44*22;
		GroupSolenoidValve.SolenoidValve[23].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[23].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[23].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[23].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[23].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[23].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[24].cx =660+44*24;
		GroupSolenoidValve.SolenoidValve[24].cy =154+44*22;
		GroupSolenoidValve.SolenoidValve[24].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[24].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[24].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[24].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[24].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[24].drawGraph(canvas);
////////////////绞盘工作允许
		
		GroupSolenoidValve.SolenoidValve[5].cx =660+44*5;
		GroupSolenoidValve.SolenoidValve[5].cy =154+44*23;
		GroupSolenoidValve.SolenoidValve[5].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[5].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[5].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[5].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[5].drawGraph(canvas);
////////////////台车伸出
				
		GroupSolenoidValve.SolenoidValve[5].cx =660+44*5;
		GroupSolenoidValve.SolenoidValve[5].cy =154+44*24;
		GroupSolenoidValve.SolenoidValve[5].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[5].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[5].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[5].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[5].drawGraph(canvas);
				
		GroupSolenoidValve.SolenoidValve[32].cx =660+44*32;
		GroupSolenoidValve.SolenoidValve[32].cy =154+44*24;
		GroupSolenoidValve.SolenoidValve[32].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[32].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[32].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[32].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[32].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[32].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[37].cx =660+44*37;
		GroupSolenoidValve.SolenoidValve[37].cy =154+44*24;
		GroupSolenoidValve.SolenoidValve[37].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[37].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[37].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[37].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[37].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[37].drawGraph(canvas);
		

////////////////台车缩回
				
		GroupSolenoidValve.SolenoidValve[5].cx =660+44*5;
		GroupSolenoidValve.SolenoidValve[5].cy =154+44*25;
		GroupSolenoidValve.SolenoidValve[5].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[5].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[5].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[5].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[5].drawGraph(canvas);
				
		GroupSolenoidValve.SolenoidValve[31].cx =660+44*31;
		GroupSolenoidValve.SolenoidValve[31].cy =154+44*25;
		GroupSolenoidValve.SolenoidValve[31].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[31].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[31].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[31].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[31].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[31].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[37].cx =660+44*37;
		GroupSolenoidValve.SolenoidValve[37].cy =154+44*25;
		GroupSolenoidValve.SolenoidValve[37].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[37].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[37].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[37].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[37].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[37].drawGraph(canvas);

////////////////闸阀伸出
				
		GroupSolenoidValve.SolenoidValve[6].cx =660+44*6;
		GroupSolenoidValve.SolenoidValve[6].cy =154+44*26;
		GroupSolenoidValve.SolenoidValve[6].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[6].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[6].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[6].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[6].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[6].drawGraph(canvas);
				
		GroupSolenoidValve.SolenoidValve[33].cx =660+44*33;
		GroupSolenoidValve.SolenoidValve[33].cy =154+44*26;
		GroupSolenoidValve.SolenoidValve[33].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[33].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[33].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[33].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[33].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[33].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[37].cx =660+44*37;
		GroupSolenoidValve.SolenoidValve[37].cy =154+44*26;
		GroupSolenoidValve.SolenoidValve[37].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[37].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[37].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[37].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[37].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[37].drawGraph(canvas);


////////////////闸阀缩回
				
		GroupSolenoidValve.SolenoidValve[6].cx =660+44*6;
		GroupSolenoidValve.SolenoidValve[6].cy =154+44*27;
		GroupSolenoidValve.SolenoidValve[6].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[6].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[6].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[6].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[6].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[6].drawGraph(canvas);
				
		GroupSolenoidValve.SolenoidValve[34].cx =660+44*34;
		GroupSolenoidValve.SolenoidValve[34].cy =154+44*27;
		GroupSolenoidValve.SolenoidValve[34].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[34].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[34].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[34].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[34].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[34].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[37].cx =660+44*37;
		GroupSolenoidValve.SolenoidValve[37].cy =154+44*27;
		GroupSolenoidValve.SolenoidValve[37].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[37].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[37].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[37].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[37].adjustable =true;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[37].drawGraph(canvas);
		

////////////////储能器 伸出??充电?
				
		GroupSolenoidValve.SolenoidValve[6].cx =660+44*6;
		GroupSolenoidValve.SolenoidValve[6].cy =154+44*28;
		GroupSolenoidValve.SolenoidValve[6].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[6].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[6].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[6].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[6].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[6].drawGraph(canvas);
				
		GroupSolenoidValve.SolenoidValve[35].cx =660+44*35;
		GroupSolenoidValve.SolenoidValve[35].cy =154+44*28;
		GroupSolenoidValve.SolenoidValve[35].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[35].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[35].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[35].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[35].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[35].drawGraph(canvas);

////////////////储能器 放电
				
		GroupSolenoidValve.SolenoidValve[6].cx =660+44*6;
		GroupSolenoidValve.SolenoidValve[6].cy =154+44*29;
		GroupSolenoidValve.SolenoidValve[6].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[6].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[6].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[6].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[6].adjustable =false;  //电磁处可调节状态
//		GroupSolenoidValve.SolenoidValve[6].drawGraph(canvas);
				
		GroupSolenoidValve.SolenoidValve[36].cx =660+44*36;
		GroupSolenoidValve.SolenoidValve[36].cy =154+44*29;
		GroupSolenoidValve.SolenoidValve[36].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[36].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[36].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[36].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[36].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[36].drawGraph(canvas);
		
////////////////横移/杂用 快速
				
		GroupSolenoidValve.SolenoidValve[7].cx =660+44*7;
		GroupSolenoidValve.SolenoidValve[7].cy =154+44*30;
		GroupSolenoidValve.SolenoidValve[7].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[7].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[7].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[7].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[7].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[7].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[8].cx =660+44*8;
		GroupSolenoidValve.SolenoidValve[8].cy =154+44*30;
		GroupSolenoidValve.SolenoidValve[8].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[8].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[8].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[8].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[8].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[8].drawGraph(canvas);

////////////////应急 
				
		GroupSolenoidValve.SolenoidValve[5].cx =660+44*5;
		GroupSolenoidValve.SolenoidValve[5].cy =154+44*31;
		GroupSolenoidValve.SolenoidValve[5].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[5].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[5].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[5].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[5].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[6].cx =660+44*6;
		GroupSolenoidValve.SolenoidValve[6].cy =154+44*31;
		GroupSolenoidValve.SolenoidValve[6].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[6].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[6].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[6].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[6].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[6].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[8].cx =660+44*8;
		GroupSolenoidValve.SolenoidValve[8].cy =154+44*31;
		GroupSolenoidValve.SolenoidValve[8].rectWidth = 50;
		GroupSolenoidValve.SolenoidValve[8].rectHeight = 50;
		GroupSolenoidValve.SolenoidValve[8].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[8].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[8].adjustable =false;  //电磁处可调节状态
		GroupSolenoidValve.SolenoidValve[8].drawGraph(canvas);
//////////////////////////////////////////////////////////////////////////////
		paint.setAntiAlias(true);		//使用抗锯齿功能
		paint.setStrokeWidth(1); // 设置画笔的宽度
		paint.setColor(Color.GRAY);
		paint.setStyle(Paint.Style.STROKE);
		
		Rect rect = new Rect(30,88,2530,1540);
		canvas.drawRect(rect, paint);
		
		canvas.drawLine(351, 88, 351, 88+44*23, paint);//竖断点
		canvas.drawLine(351, 88+44*24, 351, 88+44*31, paint);//竖断点

		canvas.drawLine(682, 88+44*1, 2530, 88+44*1, paint);//3
		canvas.drawLine(351, 88+44*0, 682, 88+44*1, paint);//3
		canvas.drawLine(351, 88+44*0, 638, 88+44*2, paint);//3
		canvas.drawLine(638, 88+44*2, 638, 88+44*33, paint);//3
		
		
		for(int i=2;i<33;i++) {
			canvas.drawLine(351, 88+44*i, 2530, 88+44*i, paint);//行
		}
		for(int i=0;i<42;i++) {
			canvas.drawLine(682+44*i, 88, 682+44*i, 1540, paint);//列
		}
		canvas.drawLine(30, 88+44*2, 351, 88+44*2, paint);//1
		canvas.drawLine(30, 88+44*7, 351, 88+44*7, paint);//2
		canvas.drawLine(30, 88+44*9, 351, 88+44*9, paint);//3
		canvas.drawLine(30, 88+44*11, 351, 88+44*11, paint);//4
		canvas.drawLine(30, 88+44*13, 351, 88+44*13, paint);//5
		canvas.drawLine(30, 88+44*15, 351, 88+44*15, paint);//6
		canvas.drawLine(30, 88+44*17, 351, 88+44*17, paint);//7
		canvas.drawLine(30, 88+44*19, 351, 88+44*19, paint);//8
		canvas.drawLine(30, 88+44*21, 351, 88+44*21, paint);//9
		canvas.drawLine(30, 88+44*23, 351, 88+44*23, paint);//10
		canvas.drawLine(30, 88+44*24, 351, 88+44*24, paint);//11
		canvas.drawLine(30, 88+44*25, 351, 88+44*25, paint);//12
		canvas.drawLine(30, 88+44*27, 351, 88+44*27, paint);//13
		canvas.drawLine(30, 88+44*29, 351, 88+44*29, paint);//14
		canvas.drawLine(30, 88+44*31, 351, 88+44*31, paint);//15
		canvas.drawLine(30, 88+44*32, 351, 88+44*32, paint);//16
		canvas.drawLine(30, 88+44*33, 351, 88+44*33, paint);//17
//////////////////////////////////////////////////////////////////////////////
		paint.setStyle(Paint.Style.FILL);
		paint.setTextSize(60);
		paint.setColor(Color.GRAY);
		canvas.drawText("*", 50,  1602, paint);
		paint.setTextSize(36);
		canvas.drawText("Specification:", 80,  1585, paint);
		canvas.drawText("Electromagnet loss", 270+300-100,  1585, paint);//电磁铁失电 Electromagnets  power off
		canvas.drawText("electromagnet is conditional", 550+300,  1585, paint);//电磁铁有条件得电
		canvas.drawText("proportional electromagnet is adjustable", 930+300+150,  1585, paint);//比例电磁铁处可调节状态
		canvas.drawText("Electromagnet electricity", 1410+300+400,  1585, paint);//电磁铁得电
		paint.setColor(Color.LTGRAY);
		paint.setTextSize(24);
		paint.setTextAlign(Align.CENTER);
		paint.setColor(Color.rgb(131, 175, 155));
		canvas.drawText("Name", 186, 88+(44*0)+(44*2/2)+10, paint);
		canvas.drawText("Bucket Wheel Drive", 186, 88+(44*2)+(44*5/2)+1, paint);//斗轮驱动
		canvas.drawText("Left Sidesway Winch", 186, 88+(44*7)+(44*2/2)+10, paint);//左横移绞车
		canvas.drawText("Right Sidesway Winch", 186, 88+(44*9)+(44*2/2)+10, paint);//右横移绞车
		canvas.drawText("Sidesway Winch Linkage", 186, 88+(44*11)+(44*2/2)+10, paint);//横移绞车联动
		canvas.drawText("Left Spud", 186, 88+(44*13)+(44*2/2)+10, paint);//左桩
		canvas.drawText("Right Spud", 186, 88+(44*15)+(44*2/2)+10, paint);//右桩
		canvas.drawText("Bridge Winch", 186, 88+(44*17)+(44*2/2)+10, paint);//桥架绞车
		canvas.drawText("Left To Anchor Winch", 186, 88+(44*19)+(44*2/2)+10, paint);//左抛锚绞车
		canvas.drawText("Right To Anchor Winch", 186, 88+(44*21)+(44*2/2)+10, paint);//右抛锚绞车
		canvas.drawText("To Anchor Linkage", 351, 88+(44*23)+(44*1/2)+10, paint);//抛锚联动
		canvas.drawText("Capstan", 186, 88+(44*24)+(44*1/2)+10, paint);//绞盘
		canvas.drawText("Carrier", 186, 88+(44*25)+(44*2/2)+10, paint);//台车
		canvas.drawText("Sluice Valve", 186, 88+(44*27)+(44*2/2)+10, paint);//闸阀
		canvas.drawText("Accumulator", 186, 88+(44*29)+(44*2/2)+10, paint);//储能器
		canvas.drawText("Miscellaneous/Sidesway Rapid ", 351, 88+(44*31)+(44*1/2)+10, paint);//横移/杂用 快速
		canvas.drawText("Emergency", 351, 88+(44*32)+(44*1/2)+10, paint);//应急
		paint.setTextSize(20);
		canvas.drawText("S1",704+44*0,117, paint);
		canvas.drawText("S2",704+44*1,117, paint);
		canvas.drawText("S3",704+44*2,117, paint);
		canvas.drawText("S4",704+44*3,117, paint);
		canvas.drawText("S5",704+44*4,117, paint);
		canvas.drawText("S6",704+44*5,117, paint);
		canvas.drawText("S7",704+44*6,117, paint);
		canvas.drawText("S8",704+44*7,117, paint);
		canvas.drawText("S9",704+44*8,117, paint);
		canvas.drawText("S10",704+44*9,117, paint);
		canvas.drawText("S11",704+44*10,117, paint);
		canvas.drawText("S12",704+44*11,117, paint);
		canvas.drawText("S13",704+44*12,117, paint);
		canvas.drawText("S14",704+44*13,117, paint);
		canvas.drawText("S15",704+44*14,117, paint);
		canvas.drawText("S16",704+44*15,117, paint);
		canvas.drawText("S17",704+44*16,117, paint);
		canvas.drawText("S18",704+44*17,117, paint);
		canvas.drawText("S19",704+44*18,117, paint);
		canvas.drawText("S20",704+44*19,117, paint);
		canvas.drawText("S21",704+44*20,117, paint);
		canvas.drawText("S22",704+44*21,117, paint);
		canvas.drawText("S23",704+44*22,117, paint);
		canvas.drawText("S24",704+44*23,117, paint);
		canvas.drawText("S25",704+44*24,117, paint);
		canvas.drawText("S26",704+44*25,117, paint);
		canvas.drawText("S27",704+44*26,117, paint);
		canvas.drawText("S28",704+44*27,117, paint);
		canvas.drawText("S29",704+44*28,117, paint);
		canvas.drawText("S30",704+44*29,117, paint);
		canvas.drawText("S31",704+44*30,117, paint);
		canvas.drawText("S32",704+44*31,117, paint);
		canvas.drawText("S33",704+44*32,117, paint);
		canvas.drawText("S34",704+44*33,117, paint);
		canvas.drawText("S35",704+44*34,117, paint);
		canvas.drawText("S36",704+44*35,117, paint);
		canvas.drawText("e1",704+44*36,117, paint);
		canvas.drawText("e2",704+44*37,117, paint);
		canvas.drawText("e3",704+44*38,117, paint);
		canvas.drawText("hl1",704+44*39,117, paint);
		canvas.drawText("hl2",704+44*40,117, paint);
		canvas.drawText("hl3",704+44*41,117, paint);

		paint.setColor(Color.rgb(138, 151, 123));
		paint.setTextSize(20);
		canvas.drawText("speed 1", 495, 88+(44*2)+(44/2)+10, paint);
		canvas.drawText("speed 2", 495, 88+(44*3)+(44/2)+10, paint);
		canvas.drawText("speed 3", 495, 88+(44*4)+(44/2)+10, paint);
		canvas.drawText("positive", 495, 88+(44*5)+(44/2)+10, paint);
		canvas.drawText("negative", 495, 88+(44*6)+(44/2)+10, paint);
		canvas.drawText("hauling", 495, 88+(44*7)+(44/2)+10, paint);
		canvas.drawText("release", 495, 88+(44*8)+(44/2)+10, paint);
		canvas.drawText("hauling", 495, 88+(44*9)+(44/2)+10, paint);
		canvas.drawText("release", 495, 88+(44*10)+(44/2)+10, paint);
		canvas.drawText("left hauling right release", 495, 88+(44*11)+(44/2)+10, paint);
		canvas.drawText("right hauling left release", 495, 88+(44*12)+(44/2)+10, paint);
		canvas.drawText("hoist", 495, 88+(44*13)+(44/2)+10, paint);
		canvas.drawText("lower", 495, 88+(44*14)+(44/2)+10, paint);
		canvas.drawText("hoist", 495, 88+(44*15)+(44/2)+10, paint);
		canvas.drawText("lower", 495, 88+(44*16)+(44/2)+10, paint);
		canvas.drawText("hoist", 495, 88+(44*17)+(44/2)+10, paint);
		canvas.drawText("lower", 495, 88+(44*18)+(44/2)+10, paint);
		canvas.drawText("hauling", 495, 88+(44*19)+(44/2)+10, paint);
		canvas.drawText("release", 495, 88+(44*20)+(44/2)+10, paint);
		canvas.drawText("hauling", 495, 88+(44*21)+(44/2)+10, paint);
		canvas.drawText("release", 495, 88+(44*22)+(44/2)+10, paint);
		canvas.drawText("working allow", 495, 88+(44*24)+(44/2)+10, paint);
		canvas.drawText("protruding ", 495, 88+(44*25)+(44/2)+10, paint);
		canvas.drawText("retracting", 495, 88+(44*26)+(44/2)+10, paint);
		canvas.drawText("protruding ", 495, 88+(44*27)+(44/2)+10, paint);
		canvas.drawText("retracting", 495, 88+(44*28)+(44/2)+10, paint);
		canvas.drawText("charging ", 495, 88+(44*29)+(44/2)+10, paint);//充电
		canvas.drawText("release", 495, 88+(44*30)+(44/2)+10, paint);//放电
		
		
		//////////////////////////////////////////////////////////////////////////////////
		paint.setTextAlign(Align.LEFT);
		paint.setColor(Color.YELLOW);	
		paint.setTextSize(30);
		canvas.drawText("Page 2:", 10, 30, paint);
		paint.setColor(Color.GREEN);
		canvas.drawText("Excitation", 120, 30, paint);
		paint.setColor(Color.YELLOW);
		// 电池电量，WIFI强度，日期，PLC状态
		canvas.drawText(GateValveActivity.dateString, 330+250, 30, paint);// 时间
		paint.setColor(Color.GREEN);
		canvas.drawText("Battery：" + GateValveActivity.battery + "%", 750+200, 30, paint);
		paint.setColor(Color.YELLOW);
		canvas.drawText("WIFi：" + ((Integer) GateValveActivity.strength).toString() + "%", 1065+100, 30, paint);
		canvas.drawText("PLC States: ", 1365, 30, paint);
		if (NewMyService.plcconect1) {
			paint.setColor(Color.GREEN);
			canvas.drawText(" Connect", 1515, 20, paint);
		} else {
			paint.setColor(Color.RED);
			canvas.drawText(" Disconnect", 1515, 20, paint);
		}
		if (NewMyService.plcconect2) {
			paint.setColor(Color.GREEN);
			canvas.drawText(" Connect", 1515, 40, paint);
		} else {
			paint.setColor(Color.RED);
			canvas.drawText(" Disconnect", 1515, 40, paint);
		}
		paint.setColor(Color.YELLOW);
		canvas.drawText("SD Free Space: " + GateValveActivity.SdVolume + " MB", 1720, 30, paint);
		paint.setColor(Color.WHITE);
		canvas.drawText("Local IP: " + GateValveActivity.ip, 2170, 30, paint);// ip
		// 屏幕上下预留分割线
		paint.setColor(Color.GRAY);
		paint.setTextSize(3);
//		canvas.drawLine(0, 1530, 2560, 1530, paint);
		canvas.drawLine(0, 50, 2560, 50, paint);

		TextPaint textPaint = new TextPaint();
		textPaint.setTextSize(25);
		textPaint.setAntiAlias(true);
		textPaint.setColor(Color.LTGRAY);
		paint.setStyle(Style.FILL);

		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(3);
		PathEffect effects = new DashPathEffect(new float[] { 10, 5, 10, 10 }, 1);
		paint.setPathEffect(effects);

		paint.setStyle(Style.STROKE);
	}
}