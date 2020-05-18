package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;

//画圆形灯
public class Graph_SolenoidValve {
	public float cx = 250;  //中心点X
	public float cy = 250;  //中心点Y
	public float rectWidth = 40;
	public float rectHeight = 40;
	public boolean blink_sign = false;  // 标志位，，变绿
	public boolean electricity = false;  //电磁阀得电
	public boolean conditional_electricity = false;  //电磁阀有条件得电
	public boolean adjustable = false;  //电磁阀有条件得电

	
	public float rectX[] = new float[4];
	public float rectY[] = new float[4];
	
	public void drawGraph(Canvas canvas) {
		 int color =Color.GREEN;
	
		canvas.save();//保存当前坐标状态
	     canvas.translate(cx, cy);//改变坐标系原点
	     
	 	Paint paint = new Paint();
		paint.setAntiAlias(true);		//使用抗锯齿功能
		paint.setStrokeWidth(3); // 设置画笔的宽度
		paint.setStyle(Style.FILL);
	
		float circle=(float)Math.sqrt((rectWidth/2)*(rectWidth/2)+(rectHeight/2)*(rectHeight/2));
		if(electricity){
			paint.setStyle(Style.FILL);
			paint.setColor( Color.WHITE);
			canvas.drawCircle(0,0,(circle*40/100), paint);
		}
	   if(conditional_electricity){
			paint.setStyle(Style.STROKE);
			paint.setColor( Color.WHITE);
			canvas.drawCircle(0,0,(circle*40/100), paint);
		}
	   if(adjustable){
			paint.setColor( Color.GRAY);
			canvas.drawLine(-rectWidth*45/100,-rectHeight*45/100,rectWidth*45/100,rectHeight*45/100,paint);
			canvas.drawLine(-rectWidth*45/100,rectHeight*45/100,rectWidth*45/100,-rectHeight*45/100,paint);
		}
		

		if(blink_sign){
		paint.setColor(color);
		paint.setStyle(Style.FILL);
		canvas.drawCircle(0,0,(circle*40/100), paint);
//		else paint.setColor( Color.argb(255, 192, 192, 192));
//		canvas.drawRect(-rectWidth/2,-rectHeight/2,rectWidth/2,rectHeight/2,paint);
//		canvas.drawRoundRect(new RectF(-rectWidth/2,-rectHeight/2,rectWidth/2,rectHeight/2),rectWidth*2/100, rectWidth*2/100, paint);//第二个参数是x半径，第三个参数是y半径    
		}
		
		canvas.restore();	//恢复原来坐标状态
	}
}
