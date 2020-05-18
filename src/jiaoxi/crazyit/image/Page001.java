package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.text.TextPaint;

import jiaoxi.crazyit.classes.Density;

////////////// 主界面001
public class Page001 {

	public static void DrawPage(Canvas canvas) {
//		if (GateValveActivity.control_limite) {
//			canvas.drawBitmap(GateValveActivity.bmp11, 2150, 70, null);
//		} else {
//			canvas.drawBitmap(GateValveActivity.bmp10, 2150, 70, null);
//		}
		//////////////////////////////////////////////////////////////////////////////////
//		GateValveActivity.bmp1;
//		canvas.drawBitmap(GateValveActivity.bmp1, 2240, 440, null);        //配电板
		canvas.drawBitmap(GateValveActivity.bmp2, 1760, 80, null);        //台车
//		canvas.drawBitmap(GateValveActivity.bmp4, 735, 610, null);        //变频器

//		canvas.drawBitmap(GateValveActivity.bmp5, 100, 1000, null);        //桥架切换
//		canvas.drawBitmap(GateValveActivity.bmp6, 100, 1000, null);        //桥架切换
//		//柴油机
//		GroupDiesel.diese.cx = 1800;
//		GroupDiesel.diese.cy = 310;
//		GroupDiesel.diese.rectHeight = 280;
//		GroupDiesel.diese.rectWidth = 300;			
//		GroupDiesel.diese.num = 5;
//		GroupDiesel.diese.drawGraph(canvas);
		GroupBucketWheel.bucketwheel[0].cx=240;
		GroupBucketWheel.bucketwheel[0].cy=420;
		GroupBucketWheel.bucketwheel[0].run=true;
		GroupBucketWheel.bucketwheel[0].reversal=true;
		GroupBucketWheel.bucketwheel[0].drawGraph(canvas);

		
		//绞刀头
		GroupCutterWheel.cutterwheel.cx = 240;
		GroupCutterWheel.cutterwheel.cy = 420;
		GroupCutterWheel.cutterwheel.rectHeight = 200;
		GroupCutterWheel.cutterwheel.rectWidth = 200;
		GroupCutterWheel.cutterwheel.drawGraph(canvas);
        //桥架		
		GroupCutter2.cutter2.cx = 20;
		GroupCutter2.cutter2.cy = 835;
		GroupCutter2.cutter2.rectWidth = 1070;
		GroupCutter2.cutter2.rectHeight = 690;
//		GroupCutter2.cutter2.run=true;
		GroupCutter2.cutter2.deep = 30;
		GroupCutter2.cutter2.drawGraph(canvas);
		//水下泥泵
		GroupDredgePump.dredgepump[0].cx = 760;    //泥泵
		GroupDredgePump.dredgepump[0].cy = 400;
		GroupDredgePump.dredgepump[0].rectWidth = 80;
		GroupDredgePump.dredgepump[0].rectHeight = 180;
		GroupDredgePump.dredgepump[0].rotateAngle = 360;
		GroupDredgePump.dredgepump[0].bShowLeft = false;
		GroupDredgePump.dredgepump[0].sText = "泥泵";
		GroupDredgePump.dredgepump[0].drawGraph(canvas);


		GroupClutch.clutch[0].cx = 860;
		GroupClutch.clutch[0].cy = 680;
		GroupClutch.clutch[0].rectWidth = 45;
		GroupClutch.clutch[0].rectHeight = 60;
		GroupClutch.clutch[0].drawGraph(canvas);// 离合器
		
		GroupDiesel.diesel[0].cx = 900;
		GroupDiesel.diesel[0].cy = 480;
		GroupDiesel.diesel[0].rectHeight = 280;
		GroupDiesel.diesel[0].rectWidth = 300;			
		GroupDiesel.diesel[0].num = 5;
		GroupDiesel.diesel[0].drawGraph(canvas);//柴油机
		
		GroupDiesel.diesel[1].cx = 1800;
		GroupDiesel.diesel[1].cy = 320;
		GroupDiesel.diesel[1].rectHeight = 280;
		GroupDiesel.diesel[1].rectWidth = 300;			
		GroupDiesel.diesel[1].num = 5;
		GroupDiesel.diesel[1].drawGraph(canvas);//柴油机

		 //应急
		GroupHDPump.hdpump[3].cx = 1680;   //1#液压泵
		GroupHDPump.hdpump[3].cy = 510-150;
		GroupHDPump.hdpump[3].rectWidth = 100;
		GroupHDPump.hdpump[3].rectHeight = 100;
		GroupHDPump.hdpump[3].rotateAngle = 180;
		GroupHDPump.hdpump[3].bArc = false;
		GroupHDPump.hdpump[3].blink_sign = false;
		GroupHDPump.hdpump[3].szText = "1#液压泵";
		GroupHDPump.hdpump[3].drawGraph(canvas);
						
		//应急泵
		GroupHDPump.hdpump[1].cx = 950;   //1#液压泵
		GroupHDPump.hdpump[1].cy = 170;
		GroupHDPump.hdpump[1].rectWidth = 100;
		GroupHDPump.hdpump[1].rectHeight = 100;
		GroupHDPump.hdpump[1].bArc = true;
		GroupHDPump.hdpump[1].blink_sign = false;
		GroupHDPump.hdpump[1].szText = "封水泵";
		GroupHDPump.hdpump[1].drawGraph(canvas);

		 //消防泵
		GroupHDPump.hdpump[4].cx = 1320+50;   //1#液压泵
		GroupHDPump.hdpump[4].cy = 770-150;
		GroupHDPump.hdpump[4].rectWidth = 100;
		GroupHDPump.hdpump[4].rectHeight = 100;
		GroupHDPump.hdpump[4].rotateAngle = 0;
		GroupHDPump.hdpump[4].bArc = false;
		GroupHDPump.hdpump[4].blink_sign = false;
		GroupHDPump.hdpump[4].szText = "消防泵";
		GroupHDPump.hdpump[4].drawGraph(canvas);
	
		//线条
		
		GroupLine.line[0].startX = 325;    //绞刀到水下泵
		GroupLine.line[0].startY = 420;
		GroupLine.line[0].endX = 720;
		GroupLine.line[0].endY = 420;
		GroupLine.line[0].lineWidth = 6;
		GroupLine.line[0].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[0].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[0].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[0].drawGraph(canvas);
		
		GroupLine.line[0].startX = 820;    //
		GroupLine.line[0].startY = 420;
		GroupLine.line[0].endX = 1100;
		GroupLine.line[0].endY = 420;
		GroupLine.line[0].lineWidth = 6;
		GroupLine.line[0].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[0].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[0].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[0].drawGraph(canvas);
		
		GroupLine.line[2].startX = 1356;    //
		GroupLine.line[2].startY = 340;
		GroupLine.line[2].endX = 1180;
		GroupLine.line[2].endY = 340;
		GroupLine.line[2].lineWidth = 6;
		GroupLine.line[2].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[2].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[2].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[2].drawGraph(canvas);
		
		GroupLine.line[0].startX = 1140;    //
		GroupLine.line[0].startY = 380;
		GroupLine.line[0].endX = 1100;
		GroupLine.line[0].endY = 420;
		GroupLine.line[0].lineWidth = 6;
		GroupLine.line[0].bArc = true;
		GroupLine.line[0].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[0].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[0].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[0].drawGraph(canvas);
		
		GroupLine.line[0].startX = 1140;    //
		GroupLine.line[0].startY = 380;
		GroupLine.line[0].endX = 1180;
		GroupLine.line[0].endY = 340;
		GroupLine.line[0].lineWidth = 6;
		GroupLine.line[0].bArc = true;
		GroupLine.line[0].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[0].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[0].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[0].drawGraph(canvas);
		
		GroupLine.line[0].startX = 760;    //变频器到水下泵
		GroupLine.line[0].startY = 530;
		GroupLine.line[0].endX = 760+3;
		GroupLine.line[0].endY = 610+70;
		GroupLine.line[0].lineWidth = 6;
		GroupLine.line[0].bArc = false;
		GroupLine.line[0].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[0].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[0].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[0].drawGraph(canvas);
		
		GroupLine.line[9].startX = 1810;    //泵站出口连接
		GroupLine.line[9].startY = 510;
		GroupLine.line[9].endX = 1540;
		GroupLine.line[9].endY = 510;
		GroupLine.line[9].lineWidth = 6;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[9].drawGraph(canvas);

		GroupLine.line[9].startX = 1680;    //泵站出口连接
		GroupLine.line[9].startY = 510-100;
		GroupLine.line[9].endX = 1680;
		GroupLine.line[9].endY = 510;
		GroupLine.line[9].lineWidth = 6;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[9].drawGraph(canvas);
		
		GroupLine.line[9].startX = 1540;    //泵站出口连接
		GroupLine.line[9].startY = 140;
		GroupLine.line[9].endX = 1540;
		GroupLine.line[9].endY = 513;//660
		GroupLine.line[9].lineWidth = 6;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[9].drawGraph(canvas);
		
		GroupLine.line[9].startX = 1500;    //泵站出口和绞刀连接
		GroupLine.line[9].startY = 100;
		GroupLine.line[9].endX = 1540;
		GroupLine.line[9].endY = 140;
		GroupLine.line[9].lineWidth = 6;
		GroupLine.line[9].bArc = true;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[9].drawGraph(canvas);
				
		GroupLine.line[9].startX = 1500;    //泵站出口和绞刀连接
		GroupLine.line[9].startY = 100;
		GroupLine.line[9].endX = 1240;
		GroupLine.line[9].endY = 100;
		GroupLine.line[9].lineWidth = 6;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[9].drawGraph(canvas);
		
		GroupLine.line[9].startX = 1540;    //泵站出口和水下泵连接
		GroupLine.line[9].startY = 660;
		GroupLine.line[9].endX = 1500;
		GroupLine.line[9].endY = 700;
		GroupLine.line[9].lineWidth = 6;
		GroupLine.line[9].bArc = true;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
//		GroupLine.line[9].drawGraph(canvas);
		
		GroupLine.line[9].startX = 1500;    //泵站出口和水下泵连接
		GroupLine.line[9].startY = 700;
		GroupLine.line[9].endX = 1240;
		GroupLine.line[9].endY = 700;
		GroupLine.line[9].lineWidth = 6;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
//		GroupLine.line[9].drawGraph(canvas);
		
		GroupLine.line[9].startX = 1540;    //泵站出口和台车连接
		GroupLine.line[9].startY = 180;
		GroupLine.line[9].endX = 1800;
		GroupLine.line[9].endY = 180;
		GroupLine.line[9].lineWidth = 6;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[9].drawGraph(canvas);
		
		GroupLine.line[1].startX = 900;    //封水泵到水下泵连接
		GroupLine.line[1].startY = 170;
		GroupLine.line[1].endX = 800;
		GroupLine.line[1].endY = 170;
		GroupLine.line[1].lineWidth = 6;
		GroupLine.line[1].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[1].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[1].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[1].drawGraph(canvas);
		
		GroupLine.line[1].startX = 760;    //封水泵到水下泵连接
		GroupLine.line[1].startY = 210;
		GroupLine.line[1].endX = 800;
		GroupLine.line[1].endY = 170;
		GroupLine.line[1].lineWidth = 6;
		GroupLine.line[1].bArc = true;
		GroupLine.line[1].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[1].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[1].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[1].drawGraph(canvas);
		
		GroupLine.line[1].startX = 760;    //封水泵到水下泵连接
		GroupLine.line[1].startY = 210;
		GroupLine.line[1].endX = 760;
		GroupLine.line[1].endY = 270;
		GroupLine.line[1].lineWidth = 6;
		GroupLine.line[1].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[1].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[1].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[1].drawGraph(canvas);

		GroupLine.line[0].startX = 760;    //变频器连离合器
		GroupLine.line[0].startY = 680;
		GroupLine.line[0].endX = 835;
		GroupLine.line[0].endY = 680;
		GroupLine.line[0].lineWidth = 6;
		GroupLine.line[0].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[0].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[0].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[0].drawGraph(canvas);

		GroupLine.line[3].startX = 885;    //离合器连柴油机
		GroupLine.line[3].startY = 680;
		GroupLine.line[3].endX = 910;
		GroupLine.line[3].endY = 680;
		GroupLine.line[3].lineWidth = 6;
		GroupLine.line[3].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[3].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[3].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[3].drawGraph(canvas);
/////////////////////////////////////////////////////////////////////////////////////////////////////		
		//右下角 报警灯
		Group_BJD.bjd[72].cx = 1170-150-950;//桥架上限位
		Group_BJD.bjd[72].cy = 835+700;
		Group_BJD.bjd[72].rectWidth =40;
		Group_BJD.bjd[72].rectHeight = 40;
		Group_BJD.bjd[72].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[72].bBlink = false;
		Group_BJD.bjd[72].bRectLight = false;
		Group_BJD.bjd[72].drawGraph(canvas);

		//显示灯状态灯
		Group_BJD.bjd[60].cx = 1970+150;   //主钢桩升起
		Group_BJD.bjd[60].cy = 110+60*0;
		Group_BJD.bjd[60].rectWidth = 40;
		Group_BJD.bjd[60].rectHeight = 40;
		Group_BJD.bjd[60].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[60].bBlink = false;
		Group_BJD.bjd[60].bRectLight = true;
		Group_BJD.bjd[60].drawGraph(canvas);

		Group_BJD.bjd[61].cx = 1970+150;   //主钢桩下降
		Group_BJD.bjd[61].cy = 110+60*1;
		Group_BJD.bjd[61].rectWidth = 40;
		Group_BJD.bjd[61].rectHeight = 40;
		Group_BJD.bjd[61].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[61].bBlink = false;
		Group_BJD.bjd[61].bRectLight = true;
		Group_BJD.bjd[61].drawGraph(canvas);

		Group_BJD.bjd[62].cx = 1970+150;   //辅钢桩升起
		Group_BJD.bjd[62].cy = 110+60*2;
		Group_BJD.bjd[62].rectWidth = 40;
		Group_BJD.bjd[62].rectHeight = 40;
		Group_BJD.bjd[62].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[62].bBlink = false;
		Group_BJD.bjd[62].bRectLight = true;
		Group_BJD.bjd[62].drawGraph(canvas);

		Group_BJD.bjd[63].cx = 1970+150;   //辅钢桩下降
		Group_BJD.bjd[63].cy = 110+60*3;
		Group_BJD.bjd[63].rectWidth = 40;
		Group_BJD.bjd[63].rectHeight = 40;
		Group_BJD.bjd[63].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[63].bBlink = false;
		Group_BJD.bjd[63].bRectLight = true;
		Group_BJD.bjd[63].drawGraph(canvas);

		Group_BJD.bjd[64].cx = 1970+150;  //台车油缸伸出
		Group_BJD.bjd[64].cy = 110+60*4;
		Group_BJD.bjd[64].rectWidth = 40;
		Group_BJD.bjd[64].rectHeight = 40;
		Group_BJD.bjd[64].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[64].bBlink = false;
		Group_BJD.bjd[64].bRectLight = true;
		Group_BJD.bjd[64].drawGraph(canvas);

		Group_BJD.bjd[65].cx = 1970+150;  //台车油缸缩回
		Group_BJD.bjd[65].cy = 110+60*5;
		Group_BJD.bjd[65].rectWidth = 40;
		Group_BJD.bjd[65].rectHeight = 40;
		Group_BJD.bjd[65].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[65].bBlink = false;
		Group_BJD.bjd[65].bRectLight = true;
		Group_BJD.bjd[65].drawGraph(canvas);
		
		Group_BJD.bjd[66].cx = 1970+150;  //台车油缸伸出限位
		Group_BJD.bjd[66].cy = 110+60*6;
		Group_BJD.bjd[66].rectWidth = 40;
		Group_BJD.bjd[66].rectHeight = 40;
		Group_BJD.bjd[66].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[66].bBlink = false;
		Group_BJD.bjd[66].bRectLight = false;
		Group_BJD.bjd[66].drawGraph(canvas);

		Group_BJD.bjd[67].cx = 1970+150;  //台车油缸缩回限位
		Group_BJD.bjd[67].cy = 110+60*7;
		Group_BJD.bjd[67].rectWidth = 40;
		Group_BJD.bjd[67].rectHeight = 40;
		Group_BJD.bjd[67].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[67].bBlink = false;
		Group_BJD.bjd[67].bRectLight = false;
		Group_BJD.bjd[67].drawGraph(canvas);
		
		Group_BJD.bjd[68].cx = 210;   //斗轮正传
		Group_BJD.bjd[68].cy = 180;
		Group_BJD.bjd[68].rectWidth = 46;
		Group_BJD.bjd[68].rectHeight = 46;
		Group_BJD.bjd[68].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[68].bBlink = false;
		Group_BJD.bjd[68].bRectLight = true;
		Group_BJD.bjd[68].drawGraph(canvas);

		Group_BJD.bjd[69].cx = 210;    //斗轮反传
		Group_BJD.bjd[69].cy = 260;
		Group_BJD.bjd[69].rectWidth = 46;
		Group_BJD.bjd[69].rectHeight = 46;
		Group_BJD.bjd[69].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[69].bBlink = false;
		Group_BJD.bjd[69].bRectLight = true;
		Group_BJD.bjd[69].drawGraph(canvas);

		Group_BJD.bjd[70].cx = 1250;   //闸阀开
		Group_BJD.bjd[70].cy = 340-100;
		Group_BJD.bjd[70].rectWidth = 40;
		Group_BJD.bjd[70].rectHeight = 40;
		Group_BJD.bjd[70].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[70].bBlink = false;
		Group_BJD.bjd[70].bRectLight = true;
		Group_BJD.bjd[70].drawGraph(canvas);
		
		Group_BJD.bjd[71].cx = 1250;	//闸阀关
		Group_BJD.bjd[71].cy = 340-40;
		Group_BJD.bjd[71].rectWidth =40;
		Group_BJD.bjd[71].rectHeight = 40;
		Group_BJD.bjd[71].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[71].bBlink = false;
		Group_BJD.bjd[71].bRectLight = true;
		Group_BJD.bjd[71].drawGraph(canvas);
////////////////////////////////////////////////////////////////////////////////////////////////////////plc报警
		Group_BJD.bjd[0].cx = 1150;
		Group_BJD.bjd[0].cy = 850+50*1;
		Group_BJD.bjd[0].rectWidth = 40;
		Group_BJD.bjd[0].rectHeight = 40;
		Group_BJD.bjd[0].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[0].bBlink = false;
		Group_BJD.bjd[0].bRectLight = false;
		Group_BJD.bjd[0].name="NO.1 DG ABNORMAL TRIP";
		Group_BJD.bjd[0].drawGraph(canvas);
		
		Group_BJD.bjd[1].cx = 1150;
		Group_BJD.bjd[1].cy = 850+50*2;
		Group_BJD.bjd[1].rectWidth = 40;
		Group_BJD.bjd[1].rectHeight = 40;
		Group_BJD.bjd[1].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[1].bBlink = false;
		Group_BJD.bjd[1].bRectLight = false;
		Group_BJD.bjd[1].name="NO.2 DG ABNORMAL TRIP";
		Group_BJD.bjd[1].drawGraph(canvas);
		
		Group_BJD.bjd[2].cx = 1150;
		Group_BJD.bjd[2].cy = 850+50*3;
		Group_BJD.bjd[2].rectWidth = 40;
		Group_BJD.bjd[2].rectHeight = 40;
		Group_BJD.bjd[2].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[2].bBlink = false;
		Group_BJD.bjd[2].bRectLight = false;
		Group_BJD.bjd[2].name="AC415V INSULATION IS LOW";
		Group_BJD.bjd[2].drawGraph(canvas);
		
		Group_BJD.bjd[3].cx = 1150;
		Group_BJD.bjd[3].cy = 850+50*4;
		Group_BJD.bjd[3].rectWidth = 40;
		Group_BJD.bjd[3].rectHeight = 40;
		Group_BJD.bjd[3].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[3].bBlink = false;
		Group_BJD.bjd[3].bRectLight = false;
		Group_BJD.bjd[3].name="AC240V INSULATION IS LOW";
		Group_BJD.bjd[3].drawGraph(canvas);
		
		Group_BJD.bjd[5].cx = 1150;
		Group_BJD.bjd[5].cy = 850+50*5;
		Group_BJD.bjd[5].rectWidth = 40;
		Group_BJD.bjd[5].rectHeight = 40;
		Group_BJD.bjd[5].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[5].bBlink = false;
		Group_BJD.bjd[5].bRectLight = false;
		Group_BJD.bjd[5].name="DC24V INSULATION IS LOW";
		Group_BJD.bjd[5].drawGraph(canvas);
	
		Group_BJD.bjd[6].cx = 1150;
		Group_BJD.bjd[6].cy = 850+50*6;
		Group_BJD.bjd[6].rectWidth = 40;
		Group_BJD.bjd[6].rectHeight = 40;
		Group_BJD.bjd[6].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[6].bBlink = false;
		Group_BJD.bjd[6].bRectLight = false;
		Group_BJD.bjd[6].name="HGB/OTH L.O TEMP. HIGH";
		Group_BJD.bjd[6].drawGraph(canvas);
		
		Group_BJD.bjd[7].cx = 1150;
		Group_BJD.bjd[7].cy = 850+50*7;
		Group_BJD.bjd[7].rectWidth = 40;
		Group_BJD.bjd[7].rectHeight = 40;
		Group_BJD.bjd[7].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[7].bBlink = false;
		Group_BJD.bjd[7].bRectLight = false;
		Group_BJD.bjd[7].name="HGB/OTH L.O LOW PRESSURE";
		Group_BJD.bjd[7].drawGraph(canvas);
		
		Group_BJD.bjd[8].cx = 1150;
		Group_BJD.bjd[8].cy = 850+50*8;
		Group_BJD.bjd[8].rectWidth = 40;
		Group_BJD.bjd[8].rectHeight = 40;
		Group_BJD.bjd[8].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[8].bBlink = false;
		Group_BJD.bjd[8].bRectLight = false;
		Group_BJD.bjd[8].name="DGCB OVERTORUE OVERSLIP";
		Group_BJD.bjd[8].drawGraph(canvas);
		
		Group_BJD.bjd[9].cx = 1150;
		Group_BJD.bjd[9].cy = 850+50*9;
		Group_BJD.bjd[9].rectWidth = 40;
		Group_BJD.bjd[9].rectHeight = 40;
		Group_BJD.bjd[9].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[9].bBlink = false;
		Group_BJD.bjd[9].bRectLight = false;
		Group_BJD.bjd[9].name="DGCB L.O.TEMP. HIGH";
		Group_BJD.bjd[9].drawGraph(canvas);
		
		Group_BJD.bjd[10].cx = 1150;
		Group_BJD.bjd[10].cy = 850+50*10;
		Group_BJD.bjd[10].rectWidth = 40;
		Group_BJD.bjd[10].rectHeight = 40;
		Group_BJD.bjd[10].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[10].bBlink = false;
		Group_BJD.bjd[10].bRectLight = false;
		Group_BJD.bjd[10].name="DGCB L.O.LOW PRESS";
		Group_BJD.bjd[10].drawGraph(canvas);
		
		Group_BJD.bjd[11].cx = 1150;
		Group_BJD.bjd[11].cy = 850+50*11;
		Group_BJD.bjd[11].rectWidth = 40;
		Group_BJD.bjd[11].rectHeight = 40;
		Group_BJD.bjd[11].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[11].bBlink = false;
		Group_BJD.bjd[11].bRectLight = false;
		Group_BJD.bjd[11].name="DGCB AIR LOW PRESS";
		Group_BJD.bjd[11].drawGraph(canvas);
		
		Group_BJD.bjd[12].cx = 1150;
		Group_BJD.bjd[12].cy = 850+50*12;
		Group_BJD.bjd[12].rectWidth = 40;
		Group_BJD.bjd[12].rectHeight = 40;
		Group_BJD.bjd[12].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[12].bBlink = false;
		Group_BJD.bjd[12].bRectLight = false;
		Group_BJD.bjd[12].name="Front fuel tank (left) high level";
		Group_BJD.bjd[12].drawGraph(canvas);
		
		Group_BJD.bjd[13].cx = 1150;
		Group_BJD.bjd[13].cy = 850+50*13;
		Group_BJD.bjd[13].rectWidth = 40;
		Group_BJD.bjd[13].rectHeight = 40;
		Group_BJD.bjd[13].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[13].bBlink = false;
		Group_BJD.bjd[13].bRectLight = false;
		Group_BJD.bjd[13].name="Front fuel tank (right) high level";
		Group_BJD.bjd[13].drawGraph(canvas);
		
		Group_BJD.bjd[14].cx = 1150;
		Group_BJD.bjd[14].cy = 850+50*14;
		Group_BJD.bjd[14].rectWidth = 40;
		Group_BJD.bjd[14].rectHeight = 40;
		Group_BJD.bjd[14].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[14].bBlink = false;
		Group_BJD.bjd[14].bRectLight = false;
		Group_BJD.bjd[14].name="Rear fuel tank (left) high level";
		Group_BJD.bjd[14].drawGraph(canvas);//14
		
		Group_BJD.bjd[15].cx = 1900;
		Group_BJD.bjd[15].cy = 850+50*1;
		Group_BJD.bjd[15].rectWidth = 40;
		Group_BJD.bjd[15].rectHeight = 40;
		Group_BJD.bjd[15].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[15].bBlink = false;
		Group_BJD.bjd[15].bRectLight = false;
		Group_BJD.bjd[15].name="Rear fuel tank (right) high level";
		Group_BJD.bjd[15].drawGraph(canvas);
		
		Group_BJD.bjd[16].cx = 1900;
		Group_BJD.bjd[16].cy = 850+50*2;
		Group_BJD.bjd[16].rectWidth = 40;
		Group_BJD.bjd[16].rectHeight = 40;
		Group_BJD.bjd[16].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[16].bBlink = false;
		Group_BJD.bjd[16].bRectLight = false;
		Group_BJD.bjd[16].name="Dirty fuel tank high level";
		Group_BJD.bjd[16].drawGraph(canvas);
		
		Group_BJD.bjd[18].cx = 1900;
		Group_BJD.bjd[18].cy = 850+50*3;
		Group_BJD.bjd[18].rectWidth = 40;
		Group_BJD.bjd[18].rectHeight = 40;
		Group_BJD.bjd[18].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[18].bBlink = false;
		Group_BJD.bjd[18].bRectLight = false;
		Group_BJD.bjd[18].name="Bilge tank high level";
		Group_BJD.bjd[18].drawGraph(canvas);
		
		Group_BJD.bjd[19].cx = 1900;
		Group_BJD.bjd[19].cy = 850+50*4;
		Group_BJD.bjd[19].rectWidth = 40;
		Group_BJD.bjd[19].rectHeight = 40;
		Group_BJD.bjd[19].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[19].bBlink = false;
		Group_BJD.bjd[19].bRectLight = false;
		Group_BJD.bjd[19].name="Engine room bilge tank high level";
		Group_BJD.bjd[19].drawGraph(canvas);
		
		Group_BJD.bjd[22].cx = 1900;
		Group_BJD.bjd[22].cy = 850+50*5;
		Group_BJD.bjd[22].rectWidth = 40;
		Group_BJD.bjd[22].rectHeight = 40;
		Group_BJD.bjd[22].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[22].bBlink = false;
		Group_BJD.bjd[22].bRectLight = false;
		Group_BJD.bjd[22].name="#2 Generator stop";
		Group_BJD.bjd[22].drawGraph(canvas);//19
		
		Group_BJD.bjd[23].cx = 1900;
		Group_BJD.bjd[23].cy = 850+50*6;
		Group_BJD.bjd[23].rectWidth = 40;
		Group_BJD.bjd[23].rectHeight = 40;
		Group_BJD.bjd[23].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[23].bBlink = false;
		Group_BJD.bjd[23].bRectLight = false;
		Group_BJD.bjd[23].name="Freshwater tank low level";
		Group_BJD.bjd[23].drawGraph(canvas);
		
		Group_BJD.bjd[24].cx = 1900;
		Group_BJD.bjd[24].cy = 850+50*7;
		Group_BJD.bjd[24].rectWidth = 40;
		Group_BJD.bjd[24].rectHeight = 40;
		Group_BJD.bjd[24].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[24].bBlink = false;
		Group_BJD.bjd[24].bRectLight = false;
		Group_BJD.bjd[24].name="Daily use fuel tank low level";
		Group_BJD.bjd[24].drawGraph(canvas);
		
		Group_BJD.bjd[25].cx = 1900;
		Group_BJD.bjd[25].cy = 850+50*8;
		Group_BJD.bjd[25].rectWidth = 40;
		Group_BJD.bjd[25].rectHeight = 40;
		Group_BJD.bjd[25].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[25].bBlink = false;
		Group_BJD.bjd[25].bRectLight = false;
		Group_BJD.bjd[25].name="Hydraulic oil tank high level";
		Group_BJD.bjd[25].drawGraph(canvas);
	
		Group_BJD.bjd[26].cx = 1900;
		Group_BJD.bjd[26].cy = 850+50*9;
		Group_BJD.bjd[26].rectWidth = 40;
		Group_BJD.bjd[26].rectHeight = 40;
		Group_BJD.bjd[26].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[26].bBlink = false;
		Group_BJD.bjd[26].bRectLight = false;
		Group_BJD.bjd[26].name="Hydraulic oil tank low level";
		Group_BJD.bjd[26].drawGraph(canvas);
		
		Group_BJD.bjd[27].cx = 1900;
		Group_BJD.bjd[27].cy = 850+50*10;
		Group_BJD.bjd[27].rectWidth = 40;
		Group_BJD.bjd[27].rectHeight = 40;
		Group_BJD.bjd[27].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[27].bBlink = false;
		Group_BJD.bjd[27].bRectLight = false;
		Group_BJD.bjd[27].name="Hydraulic oil tank high temperature";
		Group_BJD.bjd[27].drawGraph(canvas);
		
		Group_BJD.bjd[72].cx = 1900;
		Group_BJD.bjd[72].cy = 850+50*11;
		Group_BJD.bjd[72].rectWidth = 40;
		Group_BJD.bjd[72].rectHeight = 40;
		Group_BJD.bjd[72].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[72].bBlink = false;
		Group_BJD.bjd[72].bRectLight = false;
		Group_BJD.bjd[72].name="Hydraulic oil Filter blocking";
		Group_BJD.bjd[72].drawGraph(canvas);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////
		// 模拟量

		GroupText.text[27].cx = 600-60; // 真空压力
		GroupText.text[27].cy = 460;
		GroupText.text[27].textSize = 30;
		GroupText.text[27].format = 2;
		GroupText.text[27].isFont_center2=true;
		GroupText.text[27].drawGraph(canvas);
	
		GroupText.text[28].cx = 1040-60; // 泥泵排出压力
		GroupText.text[28].cy = 460;
		GroupText.text[28].textSize = 30;
		GroupText.text[28].format = 2;
		GroupText.text[28].isFont_center2=true;
		GroupText.text[28].drawGraph(canvas);
		
		GroupText.text[26].cx = 1050-60; // 水下泵封水压力
		GroupText.text[26].cy = 270;
		GroupText.text[26].textSize = 30;
		GroupText.text[26].format = 2;
		GroupText.text[26].isFont_center2=true;
		GroupText.text[26].drawGraph(canvas);
		
		GroupText.text[23].cx = 1800-40; 
		GroupText.text[23].cy = 840-25-120;
		GroupText.text[23].textSize = 30;
		GroupText.text[23].format = 0;
		GroupText.text[23].isFont_center2=true;
		GroupText.text[23].drawGraph(canvas);//斗轮油压
		
		GroupText.text[24].cx = 2300-40; 
		GroupText.text[24].cy = 840-25-120;
		GroupText.text[24].textSize = 30;
		GroupText.text[24].format = 0;
		GroupText.text[24].isFont_center2=true;
		GroupText.text[24].drawGraph(canvas);//横移油压
		
		GroupText.text[25].cx = 1800-40; 
		GroupText.text[25].cy = 840-25-45;
		GroupText.text[25].textSize = 30;
		GroupText.text[25].format = 0;
		GroupText.text[25].isFont_center2=true;
		GroupText.text[25].drawGraph(canvas);//其他油压
		
		GroupText.text[30].cx = 2300-40; 
		GroupText.text[30].cy = 840-25-45;
		GroupText.text[30].textSize = 30;
		GroupText.text[30].format = 0;
		GroupText.text[30].isFont_center2=true;
		GroupText.text[30].drawGraph(canvas);//台车行程
		
		GroupText.text[31].cx = 1370-20; 
		GroupText.text[31].cy = 450;
		GroupText.text[31].textSize = 30;
		GroupText.text[31].format = 2;
		GroupText.text[31].isFont_center2=true;
		GroupText.text[31].drawGraph(canvas);//浓度

		GroupText.text[32].cx = 1370-20;
		GroupText.text[32].cy = 500;
		GroupText.text[32].textSize = 30;
		GroupText.text[32].format = 2;
		GroupText.text[32].isFont_center2=true;
		GroupText.text[32].drawGraph(canvas);//流速

		///new
		GroupText.text[100].cx = 490;
		GroupText.text[100].cy = 575;
		GroupText.text[100].textSize = 30;
		GroupText.text[100].format = 2;
		GroupText.text[100].isFont_center2=true;
		GroupText.text[100].drawGraph(canvas);//尾矿池液位

		GroupText.text[101].cx = 490;
		GroupText.text[101].cy = 625;
		GroupText.text[101].textSize = 30;
		GroupText.text[101].format = 2;
		GroupText.text[101].isFont_center2=true;
		GroupText.text[101].drawGraph(canvas);//精矿产量

		GroupText.text[102].cx = 490;
		GroupText.text[102].cy = 675;
		GroupText.text[102].textSize = 30;
		GroupText.text[102].format = 2;
		GroupText.text[102].isFont_center2=true;
		GroupText.text[102].drawGraph(canvas);//尾矿泵压力

		GroupText.text[103].cx = 490;
		GroupText.text[103].cy = 725;
		GroupText.text[103].textSize = 30;
		GroupText.text[103].format = 1;
		GroupText.text[103].isFont_center2=true;
		GroupText.text[103].drawGraph(canvas);//尾矿泵转速
		
		Paint paint = new Paint(); // 新建画笔
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStrokeWidth(2); // 设置画笔的宽度
		paint.setStyle(Paint.Style.STROKE);

		// 写文本
		paint.setStrokeWidth(1); // 设置画笔的宽度
		paint.setStyle(Paint.Style.FILL);
		paint.setTextAlign(Align.CENTER);
		paint.setColor(Color.rgb(131, 175, 155));//说明
		paint.setTextSize(28);
		canvas.drawText("Suction Vacuum", 500,  410, paint);
		canvas.drawText("Exhaust Pressure", 950,  410, paint);
		canvas.drawText("Hydraulic Pump Diesel Engine", 1860+140,  605, paint);
		canvas.drawText("Emergency", 1610+60,  430-150, paint);
		canvas.drawText("Bucket Wheel Oil Pressure", 1800, 840-25-150, paint);//斗轮油压
		canvas.drawText("Sidesway Oil Pressure", 2300,  840-25-150, paint);//横移油压
	    canvas.drawText("Other Oil Pressure", 1800,  840-25-75, paint);//其他油压
		canvas.drawText("Carrier Distance", 2300,  840-25-75, paint);//台车行程
		canvas.drawText("Concentration", 1370-160, 450, paint);//浓度
		canvas.drawText("Flow Speed", 1370-160, 500, paint);//流速
		canvas.drawText("Fire", 1320+50, 860-150, paint);//消防泵Fire pump

		//new
		paint.setTextAlign(Align.RIGHT);//左对齐部分
		canvas.drawText("Surge Bin Level", 450-30,  575, paint);//尾矿池液位
		canvas.drawText("Final Product Tonnage", 450-30,  625, paint);//精矿产量
		canvas.drawText("Tailing Pump Pressure", 450-30,  675, paint);//尾矿泵压力
		canvas.drawText("Tailing Pump HZ", 450-30,  725, paint);//尾矿泵转速
		
		paint.setTextAlign(Align.LEFT);//左对齐部分
		canvas.drawText("Bridge Winch Up Limit", 1200-150-950, 848+700, paint);//桥架上限位
		canvas.drawText("Steel Pile Carrier", 1740+30,  280, paint);//台车 钢桩
		canvas.drawText("Main Spud Hoist", 2000+150,  120, paint);//主钢桩起升
		canvas.drawText("Main Spud Lower", 2000+150,  120+60*1, paint);//主钢桩下降
		canvas.drawText("Auxiliary Spud Hoist", 2000+150,  120+60*2, paint);//副钢桩起升
		canvas.drawText("Auxiliary Spud Lower", 2000+150,  120+60*3, paint);//副钢桩下降
		canvas.drawText("Steel Pile Carrier Forward", 2000+150,  120+60*4, paint);//台车油缸伸出
		canvas.drawText("Steel Pile Carrier Astern", 2000+150,  120+60*5, paint);//台车油缸缩回
		canvas.drawText("Carrier Forward Limit", 2000+150,  120+60*6, paint);//台车油缸伸出限位
		canvas.drawText("Carrier Astern Limit", 2000+150,  120+60*7, paint);//台车油缸缩回限位
		canvas.drawText("Sealing Water Pressure：", 840,  270-25, paint);//封水压力
		canvas.drawText("Bucket Wheel Positive", 260,  192, paint);//斗轮正转
		canvas.drawText("Bucket Wheel Negative", 260,  273, paint);//斗轮反转
		canvas.drawText("Sluice Valve Open", Group_BJD.bjd[70].cx+30, Group_BJD.bjd[70].cy+10, paint);
		canvas.drawText("Sluice Valve Close", Group_BJD.bjd[71].cx+30, Group_BJD.bjd[71].cy+10, paint);
		
		
		paint.setTextAlign(Align.LEFT);//单位
		paint.setTextSize(30);
		paint.setColor(Color.rgb(138, 151, 123));//单位
		canvas.drawText("bar", 600,  460, paint);  //真空
		canvas.drawText("bar", 1040,  460, paint);//排压
		canvas.drawText("Mpa", 1800+20, 840-25-120, paint);//1
		canvas.drawText("Mpa", 2300+20, 840-25-120, paint);//2
		canvas.drawText("Mpa", 1800+20,  840-25-45, paint);//3
		canvas.drawText("m", 2300+20,  840-25-45, paint);//4
		canvas.drawText("bar", 1050,  270, paint);//封水油压
		canvas.drawText("t/m3", 1370+50, 450, paint);//产量
		canvas.drawText("m/s", 1370+50, 500, paint);//流速

		///new
		canvas.drawText("m",530+30,575,paint);///尾矿池液位
		canvas.drawText("t/h",530+30,625,paint);///精矿产量
		canvas.drawText("Mpa",530+30,675,paint);///尾矿泵压力
		canvas.drawText("Hz",530+30,725,paint);///尾矿泵转速
		/////////////////plc报警

		paint.setStyle(Style.FILL);
		paint.setTextAlign(Align.CENTER);
		paint.setTextSize(30);

		paint.setColor(Color.GREEN);//标题
		canvas.drawText("PLC Collection Box Alarm", 1900	, 850, paint);
		paint.setTextAlign(Align.LEFT);
		paint.setColor(Color.rgb(222, 156, 83));
		canvas.drawText("NO.1 DG ABNORMAL TRIP", 1200, 12+850+50*1, paint);
		canvas.drawText("NO.2 DG ABNORMAL TRIP", 1200, 12+850+50*2, paint);
		canvas.drawText("AC415V INSULATION IS LOW", 1200, 12+850+50*3, paint);
		canvas.drawText("AC240V INSULATION IS LOW", 1200, 12+850+50*4, paint);
		canvas.drawText("DC24V INSULATION IS LOW", 1200, 12+850+50*5, paint);
		canvas.drawText("HGB/OTH L.O TEMP. HIGH", 1200, 12+850+50*6, paint);
		canvas.drawText("HGB/OTH L.O LOW PRESSURE", 1200, 12+850+50*7, paint);
		canvas.drawText("DGCB OVERTORUE OVERSLIP", 1200, 12+850+50*8, paint);
		canvas.drawText("DGCB L.O.TEMP. HIGH", 1200, 12+850+50*9, paint);
		canvas.drawText("DGCB L.O.LOW PRESS", 1200, 12+850+50*10, paint);
		canvas.drawText("DGCB AIR LOW PRESS", 1200, 12+850+50*11, paint);
		canvas.drawText("NO.1 F.O  TANK HIGH LEVEL(P)", 1200, 12+850+50*12, paint);
		canvas.drawText("NO.1 F.O  TANK HIGH LEVEL(S)", 1200, 12+850+50*13, paint);
		canvas.drawText("NO.2 F.O  TANK HIGH LEVEL(P)", 1200, 12+850+50*14, paint);
		
		canvas.drawText("NO.2 F.O  TANK HIGH LEVEL(S)", 1950, 7+850+50*1, paint);	
		canvas.drawText("DIRTY OIL TANK HIGH LEVEL", 1950, 7+850+50*2, paint);
		canvas.drawText("BILGE TANK NIGN LEVEL", 1950, 7+850+50*3, paint);
		canvas.drawText("ENGINE ROOM BILGE TANK HIGH LEVEL", 1950, 7+850+50*4, paint);
		canvas.drawText("#2 GENERATOR STOP", 1950, 7+850+50*5, paint);
		canvas.drawText("F.W TANK LOW LEVER", 1950, 7+850+50*6, paint);
		canvas.drawText("SERVICE OIL TANK LOW LEVEL", 1950, 7+850+50*7, paint);
		canvas.drawText("HYDRAULIC OIL TANK LOW LEVER", 1950, 7+850+50*8, paint);
		canvas.drawText("HYDRAULIC OIL TANK LOW LOW LEVER", 1950, 7+850+50*9, paint);
		canvas.drawText("HYDRAULIC OIL TANK HIGH TEMP.", 1950, 7+850+50*10, paint);
		canvas.drawText("HYDRAULIC OIL TANK", 1950, 7+850+50*11, paint);


		paint.setColor(Color.GREEN);
		paint.setTextAlign(Align.CENTER);
		paint.setTextSize(40);
		canvas.drawText("Yield",1320+50,860-150+50,paint);
		paint.setColor(Color.YELLOW);
		paint.setTextSize(50);
//		canvas.drawText((((GroupText.text[31].sValue-Density.Waterdensity)/(Density.Soildensity-Density.Waterdensity)*100)/100)*(GroupText.text[32].sValue *3.1415926*0.5*0.5/4*3600)+"  t",1320+50,860-150+100,paint);

		Density.Hourlyyield=(((GroupText.text[31].sValue-Density.Waterdensity)/(Density.Soildensity-Density.Waterdensity)*100)/100)*(GroupText.text[32].sValue *3.1415926*Density.Pipediameter*Density.Pipediameter/4*3600);
		canvas.drawText((int)Density.Hourlyyield+"  t",1320+50,860-150+100,paint);
		//////////////////////////////////////////////////////////////////////////////////
		paint.setTextAlign(Align.LEFT);
		paint.setColor(Color.YELLOW);	
		paint.setTextSize(30);
		canvas.drawText("Page 1:", 10, 30, paint);
		paint.setColor(Color.GREEN);
		canvas.drawText("Dredging Process", 120, 30, paint);
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