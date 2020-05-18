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
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.Layout.Alignment;

////////////// 主界面001
public class Page006 {

	public static void DrawPage(Canvas canvas) {
		////////////////////////////////////////////////////////////////////////////////////图元
		Group_BJD.bjd[0].cx = 230;
		Group_BJD.bjd[0].cy = 170+50*0;
		Group_BJD.bjd[0].rectWidth = 40;
		Group_BJD.bjd[0].rectHeight = 40;
		Group_BJD.bjd[0].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[0].bBlink = false;
		Group_BJD.bjd[0].bRectLight = false;
		Group_BJD.bjd[0].drawGraph(canvas);
		
		Group_BJD.bjd[1].cx = 230;
		Group_BJD.bjd[1].cy = 170+50*1;
		Group_BJD.bjd[1].rectWidth = 40;
		Group_BJD.bjd[1].rectHeight = 40;
		Group_BJD.bjd[1].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[1].bBlink = false;
		Group_BJD.bjd[1].bRectLight = false;
		Group_BJD.bjd[1].drawGraph(canvas);
		
		Group_BJD.bjd[2].cx = 230;
		Group_BJD.bjd[2].cy = 170+50*2;
		Group_BJD.bjd[2].rectWidth = 40;
		Group_BJD.bjd[2].rectHeight = 40;
		Group_BJD.bjd[2].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[2].bBlink = false;
		Group_BJD.bjd[2].bRectLight = false;
		Group_BJD.bjd[2].drawGraph(canvas);
		
		Group_BJD.bjd[3].cx = 230;
		Group_BJD.bjd[3].cy = 170+50*3;
		Group_BJD.bjd[3].rectWidth = 40;
		Group_BJD.bjd[3].rectHeight = 40;
		Group_BJD.bjd[3].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[3].bBlink = false;
		Group_BJD.bjd[3].bRectLight = false;
		Group_BJD.bjd[3].drawGraph(canvas);
		
		Group_BJD.bjd[5].cx = 230;
		Group_BJD.bjd[5].cy = 170+50*4;
		Group_BJD.bjd[5].rectWidth = 40;
		Group_BJD.bjd[5].rectHeight = 40;
		Group_BJD.bjd[5].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[5].bBlink = false;
		Group_BJD.bjd[5].bRectLight = false;
		Group_BJD.bjd[5].drawGraph(canvas);
	
		Group_BJD.bjd[6].cx = 230;
		Group_BJD.bjd[6].cy = 170+50*5;
		Group_BJD.bjd[6].rectWidth = 40;
		Group_BJD.bjd[6].rectHeight = 40;
		Group_BJD.bjd[6].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[6].bBlink = false;
		Group_BJD.bjd[6].bRectLight = false;
		Group_BJD.bjd[6].drawGraph(canvas);
		
		Group_BJD.bjd[7].cx = 230;
		Group_BJD.bjd[7].cy = 170+50*6;
		Group_BJD.bjd[7].rectWidth = 40;
		Group_BJD.bjd[7].rectHeight = 40;
		Group_BJD.bjd[7].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[7].bBlink = false;
		Group_BJD.bjd[7].bRectLight = false;
		Group_BJD.bjd[7].drawGraph(canvas);
		
		Group_BJD.bjd[8].cx = 230;
		Group_BJD.bjd[8].cy = 170+50*7;
		Group_BJD.bjd[8].rectWidth = 40;
		Group_BJD.bjd[8].rectHeight = 40;
		Group_BJD.bjd[8].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[8].bBlink = false;
		Group_BJD.bjd[8].bRectLight = false;
		Group_BJD.bjd[8].drawGraph(canvas);
		
		Group_BJD.bjd[9].cx = 230;
		Group_BJD.bjd[9].cy = 170+50*8;
		Group_BJD.bjd[9].rectWidth = 40;
		Group_BJD.bjd[9].rectHeight = 40;
		Group_BJD.bjd[9].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[9].bBlink = false;
		Group_BJD.bjd[9].bRectLight = false;
		Group_BJD.bjd[9].drawGraph(canvas);
	
		Group_BJD.bjd[10].cx = 230;
		Group_BJD.bjd[10].cy = 170+50*9;
		Group_BJD.bjd[10].rectWidth = 40;
		Group_BJD.bjd[10].rectHeight = 40;
		Group_BJD.bjd[10].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[10].bBlink = false;
		Group_BJD.bjd[10].bRectLight = false;
		Group_BJD.bjd[10].drawGraph(canvas);
		
		Group_BJD.bjd[11].cx = 230;
		Group_BJD.bjd[11].cy = 170+50*10;
		Group_BJD.bjd[11].rectWidth = 40;
		Group_BJD.bjd[11].rectHeight = 40;
		Group_BJD.bjd[11].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[11].bBlink = false;
		Group_BJD.bjd[11].bRectLight = false;
		Group_BJD.bjd[11].drawGraph(canvas);
		
		Group_BJD.bjd[12].cx = 230;
		Group_BJD.bjd[12].cy = 170+50*11;
		Group_BJD.bjd[12].rectWidth = 40;
		Group_BJD.bjd[12].rectHeight = 40;
		Group_BJD.bjd[12].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[12].bBlink = false;
		Group_BJD.bjd[12].bRectLight = false;
		Group_BJD.bjd[12].drawGraph(canvas);
		
		Group_BJD.bjd[13].cx = 230;
		Group_BJD.bjd[13].cy = 170+50*12;
		Group_BJD.bjd[13].rectWidth = 40;
		Group_BJD.bjd[13].rectHeight = 40;
		Group_BJD.bjd[13].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[13].bBlink = false;
		Group_BJD.bjd[13].bRectLight = false;
		Group_BJD.bjd[13].drawGraph(canvas);
		
		Group_BJD.bjd[14].cx = 230;
		Group_BJD.bjd[14].cy = 170+50*13;
		Group_BJD.bjd[14].rectWidth = 40;
		Group_BJD.bjd[14].rectHeight = 40;
		Group_BJD.bjd[14].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[14].bBlink = false;
		Group_BJD.bjd[14].bRectLight = false;
		Group_BJD.bjd[14].drawGraph(canvas);
		
		Group_BJD.bjd[15].cx = 230;
		Group_BJD.bjd[15].cy = 170+50*14;
		Group_BJD.bjd[15].rectWidth = 40;
		Group_BJD.bjd[15].rectHeight = 40;
		Group_BJD.bjd[15].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[15].bBlink = false;
		Group_BJD.bjd[15].bRectLight = false;
		Group_BJD.bjd[15].drawGraph(canvas);
		
		Group_BJD.bjd[16].cx = 230;
		Group_BJD.bjd[16].cy = 170+50*15;
		Group_BJD.bjd[16].rectWidth = 40;
		Group_BJD.bjd[16].rectHeight = 40;
		Group_BJD.bjd[16].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[16].bBlink = false;
		Group_BJD.bjd[16].bRectLight = false;
		Group_BJD.bjd[16].drawGraph(canvas);
		
		Group_BJD.bjd[17].cx = 230;
		Group_BJD.bjd[17].cy = 170+50*16;
		Group_BJD.bjd[17].rectWidth = 40;
		Group_BJD.bjd[17].rectHeight = 40;
		Group_BJD.bjd[17].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[17].bBlink = false;
		Group_BJD.bjd[17].bRectLight = false;
		Group_BJD.bjd[17].drawGraph(canvas);
		
		Group_BJD.bjd[18].cx = 230;
		Group_BJD.bjd[18].cy = 170+50*17;
		Group_BJD.bjd[18].rectWidth = 40;
		Group_BJD.bjd[18].rectHeight = 40;
		Group_BJD.bjd[18].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[18].bBlink = false;
		Group_BJD.bjd[18].bRectLight = false;
		Group_BJD.bjd[18].drawGraph(canvas);
		
		Group_BJD.bjd[19].cx = 230;
		Group_BJD.bjd[19].cy = 170+50*18;
		Group_BJD.bjd[19].rectWidth = 40;
		Group_BJD.bjd[19].rectHeight = 40;
		Group_BJD.bjd[19].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[19].bBlink = false;
		Group_BJD.bjd[19].bRectLight = false;
		Group_BJD.bjd[19].drawGraph(canvas);
		
		Group_BJD.bjd[20].cx = 230;
		Group_BJD.bjd[20].cy = 170+50*19;
		Group_BJD.bjd[20].rectWidth = 40;
		Group_BJD.bjd[20].rectHeight = 40;
		Group_BJD.bjd[20].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[20].bBlink = false;
		Group_BJD.bjd[20].bRectLight = false;
		Group_BJD.bjd[20].drawGraph(canvas);
		
		Group_BJD.bjd[21].cx = 230;
		Group_BJD.bjd[21].cy = 170+50*20;
		Group_BJD.bjd[21].rectWidth = 40;
		Group_BJD.bjd[21].rectHeight = 40;
		Group_BJD.bjd[21].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[21].bBlink = false;
		Group_BJD.bjd[21].bRectLight = false;
		Group_BJD.bjd[21].drawGraph(canvas);
		
		Group_BJD.bjd[22].cx = 230;
		Group_BJD.bjd[22].cy = 170+50*21;
		Group_BJD.bjd[22].rectWidth = 40;
		Group_BJD.bjd[22].rectHeight = 40;
		Group_BJD.bjd[22].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[22].bBlink = false;
		Group_BJD.bjd[22].bRectLight = false;
		Group_BJD.bjd[22].drawGraph(canvas);
		
		Group_BJD.bjd[23].cx = 230;
		Group_BJD.bjd[23].cy = 170+50*22;
		Group_BJD.bjd[23].rectWidth = 40;
		Group_BJD.bjd[23].rectHeight = 40;
		Group_BJD.bjd[23].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[23].bBlink = false;
		Group_BJD.bjd[23].bRectLight = false;
		Group_BJD.bjd[23].drawGraph(canvas);
		
		Group_BJD.bjd[24].cx = 230;
		Group_BJD.bjd[24].cy = 170+50*23;
		Group_BJD.bjd[24].rectWidth = 40;
		Group_BJD.bjd[24].rectHeight = 40;
		Group_BJD.bjd[24].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[24].bBlink = false;
		Group_BJD.bjd[24].bRectLight = false;
		Group_BJD.bjd[24].drawGraph(canvas);
		
		Group_BJD.bjd[25].cx = 230;
		Group_BJD.bjd[25].cy = 170+50*24;
		Group_BJD.bjd[25].rectWidth = 40;
		Group_BJD.bjd[25].rectHeight = 40;
		Group_BJD.bjd[25].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[25].bBlink = false;
		Group_BJD.bjd[25].bRectLight = false;
		Group_BJD.bjd[25].drawGraph(canvas);
		
		Group_BJD.bjd[26].cx = 230;
		Group_BJD.bjd[26].cy = 170+50*25;
		Group_BJD.bjd[26].rectWidth = 40;
		Group_BJD.bjd[26].rectHeight = 40;
		Group_BJD.bjd[26].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[26].bBlink = false;
		Group_BJD.bjd[26].bRectLight = false;
		Group_BJD.bjd[26].drawGraph(canvas);
		
		Group_BJD.bjd[27].cx = 230;
		Group_BJD.bjd[27].cy = 170+50*26;
		Group_BJD.bjd[27].rectWidth = 40;
		Group_BJD.bjd[27].rectHeight = 40;
		Group_BJD.bjd[27].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[27].bBlink = false;
		Group_BJD.bjd[27].bRectLight = false;
		Group_BJD.bjd[27].drawGraph(canvas);
		
		Group_BJD.bjd[28].cx = 230;
		Group_BJD.bjd[28].cy = 170+50*27;
		Group_BJD.bjd[28].rectWidth = 40;
		Group_BJD.bjd[28].rectHeight = 40;
		Group_BJD.bjd[28].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[28].bBlink = false;
		Group_BJD.bjd[28].bRectLight = false;
		Group_BJD.bjd[28].drawGraph(canvas);
///////////////////////////////////////////////////////////////////////////////////
		Group_BJD.bjd[29].cx = 1480;
		Group_BJD.bjd[29].cy = 170+45*0;
		Group_BJD.bjd[29].rectWidth = 40;
		Group_BJD.bjd[29].rectHeight = 40;
		Group_BJD.bjd[29].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[29].bBlink = false;
		Group_BJD.bjd[29].bRectLight = false;
//		Group_BJD.bjd[29].drawGraph(canvas);

//////////////////////////////////////////////////////////////////////////////////
		
		Group_BJD.bjd[43].cx = 1480;
		Group_BJD.bjd[43].cy = 950+45*0;
		Group_BJD.bjd[43].rectWidth = 40;
		Group_BJD.bjd[43].rectHeight = 40;
		Group_BJD.bjd[43].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[43].bBlink = false;
		Group_BJD.bjd[43].bRectLight = false;
//		Group_BJD.bjd[43].drawGraph(canvas);
		
		//////////////////////////////////////////////////////////////////////////////////分割线
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(1);
		paint.setColor(Color.rgb(113, 150, 159));
		
		Rect rl = new Rect(30,80,1265,1570);
		Rect rru = new Rect(1295,80,2530,830);
		Rect rrd = new Rect(1295,860,2530,1570);
		canvas.drawRect(rl, paint);
//		canvas.drawRect(rru, paint);
//		canvas.drawRect(rrd, paint);
		//////////////////////////////////////////////////////////////////////////////////文本
		paint.setStyle(Style.FILL);
		paint.setTextAlign(Align.CENTER);
		paint.setTextSize(30);

		paint.setColor(Color.GREEN);//标题
		canvas.drawText("PLC Collection Box Alarm", 648, 120, paint);
//		canvas.drawText("Hydraulic Pump Alarm", 1913, 120, paint);
//		canvas.drawText("Dredge Pump Alarm", 1913, 900, paint);
		
		paint.setTextAlign(Align.LEFT);
		paint.setColor(Color.rgb(222, 156, 83));
		canvas.drawText("#1 generator overload", 330, 10+170+50*0, paint);
		canvas.drawText("#2 generator overload", 330, 10+170+50*1, paint);
		canvas.drawText("AC415V insulation is low", 330, 10+170+50*2, paint);
		canvas.drawText("AC240V insulation is low", 330, 10+170+50*3, paint);
		canvas.drawText("DC24V insulation is low", 330, 10+170+50*4, paint);
		canvas.drawText("Hydraulic gear shifting box lubricating oil high", 330, 10+170+50*5, paint);
		canvas.drawText("Hydraulic gear shifting box lubricating oil low", 330, 10+170+50*6, paint);
		canvas.drawText("Dredge shifting box over torque/over slip", 330, 10+170+50*7, paint);
		canvas.drawText("Dredge shifting box lubricating oil high tempera", 330, 10+170+50*8, paint);
		canvas.drawText("Dredge shifting box low atmospheric pressure", 330, 10+170+50*9, paint);
		canvas.drawText("Dredge shifting box lubricating oil low atmosphere", 330, 10+170+50*10, paint);
		canvas.drawText("Front fuel tank (left) high level", 330, 10+170+50*11, paint);
		canvas.drawText("Front fuel tank (right) high level", 330, 10+170+50*12, paint);
		canvas.drawText("Rear fuel tank (left) high level", 330, 10+170+50*13, paint);
		canvas.drawText("Rear fuel tank (right) high level", 330, 10+170+50*14, paint);
		canvas.drawText("Dirty fuel tank high level", 330, 10+170+50*15, paint);
		canvas.drawText("Dirty water tank high level", 330, 10+170+50*16, paint);
		canvas.drawText("Bilge tank high leve", 330, 10+170+50*17, paint);
		canvas.drawText("Engine room bilge tank high level", 330, 10+170+50*18, paint);
		canvas.drawText("Engine room bilge tank high high level", 330, 10+170+50*19, paint);
		canvas.drawText("Left storage tank bilge tank high level", 330, 10+170+50*20, paint);
		canvas.drawText("Right storage tank bilge tank high level", 330, 10+170+50*21, paint);
		canvas.drawText("Empty tank bilge tank high level", 330, 10+170+50*22, paint);
		canvas.drawText("Freshwater tank low level", 330, 10+170+50*23, paint);
		canvas.drawText("Daily use fuel tank low level", 330, 10+170+50*24, paint);
		canvas.drawText("Hydraulic oil tank low level", 330, 10+170+50*25, paint);
		canvas.drawText("Hydraulic oil tank high temperature", 330, 10+170+50*26, paint);
		canvas.drawText("Hydraulic oil Filter blocking", 330, 10+170+50*27, paint);
		
		
/*
		canvas.drawText("Overspeed stop", 1580, 10+170+45*0, paint);
		canvas.drawText("Overspeed sensor", 1580, 10+170+45*1, paint);
		canvas.drawText("Lubricating oil low pressure", 1580, 10+170+45*2, paint);
		canvas.drawText("Engine oil low pressure", 1580, 10+170+45*3, paint);
		canvas.drawText("Water high temperature break off", 1580, 10+170+45*4, paint);
		canvas.drawText("Cooling water high temperature break off", 1580, 10+170+45*5, paint);
		canvas.drawText("Cooling water low level", 1580, 10+170+45*6, paint);
		canvas.drawText("Emergency stop", 1580, 10+170+45*7, paint);
		canvas.drawText("Common alarm", 1580, 10+170+45*8, paint);
		canvas.drawText("Common break off", 1580, 10+170+45*9, paint);
		canvas.drawText("Start failure alarm", 1580, 10+170+45*10, paint);
		canvas.drawText("Main 24V power lose", 1580, 10+170+45*11, paint);
		canvas.drawText("Spare 24V power lose", 1580, 10+170+45*12, paint);
		canvas.drawText("Engine running", 1580, 10+170+45*13, paint);
		canvas.drawText("Engine stop failure", 1580, 10+170+45*14, paint);


		canvas.drawText("Overspeed sto", 1580, 10+950+45*0, paint);
		canvas.drawText("Lubricating oil low pressure", 1580, 10+950+45*1, paint);
		canvas.drawText("Engine oil low pressure", 1580, 10+950+45*2, paint);
		canvas.drawText("Water high temperature break off", 1580, 10+950+45*3, paint);
		canvas.drawText("Cooling water high temperature break off", 1580, 10+950+45*4, paint);
		canvas.drawText("Cooling water low level", 1580, 10+950+45*5, paint);
		canvas.drawText("Emergency stop", 1580, 10+950+45*6, paint);
		canvas.drawText("Common alarm", 1580, 10+950+45*7, paint);
		canvas.drawText("Common break off", 1580, 10+950+45*8, paint);
		canvas.drawText("Engine running", 1580, 10+950+45*9, paint);
		canvas.drawText("Main 24V power lose", 1580, 10+950+45*10, paint);
		canvas.drawText("Spare 24V power lose", 1580, 10+950+45*11, paint);
		canvas.drawText("Remote regulator speed mode", 1580, 10+950+45*12, paint);
		canvas.drawText("Clutch engage feedback", 1580, 10+950+45*13, paint);*/
		//////////////////////////////////////////////////////////////////////////////////
		paint.setTextAlign(Align.LEFT);
		paint.setColor(Color.YELLOW);	
		paint.setTextSize(30);
		canvas.drawText("Page 6:", 10, 30, paint);
		paint.setColor(Color.GREEN);
		canvas.drawText("Alarm", 120, 30, paint);
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