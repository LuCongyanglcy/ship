package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Paint.Style;

public class Graph_Button {
	public Graph_Button() {
		backColor = Color.argb(192, 192, 192, 192);
	}
	public int textSize = 15;
	public String sText = "";
	public float cx = 100; // ���ĵ�X
	public float cy = 100; // ���ĵ�Y
	public float rectWidth = 80;
	public float rectHeight = 50;
	public boolean blinkStatus = false; // ��˸�ı�־
	public int backColor = 0; // ������ɫ
	public float rectX[] = new float[4];
	public float rectY[] = new float[4];
	public boolean bDown = false;  //��ť�Ƿ���
	public boolean blink = false;  //���ڶ���
	public int distance_centerX = 0;  //��������X
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true); // ʹ�ÿ���ݹ���
		paint.setStyle(Style.STROKE);
		paint.setColor(backColor);
		// paint.setStrokeWidth(2);
		int color_status = Color.argb(255,  0, 255, 0);  //״̬����ɫֵ
		rectX[0] = cx - rectWidth / 2;
		rectY[0] = cy - rectHeight / 2;
		rectX[1] = cx - rectWidth / 2;
		rectY[1] = cy + rectHeight / 2;
		rectX[2] = cx + rectWidth / 2;
		rectY[2] = cy + rectHeight / 2;
		rectX[3] = cx + rectWidth / 2;
		rectY[3] = cy - rectHeight / 2;

		RectF outRect = new RectF();
		outRect.left = rectX[0];
		outRect.top = rectY[0];
		outRect.right = rectX[2];
		outRect.bottom = rectY[2];

		RectF inRect = new RectF();
		inRect.left = rectX[0] + rectWidth / 20;
		inRect.top = rectY[0] + rectHeight / 10;
		inRect.right = rectX[2] - rectWidth / 20;
		inRect.bottom = rectY[2] - rectHeight / 10;

		int color_second = Color.argb(255, 128, 128, 128);
		int color_first = Color.argb(255, 192, 192, 192);

		paint.setStyle(Paint.Style.FILL); // �����
		canvas.drawRect(outRect, paint);
		paint.setStyle(Style.STROKE);
		paint.setColor(color_first);
		canvas.drawLine(rectX[0], rectY[0], rectX[1], rectY[1], paint);
		canvas.drawLine(rectX[0], rectY[0], rectX[3], rectY[3], paint);
		paint.setColor(color_second);
		canvas.drawLine(rectX[2], rectY[2], rectX[3], rectY[3], paint);
		canvas.drawLine(rectX[2], rectY[2], rectX[1], rectY[1], paint);

		// �ڲ�����
		paint.setStyle(Paint.Style.FILL); // �����
		paint.setColor(backColor);
		canvas.drawRect(inRect, paint);
		
		

		paint.setStyle(Style.STROKE);
		paint.setColor(color_first);
		canvas.drawLine(inRect.left, inRect.top, inRect.left, inRect.bottom,
				paint);
		canvas.drawLine(inRect.left, inRect.top, inRect.right, inRect.top,
				paint);
		paint.setColor(color_second);
		canvas.drawLine(inRect.right, inRect.bottom, inRect.left,
				inRect.bottom, paint);
		canvas.drawLine(inRect.right, inRect.bottom, inRect.right, inRect.top,
				paint);
		
		RectF changeRect = new RectF();
		changeRect.left = inRect.left +1;
		changeRect.right = inRect.right - 1;
		changeRect.top = inRect.top + 1;
		changeRect.bottom = inRect.bottom - 1;
		
		if (blink) {
			if (blinkStatus) {
				paint.setColor(color_status);
				paint.setStyle(Paint.Style.FILL); // �����
				canvas.drawRect(changeRect, paint);
				
				
			}
			else {
				
			}
		}
		else if (bDown) {
			paint.setColor(color_status);
			paint.setStyle(Paint.Style.FILL); // �����
			canvas.drawRect(changeRect, paint);

		}
		
		//������
		paint.setTextSize(textSize);
		paint.setStyle(Paint.Style.FILL); // �����
		int textColor = Color.argb(255, 0, 0, 0);
		paint.setColor(textColor);
		//int iLen = sText.length();
		//float startX = cx - iLen * textSize/2;
		float startY = cy + textSize/2;
		canvas.drawText(sText, cx - distance_centerX, startY, paint);
	
	}
}
