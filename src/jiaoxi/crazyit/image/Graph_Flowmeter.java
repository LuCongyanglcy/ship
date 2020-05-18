package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Paint.Style;

//横移摆宽
public class Graph_Flowmeter {
	public float cx = 950; // 中心点X
	public float cy = 550; // 中心点Y
	public float Circle = 800; // 圆表半径
	public float staff = -38.4f;// 密度表数值
	public float higherDepth=40;   //最高警戒线
	public float underDepth=-40;     //最低警戒线
	private int color = Color.RED;
	

	public void drawxx(Canvas canvas,float scale,int color){//其他箭头
		canvas.save(); 
		Paint paint = new Paint();
		Path path = new Path();
		paint.setColor(color);
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStyle(Style.FILL);
		
		canvas.rotate(scale);
		path.moveTo(-10, -Circle-15-30);
		path.lineTo(10, -Circle-15-30);
		path.lineTo(0,-Circle+5-30);
		path.close();
		canvas.drawPath(path, paint);
		canvas.restore();
	}
	public void drawxxs(Canvas canvas,float scale){//当前
		canvas.save(); 
		Paint paint = new Paint();
		Path path = new Path();
		paint.setColor(Color.GREEN);
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStyle(Style.FILL);
		
		canvas.rotate(scale);
		path.moveTo(-10, -Circle-15-30);
		path.lineTo(10, -Circle-15-30);
		path.lineTo(0,-Circle+5-30);
		path.close();
		String str = scale+"";
		canvas.drawPath(path, paint);
		
		paint.setTextSize(25);
		paint.setColor(Color.YELLOW);
		canvas.drawText(str, -20, -Circle+5-60, paint);
		canvas.restore();
	}
	public void drawx(Canvas canvas){//最大
		canvas.save(); 
		Paint paint = new Paint();
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStyle(Style.FILL);
		
		canvas.rotate(45);
		String str = 45+"";
		paint.setTextSize(25);
		paint.setColor(Color.YELLOW);
		canvas.drawText(str, -20, -Circle+60, paint);
		
		canvas.rotate(-90);
		str = -45+"";
		paint.setTextSize(25);
		paint.setColor(Color.YELLOW);
		canvas.drawText(str, -20, -Circle+60, paint);
		canvas.restore();
	}

	public void drawGraph(Canvas canvas) {
		canvas.save();
		canvas.translate(cx, cy); // 改变坐标系原点
		Paint paint = new Paint();
		paint.setAntiAlias(true); // 使用抗锯齿功能

		
		

		paint.setStyle(Style.STROKE);
		RectF oval001 = new RectF(-Circle, -Circle, Circle, Circle);// 设置个新的长方形，扫描测量
		
		paint.setColor(Color.GREEN);
		paint.setStrokeWidth(Circle / 400);
		for (int i = 1; i <= (11); i++) {
			float sin01 = (float)Math.sin((3.14159*i*9+113)/180);// 刻度
			float cos01 = (float)Math.cos((3.14159*i*9+113)/180);
			canvas.drawLine(-98*Circle*cos01/100, -98*Circle*sin01/100,
							-100*Circle*cos01/100, -100*Circle*sin01/100, paint);
		}
		color=Color.RED;
		drawxx(canvas,-45,color);
		drawxx(canvas,45,color);//最大角度
		color=Color.BLUE;
		drawxx(canvas,higherDepth,color);//警戒线
		drawxx(canvas,underDepth,color);
		color=Color.GREEN;
		drawxxs(canvas,staff);//当前角度
		drawx(canvas);
		
		
		paint.setStrokeWidth(Circle / 200);
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.GREEN);
		canvas.drawArc(oval001, -135, 90, false, paint);//密度表弧线
		
		
		// 最低警戒线 <= 待输入数值 <= 最高警戒线
		if(underDepth<= staff && staff<=higherDepth) paint.setColor(Color.GREEN);
		else paint.setColor(Color.RED);
		if(staff > 45) staff = 45;
		if(staff < -45) staff = -45;

		
		RectF oval002 = new RectF(-Circle*101/99, -Circle*101/99, Circle*101/99, Circle*101/99);// 设置个新的长方形，扫描测量
		canvas.drawArc(oval002, -90,staff, false,paint);//根据PLC状态画密度表状态

		canvas.restore(); // 恢复原来坐标状态
	}
}
