package jiaoxi.crazyit.image;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import jiaoxi.crazyit.sql.*;

//画圆形灯
public class Graph_BJD {
	public float cx = 50;  //中心点X
	public float cy = 50;  //中心点Y
	public float rectWidth = 50;
	public float rectHeight = 50;
	public boolean blink_sign = false;  // 标志位，绘图使用，从视图类传递参数过来
	public float rotateAngle = 0;
	public float rectX[] = new float[4];
	public float rectY[] = new float[4];
	public boolean alarm_status = false;  //状态位
	public boolean ack_status = false;    //响应位
	public boolean show_status = false;  //运行指示状态
	public boolean bBlink = true;       //是否闪烁
	public int color_status = Color.argb(255, 255, 0, 0);  //状态颜色
	public boolean bRectLight = false;
	
	

	
	//2018/2/1 吴
	public boolean temp = false;//正在报警
//	private boolean lasttemp = false;
	public String name= "";

	public void drawGraph(Canvas canvas) {
		
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//使用抗锯齿功能
		paint.setStyle(Paint.Style.FILL);
		
		rectX[0] = cx - rectWidth/2;
		rectY[0] = cy - rectHeight/2;
		rectX[1] = cx - rectWidth/2;
		rectY[1] = cy + rectHeight/2;
		rectX[2] = cx + rectWidth/2;
		rectY[2] = cy + rectHeight/2;
		rectX[3] = cx + rectWidth/2;
		rectY[3] = cy - rectHeight/2;
		
		int color = 0;
		if (bRectLight == false) {
			color = Color.argb(255, 192, 192, 192);
			paint.setColor(color);
			RectF drawRect = new RectF();
			drawRect.left = rectX[0];
			drawRect.top = (float) (rectY[0] + 0.88 * rectHeight);
			drawRect.right = rectX[2];
			drawRect.bottom = rectY[2];
			canvas.drawOval(drawRect, paint);
			
			drawRect.left = rectX[0];
			drawRect.top = (float) (rectY[0] + 0.82 * rectHeight);
			drawRect.right = rectX[2];
			drawRect.bottom = (float) (rectY[0] + 0.94 * rectHeight);
			canvas.drawRect(drawRect, paint);
			
			if ((alarm_status && ack_status)|| show_status) {
				color = color_status;
			}
			else if (alarm_status){
				if (bBlink) {
					if (blink_sign){
						color = color_status;
					}
					else {
						color = Color.argb(255, 192, 192, 192);
					}
				}
				else {
					color = color_status;
				}
			}
			else {
				color = Color.argb(255, 192, 192, 192);
			}
			//颜色选好了
			drawRect.left = (float) (rectX[0] + 0.15*rectWidth);
			drawRect.right = (float) (rectX[0] + 0.85*rectWidth);
			drawRect.top = (float) (rectY[0] + 0.35 * rectWidth);
			drawRect.bottom = (float) (drawRect.bottom - 0.06 * rectHeight);
			paint.setColor(color);
			canvas.drawRect(drawRect, paint);
			int color1 =  Color.argb(255, 192, 192, 192);
			paint.setColor(color1);
			canvas.drawLine(drawRect.left, drawRect.top, drawRect.left, drawRect.bottom, paint);
			canvas.drawLine(drawRect.right, drawRect.top, drawRect.right, drawRect.bottom, paint);
			paint.setColor(color);
			drawRect.left = (float) (rectX[0] + 0.15*rectWidth);
			drawRect.right = (float) (rectX[0] + 0.85*rectWidth);
			drawRect.top = rectY[0];
			drawRect.bottom = (float) (rectY[0] + 0.7 * rectHeight);
			canvas.drawRoundRect(drawRect, rectWidth/2, rectHeight/2, paint);
			paint.setStyle(Style.STROKE);
			paint.setStrokeWidth(1);
			color = Color.argb(255, 192, 192, 192);
			canvas.drawOval(drawRect, paint);
			
			drawRect.left = (float) (rectX[0] + 0.15*rectWidth);
			drawRect.right = (float) (rectX[0] + 0.85*rectWidth);
			drawRect.top = (float) (rectY[0] + 0.35 * rectWidth);
			drawRect.bottom = (float) (rectY[2] - 0.12 * rectHeight);
			canvas.drawRect(drawRect, paint);
			float CenterX = cx;
			float CenterY = (float) (rectY[0] + 0.35 *rectHeight);
			float ptX[] = new float[6];
			float ptY[] = new float[6];
			ptX[0]=CenterX-(int)(Math.cos(80*3.1415926/180)*0.35*rectWidth*0.75);
			ptY[0]=CenterY-(int)(Math.sin(80*3.1415926/180)*0.35*rectWidth*0.75);
			ptX[1]=CenterX-(int)(Math.cos(45*3.1415926/180)*0.35*rectWidth*0.75);
			ptY[1]=CenterY-(int)(Math.sin(45*3.1415926/180)*0.35*rectWidth*0.75);
			ptX[2]=CenterX-(int)(Math.cos(30*3.1415926/180)*0.35*rectWidth*0.7);
			ptY[2]=CenterY-(int)(Math.sin(30*3.1415926/180)*0.35*rectWidth*0.7);
			ptX[3]=CenterX-(int)(Math.cos(0*3.1415926/180)*0.35*rectWidth*0.6);
			ptY[3]=CenterY-(int)(Math.sin(0*3.1415926/180)*0.35*rectWidth*0.6);
			ptX[4]=CenterX-(int)(Math.cos(40*3.1415926/180)*0.35*rectWidth*0.5);
			ptY[4]=CenterY-(int)(Math.sin(40*3.1415926/180)*0.35*rectWidth*0.5);
			ptX[5]=CenterX-(int)(Math.cos(90*3.1415926/180)*0.35*rectWidth*0.55);
			ptY[5]=CenterY-(int)(Math.sin(90*3.1415926/180)*0.35*rectWidth*0.55);
			
			Path path = new Path();
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[1], ptY[1]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[4], ptY[4]);
			path.lineTo(ptX[5], ptY[5]);
			path.close();
			color = Color.argb(255, 255, 255, 255);
			paint.setColor(color);
			paint.setStyle(Paint.Style.FILL);
			canvas.drawPath(path, paint);	//绘制路径
			//后添加
/*			color = Color.argb(255, 192, 192, 192);
			paint.setColor(color);
			
			drawRect.left = rectX[0];
			drawRect.top = (float) (rectY[0] + 0.88 * rectHeight);
			drawRect.right = rectX[2];
			drawRect.bottom = rectY[2];
			canvas.drawOval(drawRect, paint);
			
			drawRect.left = rectX[0];
			drawRect.top = (float) (rectY[0] + 0.82 * rectHeight);
			drawRect.right = rectX[2];
			drawRect.bottom = (float) (rectY[0] + 0.94 * rectHeight);
			canvas.drawRect(drawRect, paint);*/
		}
		else {
			if ((alarm_status && ack_status)|| show_status) {
				color = color_status;
			}
			else if (alarm_status){
				if (bBlink) {
					if (blink_sign){
						color = color_status;
					}
					else {
						color = Color.argb(255, 192, 192, 192);
					}
				}
				else {
					color = color_status;
				}
			}
			else {
				color = Color.argb(255, 192, 192, 192);
			}
			RectF drawRect = new RectF();
			drawRect.left = rectX[0];
			drawRect.right = rectX[2];
			drawRect.top = rectY[0];
			drawRect.bottom = rectY[2];
			
			paint.setColor(color);
			canvas.drawRect(drawRect, paint);
			
			int color_second = Color.argb(255, 128, 128, 128);
			int color_first = Color.argb(255, 192, 192, 192);
			paint.setStyle(Style.STROKE);
			paint.setColor(color_second);
			canvas.drawLine(drawRect.left, drawRect.top, drawRect.left, drawRect.bottom,
					paint);
			canvas.drawLine(drawRect.left, drawRect.top, drawRect.right, drawRect.top,
					paint);
			paint.setColor(color_first);
			canvas.drawLine(drawRect.right, drawRect.bottom, drawRect.left,
					drawRect.bottom, paint);
			canvas.drawLine(drawRect.right, drawRect.bottom, drawRect.right, drawRect.top,
					paint);		
		}
	}
	public boolean JudgePointInRect(float x, float y){
		boolean bReturn = false;
		RectF judgeRect = new RectF();
		judgeRect.left = cx - rectWidth/2;
		judgeRect.top = cy - rectHeight/2;
		judgeRect.bottom = cy + rectHeight/2;
		judgeRect.right = cx + rectWidth/2;
		float pointX = (float) (cx + (x - cx)*Math.cos(-rotateAngle) + (y - cy)*Math.sin(-rotateAngle));
		float pointY = (float) (cy - (x - cx)*Math.sin(-rotateAngle) + (y - cy)*Math.cos(-rotateAngle));
		bReturn = judgeRect.contains(pointX, pointY);
		return bReturn;
	}
}
