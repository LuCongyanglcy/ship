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
public class Page004 {

	public static void DrawPage(Canvas canvas) {

//		if (GateValveActivity.control_limite) {
//			canvas.drawBitmap(GateValveActivity.bmp11, 2150, 70, null);
//		} else {
//			canvas.drawBitmap(GateValveActivity.bmp10, 2150, 70, null);
//		}
		//////////////////////////////////////////////////////////////////////////////////图元
		GroupRuler.ruler[5].cx = 333 ; 
		GroupRuler.ruler[5].cy = 150 ;
		GroupRuler.ruler[5].rectHeight = 240;
		GroupRuler.ruler[5].rectWidth = 150;
		GroupRuler.ruler[5].higherDepth = 10000;
		GroupRuler.ruler[5].underDepth = 0;
		GroupRuler.ruler[5].rulerhigher = 3000;
		GroupRuler.ruler[5].rulerunder = 0;
		GroupRuler.ruler[5].rulermain = 5;
		GroupRuler.ruler[5].rulersecond = 4;
		GroupRuler.ruler[5].ifint = true;
		GroupRuler.ruler[5].switchdirection = false;
		GroupRuler.ruler[5].drawGraph(canvas);//电机转速
		
		GroupRuler.ruler[6].cx = 666 ; 
		GroupRuler.ruler[6].cy = 150 ;
		GroupRuler.ruler[6].rectHeight = 240;
		GroupRuler.ruler[6].rectWidth = 150;
		GroupRuler.ruler[6].higherDepth = 10000;
		GroupRuler.ruler[6].underDepth = 0;
		GroupRuler.ruler[6].rulerhigher = 40;
		GroupRuler.ruler[6].rulerunder = 0;
		GroupRuler.ruler[6].rulermain = 5;
		GroupRuler.ruler[6].rulersecond = 4;
		GroupRuler.ruler[6].ifint = true;
		GroupRuler.ruler[6].switchdirection = false;
		GroupRuler.ruler[6].drawGraph(canvas);//电池电压
		
		GroupRuler.ruler[7].cx = 200 ; 
		GroupRuler.ruler[7].cy = 650 ;
		GroupRuler.ruler[7].rectHeight = 240;
		GroupRuler.ruler[7].rectWidth = 150;
		GroupRuler.ruler[7].higherDepth = 10000;
		GroupRuler.ruler[7].underDepth = 0;
		GroupRuler.ruler[7].rulerhigher = 850;
		GroupRuler.ruler[7].rulerunder = 0;
		GroupRuler.ruler[7].rulermain = 5;
		GroupRuler.ruler[7].rulersecond = 4;
		GroupRuler.ruler[7].ifint = true;
		GroupRuler.ruler[7].switchdirection = false;
		GroupRuler.ruler[7].drawGraph(canvas);//温度1
		
		GroupRuler.ruler[8].cx = 400 ; 
		GroupRuler.ruler[8].cy = 650 ;
		GroupRuler.ruler[8].rectHeight = 240;
		GroupRuler.ruler[8].rectWidth = 150;
		GroupRuler.ruler[8].higherDepth = 10000;
		GroupRuler.ruler[8].underDepth = 0;
		GroupRuler.ruler[8].rulerhigher = 850;
		GroupRuler.ruler[8].rulerunder = 0;
		GroupRuler.ruler[8].rulermain = 5;
		GroupRuler.ruler[8].rulersecond = 4;
		GroupRuler.ruler[8].ifint = true;
		GroupRuler.ruler[8].switchdirection = false;
		GroupRuler.ruler[8].drawGraph(canvas);//温度2
		
		GroupRuler.ruler[9].cx = 600 ; 
		GroupRuler.ruler[9].cy = 650 ;
		GroupRuler.ruler[9].rectHeight = 240;
		GroupRuler.ruler[9].rectWidth = 150;
		GroupRuler.ruler[9].higherDepth = 10000;
		GroupRuler.ruler[9].underDepth = 0;
		GroupRuler.ruler[9].rulerhigher = 150;
		GroupRuler.ruler[9].rulerunder = 0;
		GroupRuler.ruler[9].rulermain = 5;
		GroupRuler.ruler[9].rulersecond = 4;
		GroupRuler.ruler[9].ifint = true;
		GroupRuler.ruler[9].switchdirection = false;
		GroupRuler.ruler[9].drawGraph(canvas);//温度3
	
		GroupRuler.ruler[10].cx = 800 ; 
		GroupRuler.ruler[10].cy = 650 ;
		GroupRuler.ruler[10].rectHeight = 240;
		GroupRuler.ruler[10].rectWidth = 150;
		GroupRuler.ruler[10].higherDepth = 10000;
		GroupRuler.ruler[10].underDepth = 0;
		GroupRuler.ruler[10].rulerhigher = 150;
		GroupRuler.ruler[10].rulerunder = 0;
		GroupRuler.ruler[10].rulermain = 5;
		GroupRuler.ruler[10].rulersecond = 4;
		GroupRuler.ruler[10].ifint = true;
		GroupRuler.ruler[10].switchdirection = false;
		GroupRuler.ruler[10].drawGraph(canvas);//温度4
		
		GroupRuler.ruler[11].cx = 200; 
		GroupRuler.ruler[11].cy = 1150;
		GroupRuler.ruler[11].rectHeight = 240;
		GroupRuler.ruler[11].rectWidth = 150;
		GroupRuler.ruler[11].higherDepth = 10000;
		GroupRuler.ruler[11].underDepth = 0;
		GroupRuler.ruler[11].rulerhigher = 5;
		GroupRuler.ruler[11].rulerunder = 0;
		GroupRuler.ruler[11].rulermain = 5;
		GroupRuler.ruler[11].rulersecond = 4;
		GroupRuler.ruler[11].ifint = true ;
		GroupRuler.ruler[11].switchdirection = false;
		GroupRuler.ruler[11].drawGraph(canvas);//压力1
		
		GroupRuler.ruler[12].cx = 400; 
		GroupRuler.ruler[12].cy = 1150;
		GroupRuler.ruler[12].rectHeight = 240;
		GroupRuler.ruler[12].rectWidth = 150;
		GroupRuler.ruler[12].higherDepth = 10000;
		GroupRuler.ruler[12].underDepth = 0;
		GroupRuler.ruler[12].rulerhigher = 1.25f;
		GroupRuler.ruler[12].rulerunder = 0;
		GroupRuler.ruler[12].rulermain = 5;
		GroupRuler.ruler[12].rulersecond = 4;
		GroupRuler.ruler[12].format = 2 ;
		GroupRuler.ruler[12].switchdirection = false;
		GroupRuler.ruler[12].drawGraph(canvas);//压力2
		
		GroupRuler.ruler[13].cx = 600; 
		GroupRuler.ruler[13].cy = 1150;
		GroupRuler.ruler[13].rectHeight = 240;
		GroupRuler.ruler[13].rectWidth = 150;
		GroupRuler.ruler[13].higherDepth = 10000;
		GroupRuler.ruler[13].underDepth = 0;
		GroupRuler.ruler[13].rulerhigher = 0.5f;
		GroupRuler.ruler[13].rulerunder = 0;
		GroupRuler.ruler[13].rulermain = 5;
		GroupRuler.ruler[13].rulersecond = 4;
		GroupRuler.ruler[13].format = 1 ;
		GroupRuler.ruler[13].switchdirection = false;
		GroupRuler.ruler[13].drawGraph(canvas);//压力3
		
		GroupRuler.ruler[14].cx = 800; 
		GroupRuler.ruler[14].cy = 1150;
		GroupRuler.ruler[14].rectHeight = 240;
		GroupRuler.ruler[14].rectWidth = 150;
		GroupRuler.ruler[14].higherDepth = 10000;
		GroupRuler.ruler[14].underDepth = 0;
		GroupRuler.ruler[14].rulerhigher = 10;
		GroupRuler.ruler[14].rulerunder = 0;
		GroupRuler.ruler[14].rulermain = 5;
		GroupRuler.ruler[14].rulersecond = 4;
		GroupRuler.ruler[14].ifint = true ;
		GroupRuler.ruler[14].switchdirection = false;
		GroupRuler.ruler[14].drawGraph(canvas);//压力4
		
		GroupRuler.ruler[15].cx = 1000; 
		GroupRuler.ruler[15].cy = 1150;
		GroupRuler.ruler[15].rectHeight = 240;
		GroupRuler.ruler[15].rectWidth = 150;
		GroupRuler.ruler[15].higherDepth = 10000;
		GroupRuler.ruler[15].underDepth = 0;
		GroupRuler.ruler[15].rulerhigher = 1.5f;
		GroupRuler.ruler[15].rulerunder = 0;
		GroupRuler.ruler[15].rulermain = 5;
		GroupRuler.ruler[15].rulersecond = 4;
		GroupRuler.ruler[15].format = 1 ;
		GroupRuler.ruler[15].switchdirection = false;
		GroupRuler.ruler[15].drawGraph(canvas);//压力5
		
		GroupRuler.ruler[16].cx = 1200; 
		GroupRuler.ruler[16].cy = 1150;
		GroupRuler.ruler[16].rectHeight = 240;
		GroupRuler.ruler[16].rectWidth = 150;
		GroupRuler.ruler[16].higherDepth = 10000;
		GroupRuler.ruler[16].underDepth = 0;
		GroupRuler.ruler[16].rulerhigher = 10;
		GroupRuler.ruler[16].rulerunder = 0;
		GroupRuler.ruler[16].rulermain = 5;
		GroupRuler.ruler[16].rulersecond = 4;
		GroupRuler.ruler[16].ifint = true ;
		GroupRuler.ruler[16].switchdirection = false;
		GroupRuler.ruler[16].drawGraph(canvas);//压力6
		
		GroupRuler.ruler[17].cx = 1400; 
		GroupRuler.ruler[17].cy = 1150;
		GroupRuler.ruler[17].rectHeight = 240;
		GroupRuler.ruler[17].rectWidth = 150;
		GroupRuler.ruler[17].higherDepth = 10000;
		GroupRuler.ruler[17].underDepth = 0;
		GroupRuler.ruler[17].rulerhigher = 4;
		GroupRuler.ruler[17].rulerunder = 0;
		GroupRuler.ruler[17].rulermain = 5;
		GroupRuler.ruler[17].rulersecond = 4;
		GroupRuler.ruler[17].format = 1 ;
		GroupRuler.ruler[17].switchdirection = false;
		GroupRuler.ruler[17].drawGraph(canvas);//压力7
		
		GroupDiesel.diesel[0].cx = 1150;
		GroupDiesel.diesel[0].cy = 200;
		GroupDiesel.diesel[0].rectHeight = 280;
		GroupDiesel.diesel[0].rectWidth = 300;			
		GroupDiesel.diesel[0].num = 5;
		GroupDiesel.diesel[0].drawGraph(canvas);//柴油机
		
//		for(int i=1;i<15;i++) {
//			Group_BJD.bjd[45+i].cx = 1700;
//			Group_BJD.bjd[45+i].cy = 75+100*i;
//			Group_BJD.bjd[45+i].rectWidth = 40;
//			Group_BJD.bjd[45+i].rectHeight = 40;
//			Group_BJD.bjd[45+i].color_status = Color.argb(255, 255, 0, 0);
//			Group_BJD.bjd[45+i].bBlink = false;
//			Group_BJD.bjd[45+i].bRectLight = false;
//			Group_BJD.bjd[45+i].drawGraph(canvas);
//		}
		
		Group_BJD.bjd[46].cx = 1700;
		Group_BJD.bjd[46].cy = 75+100*1;
		Group_BJD.bjd[46].rectWidth = 40;
		Group_BJD.bjd[46].rectHeight = 40;
		Group_BJD.bjd[46].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[46].bBlink = false;
		Group_BJD.bjd[46].bRectLight = false;
		Group_BJD.bjd[46].name="Over Speed Shutdown";
		Group_BJD.bjd[46].drawGraph(canvas);
		
		Group_BJD.bjd[47].cx = 1700;
		Group_BJD.bjd[47].cy = 75+100*2;
		Group_BJD.bjd[47].rectWidth = 40;
		Group_BJD.bjd[47].rectHeight = 40;
		Group_BJD.bjd[47].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[47].bBlink = false;
		Group_BJD.bjd[47].bRectLight = false;
		Group_BJD.bjd[47].name="Low Lube Oil Shutdown";
		Group_BJD.bjd[47].drawGraph(canvas);
		
		Group_BJD.bjd[48].cx = 1700;
		Group_BJD.bjd[48].cy = 75+100*3;
		Group_BJD.bjd[48].rectWidth = 40;
		Group_BJD.bjd[48].rectHeight = 40;
		Group_BJD.bjd[48].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[48].bBlink = false;
		Group_BJD.bjd[48].bRectLight = false;
		Group_BJD.bjd[48].name="Oil Pressure Low Low SW Wirebreak";
		Group_BJD.bjd[48].drawGraph(canvas);
		
		Group_BJD.bjd[49].cx = 1700;
		Group_BJD.bjd[49].cy = 75+100*4;
		Group_BJD.bjd[49].rectWidth = 40;
		Group_BJD.bjd[49].rectHeight = 40;
		Group_BJD.bjd[49].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[49].bBlink = false;
		Group_BJD.bjd[49].bRectLight = false;
		Group_BJD.bjd[49].name="High Water Temp. Shutdown";
		Group_BJD.bjd[49].drawGraph(canvas);
		
		Group_BJD.bjd[50].cx = 1700;
		Group_BJD.bjd[50].cy = 75+100*5;
		Group_BJD.bjd[50].rectWidth = 40;
		Group_BJD.bjd[50].rectHeight = 40;
		Group_BJD.bjd[50].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[50].bBlink = false;
		Group_BJD.bjd[50].bRectLight = false;
		Group_BJD.bjd[50].name="JW Temp High High SW Wirebreak";
		Group_BJD.bjd[50].drawGraph(canvas);
		
		Group_BJD.bjd[51].cx = 1700;
		Group_BJD.bjd[51].cy = 75+100*6;
		Group_BJD.bjd[51].rectWidth = 40;
		Group_BJD.bjd[51].rectHeight = 40;
		Group_BJD.bjd[51].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[51].bBlink = false;
		Group_BJD.bjd[51].bRectLight = false;
		Group_BJD.bjd[51].name="Water Level Low Alarm";
		Group_BJD.bjd[51].drawGraph(canvas);
		
		Group_BJD.bjd[52].cx = 1700;
		Group_BJD.bjd[52].cy = 75+100*7;
		Group_BJD.bjd[52].rectWidth = 40;
		Group_BJD.bjd[52].rectHeight = 40;
		Group_BJD.bjd[52].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[52].bBlink = false;
		Group_BJD.bjd[52].bRectLight = false;
		Group_BJD.bjd[52].name="E-Stop Shutdown";
		Group_BJD.bjd[52].drawGraph(canvas);
		
		Group_BJD.bjd[53].cx = 1700;
		Group_BJD.bjd[53].cy = 75+100*8;
		Group_BJD.bjd[53].rectWidth = 40;
		Group_BJD.bjd[53].rectHeight = 40;
		Group_BJD.bjd[53].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[53].bBlink = false;
		Group_BJD.bjd[53].bRectLight = false;
		Group_BJD.bjd[53].name="Common Alarm";
		Group_BJD.bjd[53].drawGraph(canvas);
		
		Group_BJD.bjd[54].cx = 1700;
		Group_BJD.bjd[54].cy = 75+100*9;
		Group_BJD.bjd[54].rectWidth = 40;
		Group_BJD.bjd[54].rectHeight = 40;
		Group_BJD.bjd[54].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[54].bBlink = false;
		Group_BJD.bjd[54].bRectLight = false;
		Group_BJD.bjd[54].name="Common Shutdown";
		Group_BJD.bjd[54].drawGraph(canvas);
		
		Group_BJD.bjd[55].cx = 1700;
		Group_BJD.bjd[55].cy = 75+100*10;
		Group_BJD.bjd[55].rectWidth = 40;
		Group_BJD.bjd[55].rectHeight = 40;
		Group_BJD.bjd[55].color_status =Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[55].bBlink = false;
		Group_BJD.bjd[55].bRectLight = false;
		Group_BJD.bjd[55].name="Engine running";
		Group_BJD.bjd[55].drawGraph(canvas);
		
		Group_BJD.bjd[56].cx = 1700;
		Group_BJD.bjd[56].cy = 75+100*11;
		Group_BJD.bjd[56].rectWidth = 40;
		Group_BJD.bjd[56].rectHeight = 40;
		Group_BJD.bjd[56].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[56].bBlink = false;
		Group_BJD.bjd[56].bRectLight = false;
		Group_BJD.bjd[56].name="Main 24VDC Power loss";
		Group_BJD.bjd[56].drawGraph(canvas);
		
		Group_BJD.bjd[57].cx = 1700;
		Group_BJD.bjd[57].cy = 75+100*12;
		Group_BJD.bjd[57].rectWidth = 40;
		Group_BJD.bjd[57].rectHeight = 40;
		Group_BJD.bjd[57].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[57].bBlink = false;
		Group_BJD.bjd[57].bRectLight = false;
		Group_BJD.bjd[57].name="Backup 24VDC Power loss";
		Group_BJD.bjd[57].drawGraph(canvas);
		
		Group_BJD.bjd[58].cx = 1700;
		Group_BJD.bjd[58].cy = 75+100*13;
		Group_BJD.bjd[58].rectWidth = 40;
		Group_BJD.bjd[58].rectHeight = 40;
		Group_BJD.bjd[58].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[58].bBlink = false;
		Group_BJD.bjd[58].bRectLight = false;
		Group_BJD.bjd[58].name="Remote speed control mode";
		Group_BJD.bjd[58].drawGraph(canvas);
		
		Group_BJD.bjd[59].cx = 1700;
		Group_BJD.bjd[59].cy = 75+100*14;
		Group_BJD.bjd[59].rectWidth = 40;
		Group_BJD.bjd[59].rectHeight = 40;
		Group_BJD.bjd[59].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[59].bBlink = false;
		Group_BJD.bjd[59].bRectLight = false;
		Group_BJD.bjd[59].name="Allow Clutch In";
		Group_BJD.bjd[59].drawGraph(canvas);
		//////////////////////////////////////////////////////////////////////////////////数据
		
		GroupText.text[21].cx = 1280-40; // L/h
		GroupText.text[21].cy = 650;
		GroupText.text[21].textSize = 40;
		GroupText.text[21].format = 0;
		GroupText.text[21].isFont_right=true;
		GroupText.text[21].drawGraph(canvas);
		
		GroupText.text[22].cx = 1280-40; // L
		GroupText.text[22].cy = 900;
		GroupText.text[22].textSize = 40;
		GroupText.text[22].format = 0;
		GroupText.text[22].isFont_right=true;
		GroupText.text[22].drawGraph(canvas);
		
		GroupText.text[17].cx = 333-40;
		GroupText.text[17].cy = 450;
		GroupText.text[17].textSize = 40;
		GroupText.text[17].format = 1;
		GroupText.text[17].isFont_center=true;
		GroupText.text[17].drawGraph(canvas);//电机转速
		
		GroupText.text[16].cx = 666-40;
		GroupText.text[16].cy = 450;
		GroupText.text[16].textSize = 40;
		GroupText.text[16].format = 1;
		GroupText.text[16].isFont_center=true;
		GroupText.text[16].drawGraph(canvas);//电池电压
		
		GroupText.text[10].cx = 200-40;
		GroupText.text[10].cy = 950;
		GroupText.text[10].textSize = 40;
		GroupText.text[10].format = 1;
		GroupText.text[10].isFont_center=true;
		GroupText.text[10].drawGraph(canvas);//温度1
		
		GroupText.text[11].cx = 400-40;
		GroupText.text[11].cy = 950;
		GroupText.text[11].textSize = 40;
		GroupText.text[11].format = 1;
		GroupText.text[11].isFont_center=true;
		GroupText.text[11].drawGraph(canvas);//温度2
		
		GroupText.text[13].cx = 600-40;
		GroupText.text[13].cy = 950;
		GroupText.text[13].textSize = 40;
		GroupText.text[13].format = 1;
		GroupText.text[13].isFont_center=true;
		GroupText.text[13].drawGraph(canvas);//温度3
		
		GroupText.text[18].cx = 800-40;
		GroupText.text[18].cy = 950;
		GroupText.text[18].textSize = 40;
		GroupText.text[18].format = 1;
		GroupText.text[18].isFont_center=true;
		GroupText.text[18].drawGraph(canvas);//温度4
		
		GroupText.text[8].cx = 200-40;
		GroupText.text[8].cy = 1450;
		GroupText.text[8].textSize = 40;
		GroupText.text[8].format = 1;
		GroupText.text[8].isFont_center=true;
		GroupText.text[8].drawGraph(canvas);//压力1
		
		GroupText.text[9].cx = 400-40;
		GroupText.text[9].cy = 1450;
		GroupText.text[9].textSize = 40;
		GroupText.text[9].format = 1;
		GroupText.text[9].isFont_center=true;
		GroupText.text[9].drawGraph(canvas);//压力2
		
		GroupText.text[12].cx = 600-40;
		GroupText.text[12].cy = 1450;
		GroupText.text[12].textSize = 40;
		GroupText.text[12].format = 1;
		GroupText.text[12].isFont_center=true;
		GroupText.text[12].drawGraph(canvas);//压力3
		
		GroupText.text[14].cx = 800-40;
		GroupText.text[14].cy = 1450;
		GroupText.text[14].textSize = 40;
		GroupText.text[14].format = 1;
		GroupText.text[14].isFont_center=true;
		GroupText.text[14].drawGraph(canvas);//压力4
		
		GroupText.text[15].cx = 1000-40;
		GroupText.text[15].cy = 1450;
		GroupText.text[15].textSize = 40;
		GroupText.text[15].format = 1;
		GroupText.text[15].isFont_center=true;
		GroupText.text[15].drawGraph(canvas);//压力5
		
		GroupText.text[20].cx = 1200-40;
		GroupText.text[20].cy = 1450;
		GroupText.text[20].textSize = 40;
		GroupText.text[20].format = 1;
		GroupText.text[20].isFont_center=true;
		GroupText.text[20].drawGraph(canvas);//压力6
		
		GroupText.text[19].cx = 1400-40;
		GroupText.text[19].cy = 1450;
		GroupText.text[19].textSize = 40;
		GroupText.text[19].format = 1;
		GroupText.text[19].isFont_center=true;
		GroupText.text[19].drawGraph(canvas);//压力7
		//////////////////////////////////////////////////////////////////////////////////文本
		Paint paint = new Paint();
		paint.setStrokeWidth(1);
		paint.setAntiAlias(true);
		paint.setStyle(Style.FILL);
		
		paint.setTextAlign(Align.CENTER);
		paint.setColor(Color.rgb(131, 175, 155));
		paint.setTextSize(40);
		canvas.drawText("Fuel Consumption Rate", 1280, 600, paint);
		canvas.drawText("Total Fuel Consumption", 1280, 850, paint);

		paint.setTextSize(20);
		canvas.drawText("Engine Speed", 333, 490, paint);
		canvas.drawText("Battery Voltage", 666, 490, paint);

		canvas.drawText("Right Exhaust", 200, 990, paint);
		canvas.drawText("Left Exhaust", 400, 990, paint);
		canvas.drawText("Engine Oil", 600, 990, paint);
		canvas.drawText("Engine Coolant Water", 800, 990, paint);
		canvas.drawText("Temperature", 200, 1015, paint);
		canvas.drawText("Temperature", 400, 1015, paint);
		canvas.drawText("Temperature", 600, 1015, paint);
		canvas.drawText("Temperature", 800, 1015, paint);

		canvas.drawText("Boost", 200, 1490, paint);
		canvas.drawText("Fuel Filter", 400, 1490, paint);
		canvas.drawText("Crankcase", 600, 1490, paint);
		canvas.drawText("Fuel", 800, 1490, paint);
		canvas.drawText("Oil Filter Differential", 1000, 1490, paint);
		canvas.drawText("Jacket Water", 1200, 1490, paint);
		canvas.drawText("Engine oil", 1400, 1490, paint);
		canvas.drawText("pressure", 200, 1515, paint);
		canvas.drawText("differential", 400, 1515, paint);
		canvas.drawText("pressure", 600, 1515, paint);
		canvas.drawText("pressure", 800, 1515, paint);
		canvas.drawText("pressure", 1000, 1515, paint);
		canvas.drawText("pressure", 1200, 1515, paint);
		canvas.drawText("pressure", 1400, 1515, paint);
		canvas.drawText("pressure", 400, 1540, paint);
		
		paint.setTextSize(30);
		paint.setColor(Color.GREEN);
		canvas.drawText("TEMPERATURE", 500, 610, paint);
		canvas.drawText("PRESSURE", 500, 1110, paint);
		
		paint.setTextAlign(Align.LEFT);
		paint.setTextSize(40);
		paint.setColor(Color.rgb(138, 151, 123));
		canvas.drawText("L/h", 1280+20, 650, paint);
		canvas.drawText("L", 1280+20, 900, paint);
		canvas.drawText("r/min", 333+20, 450, paint);
		canvas.drawText("V", 666+20, 450, paint);
		canvas.drawText("℃", 200+20, 950, paint);
		canvas.drawText("℃", 400+20, 950, paint);
		canvas.drawText("℃", 600+20, 950, paint);
		canvas.drawText("℃", 800+20, 950, paint);
		canvas.drawText("bar", 200+20, 1450, paint);
		canvas.drawText("bar", 400+20, 1450, paint);
		canvas.drawText("bar", 600+20, 1450, paint);
		canvas.drawText("bar", 800+20, 1450, paint);
		canvas.drawText("bar", 1000+20, 1450, paint);
		canvas.drawText("bar", 1200+20, 1450, paint);
		canvas.drawText("bar", 1400+20, 1450, paint);
		
		paint.setColor(Color.rgb(222, 156, 83));
		paint.setTextSize(38);
		canvas.drawText("Over Speed Shutdown", 1800, 185, paint);
		canvas.drawText("Low Lube Oil Shutdown", 1800, 285, paint);
		canvas.drawText("Oil Pressure Low Low SW Wirebreak", 1800, 385, paint);
		canvas.drawText("High Water Temp. Shutdown", 1800, 485, paint);
		canvas.drawText("JW Temp High High SW Wirebreak", 1800, 585, paint);
		canvas.drawText("Water Level Low Alarm", 1800, 685, paint);
		canvas.drawText("E-Stop Shutdown", 1800, 785, paint);
		canvas.drawText("Common Alarm", 1800, 885, paint);
		canvas.drawText("Common Shutdown", 1800, 985, paint);
		canvas.drawText("Engine running", 1800, 1085, paint);
		canvas.drawText("Main 24VDC Power loss", 1800, 1185, paint);
		canvas.drawText("Backup 24VDC Power loss", 1800, 1285, paint);
		canvas.drawText("Remote speed control mode", 1800, 1385, paint);
		canvas.drawText("Allow Clutch In", 1800, 1485, paint);
		//////////////////////////////////////////////////////////////////////////////////分割线
		paint.setColor(Color.rgb(113, 150, 159));
		canvas.drawLine(30, 100, 975, 100, paint);
		canvas.drawLine(975, 100, 975, 1100, paint);
		canvas.drawLine(975, 1100, 1595, 1100, paint);
		canvas.drawLine(1595, 1100, 1595, 100, paint);
		canvas.drawLine(1595, 100, 2530, 100, paint);

		canvas.drawLine(2530, 100, 2530, 1550, paint);
		canvas.drawLine(30, 1550, 2530, 1550, paint);
		canvas.drawLine(30, 1550, 30, 100, paint);
		
		canvas.drawLine(1595, 1100, 1595, 1550, paint);
		//////////////////////////////////////////////////////////////////////////////////
		paint.setTextAlign(Align.LEFT);
		paint.setColor(Color.YELLOW);	
		paint.setTextSize(30);
		canvas.drawText("Page 4:", 10, 30, paint);
		paint.setColor(Color.GREEN);
		canvas.drawText("Dredge Pump Diesel Engine", 120, 30, paint);
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