package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Paint.Style;

//该按钮只显示状态，不显示动作
public class Graph_ShowButton {
	public Graph_ShowButton() {
		textColor = Color.argb(255, 0, 0, 0);
	}
	public int textSize = 15;
	public String sText = "";
	public float cx = 100; // 中心点X
	public float cy = 100; // 中心点Y
	public float rectWidth = 80;
	public float rectHeight = 50;
	public int textColor = 0;
	public String szText = "";  //的名按钮称
	public boolean status = false;  //状态是否存在
	public int distance_centerX = 0;  //距离中心X
	
	public float rectX[] = new float[4];
	public float rectY[] = new float[4];
	
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStyle(Style.STROKE);
		int backColor = Color.argb(192, 192, 192, 192);
		
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
		
		paint.setStyle(Paint.Style.FILL); // 先填充
		paint.setColor(backColor);
		canvas.drawRect(outRect, paint);
		paint.setStyle(Style.STROKE);
		paint.setColor(color_first);
		canvas.drawLine(rectX[0], rectY[0], rectX[1], rectY[1], paint);
		canvas.drawLine(rectX[0], rectY[0], rectX[3], rectY[3], paint);
		paint.setColor(color_second);
		canvas.drawLine(rectX[2], rectY[2], rectX[3], rectY[3], paint);
		canvas.drawLine(rectX[2], rectY[2], rectX[1], rectY[1], paint);
		
		
		paint.setColor(color_second);
		canvas.drawLine(inRect.left-1, inRect.top-1, inRect.left-1, inRect.bottom+1,
				paint);
		canvas.drawLine(inRect.left-1, inRect.top-1, inRect.right+1, inRect.top-1,
				paint);
		paint.setColor(color_first);
		canvas.drawLine(inRect.right+1, inRect.bottom+1, inRect.left-1,
				inRect.bottom+1, paint);
		canvas.drawLine(inRect.right+1, inRect.bottom+1, inRect.right+1, inRect.top-1,
				paint);
		
		int statusColor = Color.argb(255, 15, 15, 255);
		if (status) {
			paint.setColor(statusColor);
			paint.setStyle(Paint.Style.FILL); // 先填充
			canvas.drawRect(inRect, paint);
		}
		else {
			paint.setColor(backColor);
			paint.setStyle(Paint.Style.FILL); // 先填充
			canvas.drawRect(inRect, paint);
		}
		
		paint.setTextSize(textSize);
		paint.setColor(textColor);
	//	int iLen = sText.length();
	//	float startX = cx - iLen * textSize/2;
		float startY = cy + textSize/2;
		canvas.drawText(sText, cx - distance_centerX, startY, paint);
	}
}
