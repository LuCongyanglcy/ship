package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.text.TextPaint;

////////////// 主界面001
public class Page003 {

	public static void DrawPage(Canvas canvas) {

//		if (GateValveActivity.control_limite) {
//			canvas.drawBitmap(GateValveActivity.bmp11, 2150, 70, null);
//		} else {
//			canvas.drawBitmap(GateValveActivity.bmp10, 2150, 70, null);
//		}
		////////////////////////////////////////////////////////////////////////////////////// 线条
		GroupLine.line[9].startX = 1280-53;    //左
		GroupLine.line[9].startY = 1050;
		GroupLine.line[9].endX = 300;
		GroupLine.line[9].endY = 1050;
		GroupLine.line[9].lineWidth = 6;
		GroupLine.line[9].bArc = true;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[9].drawGraph(canvas);

		GroupLine.line[9].startX = 1280+40;    //右
		GroupLine.line[9].startY = 1050;
		GroupLine.line[9].endX = 2360;
		GroupLine.line[9].endY = 1050;
		GroupLine.line[9].lineWidth = 6;
		GroupLine.line[9].bArc = true;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[9].drawGraph(canvas);

		GroupLine.line[9].startX = 1280;    //下 
		GroupLine.line[9].startY = 1180;
		GroupLine.line[9].endX = 1280;
		GroupLine.line[9].endY = 1300;
		GroupLine.line[9].lineWidth = 6;
		GroupLine.line[9].bArc = true;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[9].drawGraph(canvas);

		GroupLine.line[9].startX = 1280;    //右 连离合器
		GroupLine.line[9].startY = 1300;
		GroupLine.line[9].endX = 1475;
		GroupLine.line[9].endY = 1300;
		GroupLine.line[9].lineWidth = 6;
		GroupLine.line[9].bArc = true;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[9].drawGraph(canvas);

		GroupLine.line[9].startX = 1525;    //右 连柴油机
		GroupLine.line[9].startY = 1300;
		GroupLine.line[9].endX = 1580;
		GroupLine.line[9].endY = 1300;
		GroupLine.line[9].lineWidth = 6;
		GroupLine.line[9].bArc = true;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[9].drawGraph(canvas);
		////////////////////////////////////////////////////////////////////////////////////////////// 元件
		GroupRuler.ruler[4].cx = 1280;
		GroupRuler.ruler[4].cy = 450+40;
		GroupRuler.ruler[4].rectWidth = 150;
		GroupRuler.ruler[4].rectHeight = 250;
		GroupRuler.ruler[4].higherDepth = 10000;
		GroupRuler.ruler[4].underDepth = -100;
		GroupRuler.ruler[4].rulerhigher = 8;
		GroupRuler.ruler[4].rulerunder = 0;
		GroupRuler.ruler[4].rulermain = 4;
		GroupRuler.ruler[4].rulersecond = 4;
		GroupRuler.ruler[4].rotateAngle = 0;
		GroupRuler.ruler[4].switchdirection = false;
		GroupRuler.ruler[4].ifint = true;
		GroupRuler.ruler[4].drawGraph(canvas);// 耳轴吃水

		GroupRunOut.runout[0].cx = 480;
		GroupRunOut.runout[0].cy = 130;
		GroupRunOut.runout[0].rectWidth = 1600;
		GroupRunOut.runout[0].rectHeight = 65;
		GroupRunOut.runout[0].rulerhigher = 50;
		GroupRunOut.runout[0].rulerunder = -50;
		GroupRunOut.runout[0].higherDepth = 45;
		GroupRunOut.runout[0].underDepth = -45;
		GroupRunOut.runout[0].rulermain = 5;
		GroupRunOut.runout[0].rulersecond = 5;
		GroupRunOut.runout[0].switchdirection = false;
		GroupRunOut.runout[0].ifint = true;
//		GroupRunOut.runout[0].drawGraph(canvas);// 摆度

		GroupFlowmeter.flowmeter[0].cx = 1280;
		GroupFlowmeter.flowmeter[0].cy = 1265+40;
		GroupFlowmeter.flowmeter[0].Circle = 960;
//		GroupFlowmeter.flowmeter[0].densityhigher = 45;
//		GroupFlowmeter.flowmeter[0].densityunder = -45;
		GroupFlowmeter.flowmeter[0].higherDepth = 40;
		GroupFlowmeter.flowmeter[0].underDepth = -40;
//		GroupFlowmeter.flowmeter[0].densitymain = 2;
//		GroupFlowmeter.flowmeter[0].densitysecond = 8;
//		GroupFlowmeter.flowmeter[0].densityifint = false;
		GroupFlowmeter.flowmeter[0].drawGraph(canvas);// 船体角度

		GroupDredgePump.dredgepump[0].cx = 1280;
		GroupDredgePump.dredgepump[0].cy = 1050;
		GroupDredgePump.dredgepump[0].rectWidth = 80;
		GroupDredgePump.dredgepump[0].rectHeight = 180;
		GroupDredgePump.dredgepump[0].rotateAngle = 0;
		GroupDredgePump.dredgepump[0].bShowLeft = true;
		GroupDredgePump.dredgepump[0].sText = "水下泵";
		GroupDredgePump.dredgepump[0].drawGraph(canvas);
		
		GroupCutterWheel.cutterwheel.cx = 200;
		GroupCutterWheel.cutterwheel.cy = 1050;
		GroupCutterWheel.cutterwheel.rectHeight = 200;
		GroupCutterWheel.cutterwheel.rectWidth = 200;	
		GroupCutterWheel.cutterwheel.drawGraph(canvas);//斗轮
		

		GroupClutch.clutch[0].cx = 1500;
		GroupClutch.clutch[0].cy = 1300;
		GroupClutch.clutch[0].rectWidth = 45;
		GroupClutch.clutch[0].rectHeight = 60;
		GroupClutch.clutch[0].drawGraph(canvas);// 离合器
		
		GroupDiesel.diesel[0].cx = 1560;
		GroupDiesel.diesel[0].cy = 1100;
		GroupDiesel.diesel[0].rectHeight = 280;
		GroupDiesel.diesel[0].rectWidth = 300;			
		GroupDiesel.diesel[0].num = 5;
		GroupDiesel.diesel[0].drawGraph(canvas);//柴油机
		//////////////////////////////////////////////////////////////////////////////////数据
		GroupText.text[194].cx = 680-40; 
		GroupText.text[194].cy = 750;
		GroupText.text[194].textSize = 30;
		GroupText.text[194].format = 0;
		GroupText.text[194].isFont_center2=true;
//		GroupText.text[194].drawGraph(canvas);//左抛锚
		
		GroupText.text[199].cx = 1880-40; 
		GroupText.text[199].cy = 750;
		GroupText.text[199].textSize = 30;
		GroupText.text[199].format = 0;
		GroupText.text[199].isFont_center2=true;
//		GroupText.text[199].drawGraph(canvas);//右抛锚
		
		GroupText.text[42].cx = 1280-40; 
		GroupText.text[42].cy = 825+40;
		GroupText.text[42].textSize = 30;
		GroupText.text[42].format = 2;
		GroupText.text[42].isFont_center2=true;
		GroupText.text[42].drawGraph(canvas);//耳轴吃水
		
		GroupText.text[27].cx = 700-40; 
		GroupText.text[27].cy = 950+50;
		GroupText.text[27].textSize = 30;
		GroupText.text[27].format = 2	;
		GroupText.text[27].isFont_center2=true;
		GroupText.text[27].drawGraph(canvas);//真空压力
		
		GroupText.text[28].cx = 1500-40; 
		GroupText.text[28].cy = 950+50;
		GroupText.text[28].textSize = 30;
		GroupText.text[28].format = 2;
		GroupText.text[28].isFont_center2=true;
		GroupText.text[28].drawGraph(canvas);//排气压力
		
		GroupText.text[43].cx = 1280-40; 
		GroupText.text[43].cy = 400+40;
		GroupText.text[43].textSize = 30;
		GroupText.text[43].format = 0;
		GroupText.text[43].isFont_center2=true;
		GroupText.text[43].drawGraph(canvas);//桥架角度
		
		GroupText.text[17].cx = 1500+160; 
		GroupText.text[17].cy = 1400;
		GroupText.text[17].textSize = 30;
		GroupText.text[17].format = 0;
		GroupText.text[17].isFont_center2=true;
		GroupText.text[17].drawGraph(canvas);//柴油机转速
		
		GroupText.text[31].cx = 2000+160; 
		GroupText.text[31].cy = 875+50;
		GroupText.text[31].textSize = 30;
		GroupText.text[31].format = 2;
		GroupText.text[31].isFont_center2=true;
		GroupText.text[31].drawGraph(canvas);//产量
		
		GroupText.text[32].cx = 2000+160; 
		GroupText.text[32].cy = 925+50;
		GroupText.text[32].textSize = 30;
		GroupText.text[32].format = 2;
		GroupText.text[32].isFont_center2=true;
		GroupText.text[32].drawGraph(canvas);//流速
		
		GroupText.text[62].cx = 300; 
		GroupText.text[62].cy = 435;
		GroupText.text[62].textSize = 30;
		GroupText.text[62].format = 1;
		GroupText.text[62].isFont_center2=true;
		GroupText.text[62].drawGraph(canvas);//L1
		
		GroupText.text[63].cx = 300; 
		GroupText.text[63].cy = 470;
		GroupText.text[63].textSize = 30;
		GroupText.text[63].format = 1;
		GroupText.text[63].isFont_center2=true;
		GroupText.text[63].drawGraph(canvas);//L2
		
		GroupText.text[64].cx = 300; 
		GroupText.text[64].cy = 505;
		GroupText.text[64].textSize = 30;
		GroupText.text[64].format = 1;
		GroupText.text[64].isFont_center2=true;
		GroupText.text[64].drawGraph(canvas);//L3
		
		GroupText.text[52].cx = 300; 
		GroupText.text[52].cy = 635;
		GroupText.text[52].textSize = 30;
		GroupText.text[52].format = 1;
		GroupText.text[52].isFont_center2=true;
		GroupText.text[52].drawGraph(canvas);//L4
		
		GroupText.text[53].cx = 300; 
		GroupText.text[53].cy = 670;
		GroupText.text[53].textSize = 30;
		GroupText.text[53].format = 1;
		GroupText.text[53].isFont_center2=true;
		GroupText.text[53].drawGraph(canvas);//L5
		
		GroupText.text[54].cx = 300; 
		GroupText.text[54].cy = 705;
		GroupText.text[54].textSize = 30;
		GroupText.text[54].format = 1;
		GroupText.text[54].isFont_center2=true;
		GroupText.text[54].drawGraph(canvas);//L6
		
		GroupText.text[67].cx = 2260; 
		GroupText.text[67].cy = 435;
		GroupText.text[67].textSize = 30;
		GroupText.text[67].format = 1;
		GroupText.text[67].isFont_center2=true;
		GroupText.text[67].drawGraph(canvas);//R1
		
		GroupText.text[68].cx = 2260; 
		GroupText.text[68].cy = 470;
		GroupText.text[68].textSize = 30;
		GroupText.text[68].format = 1;
		GroupText.text[68].isFont_center2=true;
		GroupText.text[68].drawGraph(canvas);//R2
		
		GroupText.text[69].cx = 2260; 
		GroupText.text[69].cy = 505;
		GroupText.text[69].textSize = 30;
		GroupText.text[69].format = 1;
		GroupText.text[69].isFont_center2=true;
		GroupText.text[69].drawGraph(canvas);//R3
		
		GroupText.text[57].cx = 2260; 
		GroupText.text[57].cy = 635;
		GroupText.text[57].textSize = 30;
		GroupText.text[57].format = 1;
		GroupText.text[57].isFont_center2=true;
		GroupText.text[57].drawGraph(canvas);//R4
		
		GroupText.text[58].cx = 2260; 
		GroupText.text[58].cy = 670;
		GroupText.text[58].textSize = 30;
		GroupText.text[58].format = 1;
		GroupText.text[58].isFont_center2=true;
		GroupText.text[58].drawGraph(canvas);//R5
		
		GroupText.text[59].cx = 2260; 
		GroupText.text[59].cy = 705;
		GroupText.text[59].textSize = 30;
		GroupText.text[59].format = 1;
		GroupText.text[59].isFont_center2=true;
		GroupText.text[59].drawGraph(canvas);//R6
		
		GroupText.text[47].cx = 880; 
		GroupText.text[47].cy = 1235;
		GroupText.text[47].textSize = 30;
		GroupText.text[47].format = 1;
		GroupText.text[47].isFont_center2=true;
		GroupText.text[47].drawGraph(canvas);//M1
		
		GroupText.text[48].cx = 880; 
		GroupText.text[48].cy = 1270;
		GroupText.text[48].textSize = 30;
		GroupText.text[48].format = 1;
		GroupText.text[48].isFont_center2=true;
		GroupText.text[48].drawGraph(canvas);//M2
		
		GroupText.text[49].cx = 880; 
		GroupText.text[49].cy = 1305;
		GroupText.text[49].textSize = 30;
		GroupText.text[49].format = 1;
		GroupText.text[49].isFont_center2=true;
		GroupText.text[49].drawGraph(canvas);//M3
		////////////////////////////////////////////////////////////////////////////////// 文本
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setStrokeWidth(1);
		paint.setTextSize(30);

		paint.setColor(Color.rgb(131, 175, 155));

		paint.setTextAlign(Align.CENTER);
//		canvas.drawText("Swing Width", 250, 185, paint);//摆度
		canvas.drawText("Bridge Angle", 1280, 350+40, paint);//桥架角度
		canvas.drawText("Trunnion Draft", 1280, 775+40, paint);//耳轴吃水
//		canvas.drawText("Left Throw Anchor", 680, 700, paint);//左耳轴
//		canvas.drawText("Right Throw Anchor", 1880, 700, paint);//右耳轴
		canvas.drawText("Vacuum Pressure", 680, 900+50, paint);//真空压力
		canvas.drawText("Exhaust Pressure", 1500, 900+50, paint);//排气压力
		
		canvas.drawText("Harvest", 2000, 875+50, paint);//密度
		canvas.drawText("Flow speed", 2000, 925+50, paint);//流速
		canvas.drawText("Diesel Engine", 1500, 1400, paint);//柴油机转速

		canvas.drawText("Left Weigh Anchor", 300, 400, paint);//左锚绞车
		canvas.drawText("Right Weigh Anchor", 2260, 400, paint);//右锚绞车
		canvas.drawText("Left Sidesway", 300, 600, paint);//左横移
		canvas.drawText("Right Sidesway", 2260, 600, paint);//右横移
		canvas.drawText("Bridge Winch", 880, 1200, paint);//桥架
		
		paint.setTextAlign(Align.RIGHT);
		paint.setColor(Color.rgb(182, 194, 154));
		canvas.drawText("Remain Length", 300-45, 435, paint);
		canvas.drawText("In/Out Length", 300-45, 470, paint);
		canvas.drawText("Speed", 300-45, 505, paint);
		
		canvas.drawText("Remain Length", 2260-45, 435, paint);
		canvas.drawText("In/Out Length", 2260-45, 470, paint);
		canvas.drawText("Speed", 2260-45, 505, paint);
		
		canvas.drawText("Remain Length", 300-45, 635, paint);
		canvas.drawText("In/Out Length", 300-45, 670, paint);
		canvas.drawText("Speed", 300-45, 705, paint);
		
		canvas.drawText("Remain Length", 2260-45, 635, paint);
		canvas.drawText("In/Out Length", 2260-45, 670, paint);
		canvas.drawText("Speed", 2260-45, 705, paint);
		
		canvas.drawText("Remain Length", 880-45, 1235, paint);
		canvas.drawText("In/Out Length", 880-45, 1270, paint);
		canvas.drawText("Speed", 880-45, 1305, paint);
		
		paint.setTextAlign(Align.LEFT);
		paint.setColor(Color.rgb(138, 151, 123));
//		canvas.drawText("m/min", 680, 750, paint);//左耳轴
//		canvas.drawText("m/min", 1880, 750, paint);//右耳轴
		canvas.drawText("m", 1280, 825+40, paint);//耳轴吃水
		canvas.drawText("bar", 700, 950+50, paint);//真空压力
		canvas.drawText("bar", 1500, 950+50, paint);//排气压力
		canvas.drawText("°", 1280, 400+40, paint);//桥架角度
		canvas.drawText("t/m3", 2000+250, 875+50, paint);//产量
		canvas.drawText("m/s", 2000+250, 925+50, paint);//流速
		canvas.drawText("r/min", 1500+200, 1400, paint);//柴油机转速

		canvas.drawText("m", 300+45, 435, paint);//
		canvas.drawText("m", 300+45, 470, paint);//
		canvas.drawText("m/min", 300+45, 505, paint);//

		canvas.drawText("m", 2260+45, 435, paint);//
		canvas.drawText("m", 2260+45, 470, paint);//
		canvas.drawText("m/min", 2260+45, 505, paint);//

		canvas.drawText("m", 300+45, 635, paint);//
		canvas.drawText("m", 300+45, 670, paint);//
		canvas.drawText("m/min", 300+45, 705, paint);//

		canvas.drawText("m", 2260+45, 635, paint);//
		canvas.drawText("m", 2260+45, 670, paint);//
		canvas.drawText("m/min", 2260+45, 705, paint);//

		canvas.drawText("m", 880+45, 1235, paint);//
		canvas.drawText("m", 880+45, 1270, paint);//
		canvas.drawText("m/min", 880+45, 1305, paint);//
		//////////////////////////////////////////////////////////////////////////////////
		paint.setTextAlign(Align.LEFT);
		paint.setColor(Color.YELLOW);	
		paint.setTextSize(30);
		canvas.drawText("Page 3:", 10, 30, paint);
		paint.setColor(Color.GREEN);
		canvas.drawText("Bridge angle", 120, 30, paint);
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