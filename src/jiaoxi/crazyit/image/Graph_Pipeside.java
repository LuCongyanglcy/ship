package jiaoxi.crazyit.image;

import java.text.DecimalFormat;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Paint.Style;

public class Graph_Pipeside {
	public float cx = 450;  //中心点X
	public float cz = 100;  //中心点Z
	public float p = 14;  //吸口到第一节点的长度占宽度的百分比，p+q+r<=100
	public float q = 37;  //耙臂第一截长度占宽度的百分比 p+q+r<=100
	public float r = 49;  //耙臂第二截长度占宽度的百分比 p+q+r<=100
	public float tideDepth = 5;//潮位高
	public float grayDepth = 20;//泥深
	public float depth0=-2;  //吸口深度
	public float depth1=20;  //耙臂一深度
	public float depth2=40;  //耙臂二深度
	public float lesty = 5;  //刻度尺最小刻度
	public float rectWidth = 400;   //矩形宽度
	public float rectHeight = 300;  //矩形高度
	public float rotateAngle = 0;     //旋转角度
	public boolean rightgray = true;   //是否为右耙
	public boolean standby = false;    //是否备用
	public boolean switchdirection=true;  //是否转换方向
	public int  suction= 4;  //吸口下标
	public int grayunder = 8;//耙头下标
	public int grayhigher = 1;//耙头上标
	float ptx[] = new float[4];//耙臂横坐标
	float pty[] = new float[5];//耙臂纵坐标
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//使用抗锯齿功能
		paint.setStyle(Paint.Style.FILL);
		//创建路径
		canvas.save();//保存当前坐标状态
	    float l=rectHeight/(grayhigher+grayunder);//最小刻度长度
	    float lx[]=new float[2];
	    float ly[]=new float[2];
	    float rx[]=new float[2];
	    float ry[]=new float[2];
	    lx[0]=-25*rectWidth/30;
	    lx[1]=-25*rectWidth/30;
	    ly[0]=-grayhigher*rectHeight/(grayunder+grayhigher);
	    ly[1]=grayunder*rectHeight/(grayunder+grayhigher);
	    //左刻度尺坐标
	    rx[0]=rectWidth/30;
	    rx[1]=rectWidth/30;
	    ry[0]=-grayhigher*rectHeight/(grayunder+grayhigher);
	    ry[1]=suction*rectHeight/(grayunder+grayhigher);
	    //右刻度尺坐标
	    float Lx=-12*rectWidth/15;//水位线右横坐标
	    float a= (float)Math.sqrt(((p+q)*rectWidth/132)*((p+q)*rectWidth/132)-(depth1-depth0)*(depth1-depth0)*(l*l)/(lesty*lesty));//耙臂第一阶长度
	    float b=(float)Math.sqrt((r*rectWidth/132)*(r*rectWidth/132)-(depth2-depth1)*(depth2-depth1)*(l*l)/(lesty*lesty));//耙臂第二阶长度
	    canvas.translate(cx, cz);//改变坐标系原点
		canvas.rotate(-rotateAngle, 0, 0);
		paint.setStyle(Style.STROKE);
		if(standby) paint.setColor(Color.GRAY);
		else paint.setColor(Color.YELLOW);
	    paint.setStrokeWidth(l/5);
	    pty[4]=depth0*l/lesty;
		ptx[1]=-a;
		pty[1]=depth1*l/lesty;
		ptx[0]=p/(p+q)*ptx[1];
		pty[0]=(p*pty[1]+q*pty[4])/(p+q);
		ptx[2]=ptx[1]-b;
		pty[2]=depth2*l/lesty;
		ptx[3]=ptx[2]-rectWidth/16;//耙头坐标
		pty[3]=depth2*l/lesty+l/3;;//耙头坐标
		//耙头坐标
		if(switchdirection){
			ptx[1]=a;
			ptx[0]=p/(p+q)*ptx[1];
			ptx[2]=ptx[1]+b;//耙臂坐标
			ptx[3]=ptx[2]+rectWidth/14;//耙头坐标
			lx[0]=-rectWidth/30;
			lx[1]=-rectWidth/30; //左刻度尺坐标
			ly[1]=suction*rectHeight/(grayunder+grayhigher);
		    rx[0]=25*rectWidth/30;
		    rx[1]=25*rectWidth/30;//右刻度尺坐标
		    ry[1]=grayunder*rectHeight/(grayunder+grayhigher);
		    Lx=12*rectWidth/15;//水位线右横坐标
		}
	    canvas.drawLines(new float[]{ptx[0],pty[0],0,pty[4]}, paint);
	    canvas.drawLines(new float[]{ptx[1],pty[1],ptx[0],pty[0]}, paint);//耙臂第一阶
	    canvas.drawLines(new float[]{ptx[2],pty[2],ptx[1],pty[1]}, paint);//耙臂第二阶
	     //绘制耙臂
	    DecimalFormat fnum = new DecimalFormat("0.00");
	    String s0=fnum.format(depth0);
		String s1=fnum.format(depth1);
		String s2=fnum.format(depth2);
	    paint.setTextSize(rectWidth/25);
	    paint.setStyle(Style.FILL);
	    paint.setColor(Color.GRAY);
	    canvas.drawText( s0,-rectWidth/34, pty[4]+4*l/5, paint);//吸口深度数值
	     canvas.drawText( s1,ptx[1]-rectWidth/30, pty[1]+4*l/5, paint);//第一截耙臂深度数值
	     canvas.drawText( s2,ptx[2]-rectWidth/30, pty[2]+4*l/5, paint);//第一截耙臂深度数值
	   
