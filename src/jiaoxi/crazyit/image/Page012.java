package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Page012 {//电磁阀
	public static void DrawPage(Canvas canvas) {
		Paint paint = new Paint();
		//下面说明中    电磁阀得电
		GroupSolenoidValve.SolenoidValve0[0].cx =240;//不配信号
		GroupSolenoidValve.SolenoidValve0[0].cy = 1570;
		GroupSolenoidValve.SolenoidValve0[0].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[0].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[0].blink_sign = false;
		GroupSolenoidValve.SolenoidValve0[0].electricity =true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[0].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[0].adjustable = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[0].drawGraph(canvas);
		//下面说明中    电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[1].cx =520;//不配信号
		GroupSolenoidValve.SolenoidValve0[1].cy = 1570;
		GroupSolenoidValve.SolenoidValve0[1].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[1].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[1].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[1].conditional_electricity =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[1].adjustable = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[1].drawGraph(canvas);
		//下面说明中    电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].cx = 900;// 不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 1570;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 43;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 40;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false; // 电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false; // 电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable = true; // 电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		// 下面说明中 电磁阀得电
		GroupSolenoidValve.SolenoidValve0[0].cx = 1370;// 不配信号
		GroupSolenoidValve.SolenoidValve0[0].cy = 1570;
		GroupSolenoidValve.SolenoidValve0[0].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[0].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[0].blink_sign = true;
		GroupSolenoidValve.SolenoidValve0[0].electricity = false; // 电磁阀得电
		GroupSolenoidValve.SolenoidValve0[0].conditional_electricity = false; // 电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[0].adjustable = false; // 电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[0].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*40;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*1;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*40;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*2;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*42;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*3;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*42;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*4;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*42;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*5;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*42;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*6;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*42;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*7;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*42;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*8;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*9;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*10;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*11;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*12;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*13;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*14;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*15;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*16;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*17;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*18;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*19;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*20;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*21;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*22;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

//		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
//		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*23;
//		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
//		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
//		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
//		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
//		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
//		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*24;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*25;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

//		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
//		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*26;
//		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
//		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
//		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
//		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
//		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
//		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*27;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*28;
		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);

//		GroupSolenoidValve.SolenoidValve0[2].cx =411+50*41;//不配信号
//		GroupSolenoidValve.SolenoidValve0[2].cy = 85+45*29;
//		GroupSolenoidValve.SolenoidValve0[2].rectWidth = 48;
//		GroupSolenoidValve.SolenoidValve0[2].rectHeight = 44;
//		GroupSolenoidValve.SolenoidValve0[2].electricity = false;  //电磁阀得电
//		GroupSolenoidValve.SolenoidValve0[2].conditional_electricity = false;  //电磁阀有条件得电
//		GroupSolenoidValve.SolenoidValve0[2].adjustable =true;  //电磁阀有条件得电
//		GroupSolenoidValve.SolenoidValve0[2].drawGraph(canvas);
		

		
		GroupSolenoidValve.SolenoidValve[0].cx =411+50*1;//不配信号
		GroupSolenoidValve.SolenoidValve[0].cy = 85+45*1;
		GroupSolenoidValve.SolenoidValve[0].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[0].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[0].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[0].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[0].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[0].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[0].cx =411+50*1;//不配信号
		GroupSolenoidValve.SolenoidValve[0].cy = 85+45*2;
		GroupSolenoidValve.SolenoidValve[0].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[0].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[0].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[0].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[0].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[0].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[1].cx =411+50*2;//不配信号
		GroupSolenoidValve.SolenoidValve[1].cy = 85+45*1;
		GroupSolenoidValve.SolenoidValve[1].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[1].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[1].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[1].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[1].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[1].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[2].cx =411+50*3;//不配信号
		GroupSolenoidValve.SolenoidValve[2].cy = 85+45*2;
		GroupSolenoidValve.SolenoidValve[2].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[2].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[2].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[2].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[2].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[2].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[3].cx =411+50*4;//不配信号
		GroupSolenoidValve.SolenoidValve[3].cy = 85+45*3;
		GroupSolenoidValve.SolenoidValve[3].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[3].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[3].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[3].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[3].cx =411+50*4;//不配信号
		GroupSolenoidValve.SolenoidValve[3].cy = 85+45*4;
		GroupSolenoidValve.SolenoidValve[3].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[3].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[3].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[3].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[3].cx =411+50*4;//不配信号
		GroupSolenoidValve.SolenoidValve[3].cy = 85+45*5;
		GroupSolenoidValve.SolenoidValve[3].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[3].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[3].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[3].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].drawGraph(canvas);
		
		
		GroupSolenoidValve.SolenoidValve[3].cx =411+50*4;//不配信号
		GroupSolenoidValve.SolenoidValve[3].cy = 85+45*6;
		GroupSolenoidValve.SolenoidValve[3].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[3].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[3].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[3].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].drawGraph(canvas);
		
		
		GroupSolenoidValve.SolenoidValve[3].cx =411+50*4;//不配信号
		GroupSolenoidValve.SolenoidValve[3].cy = 85+45*7;
		GroupSolenoidValve.SolenoidValve[3].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[3].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[3].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[3].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[3].cx =411+50*4;//不配信号
		GroupSolenoidValve.SolenoidValve[3].cy = 85+45*8;
		GroupSolenoidValve.SolenoidValve[3].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[3].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[3].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[3].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[3].cx =411+50*4;//不配信号
		GroupSolenoidValve.SolenoidValve[3].cy = 85+45*32;
		GroupSolenoidValve.SolenoidValve[3].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[3].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[3].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[3].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[3].drawGraph(canvas);
		
		
		GroupSolenoidValve.SolenoidValve[4].cx =411+50*5;//不配信号
		GroupSolenoidValve.SolenoidValve[4].cy = 85+45*4;
		GroupSolenoidValve.SolenoidValve[4].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[4].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[4].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[4].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[4].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[4].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[5].cx =411+50*6;//不配信号
		GroupSolenoidValve.SolenoidValve[5].cy = 85+45*3;
		GroupSolenoidValve.SolenoidValve[5].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[5].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[5].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[5].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[5].cx =411+50*6;//不配信号
		GroupSolenoidValve.SolenoidValve[5].cy = 85+45*7;
		GroupSolenoidValve.SolenoidValve[5].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[5].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[5].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[5].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[5].drawGraph(canvas);
		
		
		GroupSolenoidValve.SolenoidValve[6].cx =411+50*7;//不配信号
		GroupSolenoidValve.SolenoidValve[6].cy = 85+45*6;
		GroupSolenoidValve.SolenoidValve[6].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[6].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[6].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[6].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[6].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[6].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[7].cx =411+50*8;//不配信号
		GroupSolenoidValve.SolenoidValve[7].cy = 85+45*5;
		GroupSolenoidValve.SolenoidValve[7].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[7].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[7].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[7].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[7].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[7].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[7].cx =411+50*8;//不配信号
		GroupSolenoidValve.SolenoidValve[7].cy = 85+45*8;
		GroupSolenoidValve.SolenoidValve[7].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[7].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[7].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[7].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[7].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[7].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[8].cx =411+50*9;//不配信号
		GroupSolenoidValve.SolenoidValve[8].cy = 85+45*8;
		GroupSolenoidValve.SolenoidValve[8].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[8].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[8].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[8].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[8].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[8].drawGraph(canvas);
		

		GroupSolenoidValve.SolenoidValve[9].cx =411+50*10;//不配信号
		GroupSolenoidValve.SolenoidValve[9].cy = 85+45*7;
		GroupSolenoidValve.SolenoidValve[9].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[9].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[9].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[9].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[9].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[9].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*9;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*10;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*11;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*12;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*13;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*14;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*15;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*16;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity =true ;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*17;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*18;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity =true ;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*19;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity =true ;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*20;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity =true ;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*21;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*22;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*23;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*24;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*25;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*26;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*27;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*28;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*29;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*30;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*31;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = true;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[10].cx =411+50*11;//不配信号
		GroupSolenoidValve.SolenoidValve[10].cy = 85+45*32;
		GroupSolenoidValve.SolenoidValve[10].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[10].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[10].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[10].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[10].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[11].cx =411+50*12;//不配信号
		GroupSolenoidValve.SolenoidValve[11].cy = 85+45*16;
		GroupSolenoidValve.SolenoidValve[11].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[11].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[11].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[11].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[11].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[11].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[11].cx =411+50*12;//不配信号
		GroupSolenoidValve.SolenoidValve[11].cy = 85+45*18;
		GroupSolenoidValve.SolenoidValve[11].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[11].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[11].electricity = false;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[11].conditional_electricity = true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[11].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[11].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[11].cx =411+50*12;//不配信号
		GroupSolenoidValve.SolenoidValve[11].cy = 85+45*23;
		GroupSolenoidValve.SolenoidValve[11].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[11].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[11].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[11].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[11].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[11].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[11].cx =411+50*12;//不配信号
		GroupSolenoidValve.SolenoidValve[11].cy = 85+45*26;
		GroupSolenoidValve.SolenoidValve[11].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[11].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[11].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[11].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[11].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[11].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[11].cx =411+50*12;//不配信号
		GroupSolenoidValve.SolenoidValve[11].cy = 85+45*29;
		GroupSolenoidValve.SolenoidValve[11].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[11].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[11].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[11].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[11].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[11].drawGraph(canvas);
		

		GroupSolenoidValve.SolenoidValve[12].cx =411+50*13;//不配信号
		GroupSolenoidValve.SolenoidValve[12].cy = 85+45*9;
		GroupSolenoidValve.SolenoidValve[12].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[12].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[12].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[12].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[12].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[12].drawGraph(canvas);
		

		GroupSolenoidValve.SolenoidValve[13].cx =411+50*14;//不配信号
		GroupSolenoidValve.SolenoidValve[13].cy = 85+45*10;
		GroupSolenoidValve.SolenoidValve[13].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[13].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[13].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[13].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[13].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[13].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[14].cx =411+50*15;//不配信号
		GroupSolenoidValve.SolenoidValve[14].cy = 85+45*12;
		GroupSolenoidValve.SolenoidValve[14].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[14].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[14].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[14].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[14].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[14].drawGraph(canvas);
		

		GroupSolenoidValve.SolenoidValve[15].cx =411+50*16;//不配信号
		GroupSolenoidValve.SolenoidValve[15].cy = 85+45*11;
		GroupSolenoidValve.SolenoidValve[15].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[15].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[15].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[15].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[15].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[15].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[16].cx =411+50*17;//不配信号
		GroupSolenoidValve.SolenoidValve[16].cy = 85+45*14;
		GroupSolenoidValve.SolenoidValve[16].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[16].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[16].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[16].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[16].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[16].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[17].cx =411+50*18;//不配信号
		GroupSolenoidValve.SolenoidValve[17].cy = 85+45*13;
		GroupSolenoidValve.SolenoidValve[17].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[17].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[17].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[17].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[17].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[17].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[18].cx =411+50*19;//不配信号
		GroupSolenoidValve.SolenoidValve[18].cy = 85+45*17;
		GroupSolenoidValve.SolenoidValve[18].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[18].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[18].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[18].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[18].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[18].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[19].cx =411+50*20;//不配信号
		GroupSolenoidValve.SolenoidValve[19].cy = 85+45*15;
		GroupSolenoidValve.SolenoidValve[19].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[19].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[19].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[19].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[19].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[19].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[20].cx =411+50*21;//不配信号
		GroupSolenoidValve.SolenoidValve[20].cy = 85+45*16;
		GroupSolenoidValve.SolenoidValve[20].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[20].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[20].electricity = false ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[20].conditional_electricity =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[20].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[20].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[21].cx =411+50*22;//不配信号
		GroupSolenoidValve.SolenoidValve[21].cy = 85+45*18;
		GroupSolenoidValve.SolenoidValve[21].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[21].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[21].electricity = false ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[21].conditional_electricity =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[21].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[21].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[22].cx =411+50*23;//不配信号
		GroupSolenoidValve.SolenoidValve[22].cy = 85+45*20;
		GroupSolenoidValve.SolenoidValve[22].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[22].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[22].electricity = false ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[22].conditional_electricity =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[22].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[22].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[23].cx =411+50*24;//不配信号
		GroupSolenoidValve.SolenoidValve[23].cy = 85+45*19;
		GroupSolenoidValve.SolenoidValve[23].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[23].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[23].electricity = false ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[23].conditional_electricity =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[23].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[23].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[24].cx =411+50*25;//不配信号
		GroupSolenoidValve.SolenoidValve[24].cy = 85+45*21;
		GroupSolenoidValve.SolenoidValve[24].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[24].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[24].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[24].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[24].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[24].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[25].cx =411+50*26;//不配信号
		GroupSolenoidValve.SolenoidValve[25].cy = 85+45*22;
		GroupSolenoidValve.SolenoidValve[25].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[25].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[25].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[25].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[25].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[25].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[26].cx =411+50*27;//不配信号
		GroupSolenoidValve.SolenoidValve[26].cy = 85+45*24;
		GroupSolenoidValve.SolenoidValve[26].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[26].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[26].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[26].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[26].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[26].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[27].cx =411+50*28;//不配信号
		GroupSolenoidValve.SolenoidValve[27].cy = 85+45*25;
		GroupSolenoidValve.SolenoidValve[27].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[27].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[27].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[27].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[27].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[27].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[28].cx =411+50*29;//不配信号
		GroupSolenoidValve.SolenoidValve[28].cy = 85+45*27;
		GroupSolenoidValve.SolenoidValve[28].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[28].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[28].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[28].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[28].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[28].drawGraph(canvas);
		

		GroupSolenoidValve.SolenoidValve[29].cx =411+50*30;//不配信号
		GroupSolenoidValve.SolenoidValve[29].cy = 85+45*28;
		GroupSolenoidValve.SolenoidValve[29].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[29].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[29].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[29].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[29].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[29].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[30].cx =411+50*31;//不配信号
		GroupSolenoidValve.SolenoidValve[30].cy = 85+45*23;
		GroupSolenoidValve.SolenoidValve[30].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[30].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[30].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[30].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[30].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[30].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[31].cx =411+50*32;//不配信号
		GroupSolenoidValve.SolenoidValve[31].cy = 85+45*26;
		GroupSolenoidValve.SolenoidValve[31].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[31].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[31].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[31].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[31].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[31].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[32].cx =411+50*33;//不配信号
		GroupSolenoidValve.SolenoidValve[32].cy = 85+45*29;
		GroupSolenoidValve.SolenoidValve[32].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[32].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[32].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[32].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[32].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[32].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[33].cx =411+50*34;//不配信号
		GroupSolenoidValve.SolenoidValve[33].cy = 85+45*23;
		GroupSolenoidValve.SolenoidValve[33].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[33].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[33].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[33].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[33].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[33].drawGraph(canvas);

		GroupSolenoidValve.SolenoidValve[34].cx =411+50*35;//不配信号
		GroupSolenoidValve.SolenoidValve[34].cy = 85+45*26;
		GroupSolenoidValve.SolenoidValve[34].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[34].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[34].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[34].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[34].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[34].drawGraph(canvas);
		

		GroupSolenoidValve.SolenoidValve[35].cx =411+50*36;//不配信号
		GroupSolenoidValve.SolenoidValve[35].cy = 85+45*29;
		GroupSolenoidValve.SolenoidValve[35].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[35].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[35].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[35].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[35].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[35].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[36].cx =411+50*37;//不配信号
		GroupSolenoidValve.SolenoidValve[36].cy = 85+45*30;
		GroupSolenoidValve.SolenoidValve[36].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[36].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[36].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[36].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[36].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[36].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[37].cx =411+50*38;//不配信号
		GroupSolenoidValve.SolenoidValve[37].cy = 85+45*31;
		GroupSolenoidValve.SolenoidValve[37].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[37].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[37].electricity = true ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[37].conditional_electricity =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[37].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[37].drawGraph(canvas);
		
		GroupSolenoidValve.SolenoidValve[38].cx =411+50*39;//不配信号
		GroupSolenoidValve.SolenoidValve[38].cy = 85+45*32;
		GroupSolenoidValve.SolenoidValve[38].rectWidth = 52;
		GroupSolenoidValve.SolenoidValve[38].rectHeight = 48;
		GroupSolenoidValve.SolenoidValve[38].electricity = false ;  //电磁阀得电
		GroupSolenoidValve.SolenoidValve[38].conditional_electricity =true;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[38].adjustable =false;  //电磁阀有条件得电
		GroupSolenoidValve.SolenoidValve[38].drawGraph(canvas);

		paint.setAntiAlias(true);		//使用抗锯齿功能
		paint.setStrokeWidth(3); // 设置画笔的宽度
		paint.setColor(Color.GRAY);
		paint.setStyle(Paint.Style.STROKE);
		canvas.drawRect(20,60,2540,60+45*33,paint);
		canvas.drawLine(260,60,260,60+45*33,paint);
		canvas.drawLine(280,60,410,109,paint);
		
		canvas.drawLine(20,60+45*32,2540,60+45*32,paint);
		
		for(int i=1;i<=3;i++){
			canvas.drawLine(20,60+45*21+45*3*i,2540,60+45*21+45*3*i,paint);
		}
		for(int i=0;i<=10;i++){
			canvas.drawLine(20,60+45*1+45*2*i,2540,60+45*1+45*2*i,paint);	
		}	
		paint.setStrokeWidth(1); // 设置画笔的宽度
		for(int i=1;i<34;i++){
			canvas.drawLine(260,60+45*i,2540,60+45*i,paint);	
		}
		for(int i=0;i<42;i++){
			canvas.drawLine(438+50*i,60,438+50*i,60+45*33,paint);
		}
		
		paint.setStyle(Paint.Style.FILL);
		paint.setTextSize(60);
		paint.setColor(Color.YELLOW);
		canvas.drawText("*", 50,  1602, paint);
		paint.setTextSize(36);
		canvas.drawText("说明书:", 80,  1585, paint);
		canvas.drawText("电磁铁失电", 270,  1585, paint);
		canvas.drawText("电磁铁有条件得电", 550,  1585, paint);
		canvas.drawText("比例电磁铁处可调节状态", 930,  1585, paint);
		canvas.drawText("电磁铁得电", 1410,  1585, paint);
		paint.setColor(Color.LTGRAY);
		paint.setTextSize(36);
		canvas.drawText("名  称", 90,  97, paint);
		canvas.drawText("绞刀驱动", 70,  72+45*2, paint);
		canvas.drawText("左横移绞车", 55,  72+45*4, paint); 
		canvas.drawText("右横移绞车", 55,  72+45*6, paint);
		canvas.drawText("横移联动", 70,  72+45*8, paint);
		canvas.drawText("桥架绞车", 70,  72+45*10, paint);
		canvas.drawText("绞刀调整油缸", 35,  72+45*12, paint);
		canvas.drawText("绞刀罩壳油缸", 35,  72+45*14, paint);
		canvas.drawText("主  桩", 90,  72+45*16, paint);
		canvas.drawText("副  桩", 90,  72+45*18, paint);
		canvas.drawText("台  车", 90,  72+45*20, paint);
		canvas.drawText("左锚定位绞车", 35,  72+45*22.5f, paint);
		canvas.drawText("右锚定位绞车", 35,  72+45*25.5f, paint);
		canvas.drawText("艉锚定位绞车", 35,  72+45*28.5f, paint);
		canvas.drawText("定位绞车油缸", 35,  72+45*31f, paint);
		paint.setTextSize(34);
		canvas.drawText("杂用/横移快速", 32,  72+45*32.5f, paint);
		
		paint.setTextSize(28);
		canvas.drawText("动作", 270,  97, paint);
		canvas.drawText("线圈号", 354,  85, paint);
		paint.setTextSize(30);
