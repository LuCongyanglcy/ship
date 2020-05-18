package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Paint.Style;

public class Graph_Line {
	public int startX;  //��ʼ��X����
	public int startY;  //��ʼ��Y����
	public int endX;    //������X����
	public int endY;    //������Y����
	public int lineWidth; //�߿�
	public int istyle;    //�������ͣ�
	public int color;     //������ɫ
	public boolean blink = false; // �Ƿ���˸
	
	public boolean state1 = false;  //�ź�״̬1
	public boolean state2 = false;  //�ź�״̬2
	public boolean state3 = false;  //�ź�״̬3
	
	public int color1;   //��ɫ1
	public int color2;   //��ɫ2
	public int color3;   //��ɫ3
	
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
		paint.setAntiAlias(true);		//ʹ�ÿ���ݹ���
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
