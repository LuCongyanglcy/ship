package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class Graph_Value {
	public float cx = 50;  //中心点X
	public float cy = 50;  //中心点Y
	public float rectWidth = 45;   //矩形宽度
	public float rectHeight = 25;  //矩形高度
	public float rotateAngle = 0;  //旋转角度
	public String szText = "";  //阀的名称
	public boolean choiced = false;  //是否被选中
	public boolean bCtrlInthisWnd = false;   //在窗口中是否被允许控制
	public boolean closeing = false;   //正在关闭
	public boolean opening = false;    //正在打开
	public boolean open_state = false;  //打开状态
	public boolean close_state = false; //关闭状态
	public boolean open_false = false;  //假开
	public boolean close_false = false;  //假关
	public boolean open_fail = false;    //打开失败
	public boolean close_fail = false;   //关闭失败
	public boolean open_allow = false;   //打开条件成立
	public boolean close_allow = false;  //关闭条件成立
	public boolean enjoin = false;     //禁止使用
	public boolean compelling = false;  //被强制
	public boolean bmanual = false;    //手动阀

	public float aiData = 0;
	
	float ptX[] = new float[6];
	float ptY[] = new float[6];

	float rectX[] = new float[4];
	float rectY[] = new float[4];

	
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//使用抗锯齿功能
		paint.setStyle(Paint.Style.FILL);

		//创建路径
		Path path = new Path();
		
		rectX[0] = cx- rectWidth/2;
		rectY[0] = cy-rectHeight/2;
		rectX[1] = cx - rectWidth/2;
		rectY[1] = cy + rectHeight/2;
		rectX[2] = cx + rectWidth/2;
		rectY[2] = cy + rectHeight/2;
		rectX[3] = cx + rectWidth/2;
		rectY[3] = cy - rectHeight/2;
		int color = 0;
		canvas.save();
		canvas.rotate(-rotateAngle, cx, cy);  
		//正在关
		if (closeing) {
			ptX[0] = (float) (rectWidth * (100 - aiData)/100.0 + cx-rectWidth/2);
			ptY[0] = (float) (rectHeight * (100 - aiData)/100.0 + cy - rectHeight/2);
			ptX[1] = (float) (rectWidth * (100 - aiData)/100.0 + cx-rectWidth/2);
			ptY[1] = (float) ((-rectHeight) * (100 - aiData)/100.0 + cy + rectHeight/2);
			ptX[2] = (float) (rectWidth/2 + cx);
			ptY[2] = (float) (rectHeight/2 + cy);
			ptX[3] = (float) (rectWidth/2 + cx);
			ptY[3] = (float) (cy - rectHeight/2);
				
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//闭合路径
			//选择画布，好像java中是顺时针为正，这里加了符号
		//	canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 128, 128, 128);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//绘制路径
		}
		//正在开
		else if (opening) {
			ptX[0] = (float) (-rectWidth * (100 - aiData)/100.0 + cx+rectWidth/2);
			ptY[0] = (float) (-rectHeight * (100 - aiData)/100.0 + cy + rectHeight/2);
			ptX[1] = (float) (-rectWidth * (100 - aiData)/100.0 + cx+rectWidth/2);
			ptY[1] = (float) ((rectHeight) * (100 - aiData)/100.0 + cy - rectHeight/2);
			ptX[2] = (float) (cx - rectWidth/2);
			ptY[2] = (float) (cy - rectHeight/2);
			ptX[3] = (float) (cx - rectWidth/2);
			ptY[3] = (float) (cy + rectHeight/2);
				
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//闭合路径
			//选择画布，好像java中是顺时针为正，这里加了符号
		//	canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 0, 255, 0);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//绘制路径
		}
		//打开状态与关闭状态同时成立
		else if (open_state && close_state) {
			ptX[0] = (float) (cx - rectWidth/2);
			ptY[0] = (float) (cy - rectHeight/2);
			ptX[1] = (float) (cx - rectWidth/2);
			ptY[1] = (float) (cy + rectHeight/2);
			ptX[2] = (float) (cx + rectWidth/2);
			ptY[2] = (float) (cy + rectHeight/2);
			ptX[3] = (float) (cx + rectWidth/2);
			ptY[3] = (float) (cy - rectHeight/2);
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//闭合路径
			//选择画布，好像java中是顺时针为正，这里加了符号
		//	canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 255, 0, 0);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//绘制路径
			ptX[0] = ptX[0] - 2;
			ptY[0] = ptY[0] - 2;
			ptX[1] = ptX[1] - 2;
			ptY[1] = ptY[1] + 2;
			ptX[2] = ptX[2] + 2;
			ptY[2] = ptY[2] + 2;
			ptX[3] = ptX[3] + 2;
			ptY[3] = ptY[3] - 2;

			canvas.drawLine(ptX[0], ptY[0], ptX[1], ptY[1], paint);
			canvas.drawLine(ptX[1], ptY[1], ptX[2], ptY[2], paint);
			canvas.drawLine(ptX[2], ptY[2], ptX[3], ptY[3], paint);
			canvas.drawLine(ptX[3], ptY[3], ptX[0], ptY[0], paint);
		}
		//假关9
		else if (close_false) {
			ptX[0] = (float) (cx - rectWidth/2);
			ptY[0] = (float) (cy - rectHeight/2);
			ptX[1] = (float) (cx - rectWidth/2);
			ptY[1] = (float) (cy + rectHeight/2);
			ptX[2] = (float) (cx + rectWidth/2);
			ptY[2] = (float) (cy + rectHeight/2);
			ptX[3] = (float) (cx + rectWidth/2);
			ptY[3] = (float) (cy - rectHeight/2);
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//闭合路径
			//选择画布，好像java中是顺时针为正，这里加了符号
		//	canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 0, 128, 0);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//绘制路径
			ptX[0] = ptX[0] - 2;
			ptY[0] = ptY[0] - 2;
			ptX[1] = ptX[1] - 2;
			ptY[1] = ptY[1] + 2;
			ptX[2] = ptX[2] + 2;
			ptY[2] = ptY[2] + 2;
			ptX[3] = ptX[3] + 2;
			ptY[3] = ptY[3] - 2;
			color = Color.argb(255, 255, 0, 0);
			paint.setColor(color);
			canvas.drawLine(ptX[0], ptY[0], ptX[1], ptY[1], paint);
			canvas.drawLine(ptX[1], ptY[1], ptX[2], ptY[2], paint);
			canvas.drawLine(ptX[2], ptY[2], ptX[3], ptY[3], paint);
			canvas.drawLine(ptX[3], ptY[3], ptX[0], ptY[0], paint);
		}
		//假开10
		else if (open_false) {
			ptX[0] = (float) (cx - rectWidth/2);
			ptY[0] = (float) (cy - rectHeight/2);
			ptX[1] = (float) (cx - rectWidth/2);
			ptY[1] = (float) (cy + rectHeight/2);
			ptX[2] = (float) (cx + rectWidth/2);
			ptY[2] = (float) (cy + rectHeight/2);
			ptX[3] = (float) (cx + rectWidth/2);
			ptY[3] = (float) (cy - rectHeight/2);
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//闭合路径
			//选择画布，好像java中是顺时针为正，这里加了符号
		//	canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 64, 64, 64);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//绘制路径
			ptX[0] = ptX[0] - 2;
			ptY[0] = ptY[0] - 2;
			ptX[1] = ptX[1] - 2;
			ptY[1] = ptY[1] + 2;
			ptX[2] = ptX[2] + 2;
			ptY[2] = ptY[2] + 2;
			ptX[3] = ptX[3] + 2;
			ptY[3] = ptY[3] - 2;
			color = Color.argb(255, 255, 0, 0);
			paint.setColor(color);
			canvas.drawLine(ptX[0], ptY[0], ptX[1], ptY[1], paint);
			canvas.drawLine(ptX[1], ptY[1], ptX[2], ptY[2], paint);
			canvas.drawLine(ptX[2], ptY[2], ptX[3], ptY[3], paint);
			canvas.drawLine(ptX[3], ptY[3], ptX[0], ptY[0], paint);
		}
		//开状态
		else if (open_state) {
			ptX[0] = (float) (cx - rectWidth/2);
			ptY[0] = (float) (cy - rectHeight/2);
			ptX[1] = (float) (cx - rectWidth/2);
			ptY[1] = (float) (cy + rectHeight/2);
			ptX[2] = (float) (cx + rectWidth/2);
			ptY[2] = (float) (cy + rectHeight/2);
			ptX[3] = (float) (cx + rectWidth/2);
			ptY[3] = (float) (cy - rectHeight/2);
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//闭合路径
			//选择画布，好像java中是顺时针为正，这里加了符号
			//canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 0, 255, 0);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//绘制路径
		}
		//关状态
		else if (close_state) {
			ptX[0] = (float) (cx - rectWidth/2);
			ptY[0] = (float) (cy - rectHeight/2);
			ptX[1] = (float) (cx - rectWidth/2);
			ptY[1] = (float) (cy + rectHeight/2);
			ptX[2] = (float) (cx + rectWidth/2);
			ptY[2] = (float) (cy + rectHeight/2);
			ptX[3] = (float) (cx + rectWidth/2);
			ptY[3] = (float) (cy - rectHeight/2);
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//闭合路径
			//选择画布，好像java中是顺时针为正，这里加了符号
			//canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 192, 192, 192);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//绘制路径
		}
		//打开失败
		else if (open_fail) {
			
			ptX[0] = (float) (-rectWidth * (100 - 80)/100.0 + cx+rectWidth/2);
			ptY[0] = (float) (-rectHeight * (100 - 80)/100.0 + cy + rectHeight/2);
			ptX[1] = (float) (-rectWidth * (100 - 80)/100.0 + cx+rectWidth/2);
			ptY[1] = (float) ((rectHeight) * (100 - 80)/100.0 + cy - rectHeight/2);
			ptX[2] = (float) (cx - rectWidth/2);
			ptY[2] = (float) (cy - rectHeight/2);
			ptX[3] = (float) (cx - rectWidth/2);
			ptY[3] = (float) (cy + rectHeight/2);
				
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//闭合路径
			//选择画布，好像java中是顺时针为正，这里加了符号
			//canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 0, 255, 0);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//绘制路径
		}
		//关闭失败
		else if (close_fail) {
			ptX[0] = (float) (rectWidth * (100 - 80)/100.0 + cx-rectWidth/2);
			ptY[0] = (float) (rectHeight * (100 - 80)/100.0 + cy - rectHeight/2);
			ptX[1] = (float) (rectWidth * (100 - 80)/100.0 + cx-rectWidth/2);
			ptY[1] = (float) ((-rectHeight) * (100 - 80)/100.0 + cy + rectHeight/2);
			ptX[2] = (float) (rectWidth/2 + cx);
			ptY[2] = (float) (rectHeight/2 + cy);
			ptX[3] = (float) (rectWidth/2 + cx);
			ptY[3] = (float) (cy - rectHeight/2);
				
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//闭合路径
			//选择画布，好像java中是顺时针为正，这里加了符号
			//canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 128, 128, 128);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//绘制路径
		}
		//打开条件成立
		else if (open_allow) {
			ptX[0] = (float) (-rectWidth * (100 - 70)/100.0 + cx+rectWidth/2);
			ptY[0] = (float) (-rectHeight * (100 - 70)/100.0 + cy + rectHeight/2);
			ptX[1] = (float) (-rectWidth * (100 - 70)/100.0 + cx+rectWidth/2);
			ptY[1] = (float) ((rectHeight) * (100 - 70)/100.0 + cy - rectHeight/2);
			ptX[2] = (float) (cx - rectWidth/2);
			ptY[2] = (float) (cy - rectHeight/2);
			ptX[3] = (float) (cx - rectWidth/2);
			ptY[3] = (float) (cy + rectHeight/2);
				
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//闭合路径
			//选择画布，好像java中是顺时针为正，这里加了符号
			//canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 0, 128, 0);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//绘制路径
		}
		//停止条件成立
		else if (close_allow) {
			ptX[0] = (float) (rectWidth * (100 - 70)/100.0 + cx-rectWidth/2);
			ptY[0] = (float) (rectHeight * (100 - 70)/100.0 + cy - rectHeight/2);
			ptX[1] = (float) (rectWidth * (100 - 70)/100.0 + cx-rectWidth/2);
			ptY[1] = (float) ((-rectHeight) * (100 - 70)/100.0 + cy + rectHeight/2);
			ptX[2] = (float) (rectWidth/2 + cx);
			ptY[2] = (float) (rectHeight/2 + cy);
			ptX[3] = (float) (rectWidth/2 + cx);
			ptY[3] = (float) (cy - rectHeight/2);
				
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//闭合路径
			//选择画布，好像java中是顺时针为正，这里加了符号
			//canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 64, 64, 64);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//绘制路径
		}
		else {
			ptX[0] = (float) (rectWidth * (100 - 80)/100.0 + cx-rectWidth/2);
			ptY[0] = (float) (rectHeight * (100 - 80)/100.0 + cy - rectHeight/2);
			ptX[1] = (float) (rectWidth * (100 - 80)/100.0 + cx-rectWidth/2);
			ptY[1] = (float) ((-rectHeight) * (100 - 80)/100.0 + cy + rectHeight/2);
			ptX[2] = (float) (rectWidth/2 + cx);
			ptY[2] = (float) (rectHeight/2 + cy);
			ptX[3] = (float) (rectWidth/2 + cx);
			ptY[3] = (float) (cy - rectHeight/2);
				
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//闭合路径
			//选择画布，好像java中是顺时针为正，这里加了符号
			//canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 0, 128, 128);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//绘制路径
		}
		
		//画闸阀框

		if (enjoin) {
			color = Color.argb(255, 128, 128, 128);
		}
		else if (close_fail || compelling) {
			color = Color.argb(255, 255, 0, 0);
		}
		else if (open_allow || close_allow) {
			color = Color.argb(255, 0, 255, 255);
		}
		else {
			color = Color.argb(255, 139, 139, 139);
		}
		ptX[0] = (float) (cx - rectWidth/2);
		ptY[0] = (float) (cy - rectHeight/2);
		ptX[1] = (float) (cx - rectWidth/2);
		ptY[1] = (float) (cy + rectHeight/2);
		ptX[2] = (float) (cx + rectWidth/2);
		ptY[2] = (float) (cy + rectHeight/2);
		ptX[3] = (float) (cx + rectWidth/2);
		ptY[3] = (float) (cy - rectHeight/2);
		paint.setColor(color);
		canvas.drawLine(ptX[0], ptY[0], ptX[2], ptY[2], paint);
		canvas.drawLine(ptX[1], ptY[1], ptX[3], ptY[3], paint);
		canvas.drawLine(ptX[2], ptY[2], ptX[3], ptY[3], paint);
		canvas.drawLine(ptX[0], ptY[0], ptX[1], ptY[1], paint);

		//设备被强制
		if (compelling) {
			color = Color.argb(255, 255, 0, 0);
			paint.setColor(color);
			canvas.drawLine(ptX[0], ptY[0], ptX[1], ptY[1], paint);
			canvas.drawLine(ptX[1], ptY[1], ptX[2], ptY[2], paint);
			canvas.drawLine(ptX[2], ptY[2], ptX[3], ptY[3], paint);
			canvas.drawLine(ptX[3], ptY[3], ptX[0], ptY[0], paint);
		}
		//手动阀
		if (bmanual) {
			ptX[4] = cx;
			ptY[4] = cy;
			ptX[5] = cx;
			ptY[5] = (float) (cy - rectHeight * (0.7));
			color = Color.argb(255, 128, 128, 128);
			paint.setColor(color);
			canvas.drawLine(ptX[4], ptY[4], ptX[5], ptY[5], paint);
			canvas.drawCircle(ptX[5], ptY[5], 2, paint);
		}
		canvas.restore();

	}
}
