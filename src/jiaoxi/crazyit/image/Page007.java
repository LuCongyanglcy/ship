package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class Page007 {

	public static void DrawPage(Canvas canvas) {
		RectF rectf = new RectF();
		//侧视图
		GroupPipeSide.pipeside[0].cx = 550;
		GroupPipeSide.pipeside[0].cz = 380;
		GroupPipeSide.pipeside[0].rectWidth = 520;
		GroupPipeSide.pipeside[0].rectHeight = 300;
		GroupPipeSide.pipeside[0].rightgray = true;
		GroupPipeSide.pipeside[0].switchdirection = false;
		GroupPipeSide.pipeside[0].suction = 4;
		GroupPipeSide.pipeside[0].grayunder = 8;
		GroupPipeSide.pipeside[0].grayhigher = 1;
		GroupPipeSide.pipeside[0].lesty = 5;
		GroupPipeSide.pipeside[0].drawGraph(canvas);
		
		GroupPipeSide.pipeside[1].cx = 700;
		GroupPipeSide.pipeside[1].cz = 380;
		GroupPipeSide.pipeside[1].rectWidth = 520;
		GroupPipeSide.pipeside[1].rectHeight = 300;
		GroupPipeSide.pipeside[1].rightgray = false;
		GroupPipeSide.pipeside[1].switchdirection = true;
		GroupPipeSide.pipeside[1].suction = 4;
		GroupPipeSide.pipeside[1].grayunder = 8;
		GroupPipeSide.pipeside[1].grayhigher = 1;
		GroupPipeSide.pipeside[1].lesty = 5;
		GroupPipeSide.pipeside[1].drawGraph(canvas);
		//俯视图
		GroupTopView.pipetop[0].cx = 50;
		GroupTopView.pipetop[0].cy = 50;
		GroupTopView.pipetop[0].width = 50;
		GroupTopView.pipetop[0].height = 50;
		GroupTopView.pipetop[0].width = 50;
		GroupTopView.pipetop[0].width = 50;
		GroupTopView.pipetop[0].width = 50;
		GroupTopView.pipetop[0].width = 50;		
		GroupTopView.pipetop[0].width = 50;
		
		GoupButtons.button[0].cx = 52;
		GoupButtons.button[0].cy = 775;
		GoupButtons.button[0].rectWidth = 104;
		GoupButtons.button[0].rectHeight = 50;
		GoupButtons.button[0].distance_centerX = 15;
		GoupButtons.button[0].blinkStatus = true;
		GoupButtons.button[0].sText = "";
		GoupButtons.button[0].drawGraph(canvas);
		
		GoupButtons.button[1].cx = 156;
		GoupButtons.button[1].cy = 775;
		GoupButtons.button[1].rectWidth = 104;
		GoupButtons.button[1].rectHeight = 50;
		GoupButtons.button[1].blinkStatus = true;
		GoupButtons.button[1].sText = "";
		GoupButtons.button[1].drawGraph(canvas);
		
		GoupButtons.button[2].cx = 260;
		GoupButtons.button[2].cy = 775;
		GoupButtons.button[2].rectWidth = 104;
		GoupButtons.button[2].rectHeight = 50;
		GoupButtons.button[2].blinkStatus = true;
		GoupButtons.button[2].sText = "";
		GoupButtons.button[2].drawGraph(canvas);
		
		GoupButtons.button[3].cx = 364;
		GoupButtons.button[3].cy = 775;
		GoupButtons.button[3].rectWidth = 104;
		GoupButtons.button[3].rectHeight = 50;
		GoupButtons.button[3].blinkStatus = true;
		GoupButtons.button[3].sText = "";
		GoupButtons.button[3].drawGraph(canvas);
		
		GoupButtons.button[4].cx = 484;
		GoupButtons.button[4].cy = 775;
		GoupButtons.button[4].rectWidth = 104;
		GoupButtons.button[4].rectHeight = 50;
		GoupButtons.button[4].distance_centerX = 25;
		GoupButtons.button[4].blinkStatus = true;
		GoupButtons.button[4].sText = "";
		GoupButtons.button[4].drawGraph(canvas);
		
		GoupButtons.button[5].cx = 588;
		GoupButtons.button[5].cy = 775;
		GoupButtons.button[5].rectWidth = 104;
		GoupButtons.button[5].rectHeight = 50;
		GoupButtons.button[5].blinkStatus = true;
		GoupButtons.button[5].sText = "";
		GoupButtons.button[5].drawGraph(canvas);
		
		GoupButtons.button[6].cx = 692;
		GoupButtons.button[6].cy = 775;
		GoupButtons.button[6].rectWidth = 104;
		GoupButtons.button[6].rectHeight = 50;
		GoupButtons.button[6].blinkStatus = true;
		GoupButtons.button[6].sText = "";
		GoupButtons.button[6].drawGraph(canvas);
		
		GoupButtons.button[7].cx = 796;
		GoupButtons.button[7].cy = 775;
		GoupButtons.button[7].rectWidth = 104;
		GoupButtons.button[7].rectHeight = 50;
		GoupButtons.button[7].blinkStatus = true;
		GoupButtons.button[7].sText = "";
		GoupButtons.button[7].drawGraph(canvas);

		
		GoupButtons.button[8].cx = 916;
		GoupButtons.button[8].cy = 775;
		GoupButtons.button[8].rectWidth = 104;
		GoupButtons.button[8].rectHeight = 50;
		GoupButtons.button[8].distance_centerX = 15;
		GoupButtons.button[8].blinkStatus = true;
		GoupButtons.button[8].sText = "";
		GoupButtons.button[8].drawGraph(canvas);
		
		GoupButtons.button[9].cx = 1020;
		GoupButtons.button[9].cy = 775;
		GoupButtons.button[9].rectWidth = 104;
		GoupButtons.button[9].rectHeight = 50;
		GoupButtons.button[9].blinkStatus = true;
		GoupButtons.button[9].sText = "";
		GoupButtons.button[9].drawGraph(canvas);
		
		GoupButtons.button[10].cx = 1124;
		GoupButtons.button[10].cy = 775;
		GoupButtons.button[10].rectWidth = 104;
		GoupButtons.button[10].rectHeight = 50;
		GoupButtons.button[10].blinkStatus = true;
		GoupButtons.button[10].sText = "";
		GoupButtons.button[10].drawGraph(canvas);
		
		GoupButtons.button[11].cx = 1228;
		GoupButtons.button[11].cy = 775;
		GoupButtons.button[11].rectWidth = 104;
		GoupButtons.button[11].rectHeight = 50;
		GoupButtons.button[11].blinkStatus = true;
		GoupButtons.button[11].sText = "";
		GoupButtons.button[11].drawGraph(canvas);
		

		GoupShowButtons.Showbutton[0].cx = 104;
		GoupShowButtons.Showbutton[0].cy = 725;
		GoupShowButtons.Showbutton[0].rectWidth = 208;
		GoupShowButtons.Showbutton[0].rectHeight = 50;
		GoupShowButtons.Showbutton[0].distance_centerX = 30;
		GoupShowButtons.Showbutton[0].sText = "";
		GoupShowButtons.Showbutton[0].drawGraph(canvas);
		
		GoupShowButtons.Showbutton[1].cx = 312;
		GoupShowButtons.Showbutton[1].cy = 725;
		GoupShowButtons.Showbutton[1].rectWidth = 208;
		GoupShowButtons.Showbutton[1].rectHeight = 50;
		GoupShowButtons.Showbutton[1].sText = "";
		GoupShowButtons.Showbutton[1].drawGraph(canvas);
		
		GoupShowButtons.Showbutton[2].cx = 536;
		GoupShowButtons.Showbutton[2].cy = 725;
		GoupShowButtons.Showbutton[2].rectWidth = 208;
		GoupShowButtons.Showbutton[2].rectHeight = 50;
		GoupShowButtons.Showbutton[2].distance_centerX = 50;
		GoupShowButtons.Showbutton[2].sText = "";
		GoupShowButtons.Showbutton[2].drawGraph(canvas);
		
		GoupShowButtons.Showbutton[3].cx = 744;
		GoupShowButtons.Showbutton[3].cy = 725;
		GoupShowButtons.Showbutton[3].rectWidth = 208;
		GoupShowButtons.Showbutton[3].rectHeight = 50;
		GoupShowButtons.Showbutton[3].sText = "";
		GoupShowButtons.Showbutton[3].drawGraph(canvas);
		
		GoupShowButtons.Showbutton[4].cx = 968;
		GoupShowButtons.Showbutton[4].cy = 725;
		GoupShowButtons.Showbutton[4].rectWidth = 208;
		GoupShowButtons.Showbutton[4].rectHeight = 50;
		GoupShowButtons.Showbutton[4].sText = "";
		GoupShowButtons.Showbutton[4].drawGraph(canvas);
		
		GoupShowButtons.Showbutton[5].cx = 1176;
		GoupShowButtons.Showbutton[5].cy = 725;
		GoupShowButtons.Showbutton[5].rectWidth = 208;
		GoupShowButtons.Showbutton[5].rectHeight = 50;
		GoupShowButtons.Showbutton[5].sText = "";
		GoupShowButtons.Showbutton[5].drawGraph(canvas);
			
		Paint paint = new Paint(); // 新建画笔
		paint.setAntiAlias(true); // 使用抗锯齿功能			
		paint.setStrokeWidth(1); // 设置画笔的宽度
		paint.setColor(Color.YELLOW);
		paint.setTextSize(30);
		canvas.drawText("耙臂姿态画面", 20, 30, paint);
	}
}
