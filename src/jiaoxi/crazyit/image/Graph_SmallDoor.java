package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Graph_SmallDoor {
	public float cx = 70;       //中心点X
	public float cy = 90;       //中心点Y
	public float percent=60;  //填充量百分比
	public String szText = "";
	public float rectWidth = 80;   //小矩形宽度
	public float rectHeight = 70;  //小矩形高度
	public float rotateAngle = 0;  //旋转角度
	public boolean choiced = false;  //是否被选中
	public boolean bCtrlInthisWnd = false;   //在窗口中是否被允许控制
	public boolean closing = false;   //正在关闭
	public boolean opening = false;    //正在打开
	public boolean open_state = false;  //打开状态
	public boolean close_state = false; //关闭状态
	public boolean compelling = false;  //被强制
	public boolean enjoin = false;     //禁止
	public boolean failure = false;   //设备故障或抑制
	float lx[]=new float[2];//小矩形横坐标
	float ly[]=new float[2];//小矩形纵坐标
	float px[]=new float[2];//大矩形横坐标
	float py[]=new float[2];//大矩形纵坐标
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
		px[0]=-5*rectWidth/8;   py[0]=-9*rectHeight/16;
		px[1]=5*rectWidth/8;   py[1]=9*rectHeight/16;
		lx[0]=-rectWidth/2;   ly[0]=-rectHeight/2;
		lx[1]=rectWidth/2;   ly[1]=rectHeight/2;
	   if(enjoin){//设备故障或抑制
			 paint.setStrokeWidth(3);
			 color = Color.argb(255, 0,139,139); 
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //绘制无填充的矩形
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[1], paint);
		     //绘制一个灰色填充的矩形
		     paint.setColor(Color.WHITE);
		     paint.setStrokeWidth(8);
		     canvas.drawLines(new float[]{lx[0]+3,0,lx[1]-3,0}, paint);
		     //绘制白色直直线
		}
	   else if(closing){//正在关闭
			 paint.setStrokeWidth(3);
			 if(aiData%10==0) color = Color.argb(255, 0,139,139);
		      else  color=Color.argb(255,81,81,81);
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //绘制无填充的矩形
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[1]*(50-percent)/50,lx[1],ly[1], paint);
		     //绘制一个灰色填充的矩形
		     paint.setStrokeWidth(1);
			 paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[1]*(50-percent)/50, paint);
		     //绘制一个黄色填充的矩形
		     }
		else if(opening){//正在打开
			 paint.setStrokeWidth(3);
			 if(aiData%10==0) color = Color.argb(255, 124,252,0);
		      else  color=Color.argb(255, 0,139,139);
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //绘制无填充的矩形
			 paint.setStrokeWidth(1);
			 paint.setStrokeWidth(1);
			 paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     if(percent>100) percent=100;
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[0]*(50-percent)/50, paint);
		     //绘制一个黄色填充的矩形
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0]*(50-percent)/50,lx[1],ly[1], paint);
		     //绘制一个灰色填充的矩形
		     }
		else if(close_state){//关闭状态
			 paint.setStrokeWidth(3);
			 color = Color.argb(255, 0,139,139); 
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //绘制无填充的矩形
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[1]*(50-percent)/50,lx[1],ly[1], paint);
		     //绘制一个灰色填充的矩形
		     paint.setStrokeWidth(1);
			 paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[1]*(50-percent)/50, paint);
		     //绘制一个黄色填充的矩形
		}
		else if(open_state){//打开状态
			 paint.setStrokeWidth(3);
			 color = Color.argb(255, 0,139,139); 
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //绘制无填充的矩形
		     paint.setStrokeWidth(1);
			 paint.setStrokeWidth(1);
			 paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[0]*(50-percent)/50, paint);
		     //绘制一个黄色填充的矩形
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0]*(50-percent)/50,lx[1],ly[1], paint);
		     //绘制一个灰色填充的矩形
		}
		else if(failure){//设备故障或抑制
			 paint.setStrokeWidth(3);
			 color = Color.argb(255, 0,139,139); 
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //绘制无填充的矩形
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[1], paint);
		     //绘制一个灰色填充的矩形
		}
		else if(compelling){//被强制
			 paint.setStrokeWidth(3);
			 color = Color.argb(255, 0,139,139); 
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //绘制无填充的矩形
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[1], paint);
		     //绘制一个灰色填充的矩形
		     paint.setColor(Color.RED);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(5*px[0]/4,7*py[0]/6,5*px[1]/4,7*py[1]/6, paint);
		     //绘制无填充的红色矩形

		}
		else{
			paint.setStrokeWidth(3);
			 color = Color.argb(255, 0,139,139); 
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //绘制无填充的矩形
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[1], paint);
		     //绘制一个灰色填充的矩形
		}
	     canvas.restore();	//恢复原来坐标状态
		     }
	}