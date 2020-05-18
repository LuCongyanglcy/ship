package jiaoxi.crazyit.image;

import java.text.DecimalFormat;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Graph_Ruler {
	
	public float cx = 70;  //中心点X
	public float cy = 250;  //中心点Y
	public float staff=550;//待输入数值
	public boolean alert;
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
	public int format=0;
	
	public void drawGraph(Canvas canvas) {
		
		Paint paint = new Paint();
		paint.setAntiAlias(true);		
		canvas.save();
		canvas.translate(cx, cy);
		canvas.rotate(-rotateAngle, 0, 0);

		DecimalFormat fnum1 = new DecimalFormat("##0.0");
		DecimalFormat fnum2 = new DecimalFormat("##0.00");
		
		
		float a;
		if(rulerhigher < staff)//x大于最高刻度
			a=rectHeight; 
		
		else if(rulerunder > staff)//x小于最低刻度
			a=0; 
		else
			//下标黄线长度
			a=rectHeight*(staff-rulerunder)/(rulerhigher-rulerunder);
			
		
		
		float l=rectHeight/rulermain;//最小刻度值
		float rx[]=new float[3]; //左右横坐标
		float ry[]=new float[3]; //上下纵坐标
		rx[0]=0; 
		rx[1]=rectWidth/6; 
		rx[2]=-5*rx[1]/2; 
		
		ry[0]=0;
		ry[1]=rectHeight-a;
		ry[2]=rectHeight;
		
		 
		if(switchdirection){
			rx[1]=-rectWidth/6; 
			rx[2]=-3*rx[1]/5;
		}
		
		 
		paint.setColor(Color.GRAY);
		paint.setStrokeWidth(rectWidth/3);
		canvas.drawLines(new float[]{rx[1],ry[0],rx[1],ry[1]}, paint);//灰色柱状图
		
		
		//上边灰色填充线
		if(alert&&staff!=0) {
			paint.setColor(Color.RED);
		}else if(alert==false&&staff!=0) {
			paint.setColor(Color.YELLOW);
		}
//		else paint.setColor(Color.RED);
		else paint.setColor(Color.GRAY);
		paint.setStrokeWidth(rectWidth/3);
		canvas.drawLines(new float[]{rx[1],ry[1],rx[1],ry[2]}, paint);//根据PLC画状态
		 
		//下面刻度指示线
		// paint.setColor(Color.BLUE);
		paint.setColor(Color.argb(255,245,245,245));
		paint.setStrokeWidth(rectWidth/50);
		canvas.drawLines(new float[]{rx[0],ry[0],rx[0],ry[2]}, paint);
		
		//刻度尺
		for(int i=1;i<=rulermain;i++)
		canvas.drawLines(new float[]{-3*rx[1]/10,i*l-l/2,rx[0],i*l-l/2}, paint); //刻度尺次刻度
		 
		for(int i=0;i<=rulermain;i++) {
			canvas.drawLines(new float[]{-2*rx[1]/5,i*l,rx[0],i*l}, paint);//刻度尺主刻度
			paint.setTextSize(rectWidth/7);
			paint.setStyle(Style.FILL);
			String s="";
			if(ifint) {
				int ln=(int)(rulerhigher-(rulerhigher-rulerunder)*i/rulermain);
				s=Integer.toString(ln);
			}
			else {
				float li=(float)(rulerhigher-(rulerhigher-rulerunder)*i/rulermain);
//				s=Float.toString(li);
				if(format==1) {
					s=fnum1.format(li);
				}
				if(format==2) {
					s=fnum2.format(li);
				}
			}
			canvas.drawText(s,rx[2], i*l+l/13, paint);//左标刻度
		} 
		
		canvas.restore();	//恢复原来坐标状态
     }
  }