//		if(GateValveActivity.action_status[0])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("正  转", 310,  97+45*1, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("正  转", 310,  97+45*1, paint);
//		}
//		if(GateValveActivity.action_status[1])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("反  转", 310,  97+45*2, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("反  转", 310,  97+45*2, paint);
//		}
//		if(GateValveActivity.action_status[2])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("收  揽", 310,  97+45*3, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("收  揽", 310,  97+45*3, paint);
//		}
//
//		if(GateValveActivity.action_status[3])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("放  缆", 310,  97+45*4, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("放  缆", 310,  97+45*4, paint);
//		}
//		if(GateValveActivity.action_status[4])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("收  揽", 310,  97+45*5, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("收  揽", 310,  97+45*5, paint);
//		}
//		if(GateValveActivity.action_status[5])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("放  缆", 310,  97+45*6, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("放  缆", 310,  97+45*6, paint);
//		}
//
//		if(GateValveActivity.action_status[6])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("左收右放", 290,  97+45*7, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("左收右放", 290,  97+45*7, paint);
//		}
//		if(GateValveActivity.action_status[7])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("右收左放", 290,  97+45*8, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("右收左放", 290,  97+45*8, paint);
//		}
//		if(GateValveActivity.action_status[8])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("提  升", 310,  97+45*9, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("提  升", 310,  97+45*9, paint);
//		}
//		if(GateValveActivity.action_status[9])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("下  放", 310,  97+45*10, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("下  放", 310,  97+45*10, paint);
//		}
//		if(GateValveActivity.action_status[10])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("伸  出", 310,  97+45*11, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("伸  出", 310,  97+45*11, paint);
//		}
//		if(GateValveActivity.action_status[11])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("缩  回", 310,  97+45*12, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("缩  回", 310,  97+45*12, paint);
//		}
//		if(GateValveActivity.action_status[12])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("伸  出", 310,  97+45*13, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("伸  出", 310,  97+45*13, paint);
//		}
//		if(GateValveActivity.action_status[13])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("缩  回", 310,  97+45*14, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("缩  回", 310,  97+45*14, paint);
//		}
//		if(GateValveActivity.action_status[14])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("起  桩", 310,  97+45*15, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("起  桩", 310,  97+45*15, paint);
//		}
//		if(GateValveActivity.action_status[15])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("落  桩", 310,  97+45*16, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("落  桩", 310,  97+45*16, paint);
//		}
//		if(GateValveActivity.action_status[16])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("起  桩", 310,  97+45*17, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("起  桩", 310,  97+45*17, paint);
//		}
//		if(GateValveActivity.action_status[17])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("落  桩", 310,  97+45*18, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("落  桩", 310,  97+45*18, paint);
//		}
//		if(GateValveActivity.action_status[18])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("伸  出", 310,  97+45*19, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("伸  出", 310,  97+45*19, paint);
//		}
//		if(GateValveActivity.action_status[19])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("缩  回", 310,  97+45*20, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("缩  回", 310,  97+45*20, paint);
//		}
//		if(GateValveActivity.action_status[20])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("收  揽", 310,  97+45*21, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("收  揽", 310,  97+45*21, paint);
//		}
//		if(GateValveActivity.action_status[21])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("放  缆", 310,  97+45*22, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("放  缆", 310,  97+45*22, paint);
//		}
//		if(GateValveActivity.action_status[22])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("恒张力随动", 275,  97+45*23, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("恒张力随动", 275,  97+45*23, paint);
//		}
//		if(GateValveActivity.action_status[23])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("收  揽", 310,  97+45*24, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("收  揽", 310,  97+45*24, paint);
//		}
//		if(GateValveActivity.action_status[24])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("放  缆", 310,  97+45*25, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("放  缆", 310,  97+45*25, paint);
//		}
//		if(GateValveActivity.action_status[25])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("恒张力随动", 275,  97+45*26, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("恒张力随动", 275,  97+45*26, paint);
//		}
//		if(GateValveActivity.action_status[26])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("收  揽", 310,  97+45*27, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("收  揽", 310,  97+45*27, paint);
//		}
//		if(GateValveActivity.action_status[27])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("放  缆", 310,  97+45*28, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("放  缆", 310,  97+45*28, paint);
//		}
//		if(GateValveActivity.action_status[28])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("恒张力随动", 275,  97+45*29, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("恒张力随动", 275,  97+45*29, paint);
//		}
//		if(GateValveActivity.action_status[29])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("伸  出", 310,  97+45*30, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("伸  出", 310,  97+45*30, paint);
//		}
//		if(GateValveActivity.action_status[30])
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("缩  回", 310,  97+45*31, paint);
//		}
//		else
//		{
//			paint.setColor(Color.LTGRAY);
//			canvas.drawText("缩  回", 310,  97+45*31, paint);
//		}
		
	
		paint.setTextSize(28);
		canvas.drawText("S1", 450,  97, paint);
		canvas.drawText("S2", 450+50*1,  97, paint);
		canvas.drawText("S3", 450+50*2,  97, paint);
		canvas.drawText("S4", 450+50*3,  97, paint);
		canvas.drawText("S5", 450+50*4,  97, paint);
		canvas.drawText("S6", 450+50*5,  97, paint);
		canvas.drawText("S7", 450+50*6,  97, paint);
		canvas.drawText("S8", 450+50*7,  97, paint);
		canvas.drawText("S9", 450+50*8,  97, paint);
		paint.setTextSize(24);
		canvas.drawText("S10", 445+50*9, 97, paint);
		canvas.drawText("S11", 445+50*10, 97, paint);
		canvas.drawText("S12", 445+50*11, 97, paint);
		canvas.drawText("S13", 445+50*12, 97, paint);
		canvas.drawText("S14", 445+50*13, 97, paint);
		canvas.drawText("S15", 445+50*14, 97, paint);
		canvas.drawText("S16", 445+50*15, 97, paint);
		canvas.drawText("S17", 445+50*16, 97, paint);
		canvas.drawText("S18", 445+50*17, 97, paint);
		canvas.drawText("S19", 445+50*18, 97, paint);
		canvas.drawText("S20", 445+50*19, 97, paint);
		canvas.drawText("S21", 445+50*20, 97, paint);
		canvas.drawText("S22", 445+50*21, 97, paint);
		canvas.drawText("S23", 445+50*22, 97, paint);
		canvas.drawText("S24", 445+50*23, 97, paint);
		canvas.drawText("S25", 445+50*24, 97, paint);
		canvas.drawText("S26", 445+50*25, 97, paint);
		canvas.drawText("S27", 445+50*26, 97, paint);
		canvas.drawText("S28", 445+50*27, 97, paint);
		canvas.drawText("S29", 445+50*28, 97, paint);
		canvas.drawText("S30", 445+50*29, 97, paint);
		canvas.drawText("S31", 445+50*30, 97, paint);
		canvas.drawText("S32", 445+50*31, 97, paint);
		canvas.drawText("S33", 445+50*32, 97, paint);
		canvas.drawText("S34", 445+50*33, 97, paint);
		canvas.drawText("S35", 445+50*34, 97, paint);
		canvas.drawText("S36", 445+50*35, 97, paint);
		canvas.drawText("S37", 445+50*36, 97, paint);
		canvas.drawText("S38", 445+50*37, 97, paint);
		canvas.drawText("S39", 445+50*38, 97, paint);
		paint.setTextSize(30);
		canvas.drawText("e", 460+50*39, 97, paint);
		canvas.drawText("e1", 450+50*40, 97, paint);
		canvas.drawText("e2", 450+50*41, 97, paint);
		
		paint.setTextSize(40);	
		paint.setColor(Color.YELLOW);
		//电池电量，WIFI强度，日期，PLC状态
		canvas.drawText(GateValveActivity.dateString, 20,  50, paint);//时间
		canvas.drawText("电池电量：" +GateValveActivity.battery+ "%", 440,  50, paint);
		canvas.drawText("WIFI强度：" +((Integer) GateValveActivity.strength).toString()+ "%", 740,  50, paint);
		canvas.drawText("PLC连接状态:", 1060,  50, paint);
//		canvas.drawText("远程服务器连接状态:", 1440,  50, paint);
		if(NewMyService.plcconect1)
		{
			paint.setColor(Color.GREEN);
			canvas.drawText("连接", 1320,  50, paint);
		}
		else
		{
			paint.setColor(Color.RED);
	    	canvas.drawText("断开", 1320,  50, paint);
		}		

		paint.setColor(Color.YELLOW);
		canvas.drawText("SD卡剩余容量: "+GateValveActivity.SdVolume+" MB", 1440,  50, paint);

		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStrokeWidth(2); // 设置画笔的宽度
		paint.setStyle(Paint.Style.STROKE);
	    paint.setColor(Color.YELLOW);
		// 画矩形框
		RectF rectf1 = new RectF(10, 10, 2550, 1595);
		canvas.drawRect(rectf1, paint);
		
		
	}
}
