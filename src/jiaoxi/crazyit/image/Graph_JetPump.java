package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Paint.Style;

public class Graph_JetPump {
	public float cx = 50;       //中心点X
	public float cy = 50;       //中心点Y
	public float rectWidth = 30;  //矩形宽度
	public float rectHeight = 20;  //矩形高度
	public float rotateAngle = 0;     //旋转角度
	public boolean choiced = false;  //是否被选中
	public boolean bCtrlInthisWnd = false;   //在窗口中是否被允许控制
	
	public boolean bChangeDirect = false;
	
	public boolean compelling = false;  //强制执行
	public boolean run_state = false;   //运行状态
	public boolean run_stop = false;    //停止运行
	public boolean run_Alarm = false;    //启动器失败，封水泵报警
	public boolean rtu_sign = false;     //RTU信号
	public boolean speed_raise = false;  //正在升速
	public boolean speed_reduce = false; //正在减速
	public boolean blink_control = false;  //闪烁控制
	float rectX[] = new float[4];
	float rectY[] = new float[4];
	
	float ptX[] = new float[8];
	float ptY[] = new float[8];
	
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//使用抗锯齿功能
		paint.setStyle(Style.STROKE);
		
		rectX[0] = cx- rectWidth/2;
		rectY[0] = cy-rectHeight/2;
		rectX[1] = cx - rectWidth/2;
		rectY[1] = cy + rectHeight/2;
		rectX[2] = cx + rectWidth/2;
		rectY[2] = cy + rectHeight/2;
		rectX[3] = cx + rectWidth/2;
		rectY[3] = cy - rectHeight/2;

		int color = 0;
		canvas.save();
		canvas.rotate(-rotateAngle, cx, cy);
		
		if (compelling) {
			color = Color.argb(255, 255, 0, 0);
			paint.setColor(color);
			canvas.drawLine(rectX[0], rectY[0], rectX[1], rectY[1], paint);
			canvas.drawLine(rectX[1], rectY[1], rectX[2], rectY[2], paint);
			canvas.drawLine(rectX[2], rectY[2], rectX[3], rectY[3], paint);
			canvas.drawLine(rectX[3], rectY[3], rectX[0], rectY[0], paint);
		}
		if (bChangeDirect == false) {
			ptX[0] = cx - rectWidth/2;
			ptY[0] = cy;
			ptX[1] = cx - rectWidth/2 + rectWidth/3;
			ptY[1] = cy;
			ptX[2] = cx - rectWidth/2 + rectWidth/3;
			ptY[2] = cy - rectHeight * 2/3;
			ptX[3] = ptX[2] + rectWidth/7;
			ptY[3] = ptY[2];
			ptX[4] = ptX[3];
			ptY[4] = ptY[3] - rectHeight/6;
			ptX[7] = ptX[2] - rectWidth/3;
			ptY[7] = ptY[2];
			ptX[6] = ptX[7] - rectWidth/7;
			ptY[6] = ptY[7];
			ptX[5] = ptX[6];
			ptY[5] = ptY[6] - rectHeight/6;
		}
		else {
			ptX[0] = cx + rectWidth/2;
			ptY[0] = cy;
			ptX[1] = cx + rectWidth/2 - rectWidth/3;
			ptY[1] = cy;
			ptX[2] = cx + rectWidth/2 - rectWidth/3;
			ptY[2] = cy - rectHeight * 2/3;
			ptX[3] = ptX[2] - rectWidth/7;
			ptY[3] = ptY[2];
			ptX[4] = ptX[3];
			ptY[4] = ptY[3] - rectHeight/6;
			ptX[7] = ptX[2] + rectWidth/3;
			ptY[7] = ptY[2];
			ptX[6] = ptX[7] + rectWidth/7;
			ptY[6] = ptY[7];
			ptX[5] = ptX[6];
			ptY[5] = ptY[6] - rectHeight/6;

		}

		
		//创建路径
		Path path = new Path();
		path.moveTo(ptX[0], ptY[0]);
		path.lineTo(ptX[1], ptY[1]);
		path.lineTo(ptX[2], ptY[2]);
		path.lineTo(ptX[7], ptY[7]);
		path.close();
		
