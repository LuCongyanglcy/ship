package jiaoxi.crazyit.image;

import java.text.DecimalFormat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Paint.Style;

public class Graph_Cutter {

	public Paint paint = new Paint();
	public RectF graphRect = new RectF();
	public float ptX[] = new float[20];
	public float ptY[] = new float[20];
	public float craneLenth = 20.0f;
	public float cutterDeep = 0.0f;
	
	public int scaleBig = 5;  //大刻度
	public int scaleSmall = 2; //小刻度
	//public float perValue = 4.0f; //一大等分为4米
	public float design_Deep = 18.0f;
	public float tide = 2.0f;
	public int sea_color = Color.argb(255, 0, 128, 128);  //设计挖深颜色
	public int design_Deep_Color = Color.argb(255,0,64,64);  //sea_color

	public Graph_Cutter() {

		graphRect.left = 50;
		graphRect.right = 900;
		graphRect.top = 100;
		graphRect.bottom = 600;

	}
	public void drawGraph(Canvas canvas) {
		
		//限制条件，铰刀深度不应该大于桥架长度
		if (cutterDeep > craneLenth) {
			cutterDeep = craneLenth;
		}
		float finalX  = 0;  //临时定义一个点，用于后面计算的
		
		paint.setColor(Color.argb(255, 192, 192, 192));
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(2);
		canvas.drawRect(graphRect, paint);
		float craneLen = (float) (0.6 * graphRect.width());
		float bili = (float) (1.0*craneLen/craneLenth);
		//画船
		ptX[0] = graphRect.left;
/*		ptY[0] = (float) (graphRect.top + 0.15*graphRect.height());
		ptX[1] = (float) (graphRect.left + 0.6 * graphRect.width());
		ptY[1] = (float) (graphRect.top + 0.15*graphRect.height());*/
		ptY[0] = (float) (graphRect.top + 0.1*graphRect.height());
		ptX[1] = (float) (graphRect.left + 0.55 * graphRect.width());
		ptY[1] = (float) (graphRect.top + 0.1*graphRect.height());
		ptX[2] = ptX[1];
		ptY[2] = (float) (graphRect.top + 0.2*graphRect.height());
		ptX[3] = (float) (graphRect.left + 0.5*graphRect.width());
		ptY[3] = (float) (graphRect.top + 0.25*graphRect.height());
		ptX[4] = graphRect.left;
		ptY[4] = ptY[3];
		
		float radius = (float) (0.05*(ptX[1]-ptX[0]));
		if (radius > 0.33*(ptY[4]-ptY[0])){
			radius = (float) (0.33*(ptY[4]-ptY[0]));
		}
		radius = (float) (0.7 * radius);
		finalX = (float) ((graphRect.left + ptX[1] - ptX[0])+4 + 2.5 * radius);
		//以前未考虑潮位,这里添加潮位计算，先计算海平面
		float smallHeight = (float)(ptY[0] + 0.33*(ptY[4]-ptY[0]));   //海平面
		//float bigHeight = graphRect.bottom - 20;
		float bigHeight = (float) (smallHeight + (finalX - (ptX[0] + 0.05*(ptX[1]-ptX[0]))));
		float perLength = (bigHeight - smallHeight)/scaleBig;
		float perSmall = perLength/scaleSmall;
		
		ptY[0] = ptY[0] - tide/craneLenth*(bigHeight - smallHeight);
		ptY[1] = ptY[1] - tide/craneLenth*(bigHeight - smallHeight);
		ptY[2] = ptY[2] - tide/craneLenth*(bigHeight - smallHeight);
		ptY[3] = ptY[3] - tide/craneLenth*(bigHeight - smallHeight);
		ptY[4] = ptY[4] - tide/craneLenth*(bigHeight - smallHeight);
		//画设计挖深
		float[] rectPtX = new float[8];
		float[] rectPtY = new float[8];
		rectPtX[0] = graphRect.left;
		rectPtY[0] = smallHeight - tide/craneLenth*(bigHeight - smallHeight);
		rectPtX[1] = graphRect.right;
		rectPtY[1] = smallHeight - tide/craneLenth*(bigHeight - smallHeight);
		rectPtX[2] = graphRect.left;
		rectPtY[2] = smallHeight + design_Deep/craneLenth*(bigHeight - smallHeight);
		rectPtX[3] = graphRect.right;
		rectPtY[3] = smallHeight + design_Deep/craneLenth*(bigHeight - smallHeight);
		rectPtX[4] = graphRect.left;
		rectPtY[4] = graphRect.bottom;
		rectPtX[5] = graphRect.right;
		rectPtY[5] = graphRect.bottom;
		paint.setColor(design_Deep_Color);
		paint.setStyle(Style.FILL);
		RectF design_Rect = new RectF();
		design_Rect.left = rectPtX[2];
		design_Rect.top = rectPtY[2];
		design_Rect.right = rectPtX[5];
		design_Rect.bottom = rectPtY[5];
		canvas.drawRect(design_Rect, paint);
		paint.setColor(sea_color);
		design_Rect.left = rectPtX[0];
		design_Rect.top = rectPtY[0];
		design_Rect.right = rectPtX[3];
		design_Rect.bottom = rectPtY[3];
		canvas.drawRect(design_Rect, paint);
		
		paint.setColor(Color.argb(255, 192, 192, 192));
		paint.setStyle(Style.STROKE);
		canvas.drawLine(ptX[0], ptY[0], ptX[1], ptY[1], paint);
		canvas.drawLine(ptX[1], ptY[1], ptX[2], ptY[2], paint);
		canvas.drawLine(ptX[3], ptY[3], ptX[4], ptY[4], paint);
		RectF drawRect = new RectF();
		drawRect.left = ptX[3] - (ptX[2]-ptX[3]);
		drawRect.top = ptY[2] - (ptY[3] - ptY[2]);
		drawRect.right = ptX[2];
		drawRect.bottom = ptY[3];
		canvas.drawArc(drawRect, 0, 90, false, paint);
		
		//第二步
		//从这里开始应该旋转了
	
		ptX[5] = (float) (ptX[0] + 0.05*(ptX[1]-ptX[0]));
		ptY[5] = (float) (ptY[0] + 0.33*(ptY[4]-ptY[0]));
		float angle1 =  (float) (180* Math.asin((cutterDeep+tide)/craneLenth)/Math.PI);
		canvas.save();
		canvas.rotate(angle1, ptX[5], ptY[5]);
		

		drawRect.left = ptX[5] - radius;
		drawRect.top = ptY[5] - radius;
		drawRect.right = ptX[5] + radius;
		drawRect.bottom = ptY[5] + radius;
		canvas.drawArc(drawRect, 90, 180, false, paint);
		RectF midRect = new RectF();
		midRect.left = (float) (ptX[5] - 0.5*radius);
		midRect.top = (float) (ptY[5] - 0.5*radius);
		midRect.right = (float) (ptX[5] + 0.5*radius);
		midRect.bottom = (float) (ptY[5] + 0.5*radius);
		canvas.drawArc(midRect, 0, 360, false, paint);
		ptX[5] = (float) (ptX[0] + 0.35*(ptX[1]-ptX[0]));
		ptY[5] = (float) (drawRect.top - 0.3*radius);
		ptX[6] = ptX[5];
		ptY[6] = drawRect.top;
		ptX[7] = ptX[5];
		ptY[7] = drawRect.bottom;
		ptX[8] = ptX[5];
		ptY[8] = (float) (drawRect.bottom + 0.3 * radius);
		
		canvas.drawLine(drawRect.centerX(), drawRect.top, ptX[6], ptY[6], paint);
		canvas.drawLine(drawRect.centerX(), drawRect.bottom, ptX[7], ptY[7], paint);
		canvas.drawLine(ptX[5], ptY[5], ptX[8], ptY[8], paint);
		
		ptX[10] = (float) (graphRect.left + 0.25 * (ptX[1]-ptX[0]));
		ptY[10] = ptY[6];
		ptX[11] = ptX[10];
		ptY[11] = ptY[7];
		ptX[12] = graphRect.left + ptX[1] - ptX[0];
		ptY[12] = ptY[5];
		ptX[13] = ptX[12];
		ptY[13] = ptY[8];
		Path drawPath = new Path();
		drawPath.moveTo(ptX[10], ptY[10]);
		drawPath.lineTo(ptX[5], ptY[5]);
		drawPath.lineTo(ptX[12], ptY[12]);
		drawPath.lineTo(ptX[13], ptY[13]);
		drawPath.lineTo(ptX[8], ptY[8]);
		drawPath.lineTo(ptX[11], ptY[11]);
		drawPath.close();
		canvas.drawPath(drawPath, paint);
		
		ptX[14] = ptX[12]+4;
		ptY[14] = ptY[12];
		ptX[15] = ptX[13] + 4;
		ptY[15] = ptY[13];
		
		drawRect.left = ptX[12];
		drawRect.top = ptY[12] - 3;
		drawRect.right = ptX[14];
		drawRect.bottom = ptY[15]+3;
		canvas.drawRect(drawRect, paint);
		//绞刀部分
		drawRect.left = ptX[14];
		drawRect.top = ptY[12];
		drawRect.right = ptX[14]+2*radius;
		drawRect.bottom = ptY[13];
		canvas.drawRect(drawRect, paint);
		float centerX = drawRect.centerX();
		float centerY = drawRect.centerY();
/*		drawRect.left = ptX[14]+2*radius;
		drawRect.top = centerY- radius;
		drawRect.right = ptX[14]+4*radius;
		drawRect.bottom = centerY+radius;*/
		drawRect.left = ptX[14]+2*radius;
		drawRect.top = (float) (centerY- radius);
		drawRect.right = ptX[14]+3*radius;
		drawRect.bottom = (float) (centerY);
		
		canvas.drawArc(drawRect, 0, 360, false, paint);
		finalX = (float)(ptX[14]+2.5*radius);  //这个值保存下面，画后面刻度尺使用
		//String
		
		canvas.save();
		canvas.rotate(100, (float)(ptX[14]+2.5*radius), (float) (centerY-0.5*radius));
/*		canvas.drawLine(ptX[14]+3*radius,drawRect.top,ptX[14]+7*radius, drawRect.top, paint);
		canvas.drawLine(ptX[14]+7*radius, drawRect.top,ptX[14]+7*radius, drawRect.bottom,paint);
		canvas.drawLine(ptX[14]+7*radius, drawRect.bottom,ptX[14]+3*radius, drawRect.bottom, paint);*/
		canvas.drawLine((float)(ptX[14]+2.5*radius),drawRect.top,ptX[14]+6*radius, drawRect.top, paint);
		canvas.drawLine(ptX[14]+6*radius, drawRect.top,ptX[14]+6*radius, drawRect.bottom,paint);
		canvas.drawLine(ptX[14]+6*radius, drawRect.bottom,(float)(ptX[14]+2.5*radius), drawRect.bottom, paint);
		
/*		ptX[5] = ptX[14]+5*radius;
		ptY[5] = drawRect.top;
		ptX[6] = ptX[14]+7*radius;
		ptY[6] = drawRect.top;
		ptX[7] = ptX[6] + radius;
		ptY[7] = ptY[6]-4*radius;
		ptX[8] = (float) (ptX[6] + 0.5*radius);
		ptY[8] = ptY[6]-6*radius;
		ptX[9] = (float) (ptX[5] - radius);
		ptY[9] = ptY[8];
		ptX[10] = ptX[5] - 2*radius;
		ptY[10] = ptY[7];*/
		
		ptX[5] = ptX[14]+4*radius;
		ptY[5] = drawRect.top;
		ptX[6] = ptX[14]+6*radius;
		ptY[6] = drawRect.top;
		ptX[7] = (float) (ptX[6] + 0.5*radius);
		ptY[7] = (float) (ptY[6]-2.5*radius);
		ptX[8] = (float) (ptX[6]);
		ptY[8] = ptY[6]-4*radius;
		ptX[9] = (float) (ptX[5]);
		ptY[9] = ptY[8];
		ptX[10] = (float) (ptX[5] - 0.5*radius);
		ptY[10] = ptY[7];
		canvas.drawLine(ptX[5], ptY[5], ptX[6], ptY[6], paint);
		canvas.drawLine(ptX[6], ptY[6], ptX[7], ptY[7], paint);
		canvas.drawLine(ptX[7], ptY[7], ptX[8], ptY[8], paint);
		canvas.drawLine(ptX[8], ptY[8], ptX[9], ptY[9], paint);
		canvas.drawLine(ptX[9], ptY[9], ptX[10], ptY[10], paint);
		canvas.drawLine(ptX[10], ptY[10], ptX[5], ptY[5], paint);
		canvas.drawLine(ptX[10], ptY[10], ptX[7], ptY[7], paint);
		canvas.restore();
		canvas.restore();
		
		
		//画刻度尺
		float[] pt1X = new float[2*scaleSmall];
		float[] pt1Y = new float[2*scaleSmall];

		paint.setTextSize(16);
		for (int i =0; i < scaleBig; i++) {
			ptX[i] = (float) (graphRect.right - 0.15 * graphRect.width());
			ptY[i] = smallHeight + i * perLength;
			ptX[i+scaleBig+1] = (float) ptX[i]+15;
			ptY[i+scaleBig+1] = smallHeight + i * perLength;
			canvas.drawLine(ptX[i], ptY[i], ptX[i+scaleBig+1], ptY[i+scaleBig+1], paint);
			float fData = i * craneLenth/scaleBig;
			DecimalFormat fnum = new DecimalFormat("0.00");
			String sData = fnum.format(fData);
		//	sData.format("%.2f", i*craneLenth/bigHeight);
			canvas.drawText(sData, ptX[i+scaleBig+1], ptY[i+scaleBig+1], paint);
			if (i != scaleBig) {
				for (int j = 0; j < scaleSmall; j++) {	
					pt1X[j] = (float) ptX[i];
					pt1Y[j] = smallHeight + i * perLength + j * perSmall;
					pt1X[j+scaleSmall] = (float) ptX[i]+10;
					pt1Y[j+scaleSmall] = smallHeight + i * perLength + j * perSmall;
					canvas.drawLine(pt1X[j], pt1Y[j], pt1X[j+scaleSmall], pt1Y[j+scaleSmall], paint);
				}
			}
		}
		canvas.drawLine(ptX[0], ptY[0], ptX[scaleBig-1], ptY[scaleBig-1], paint);
		//画显示刻度
		paint.setStyle(Style.FILL);
		int color = Color.argb(255, 0, 0, 255);
		paint.setColor(color);
		float[] showPtX = new float[4];
		float[] showPtY = new float[4];
		showPtX[0] = ptX[0] - 8;
		showPtY[0] = ptY[0];
		showPtX[1] = ptX[0]-3;
		showPtY[1] = ptY[0];
		showPtX[2] = ptX[0]-3;
		showPtY[2] = smallHeight + cutterDeep/craneLenth*(bigHeight - smallHeight);
		showPtX[3] = ptX[0] - 8;
		showPtY[3] = showPtY[2];
		Path kPath = new Path();
		kPath.moveTo(showPtX[0], showPtY[0]);
		kPath.lineTo(showPtX[1], showPtY[1]);
		kPath.lineTo(showPtX[2], showPtY[2]);
		kPath.lineTo(showPtX[3], showPtY[3]);
		kPath.close();
		canvas.drawPath(kPath, paint);
		
		//
		
	}	
}	

 