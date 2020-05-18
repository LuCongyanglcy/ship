package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Page008 {

	public static void DrawPage(Canvas canvas) {
		RectF rectf = new RectF();
         //液压泵
		GroupHDPump.hdpump[0].cx = 1100;   //5#液压泵
		GroupHDPump.hdpump[0].cy = 500;
		GroupHDPump.hdpump[0].rectWidth = 40;
		GroupHDPump.hdpump[0].rectHeight = 40;
		GroupHDPump.hdpump[0].rotateAngle = -90;
		GroupHDPump.hdpump[0].bArc = false;
		GroupHDPump.hdpump[0].blink_sign = false;
		GroupHDPump.hdpump[0].szText = "A";
		GroupHDPump.hdpump[0].drawGraph(canvas);
		
		GroupHDPump.hdpump[1].cx = 1100;//6#液压泵
		GroupHDPump.hdpump[1].cy = 560;
		GroupHDPump.hdpump[1].rectWidth = 40;
		GroupHDPump.hdpump[1].rectHeight = 40;
		GroupHDPump.hdpump[1].rotateAngle = -90;
		GroupHDPump.hdpump[1].bArc = false;
		GroupHDPump.hdpump[1].blink_sign = false;
		GroupHDPump.hdpump[1].szText = "B";
		GroupHDPump.hdpump[1].drawGraph(canvas);
		
		GroupHDPump.hdpump[2].cx = 1100;//7#液压泵
		GroupHDPump.hdpump[2].cy = 620;
		GroupHDPump.hdpump[2].rectWidth = 40;
		GroupHDPump.hdpump[2].rectHeight = 40;
		GroupHDPump.hdpump[2].rotateAngle = -90;
		GroupHDPump.hdpump[2].bArc = false;
		GroupHDPump.hdpump[2].blink_sign = false;
		GroupHDPump.hdpump[2].szText = "C";
		GroupHDPump.hdpump[2].drawGraph(canvas);
		
		GroupHDPump.hdpump[3].cx = 200;//1#液压泵
		GroupHDPump.hdpump[3].cy = 500;
		GroupHDPump.hdpump[3].rectWidth = 40;
		GroupHDPump.hdpump[3].rectHeight = 40;
		GroupHDPump.hdpump[3].rotateAngle = 90;
		GroupHDPump.hdpump[3].bArc = false;
		GroupHDPump.hdpump[3].blink_sign = false;
		GroupHDPump.hdpump[3].szText = "D";
		GroupHDPump.hdpump[3].drawGraph(canvas);
		
		GroupHDPump.hdpump[4].cx = 200;//2#液压泵
		GroupHDPump.hdpump[4].cy = 560;
		GroupHDPump.hdpump[4].rectWidth = 40;
		GroupHDPump.hdpump[4].rectHeight = 40;
		GroupHDPump.hdpump[4].rotateAngle = 90;
		GroupHDPump.hdpump[4].bArc = false;
		GroupHDPump.hdpump[4].blink_sign = false;
		GroupHDPump.hdpump[4].szText = "E";
		GroupHDPump.hdpump[4].drawGraph(canvas);
		
		GroupHDPump.hdpump[5].cx = 200;//3#液压泵
		GroupHDPump.hdpump[5].cy = 620;
		GroupHDPump.hdpump[5].rectWidth = 40;
		GroupHDPump.hdpump[5].rectHeight = 40;
		GroupHDPump.hdpump[5].rotateAngle = 90;
		GroupHDPump.hdpump[5].bArc = false;
		GroupHDPump.hdpump[5].blink_sign = false;
		GroupHDPump.hdpump[5].szText = "F";
		GroupHDPump.hdpump[5].drawGraph(canvas);
		
		GroupHDPump.hdpump[6].cx = 250;//应急液压泵
		GroupHDPump.hdpump[6].cy = 420;
		GroupHDPump.hdpump[6].rectWidth = 40;
		GroupHDPump.hdpump[6].rectHeight = 40;
		GroupHDPump.hdpump[6].rotateAngle = 90;
		GroupHDPump.hdpump[6].bArc = false;
		GroupHDPump.hdpump[6].blink_sign = false;
		GroupHDPump.hdpump[6].szText = "G";
		GroupHDPump.hdpump[6].drawGraph(canvas);
		
		GroupHDPump.hdpump[7].cx = 250;//液压保压泵
		GroupHDPump.hdpump[7].cy = 360;
		GroupHDPump.hdpump[7].rectWidth = 40;
		GroupHDPump.hdpump[7].rectHeight = 40;
		GroupHDPump.hdpump[7].rotateAngle = 90;
		GroupHDPump.hdpump[7].bArc = false;
		GroupHDPump.hdpump[7].blink_sign = false;
		GroupHDPump.hdpump[7].szText = "H";
		GroupHDPump.hdpump[7].drawGraph(canvas);
		
		GroupHDPump.hdpump[8].cx = 1100;//10#液压泵
		GroupHDPump.hdpump[8].cy = 200;
		GroupHDPump.hdpump[8].rectWidth = 40;
		GroupHDPump.hdpump[8].rectHeight = 40;
		GroupHDPump.hdpump[8].rotateAngle = 0;
		GroupHDPump.hdpump[8].bArc = false;
		GroupHDPump.hdpump[8].blink_sign = false;
		GroupHDPump.hdpump[8].szText = "I";
		GroupHDPump.hdpump[8].drawGraph(canvas);
		
		GroupHDPump.hdpump[9].cx = 580;//1#主动耙头液压泵
		GroupHDPump.hdpump[9].cy = 620;
		GroupHDPump.hdpump[9].rectWidth = 40;
		GroupHDPump.hdpump[9].rectHeight = 40;
		GroupHDPump.hdpump[9].rotateAngle = 180;
		GroupHDPump.hdpump[9].bArc = false;
		GroupHDPump.hdpump[9].blink_sign = false;
		GroupHDPump.hdpump[9].szText = "J";
		GroupHDPump.hdpump[9].drawGraph(canvas);
		
		GroupHDPump.hdpump[10].cx = 700;//2#主动耙头液压泵
		GroupHDPump.hdpump[10].cy = 620;
		GroupHDPump.hdpump[10].rectWidth = 40;
		GroupHDPump.hdpump[10].rectHeight = 40;
		GroupHDPump.hdpump[10].rotateAngle = 180;
		GroupHDPump.hdpump[10].bArc = false;
		GroupHDPump.hdpump[10].blink_sign = false;
		GroupHDPump.hdpump[10].szText = "K";
		GroupHDPump.hdpump[10].drawGraph(canvas);
 
		//报警方灯
		Group_BJD.bjd[0].cx = 540;
		Group_BJD.bjd[0].cy = 80;
		Group_BJD.bjd[0].rectWidth = 20;
		Group_BJD.bjd[0].rectHeight = 20;
		Group_BJD.bjd[0].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[0].bBlink = false;
		Group_BJD.bjd[0].bRectLight = true;
		Group_BJD.bjd[0].drawGraph(canvas);
		
		Group_BJD.bjd[1].cx = 640;
		Group_BJD.bjd[1].cy = 80;
		Group_BJD.bjd[1].rectWidth = 20;
		Group_BJD.bjd[1].rectHeight = 20;
		Group_BJD.bjd[1].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[1].bBlink = false;
		Group_BJD.bjd[1].bRectLight = true;
		Group_BJD.bjd[1].drawGraph(canvas);
		
		Group_BJD.bjd[2].cx = 740;
		Group_BJD.bjd[2].cy = 80;
		Group_BJD.bjd[2].rectWidth = 20;
		Group_BJD.bjd[2].rectHeight = 20;
		Group_BJD.bjd[2].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[2].bBlink = false;
		Group_BJD.bjd[2].bRectLight = true;
		Group_BJD.bjd[2].drawGraph(canvas);
		
		Group_BJD.bjd[3].cx = 200;
		Group_BJD.bjd[3].cy = 175;
		Group_BJD.bjd[3].rectWidth = 20;
		Group_BJD.bjd[3].rectHeight = 20;
		Group_BJD.bjd[3].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[3].bBlink = false;
		Group_BJD.bjd[3].bRectLight = true;
		Group_BJD.bjd[3].drawGraph(canvas);
		
		Group_BJD.bjd[4].cx = 200;
		Group_BJD.bjd[4].cy = 205;
		Group_BJD.bjd[4].rectWidth = 20;
		Group_BJD.bjd[4].rectHeight = 20;
		Group_BJD.bjd[4].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[4].bBlink = false;
		Group_BJD.bjd[4].bRectLight = true;
		Group_BJD.bjd[4].drawGraph(canvas);
		
		Group_BJD.bjd[5].cx = 200;
		Group_BJD.bjd[5].cy = 235;
		Group_BJD.bjd[5].rectWidth = 20;
		Group_BJD.bjd[5].rectHeight = 20;
		Group_BJD.bjd[5].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[5].bBlink = false;
		Group_BJD.bjd[5].bRectLight = true;
		Group_BJD.bjd[5].drawGraph(canvas);
		
		Group_BJD.bjd[6].cx = 780;
		Group_BJD.bjd[6].cy = 395;
		Group_BJD.bjd[6].rectWidth = 20;
		Group_BJD.bjd[6].rectHeight = 20;
		Group_BJD.bjd[6].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[6].bBlink = false;
		Group_BJD.bjd[6].bRectLight = true;
		Group_BJD.bjd[6].drawGraph(canvas);
		
		Group_BJD.bjd[7].cx = 780;
		Group_BJD.bjd[7].cy = 425;
		Group_BJD.bjd[7].rectWidth = 20;
		Group_BJD.bjd[7].rectHeight = 20;
		Group_BJD.bjd[7].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[7].bBlink = false;
		Group_BJD.bjd[7].bRectLight = true;
		Group_BJD.bjd[7].drawGraph(canvas);
		
		Group_BJD.bjd[8].cx = 780;
		Group_BJD.bjd[8].cy = 455;
		Group_BJD.bjd[8].rectWidth = 20;
		Group_BJD.bjd[8].rectHeight = 20;
		Group_BJD.bjd[8].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[8].bBlink = false;
		Group_BJD.bjd[8].bRectLight = true;
		Group_BJD.bjd[8].drawGraph(canvas);
		
		Group_BJD.bjd[9].cx = 780;
		Group_BJD.bjd[9].cy = 485;
		Group_BJD.bjd[9].rectWidth = 20;
		Group_BJD.bjd[9].rectHeight = 20;
		Group_BJD.bjd[9].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[9].bBlink = false;
		Group_BJD.bjd[9].bRectLight = true;
		Group_BJD.bjd[9].drawGraph(canvas);

		//按钮
		GoupButtons.button[0].cx = 52;
		GoupButtons.button[0].cy = 775;
		GoupButtons.button[0].rectWidth = 104;
		GoupButtons.button[0].rectHeight = 50;
		GoupButtons.button[0].distance_centerX = 20;
		GoupButtons.button[0].sText = "Start";
		GoupButtons.button[0].drawGraph(canvas);
		
		GoupButtons.button[1].cx = 156;
		GoupButtons.button[1].cy = 775;
		GoupButtons.button[1].rectWidth = 104;
		GoupButtons.button[1].rectHeight = 50;
		GoupButtons.button[1].distance_centerX = 20;
		GoupButtons.button[1].sText = "Stop";
		GoupButtons.button[1].drawGraph(canvas);
		
		GoupButtons.button[2].cx = 260;
		GoupButtons.button[2].cy = 775;
		GoupButtons.button[2].rectWidth = 104;
		GoupButtons.button[2].rectHeight = 50;
		GoupButtons.button[2].distance_centerX = 20;
		GoupButtons.button[2].sText = "Cancel";
		GoupButtons.button[2].drawGraph(canvas);
		
		GoupButtons.button[3].cx = 374;
		GoupButtons.button[3].cy = 775;
		GoupButtons.button[3].rectWidth = 104;
		GoupButtons.button[3].rectHeight = 50;
		GoupButtons.button[3].distance_centerX = 20;
		GoupButtons.button[3].sText = "Start";
		GoupButtons.button[3].drawGraph(canvas);
		
		GoupButtons.button[4].cx = 478;
		GoupButtons.button[4].cy = 775;
		GoupButtons.button[4].rectWidth = 104;
		GoupButtons.button[4].rectHeight = 50;
		GoupButtons.button[4].distance_centerX = 20;
		GoupButtons.button[4].blinkStatus = true;
		GoupButtons.button[4].sText = "Stop";
		GoupButtons.button[4].drawGraph(canvas);
		
		GoupButtons.button[5].cx = 582;
		GoupButtons.button[5].cy = 775;
		GoupButtons.button[5].rectWidth = 104;
		GoupButtons.button[5].rectHeight = 50;
		GoupButtons.button[5].distance_centerX = 20;
		GoupButtons.button[5].sText = "Cancel";
		GoupButtons.button[5].drawGraph(canvas);
		
		GoupButtons.button[6].cx = 696;
		GoupButtons.button[6].cy = 775;
		GoupButtons.button[6].rectWidth = 104;
		GoupButtons.button[6].rectHeight = 50;
		GoupButtons.button[6].distance_centerX = 20;
		GoupButtons.button[6].sText = "Start";
		GoupButtons.button[6].drawGraph(canvas);
		
		GoupButtons.button[7].cx = 800;
		GoupButtons.button[7].cy = 775;
		GoupButtons.button[7].rectWidth = 104;
		GoupButtons.button[7].rectHeight = 50;
		GoupButtons.button[7].distance_centerX = 20;
		GoupButtons.button[7].sText = "Stop";
		GoupButtons.button[7].drawGraph(canvas);

		
		GoupButtons.button[8].cx = 904;
		GoupButtons.button[8].cy = 775;
		GoupButtons.button[8].rectWidth = 104;
		GoupButtons.button[8].rectHeight = 50;
		GoupButtons.button[8].distance_centerX = 20;
		GoupButtons.button[8].sText = "Cancel";
		GoupButtons.button[8].drawGraph(canvas);
		
		GoupButtons.button[9].cx = 1020;
		GoupButtons.button[9].cy = 775;
		GoupButtons.button[9].rectWidth = 104;
		GoupButtons.button[9].rectHeight = 50;
		GoupButtons.button[9].distance_centerX = 30;
		GoupButtons.button[9].sText = "Start";
		GoupButtons.button[9].drawGraph(canvas);
		
		GoupButtons.button[10].cx = 1124;
		GoupButtons.button[10].cy = 775;
		GoupButtons.button[10].rectWidth = 104;
		GoupButtons.button[10].rectHeight = 50;
		GoupButtons.button[10].distance_centerX = 30;
		GoupButtons.button[10].sText = "Stop";
		GoupButtons.button[10].drawGraph(canvas);
		
		GoupButtons.button[11].cx = 1228;
		GoupButtons.button[11].cy = 775;
		GoupButtons.button[11].rectWidth = 104;
		GoupButtons.button[11].rectHeight = 50;
		GoupButtons.button[11].distance_centerX = 30;
		GoupButtons.button[11].sText = "Cancel";
		GoupButtons.button[11].drawGraph(canvas);
		
		GoupShowButtons.Showbutton[0].cx = 156;
		GoupShowButtons.Showbutton[0].cy = 725;
		GoupShowButtons.Showbutton[0].rectWidth = 312;
		GoupShowButtons.Showbutton[0].rectHeight = 50;
		GoupShowButtons.Showbutton[0].distance_centerX = 60;
		GoupShowButtons.Showbutton[0].sText = "PS Hydraulic System";
		GoupShowButtons.Showbutton[0].drawGraph(canvas);
		
		GoupShowButtons.Showbutton[1].cx = 478;
		GoupShowButtons.Showbutton[1].cy = 725;
		GoupShowButtons.Showbutton[1].rectWidth = 312;
		GoupShowButtons.Showbutton[1].rectHeight = 50;
		GoupShowButtons.Showbutton[1].distance_centerX = 50;
		GoupShowButtons.Showbutton[1].sText = "Hydraulic System";
		GoupShowButtons.Showbutton[1].drawGraph(canvas);
		
		GoupShowButtons.Showbutton[2].cx = 800;
		GoupShowButtons.Showbutton[2].cy = 725;
		GoupShowButtons.Showbutton[2].rectWidth = 312;
		GoupShowButtons.Showbutton[2].rectHeight = 50;
		GoupShowButtons.Showbutton[2].distance_centerX = 60;
		GoupShowButtons.Showbutton[2].sText = "SB Hydraulic System";
		GoupShowButtons.Showbutton[2].drawGraph(canvas);
		
		GoupShowButtons.Showbutton[3].cx = 1124;
		GoupShowButtons.Showbutton[3].cy = 725;
		GoupShowButtons.Showbutton[3].rectWidth = 312;
		GoupShowButtons.Showbutton[3].rectHeight = 50;
		GoupShowButtons.Showbutton[3].distance_centerX = 60;
		GoupShowButtons.Showbutton[3].sText = "Active Draghead System";
		GoupShowButtons.Showbutton[3].drawGraph(canvas);
		
		// 阀
		NewGroupValves.graph1[50].cx = 500;
		NewGroupValves.graph1[50].cy = 290 ;
		NewGroupValves.graph1[50].rectWidth = 30 ;
		NewGroupValves.graph1[50].rectHeight = 20 ;
		NewGroupValves.graph1[50].rotateAngle = 90;
		NewGroupValves.graph1[50].szText = "SK8";
		NewGroupValves.graph1[50].bmanual = false;
		NewGroupValves.graph1[50].drawGraph(canvas);
		
		NewGroupValves.graph1[51].cx = 540;
		NewGroupValves.graph1[51].cy = 290 ;
		NewGroupValves.graph1[51].rectWidth = 30 ;
		NewGroupValves.graph1[51].rectHeight = 20 ;
		NewGroupValves.graph1[51].rotateAngle = 90;
		NewGroupValves.graph1[51].szText = "SK4";
		NewGroupValves.graph1[51].bmanual = false;
		NewGroupValves.graph1[51].drawGraph(canvas);
		
		NewGroupValves.graph1[52].cx = 580;
		NewGroupValves.graph1[52].cy = 290 ;
		NewGroupValves.graph1[52].rectWidth = 30 ;
		NewGroupValves.graph1[52].rectHeight = 20 ;
		NewGroupValves.graph1[52].rotateAngle = 90;
		NewGroupValves.graph1[52].szText = "SK1";
		NewGroupValves.graph1[52].bmanual = false;
		NewGroupValves.graph1[52].drawGraph(canvas);
		
		NewGroupValves.graph1[53].cx = 720;
		NewGroupValves.graph1[53].cy = 290 ;
		NewGroupValves.graph1[53].rectWidth = 30 ;
		NewGroupValves.graph1[53].rectHeight = 20 ;
		NewGroupValves.graph1[53].rotateAngle = 90;
		NewGroupValves.graph1[53].szText = "SK7";
		NewGroupValves.graph1[53].bmanual = false;
		NewGroupValves.graph1[53].drawGraph(canvas);
		
		NewGroupValves.graph1[54].cx = 760;
		NewGroupValves.graph1[54].cy = 290 ;
		NewGroupValves.graph1[54].rectWidth = 30 ;
		NewGroupValves.graph1[54].rectHeight = 20 ;
		NewGroupValves.graph1[54].rotateAngle = 90;
		NewGroupValves.graph1[54].szText = "SK2";
		NewGroupValves.graph1[54].bmanual = false;
		NewGroupValves.graph1[54].drawGraph(canvas);		
		
		//		
		GroupLine.line[0].startX = 500;    //SK8到H
		GroupLine.line[0].startY = 305;
		GroupLine.line[0].endX = 500;
		GroupLine.line[0].endY = 340;
		GroupLine.line[0].lineWidth = 3;
		GroupLine.line[0].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[0].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[0].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[0].drawGraph(canvas);
		
		GroupLine.line[0].startX = 500;    //SK8到H
		GroupLine.line[0].startY = 340;
		GroupLine.line[0].endX = 480;
		GroupLine.line[0].endY = 360;
		GroupLine.line[0].lineWidth = 3;
		GroupLine.line[0].bArc = true;
		GroupLine.line[0].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[0].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[0].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[0].drawGraph(canvas);
		
		GroupLine.line[0].startX = 480;    //SK8到H
		GroupLine.line[0].startY = 360;
		GroupLine.line[0].endX = 270;
		GroupLine.line[0].endY = 360;
		GroupLine.line[0].lineWidth = 3;
		GroupLine.line[0].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[0].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[0].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[0].drawGraph(canvas);
		
		GroupLine.line[1].startX = 540;    //SK4到G
		GroupLine.line[1].startY = 305;
		GroupLine.line[1].endX = 540;
		GroupLine.line[1].endY = 400;
		GroupLine.line[1].lineWidth = 3;
		GroupLine.line[1].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[1].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[1].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[1].drawGraph(canvas);
		
		GroupLine.line[1].startX = 540;    //SK4到G
		GroupLine.line[1].startY = 400;
		GroupLine.line[1].endX = 520;
		GroupLine.line[1].endY = 420;
		GroupLine.line[1].lineWidth = 3;
		GroupLine.line[1].bArc = true;
		GroupLine.line[1].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[1].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[1].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[1].drawGraph(canvas);
		
		GroupLine.line[1].startX = 520;    //SK4到G
		GroupLine.line[1].startY = 420;
		GroupLine.line[1].endX = 270;
		GroupLine.line[1].endY = 420;
		GroupLine.line[1].lineWidth = 3;
		GroupLine.line[1].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[1].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[1].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[1].drawGraph(canvas);
		
		GroupLine.line[2].startX = 580;    //SK1到D节点
		GroupLine.line[2].startY = 305;
		GroupLine.line[2].endX = 580;
		GroupLine.line[2].endY = 420;
		GroupLine.line[2].lineWidth = 3;
		GroupLine.line[2].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[2].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[2].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[2].drawGraph(canvas);
		
		GroupLine.line[2].startX = 580;    //SK1到D节点
		GroupLine.line[2].startY = 420;
		GroupLine.line[2].endX = 560;
		GroupLine.line[2].endY = 440;
		GroupLine.line[2].lineWidth = 3;
		GroupLine.line[2].bArc = true;
		GroupLine.line[2].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[2].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[2].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[2].drawGraph(canvas);
		
		GroupLine.line[2].startX = 560;    //SK1到D节点
		GroupLine.line[2].startY = 440;
		GroupLine.line[2].endX = 400;
		GroupLine.line[2].endY = 440;
		GroupLine.line[2].lineWidth = 3;
		GroupLine.line[2].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[2].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[2].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[2].drawGraph(canvas);
		
		GroupLine.line[2].startX = 380;    //SK1到D节点
		GroupLine.line[2].startY = 460;
		GroupLine.line[2].endX = 400;
		GroupLine.line[2].endY = 440;
		GroupLine.line[2].lineWidth = 3;
		GroupLine.line[2].bArc = true;
		GroupLine.line[2].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[2].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[2].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[2].drawGraph(canvas);
		
		GroupLine.line[2].startX = 380;    //SK1到D节点
		GroupLine.line[2].startY = 460;
		GroupLine.line[2].endX = 380;
		GroupLine.line[2].endY = 500;
		GroupLine.line[2].lineWidth = 3;
		GroupLine.line[2].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[2].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[2].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[2].drawGraph(canvas);
		
		GroupLine.line[3].startX = 380;    //D节点连接D
		GroupLine.line[3].startY = 500;
		GroupLine.line[3].endX = 220;
		GroupLine.line[3].endY = 500;
		GroupLine.line[3].lineWidth = 3;
		GroupLine.line[3].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[3].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[3].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[3].drawGraph(canvas);
		
		GroupLine.line[4].startX = 380;    //D节点到E节点
		GroupLine.line[4].startY = 500;
		GroupLine.line[4].endX = 380;
		GroupLine.line[4].endY = 560;
		GroupLine.line[4].lineWidth = 3;
		GroupLine.line[4].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[4].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[4].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[4].drawGraph(canvas);
		
		GroupLine.line[5].startX = 380;    //E节点连接E
		GroupLine.line[5].startY = 560;
		GroupLine.line[5].endX = 220;
		GroupLine.line[5].endY = 560;
		GroupLine.line[5].lineWidth = 3;
		GroupLine.line[5].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[5].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[5].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[5].drawGraph(canvas);
		
		GroupLine.line[6].startX = 380;    //E节点到F节点
		GroupLine.line[6].startY = 560;
		GroupLine.line[6].endX = 380;
		GroupLine.line[6].endY = 620;
		GroupLine.line[6].lineWidth = 3;
		GroupLine.line[6].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[6].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[6].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[6].drawGraph(canvas);
		
		GroupLine.line[7].startX = 380;    //F节点连接F
		GroupLine.line[7].startY = 620;
		GroupLine.line[7].endX = 220;
		GroupLine.line[7].endY = 620;
		GroupLine.line[7].lineWidth = 3;
		GroupLine.line[7].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[7].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[7].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[7].drawGraph(canvas);
		
		GroupLine.line[8].startX = 720;    //SK7到A节点
		GroupLine.line[8].startY = 305;
		GroupLine.line[8].endX = 720;
		GroupLine.line[8].endY = 350;
		GroupLine.line[8].lineWidth = 3;
		GroupLine.line[8].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[8].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[8].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[8].drawGraph(canvas);
		
		GroupLine.line[8].startX = 740;    //SK7到A节点
		GroupLine.line[8].startY = 370;
		GroupLine.line[8].endX = 720;
		GroupLine.line[8].endY = 350;
		GroupLine.line[8].lineWidth = 3;
		GroupLine.line[8].bArc = true;
		GroupLine.line[8].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[8].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[8].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[8].drawGraph(canvas);
		
		GroupLine.line[8].startX = 740;    //SK7到A节点
		GroupLine.line[8].startY = 370;
		GroupLine.line[8].endX = 920;
		GroupLine.line[8].endY = 370;
		GroupLine.line[8].lineWidth = 3;
		GroupLine.line[8].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[8].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[8].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[8].drawGraph(canvas);
		
		GroupLine.line[8].startX = 920;    //SK7到A节点
		GroupLine.line[8].startY = 370;
		GroupLine.line[8].endX = 940;
		GroupLine.line[8].endY = 390;
		GroupLine.line[8].lineWidth = 3;
		GroupLine.line[8].bArc = true;
		GroupLine.line[8].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[8].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[8].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[8].drawGraph(canvas);
		
		GroupLine.line[8].startX = 940;    //SK7到A节点
		GroupLine.line[8].startY = 390;
		GroupLine.line[8].endX = 940;
		GroupLine.line[8].endY = 500;
		GroupLine.line[8].lineWidth = 3;
		GroupLine.line[8].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[8].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[8].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[8].drawGraph(canvas);
		
		GroupLine.line[9].startX = 940;    //A节点到A
		GroupLine.line[9].startY = 500;
		GroupLine.line[9].endX = 1080;
		GroupLine.line[9].endY = 500;
		GroupLine.line[9].lineWidth = 3;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[9].drawGraph(canvas);
		
		GroupLine.line[10].startX = 940;    //A节点到B节点
		GroupLine.line[10].startY = 500;
		GroupLine.line[10].endX = 940;
		GroupLine.line[10].endY = 560;
		GroupLine.line[10].lineWidth = 3;
		GroupLine.line[10].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[10].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[10].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[10].drawGraph(canvas);
		
		GroupLine.line[11].startX = 940;    //B节点到B
		GroupLine.line[11].startY = 560;
		GroupLine.line[11].endX = 1080;
		GroupLine.line[11].endY = 560;
		GroupLine.line[11].lineWidth = 3;
		GroupLine.line[11].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[11].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[11].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[11].drawGraph(canvas);
		
		GroupLine.line[12].startX = 940;    //B节点到C节点
		GroupLine.line[12].startY = 560;
		GroupLine.line[12].endX = 940;
		GroupLine.line[12].endY = 620;
		GroupLine.line[12].lineWidth = 3;
		GroupLine.line[12].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[12].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[12].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[12].drawGraph(canvas);
		
		GroupLine.line[12].startX = 940;    //C节点到C
		GroupLine.line[12].startY = 620;
		GroupLine.line[12].endX = 1080;
		GroupLine.line[12].endY = 620;
		GroupLine.line[12].lineWidth = 3;
		GroupLine.line[12].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[12].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[12].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[12].drawGraph(canvas);
		
		GroupLine.line[13].startX = 760;    //SK2到I节点
		GroupLine.line[13].startY = 305;
		GroupLine.line[13].endX = 760;
		GroupLine.line[13].endY = 310;
		GroupLine.line[13].lineWidth = 3;
		GroupLine.line[13].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[13].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[13].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[13].drawGraph(canvas);
		
		GroupLine.line[13].startX = 780;    //SK2到I节点
		GroupLine.line[13].startY = 330;
		GroupLine.line[13].endX = 760;
		GroupLine.line[13].endY = 310;
		GroupLine.line[13].lineWidth = 3;
		GroupLine.line[13].bArc = true;
		GroupLine.line[13].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[13].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[13].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[13].drawGraph(canvas);
		
		GroupLine.line[13].startX = 780;    //SK2到I节点
		GroupLine.line[13].startY = 330;
		GroupLine.line[13].endX = 1080;
		GroupLine.line[13].endY = 330;
		GroupLine.line[13].lineWidth = 3;
		GroupLine.line[13].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[13].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[13].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[13].drawGraph(canvas);
		
		GroupLine.line[13].startX = 1100;    //SK2到I节点
		GroupLine.line[13].startY = 310;
		GroupLine.line[13].endX = 1080;
		GroupLine.line[13].endY = 330;
		GroupLine.line[13].lineWidth = 3;
		GroupLine.line[13].bArc = true;
		GroupLine.line[13].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[13].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[13].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[13].drawGraph(canvas);
		
		GroupLine.line[13].startX = 1100;    //SK2到I节点
		GroupLine.line[13].startY = 310;
		GroupLine.line[13].endX = 1100;
		GroupLine.line[13].endY = 220;
		GroupLine.line[13].lineWidth = 3;
		GroupLine.line[13].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[13].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[13].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[13].drawGraph(canvas);
		
		GroupLine.line[14].startX = 1120;    //A出口到A节点
		GroupLine.line[14].startY = 500;
		GroupLine.line[14].endX = 1200;
		GroupLine.line[14].endY = 500;
		GroupLine.line[14].lineWidth = 3;
		GroupLine.line[14].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[14].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[14].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[14].drawGraph(canvas);
		
		GroupLine.line[15].startX = 1120;    //B出口到B节点
		GroupLine.line[15].startY = 560;
		GroupLine.line[15].endX = 1200;
		GroupLine.line[15].endY = 560;
		GroupLine.line[15].lineWidth = 3;
		GroupLine.line[15].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[15].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[15].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[15].drawGraph(canvas);
		
		GroupLine.line[16].startX = 1120;    //C出口到B节点
		GroupLine.line[16].startY = 620;
		GroupLine.line[16].endX = 1200;
		GroupLine.line[16].endY = 620;
		GroupLine.line[16].lineWidth = 3;
		GroupLine.line[16].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[16].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[16].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[16].drawGraph(canvas);
		
		GroupLine.line[16].startX = 1200;    //C出口到B节点
		GroupLine.line[16].startY = 621;
		GroupLine.line[16].endX = 1200;
		GroupLine.line[16].endY = 560;
		GroupLine.line[16].lineWidth = 3;
		GroupLine.line[16].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[16].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[16].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[16].drawGraph(canvas);
		
		GroupLine.line[17].startX = 1200;    //B节点到A节点
		GroupLine.line[17].startY = 560;
		GroupLine.line[17].endX = 1200;
		GroupLine.line[17].endY = 500;
		GroupLine.line[17].lineWidth = 3;
		GroupLine.line[17].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[17].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[17].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[17].drawGraph(canvas);
		
		GroupLine.line[18].startX = 1200;    //A节点到油箱顶部中间
		GroupLine.line[18].startY = 500;
		GroupLine.line[18].endX = 1200;
		GroupLine.line[18].endY = 40;
		GroupLine.line[18].lineWidth = 3;
		GroupLine.line[18].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[18].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[18].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[18].drawGraph(canvas);
		
		GroupLine.line[18].startX = 1180;    //A节点到油箱顶部中间
		GroupLine.line[18].startY = 20;
		GroupLine.line[18].endX = 1200;
		GroupLine.line[18].endY = 40;
		GroupLine.line[18].lineWidth = 3;
		GroupLine.line[18].bArc = true;
		GroupLine.line[18].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[18].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[18].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[18].drawGraph(canvas);
		
		GroupLine.line[18].startX = 1180;    //A节点到油箱顶部中间
		GroupLine.line[18].startY = 20;
		GroupLine.line[18].endX = 660;
		GroupLine.line[18].endY = 20;
		GroupLine.line[18].lineWidth = 3;
		GroupLine.line[18].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[18].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[18].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[18].drawGraph(canvas);
		
		GroupLine.line[18].startX = 640;    //A节点到油箱顶部中间
		GroupLine.line[18].startY = 40;
		GroupLine.line[18].endX = 660;
		GroupLine.line[18].endY = 20;
		GroupLine.line[18].lineWidth = 3;
		GroupLine.line[18].bArc = true;
		GroupLine.line[18].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[18].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[18].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[18].drawGraph(canvas);
		
		GroupLine.line[19].startX = 640;    //A节点到油箱顶部中间
		GroupLine.line[19].startY = 40;
		GroupLine.line[19].endX = 640;
		GroupLine.line[19].endY = 70;
		GroupLine.line[19].lineWidth = 3;
		GroupLine.line[19].bArc = false;
		GroupLine.line[19].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[19].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[19].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[19].drawGraph(canvas);
		
		GroupLine.line[20].startX = 180;    //D出口到D节点
		GroupLine.line[20].startY = 500;
		GroupLine.line[20].endX = 100;
		GroupLine.line[20].endY = 500;
		GroupLine.line[20].lineWidth = 3;
		GroupLine.line[20].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[20].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[20].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[20].drawGraph(canvas);
		
		GroupLine.line[21].startX = 180;    //E出口到E节点
		GroupLine.line[21].startY = 560;
		GroupLine.line[21].endX = 100;
		GroupLine.line[21].endY = 560;
		GroupLine.line[21].lineWidth = 3;
		GroupLine.line[21].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[21].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[21].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[21].drawGraph(canvas);
		
		GroupLine.line[22].startX = 180;    //F出口到E节点
		GroupLine.line[22].startY = 620;
		GroupLine.line[22].endX = 100;
		GroupLine.line[22].endY = 620;
		GroupLine.line[22].lineWidth = 3;
		GroupLine.line[22].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[22].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[22].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[22].drawGraph(canvas);
		
		GroupLine.line[22].startX = 100;    //F出口到E节点
		GroupLine.line[22].startY = 621;
		GroupLine.line[22].endX = 100;
		GroupLine.line[22].endY = 560;
		GroupLine.line[22].lineWidth = 3;
		GroupLine.line[22].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[22].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[22].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[22].drawGraph(canvas);
		
		GroupLine.line[23].startX = 100;    //E节点到D节点
		GroupLine.line[23].startY = 560;
		GroupLine.line[23].endX = 100;
		GroupLine.line[23].endY = 500;
		GroupLine.line[23].lineWidth = 3;
		GroupLine.line[23].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[23].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[23].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[23].drawGraph(canvas);
		
		GroupLine.line[24].startX = 100;    //D节点到油箱顶部中间
		GroupLine.line[24].startY = 500;
		GroupLine.line[24].endX = 100;
		GroupLine.line[24].endY = 40;
		GroupLine.line[24].lineWidth = 3;
		GroupLine.line[24].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[24].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[24].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[24].drawGraph(canvas);
		
		GroupLine.line[24].startX = 100;    //D节点到油箱顶部中间
		GroupLine.line[24].startY = 40;
		GroupLine.line[24].endX = 120;
		GroupLine.line[24].endY = 20;
		GroupLine.line[24].lineWidth = 3;
		GroupLine.line[24].bArc = true;
		GroupLine.line[24].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[24].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[24].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[24].drawGraph(canvas);
		
		GroupLine.line[24].startX = 120;    //D节点到油箱顶部中间
		GroupLine.line[24].startY = 20;
		GroupLine.line[24].endX = 620;
		GroupLine.line[24].endY = 20;
		GroupLine.line[24].lineWidth = 3;
		GroupLine.line[24].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[24].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[24].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[24].drawGraph(canvas);
		
		GroupLine.line[24].startX = 620;    //D节点到油箱顶部中间
		GroupLine.line[24].startY = 20;
		GroupLine.line[24].endX = 640;
		GroupLine.line[24].endY = 40;
		GroupLine.line[24].lineWidth = 3;
		GroupLine.line[24].bArc = true;
		GroupLine.line[24].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[24].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[24].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[24].drawGraph(canvas);
				
		GroupLine.line[25].startX = 230;    //H出口到H节点
		GroupLine.line[25].startY = 360;
		GroupLine.line[25].endX = 150;
		GroupLine.line[25].endY = 360;
		GroupLine.line[25].lineWidth = 3;
		GroupLine.line[25].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[25].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[25].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[25].drawGraph(canvas);
		
		GroupLine.line[26].startX = 230;    //G出口到H节点
		GroupLine.line[26].startY = 420;
		GroupLine.line[26].endX = 150;
		GroupLine.line[26].endY = 420;
		GroupLine.line[26].lineWidth = 3;
		GroupLine.line[26].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[26].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[26].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[26].drawGraph(canvas);
		
		GroupLine.line[26].startX = 150;    //G出口到H节点
		GroupLine.line[26].startY = 421;
		GroupLine.line[26].endX = 150;
		GroupLine.line[26].endY = 360;
		GroupLine.line[26].lineWidth = 3;
		GroupLine.line[26].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[26].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[26].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[26].drawGraph(canvas);
		
		GroupLine.line[27].startX = 150;    //H节点到油箱顶部左边
		GroupLine.line[27].startY = 360;
		GroupLine.line[27].endX = 150;
		GroupLine.line[27].endY = 60;
		GroupLine.line[27].lineWidth = 3;
		GroupLine.line[27].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[27].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[27].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[27].drawGraph(canvas);
		
		GroupLine.line[27].startX = 150;    //H节点到油箱顶部左边
		GroupLine.line[27].startY = 60;
		GroupLine.line[27].endX = 170;
		GroupLine.line[27].endY = 40;
		GroupLine.line[27].lineWidth = 3;
		GroupLine.line[27].bArc = true;
		GroupLine.line[27].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[27].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[27].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[27].drawGraph(canvas);
		
		GroupLine.line[27].startX = 170;    //H节点到油箱顶部左边
		GroupLine.line[27].startY = 40;
		GroupLine.line[27].endX = 520;
		GroupLine.line[27].endY = 40;
		GroupLine.line[27].lineWidth = 3;
		GroupLine.line[27].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[27].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[27].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[27].drawGraph(canvas);
		
		GroupLine.line[27].startX = 520;    //H节点到油箱顶部左边
		GroupLine.line[27].startY = 40;
		GroupLine.line[27].endX = 540;
		GroupLine.line[27].endY = 60;
		GroupLine.line[27].lineWidth = 3;
		GroupLine.line[27].bArc = true;
		GroupLine.line[27].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[27].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[27].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[27].drawGraph(canvas);
		
		GroupLine.line[27].startX = 540;    //H节点到油箱顶部左边
		GroupLine.line[27].startY = 60;
		GroupLine.line[27].endX = 540;
		GroupLine.line[27].endY = 70;
		GroupLine.line[27].lineWidth = 3;
		GroupLine.line[27].bArc = false;
		GroupLine.line[27].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[27].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[27].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[27].drawGraph(canvas);
		
		GroupLine.line[28].startX = 1100;    //I节点到油箱顶部右边
		GroupLine.line[28].startY = 180;
		GroupLine.line[28].endX = 1100;
		GroupLine.line[28].endY = 60;
		GroupLine.line[28].lineWidth = 3;
		GroupLine.line[28].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[28].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[28].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[28].drawGraph(canvas);
		
		GroupLine.line[28].startX = 1080;    //I节点到油箱顶部右边
		GroupLine.line[28].startY = 40;
		GroupLine.line[28].endX = 1100;
		GroupLine.line[28].endY = 60;
		GroupLine.line[28].lineWidth = 3;
		GroupLine.line[28].bArc = true;
		GroupLine.line[28].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[28].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[28].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[28].drawGraph(canvas);
		
		GroupLine.line[28].startX = 1080;    //I节点到油箱顶部右边
		GroupLine.line[28].startY = 40;
		GroupLine.line[28].endX = 760;
		GroupLine.line[28].endY = 40;
		GroupLine.line[28].lineWidth = 3;
		GroupLine.line[28].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[28].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[28].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[28].drawGraph(canvas);
		
		GroupLine.line[28].startX = 740;    //I节点到油箱顶部右边
		GroupLine.line[28].startY = 60;
		GroupLine.line[28].endX = 760;
		GroupLine.line[28].endY = 40;
		GroupLine.line[28].lineWidth = 3;
		GroupLine.line[28].bArc = true;
		GroupLine.line[28].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[28].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[28].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[28].drawGraph(canvas);
		
		GroupLine.line[28].startX = 740;    //I节点到油箱顶部右边
		GroupLine.line[28].startY = 60;
		GroupLine.line[28].endX = 740;
		GroupLine.line[28].endY = 70;
		GroupLine.line[28].lineWidth = 3;
		GroupLine.line[28].bArc = false;
		GroupLine.line[28].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[28].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[28].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[28].drawGraph(canvas);
		
		GroupLine.line[30].startX = 580;    //下油箱到J
		GroupLine.line[30].startY = 580;
		GroupLine.line[30].endX = 580;
		GroupLine.line[30].endY = 600;
		GroupLine.line[30].lineWidth = 3;
		GroupLine.line[30].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[30].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[30].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[30].drawGraph(canvas);
		
		GroupLine.line[31].startX = 700;    //下油箱到K
		GroupLine.line[31].startY = 580;
		GroupLine.line[31].endX = 700;
		GroupLine.line[31].endY = 600;
		GroupLine.line[31].lineWidth = 3;
		GroupLine.line[31].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[31].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[31].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[31].drawGraph(canvas);
		
		GroupLine.line[32].startX = 580;    //J出口
		GroupLine.line[32].startY = 640;
		GroupLine.line[32].endX = 580;
		GroupLine.line[32].endY = 660;
		GroupLine.line[32].lineWidth = 3;
		GroupLine.line[32].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[32].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[32].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[32].drawGraph(canvas);
		
		GroupLine.line[33].startX = 700;    //K出口
		GroupLine.line[33].startY = 640;
		GroupLine.line[33].endX = 700;
		GroupLine.line[33].endY = 660;
		GroupLine.line[33].lineWidth = 3;
		GroupLine.line[33].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[33].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[33].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[33].drawGraph(canvas);
		
		GroupLine.line[35].startX = 540;    //左报警灯到油箱
		GroupLine.line[35].startY = 90;
		GroupLine.line[35].endX = 540;
		GroupLine.line[35].endY = 120;
		GroupLine.line[35].lineWidth = 3;
		GroupLine.line[35].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[35].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[35].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[35].drawGraph(canvas);
		
		GroupLine.line[36].startX = 640;    //中报警灯到油箱
		GroupLine.line[36].startY = 90;
		GroupLine.line[36].endX = 640;
		GroupLine.line[36].endY = 120;
		GroupLine.line[36].lineWidth = 3;
		GroupLine.line[36].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[36].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[36].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[36].drawGraph(canvas);
		
		GroupLine.line[37].startX = 740;    //右报警灯到油箱
		GroupLine.line[37].startY = 90;
		GroupLine.line[37].endX = 740;
		GroupLine.line[37].endY = 120;
		GroupLine.line[37].lineWidth = 3;
		GroupLine.line[37].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[37].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[37].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[37].drawGraph(canvas);
		
		Paint paint = new Paint(); // 新建画笔
		paint.setAntiAlias(true); // 使用抗锯齿功能	
		//画矩形
		paint.setStyle(Paint.Style.STROKE);
		RectF rectf1 = new RectF(520, 480, 760, 580);
		RectF rectf2 = new RectF(470, 120, 810, 250);
		RectF rectf3 = new RectF(80, 330, 160, 380);
		RectF rectf4 = new RectF(380, 330, 460, 380);
		RectF rectf5 = new RectF(50, 283, 700, 422);
		paint.setColor(Color.GRAY);
		paint.setStrokeWidth(2); // 设置画笔的宽度
		canvas.drawRect(rectf1, paint);
		paint.setStrokeWidth(3); // 设置画笔的宽度
		canvas.drawRect(rectf2, paint);
		
		//画线
		paint.setStrokeWidth(3); // 设置画笔的宽度
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(Color.argb(255, 205, 149, 12));
		canvas.drawLine(500, 250, 500, 275, paint);//sk8连接油箱
		canvas.drawLine(540, 250, 540, 275, paint);//sk4连接油箱
		canvas.drawLine(580, 250, 580, 275, paint);//sk1连接油箱
		canvas.drawLine(720, 250, 720, 275, paint);// sk7连接油箱
		canvas.drawLine(760, 250, 760, 275, paint);// sk2连接油箱

		// 模拟量
		GroupText.text[218].cx = 590; // J泵出口压力
		GroupText.text[218].cy = 660;
		GroupText.text[218].textSize = 15;
		GroupText.text[218].format = 0;
		GroupText.text[218].drawGraph(canvas);
		
		GroupText.text[219].cx = 710; // K泵出口压力
		GroupText.text[219].cy = 660;
		GroupText.text[219].textSize = 15;
		GroupText.text[219].format = 0;
		GroupText.text[219].drawGraph(canvas);
		
		GroupText.text[256].cx = 1000; // A泵出口压力
		GroupText.text[256].cy = 500;
		GroupText.text[256].textSize = 15;
		GroupText.text[256].format = 0;
		GroupText.text[256].drawGraph(canvas);
		
		GroupText.text[257].cx = 1000; // B泵出口压力
		GroupText.text[257].cy = 560;
		GroupText.text[257].textSize = 15;
		GroupText.text[257].format = 0;
		GroupText.text[257].drawGraph(canvas);
		
		GroupText.text[258].cx = 1000; // C泵出口压力
		GroupText.text[258].cy = 620;
		GroupText.text[258].textSize = 15;
		GroupText.text[258].format = 0;
		GroupText.text[258].drawGraph(canvas);
		
		GroupText.text[252].cx = 260; // D泵出口压力
		GroupText.text[252].cy = 500;
		GroupText.text[252].textSize = 15;
		GroupText.text[252].format = 0;
		GroupText.text[252].drawGraph(canvas);
		
		GroupText.text[253].cx = 260; // E泵出口压力
		GroupText.text[253].cy = 560;
		GroupText.text[253].textSize = 15;
		GroupText.text[253].format = 0;
		GroupText.text[253].drawGraph(canvas);
		
		GroupText.text[254].cx = 260; // F泵出口压力
		GroupText.text[254].cy = 620;
		GroupText.text[254].textSize = 15;
		GroupText.text[254].format = 0;
		GroupText.text[254].drawGraph(canvas);
		
		GroupText.text[255].cx = 310; // G泵出口压力
		GroupText.text[255].cy = 420;
		GroupText.text[255].textSize = 15;
		GroupText.text[255].format = 0;
		GroupText.text[255].drawGraph(canvas);
		
		GroupText.text[255].cx = 310; // H泵出口压力
		GroupText.text[255].cy = 360;
		GroupText.text[255].textSize = 15;
		GroupText.text[255].format = 0;
		GroupText.text[255].drawGraph(canvas);
		// 写文本
		paint.setStrokeWidth(1); // 设置画笔的宽度
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(Color.LTGRAY);
		paint.setTextSize(15);
		canvas.drawText("PS", 570, 680, paint);
		canvas.drawText("SB", 690, 680, paint);
		
		canvas.drawText("A", 1140, 520, paint);
		canvas.drawText("B", 1140, 580, paint);
		canvas.drawText("C", 1140, 640, paint);
		canvas.drawText("D", 160, 520, paint);
		canvas.drawText("E", 160, 580, paint);
		canvas.drawText("F", 160, 640, paint);
		canvas.drawText("G", 210, 440, paint);
		canvas.drawText("H", 210, 380, paint);
		canvas.drawText("I", 1140, 220, paint);
		canvas.drawText("J", 540, 620, paint);
		canvas.drawText("K", 730, 620, paint);		
		canvas.drawText("bar", 620, 655, paint);//J
		canvas.drawText("bar", 740, 655, paint);//K		
		canvas.drawText("bar", 1040, 495, paint);//A
		canvas.drawText("bar", 1040, 555, paint);//B
		canvas.drawText("bar", 1040, 615, paint);//C
		canvas.drawText("bar", 300, 495, paint);//D
		canvas.drawText("bar", 300, 555, paint);//E
		canvas.drawText("bar", 300, 615, paint);//F
		canvas.drawText("bar", 350, 415, paint);//G
		canvas.drawText("bar", 350, 355, paint);//H
		
		canvas.drawText("SK8", 460, 295, paint);
		canvas.drawText("SK4", 505, 295, paint);
		canvas.drawText("SK1", 550, 295, paint);
		canvas.drawText("SK7", 680, 295, paint);
		canvas.drawText("SK2", 725, 295, paint);
		
		canvas.drawText("Draghead", 1000, 520, paint);//A
		canvas.drawText("Draghead", 260, 520, paint);//D
		canvas.drawText("Intermediate", 990, 580, paint);//B
		canvas.drawText("Intermediate", 260, 580, paint);//E
		canvas.drawText("Trunnion", 1000, 640, paint);//C
		canvas.drawText("Trunnion", 260, 640, paint);//F
		canvas.drawText("Door Fasten", 310, 380, paint);//H
		canvas.drawText("Emergency", 310, 440, paint);//G
		canvas.drawText("Cooling", 1020, 205, paint);	//I	
		canvas.drawText("Heater", 625, 270, paint);
		
		canvas.drawText("Level Low", 220, 180, paint);
		canvas.drawText("Level Low Low", 220, 210, paint);
		canvas.drawText("Temperature High", 220, 240, paint);
		
		canvas.drawText("Filter Blocked NO.3", 400, 110, paint);
		canvas.drawText("Filter Blocked NO.1", 580, 110, paint);
		canvas.drawText("Filter Blocked NO.2", 760, 110, paint);
		
		canvas.drawText("Level Low", 800, 400, paint);
		canvas.drawText("Level Low Low", 800, 430, paint);
		canvas.drawText("Temperature High", 800, 460, paint);
		canvas.drawText("Filter Blocked", 800, 490, paint);
		paint.setTextSize(18);
		canvas.drawText("Active Draghead", 570, 472, paint);		
		canvas.drawText("Main Oil Tank", 205, 150, paint);
		paint.setTextSize(30);
		paint.setColor(Color.argb(255,205,205,0));
		canvas.drawText("PS", 160, 465, paint);
		canvas.drawText("SB", 1100, 465, paint);
		paint.setColor(Color.YELLOW);
		paint.setTextSize(30);
		canvas.drawText("液压泵画面", 20, 30, paint);
	}
}
