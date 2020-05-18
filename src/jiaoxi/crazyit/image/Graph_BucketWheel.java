package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;


public class Graph_BucketWheel {
	public float cx = 70;  //中心点X
	public float cy = 250;  //中心点Y
	public float sx = 1;//x轴放大倍数
	public float sy = 1;//y轴放大倍数
	public final float length =700;//机械臂长度
	public int color1 =Color.rgb(255, 140, 0);
	public int color2 =Color.rgb(255, 165, 0);
	public int color3 =Color.rgb(192, 192, 192);
	public int color4 =Color.rgb(50, 50, 50);
	public boolean run = true;//是否在运行
	public boolean reversal = false;//是否反转
	public int rotate=0;
	private int temp1=0;
	private int temp2=0;
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		canvas.save();
		canvas.translate(cx, cy);
		canvas.scale(sx, sy);
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStyle(Style.STROKE);
		
		RectF r = new RectF(-length-50,-200,400,800);
		paint.setColor(Color.WHITE);
		canvas.drawRect(r, paint);
		
		机械臂(canvas);
		
		canvas.restore();	//恢复原来坐标状态
     }
	void 背景(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		RectF r1 = new RectF();
		RectF r2 = new RectF();
		
		paint.setColor(Color.rgb(0, 128, 128));
		canvas.drawRect(r1, paint);
		paint.setColor(Color.rgb(0, 64, 64));
		canvas.drawRect(r2, paint);
	}
	void 旋转斗轮(Canvas canvas) {
		Paint paint =new Paint();
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setColor(color1);
		canvas.save();
		canvas.rotate(rotate, 0, 0);//旋转
		complete(canvas);
		canvas.restore();
	}
	void 机械臂(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		canvas.save();
		paint.setStrokeWidth(50);
		
		Shader shader1 = new LinearGradient(0,-20,0,20, new int[] {color2, color1, color2}, null,
				Shader.TileMode.MIRROR);
		paint.setShader(shader1);
		canvas.drawLine(-length, 0, 0, 0, paint);//机械臂
		
		Shader shader2 = new RadialGradient(-length,0,25, new int[] {color1, color2,color2}, null,
				Shader.TileMode.MIRROR);
		paint.setShader(shader2);
		RectF r = new RectF(-length-25,-25,-length+25,25);
		canvas.drawArc(r, 90, 180, false, paint);
		paint.setShader(null);
		
		旋转斗轮(canvas);
		canvas.restore();
	}
	void complete(Canvas canvas) {//拼装
		Paint paint = new Paint();
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
		
	}
	void edge(Canvas canvas) {//扇叶
		Paint paint = new Paint();
		Path path = new Path();
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStyle(Style.FILL);
		paint.setStrokeWidth(1);
		paint.setColor(color2);
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
	}
	void mid(Canvas canvas) {//中间的外六边形
		Paint paint = new Paint();
		Path path = new Path();
		canvas.save();
		canvas.rotate(30,0,0);
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStyle(Style.FILL);
		
		 int centre = 0;// 中心坐标
		 	int roundWidth=(int) (29);
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
		 	int roundWidth=(int) (20);
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
