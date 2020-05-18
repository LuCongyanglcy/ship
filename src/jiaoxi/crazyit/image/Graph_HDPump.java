package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Paint.Style;
//液压泵
public class Graph_HDPump {
		public float cx = 50.0f;   //中心点X
		public float cy = 50.0f;   //中心点Y
		public boolean bArc = false;  //标志位，0为三角型，1为圆形
		public float rectWidth = 50;   //矩形宽度
		public float rectHeight = 50;  //矩形高度
		public float rotateAngle = 0;  //旋转角度
		public String szText = "";
		public boolean blink_sign = false;  //闪烁标志位，用来实现闪动
		public boolean start_faild = false;  //启动器失败
		public boolean running = false;    //正在执行运行指令
		public boolean stoping = false;    //正在执行停止命令
		public boolean run_status = false;  //运行状态
		public boolean run_faild = false;   //执行运行失败
		public boolean stop_faild = false;  //执行停止失败
		public boolean bprepared = false;   //准备就绪
		public boolean compelling = false;  //强制启动
		public boolean urgent_stop = false;  //紧急停止
		public boolean bAuto = false;       //遥控信号
		public boolean bChange = false;     //被替代
		public float aiData = 0;  //添加的模拟量
		
		
		public void drawGraph(Canvas canvas){
			Paint paint = new Paint();
			paint.setAntiAlias(true);  //使用抗锯齿功能
			paint.setStrokeWidth(3);
			float[] ptX = new float[10];
			float[] ptY = new float[10];
			ptX[0] = cx - rectWidth/2;
			ptY[0] = cy - rectHeight/2;
			ptX[1] = cx - rectWidth/2;
			ptY[1] = cy + rectHeight/2;
			ptX[2] = cx + rectWidth/2;
			ptY[2] = cy + rectHeight/2;
			ptX[3] = cx + rectWidth/2;
			ptY[3] = cy - rectHeight/2;
			int color =Color.GRAY;
			//paint.setColor(color);
			paint.setStyle(Style.FILL);
			Path path = new Path();
			Path path0 = new Path();
			//设置旋转
			canvas.save();
			canvas.rotate(-rotateAngle, cx, cy);
			if (bArc == false){
				ptX[4] = cx;
				ptY[4] = cy - rectHeight/2;
				ptX[5] = (float) (cx - rectWidth/2.0*Math.cos(Math.PI/6.0));
				ptY[5] = (float) (cy + rectHeight/2.0*Math.sin(Math.PI/6.0));
				ptX[6] = (float) (cx + rectWidth/2.0*Math.cos(Math.PI/6.0));
				ptY[6] = (float) (cy + rectHeight/2.0*Math.sin(Math.PI/6.0));
				path.moveTo(ptX[4], ptY[4]);
				path.lineTo(ptX[5], ptY[5]);
				path.lineTo(ptX[6], ptY[6]);
				path.close();
				if (start_faild) {
					color = Color.argb(255, 255, 0, 0);
					paint.setColor(color);
					canvas.drawPath(path, paint);
				}
				else if (running){
					color = Color.argb(255, 128, 128, 128);
					paint.setColor(color);
					canvas.drawPath(path, paint);
					ptX[7] = (float) ((ptX[5] - ptX[4])*(100 - aiData)/100.0 + ptX[4]);
					ptY[7] = (float) ((ptY[5] - ptY[4])*(100-aiData)/100.0 + ptY[4]);
					ptX[8] = (float) ((ptX[6] - ptX[4])*(100 - aiData)/100.0 + ptX[4]);
					ptY[8] = (float) ((ptY[6] - ptY[4])*(100-aiData)/100.0 + ptY[4]);
//					path0.moveTo(ptX[4], ptY[4]);
					path0.moveTo(ptX[5], ptY[5]);
					path0.lineTo(ptX[6], ptY[6]);
					path0.lineTo(ptX[8], ptY[8]);
					path0.lineTo(ptX[7], ptY[7]);
					path0.close();
					color = Color.argb(255, 0, 255, 0);
					paint.setColor(color);
					canvas.drawPath(path0, paint);
				}
				else if (stoping) {
					color = Color.argb(255, 0, 64, 0);
					paint.setColor(color);
					canvas.drawPath(path, paint);
					ptX[7] = (float) ((ptX[4] - ptX[5])*(100 - aiData)/100.0 + ptX[5]);
					ptY[7] = (float) ((ptY[4] - ptY[5])*(100-aiData)/100.0 + ptY[5]);
					ptX[8] = (float) ((ptX[4] - ptX[6])*(100 - aiData)/100.0 + ptX[6]);
					ptY[8] = (float) ((ptY[4] - ptY[6])*(100-aiData)/100.0 + ptY[6]);
					path0.moveTo(ptX[4], ptY[4]);
					path0.lineTo(ptX[8], ptY[8]);
					path0.lineTo(ptX[7], ptY[7]);
					path.close();
					color = Color.argb(255, 128, 128, 128);
					paint.setColor(color);
					canvas.drawPath(path0, paint);
				}
				else if (run_status){
					color = Color.argb(255, 0, 255, 0);
					paint.setColor(color);
					canvas.drawPath(path, paint);
				}
				else if (run_faild) {
					color = Color.argb(255, 128, 128, 128);
					paint.setColor(color);
					canvas.drawPath(path, paint);
					ptX[7] = (float) ((ptX[5] - ptX[4])*(100 - 30)/100.0 + ptX[4]);
					ptY[7] = (float) ((ptY[5] - ptY[4])*(100-30)/100.0 + ptY[4]);
					ptX[8] = (float) ((ptX[6] - ptX[4])*(100 - 30)/100.0 + ptX[4]);
					ptY[8] = (float) ((ptY[6] - ptY[4])*(100-30)/100.0 + ptY[4]);
	     			path0.moveTo(ptX[4], ptY[4]);
//					path.moveTo(ptX[5], ptY[5]);
//					path.lineTo(ptX[6], ptY[6]);
					path0.lineTo(ptX[8], ptY[8]);
					path0.lineTo(ptX[7], ptY[7]);
					path0.close();
					color = Color.argb(255, 255, 0, 0);
					paint.setColor(color);
					canvas.drawPath(path0, paint);
				}
				else if (stop_faild) {
					color = Color.argb(255, 128, 128, 128);
					paint.setColor(color);
					canvas.drawPath(path, paint);
					ptX[7] = (float) ((ptX[4] - ptX[5])*(100 - 30)/100.0 + ptX[5]);
					ptY[7] = (float) ((ptY[4] - ptY[5])*(100-30)/100.0 + ptY[5]);
					ptX[8] = (float) ((ptX[4] - ptX[6])*(100 - 30)/100.0 + ptX[6]);
					ptY[8] = (float) ((ptY[4] - ptY[6])*(100-30)/100.0 + ptY[6]);
					path0.moveTo(ptX[4], ptY[4]);
//					path0.moveTo(ptX[5], ptY[5]);
//					path0.lineTo(ptX[6], ptY[6]);
					path0.lineTo(ptX[8], ptY[8]);
					path0.lineTo(ptX[7], ptY[7]);
					path0.close();
					color = Color.argb(255, 0, 64, 0);
					paint.setColor(color);
					canvas.drawPath(path0, paint);
				}
				else{
					color = Color.argb(255, 128, 128, 128);
					paint.setColor(color);
					canvas.drawPath(path, paint);
				}
				/////////////////////////////////
				paint.setStyle(Style.STROKE);
				if (bprepared) {
					color = Color.argb(255, 0, 192, 192);
					paint.setColor(color);
					path.moveTo(ptX[4], ptY[4]);
					path.lineTo(ptX[5], ptY[5]);
					path.lineTo(ptX[6], ptY[6]);
					canvas.drawPath(path, paint);
				}
				if (compelling) {
					path.moveTo(ptX[0], ptY[0]);
					path.lineTo(ptX[1], ptY[1]);
					path.lineTo(ptX[2], ptY[2]);
					path.lineTo(ptX[3], ptY[3]);
					path.close();
					color = Color.argb(255, 255, 0, 0);
					paint.setColor(color);
					canvas.drawPath(path, paint);
				}
				
				if (urgent_stop) {
					color = Color.argb(255, 255, 0, 255);
				}
				else if (start_faild) {
					color = Color.argb(255, 255, 0, 0);
				}
				 
				else if (bChange) {
					color = Color.argb(255, 128, 128, 128);
				}
				else {
					color = Color.argb(255, 192, 192, 192);
				}
				if (bAuto) {
					color = Color.argb(255, 0, 192, 192);
				}
				paint.setColor(color);
				RectF drawRect = new RectF();
				drawRect.left = ptX[0];
				drawRect.top = ptY[0];
				drawRect.right = ptX[2];
				drawRect.bottom = ptY[2];
				canvas.drawArc(drawRect, 0, 360, false, paint);
			}
			else {  //圆形
				RectF rect1 = new RectF();
				RectF rect2 = new RectF();
				RectF rect3 = new RectF();
				RectF rect4 = new RectF();
				rect1.left = ptX[0];
				rect1.top = ptY[0];
				rect1.bottom = ptY[2];
				rect1.right = ptX[2];
				
				rect2.left = rect1.left+ rectWidth/20;
				rect2.top = rect1.top+ rectHeight/20;
				rect2.bottom = rect1.bottom- rectHeight/20;
				rect2.right = rect1.right - rectWidth/20;
				rect3.left = rect1.left+ rectWidth/10;
				rect3.top = rect1.top+ rectHeight/10;
				rect3.bottom = rect1.bottom- rectHeight/10;
				rect3.right = rect1.right - rectWidth/10;
				
				rect4.left = rect1.left+ rectWidth/3;
				rect4.top = rect1.top+ rectHeight/3;
				rect4.bottom = rect1.bottom- rectHeight/3;
				rect4.right = rect1.right - rectWidth/3;
				paint.setStrokeWidth(3);	
				/////////////////////////////////
                if (run_status) {
					color = Color.argb(255, 0, 255, 0);
					paint.setColor(color);				
					canvas.drawArc(rect1, 0, 360, false, paint);
					color =  Color.argb(255, 0, 0, 0);
					paint.setColor(color);
					canvas.drawArc(rect2, 0, 360, false, paint);
					color =  Color.argb(255, 0, 255, 0);
					paint.setColor(color);
					canvas.drawArc(rect3, 0, 360, false, paint);
					color =  Color.argb(255, 0, 0, 0);
					paint.setColor(color);
					canvas.drawArc(rect4, 0, 360, false, paint);	
				}
                else
                {
					color = Color.argb(255, 192, 192, 192);
					paint.setColor(color);				
					canvas.drawArc(rect1, 0, 360, false, paint);
					
					color =  Color.argb(255, 0, 0, 0);
					paint.setColor(color);
					canvas.drawArc(rect2, 0, 360, false, paint);
					
					color =  Color.argb(255, 192, 192, 192);
					paint.setColor(color);
					canvas.drawArc(rect3, 0, 360, false, paint);
					
					color =  Color.argb(255, 0, 0, 0);
					paint.setColor(color);
					canvas.drawArc(rect4, 0, 360, false, paint);
                }
			}
			canvas.restore();
		}
	}
