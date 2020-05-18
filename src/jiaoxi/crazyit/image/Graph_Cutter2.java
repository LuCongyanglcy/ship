package jiaoxi.crazyit.image;

import java.text.DecimalFormat;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Paint.Style;

public class Graph_Cutter2 {
	public float cx = 450;  //中心点X
	public float cy = 100;  //中心点y
	public float rectWidth = 800;   //矩形宽度
	public float rectHeight = 600;  //矩形高度
	public float muddeep = 6;  //泥深
	public float waterdeep = 1.0f;//控制变量吸口值	
	public float design_Deep = 15f;//控制变量深度
	public boolean bRun = true;  //运行信号
	public float aiData = 0;
	public float deep = 30;//设计挖深
	public float  rotateAngle= 10;//控制变量铰刀倾斜角度
	
	//2018/01/11
	private float centerx=0;//新中心点
	private float centery=0;
	public boolean run=false;
	public float rotate=0;
	public int color1 =Color.rgb(255, 140, 0);
	public int color2 =Color.rgb(255, 165, 0);
	public int color3 =Color.rgb(192, 192, 192);
	public int color4 =Color.rgb(50, 50, 50);
	public final float length =700;//机械臂长度
	private int temp1=0;
	private int temp2=0;
	public boolean reversal = false;//是否反转
	
	
	public void drawGraph(Canvas canvas) {
		canvas.save();//保存当前坐标状态
		
		canvas.translate(cx, cy);//改变坐标系原点
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//使用抗锯齿功能
		paint.setStyle(Paint.Style.FILL);
		paint.setStrokeWidth(1);
		paint.setColor(Color.argb(255, 0, 128, 128));//sea_color
		canvas.drawRect(0,7*rectHeight/60+(-waterdeep*rectHeight/24),rectWidth,(muddeep*20/deep)*rectHeight/24+7*rectHeight/60+(-waterdeep*rectHeight/24),paint);
		paint.setColor(Color.argb(255,0,64,64));//设计挖深颜色
		canvas.drawRect(0,(muddeep*20/deep)*rectHeight/24+7*rectHeight/60+(-waterdeep*rectHeight/24),rectWidth,26*rectHeight/24,paint);
		paint.setStrokeWidth(rectHeight/200);
		paint.setColor(Color.WHITE);
		paint.setStyle(Paint.Style.STROKE);
		canvas.drawRect(0,-rectHeight/24,rectWidth,26*rectHeight/24,paint);
		canvas.drawLines(new float[]{0,rectHeight/30,rectWidth/2,rectHeight/30},paint);
		canvas.drawLines(new float[]{0,rectHeight/5,19*rectWidth/40,rectHeight/5},paint);
		canvas.drawLines(new float[]{rectWidth/2,rectHeight/30,rectWidth/2,7*rectHeight/45},paint);
	    canvas.drawArc(new RectF(9*rectWidth/20,7*rectHeight/60,rectWidth/2,rectHeight/5),-5,105,false,paint);//绘制弧度
	    canvas.drawLines(new float[]{9*rectWidth/10,7*rectHeight/60+(-waterdeep*rectHeight/24),9*rectWidth/10,57*rectHeight/60+(-waterdeep*rectHeight/24)},paint);
	    for(int i=0;i<6;i++){
	    	canvas.drawLines(new float[]{9*rectWidth/10,(10*i+7)*rectHeight/60+(-waterdeep*rectHeight/24),56*rectWidth/60,(10*i+7)*rectHeight/60+(-waterdeep*rectHeight/24)},paint);
	    	 paint.setTextSize(rectWidth/25);
			    paint.setStyle(Style.FILL);
			    int li=(int)(i*deep/5);
			    String s=Integer.toString(li);
			    canvas.drawText( s,56*rectWidth/59,(10*i+8)*rectHeight/60+(-waterdeep*rectHeight/24) , paint);//右标刻度
	    
	    }
	    for(int j=0;j<5;j++){
	        canvas.drawLines(new float[]{9*rectWidth/10,(10*j+12)*rectHeight/60+(-waterdeep*rectHeight/24),55*rectWidth/60,(10*j+12)*rectHeight/60+(-waterdeep*rectHeight/24)},paint);
	    }
	    paint.setStrokeWidth(rectHeight/80);
		paint.setColor(Color.BLUE);
	    canvas.drawLines(new float[]{89*rectWidth/100,7*rectHeight/60+(-waterdeep*rectHeight/24),89*rectWidth/100,7*rectHeight/60+(-waterdeep*rectHeight/24)+(design_Deep*20/deep)*rectHeight/24},paint);//刻度指示线
	    
        float rotateAngle1=(float) Math.asin(((design_Deep*20/deep+(-waterdeep))*rectHeight/72)/(3*rectWidth/4));//角度
    	canvas.rotate(180*rotateAngle1,rectWidth/25,7*rectHeight/60);//旋转
    	paint.setStrokeWidth(rectHeight/80);
    	paint.setStyle(Style.FILL);
    	paint.setColor(Color.argb(255, 238, 208,1));
		paint.setAntiAlias(true);		//使用抗锯齿功能
		 canvas.drawArc(new RectF(rectWidth/25-rectHeight/30,rectHeight/12,rectWidth/25+rectHeight/30,3*rectHeight/20),85,190,false,paint);//绘制弧度
    	 canvas.drawRect(rectWidth/25,rectHeight/12,3*rectWidth/20,3*rectHeight/20,paint);
    	 Path Path=new Path();
		    Path.moveTo(3*rectWidth/20,rectHeight/12);
		    Path.lineTo(4*rectWidth/20,9*rectHeight/120);
		    Path.lineTo(4*rectWidth/20,19*rectHeight/120);
		    Path.lineTo(3*rectWidth/20,3*rectHeight/20);
		    Path.close(); 
		    canvas.drawPath(Path,paint);//填充
		  canvas.drawRect(4*rectWidth/20,9*rectHeight/120,11*rectWidth/20,19*rectHeight/120,paint);   
		  canvas.drawRect(11*rectWidth/20,8*rectHeight/120,57*rectWidth/100,20*rectHeight/120,paint); 
		  canvas.drawRect(57*rectWidth/100,9*rectHeight/120,61*rectWidth/100,19*rectHeight/120,paint);
		  paint.reset();//重置
		  
		
		  canvas.rotate(rotateAngle, 61*rectWidth/100, 7*rectHeight/60);
		  canvas.translate(64*rectWidth/101,7*rectHeight/60);//改变坐标系原点
			 float rectWidth1=3*rectWidth/23;
			 float rectHeight1=rectHeight/5;
			 paint.setStrokeWidth(1);
			 paint.setAntiAlias(true);		//使用抗锯齿功能
			 paint.setStyle(Paint.Style.FILL);
			 paint.setColor(Color.argb(255,225,170,0));
//			 canvas.drawArc(new RectF(-3*rectWidth1/20-rectHeight/24,-5*rectHeight1/24,-3*rectWidth1/20+rectHeight/24,5*rectHeight1/24),80,200,false,paint);//绘制弧度
			 旋转斗轮(canvas);
			 //2018/01/11
			 centerx=-3*rectWidth1/12;
			 centery=rectHeight1/20000;
		 
			 paint.setAntiAlias(true);		//使用抗锯齿功能
			 paint.setColor(Color.argb(255,238,201,0));
			 paint.setStrokeWidth(rectHeight1/48);
    	 paint.reset();//重置
    	 canvas.restore();	//恢复原来坐标状态
    	 canvas.save();//保存当前坐标状态
    	 canvas.translate(cx, cy);//改变坐标系原点
    	 paint.setStrokeWidth(rectHeight/200);
    	 paint.setAntiAlias(true);		//使用抗锯齿功能
 		 paint.setColor(Color.argb(255, 0, 128, 128));
 		 paint.setStyle(Paint.Style.FILL);
 		 canvas.drawCircle(rectWidth/25,7*rectHeight/60,rectHeight/70, paint);//绘制圆
 		 
 		 paint.setTextSize(rectWidth/25);
 	     paint.setStyle(Style.FILL);
 	     paint.setColor(Color.argb(255, 0, 228, 28));
 	     
 	     DecimalFormat fnum = new DecimalFormat("0.00");
 	     float cos=(float)( Math.cos(rotateAngle1));
	     String s0=fnum.format(waterdeep);
	     String s1=fnum.format(design_Deep);
 	     canvas.drawText( s0,rectWidth/50,12*rectHeight/60, paint);//吸口深度数值
 	     canvas.drawText( s1 ,3*rectWidth*cos/5,17*rectHeight/60+(-waterdeep*rectHeight/24)+(design_Deep*18/deep)*rectHeight/24, paint);//绞刀深度数值
		 canvas.restore();	//恢复原来坐标状态
	}
	void 旋转斗轮(Canvas canvas) {
		Paint paint =new Paint();
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setColor(color1);
		canvas.save();
		canvas.scale(0.6f, 0.6f);
		canvas.translate(centerx, centery);
		canvas.rotate(rotate, 0, 0);//旋转
		complete(canvas);
		canvas.restore();
	}
	void complete(Canvas canvas) {//拼装
		Paint paint = new Paint();
		canvas.save();
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setColor(color1);
		
		for(int i=0;i<8;i++) {
			canvas.rotate(45,0,0);
			edge(canvas);	
		}
//		paint.setStyle(Style.FILL);
//		canvas.drawCircle(0, 0, 30, paint);//中心圆环
		for(int i=0;i<6;i++) {
			canvas.rotate(60,0,0);
			temp(canvas);
		}
		mid(canvas);
		mid2(canvas);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(20);
		Shader shader = new RadialGradient(0,0,90, new int[] {color1, color3,color3, color1}, null,
				Shader.TileMode.MIRROR);
		paint.setShader(shader);
		canvas.drawCircle(0, 0, 90, paint);//外圈
		canvas.restore();
	}
	void edge(Canvas canvas) {//扇叶
		Paint paint = new Paint();
		Path path = new Path();
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStyle(Style.FILL);
		paint.setStrokeWidth(1);
		paint.setColor(color2);
		canvas.save();
		RectF r = new RectF(-50,-150,50,-20);
		
		if(reversal) {
			temp1=10;
			temp2=-100;
		}else {
			temp1=-10;
			temp2=100;
		}
		
		path.moveTo(temp1, -150);
		path.lineTo(0, -150);
		path.arcTo(r,-90,temp2);
		path.lineTo(0, -100);////1
		path.lineTo(0, -125);
		path.close();
		canvas.drawPath(path, paint);
		path.reset();
		canvas.restore();
	}
	void mid(Canvas canvas) {//中间的外六边形
		Paint paint = new Paint();
		Path path = new Path();
		canvas.save();
		canvas.rotate(30,0,0);
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStyle(Style.FILL);
		
		 int centre = 0;// 中心坐标
		 	int roundWidth=(int) (45);
	        int radius = (int) (centre - roundWidth / 2);// 六边形边长
	        paint.setColor(color1); // 设置圆环的颜色
	        paint.setStyle(Paint.Style.STROKE); // 设置空心
	        paint.setStrokeWidth(roundWidth); // 设置圆环的宽度
	        paint.setAntiAlias(true); // 消除锯齿
	        path.moveTo(centre - radius, centre); // A
	        path.lineTo(centre - radius / 2, (float) (centre - Math.sqrt(3)* radius / 2));// B
	        path.lineTo(centre + radius / 2, (float) (centre - Math.sqrt(3)* radius / 2));// C
	        path.lineTo(centre + radius, centre);// D
	        path.lineTo(centre + radius / 2,(float) ((Math.sqrt(3) * radius / 2) + centre));// E
	        path.lineTo(centre - radius / 2,(float) ((Math.sqrt(3) * radius / 2) + centre));// F
	        path.close();
	        canvas.drawPath(path, paint);
	        canvas.restore();
	}
	void mid2(Canvas canvas) {//中间的内六边形
		Paint paint = new Paint();
		Path path = new Path();
		canvas.save();
		canvas.rotate(30,0,0);
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStyle(Style.FILL);
		
		 int centre = 0;// 中心坐标
		 	int roundWidth=(int) (30);
	        int radius = (int) (centre - roundWidth / 2);// 六边形边长
	        paint.setColor(color2); // 设置圆环的颜色
	        paint.setStyle(Paint.Style.STROKE); // 设置空心
	        paint.setStrokeWidth(roundWidth); // 设置圆环的宽度
	        paint.setAntiAlias(true); // 消除锯齿
	        path.moveTo(centre - radius, centre); // A
	        path.lineTo(centre - radius / 2, (float) (centre - Math.sqrt(3)* radius / 2));// B
	        path.lineTo(centre + radius / 2, (float) (centre - Math.sqrt(3)* radius / 2));// C
	        path.lineTo(centre + radius, centre);// D
	        path.lineTo(centre + radius / 2,(float) ((Math.sqrt(3) * radius / 2) + centre));// E
	        path.lineTo(centre - radius / 2,(float) ((Math.sqrt(3) * radius / 2) + centre));// F
	        path.close();
	        canvas.drawPath(path, paint);
	        canvas.restore();
	}
	void temp(Canvas canvas) {//连接管道
		Paint paint = new Paint();
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStyle(Style.FILL);
		Shader shader = new LinearGradient(-5,0,5,0, new int[] {color4, color2, color4}, null,
				Shader.TileMode.MIRROR);
		paint.setShader(shader);
		paint.setStrokeWidth(10);
		canvas.drawLine(0, 0, 0, -100, paint);
	}
}