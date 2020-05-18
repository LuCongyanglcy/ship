package jiaoxi.crazyit.image;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Paint.Style;
//电机
public class Graph_Textcircle {
	public float cx = 950;   //中心点X
	public float cy = 150;  //中心点Y
	public float rectWidth=50;  //定义矩形宽
	public float rectHight=50;  //定义矩形宽
	public boolean ifcolor=false;   //判断颜色是否为红色
	public String string="G";  //中间文本内容
	public float aiData = 0;  //计时器
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//使用抗锯齿功能
		canvas.save();
		canvas.translate(cx, cy);  //改变坐标系原点
		 int color=0;//圈的颜色
			if(ifcolor) color=Color.GREEN;
			else color=Color.GRAY;
			paint.setColor(color);
		    paint.setStrokeWidth(rectWidth/20);//x设置线条粗细
		    
		    paint.setStyle(Style.STROKE);
		    RectF oval002 = new RectF(-rectWidth/2,-rectHight/2, rectWidth/2, rectHight/2);
		      canvas.drawArc(oval002, 0, 360, false, paint);
			paint.setColor(color);
			paint.setStyle(Style.FILL);
			paint.setTypeface(Typeface.SERIF );
			paint.setTextSize(5*rectWidth/8);
			canvas.drawText(string, -3*rectWidth/10, rectWidth/4, paint);
			 canvas.restore();	//恢复原来坐标状态
	}
}
