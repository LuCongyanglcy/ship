package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Graph_BigDoor {
	public float cx = 70;       //中心点X
	public float cy = 180;       //中心点Y
	public float percent=60;  //填充量百分比
	public float circle = 40;   //圆半径
	public String szText = "";
	public float rotateAngle = 0;     //旋转角度
	public boolean choiced = false;  //是否被选中
	public boolean bCtrlInthisWnd = false;   //在窗口中是否被允许控制
	public boolean closing = false;   //正在关闭
	public boolean opening = false;    //正在打开
	public boolean open_state = false;  //打开状态
	public boolean close_state = false; //关闭状态
	public boolean compelling = false;  //被强制
	public boolean enjoin = false;     //禁止
	public boolean failure = false;   //设备故障或抑制
	float px[] = new float[3]; //三角形三顶点横坐标
	float py[] = new float[3]; //三角形三顶点纵坐标
	float lx[]=new float[2];//禁用斜杠横坐标
	float ly[]=new float[2];//禁用斜杠纵坐标
	public float aiData = 0;
	public void drawGraph(Canvas canvas) {
		if(percent>100) percent=100;
		else if(percent<0) percent=0;
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//使用抗锯齿功能
		//paint.setStyle(Paint.Style.FILL);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(2);
		int color = 0;
		canvas.save();//保存当前坐标状态
	     canvas.translate(cx, cy);//改变坐标系原点
		canvas.rotate(-rotateAngle, 0, 0);
		px[0]=-circle;   py[0]=0;
		px[1]=circle/2;  py[1]=(float) -0.866*circle;
		px[2]=circle/2;  py[2]=(float) 0.866*circle;
		lx[0]=(float) -0.707*circle;    ly[0]=(float) 0.707*circle;
		lx[1]=(float) 0.707*circle;     ly[1]=(float) -0.707*circle;
		
		if(enjoin){//禁止
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle, paint);
		     //黄色填充圆
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle*(100-aiData)/100, paint);
		     //绘制一个灰色填充的圆
		     paint.setColor(Color.BLACK);
		     paint.setStrokeWidth(3);
		     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
		     //绘制中间黑色三线
		     paint.setColor(Color.WHITE);
		     paint.setStrokeWidth(8);
		     canvas.drawLines(new float[]{lx[0],ly[0],lx[1],ly[1]}, paint);
		     //绘制白色斜直线
		     paint.setStrokeWidth(5);//x设置线条粗细
		     color = Color.argb(255, 0,139,139);
			 paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawCircle(0,0,circle, paint);
		     //绘制一个无填充的圆
		     }	 
		else if(closing){//正在关闭
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle, paint);
		     //黄色填充圆
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle*percent/100, paint);
		     //绘制一个灰色填充的圆
		     paint.setColor(Color.BLACK);
		     paint.setStrokeWidth(3);
		     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
		     //绘制中间黑色三线
		     paint.setStrokeWidth(5);//x设置线条粗细
		     if(aiData%10==0)color = Color.argb(255, 0,139,139);
		     else color=Color.WHITE;
			 paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawCircle(0,0,circle, paint);
		     //绘制一个无填充的圆
		     }
		 else if(opening){//正在打开
				 paint.setStrokeWidth(1);
			     paint.setColor(Color.argb(255,255,255,0));
			     paint.setStyle(Style.FILL);
			     canvas.drawCircle(0,0,circle, paint);
			     //黄色填充圆
				 paint.setStrokeWidth(1);
			     paint.setColor(Color.argb(255,81,81,81));
			     paint.setStyle(Style.FILL);
			     canvas.drawCircle(0,0,circle*(100-percent)/100, paint);
			     //绘制一个灰色填充的圆
			     paint.setColor(Color.BLACK);
			     paint.setStrokeWidth(3);
			     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
			     //绘制中间黑色三线
			     paint.setStrokeWidth(5);//x设置线条粗细
			     if(aiData%10==0) color = Color.argb(255, 124,252,0);
			      else  color=Color.argb(255, 0,139,139);
				 paint.setColor(color);
			     paint.setStyle(Style.STROKE);
			     canvas.drawCircle(0,0,circle, paint);
			     //绘制一个无填充的圆
			     }
		  else if (close_state) {//关闭状态
			  paint.setStrokeWidth(1);
			     paint.setColor(Color.argb(255,255,255,0));
			     paint.setStyle(Style.FILL);
			     canvas.drawCircle(0,0,circle, paint);
			     //黄色填充圆
				 paint.setStrokeWidth(1);
			     paint.setColor(Color.argb(255,81,81,81));
			     paint.setStyle(Style.FILL);
			     canvas.drawCircle(0,0,circle*percent/100, paint);
			     //绘制一个灰色填充的圆
		     paint.setColor(Color.BLACK);
		     paint.setStrokeWidth(3);
		     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
		     //绘制中间黑色三线
		     paint.setStrokeWidth(3);//设置线条粗细
		     paint.setColor(Color.argb(200,193,205,193));
		     canvas.drawLines(new float[]{px[0],py[0],px[1],py[1],px[1],py[1],px[2],py[2],px[2],py[2],px[0],py[0]}, paint);
			 //绘制白色的一个三角形
		     paint.setStrokeWidth(5);//x设置线条粗细
		     color = Color.argb(255, 0,139,139);
			 paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawCircle(0,0,circle, paint);
		     //绘制一个无填充的圆
		     }
		  else if (open_state) {//关闭状态
			  paint.setStrokeWidth(1);
			     paint.setColor(Color.argb(255,255,255,0));
			     paint.setStyle(Style.FILL);
			     canvas.drawCircle(0,0,circle, paint);
			     //黄色填充圆
				 paint.setStrokeWidth(1);
			     paint.setColor(Color.argb(255,81,81,81));
			     paint.setStyle(Style.FILL);
			     canvas.drawCircle(0,0,circle*(100-percent)/100, paint);
			     //绘制一个灰色填充的圆
			     paint.setColor(Color.BLACK);
			     paint.setStrokeWidth(3);
			     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
			     //绘制中间黑色三线
			     paint.setStrokeWidth(5);//x设置线条粗细
			     color = Color.argb(255, 0,139,139);
				 paint.setColor(color);
			     paint.setStyle(Style.STROKE);
			     canvas.drawCircle(0,0,circle, paint);
			     //绘制一个无填充的圆
			     }
		 else if(failure) { //设备故障或抑制
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle, paint);
		     //黄色填充圆
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle*(100-aiData)/100, paint);
		     //绘制一个灰色填充的圆
		     paint.setColor(Color.BLACK);
		     paint.setStrokeWidth(3);
		     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
		     //绘制中间黑色三线
		     paint.setStrokeWidth(5);//x设置线条粗细
			 paint.setColor(Color.RED);
		     paint.setStyle(Style.STROKE);
		     canvas.drawCircle(0,0,circle, paint);
		     //绘制一个无填充的圆
		     }	 
		 else if(compelling) {//被强制 
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle, paint);
		     //黄色填充圆
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle*(100-aiData)/100, paint);
		     //绘制一个灰色填充的圆
		     paint.setColor(Color.BLACK);
		     paint.setStrokeWidth(3);
		     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
		     //绘制中间黑色三线
		     paint.setColor(Color.RED);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(-circle,-circle,circle,circle, paint);
		     //绘制无填充的红色矩形
		     paint.setStrokeWidth(5);//x设置线条粗细
		     color = Color.argb(255, 0,139,139);
			 paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawCircle(0,0,circle, paint);
		     //绘制一个无填充的圆
		     }	 
		 else{
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle, paint);
		     //绘制一个灰色填充的圆
		     paint.setColor(Color.BLACK);
		     paint.setStrokeWidth(3);
		     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
		     //绘制中间黑色三线
		     paint.setStrokeWidth(5);//x设置线条粗细
		     color = Color.argb(255, 0,139,139);
			 paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawCircle(0,0,circle, paint);
		     //绘制一个无填充的圆
		 }
			 canvas.restore();	//恢复原来坐标状态
		 }
}