package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Page010 {
	
	public static int LineColor1;
	
	public static void DrawPage(Canvas canvas)
	{ 	
		GoupButtons.button[0].cx = 104;
		GoupButtons.button[0].cy = 1550;
		GoupButtons.button[0].rectWidth = 208;
		GoupButtons.button[0].rectHeight = 100;
		GoupButtons.button[0].distance_centerX = 30;
		GoupButtons.button[0].blinkStatus = true;
		GoupButtons.button[0].sText = "PS";
		GoupButtons.button[0].drawGraph(canvas);
		
		GoupButtons.button[1].cx = 312;
		GoupButtons.button[1].cy = 1550;
		GoupButtons.button[1].rectWidth = 208;
		GoupButtons.button[1].rectHeight = 100;
		GoupButtons.button[1].blinkStatus = true;
		GoupButtons.button[1].sText = "";
		GoupButtons.button[1].drawGraph(canvas);
		
		GoupButtons.button[2].cx = 520;
		GoupButtons.button[2].cy = 1550;
		GoupButtons.button[2].rectWidth = 208;
		GoupButtons.button[2].rectHeight = 100;
		GoupButtons.button[2].blinkStatus = true;
		GoupButtons.button[2].sText = "";
		GoupButtons.button[2].drawGraph(canvas);
		
		GoupButtons.button[3].cx = 728;
		GoupButtons.button[3].cy = 1550;
		GoupButtons.button[3].rectWidth = 208;
		GoupButtons.button[3].rectHeight = 100;
		GoupButtons.button[3].blinkStatus = true;
		GoupButtons.button[3].sText = "";
		GoupButtons.button[3].drawGraph(canvas);
		
		GoupButtons.button[4].cx = 968;
		GoupButtons.button[4].cy = 1550;
		GoupButtons.button[4].rectWidth = 208;
		GoupButtons.button[4].rectHeight = 100;
		GoupButtons.button[4].distance_centerX = 50;
		GoupButtons.button[4].blinkStatus = true;
		GoupButtons.button[4].sText = "Double";
		GoupButtons.button[4].drawGraph(canvas);
		
		GoupButtons.button[5].cx = 1176;
		GoupButtons.button[5].cy = 1550;
		GoupButtons.button[5].rectWidth = 208;
		GoupButtons.button[5].rectHeight = 100;
		GoupButtons.button[5].blinkStatus = true;
		GoupButtons.button[5].sText = "";
		GoupButtons.button[5].drawGraph(canvas);
		
		GoupButtons.button[6].cx = 1384;
		GoupButtons.button[6].cy = 1550;
		GoupButtons.button[6].rectWidth = 208;
		GoupButtons.button[6].rectHeight = 100;
		GoupButtons.button[6].blinkStatus = true;
		GoupButtons.button[6].sText = "";
		GoupButtons.button[6].drawGraph(canvas);
		
		GoupButtons.button[7].cx = 1592;
		GoupButtons.button[7].cy = 1550;
		GoupButtons.button[7].rectWidth = 208;
		GoupButtons.button[7].rectHeight = 100;
		GoupButtons.button[7].blinkStatus = true;
		GoupButtons.button[7].sText = "";
		GoupButtons.button[7].drawGraph(canvas);

		
		GoupButtons.button[8].cx = 1832;
		GoupButtons.button[8].cy = 1550;
		GoupButtons.button[8].rectWidth = 208;
		GoupButtons.button[8].rectHeight = 100;
		GoupButtons.button[8].distance_centerX = 30;
		GoupButtons.button[8].blinkStatus = true;
		GoupButtons.button[8].sText = "SB";
		GoupButtons.button[8].drawGraph(canvas);
		
		GoupButtons.button[9].cx = 2040;
		GoupButtons.button[9].cy = 1550;
		GoupButtons.button[9].rectWidth = 208;
		GoupButtons.button[9].rectHeight = 100;
		GoupButtons.button[9].blinkStatus = true;
		GoupButtons.button[9].sText = "";
		GoupButtons.button[9].drawGraph(canvas);
		
		GoupButtons.button[10].cx = 2248;
		GoupButtons.button[10].cy = 1550;
		GoupButtons.button[10].rectWidth = 208;
		GoupButtons.button[10].rectHeight = 100;
		GoupButtons.button[10].blinkStatus = true;
		GoupButtons.button[10].sText = "";
		GoupButtons.button[10].drawGraph(canvas);
		
		GoupButtons.button[11].cx = 2456;
		GoupButtons.button[11].cy = 1550;
		GoupButtons.button[11].rectWidth = 208;
		GoupButtons.button[11].rectHeight = 100;
		GoupButtons.button[11].blinkStatus = true;
		GoupButtons.button[11].sText = "";
		GoupButtons.button[11].drawGraph(canvas);
		

		GoupShowButtons.Showbutton[0].cx = 208;
		GoupShowButtons.Showbutton[0].cy = 1450;
		GoupShowButtons.Showbutton[0].rectWidth = 416;
		GoupShowButtons.Showbutton[0].rectHeight = 100;
		GoupShowButtons.Showbutton[0].distance_centerX = 60;
		GoupShowButtons.Showbutton[0].sText = "PS Dredge";
		GoupShowButtons.Showbutton[0].drawGraph(canvas);
		
		GoupShowButtons.Showbutton[1].cx = 624;
		GoupShowButtons.Showbutton[1].cy = 1450;
		GoupShowButtons.Showbutton[1].rectWidth = 416;
		GoupShowButtons.Showbutton[1].rectHeight = 100;
		GoupShowButtons.Showbutton[1].sText = "";
		GoupShowButtons.Showbutton[1].drawGraph(canvas);
		
		GoupShowButtons.Showbutton[2].cx = 1072;
		GoupShowButtons.Showbutton[2].cy = 1450;
		GoupShowButtons.Showbutton[2].rectWidth = 416;
		GoupShowButtons.Showbutton[2].rectHeight = 100;
		GoupShowButtons.Showbutton[2].distance_centerX = 100;
		GoupShowButtons.Showbutton[2].sText = "Double Dredge";
		GoupShowButtons.Showbutton[2].drawGraph(canvas);
		
		GoupShowButtons.Showbutton[3].cx = 1488;
		GoupShowButtons.Showbutton[3].cy = 1450;
		GoupShowButtons.Showbutton[3].rectWidth = 416;
		GoupShowButtons.Showbutton[3].rectHeight = 100;
		GoupShowButtons.Showbutton[3].sText = "";
		GoupShowButtons.Showbutton[3].drawGraph(canvas);
		
		GoupShowButtons.Showbutton[4].cx = 1936;
		GoupShowButtons.Showbutton[4].cy = 1450;
		GoupShowButtons.Showbutton[4].rectWidth = 416;
		GoupShowButtons.Showbutton[4].rectHeight = 100;
		GoupShowButtons.Showbutton[4].sText = "SB Dredge";
		GoupShowButtons.Showbutton[4].drawGraph(canvas);
		
		GoupShowButtons.Showbutton[5].cx = 2352;
		GoupShowButtons.Showbutton[5].cy = 1450;
		GoupShowButtons.Showbutton[5].rectWidth = 416;
		GoupShowButtons.Showbutton[5].rectHeight = 100;
		GoupShowButtons.Showbutton[5].sText = "";
		GoupShowButtons.Showbutton[5].drawGraph(canvas);
		
		NewGroupValves.graph1[31].cx = 900;
		NewGroupValves.graph1[31].cy = 162;
		NewGroupValves.graph1[31].rectWidth = 84;
		NewGroupValves.graph1[31].rectHeight = 50;
		NewGroupValves.graph1[31].rotateAngle = 90;
		NewGroupValves.graph1[31].szText = "HGV.12";
		NewGroupValves.graph1[31].drawGraph(canvas);
			
		NewGroupValves.graph1[32].cx = 900;
		NewGroupValves.graph1[32].cy = 962;
		NewGroupValves.graph1[32].rectWidth = 84;
		NewGroupValves.graph1[32].rectHeight = 50;
		NewGroupValves.graph1[32].rotateAngle = 90;
		NewGroupValves.graph1[32].szText = "HGV.13";
		NewGroupValves.graph1[32].drawGraph(canvas);

		NewGroupValves.graph1[36].cx = 1420;
		NewGroupValves.graph1[36].cy = 442;
		NewGroupValves.graph1[36].rectWidth = 84;
		NewGroupValves.graph1[36].rectHeight = 50;
		NewGroupValves.graph1[36].rotateAngle = 0;
		NewGroupValves.graph1[36].szText = "HGV.14";
		NewGroupValves.graph1[36].drawGraph(canvas);
		
		NewGroupValves.graph1[37].cx = 1420;
		NewGroupValves.graph1[37].cy = 682;
		NewGroupValves.graph1[37].rectWidth = 84;
		NewGroupValves.graph1[37].rectHeight = 50;
		NewGroupValves.graph1[37].rotateAngle = 0;
		NewGroupValves.graph1[37].szText = "HGV.15";
		NewGroupValves.graph1[37].drawGraph(canvas);
		
		NewGroupValves.graph1[38].cx = 2020;
		NewGroupValves.graph1[38].cy = 442;
		NewGroupValves.graph1[38].rectWidth = 84;
		NewGroupValves.graph1[38].rectHeight = 50;
		NewGroupValves.graph1[38].rotateAngle = 0;
		NewGroupValves.graph1[38].szText = "HGV.16";
		NewGroupValves.graph1[38].drawGraph(canvas);
		
		NewGroupValves.graph1[39].cx = 2020;
		NewGroupValves.graph1[39].cy = 642;
		NewGroupValves.graph1[39].rectWidth = 84;
		NewGroupValves.graph1[39].rectHeight = 50;
		NewGroupValves.graph1[39].rotateAngle = 0;
		NewGroupValves.graph1[39].szText = "HGV.17";
		NewGroupValves.graph1[39].drawGraph(canvas);

		NewGroupValves.graph1[42].cx = 860;
		NewGroupValves.graph1[42].cy = 442;
		NewGroupValves.graph1[42].rectWidth = 84;
		NewGroupValves.graph1[42].rectHeight = 50;
		NewGroupValves.graph1[42].rotateAngle = 0;
		NewGroupValves.graph1[42].szText = "HGV.10";
		NewGroupValves.graph1[42].drawGraph(canvas);

		NewGroupValves.graph1[43].cx = 860;
		NewGroupValves.graph1[43].cy = 682;
		NewGroupValves.graph1[43].rectWidth = 84;
		NewGroupValves.graph1[43].rectHeight = 50;
		NewGroupValves.graph1[43].rotateAngle = 0;
		NewGroupValves.graph1[43].szText = "HGV.11";
		NewGroupValves.graph1[43].drawGraph(canvas);
		Paint paint = new Paint(); // 新建画笔
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStrokeWidth(4); // 设置画笔的宽度
		paint.setColor(Color.GRAY);

		canvas.drawLine(818, 442, 660, 562, paint);
		canvas.drawLine(818, 682, 660, 562, paint);
		canvas.drawLine(100, 562, 660, 562, paint);

		canvas.drawLine(460, 562, 400, 502, paint);
		canvas.drawLine(460, 562, 400, 622, paint);

		NewGroupValves.graph1[44].cx = 370;
		NewGroupValves.graph1[44].cy = 472;
		NewGroupValves.graph1[44].rectWidth = 84;
		NewGroupValves.graph1[44].rectHeight = 50;
		NewGroupValves.graph1[44].rotateAngle = -45;
		NewGroupValves.graph1[44].szText = "HGV.08";
		NewGroupValves.graph1[44].drawGraph(canvas);
		

		NewGroupValves.graph1[45].cx = 370;
		NewGroupValves.graph1[45].cy = 652;
		NewGroupValves.graph1[45].rectWidth = 84;
		NewGroupValves.graph1[45].rectHeight = 50;
		NewGroupValves.graph1[45].rotateAngle = 45;
		NewGroupValves.graph1[45].szText = "HGV.09";
		NewGroupValves.graph1[45].drawGraph(canvas);

		canvas.drawLine(310, 562, 250, 502, paint);
		canvas.drawLine(310, 562, 250, 622, paint);

		NewGroupValves.graph1[46].cx = 220;
		NewGroupValves.graph1[46].cy = 472;
		NewGroupValves.graph1[46].rectWidth = 84;
		NewGroupValves.graph1[46].rectHeight = 50;
		NewGroupValves.graph1[46].rotateAngle = -45;
		NewGroupValves.graph1[46].szText = "HGV.06";
		NewGroupValves.graph1[46].drawGraph(canvas);
		
		NewGroupValves.graph1[47].cx = 220;
		NewGroupValves.graph1[47].cy = 652;
		NewGroupValves.graph1[47].rectWidth = 84;
		NewGroupValves.graph1[47].rectHeight = 50;
		NewGroupValves.graph1[47].rotateAngle = 45;
		NewGroupValves.graph1[47].szText = "HGV.07";
		NewGroupValves.graph1[47].drawGraph(canvas);
		
		
		GroupDredgePump.dredgepump[0].cx = 1100;
		GroupDredgePump.dredgepump[0].cy = 350;
		GroupDredgePump.dredgepump[0].rectWidth = 80;
		GroupDredgePump.dredgepump[0].rectHeight = 160;
		GroupDredgePump.dredgepump[0].rotateAngle = 180;
		GroupDredgePump.dredgepump[0].bShowLeft = false;
		GroupDredgePump.dredgepump[0].sText = "左泥泵";
		GroupDredgePump.dredgepump[0].drawGraph(canvas);
		
		GroupDredgePump.dredgepump[1].cx = 1100;
		GroupDredgePump.dredgepump[1].cy = 780;
		GroupDredgePump.dredgepump[1].rectWidth = 80;
		GroupDredgePump.dredgepump[1].rectHeight = 160;
		GroupDredgePump.dredgepump[1].rotateAngle = 0;
		GroupDredgePump.dredgepump[1].bShowLeft = true;
		GroupDredgePump.dredgepump[1].sText = "右泥泵";
		GroupDredgePump.dredgepump[1].drawGraph(canvas);
		
		//画和左泵连的线条
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStrokeWidth(4); // 设置画笔的宽度		
		paint.setColor(Color.GRAY);
		canvas.drawLine(1060, 442, 900, 442, paint);// 和12连的线
		canvas.drawLine(1140 , 442, 1380, 442, paint);// 和6连的线
		canvas.drawLine(1040, 322, 900, 322, paint);// 出口和1连的线
		canvas.drawLine(900, 204, 900, 322, paint);// 出口和1连的线

		// 画和右泵连的线条
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStrokeWidth(4); // 设置画笔的宽度

		paint.setColor(Color.GRAY);
		canvas.drawLine(1060, 682, 900, 682, paint);// 和13连的线
		canvas.drawLine(1140, 682, 1380, 682, paint);// 和7连的线

		canvas.drawLine(1040, 802, 900, 802, paint);//进口和2连的线
		canvas.drawLine(900, 920, 900, 802, paint);// 进口和2连的线
		
		// 画1和耙连接线
		canvas.drawLine(900, 120, 900, 100, paint);
		canvas.drawLine(900, 100, 200, 100, paint);
		// 画2和耙连接线
		canvas.drawLine(900, 1004, 900, 1024, paint);
		canvas.drawLine(900, 1024, 200, 1024, paint);
		// 画艏吹和艏喷连接线
		canvas.drawLine(1460, 442, 1980, 442, paint);//6和8连		
		canvas.drawLine(1460, 682, 1600, 442, paint);			
		canvas.drawLine(1800, 642, 1800, 442, paint);
		canvas.drawLine(1800, 642, 1980, 642, paint);
		canvas.drawLine(2065, 442, 2200, 442, paint); //艏吹出口	
		canvas.drawLine(2065, 642, 2200, 642, paint); //艏喷出口
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStrokeWidth(1); // 设置画笔的宽度
		paint.setColor(Color.LTGRAY);
		paint.setTextSize(30);	
		canvas.drawText("PS Dredge Pump", 1150, 320, paint);
		canvas.drawText("SB Dredge Pump", 1150, 820, paint);		
		canvas.drawText("HGV.12", 780, 160, paint);	
		canvas.drawText("HGV.13", 780, 950, paint);
		canvas.drawText("HGV.14", 1370, 390,	 paint);
		canvas.drawText("HGV.15", 1370, 630, paint);
		canvas.drawText("HGB.16", 1970, 390, paint);
		canvas.drawText("HGB.17", 1970, 700, paint);
		canvas.drawText("HGV.10", 810, 390, paint);
		canvas.drawText("HGV.11", 810, 740, paint);
		canvas.drawText("HGV.08", 390, 420, paint);
		canvas.drawText("HGV.09", 390, 690, paint);
		canvas.drawText("HGV.06", 160, 370, paint);
		canvas.drawText("HGV.07", 160, 740, paint);
		
		paint.setColor(Color.YELLOW);
		paint.setTextSize(50);   
		canvas.drawText("LOADING", 40, 60, paint);

	}

}
