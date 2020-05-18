package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

//摆度
public class Graph_RunOut {
	
	public float cx = 70;  //中心点X
	public float cy = 250;  //中心点Y
	public float staff=40;//待输入数值
	public float rectWidth = 100;   //矩形宽度
	public float rectHeight = 350;   //矩形高度
	public float higherDepth=1400;   //最高警戒线
	public float underDepth=600;     //最低警戒线
	public float rulerhigher=1500; //最高刻度
	public float rulerunder=500;     //最低刻度
	public float rulermain = 5;    //刻度尺主等分
	public float rulersecond = 2;  //刻度尺次等分
	public float rotateAngle = 0;     //旋转角度
	public boolean switchdirection = false;  //是否转换方向
	public boolean ifint = false;  //是否整型刻度
	
	public void drawGraph(Canvas canvas) {
		
		Paint paint = new Paint();
		paint.setAntiAlias(true);		
		canvas.save();
		canvas.translate(cx, cy);
		canvas.rotate(rotateAngle, 0, 0);
		
		
		
		
		float a;
		if(rulerhigher < staff) a=rectWidth; 
		else if(rulerunder > staff) a=0; 
		else a=rectWidth*(-staff-rulerunder)/(rulerhigher-rulerunder);//下标黄线长度
			
		
		float rx[]=new float[4]; //左右横坐标
		float ry[]=new float[3]; //上下纵坐标
		
		rx[0]=0;
		rx[1]=rectWidth/2;
		rx[2]=rectWidth-a;
		rx[3]=rectWidth;
		
		ry[0]=0;
		ry[2]=rectHeight;
		

		
		paint.setStrokeWidth(3);
		paint.setColor(Color.GREEN);
		paint.setStyle(Style.STROKE);
		canvas.drawRect(rx[0], ry[0], rx[3], ry[2], paint);//矩形框
		
		//填充
		// 最低警戒线 <= 待输入数值 <= 最高警戒线
		if(underDepth<= staff && staff<=higherDepth) paint.setColor(Color.GREEN);
		else paint.setColor(Color.RED);
		paint.setStyle(Style.FILL);
		canvas.drawRect(rx[1], ry[0], rx[2], ry[2], paint);//根据PLC画状态

		paint.setTextSize(30);
		if(ifint) {
			int ss = (int) staff;
			String sss=Integer.toString(ss);
			canvas.drawText(sss, rx[2]*99/100, 4*ry[2]/2, paint);
		}
		else {
			Float ss = staff;
			String sss=Float.toString(ss);
			canvas.drawText(sss, rx[2]*99/100, 4*ry[2]/2, paint);
		}		
		


		
		
		
		
		
		//刻度尺
		float l=rectWidth/rulermain;//最小刻度值
		paint.setColor(Color.GREEN);
		for(int i=1;i<=rulermain;i++) canvas.drawLines(new float[]{i*l-l/2, ry[2], i*l-l/2, 6*ry[2]/5}, paint);//次刻度 
		 
		for(int i=0;i<=rulermain;i++) {
			canvas.drawLines(new float[]{i*l,ry[2], i*l, 3*ry[2]/2}, paint);//主刻度
			
			paint.setStyle(Style.FILL);
			String s;
			if(ifint) {
				int ln=(int)(rulerhigher-(rulerhigher-rulerunder)*i/rulermain);
				ln = -ln;
				s=Integer.toString(ln);
			}
			else {
				float li=(float)(rulerhigher-(rulerhigher-rulerunder)*i/rulermain);
				li = -li;
				s=Float.toString(li);
			}
			paint.setColor(Color.YELLOW);
			paint.setTextSize(30);
			canvas.drawText( s, i*l-l/12, ry[0],paint);//刻度数值
		} 
		
		canvas.restore();	//恢复原来坐标状态
     }
  }



