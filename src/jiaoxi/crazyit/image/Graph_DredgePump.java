package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Paint.Style;

public class Graph_DredgePump {
	public float cx = 50;       //中心点X
	public float cy = 50;       //中心点Y
	public float rectWidth = 30;  //矩形宽度
	public float rectHeight = 20;  //矩形高度
	public float rotateAngle = 0;     //旋转角度
	public boolean choiced = false;  //是否被选中
	public boolean bCtrlInthisWnd = false;   //在窗口中是否被允许控制
	public boolean bShowLeft = false;  //是否在左边显示
	public boolean bBlinkStatus = false;  //闪烁标志
	public String sText= "";    //泥泵名称
	public boolean compelling = false;  //强制执行
	public boolean starting = false;     //正在执行运行指令
	public boolean stoping = false;      //正在执行停止指令
	public boolean run_status = false;   //运行状态
	public boolean stop_status = false;  //停止运行
	public boolean run_fail = false;     //执行运行失败
	public boolean stop_fail = false;    //执行停止失败
	public boolean rtu_sign = false;     //RTU信号
	public boolean reset = false;        //复位信号
	float rectX[] = new float[4];  //矩形四个点的横坐标
	float rectY[] = new float[4];  //矩形四个点的纵坐标
	
	float ptX[] = new float[10];
	float ptY[] = new float[10];
	
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//使用抗锯齿功能
		//paint.setStyle(Paint.Style.FILL);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(2);
		
		rectX[0] = cx- rectWidth/2;
		rectY[0] = cy-rectHeight/2;
		rectX[1] = cx - rectWidth/2;
		rectY[1] = cy + rectHeight/2;
		rectX[2] = cx + rectWidth/2;
		rectY[2] = cy + rectHeight/2;
		rectX[3] = cx + rectWidth/2;
		rectY[3] = cy - rectHeight/2;
		

		
		ptX[0] = rectX[0];
		ptY[0] = rectY[0];
		ptX[1] = rectX[1];
		ptY[1] = rectY[1];
		ptX[2] = rectX[2];
		ptY[2] = rectY[2];
		ptX[3] = rectX[3];
		ptY[3] = rectY[3];
		
		//Path path = new Path();
		int color = 0;
		canvas.save();
		canvas.rotate(-rotateAngle, cx, cy);
		//设备被强制
		if (compelling) {
			color = Color.argb(255, 255, 0, 0);
			paint.setColor(color); 
			canvas.drawLine(rectX[0], rectY[0], rectX[1], rectY[1], paint);
			canvas.drawLine(rectX[1], rectY[1], rectX[2], rectY[2], paint);
			canvas.drawLine(rectX[2], rectY[2], rectX[3], rectY[3], paint);
			canvas.drawLine(rectX[3], rectY[3], rectX[0], rectY[0], paint);
		}
		//泵口是否左边显示
		if (bShowLeft) {
			ptX[4] = ptX[0];
			ptY[4] = ptY[0] + rectHeight * 10/25;
			ptX[5] = ptX[1];
			ptY[5] = ptY[1] - rectHeight * 2/10;
			ptX[6] = ptX[4] - rectWidth * 2/10;
			ptY[6] = ptY[4];
			ptX[7] = ptX[5] - rectWidth * 2/10;
			ptY[7] = ptY[5];
			ptX[8] = ptX[6];
			ptY[8] = ptY[6] - rectHeight * 15/250;
			ptX[9] = ptX[7];
			ptY[9] = ptY[7] + rectHeight * 15/250;
		}
		else {
			ptX[4] = ptX[3];
			ptY[4] = ptY[3] + rectHeight * 10/25;
			ptX[5] = ptX[2];
			ptY[5] = ptY[2] - rectHeight * 2/10;
			ptX[6] = ptX[4] + rectWidth * 2/10;
			ptY[6] = ptY[4];
			ptX[7] = ptX[5] + rectWidth * 2/10;
			ptY[7] = ptY[5];
			ptX[8] = ptX[6];
			ptY[8] = ptY[6] - rectHeight * 15/250;
			ptX[9] = ptX[7];
			ptY[9] = ptY[7] + rectHeight * 15/250;
		}
		//停止指令动作
		if (stoping) {
			if (bBlinkStatus) {
				color = Color.argb(255, 128, 128, 128);
			}
			else {
				color = Color.argb(255, 192, 192, 192);
			}
		}
		//启动命令动作
		else if (starting) {
			if (bBlinkStatus) {
				color = Color.argb(255, 0, 255, 0);
			}
			else {
				color = Color.argb(255, 192, 192, 192);
			}
		}
		else {
			if (run_status) {
				color = Color.argb(255, 0, 255, 0);
			}
			else if (stop_status) {
				color = Color.argb(255, 192, 192, 192);
			}
			else {
				color = Color.argb(255, 192, 192, 192);
			}
		}
		
	
		

