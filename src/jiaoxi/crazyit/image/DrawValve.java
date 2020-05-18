package jiaoxi.crazyit.image;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import java.math.*;

 class DrawValve {

	public float RotateAngle;  /* 顺时针旋转的角度*/
	public boolean OpenStatus;
//	public Rect DrawRect;
	public int left;
	public int right;
	public int top;
	public int bottom;
	
	public int RectPoint_x[]= new int[4];		///实际的4个点,0点 左上角,1为 左下角 2为右下角 3为右上角
	public int RectPoint_y[]= new int[4];		///实际的4个点,0点 左上角
	
	void GetRectPoint()
	{
		RectPoint_x[0] = (int)(GetCenterPoint_x() + ((-GetCenterPoint_x() + left)*Math.cos((double)RotateAngle) - (-GetCenterPoint_y() + top)*Math.sin((double)RotateAngle)));
		RectPoint_y[0] = (int)(GetCenterPoint_y() + ((-GetCenterPoint_x() + left)*Math.sin((double)RotateAngle) + (-GetCenterPoint_y() + top)*Math.cos((double)RotateAngle)));

		RectPoint_x[1] = (int)(GetCenterPoint_x() + ((-GetCenterPoint_x() + left)*Math.cos((double)RotateAngle) - (-GetCenterPoint_y() + bottom)*Math.sin((double)RotateAngle)));
		RectPoint_y[1] = (int)(GetCenterPoint_y() + ((-GetCenterPoint_x() + left)*Math.sin((double)RotateAngle) + (-GetCenterPoint_y() + bottom)*Math.cos((double)RotateAngle)));

		RectPoint_x[2] = (int)(GetCenterPoint_x() + ((-GetCenterPoint_x() + right)*Math.cos((double)RotateAngle) - (-GetCenterPoint_y() + bottom)*Math.sin((double)RotateAngle)));
		RectPoint_y[2] = (int)(GetCenterPoint_y() + ((-GetCenterPoint_x() + right)*Math.sin((double)RotateAngle) + (-GetCenterPoint_y() + bottom)*Math.cos((double)RotateAngle)));

		RectPoint_x[3] = (int)(GetCenterPoint_x() + ((-GetCenterPoint_x() + right)*Math.cos((double)RotateAngle) - (-GetCenterPoint_y() + top)*Math.sin((double)RotateAngle)));
		RectPoint_y[3] = (int)(GetCenterPoint_y() + ((-GetCenterPoint_x() + right)*Math.sin((double)RotateAngle) + (-GetCenterPoint_y() + top)*Math.cos((double)RotateAngle)));
		
	}
	
	int GetCenterPoint_x()
	{
	   return (left + right)/2;
	}
	
	int GetCenterPoint_y()
	{
	   return (top + bottom)/2;
	}
	
	void DrawValveStatus(Canvas canvas)
	{
	 Paint paint = new Paint();
	 paint.setAntiAlias(true);
	 if(OpenStatus == true )
	 paint.setColor(Color.GREEN);
	 else
		 paint.setColor(Color.GRAY); 
	 paint.setStyle(Paint.Style.FILL);
	 Path path1 = new Path();

	  path1.moveTo(RectPoint_x[0], RectPoint_y[0]);
	  path1.lineTo(GetCenterPoint_x(), GetCenterPoint_y());
	  path1.lineTo(RectPoint_x[3], RectPoint_y[3]);
//	  path1.lineTo(100, 100);
	 path1.close();
	 canvas.drawPath(path1, paint);

	 Path path2 = new Path();
//	  path2.moveTo(DrawRect.left, DrawRect.bottom);
//	  path2.lineTo(DrawRect.exactCenterX(), DrawRect.exactCenterY());
//	  path2.lineTo(DrawRect.right, DrawRect.bottom);
	  path2.moveTo(RectPoint_x[1], RectPoint_y[1]);
	  path2.lineTo(GetCenterPoint_x(), GetCenterPoint_y());
	  path2.lineTo(RectPoint_x[2], RectPoint_y[2]);
//	  path2.lineTo(100, 180);
	 path2.close();
	 canvas.drawPath(path2, paint);
	 
	}
}
