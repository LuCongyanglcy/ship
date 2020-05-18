package jiaoxi.crazyit.image;

/*import android.R; */
import java.util.Timer;
import java.util.TimerTask;

import jiaoxi.crazyit.classes.Caculate;


import jiaoxi.crazyit.image.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.StrictMode;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Description:
 * <br/>site: <a href="http://www.crazyit.org">crazyit.org</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class HandDraw1 extends Activity
{
	public static int CurrentPage;
	
	
//	private static final int float_NUM = 400; // final表示是一个常量
//	public static float RealData[] = new float[float_NUM];
	EmbossMaskFilter emboss;
	BlurMaskFilter blur;
//	DrawValve Valve4;
	public static CDataStruct StrData = new CDataStruct();

	Timer timer2;
	Timer timer3;

	Thread myThread;

	Caculate cacuData;

	private float[] aiData;
	private int aiNum;
	private byte[] diData;
	private int diNum;

	public static NewMyService.MyBinder myBinder;
	private ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			myBinder = (NewMyService.MyBinder) service;

		}
	};
	
	/* （非 Javadoc）
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO 自动生成的方法存根
		
		//////////填加菜单
		menu.add(Menu.NONE, Menu.FIRST+1, 1, "网络设置");
		menu.add(Menu.NONE,Menu.FIRST+2,2,"解码库设置");
		return super.onCreateOptionsMenu(menu);
	}

	/* （非 Javadoc）
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO 自动生成的方法存根
		//////注册菜单事件
		switch (item.getItemId()) {
		case Menu.FIRST+1:
			Intent intent1=new Intent();
			intent1.setClass(HandDraw1.this, SetNetConfig.class);
			
			startActivity(intent1); 
			break;
		case Menu.FIRST+2:
			Intent intent2=new Intent();
			intent2.setClass(HandDraw1.this,SetDecodeActivity.class);
			startActivity(intent2);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		if(connection!=null){
			unbindService(connection);
			connection=null;
//			Intent stopIntent=new Intent(AndroidDredgActivity1.this,MyService.class);
//			stopService(stopIntent);
		}
		if(timer2!=null){
			timer2.cancel();
			timer2=null;
		}
		
		super.onDestroy();
	}

	@Override
	/////监听返回键
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO 自动生成的方法存根
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
           //do something...
			
			new AlertDialog.Builder(this)
			.setTitle("退出")
			.setMessage("你确认退出吗?")
			.setPositiveButton("是", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO 自动生成的方法存根
					if(connection!=null){
						unbindService(connection);
						connection=null;
						Intent stopIntent=new Intent(HandDraw1.this,NewMyService.class);
						stopService(stopIntent);
						finish();
					}
				}
			})
			.setNegativeButton("否", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO 自动生成的方法存根
					return;
				}
			})
			.show();
            //return true;
        }
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.draw);
		final DrawView drawview = new DrawView(this,null); // 创建并实例化RabbitView类
		Intent bindIntent=new Intent(HandDraw1.this,NewMyService.class);
		bindService(bindIntent,connection,BIND_AUTO_CREATE);
		startService(bindIntent);
		
		if(timer2==null){
			timer2=new Timer();
			timer2.schedule(new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					//mPsTxt.setText("dddd");
					//cacuData=myBinder.getCaculate();
					//mPsTxt.setText(String.valueOf(cacuData.anlogData[40]));
//					aiNum=myBinder.getAiNum();
//					if(aiNum>0){
//						StrData.AIData=myBinder.getAiData();
//					}
//					diNum=myBinder.getDiNum();
//					if(diNum>0){
//						StrData.DIData=myBinder.getDiData();
//					}
					
					
	//				dt.postInvalidate();
				
				}
			}, 500);
		}
		
		if(timer3==null){
			timer3=new Timer();
			timer3.schedule(new TimerTask() {
				
				@Override
				public void run() {
					if(aiNum>0 && diNum>0){
						// TODO Auto-generated method stub
						//GroupValves.FillValveData();
						drawview.invalidate(); // 重绘drawview组件
					}
					
				}
			}, 500,300);
		}
		emboss = new EmbossMaskFilter(new float[] 
			{ 1.5f, 1.5f, 1.5f }, 0.6f,	6, 4.2f);
		blur = new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL);
		CurrentPage = 2;
		InitDevice();
	//	DrawView.InitDevicePoint();
		
	}
/*
	@Override
	// 负责创建选项菜单
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflator = new MenuInflater(this);
		// 装载R.menu.my_menu对应的菜单，并添加到menu中
		inflator.inflate(R.menu.my_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	// 菜单项被单击后的回调方法
	public boolean onOptionsItemSelected(MenuItem mi)
	{
		DrawView dv = (DrawView) findViewById(R.id.draw);
		// 判断单击的是哪个菜单项，并针对性的作出响应。
		switch (mi.getItemId())
		{
			case R.id.red:
				dv.paint.setColor(Color.RED);
				mi.setChecked(true);
				break;
			case R.id.green:
				dv.paint.setColor(Color.GREEN);
				mi.setChecked(true);
				break;
			case R.id.blue:
				dv.paint.setColor(Color.BLUE);
				mi.setChecked(true);
				break;
			case R.id.width_1:
				dv.paint.setStrokeWidth(1);
				break;
			case R.id.width_3:
				dv.paint.setStrokeWidth(3);
				break;
			case R.id.width_5:
				dv.paint.setStrokeWidth(5);
				break;
			case R.id.blur:
				dv.paint.setMaskFilter(blur);
				break;
			case R.id.emboss:
				dv.paint.setMaskFilter(emboss);
				break;
		}
		return true;
	}
	*/
	public void InitDevice()	///定义的设备数组实例化
	{
		GroupValves.InitValve();
		return;
	}
}