		RectF outRect = new RectF();
		outRect.left = cx - rectWidth/2;
		outRect.top = cy - rectHeight/2 - rectWidth/2;
		outRect.right = cx + rectWidth/2;
		outRect.bottom = cy - rectHeight/2+ rectWidth/2;
		RectF tempRect = new RectF();
		tempRect.left = cx - rectWidth/2;
		tempRect.top = cy + rectHeight/2 - rectWidth/2;
		tempRect.right = cx + rectWidth/2;
		tempRect.bottom = cy + rectHeight/2 + rectWidth/2;
		//内圈
		RectF inRect = new RectF();
		inRect.left = outRect.left + rectWidth/6;
		inRect.top = outRect.top + rectWidth/6;
		inRect.right = outRect.left  + rectWidth*5/6;
		inRect.bottom = outRect.top + rectWidth*5/6;
		
		paint.setColor(color);
		paint.setStyle(Paint.Style.FILL);  //椭圆填充
		canvas.drawOval(inRect, paint);
		
		paint.setStyle(Style.STROKE);
		canvas.drawOval(inRect, paint);
		canvas.drawOval(outRect, paint);
		//连线
		canvas.drawArc(tempRect, 0, 180, false, paint);
		canvas.drawLine(ptX[1], ptY[1], ptX[0], ptY[0], paint);
		canvas.drawLine(ptX[3], ptY[3], ptX[2], ptY[2], paint);
		canvas.drawLine(ptX[4], ptY[4], ptX[6], ptY[6], paint);
		canvas.drawLine(ptX[5], ptY[5], ptX[7], ptY[7], paint);
		canvas.drawLine(ptX[9], ptY[9], ptX[8], ptY[8], paint);
		
		if (run_fail || stop_fail) {
			color = Color.argb(255, 128, 0, 0);
			paint.setColor(color);
			canvas.drawArc(tempRect, 0, 180, false, paint);
			canvas.drawLine(ptX[1], ptY[1], ptX[0], ptY[0], paint);
			canvas.drawLine(ptX[3], ptY[3], ptX[2], ptY[2], paint);
			canvas.drawLine(ptX[4], ptY[4], ptX[6], ptY[6], paint);
			canvas.drawLine(ptX[5], ptY[5], ptX[7], ptY[7], paint);
			canvas.drawLine(ptX[9], ptY[9], ptX[8], ptY[8], paint);
			if (rtu_sign) {
				color = Color.argb(255, 255, 255, 0);
				paint.setColor(color);
			}
			else {
				color = Color.argb(255, 128, 0, 0);
				paint.setColor(color);
			}
			canvas.drawOval(outRect, paint);
		}
		
		if (reset) {
			color = Color.argb(255, 0, 0, 255);
			paint.setColor(color);
			canvas.drawOval(inRect, paint);
			canvas.drawOval(outRect, paint);
		}
		
		canvas.restore();
	}
}