	    paint.setStrokeWidth(l/20);
	    canvas.drawLines(new float[]{lx[0],ly[0],lx[1],ly[1],},paint);//绘制左刻度尺
	    canvas.drawLines(new float[]{rx[0],ry[0],rx[1],ry[1],},paint);//绘制右刻度尺
	    for(int i=0;i<=grayhigher;i++){
	    	canvas.drawLines(new float[]{lx[0]-5,-i*l,lx[0],-i*l}, paint);
	    	canvas.drawLines(new float[]{rx[0]+5,-i*l,rx[0],-i*l}, paint);
		    paint.setTextSize(rectWidth/30);
		    paint.setStyle(Style.FILL);
		    int li=(int)(i*lesty);
		    String s=Integer.toString(li);
		     canvas.drawText( s,lx[0]-rectWidth/15, -i*l+l/8, paint);//左标刻度
		     canvas.drawText( s,rx[0]+rectWidth/30, -i*l+l/8, paint);//左标刻度
	    }//左右上相同长度刻度线及刻标值
	    for (int i=-suction;i<=0;i++)
	    {   canvas.drawLines(new float[]{lx[0]-5,-i*l,lx[0],-i*l}, paint);
	    	canvas.drawLines(new float[]{rx[0]+5,-i*l,rx[0],-i*l}, paint);
	        paint.setTextSize(rectWidth/30);
		    paint.setStyle(Style.FILL);
		    int li=(int)(-i*lesty);
		    String s=Integer.toString(li);
		     canvas.drawText( s,lx[0]-rectWidth/15, -i*l+l/8, paint);//左标刻度
		     canvas.drawText( s,rx[0]+rectWidth/30, -i*l+l/8, paint);//左标刻度
	    }
	    //左右下相同长度刻度线
	    for (int i=-grayunder;i<=-suction;i++) {
	      if(switchdirection){ 
	    	  paint.setColor(Color.GRAY);
	  	    paint.setStrokeWidth(l/20);
	    	  canvas.drawLines(new float[]{rx[0]+5,-i*l,rx[0],-i*l}, paint);
	  	    paint.setTextSize(rectWidth/30);
		    paint.setStyle(Style.FILL);
		    int li=(int)(-i*lesty);
		    String s=Integer.toString(li);
		     //canvas.drawText( s,lx[0]-rectWidth/15, -i*l+l/8, paint);//左标刻度
		     canvas.drawText( s,rx[0]+rectWidth/30, -i*l+l/8, paint);//左标刻度
	    	  paint.setStrokeWidth(l/10);
	  	    paint.setColor(Color.YELLOW);
	  	    paint.setStyle(Style.FILL);
	  	    canvas.drawLines(new float[]{lx[0]+l/20,pty[4],lx[0]+l/20,0}, paint);
	  	    canvas.drawLines(new float[]{rx[0]-l/20,pty[2],rx[0]-l/20,0}, paint);
	  	    //绘制左右刻度尺边指示黄线
	  
	      }
	      
	      else {
	    	  paint.setColor(Color.GRAY);
	  	    paint.setStrokeWidth(l/20);
	    	  canvas.drawLines(new float[]{lx[0]-5,-i*l,lx[0],-i*l}, paint);
	    	  paint.setTextSize(rectWidth/30);
			    paint.setStyle(Style.FILL);
			    int li=(int)(-i*lesty);
			    String s=Integer.toString(li);
			    canvas.drawText( s,lx[0]-rectWidth/15, -i*l+l/8, paint);//左标刻度
	    	  paint.setStrokeWidth(l/8);
	  	    paint.setColor(Color.YELLOW);
	  	    paint.setStyle(Style.FILL);
	  	    canvas.drawLines(new float[]{lx[0]+l/20,pty[2],lx[0]+l/20,0}, paint);
	  	    canvas.drawLines(new float[]{rx[0]-l/20,pty[4],rx[0]-l/20,0}, paint);
	  	    //绘制左右刻度尺边指示黄线
	      }//左右俩边下面多出的一截刻度线
	    } 
	    