		if (run_state) {
			color = Color.argb(255, 0, 255, 0);
			paint.setColor(color);
			paint.setStyle(Paint.Style.FILL);
			canvas.drawPath(path, paint);	//绘制路径
		}
		else {
			if (run_stop) {
				if (run_Alarm) {
					color = Color.argb(255, 255, 0, 0);
					paint.setColor(color);
					paint.setStyle(Paint.Style.FILL);
					canvas.drawPath(path, paint);	//绘制路径
				}
			}
			else {
				color = Color.argb(255, 128, 128, 128);
				paint.setColor(color);
				paint.setStyle(Paint.Style.FILL);
				canvas.drawPath(path, paint);	//绘制路径
			}
		}
		
		path.moveTo(ptX[3], ptY[3]);
		path.lineTo(ptX[4], ptY[4]);
		path.lineTo(ptX[5], ptY[5]);
		path.lineTo(ptX[6], ptY[6]);
		path.close();
		if (run_state) {
			color = Color.argb(255, 0, 255, 0);
			paint.setColor(color);
			paint.setStyle(Paint.Style.FILL);
			canvas.drawPath(path, paint);	//绘制路径
		}
		else {
			if (run_stop) {
				if (run_Alarm) {
					color = Color.argb(255, 255, 0, 0);
					paint.setColor(color);
					paint.setStyle(Paint.Style.FILL);
					canvas.drawPath(path, paint);	//绘制路径
				}
			}
			else {
				color = Color.argb(255, 128, 128, 128);
				paint.setColor(color);
				paint.setStyle(Paint.Style.FILL);
				canvas.drawPath(path, paint);	//绘制路径
			}
		}
		
		if (run_Alarm) {
			color = Color.argb(255, 255, 0, 0);
		}
		else {
			if (rtu_sign) {
				color = Color.argb(255, 0, 192, 192);
			}
			else {
				color = Color.argb(255, 192, 192, 192);
			}
		}
		paint.setColor(color);
		paint.setStyle(Style.STROKE);
		for (int i = 0; i < 7; i++) {
			canvas.drawLine(ptX[i], ptY[i], ptX[i+1], ptY[i+1], paint);
		}
		canvas.drawLine(ptX[7], ptY[7], ptX[0], ptY[0], paint);
		canvas.drawLine(ptX[7], ptY[7], ptX[2], ptY[2], paint);
		
		RectF outRect = new RectF();
		outRect.left = rectX[0];
		outRect.top = rectY[0];
		outRect.bottom = rectY[2];
		outRect.right = rectX[2];
		color = Color.argb(255, 0, 0, 0);
		paint.setColor(color);
		paint.setStyle(Paint.Style.FILL);
		canvas.drawOval(outRect, paint);
		
		RectF inRect = new RectF();
		inRect.left = rectX[0] + rectWidth/6;
		inRect.top = rectY[0] + rectHeight/6;
		inRect.bottom = rectY[0] + rectHeight*5/6;
		inRect.right = rectX[0] + rectWidth*5/6;
		if (speed_raise || speed_reduce) {
			if (speed_raise) {
				if (blink_control) {
					color = Color.argb(255, 255, 0, 0);
					paint.setColor(color);
					canvas.drawOval(inRect, paint);
				}
				else {
					color = Color.argb(255, 0, 255, 0);
					paint.setColor(color);
					canvas.drawOval(inRect, paint);
				}
			}
			else if (speed_reduce) {
				if (blink_control) {
					color = Color.argb(255, 128, 128, 128);
					paint.setColor(color);
					canvas.drawOval(inRect, paint);
				}
				else {
					color = Color.argb(255, 0, 255, 0);
					paint.setColor(color);
					canvas.drawOval(inRect, paint);
				}
			}
		}
		else {
			if (run_state) {
				color = Color.argb(255, 255, 0, 0);
				paint.setColor(color);
			}
			else {
				if (run_stop) {
					if (run_Alarm) {
						color = Color.argb(255, 255, 0, 0);
						paint.setColor(color);
					}
					else {
						color = Color.argb(255, 128, 128, 128);
						paint.setColor(color);
					}
				}
				else {
					color = Color.argb(255, 128, 128, 128);
					paint.setColor(color);
				}
				
			}
			canvas.drawOval(inRect, paint);
		}
		
		if (run_Alarm) {
			color = Color.argb(255, 128, 128, 128);
			paint.setColor(color);
		}
		else if (rtu_sign) {
			color = Color.argb(255, 0, 192, 192);
			paint.setColor(color);
		}
		else {
			color = Color.argb(255, 192, 192, 192);
			paint.setColor(color);
		}
		paint.setStyle(Style.STROKE);
		canvas.drawArc(outRect, 0, 360, false, paint);
		canvas.drawArc(inRect, 0, 360, false, paint);
		
		canvas.restore();
	}
}