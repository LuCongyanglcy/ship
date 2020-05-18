package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Paint.Style;

public class Graph_Line {
	public int startX;  //起始点X坐标
	public int startY;  //起始点Y坐标
	public int endX;    //结束点X坐标
	public int endY;    //结束点Y坐标
	public int lineWidth; //线宽
	public int istyle;    //线条类型，
	public int color;     //线条颜色
	public boolean blink = false; // 是否闪烁
	
	public boolean state1 = false;  //信号状态1
	public boolean state2 = false;  //信号状态2
	public boolean state3 = false;  //信号状态3
	
	public int color1;   //颜色1
	public int color2;   //颜色2
	public int color3;   //颜色3
	
	public boolean bArc = false;
	
	
	public Graph_Line() {
		color = Color.argb(255, 128, 128, 128);
	}

	public int setColor(int r, int g, int b) {
		int iColor = Color.argb(255, r, g, b);
		return iColor;
	}
	
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//使用抗锯齿功能
		//paint.setStyle(Paint.Style.FILL);
		
		paint.setStyle(Style.STROKE);
		if (lineWidth < 1) {
			lineWidth = 1;
		}
		paint.setStrokeWidth(lineWidth);
		
		if (state1) {
			color = color1;
		}		
		else if (state2) {
			color = color2;
		}
		else if (state3) {
			color = color3;
		}
		else
			color = Color.argb(255, 128, 128, 128);
		paint.setColor(color);
		if (bArc == false) {
			canvas.drawLine(startX, startY, endX, endY, paint);
		}
		else {
			int width = 0;
			int height = 0;
			RectF drawRect = new RectF();
			if (startX > endX) {
				if (startY > endY) {
					width = 2 * (startX - endX);
					height = 2 * (startY - endY);
					drawRect.left = endX;
					drawRect.right = endX + width;
					drawRect.top = startY - height;
					drawRect.bottom = startY;
					canvas.drawArc(drawRect, 90, 90, false, paint);
				}
				else {
					width = 2 * (startX - endX);
					height = 2 * (endY - startY);
					drawRect.left = startX - width;
					drawRect.right = startX;
					drawRect.top = endY - height;
					drawRect.bottom = endY;
					canvas.drawArc(drawRect, 0, 90, false, paint);
				}
			}
			else {
				if (startY > endY) {
					width = 2 * (endX - startX);
					height = 2 * (startY - endY);
					drawRect.left = startX;
					drawRect.right = startX + width;
					drawRect.top = endY;
					drawRect.bottom = endY + height;
					canvas.drawArc(drawRect, 180, 90, false, paint);
				}
				else {
					width = 2 * (endX - startX);
					height = 2 * (endY - startY);
					drawRect.left = endX - width;
					drawRect.right = endX;
					drawRect.top = startY;
					drawRect.bottom = startY + height;
					canvas.drawArc(drawRect, 270, 90, false, paint);
				}
			}

		}
		
	}
}
