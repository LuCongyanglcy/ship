package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
//离合器
public class Graph_Clutch {
	public float cx = 70;  //中心点X
	public float cy = 250;  //中心点Y
	public float rectWidth = 30;   //矩形宽度
	public float rectHeight = 50;   //矩形高度
	public boolean RTU=false;   //遥控
	public boolean running=false;   //运行状态
	public boolean stop=false;   //运行停止
	public float aiData = 0;
	public float distance = 1;//两排间的距离比
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//使用抗锯齿功能
		canvas.save();
		canvas.translate(cx, cy);//改变坐标系原点
		if(running) distance=0.7f;
		paint.setColor(Color.WHITE);//绘制外围白方框
		 paint.setStrokeWidth(2*rectWidth/5);
		 canvas.drawLines(new float[]{-3*distance*rectWidth/10,-rectHeight/2,-3*distance*rectWidth/10,rectHeight/2}, paint);
		 canvas.drawLines(new float[]{3*distance*rectWidth/10,-rectHeight/2,3*distance*rectWidth/10,rectHeight/2}, paint);
	    int color=0;
		if(running) color=Color.GREEN;
		else if(stop)color=Color.GRAY;
		else if(RTU)color=Color.RED;
		else color=Color.RED;
		paint.setColor(color);//绘制中间变色小矩形
		paint.setStrokeWidth(rectWidth/5);
		canvas.drawLines(new float[]{-3*distance*rectWidth/10,-rectHeight/2+rectWidth/7,-3*distance*rectWidth/10,rectHeight/2-rectWidth/7}, paint);
		canvas.drawLines(new float[]{3*distance*rectWidth/10,-rectHeight/2+rectWidth/7,3*distance*rectWidth/10,rectHeight/2-rectWidth/7}, paint);
		 canvas.restore();	//恢复原来坐标状态 
	}
}
