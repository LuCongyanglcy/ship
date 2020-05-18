package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Shader;

public class Graph_Diesel {
	public float cx = 950;   //中心点X
	public float cy = 550;  //中心点Y
	public int num=5;  //缸数
	public boolean compelling = false;  //强制
	public boolean runing = false;  //运行状态
	public float rectWidth = 200;   //矩形宽度
	public float rectHeight = 250;   //矩形高度
	public void drawGraph(Canvas canvas) {
		float x=rectWidth/(20*num+110);
		float y=rectHeight/80;
		int color=0;
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//使用抗锯齿功能
		canvas.save();
		canvas.translate(cx, cy);  //改变坐标系原点
	    paint.setStrokeWidth(2);//设置线条粗细
	    if(compelling){ paint.setColor(Color.RED);
	          paint.setStyle(Style.STROKE);
	          canvas.drawRect(4,4,rectWidth-2*x,rectHeight-2*y, paint);
	        }
	    
	    if(runing)color=Color.GREEN;
	    else color=Color.GRAY;
	    paint.setColor(color);
	    paint.setStyle(Style.FILL);
	    Path mPath=new Path();
	    mPath.moveTo(22*x,35*y);
	    mPath.lineTo(30*x, 35*y);
	    mPath.lineTo(30*x, 39*y);
	    mPath.lineTo(rectWidth-22*x, 39*y);
	    mPath.lineTo(rectWidth-22*x, 70*y);
	    mPath.lineTo(32*x, 70*y);
	    mPath.lineTo(32*x, 47*y);
	    mPath.lineTo(22*x, 46*y);
	    mPath.close(); 
	    canvas.drawPath(mPath,paint);//绘制下面大多边形
	    canvas.drawRect(18*x,21*y,30*x-x,33*y, paint);//绘制左边上方(2,3)变色矩形
	    canvas.drawRect(rectWidth-22*x+x/2,46*y,rectWidth-15*x,64*y, paint);//绘制右边上方一变色矩形
	    canvas.drawRect(rectWidth-15*x+x/2,48*y,rectWidth-10*x,62*y, paint);//绘制右上方二变色矩形
	    canvas.drawRect(rectWidth-22*x+x/2,66*y,rectWidth-12*x,70*y, paint);//绘制右下方变色矩形
	    
	    Path nPath=new Path();
	    nPath.moveTo(30*x,21*y);
	    nPath.lineTo(30*x, 33*y);
	    nPath.lineTo(40*x, 31*y);
	    nPath.lineTo(40*x, 26*y);
	    nPath.close(); 
	    canvas.drawPath(nPath,paint);//绘制上方(2,3)变色梯形
	   
	    paint.setStrokeWidth(1);//设置线条粗细
	    paint.setStyle(Style.FILL);
	    Shader Shader20= new LinearGradient(21*x, 50*y, 21*x, 64*y, new int[] { Color.argb(140,148,148,148),
				 Color.argb(160,168,168,168), Color.argb(180,188,188,188),Color.argb(200,208,208,208),Color.argb(220,228,228,228),
				 Color.argb(200,208,208,208), Color.argb(180,188,188,188), Color.argb(160,168,168,168),
				  Color.argb(140,148,148,148), Color.argb(120,128,128,128)}, null, Shader.TileMode.REPEAT); // 一个材质,打造出一个线性梯度沿著一条线。  
		paint.setShader(Shader20); 
	    canvas.drawRect(16*x,53*y,26*x-x/2,61*y, paint);//绘制下左第二个渐变色矩形
	    canvas.drawRect(10*x,50*y,16*x,64*y, paint);//绘制下左第一个渐变色矩形
	    paint.reset();//重置
	    Shader Shader21= new LinearGradient(27*x, 21*y, 27*x, 33*y, new int[] { Color.argb(140,148,148,148),
				 Color.argb(160,168,168,168), Color.argb(180,188,188,188),Color.argb(200,208,208,208),Color.argb(220,228,228,228),
				 Color.argb(200,208,208,208), Color.argb(180,188,188,188), Color.argb(160,168,168,168),
				  Color.argb(140,148,148,148), Color.argb(120,128,128,128)}, null, Shader.TileMode.REPEAT); // 一个材质,打造出一个线性梯度沿著一条线。  
		paint.setShader(Shader21); 
	    canvas.drawRect(10*x,21*y,17*x,33*y, paint);//绘制上左第一个渐变色矩形
	    paint.reset();//重置
	    
	    paint.setColor(Color.LTGRAY);
	    paint.setStrokeWidth(2*y);//设置线条粗细
	    paint.setStyle(Style.FILL);
	    canvas.drawLines(new float[]{18*x,34*y+y,rectWidth-22*x,34*y+y}, paint);//绘制气缸中间灰线
	    Path oPath=new Path();
	    oPath.moveTo(26*x,53*y);
	    oPath.lineTo(32*x, 50*y);
	    oPath.lineTo(32*x, 64*y);
	    oPath.lineTo(26*x, 61*y);
	    oPath.close(); 
	    canvas.drawPath(oPath,paint);//绘制左下梯形
	    Path iPath=new Path();
	    iPath.moveTo(40*x,43*y);
	    iPath.lineTo(rectWidth-22*x,43*y);
	    iPath.lineTo(rectWidth-22*x, 53*y);
	    iPath.lineTo(43*x, 53*y);
	    iPath.lineTo(40*x, 50*y);
	    iPath.close(); 
	    canvas.drawPath(iPath,paint);//绘制中间多边形
	    paint.setColor(Color.BLACK);
	    paint.setStrokeWidth(1);//设置线条粗细
	    paint.setStyle(Style.STROKE);
	    canvas.drawLines(new float[]{38*x,43*y,rectWidth-22*x,43*y}, paint);
	    canvas.drawLines(new float[]{41*x,46*y,rectWidth-22*x,46*y}, paint);
	    canvas.drawLines(new float[]{41*x,53*y,rectWidth-22*x,53*y}, paint);
	    Path pPath=new Path();
	    pPath.moveTo(38*x,43*y);
	    pPath.lineTo(38*x,50*y);
	    pPath.lineTo(41*x, 53*y);
	    pPath.lineTo(41*x, 46*y);
	    pPath.close(); 
	    canvas.drawPath(pPath,paint);//绘制中间平行四边形形
	    
	    paint.setStrokeWidth(x/2);//设置线条粗细
	   for(int i=1;i<=num;i++){
		  // paint.setColor(color1);
		   /* 设置渐变色 这个正方形的颜色是改变的 */  
		 Shader Shader1 = new LinearGradient(40*x+25*(i-1)*x, 24*y, 57*x+25*(i-1)*x, 24*y, new int[] { Color.argb(140,148,148,148),
			 Color.argb(160,168,168,168), Color.argb(180,188,188,188),Color.argb(200,208,208,208),Color.argb(220,228,228,228),
			 Color.argb(200,208,208,208), Color.argb(180,188,188,188), Color.argb(160,168,168,168),
			  Color.argb(140,148,148,148), Color.argb(120,128,128,128)}, null, Shader.TileMode.REPEAT); // 一个材质,打造出一个线性梯度沿著一条线。  
	     paint.setShader(Shader1);  
	     paint.setStyle(Style.FILL);
	    canvas.drawRect(42*x+25*(i-1)*x,23*y,55*x+25*(i-1)*x,26*y-y/2, paint);//绘制气缸第一个渐变色矩形
	    canvas.drawRect(40*x+25*(i-1)*x,26*y,57*x+25*(i-1)*x,31*y, paint);//绘制气缸第二个渐变色矩形
	    canvas.drawRect(44*x+25*(i-1)*x,31*y+y/2,53*x+25*(i-1)*x,33*y+y/2, paint);//绘制气缸第三个渐变色矩形
	    canvas.drawRect(44*x+25*(i-1)*x,35*y+y,53*x+25*(i-1)*x,39*y-y/2, paint);//绘制气缸第四个渐变色矩形
	    paint.reset();//重置
	    
	    paint.setColor(Color.BLACK);
	    paint.setAntiAlias(true);		//使用抗锯齿功能
	    paint.setStyle(Style.STROKE);
	    canvas.drawRect(43*x+25*(i-1)*x,47*y,57*x+25*(i-1)*x,52*y, paint);//绘制圆上面矩形
	    canvas.drawCircle(50*x+25*(i-1)*x,60*y,3*x+3*y, paint);//绘制圆
	    }
	   Shader Shader11= new LinearGradient(15*x, 15*y, 32*x, 15*y, new int[] { Color.argb(140,148,148,148),
			 Color.argb(160,168,168,168), Color.argb(180,188,188,188),Color.argb(200,208,208,208),Color.argb(220,228,228,228),
			 Color.argb(200,208,208,208), Color.argb(180,188,188,188), Color.argb(160,168,168,168),
			  Color.argb(140,148,148,148), Color.argb(120,128,128,128)}, null, Shader.TileMode.REPEAT); // 一个材质,打造出一个线性梯度沿著一条线。  
	     paint.setShader(Shader11);  
	   paint.setStyle(Style.FILL);
	   canvas.drawRect(15*x,10*y,32*x,17*y-y/2, paint);//绘上方（2，1）第一个渐变色矩形
	   canvas.drawRect(18*x,17*y,29*x,21*y-y/2, paint);//绘制上方（2,2）第二个渐变色矩形
	   paint.reset();//重置
	    canvas.restore();	//恢复原来坐标状态
	}
}
