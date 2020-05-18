package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Paint.Style;

public class Graph_CutterWheel {
	public float cx = 50.0f;
	public float cy = 50.0f;
	public float rectWidth = 50;
	public float rectHeight = 50;
	public final int Number = 10;  //这里先固定死了，分成10等份
	public boolean bRun = false;  //运行信号
	public boolean bcompel = false;  //信号强制
	
	public float sAngle = 0;  //自定义角度,为绘图提供动作
	
	public float perLength = 0.0f;
	
	public float[] ptX = new float[10];
	public float[] ptY = new float[10];
	
	public void drawGraph(Canvas canvas) {
		
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//使用抗锯齿功能
		//paint.setStyle(Paint.Style.FILL);
		paint.setStyle(Style.STROKE);
		int color = 0;
		perLength = (rectWidth < rectHeight) ? (rectWidth/5) : (rectHeight/5);
		
		float row1 = perLength * 0.5f;
		float row2 = perLength * 1.2f;
		float row3 = perLength * 2.5f;
		float tramp = perLength * 1.5f;
		
		float speedCircle = row3 + row1;
		float perAngle = (float) (Math.PI*2/Number);  //将圆平均等份
		float perAngle_small = perAngle/5;    //将每一齿轮分为5等份
		
		//如果是运行信号
		if (bRun) { 
			color = Color.argb(255, 0, 255, 0);
//			sAngle += 60;
//			if (sAngle == 360) {
//				sAngle = 0;
//			}
		}
		else {
			sAngle = 0;
			color = Color.argb(255, 255, 255, 255);
		}
		
		//color = Color.argb(255, 255, 255, 255);
		paint.setColor(color);
		//画内圆1
		RectF rect_Circle1 = new RectF();
		rect_Circle1.left = cx - row1;
		rect_Circle1.top = cy - row1;
		rect_Circle1.right = cx + row1;
		rect_Circle1.bottom = cy + row1;
		canvas.drawArc(rect_Circle1, 0, 360, false, paint);
		//画内圆2
		RectF rect_Circle2 = new RectF();
		rect_Circle2.left = cx - row2;
		rect_Circle2.top = cy - row2;
		rect_Circle2.right = cx + row2;
		rect_Circle2.bottom = cy + row2;
		canvas.drawArc(rect_Circle2, 0, 360, false, paint);
		
		
		canvas.save();
		canvas.rotate(sAngle, cx, cy);
		for (int i =0; i < Number; i++) {
			ptX[0] = (float) (cx + row3* Math.cos(perAngle*i));
			ptY[0] = (float) (cy - row3 * Math.sin(perAngle*i));
			ptX[1] = (float) (cx + row2 * Math.cos(perAngle_small+perAngle*i));
			ptY[1] = (float) (cy - row2 * Math.sin(perAngle_small + perAngle*i));
			ptX[2] = (float) (cx + row2 * Math.cos(perAngle_small*2+perAngle*i));
			ptY[2] = (float) (cy - row2 * Math.sin(perAngle_small*2 + perAngle*i));
			ptX[3] = (float) (cx + (row3-row3/160) * Math.cos(perAngle_small+perAngle*i));
			ptY[3] = (float) (cy - (row3-row3/160) * Math.sin(perAngle_small + perAngle*i));
			ptX[4] = (float) (cx + (row3-row3/20) * Math.cos(perAngle_small+perAngle*i));
			ptY[4] = (float) (cy - (row3-row3/20) * Math.sin(perAngle_small + perAngle*i));
			ptX[5] = (float) (cx + row2 * Math.cos(perAngle+perAngle*i));
			ptY[5] = (float) (cy - row2 * Math.sin(perAngle + perAngle*i));
			ptX[6] = (float) (cx + (row3-row3/160*15) * Math.cos(perAngle_small*4+perAngle*i));
			ptY[6] = (float) (cy - (row3-row3/160*15) * Math.sin(perAngle_small*4 + perAngle*i));
			canvas.drawLine(ptX[0], ptY[0], ptX[1], ptY[1], paint);
			canvas.drawLine(ptX[2], ptY[2], ptX[3], ptY[3], paint);
			canvas.drawLine(ptX[0], ptY[0], ptX[3], ptY[3], paint);
			canvas.drawLine(ptX[5], ptY[5], ptX[6], ptY[6], paint);
			canvas.drawLine(ptX[6], ptY[6], ptX[4], ptY[4], paint);
			
			Path path = new Path();
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[1], ptY[1]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[0], ptY[0]);
			path.close();
			paint.setStyle(Paint.Style.FILL);
			canvas.drawPath(path, paint);	//绘制路径
		}
		canvas.restore();
		//设备被强制
		if (bcompel) {
			color = Color.argb(255, 255, 0, 0);
			paint.setColor(color);
			ptX[0] = cx - rectWidth/2;
			ptY[0] = cy - rectHeight/2;
			ptX[1] = cx - rectWidth/2;
			ptY[1] = cy + rectHeight/2;
			ptX[2] = cx + rectWidth/2;
			ptY[2] = cy + rectHeight/2;
			ptX[3] = cx + rectWidth/2;
			ptY[3] = cy - rectHeight/2;
			
			Path path = new Path();
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[1], ptY[1]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
/*			path.lineTo(ptX[0], ptY[0]);*/
			path.close();
			paint.setStyle(Style.STROKE);
			canvas.drawPath(path, paint);	//绘制路径
		}
	}
}
