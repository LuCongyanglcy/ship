package jiaoxi.crazyit.image;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class DrawView extends View
{
	float preX;
	float preY;
	private Path path;
	public Paint paint = null;
	byte[] sendCommand={0x24, 0x41, 0x00, 0x62, 0x00, 0x00, 0x0A, 0xFB-256, 0x00, 0x04, 0x00, 0x00, 0x00, 0x00, 0x01, 0xD0-256, 0x0D, 0x0A, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256};
	
//	final int VIEW_WIDTH = 1280;///320
//	final int VIEW_HEIGHT = 800; //480;
	final int VIEW_WIDTH = 1280;///320
	final int VIEW_HEIGHT = 800; //480;
	final int FLIP_DISTANCE = 50;
	// 定义一个内存中的图片，该图片将作为缓冲区
	Bitmap cacheBitmap = null;
	// 定义cacheBitmap上的Canvas对象
	Canvas cacheCanvas = null;
	public DrawView(Context context, AttributeSet set)
//	public DrawView(Context context)
	{
		super(context,set);
		
//		HandDraw.valve4 = new DrawValve();
		// 创建一个与该View相同大小的缓存区
		cacheBitmap = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT,
				Config.ARGB_8888);
//		cacheBitmap[1] = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT,
//				Config.ARGB_8888);
//		cacheBitmap[2] = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT,
	//			Config.ARGB_8888);
		//GroupValves.InitValve();
	//	InitDevicePoint();
		cacheCanvas = new Canvas();
		//DrawValve valve1 = new valve1;
	//	valve1.OpenStatus= false;
		// 设置cacheCanvas将会绘制到内存中的cacheBitmap上
		cacheCanvas.setBitmap(cacheBitmap);

	}


	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		// 获取拖动事件的发生位置
		float x = event.getX();
		float y = event.getY();
	//	InitDevicePoint();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:

			switch (HandDraw1.CurrentPage) {
			case 001:
	/*			Page001.DrawPage(cacheCanvas);
				for (int i = 0; i < 50; i++) {
					if ((GroupValves.ValveItems[i].left < x && x < GroupValves.ValveItems[i].right)
							&& (GroupValves.ValveItems[i].top < y && y < GroupValves.ValveItems[i].bottom)) {
						if (GroupValves.ValveItems[i].OpenStatus) {
							myBinder.SendCommand(sendCommand);
				//			GroupValves.ValveItems[i].OpenStatus = false;
						} else
						HandDraw1.myBinder.sendCommand(sendCommand);

					}
				}*/
				break;
			case 002:
//				Page002.DrawPage(cacheCanvas);
//				for (int i = 0; i < 50; i++) {
//					if ((GroupValves.ValveItems[i].left < x && x < GroupValves.ValveItems[i].right)
//							&& (GroupValves.ValveItems[i].top < y && y < GroupValves.ValveItems[i].bottom)) {
//
////						HandDraw1.myBinder.sendCommand(sendCommand);
//
//					}
//				}
				break;
			}
			preX = x;
			preY = y;
			break;
		case MotionEvent.ACTION_MOVE:
			   
				break;
		case MotionEvent.ACTION_UP:
			/*
			 * cacheCanvas.drawPath(path, paint); // ① path.reset();
			 */
			break;
		}
		invalidate();
		// 返回true表明处理方法已经处理该事件
		return true;
	}

	@Override
	public void onDraw(Canvas canvas)
	{
		Paint bmpPaint = new Paint();
		// 将cacheBitmap绘制到该View组件上
		canvas.drawBitmap(cacheBitmap, 0, 0, bmpPaint);
		// ②
/*		switch (HandDraw1.CurrentPage) {
		case 001:
	//		canvas.drawBitmap(cacheBitmap[1], 0, 0, bmpPaint); // ②
			Page001.DrawPage(canvas);
		case 002:
	//		canvas.drawBitmap(cacheBitmap[2], 0, 0, bmpPaint); // ②
			Page002.DrawPage(canvas);
		}*/

	}
	
	public static void InitDevicePoint()		///初始化设备的位置信息
	{
		for (int i=0; i<GroupValves.Valve_NUM; i++)
		{
			GroupValves.ValveItems[i].left = 100+ i*40;
			GroupValves.ValveItems[i].right = 128 + i*40;
			GroupValves.ValveItems[i].top = 100;
			GroupValves.ValveItems[i].bottom = 154;
			GroupValves.ValveItems[i].RotateAngle = (float)(20.0*3.1415926/180.0);
			GroupValves.ValveItems[i].GetRectPoint();  //获得选择区域大小
		//valve2.add(valve1);	///增加
		//	GroupValves.ValveItems[i] = valve1;
		}

		
	}
	
	
}
