package jiaoxi.crazyit.image;

import jiaoxi.crazyit.image.GroupCutter;
import jiaoxi.crazyit.image.GroupDiesel;
import jiaoxi.crazyit.image.GroupDredgePump;
import jiaoxi.crazyit.image.GroupElectric;
import jiaoxi.crazyit.image.GroupHDPump;
import jiaoxi.crazyit.image.GroupLine;
import jiaoxi.crazyit.image.GroupRuler;
import jiaoxi.crazyit.image.GroupText;
import jiaoxi.crazyit.image.Group_BJD;
import jiaoxi.crazyit.image.NewGroupValves;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
///////////绞吸界面1
public class Page011 {

	public static void DrawPage(Canvas canvas) {
		RectF rectf = new RectF();
//		GateValveActivity.bmp1;
		canvas.drawBitmap(GateValveActivity.bmp1, 2240, 440, null);        //配电板
		canvas.drawBitmap(GateValveActivity.bmp2, 1760, 80, null);        //台车
		canvas.drawBitmap(GateValveActivity.bmp4, 735, 610, null);        //变频器

//		canvas.drawBitmap(GateValveActivity.bmp5, 100, 1000, null);        //桥架切换
//		canvas.drawBitmap(GateValveActivity.bmp6, 100, 1000, null);        //桥架切换
//		//柴油机
//		GroupDiesel.diese.cx = 1800;
//		GroupDiesel.diese.cy = 310;
//		GroupDiesel.diese.rectHeight = 280;
//		GroupDiesel.diese.rectWidth = 300;			
//		GroupDiesel.diese.num = 5;
//		GroupDiesel.diese.drawGraph(canvas);
		//绞刀头
		GroupCutterWheel.cutterwheel.cx = 240;
		GroupCutterWheel.cutterwheel.cy = 420;
		GroupCutterWheel.cutterwheel.rectHeight = 200;
		GroupCutterWheel.cutterwheel.rectWidth = 200;	
		GroupCutterWheel.cutterwheel.drawGraph(canvas);
        //桥架		
		GroupCutter2.cutter2.cx = 20;
		GroupCutter2.cutter2.cy = 835;
		GroupCutter2.cutter2.rectWidth = 1370;
		GroupCutter2.cutter2.rectHeight = 690;
//		GroupCutter2.cutter2.rotateAngle = 10;
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
		

		 //液压泵
		GroupHDPump.hdpump[0].cx = 1680;   //1#液压泵
		GroupHDPump.hdpump[0].cy = 510;
		GroupHDPump.hdpump[0].rectWidth = 100;
		GroupHDPump.hdpump[0].rectHeight = 100;
		GroupHDPump.hdpump[0].rotateAngle = 90;
		GroupHDPump.hdpump[0].bArc = false;
		GroupHDPump.hdpump[0].blink_sign = false;
		GroupHDPump.hdpump[0].szText = "1#液压泵";
		GroupHDPump.hdpump[0].drawGraph(canvas);
						
		//封水泵
		GroupHDPump.hdpump[1].cx = 950;   //1#液压泵
		GroupHDPump.hdpump[1].cy = 170;
		GroupHDPump.hdpump[1].rectWidth = 100;
		GroupHDPump.hdpump[1].rectHeight = 100;
		GroupHDPump.hdpump[1].bArc = true;
		GroupHDPump.hdpump[1].blink_sign = false;
		GroupHDPump.hdpump[1].szText = "封水泵";
		GroupHDPump.hdpump[1].drawGraph(canvas);
		//线条
		GroupLine.line[1].startX = 250;    //绞刀到水下泵
		GroupLine.line[1].startY = 420;
		GroupLine.line[1].endX = 720;
		GroupLine.line[1].endY = 420;
		GroupLine.line[1].lineWidth = 6;
		GroupLine.line[1].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[1].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[1].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[1].drawGraph(canvas);
		
		GroupLine.line[1].startX = 820;    //
		GroupLine.line[1].startY = 400;
		GroupLine.line[1].endX = 1100;
		GroupLine.line[1].endY = 400;
		GroupLine.line[1].lineWidth = 6;
		GroupLine.line[1].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[1].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[1].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[1].drawGraph(canvas);
		
		GroupLine.line[1].startX = 1356;    //
		GroupLine.line[1].startY = 320;
		GroupLine.line[1].endX = 1180;
		GroupLine.line[1].endY = 320;
		GroupLine.line[1].lineWidth = 6;
		GroupLine.line[1].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[1].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[1].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[1].drawGraph(canvas);
		
		GroupLine.line[1].startX = 1140;    //
		GroupLine.line[1].startY = 360;
		GroupLine.line[1].endX = 1100;
		GroupLine.line[1].endY = 400;
		GroupLine.line[1].lineWidth = 6;
		GroupLine.line[1].bArc = true;
		GroupLine.line[1].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[1].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[1].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[1].drawGraph(canvas);
		
		GroupLine.line[1].startX = 1140;    //
		GroupLine.line[1].startY = 360;
		GroupLine.line[1].endX = 1180;
		GroupLine.line[1].endY = 320;
		GroupLine.line[1].lineWidth = 6;
		GroupLine.line[1].bArc = true;
		GroupLine.line[1].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[1].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[1].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[1].drawGraph(canvas);
		
		GroupLine.line[9].startX = 760;    //变频器到水下泵
		GroupLine.line[9].startY = 530;
		GroupLine.line[9].endX = 760;
		GroupLine.line[9].endY = 610;
		GroupLine.line[9].lineWidth = 6;
		GroupLine.line[9].bArc = false;
		GroupLine.line[9].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[9].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[9].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[9].drawGraph(canvas);
		
		GroupLine.line[2].startX = 1730;    //柴油机和泵站连接
		GroupLine.line[2].startY = 510;
		GroupLine.line[2].endX = 1810;
		GroupLine.line[2].endY = 510;
		GroupLine.line[2].lineWidth = 6;
		GroupLine.line[2].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[2].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[2].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[2].drawGraph(canvas);
		
		GroupLine.line[2].startX = 2090;    //柴油机和配电板连接
		GroupLine.line[2].startY = 510;
		GroupLine.line[2].endX = 2240;
		GroupLine.line[2].endY = 510;
		GroupLine.line[2].lineWidth = 6;
		GroupLine.line[2].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[2].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[2].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[2].drawGraph(canvas);
		
		GroupLine.line[3].startX = 1630;    //泵站出口连接
		GroupLine.line[3].startY = 510;
		GroupLine.line[3].endX = 1540;
		GroupLine.line[3].endY = 510;
		GroupLine.line[3].lineWidth = 6;
		GroupLine.line[3].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[3].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[3].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[3].drawGraph(canvas);
		
		GroupLine.line[3].startX = 1540;    //泵站出口连接
		GroupLine.line[3].startY = 140;
		GroupLine.line[3].endX = 1540;
		GroupLine.line[3].endY = 660;
		GroupLine.line[3].lineWidth = 6;
		GroupLine.line[3].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[3].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[3].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[3].drawGraph(canvas);
		
		GroupLine.line[4].startX = 1500;    //泵站出口和绞刀连接
		GroupLine.line[4].startY = 100;
		GroupLine.line[4].endX = 1540;
		GroupLine.line[4].endY = 140;
		GroupLine.line[4].lineWidth = 6;
		GroupLine.line[4].bArc = true;
		GroupLine.line[4].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[4].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[4].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[4].drawGraph(canvas);
				
		GroupLine.line[4].startX = 1500;    //泵站出口和绞刀连接
		GroupLine.line[4].startY = 100;
		GroupLine.line[4].endX = 1240;
		GroupLine.line[4].endY = 100;
		GroupLine.line[4].lineWidth = 6;
		GroupLine.line[4].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[4].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[4].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[4].drawGraph(canvas);
		
		GroupLine.line[5].startX = 1540;    //泵站出口和水下泵连接
		GroupLine.line[5].startY = 660;
		GroupLine.line[5].endX = 1500;
		GroupLine.line[5].endY = 700;
		GroupLine.line[5].lineWidth = 6;
		GroupLine.line[5].bArc = true;
		GroupLine.line[5].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[5].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[5].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[5].drawGraph(canvas);
		
		GroupLine.line[5].startX = 1500;    //泵站出口和水下泵连接
		GroupLine.line[5].startY = 700;
		GroupLine.line[5].endX = 1240;
		GroupLine.line[5].endY = 700;
		GroupLine.line[5].lineWidth = 6;
		GroupLine.line[5].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[5].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[5].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[5].drawGraph(canvas);
		
		GroupLine.line[6].startX = 1540;    //泵站出口和台车连接
		GroupLine.line[6].startY = 180;
		GroupLine.line[6].endX = 1800;
		GroupLine.line[6].endY = 180;
		GroupLine.line[6].lineWidth = 6;
		GroupLine.line[6].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[6].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[6].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[6].drawGraph(canvas);
		
		GroupLine.line[7].startX = 900;    //封水泵到水下泵连接
		GroupLine.line[7].startY = 170;
		GroupLine.line[7].endX = 800;
		GroupLine.line[7].endY = 170;
		GroupLine.line[7].lineWidth = 6;
		GroupLine.line[7].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[7].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[7].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[7].drawGraph(canvas);
		
		GroupLine.line[7].startX = 760;    //封水泵到水下泵连接
		GroupLine.line[7].startY = 210;
		GroupLine.line[7].endX = 800;
		GroupLine.line[7].endY = 170;
		GroupLine.line[7].lineWidth = 6;
		GroupLine.line[7].bArc = true;
		GroupLine.line[7].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[7].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[7].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[7].drawGraph(canvas);
		
		GroupLine.line[7].startX = 760;    //封水泵到水下泵连接
		GroupLine.line[7].startY = 210;
		GroupLine.line[7].endX = 760;
		GroupLine.line[7].endY = 270;
		GroupLine.line[7].lineWidth = 6;
		GroupLine.line[7].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[7].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[7].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[7].drawGraph(canvas);
//		
//		GroupLine.line[7].startX = 1800;    //泵站出口和侧推连接
//		GroupLine.line[7].startY = 700;
//		GroupLine.line[7].endX = 1980;
//		GroupLine.line[7].endY = 700;
//		GroupLine.line[7].lineWidth = 6;
//		GroupLine.line[7].color1 = Color.argb(255, 0, 255, 0);
//		GroupLine.line[7].color2 = Color.argb(255, 255, 0, 0);
//		GroupLine.line[7].color3 = Color.argb(255, 0, 0, 255);
//		GroupLine.line[7].drawGraph(canvas);
		
		GroupLine.line[8].startX = 1540;    //泵站出口和绞车连接
		GroupLine.line[8].startY = 440;
		GroupLine.line[8].endX = 1240;
		GroupLine.line[8].endY = 440;
		GroupLine.line[8].lineWidth = 6;
		GroupLine.line[8].color1 = Color.argb(255, 0, 255, 0);
		GroupLine.line[8].color2 = Color.argb(255, 255, 0, 0);
		GroupLine.line[8].color3 = Color.argb(255, 0, 0, 255);
		GroupLine.line[8].drawGraph(canvas);
		//右下角 报警灯
		Group_BJD.bjd[8].cx = 1500;
		Group_BJD.bjd[8].cy = 1200+50*0;
		Group_BJD.bjd[8].rectWidth = 40;
		Group_BJD.bjd[8].rectHeight = 40;
		Group_BJD.bjd[8].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[8].bBlink = false;
		Group_BJD.bjd[8].bRectLight = false;
		Group_BJD.bjd[8].drawGraph(canvas);

		Group_BJD.bjd[9].cx = 1500;
		Group_BJD.bjd[9].cy = 1200+50*1;
		Group_BJD.bjd[9].rectWidth = 40;
		Group_BJD.bjd[9].rectHeight = 40;
		Group_BJD.bjd[9].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[9].bBlink = false;
		Group_BJD.bjd[9].bRectLight = false;
		Group_BJD.bjd[9].drawGraph(canvas);

		Group_BJD.bjd[10].cx = 1500;
		Group_BJD.bjd[10].cy = 1200+50*2;
		Group_BJD.bjd[10].rectWidth = 40;
		Group_BJD.bjd[10].rectHeight = 40;
		Group_BJD.bjd[10].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[10].bBlink = false;
		Group_BJD.bjd[10].bRectLight = false;
		Group_BJD.bjd[10].drawGraph(canvas);
		
		Group_BJD.bjd[21].cx = 1500;
		Group_BJD.bjd[21].cy = 1200+50*3;
		Group_BJD.bjd[21].rectWidth = 40;
		Group_BJD.bjd[21].rectHeight = 40;
		Group_BJD.bjd[21].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[21].bBlink = false;
		Group_BJD.bjd[21].bRectLight = false;
		Group_BJD.bjd[21].drawGraph(canvas);

		Group_BJD.bjd[22].cx = 1500;
		Group_BJD.bjd[22].cy = 1200+50*4;
		Group_BJD.bjd[22].rectWidth = 40;
		Group_BJD.bjd[22].rectHeight = 40;
		Group_BJD.bjd[22].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[22].bBlink = false;
		Group_BJD.bjd[22].bRectLight = false;
		Group_BJD.bjd[22].drawGraph(canvas);

		Group_BJD.bjd[23].cx = 1500;
		Group_BJD.bjd[23].cy = 1200+50*5;
		Group_BJD.bjd[23].rectWidth = 40;
		Group_BJD.bjd[23].rectHeight = 40;
		Group_BJD.bjd[23].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[23].bBlink = false;
		Group_BJD.bjd[23].bRectLight = false;
		Group_BJD.bjd[23].drawGraph(canvas);

		Group_BJD.bjd[20].cx = 1500;
		Group_BJD.bjd[20].cy = 1200+50*6;
		Group_BJD.bjd[20].rectWidth = 40;
		Group_BJD.bjd[20].rectHeight = 40;
		Group_BJD.bjd[20].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[20].bBlink = false;
		Group_BJD.bjd[20].bRectLight = false;
		Group_BJD.bjd[20].drawGraph(canvas);

		Group_BJD.bjd[19].cx = 1500;
		Group_BJD.bjd[19].cy = 1200+50*7;
		Group_BJD.bjd[19].rectWidth = 40;
		Group_BJD.bjd[19].rectHeight = 40;
		Group_BJD.bjd[19].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[19].bBlink = false;
		Group_BJD.bjd[19].bRectLight = false;
		Group_BJD.bjd[19].drawGraph(canvas);

		
		Group_BJD.bjd[24].cx = 1950;
		Group_BJD.bjd[24].cy = 1200+50*0;
		Group_BJD.bjd[24].rectWidth = 40;
		Group_BJD.bjd[24].rectHeight = 40;
		Group_BJD.bjd[24].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[24].bBlink = false;
		Group_BJD.bjd[24].bRectLight = false;
		Group_BJD.bjd[24].drawGraph(canvas);

		Group_BJD.bjd[25].cx = 1950;
		Group_BJD.bjd[25].cy = 1200+50*1;
		Group_BJD.bjd[25].rectWidth = 40;
		Group_BJD.bjd[25].rectHeight = 40;
		Group_BJD.bjd[25].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[25].bBlink = false;
		Group_BJD.bjd[25].bRectLight = false;
		Group_BJD.bjd[25].drawGraph(canvas);

		Group_BJD.bjd[26].cx = 1950;
		Group_BJD.bjd[26].cy = 1200+50*2;
		Group_BJD.bjd[26].rectWidth =40;
		Group_BJD.bjd[26].rectHeight = 40;
		Group_BJD.bjd[26].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[26].bBlink = false;
		Group_BJD.bjd[26].bRectLight = false;
		Group_BJD.bjd[26].drawGraph(canvas);
		
		Group_BJD.bjd[27].cx = 1950;
		Group_BJD.bjd[27].cy = 1200+50*3;
		Group_BJD.bjd[27].rectWidth = 40;
		Group_BJD.bjd[27].rectHeight = 40;
		Group_BJD.bjd[27].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[27].bBlink = false;
		Group_BJD.bjd[27].bRectLight = false;
		Group_BJD.bjd[27].drawGraph(canvas);

		Group_BJD.bjd[28].cx = 1950;
		Group_BJD.bjd[28].cy = 1200+50*4;
		Group_BJD.bjd[28].rectWidth = 40;
		Group_BJD.bjd[28].rectHeight = 40;
		Group_BJD.bjd[28].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[28].bBlink = false;
		Group_BJD.bjd[28].bRectLight = false;
		Group_BJD.bjd[28].drawGraph(canvas);

		Group_BJD.bjd[29].cx = 1950;
		Group_BJD.bjd[29].cy = 1200+50*5;
		Group_BJD.bjd[29].rectWidth =40;
		Group_BJD.bjd[29].rectHeight = 40;
		Group_BJD.bjd[29].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[29].bBlink = false;
		Group_BJD.bjd[29].bRectLight = false;
		Group_BJD.bjd[29].drawGraph(canvas);
		
		Group_BJD.bjd[30].cx = 1950;
		Group_BJD.bjd[30].cy = 1200+50*6;
		Group_BJD.bjd[30].rectWidth =40;
		Group_BJD.bjd[30].rectHeight = 40;
		Group_BJD.bjd[30].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[30].bBlink = false;
		Group_BJD.bjd[30].bRectLight = false;
		Group_BJD.bjd[30].drawGraph(canvas);
		
		Group_BJD.bjd[31].cx = 1950;
		Group_BJD.bjd[31].cy = 1200+50*7;
		Group_BJD.bjd[31].rectWidth =40;
		Group_BJD.bjd[31].rectHeight = 40;
		Group_BJD.bjd[31].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[31].bBlink = false;
		Group_BJD.bjd[31].bRectLight = false;
		Group_BJD.bjd[31].drawGraph(canvas);
		
		
		Group_BJD.bjd[16].cx = 1170;//桥架上限位
		Group_BJD.bjd[16].cy = 835;
		Group_BJD.bjd[16].rectWidth =40;
		Group_BJD.bjd[16].rectHeight = 40;
		Group_BJD.bjd[16].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[16].bBlink = false;
		Group_BJD.bjd[16].bRectLight = false;
		Group_BJD.bjd[16].drawGraph(canvas);

		//显示灯状态灯
		Group_BJD.bjd[5].cx = 1970;   //主钢桩升起
		Group_BJD.bjd[5].cy = 110+60*0;
		Group_BJD.bjd[5].rectWidth = 40;
		Group_BJD.bjd[5].rectHeight = 40;
		Group_BJD.bjd[5].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[5].bBlink = false;
		Group_BJD.bjd[5].bRectLight = true;
		Group_BJD.bjd[5].drawGraph(canvas);

		Group_BJD.bjd[4].cx = 1970;   //主钢桩下降
		Group_BJD.bjd[4].cy = 110+60*1;
		Group_BJD.bjd[4].rectWidth = 40;
		Group_BJD.bjd[4].rectHeight = 40;
		Group_BJD.bjd[4].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[4].bBlink = false;
		Group_BJD.bjd[4].bRectLight = true;
		Group_BJD.bjd[4].drawGraph(canvas);

		Group_BJD.bjd[7].cx = 1970;   //辅钢桩升起
		Group_BJD.bjd[7].cy = 110+60*2;
		Group_BJD.bjd[7].rectWidth = 40;
		Group_BJD.bjd[7].rectHeight = 40;
		Group_BJD.bjd[7].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[7].bBlink = false;
		Group_BJD.bjd[7].bRectLight = true;
		Group_BJD.bjd[7].drawGraph(canvas);

		Group_BJD.bjd[6].cx = 1970;   //辅钢桩下降
		Group_BJD.bjd[6].cy = 110+60*3;
		Group_BJD.bjd[6].rectWidth = 40;
		Group_BJD.bjd[6].rectHeight = 40;
		Group_BJD.bjd[6].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[6].bBlink = false;
		Group_BJD.bjd[6].bRectLight = true;
		Group_BJD.bjd[6].drawGraph(canvas);

		Group_BJD.bjd[0].cx = 2230;  //台车油缸伸出
		Group_BJD.bjd[0].cy = 110+60*0;
		Group_BJD.bjd[0].rectWidth = 40;
		Group_BJD.bjd[0].rectHeight = 40;
		Group_BJD.bjd[0].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[0].bBlink = false;
		Group_BJD.bjd[0].bRectLight = true;
		Group_BJD.bjd[0].drawGraph(canvas);

		Group_BJD.bjd[1].cx = 2230;  //台车油缸缩回
		Group_BJD.bjd[1].cy = 110+60*1;
		Group_BJD.bjd[1].rectWidth = 40;
		Group_BJD.bjd[1].rectHeight = 40;
		Group_BJD.bjd[1].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[1].bBlink = false;
		Group_BJD.bjd[1].bRectLight = true;
		Group_BJD.bjd[1].drawGraph(canvas);
		
		Group_BJD.bjd[14].cx = 2230;  //台车油缸伸出限位
		Group_BJD.bjd[14].cy = 110+60*2;
		Group_BJD.bjd[14].rectWidth = 40;
		Group_BJD.bjd[14].rectHeight = 40;
		Group_BJD.bjd[14].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[14].bBlink = false;
		Group_BJD.bjd[14].bRectLight = false;
		Group_BJD.bjd[14].drawGraph(canvas);

		Group_BJD.bjd[15].cx = 2230;  //台车油缸缩回限位
		Group_BJD.bjd[15].cy = 110+60*3;
		Group_BJD.bjd[15].rectWidth = 40;
		Group_BJD.bjd[15].rectHeight = 40;
		Group_BJD.bjd[15].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[15].bBlink = false;
		Group_BJD.bjd[15].bRectLight = false;
		Group_BJD.bjd[15].drawGraph(canvas);
		
		Group_BJD.bjd[2].cx = 210;   //绞刀正传
		Group_BJD.bjd[2].cy = 180;
		Group_BJD.bjd[2].rectWidth = 46;
		Group_BJD.bjd[2].rectHeight = 46;
		Group_BJD.bjd[2].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[2].bBlink = false;
		Group_BJD.bjd[2].bRectLight = true;
		Group_BJD.bjd[2].drawGraph(canvas);

		Group_BJD.bjd[3].cx = 210;    //绞刀反传
		Group_BJD.bjd[3].cy = 260;
		Group_BJD.bjd[3].rectWidth = 46;
		Group_BJD.bjd[3].rectHeight = 46;
		Group_BJD.bjd[3].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[3].bBlink = false;
		Group_BJD.bjd[3].bRectLight = true;
		Group_BJD.bjd[3].drawGraph(canvas);
		
		Group_BJD.bjd[11].cx = 890;   //变频器备妥
		Group_BJD.bjd[11].cy = 625;
		Group_BJD.bjd[11].rectWidth = 40;
		Group_BJD.bjd[11].rectHeight = 40;
		Group_BJD.bjd[11].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[11].bBlink = false;
		Group_BJD.bjd[11].bRectLight = true;
		Group_BJD.bjd[11].drawGraph(canvas);

		Group_BJD.bjd[12].cx = 890;    //变频器运行
		Group_BJD.bjd[12].cy = 675;
		Group_BJD.bjd[12].rectWidth = 40;
		Group_BJD.bjd[12].rectHeight = 40;
		Group_BJD.bjd[12].color_status = Color.argb(255, 0, 255, 0);
		Group_BJD.bjd[12].bBlink = false;
		Group_BJD.bjd[12].bRectLight = true;
		Group_BJD.bjd[12].drawGraph(canvas);
		
		Group_BJD.bjd[13].cx = 890;   //变频器故障
		Group_BJD.bjd[13].cy = 725;
		Group_BJD.bjd[13].rectWidth = 40;
		Group_BJD.bjd[13].rectHeight = 40;
		Group_BJD.bjd[13].color_status = Color.argb(255, 255, 0, 0);
		Group_BJD.bjd[13].bBlink = false;
		Group_BJD.bjd[13].bRectLight = true;
		Group_BJD.bjd[13].drawGraph(canvas);

		// 标尺
		GroupRuler.ruler[10].cx = 1500; //横移
		GroupRuler.ruler[10].cy = 870;
		GroupRuler.ruler[10].rectHeight = 240;
		GroupRuler.ruler[10].rectWidth = 150;
		GroupRuler.ruler[10].higherDepth = 40;
		GroupRuler.ruler[10].underDepth = 0;
		GroupRuler.ruler[10].rulerhigher = 40;
		GroupRuler.ruler[10].rulerunder = 0;
		GroupRuler.ruler[10].rulermain = 8;
		GroupRuler.ruler[10].rulersecond = 4;
		GroupRuler.ruler[10].switchdirection = false;
		GroupRuler.ruler[10].drawGraph(canvas);

		GroupRuler.ruler[4].cx = 1700 ; //水下泵电机电流
		GroupRuler.ruler[4].cy = 870 ;
		GroupRuler.ruler[4].rectHeight = 240;
		GroupRuler.ruler[4].rectWidth = 150;
		GroupRuler.ruler[4].higherDepth = 500;
		GroupRuler.ruler[4].underDepth = 0;
		GroupRuler.ruler[4].rulerhigher = 500;
		GroupRuler.ruler[4].rulerunder = 0;
		GroupRuler.ruler[4].rulermain = 5;
		GroupRuler.ruler[4].rulersecond = 4;
		GroupRuler.ruler[4].switchdirection = false;
		GroupRuler.ruler[4].drawGraph(canvas);

		GroupRuler.ruler[11].cx = 1900 ;//绞刀压力
		GroupRuler.ruler[11].cy = 870 ;
		GroupRuler.ruler[11].rectHeight = 240;
		GroupRuler.ruler[11].rectWidth = 150;
		GroupRuler.ruler[11].higherDepth = 40;
		GroupRuler.ruler[11].underDepth = 0;
		GroupRuler.ruler[11].rulerhigher = 40;
		GroupRuler.ruler[11].rulerunder = 0;
		GroupRuler.ruler[11].rulermain = 8;
		GroupRuler.ruler[11].rulersecond = 4;
		GroupRuler.ruler[11].switchdirection = false;
		GroupRuler.ruler[11].drawGraph(canvas);
		
		GroupRuler.ruler[9].cx = 2120 ; //杂用压力
		GroupRuler.ruler[9].cy = 870 ;
		GroupRuler.ruler[9].rectHeight = 240;
		GroupRuler.ruler[9].rectWidth = 150;
		GroupRuler.ruler[9].higherDepth = 40;
		GroupRuler.ruler[9].underDepth = 0;
		GroupRuler.ruler[9].rulerhigher = 40;
		GroupRuler.ruler[9].rulerunder = 0;
		GroupRuler.ruler[9].rulermain = 8;
		GroupRuler.ruler[9].rulersecond = 4;
		GroupRuler.ruler[9].switchdirection = false;
		GroupRuler.ruler[9].drawGraph(canvas);
		
		GroupRuler.ruler[7].cx = 2360 ; //台车行程
		GroupRuler.ruler[7].cy = 870 ;
		GroupRuler.ruler[7].rectHeight = 240;
		GroupRuler.ruler[7].rectWidth = 150;
		GroupRuler.ruler[7].higherDepth = 3;
		GroupRuler.ruler[7].underDepth = 0;
		GroupRuler.ruler[7].rulerhigher = 3;
		GroupRuler.ruler[7].rulerunder = 0;
		GroupRuler.ruler[7].rulermain = 6;
		GroupRuler.ruler[7].rulersecond = 2;
		GroupRuler.ruler[7].switchdirection = false; 
		GroupRuler.ruler[7].drawGraph(canvas);

		// 模拟量
		GroupText.text[10].cx = 1480; // 横移绞车油压
		GroupText.text[10].cy = 1180;
		GroupText.text[10].textSize = 36;
		GroupText.text[10].format = 0;
		GroupText.text[10].drawGraph(canvas);

		GroupText.text[4].cx = 1670; // 水下泵电机电流
		GroupText.text[4].cy = 1180;
		GroupText.text[4].textSize = 36;
		GroupText.text[4].format = 0;
		GroupText.text[4].drawGraph(canvas);

		GroupText.text[11].cx = 1860; // 绞刀压力
		GroupText.text[11].cy = 1180;
		GroupText.text[11].textSize = 36;
		GroupText.text[11].format = 1;
		GroupText.text[11].drawGraph(canvas);

		GroupText.text[9].cx = 2100; // 杂用油压信号
		GroupText.text[9].cy = 1180;
		GroupText.text[9].textSize = 36;
		GroupText.text[9].format = 1;
		GroupText.text[9].drawGraph(canvas);

		GroupText.text[7].cx = 2320; //台车行程
		GroupText.text[7].cy = 1180;
		GroupText.text[7].textSize = 36;
		GroupText.text[7].format = 2;
		GroupText.text[7].drawGraph(canvas);

		GroupText.text[6].cx = 510; // 真空压力
		GroupText.text[6].cy = 480;
		GroupText.text[6].textSize = 40;
		GroupText.text[6].format = 1;
		GroupText.text[6].drawGraph(canvas);
	
		GroupText.text[5].cx = 940; // 泥泵排出压力
		GroupText.text[5].cy = 460;
		GroupText.text[5].textSize = 40;
		GroupText.text[5].format = 1;
		GroupText.text[5].drawGraph(canvas);

		GroupText.text[11].cx = 270; // 绞刀工作压力
		GroupText.text[11].cy = 610;
		GroupText.text[11].textSize = 40;
		GroupText.text[11].format = 1;
		GroupText.text[11].drawGraph(canvas);
		
		GroupText.text[12].cx = 270; // 绞刀行程
		GroupText.text[12].cy = 660;
		GroupText.text[12].textSize = 40;
		GroupText.text[12].format = 1;
		GroupText.text[12].drawGraph(canvas);
		
		GroupText.text[8].cx = 980; // 水下泵封水压力
		GroupText.text[8].cy = 285;
		GroupText.text[8].textSize = 30;
		GroupText.text[8].format = 1;
		GroupText.text[8].drawGraph(canvas);
		
		GroupText.text[13].cx = 210; // 桥架角度
		GroupText.text[13].cy = 1340;
		GroupText.text[13].textSize = 40;
		GroupText.text[13].format = 1;
		GroupText.text[13].drawGraph(canvas);
		
		GroupText.text[26].cx = 210; // 绞刀角度
		GroupText.text[26].cy = 1420;
		GroupText.text[26].textSize = 40;
		GroupText.text[26].format = 1;
		GroupText.text[26].drawGraph(canvas); 	
		
		GroupText.text[12].cx = 210; // 油缸行程
		GroupText.text[12].cy = 1500;
		GroupText.text[12].textSize = 40;
		GroupText.text[12].format = 2;
		GroupText.text[12].drawGraph(canvas);
		
		Paint paint = new Paint(); // 新建画笔
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStrokeWidth(2); // 设置画笔的宽度
		paint.setStyle(Paint.Style.STROKE);
		
		// 画矩形框
		RectF rectf1 = new RectF(10, 10, 2550, 1590);
		RectF rectf2 = new RectF(10, 10, 2550, 800);
		RectF rectf3 = new RectF(10, 800, 1400, 1590);

		paint.setColor(Color.YELLOW);
		canvas.drawRect(rectf1, paint);
		canvas.drawRect(rectf2, paint);
		canvas.drawRect(rectf3, paint);

		// 写文本
		paint.setStrokeWidth(1); // 设置画笔的宽度
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(Color.LTGRAY);
		paint.setTextSize(37);	
		canvas.drawText("桥架上限位", 1200, 848, paint);
		
		canvas.drawText("液压油液位低",1540, 1212+50*0, paint);
	    canvas.drawText("液压油油温高",1540, 1212+50*1, paint);
		canvas.drawText("液压油滤器堵", 1540, 1212+50*2, paint);
		canvas.drawText("380V绝缘低", 1540, 1212+50*3, paint);
		canvas.drawText("220V绝缘低", 1540, 1212+50*4, paint);
		canvas.drawText("DC24V绝缘低", 1540, 1212+50*5, paint);
	    canvas.drawText("停泊发电机过载",1540, 1212+50*6, paint);
	    canvas.drawText("#2作业发电机过载",1540, 1212+50*7, paint);
		
	    canvas.drawText("停泊发电机旁控制箱综合报警",2000, 1212+50*0, paint);
		canvas.drawText("2#发电机机旁控制箱综合报警", 2000, 1212+50*1, paint);
		canvas.drawText("变频控制柜综合报警", 2000, 1212+50*2, paint);
		canvas.drawText("机舱舱底水液位高报警", 2000, 1212+50*3, paint);
		canvas.drawText("水下电机舱舱底水液位高报警", 2000, 1212+50*4, paint);
	    canvas.drawText("污油舱液位高报警",2000, 1212+50*5, paint);
		canvas.drawText("水下泵电机舱水位高报警", 2000, 1212+50*6, paint);
	    canvas.drawText("水下泵电机温度高报警",2000, 1212+50*7, paint);
		
		canvas.drawText("桥架角度：", 30, 1320, paint);
		canvas.drawText("绞刀角度：", 30, 1400, paint);
		canvas.drawText("油缸行程：", 30, 1480, paint);
		
		canvas.drawText("°", 290, 1320, paint);
		canvas.drawText("°", 290, 1400, paint);
		canvas.drawText("m", 300, 1480, paint);
		paint.setTextSize(36);
		canvas.drawText("横移油压", 1430, 840, paint);
		canvas.drawText("水下泵电流", 1630,  840, paint);
	    canvas.drawText("绞刀压力", 1850,  840, paint);
		canvas.drawText("杂用油压", 2050,  840, paint);
		canvas.drawText("台车行程", 2300,  840, paint);
		
		paint.setTextSize(30);
		canvas.drawText("Mpa", 1550, 1150, paint);
		canvas.drawText("A", 1750,  1150, paint);
		canvas.drawText("Mpa", 1950,  1150, paint);
		canvas.drawText("Mpa", 2180,  1150, paint);
		canvas.drawText("m", 2420,  1150, paint);
		
		paint.setTextSize(40);
//		canvas.drawText("水下泵", 710,  260, paint);
		canvas.drawText("吸入真空", 500,  410, paint);
		canvas.drawText("排出压力", 920,  390, paint);
		canvas.drawText("主发柴油机", 1860,  605, paint);
		canvas.drawText("配电板", 2310,  610, paint);
		canvas.drawText("液压泵站", 1610,  430, paint);
		canvas.drawText("台车/钢桩", 1740,  280, paint);
//		canvas.drawText("侧推", 2100,  710, paint);
		canvas.drawText("至绞刀", 1320,  140, paint);
		canvas.drawText("至绞车", 1320,  420, paint);
		canvas.drawText("至水下泵", 1320,  680, paint);
		
		canvas.drawText("油压：", 160,  584, paint);//绞刀
		canvas.drawText("行程：", 160,  640, paint);//绞刀		
		canvas.drawText("绞刀正转", 260,  192, paint);
		canvas.drawText("绞刀反转", 260,  273, paint);
		
		paint.setTextSize(30);
		canvas.drawText("封水压力：", 840,  270, paint);//封水泵
		canvas.drawText("Mpa", 1050,  270, paint);//封水油压
		paint.setTextSize(30);
		canvas.drawText("备妥", 940,  635, paint);
		canvas.drawText("运行", 940,  685, paint);
		canvas.drawText("故障", 940,  735, paint);
		
		paint.setTextSize(36);
		canvas.drawText("主钢桩起升", 2000,  120, paint);
		canvas.drawText("主钢桩下降", 2000,  120+60*1, paint);
		canvas.drawText("辅钢桩起升", 2000,  120+60*2, paint);
		canvas.drawText("辅钢桩下降", 2000,  120+60*3, paint);
		canvas.drawText("台车油缸伸出", 2260,  120+60*0, paint);
		canvas.drawText("台车油缸缩回", 2260,  120+60*1, paint);	
		canvas.drawText("台车油缸伸出限位", 2260,  120+60*2, paint);
		canvas.drawText("台车油缸缩回限位", 2260,  120+60*3, paint);	
		
		paint.setTextSize(40);
		canvas.drawText("bar", 600,  460, paint);  //真空
		canvas.drawText("bar", 1040,  440, paint);//排压
		canvas.drawText("Mpa", 360,  590, paint);//绞刀油压
		canvas.drawText("m", 360,  640, paint);//绞刀行程
		
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
//		if(NewMyService.serverconect)
//		{
//			paint.setColor(Color.GREEN);
//			canvas.drawText("连接", 1820,  50, paint);
//		}
//		else
//		{
//			paint.setColor(Color.RED);
//	    	canvas.drawText("断开", 1820,  50, paint);
//		}
		paint.setColor(Color.YELLOW);
		canvas.drawText("SD卡剩余容量: "+GateValveActivity.SdVolume+" MB", 1440,  50, paint);		
		paint.setStyle(Paint.Style.FILL);
		paint.setStrokeWidth(3);
		canvas.drawLine(10, 60, 2550, 60, paint);
		//画出口线段
		paint.setColor(Color.GRAY);
		paint.setStrokeWidth(3);
		paint.setStyle(Paint.Style.FILL);
		canvas.drawLine(1356, 320, 1306, 290, paint);//排泥出口
		canvas.drawLine(1356, 320, 1306, 350, paint);
		
		canvas.drawLine(1240, 100, 1280, 70, paint);//到绞刀
		canvas.drawLine(1240, 100, 1280, 130, paint);
		canvas.drawLine(1240, 440, 1280, 410, paint);//到绞车
		canvas.drawLine(1240, 440, 1280, 470, paint);
		canvas.drawLine(1240, 700, 1280, 670, paint);//到水下泵
		canvas.drawLine(1240, 700, 1280, 730, paint);
		
		
		if(GateValveActivity.control_limite)
		{
			canvas.drawBitmap(GateValveActivity.bmp5, 80, 1080, null);
		}
		else
		{
			canvas.drawBitmap(GateValveActivity.bmp6, 80, 1080, null);
		}
	}
}
