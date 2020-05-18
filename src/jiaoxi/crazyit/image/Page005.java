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
public class Page005 {

	public static void DrawPage(Canvas canvas) {

//		if (GateValveActivity.control_limite) {
//			canvas.drawBitmap(GateValveActivity.bmp11, 2150, 70, null);
//		} else {
//			canvas.drawBitmap(GateValveActivity.bmp10, 2150, 70, null);
//		}
		//////////////////////////////////////////////////////////////////////////////////图元
		GroupRuler.ruler[18].cx = 333 ; 
		GroupRuler.ruler[18].cy = 150 ;
		GroupRuler.ruler[18].rectHeight = 240;
		GroupRuler.ruler[18].rectWidth = 150;
		GroupRuler.ruler[18].higherDepth = 10000;
		GroupRuler.ruler[18].underDepth = 0;
		GroupRuler.ruler[18].rulerhigher = 3000;
		GroupRuler.ruler[18].rulerunder = 0;
		GroupRuler.ruler[18].rulermain = 5;
		GroupRuler.ruler[18].rulersecond = 4;
		GroupRuler.ruler[18].ifint = true;
		GroupRuler.ruler[18].switchdirection = false;
		GroupRuler.ruler[18].drawGraph(canvas);//电机转速
		
		GroupRuler.ruler[19].cx = 666 ; 
		GroupRuler.ruler[19].cy = 150 ;
		GroupRuler.ruler[19].rectHeight = 240;
		GroupRuler.ruler[19].rectWidth = 150;
		GroupRuler.ruler[19].higherDepth = 10000;
		GroupRuler.ruler[19].underDepth = 0;
		GroupRuler.ruler[19].rulerhigher = 40;
		GroupRuler.ruler[19].rulerunder = 0;
		GroupRuler.ruler[19].rulermain = 5;
		GroupRuler.ruler[19].rulersecond = 4;
		GroupRuler.ruler[19].ifint = true;
		GroupRuler.ruler[19].switchdirection = false;
		GroupRuler.ruler[19].drawGraph(canvas);//电池电压
		
		GroupRuler.ruler[20].cx = 250 ; 
		GroupRuler.ruler[20].cy = 650 ;
		GroupRuler.ruler[20].rectHeight = 240;
		GroupRuler.ruler[20].rectWidth = 150;
		GroupRuler.ruler[20].higherDepth = 10000;
		GroupRuler.ruler[20].underDepth = 0;
		GroupRuler.ruler[20].rulerhigher = 150;
		GroupRuler.ruler[20].rulerunder = 0;
		GroupRuler.ruler[20].rulermain = 5;
		GroupRuler.ruler[20].rulersecond = 4;
		GroupRuler.ruler[20].ifint = true;
		GroupRuler.ruler[20].switchdirection = false;
		GroupRuler.ruler[20].drawGraph(canvas);//温度1
		
		GroupRuler.ruler[21].cx = 500 ; 
		GroupRuler.ruler[21].cy = 650 ;
		GroupRuler.ruler[21].rectHeight = 240;
		GroupRuler.ruler[21].rectWidth = 150;
		GroupRuler.ruler[21].higherDepth = 10000;
		GroupRuler.ruler[21].underDepth = 0;
		GroupRuler.ruler[21].rulerhigher = 150;
		GroupRuler.ruler[21].rulerunder = 0;
		GroupRuler.ruler[21].rulermain = 5;
		GroupRuler.ruler[21].rulersecond = 4;
		GroupRuler.ruler[21].ifint = true;
		GroupRuler.ruler[21].switchdirection = false;
		GroupRuler.ruler[21].drawGraph(canvas);//温度2
		
		GroupRuler.ruler[22].cx = 750 ; 
		GroupRuler.ruler[22].cy = 650 ;
		GroupRuler.ruler[22].rectHeight = 240;
		GroupRuler.ruler[22].rectWidth = 150;
		GroupRuler.ruler[22].higherDepth = 10000;
		GroupRuler.ruler[22].underDepth = 0;
		GroupRuler.ruler[22].rulerhigher = 850;
		GroupRuler.ruler[22].rulerunder = 0;
		GroupRuler.ruler[22].rulermain = 5;
		GroupRuler.ruler[22].rulersecond = 4;
		GroupRuler.ruler[22].ifint = true;
		GroupRuler.ruler[22].switchdirection = false;
		GroupRuler.ruler[22].drawGraph(canvas);//温度3
		
		GroupRuler.ruler[23].cx = 250; 
		GroupRuler.ruler[23].cy = 1150;
		GroupRuler.ruler[23].rectHeight = 240;
		GroupRuler.ruler[23].rectWidth = 150;
		GroupRuler.ruler[23].higherDepth = 10000;
		GroupRuler.ruler[23].underDepth = 0;
		GroupRuler.ruler[23].rulerhigher = 10;
		GroupRuler.ruler[23].rulerunder = 0;
		GroupRuler.ruler[23].rulermain = 5;
		GroupRuler.ruler[23].rulersecond = 4;
		GroupRuler.ruler[23].ifint = true;
		GroupRuler.ruler[23].switchdirection = false;
		GroupRuler.ruler[23].drawGraph(canvas);//压力1
		
		GroupRuler.ruler[24].cx = 500; 
		GroupRuler.ruler[24].cy = 1150;
		GroupRuler.ruler[24].rectHeight = 240;
		GroupRuler.ruler[24].rectWidth = 150;
		GroupRuler.ruler[24].higherDepth = 10000;
		GroupRuler.ruler[24].underDepth = 0;
		GroupRuler.ruler[24].rulerhigher = 10;
		GroupRuler.ruler[24].rulerunder = 0;
		GroupRuler.ruler[24].rulermain = 5;
		GroupRuler.ruler[24].rulersecond = 4;
		GroupRuler.ruler[24].ifint = true;
		GroupRuler.ruler[24].switchdirection = false;
		GroupRuler.ruler[24].drawGraph(canvas);//压力2
		
		GroupRuler.ruler[25].cx = 750; 
		GroupRuler.ruler[25].cy = 1150;
		GroupRuler.ruler[25].rectHeight = 240;
		GroupRuler.ruler[25].rectWidth = 150;
		GroupRuler.ruler[25].higherDepth = 10000;
		GroupRuler.ruler[25].underDepth = 0;
		GroupRuler.ruler[25].rulerhigher = 4;
		GroupRuler.ruler[25].rulerunder = 0;
		GroupRuler.ruler[25].rulermain = 5;
		GroupRuler.ruler[25].rulersecond = 4;
		GroupRuler.ruler[25].format=1;
		GroupRuler.ruler[25].switchdirection = false;
		GroupRuler.ruler[25].drawGraph(canvas);//压力3
		
		GroupDiesel.diesel[1].cx = 1150;
		GroupDiesel.diesel[1].cy = 200;
		GroupDiesel.diesel[1].rectHeight = 280;
		GroupDiesel.diesel[1].rectWidth = 300;			
		GroupDiesel.diesel[1].num = 5;
		GroupDiesel.diesel[1].drawGraph(canvas);//柴油机
		
//		for(int i=1;i<16;i++) {
//			Group_BJD.bjd[28+i].cx = 1700;
//			Group_BJD.bjd[28+i].cy = 75+92*i;
//			Group_BJD.bjd[28+i].rectWidth = 40;
//			Group_BJD.bjd[28+i].rectHeight = 40;
//			Group_BJD.bjd[28+i].color_status = Color.argb(255, 255, 0, 0);
//			Group_BJD.bjd[28+i].bBlink = false;
//			Group_BJD.bjd[28+i].bRectLight = false;
//			Group_BJD.bjd[28+i].drawGraph(canvas);
//		}
		
		Group_BJD.bjd[29].cx = 1700;
		Group_BJD.bjd[29].cy = 75+92*1;
		Group_BJD.bjd[29].rectWidth = 40;
		Group_BJD.bjd[29].rectHeight = 40;
		Group_BJD.bjd[29].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[29].bBlink = false;
		Group_BJD.bjd[29].bRectLight = false;
		Group_BJD.bjd[29].name="Over Speed Shutdown";
		Group_BJD.bjd[29].drawGraph(canvas);
		
		Group_BJD.bjd[30].cx = 1700;
		Group_BJD.bjd[30].cy = 75+92*2;
		Group_BJD.bjd[30].rectWidth = 40;
		Group_BJD.bjd[30].rectHeight = 40;
		Group_BJD.bjd[30].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[30].bBlink = false;
		Group_BJD.bjd[30].bRectLight = false;
		Group_BJD.bjd[30].name="Overspeed Sensor Wire Break";
		Group_BJD.bjd[30].drawGraph(canvas);
		
		Group_BJD.bjd[31].cx = 1700;
		Group_BJD.bjd[31].cy = 75+92*3;
		Group_BJD.bjd[31].rectWidth = 40;
		Group_BJD.bjd[31].rectHeight = 40;
		Group_BJD.bjd[31].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[31].bBlink = false;
		Group_BJD.bjd[31].bRectLight = false;
		Group_BJD.bjd[31].name="Low Lube Oil Pressure Shutdown";
		Group_BJD.bjd[31].drawGraph(canvas);
		
		Group_BJD.bjd[32].cx = 1700;
		Group_BJD.bjd[32].cy = 75+92*4;
		Group_BJD.bjd[32].rectWidth = 40;
		Group_BJD.bjd[32].rectHeight = 40;
		Group_BJD.bjd[32].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[32].bBlink = false;
		Group_BJD.bjd[32].bRectLight = false;
		Group_BJD.bjd[32].name="Oil Pressure Shutdwon Switch Wire Break";
		Group_BJD.bjd[32].drawGraph(canvas);
		
		Group_BJD.bjd[33].cx = 1700;
		Group_BJD.bjd[33].cy = 75+92*5;
		Group_BJD.bjd[33].rectWidth = 40;
		Group_BJD.bjd[33].rectHeight = 40;
		Group_BJD.bjd[33].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[33].bBlink = false;
		Group_BJD.bjd[33].bRectLight = false;
		Group_BJD.bjd[33].name="High Water Temp. Shutdown";
		Group_BJD.bjd[33].drawGraph(canvas);
		
		Group_BJD.bjd[34].cx = 1700;
		Group_BJD.bjd[34].cy = 75+92*6;
		Group_BJD.bjd[34].rectWidth = 40;
		Group_BJD.bjd[34].rectHeight = 40;
		Group_BJD.bjd[34].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[34].bBlink = false;
		Group_BJD.bjd[34].bRectLight = false;
		Group_BJD.bjd[34].name="JW Temp High High SW Wirebreak";
		Group_BJD.bjd[34].drawGraph(canvas);
		
		Group_BJD.bjd[35].cx = 1700;
		Group_BJD.bjd[35].cy = 75+92*7;
		Group_BJD.bjd[35].rectWidth = 40;
		Group_BJD.bjd[35].rectHeight = 40;
		Group_BJD.bjd[35].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[35].bBlink = false;
		Group_BJD.bjd[35].bRectLight = false;
		Group_BJD.bjd[35].name="Jacket Water Level Low Alarm";
		Group_BJD.bjd[35].drawGraph(canvas);
		
		Group_BJD.bjd[36].cx = 1700;
		Group_BJD.bjd[36].cy = 75+92*8;
		Group_BJD.bjd[36].rectWidth = 40;
		Group_BJD.bjd[36].rectHeight = 40;
		Group_BJD.bjd[36].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[36].bBlink = false;
		Group_BJD.bjd[36].bRectLight = false;
		Group_BJD.bjd[36].name="E-Stop Shutdown";
		Group_BJD.bjd[36].drawGraph(canvas);
		
		Group_BJD.bjd[37].cx = 1700;
		Group_BJD.bjd[37].cy = 75+92*9;
		Group_BJD.bjd[37].rectWidth = 40;
		Group_BJD.bjd[37].rectHeight = 40;
		Group_BJD.bjd[37].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[37].bBlink = false;
		Group_BJD.bjd[37].bRectLight = false;
		Group_BJD.bjd[37].name="Common Alarm";
		Group_BJD.bjd[37].drawGraph(canvas);
		
		Group_BJD.bjd[38].cx = 1700;
		Group_BJD.bjd[38].cy = 75+92*10;
		Group_BJD.bjd[38].rectWidth = 40;
		Group_BJD.bjd[38].rectHeight = 40;
		Group_BJD.bjd[38].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[38].bBlink = false;
		Group_BJD.bjd[38].bRectLight = false;
		Group_BJD.bjd[38].name="Common Shutdown";
		Group_BJD.bjd[38].drawGraph(canvas);
		
		Group_BJD.bjd[39].cx = 1700;
		Group_BJD.bjd[39].cy = 75+92*11;
		Group_BJD.bjd[39].rectWidth = 40;
		Group_BJD.bjd[39].rectHeight = 40;
		Group_BJD.bjd[39].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[39].bBlink = false;
		Group_BJD.bjd[39].bRectLight = false;
		Group_BJD.bjd[39].name="Start Failure Alarm";
		Group_BJD.bjd[39].drawGraph(canvas);
		
		Group_BJD.bjd[40].cx = 1700;
		Group_BJD.bjd[40].cy = 75+92*12;
		Group_BJD.bjd[40].rectWidth = 40;
		Group_BJD.bjd[40].rectHeight = 40;
		Group_BJD.bjd[40].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[40].bBlink = false;
		Group_BJD.bjd[40].bRectLight = false;
		Group_BJD.bjd[40].name="Main 24VDC Power loss";
		Group_BJD.bjd[40].drawGraph(canvas);
		
		Group_BJD.bjd[41].cx = 1700;
		Group_BJD.bjd[41].cy = 75+92*13;
		Group_BJD.bjd[41].rectWidth = 40;
		Group_BJD.bjd[41].rectHeight = 40;
		Group_BJD.bjd[41].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[41].bBlink = false;
		Group_BJD.bjd[41].bRectLight = false;
		Group_BJD.bjd[41].name="Backup 24VDC Power loss";
		Group_BJD.bjd[41].drawGraph(canvas);
		
		Group_BJD.bjd[42].cx = 1700;
		Group_BJD.bjd[42].cy = 75+92*14;
		Group_BJD.bjd[42].rectWidth = 40;
		Group_BJD.bjd[42].rectHeight = 40;
		Group_BJD.bjd[42].color_status = Color.argb(255, 0, 255, 0);;
		Group_BJD.bjd[42].bBlink = false;
		Group_BJD.bjd[42].bRectLight = false;
		Group_BJD.bjd[42].name="Engine Running";
		Group_BJD.bjd[42].drawGraph(canvas);
		
		Group_BJD.bjd[43].cx = 1700;
		Group_BJD.bjd[43].cy = 75+92*15;
		Group_BJD.bjd[43].rectWidth = 40;
		Group_BJD.bjd[43].rectHeight = 40;
		Group_BJD.bjd[43].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[43].bBlink = false;
		Group_BJD.bjd[43].bRectLight = false;
		Group_BJD.bjd[43].name="Over Speed Shutdown";
		Group_BJD.bjd[43].drawGraph(canvas);
		
		
		//////////////////////////////////////////////////////////////////////////////////数据
		
		GroupText.text[22].cx = 1280-40; // L/h
		GroupText.text[22].cy = 650;
		GroupText.text[22].textSize = 40;
		GroupText.text[22].format = 0;
		GroupText.text[22].isFont_right=true;
//		GroupText.text[22].drawGraph(canvas);
		
		GroupText.text[23].cx = 1280-40; // L
		GroupText.text[23].cy = 900;
		GroupText.text[23].textSize = 40;
		GroupText.text[23].format = 2;
		GroupText.text[23].isFont_right=true;
//		GroupText.text[23].drawGraph(canvas);
		
		GroupText.text[3].cx = 333-40;
		GroupText.text[3].cy = 450;
		GroupText.text[3].textSize = 40;
		GroupText.text[3].format = 1;
		GroupText.text[3].isFont_center=true;
		GroupText.text[3].drawGraph(canvas);//电机转速
		
		GroupText.text[2].cx = 666-40;
		GroupText.text[2].cy = 450;
		GroupText.text[2].textSize = 40;
		GroupText.text[2].format = 1;
		GroupText.text[2].isFont_center=true;
		GroupText.text[2].drawGraph(canvas);//电池电压
		
		GroupText.text[0].cx = 250-40;
		GroupText.text[0].cy = 950;
		GroupText.text[0].textSize = 40;
		GroupText.text[0].format = 1;
		GroupText.text[0].isFont_center=true;
		GroupText.text[0].drawGraph(canvas);//温度1
		
		GroupText.text[4].cx = 500-40;
		GroupText.text[4].cy = 950;
		GroupText.text[4].textSize = 40;
		GroupText.text[4].format = 1;
		GroupText.text[4].isFont_center=true;
		GroupText.text[4].drawGraph(canvas);//温度2
		
		GroupText.text[7].cx = 750-40;
		GroupText.text[7].cy = 950;
		GroupText.text[7].textSize = 40;
		GroupText.text[7].format = 1;
		GroupText.text[7].isFont_center=true;
		GroupText.text[7].drawGraph(canvas);//温度3
		
		GroupText.text[1].cx = 250-40;
		GroupText.text[1].cy = 1450;
		GroupText.text[1].textSize = 40;
		GroupText.text[1].format = 1;
		GroupText.text[1].isFont_center=true;
		GroupText.text[1].drawGraph(canvas);//压力1
		
		GroupText.text[5].cx = 500-40;
		GroupText.text[5].cy = 1450;
		GroupText.text[5].textSize = 40;
		GroupText.text[5].format = 1;
		GroupText.text[5].isFont_center=true;
		GroupText.text[5].drawGraph(canvas);//压力2
		
		GroupText.text[6].cx = 750-40;
		GroupText.text[6].cy = 1450;
		GroupText.text[6].textSize = 40;
		GroupText.text[6].format = 1;
		GroupText.text[6].isFont_center=true;
		GroupText.text[6].drawGraph(canvas);//压力3
		//////////////////////////////////////////////////////////////////////////////////文本
		Paint paint = new Paint();
		paint.setStrokeWidth(1);
		paint.setAntiAlias(true);
		paint.setStyle(Style.FILL);
		
		paint.setTextAlign(Align.CENTER);
		paint.setColor(Color.rgb(131, 175, 155));
		paint.setTextSize(40);
//		canvas.drawText("Fuel Consumption Rate", 1280, 600, paint);
//		canvas.drawText("Total Fuel Consumption", 1280, 850, paint);

		paint.setTextSize(20);
		canvas.drawText("Engine Speed", 333, 500, paint);
		canvas.drawText("Battery Voltage", 666, 500, paint);

		canvas.drawText("Engine oil", 250, 1000, paint);
		canvas.drawText("Engine coolant water", 500, 1000, paint);
		canvas.drawText("Exhaust", 750, 1000, paint);
		canvas.drawText("Temperature", 250, 1025, paint);
		canvas.drawText("Temperature", 500, 1025, paint);
		canvas.drawText("Temperature", 750, 1025, paint);

		canvas.drawText("Fuel", 250, 1500, paint);
		canvas.drawText("Engine oil", 500, 1500, paint);
		canvas.drawText("Jacket water", 750, 1500, paint);
		canvas.drawText("pressure", 250, 1525, paint);
		canvas.drawText("pressure", 500, 1525, paint);
		canvas.drawText("pressure", 750, 1525, paint);

		paint.setTextSize(30);
		paint.setColor(Color.GREEN);
		canvas.drawText("TEMPERATURE", 500, 610, paint);
		canvas.drawText("PRESSURE", 500, 1110, paint);
		
		paint.setTextAlign(Align.LEFT);
		paint.setTextSize(40);
		paint.setColor(Color.rgb(138, 151, 123));
//		canvas.drawText("L/h", 1280+20, 650, paint);
//		canvas.drawText("L", 1280+20, 900, paint);
		canvas.drawText("r/min", 333+20, 450, paint);
		canvas.drawText("V", 666+20, 450, paint);
		canvas.drawText("℃", 250+20, 950, paint);
		canvas.drawText("℃", 500+20, 950, paint);
		canvas.drawText("℃", 750+20, 950, paint);
		canvas.drawText("bar", 250+20, 1450, paint);
		canvas.drawText("bar", 500+20, 1450, paint);
		canvas.drawText("bar", 750+20, 1450, paint);
		
		paint.setColor(Color.rgb(222, 156, 83));
		paint.setTextSize(38);
		canvas.drawText("Over Speed Shutdown", 1800, 85+92*1, paint);
		canvas.drawText("Overspeed Sensor Wire Break", 1800, 85+92*2, paint);
		canvas.drawText("Low Lube Oil Pressure Shutdown", 1800, 85+92*3, paint);
		canvas.drawText("Oil Pressure Shutdwon Switch Wire Break", 1800, 85+92*4, paint);
		canvas.drawText("High Water Temp. Shutdown", 1800, 85+92*5, paint);
		canvas.drawText("JW Temp High High SW Wirebreak", 1800, 85+92*6, paint);
		canvas.drawText("Jacket Water Level Low Alarm", 1800, 85+92*7, paint);
		canvas.drawText("E-Stop Shutdown", 1800, 85+92*8, paint);
		canvas.drawText("Common Alarm", 1800, 85+92*9, paint);
		canvas.drawText("Common Shutdown", 1800, 85+92*10, paint);
		canvas.drawText("Start Failure Alarm", 1800, 85+92*11, paint);
		canvas.drawText("Main 24VDC Power loss", 1800, 85+92*12, paint);
		canvas.drawText("Backup 24VDC Power loss", 1800, 85+92*13, paint);
		canvas.drawText("Engine Running", 1800, 85+92*14, paint);
		canvas.drawText("Over Speed Shutdown", 1800, 85+92*15, paint);
		//////////////////////////////////////////////////////////////////////////////////分割线
		paint.setColor(Color.rgb(113, 150, 159));
		canvas.drawLine(30, 100, 975, 100, paint);
		canvas.drawLine(975, 100, 975, 1100, paint);
		canvas.drawLine(975, 1100, 1595, 1100, paint);
		canvas.drawLine(1595, 1100, 1595, 100, paint);
		canvas.drawLine(1595, 100, 2530, 100, paint);

		canvas.drawLine(2530, 100, 2530, 1550, paint);
		canvas.drawLine(30, 1550, 975, 1550, paint);
		canvas.drawLine(1595, 1550, 2530, 1550, paint);
		canvas.drawLine(30, 1550, 30, 100, paint);

		canvas.drawLine(975, 1100, 975, 1550, paint);
		canvas.drawLine(1595, 1100, 1595, 1550, paint);
		//////////////////////////////////////////////////////////////////////////////////
		paint.setTextAlign(Align.LEFT);
		paint.setColor(Color.YELLOW);	
		paint.setTextSize(30);
		canvas.drawText("Page 5:", 10, 30, paint);
		paint.setColor(Color.GREEN);
		canvas.drawText("Hydraulic Pump Diesel Engine", 120, 30, paint);
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