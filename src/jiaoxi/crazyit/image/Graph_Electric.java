package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;

public class Graph_Electric {
	public float cx = 950;   //中心点X
	public float cy = 150;  //中心点Y
	public float circle=50;  //定义圆的半径
	public boolean ifcolor=true;   //判断颜色是否为红色
	public String string="G";  //中间文本内容
	public float aiData = 0;  //计时器
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//使用抗锯齿功能
		canvas.save();
		canvas.translate(cx, cy);  //改变坐标系原点
		 int color=0;//圈的颜色
			if(ifcolor) color=Color.GRAY;
			else color=Color.RED;
			paint.setColor(color);
		    paint.setStrokeWidth(circle/10);//x设置线条粗细
			paint.setStyle(Style.STROKE);
			canvas.drawCircle(0,0,circle, paint); //绘制一个无填充的圆
			paint.setColor(color);
			paint.setStyle(Style.FILL);
			paint.setTypeface(Typeface.SERIF );
			paint.setTextSize(5*circle/4);
			canvas.drawText(string, -3*circle/5, circle/2, paint);
			canvas.restore();	//恢复原来坐标状态
	}
}