	    paint.setColor(Color.argb(255,205,102,0));
	    paint.setStrokeWidth(l/20);
	    canvas.drawLines(new float[]{Lx,l*grayDepth/lesty,0,l*grayDepth/lesty}, paint);
	    //河底线位
	    
	    paint.setColor(Color.YELLOW);
	    paint.setStrokeWidth(l/17);
	    paint.setStyle(Style.STROKE);
	    canvas.drawCircle(0,pty[4],l/8, paint);
	    canvas.drawCircle(ptx[0],pty[0],l/8, paint);
	    canvas.drawCircle(ptx[1],pty[1],l/8, paint);
	    canvas.drawCircle(ptx[2],pty[2],l/8, paint);
	    //绘制耙吸黄圆圈
	 
	      Path path = new Path();
		    paint.setColor(Color.BLUE);  
			paint.setStrokeWidth(l/40);
			float h=-l*tideDepth/lesty;
			float g=-l*tideDepth/lesty;
			path.moveTo(0, h);
			path.lineTo(Lx, g);
			PathEffect effect = new DashPathEffect(new float[] { 4, 4, 4, 4}, 1);
			paint.setPathEffect(effect);
			canvas.drawPath(path, paint);
			//绘制蓝色虚线
			
		   paint.setColor(Color.argb(255,193,205,193));
		    paint.setStyle(Style.FILL);
		    paint.setStrokeWidth(1);
		    canvas.drawCircle(0,pty[4],l/9, paint);
		    canvas.drawCircle(ptx[0],pty[0],l/9, paint);
		    canvas.drawCircle(ptx[1],pty[1],l/9, paint);
		    canvas.drawCircle(ptx[2],pty[2],l/9, paint);
		    //绘制灰色填充
		    
	     if(rightgray) paint.setColor(Color.argb(255, 124,252,0));
	    else  paint.setColor(Color.RED);
	    paint.setStyle(Style.FILL);
	    Path mPath=new Path();
	    mPath.moveTo(ptx[3], pty[3]);
	    mPath.lineTo(ptx[2], pty[2]+l/5);
	    mPath.lineTo(ptx[2], pty[2]-l/6);
	    mPath.lineTo(3*ptx[3]/7+4*ptx[2]/7, pty[2]-l/4);
	    mPath.close(); 
	    canvas.drawPath(mPath,paint);
	     //绘制耙头  
	    canvas.restore();	//恢复原来坐标状态
	}
}
