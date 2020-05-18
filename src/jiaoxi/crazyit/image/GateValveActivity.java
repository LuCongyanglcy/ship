package jiaoxi.crazyit.image;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import jiaoxi.crazyit.classes.Caculate;
import jiaoxi.crazyit.classes.Density;
import jiaoxi.crazyit.image.NewMyService;
import jiaoxi.crazyit.image.SeekWindowActivity;
import jiaoxi.crazyit.sql.DBHelper;
import jiaoxi.crazyit.image.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.StatFs;
import android.provider.UserDictionary.Words;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class GateValveActivity extends Activity implements OnGestureListener {

	float xInScreen;
	float yInScreen;
	float x1;
	float y1;
	float volumnRatio;
	public static boolean touch = false;

	public static Bitmap bmp10 = null;// 控制允许
	public static Bitmap bmp11 = null;// 取消控制

	// 切换桥架
	public static boolean control_limite = false;
	int s = 0;
	int j = 0;

	public static long SdVolume = 0;
	public String sdPath;
	// 时间，日期
	public String date;
	public CharSequence sysTimeStr = null;
	public static String dateString = null;
	// 图元计时器变量
	public int ii = 0;
	public int jj = 0;
	public int bb = 0;
	public int cc = 0;
	public static boolean stats = false;
	public static boolean drawerstats = false;

	// ///////界面数量
	final int bitmapNum = 5;
	final int PageNum = 5;
	// /////总图
	private Bitmap[] sBitmap = new Bitmap[bitmapNum];
	// 抽屉类
	private DrawerLayout mDrawerLayout = null;
	private ListView mDrawerList = null;

	private String[] mPlanetTitles = null;
	// ////第几个界面
	private int bId = 0;

	final int VIEW_WIDTH = 2560;// /320
	final int VIEW_HEIGHT = 1600; // 480;
	final int FLIP_DISTANCE = 150;

	private ViewFlipper viewFilipper = null;
	private GestureDetector gestrueDetector = null;

	private final String[] mLabelArray = { "View1", "View2", "View3", "View4", "View5" };
	private final int color_red = Color.argb(100, 200, 0, 0);
	private final int color_green = Color.argb(100, 0, 200, 0);
	private final int color_blue = Color.argb(100, 0, 0, 200);
	private final int color_yellow = Color.argb(100, 200, 200, 0);
	private final int color_purple = Color.argb(100, 200, 0, 200);
	private final int[] mColorArray = { color_red, color_green, color_blue, color_yellow, color_purple };

	private FlingGallery gallery = null;;

	private SoundPool sp = null;// 声明一个SoundPool
	private int music = 0;// 定义一个整型用load（）；来设置suondID

	// 加载的图片
	static Bitmap bmp1 = null;
	static Bitmap bmp2 = null;
	static Bitmap bmp3 = null;
	static Bitmap bmp4 = null;
	static Bitmap bmp5 = null;
	static Bitmap bmp6 = null;
	// 电量
	public static int battery = 0;
	// wifi强度
	public static String ip = "";
	public static int ipAddress = 0;
	public WifiManager wm; // WifiManager在包 android.net.wifi.WifiManager中
	public WifiInfo wi; // WifiInfo在包android.net.wifi.WifiInfo中
	public static int strength; // 信号强度

	// private Bitmap sBitmap2=null;

	// ///刷新定时器
	private Timer reTimer = null;

	// ///保持屏幕常亮
	PowerManager powerManager = null;
	WakeLock wakeLock = null;

	// 2018/2/1报警数据库
	// private SQLiteDatabase DB;
	Date curDate;
	private String alarmstate = "";
	SimpleDateFormat formatter;
	TextView txt1;
	TextView txt2;
	TextView txt3;
	java.util.Date datesq = new java.util.Date();
	int AutoDelete = 0;
	String state1 = "正常";
	String state2 = "报警";

	// 2018/3/6 曲线数据库

	//设定窗口
	private String[] str= new String[4];
	private EditText[] et=new EditText[3];
	private Button ok;
	private View sv;
	private AlertDialog ad;


	//////////

	/////// 服务
	private NewMyService.MyBinder myBinder;
	private ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			myBinder = (NewMyService.MyBinder) service;
			cacuDate = myBinder.getCaculate();
			reTimer = new Timer();
			reTimer.schedule(new TimerTask() {

				@Override
				public void run() {
					// TODO 自动生成的方法存根
					Canvas c = new Canvas(sBitmap[0]);
					Canvas c1 = new Canvas(sBitmap[1]);
					Canvas c2 = new Canvas(sBitmap[2]);
					Canvas c3 = new Canvas(sBitmap[3]);
					Canvas c4 = new Canvas(sBitmap[4]);
					c.drawColor(Color.TRANSPARENT, Mode.CLEAR);
					c1.drawColor(Color.TRANSPARENT, Mode.CLEAR);
					c2.drawColor(Color.TRANSPARENT, Mode.CLEAR);
					c3.drawColor(Color.TRANSPARENT, Mode.CLEAR);
					c4.drawColor(Color.TRANSPARENT, Mode.CLEAR);
					drawGateValve();
					viewFilipper.postInvalidate();

					GroupDredgePump.FillValveData(cacuDate); // 泥泵
					// GoupButtons.FillValveData(cacuDate,stats);//按钮
					// GoupShowButtons.FillValveData(cacuDate);//显示按钮
					GroupLine.FillValveData(cacuDate);// 线
					GroupText.FillValveData(cacuDate);// 数值文本
					GroupRuler.FillValveData(cacuDate); // 数值标尺
					Group_BJD.FillValveData(cacuDate); // 报警灯
					GroupHDPump.FillValveData(cacuDate, ii);// 液压泵
					GroupCutter2.FillValveData(cacuDate, ii); // 桥架2
					GroupClutch.FillValveData(cacuDate); // 离合器
					GroupCutterWheel.FillValveData(cacuDate, jj); // 绞刀头
					GroupDiesel.FillValveData(cacuDate); // 柴油机
					GroupSolenoidValve.FillValveData(cacuDate); // 电磁阀
					GroupBucketWheel.FillValveData(cacuDate, ii);// 斗轮
					GroupFlowmeter.FillValveData(cacuDate);// 船体角度
					GroupRunOut.FillValveData(cacuDate);// 船体摆渡

					SdVolume = getSDFreeSize();

					getworking_status(cacuDate);
					jj += 20;
					if (jj > 360) {
						jj = 0;
					}
					ii += 5;
					if (ii > 100) {
						ii = 0;
					}
					stats = !stats;



					//计算浓度 流量
					Density.Concentration=(cacuDate.anlogData[100 + 32]-Density.Waterdensity)/(Density.Soildensity-Density.Waterdensity)*100;//(数据字典产量-水密度)/(土密度-水密度)*100;
					Density.flow=cacuDate.anlogData[100 + 32]*Math.PI*Density.Pipediameter*Density.Pipediameter/4*3600;//流速*π*流量计管径*流量计管径/4*3600;

					//计算小时产量率
					Density.Hourlyyield=Density.Concentration*Density.flow/100;
					//Density.Hourlyyield=3600;
					//累计产量
					Density.Cumulativeoutput+=Density.Hourlyyield/3600;


					cc++;
					if(cc>=60){
						cc=0;
						str[0]= String.valueOf(Density.Waterdensity);
						str[1]= String.valueOf(Density.Soildensity);
						str[2]= String.valueOf(Density.Pipediameter);
						str[3]= String.valueOf(Density.Cumulativeoutput);
						stringTxt(str);//保存
					}




				}
			}, 1000, 500);
		}
	};


	@Override
	protected void onDestroy() {

		// TODO 自动生成的方法存根
		if (connection != null) {
			unbindService(connection);
			connection = null;
		}
		if (reTimer != null) {
			reTimer.cancel();
			reTimer = null;
		}
		synchronized (sBitmap) {
			if (sBitmap != null) {
				sBitmap[0].recycle();
				sBitmap[1].recycle();
				sBitmap[2].recycle();
				sBitmap[3].recycle();
				sBitmap[4].recycle();
				sBitmap = null;
			}
			bmp1 = null;
			bmp2 = null;
			bmp3 = null;
			bmp4 = null;
			bmp5 = null;
			bmp6 = null;

			bmp10.recycle();
			bmp11.recycle();

			bmp10 = null;
			bmp11 = null;

		}
		unregisterReceiver(batteryChangedReceiver);
		super.onDestroy();
	}

	////////////// 画图
	private void drawGateValve() {
		drawBitmapById(bId);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		new TimeThread().start(); // 时间
		setContentView(R.layout.activity_gate_valve);

		sdPath = Environment.getExternalStorageDirectory().getPath();
		////// 保持屏幕常亮
		this.powerManager = (PowerManager) this.getSystemService(Context.POWER_SERVICE);
		this.wakeLock = this.powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Lock");

		bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_power); // Bitmap对象
		bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_trolley); // Bitmap对象
		bmp3 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_propeller); // Bitmap对象
		// bmp4 = BitmapFactory.decodeResource(getResources(), R.drawable.bp_bianpin);
		// //Bitmap对象
		bmp4 = BitmapFactory.decodeResource(getResources(), R.drawable.transducer0); // Bitmap对象
		bmp5 = BitmapFactory.decodeResource(getResources(), R.drawable.structure37); // Bitmap对象
		bmp6 = BitmapFactory.decodeResource(getResources(), R.drawable.structure13); // Bitmap对象

		bmp10 = BitmapFactory.decodeResource(getResources(), R.drawable.control_allows); // Bitmap对象
		bmp11 = BitmapFactory.decodeResource(getResources(), R.drawable.control_cancel); // Bitmap对象

		// 注册一个接受广播类型 读电量
		registerReceiver(batteryChangedReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

		///// 绑定服务
		Intent bindIntent = new Intent(GateValveActivity.this, NewMyService.class);
		bindService(bindIntent, connection, BIND_AUTO_CREATE);

		// Intent bindIntent1=new Intent(GateValveActivity.this,HipriService.class);
		// startService(bindIntent1);

		viewFilipper = (ViewFlipper) findViewById(R.id.viewFlipperValve);
		gestrueDetector = new GestureDetector(this);

		sBitmap[0] = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT, Bitmap.Config.ARGB_8888);
		sBitmap[1] = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT, Bitmap.Config.ARGB_8888);
		sBitmap[2] = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT, Bitmap.Config.ARGB_8888);
		sBitmap[3] = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT, Bitmap.Config.ARGB_8888);
		sBitmap[4] = Bitmap.createBitmap(VIEW_WIDTH, VIEW_HEIGHT, Bitmap.Config.ARGB_8888);
		for (int i = 0; i < bitmapNum; i++) {

			synchronized (sBitmap) {
				ImageView image = new ImageView(GateValveActivity.this);
				image.setImageBitmap(sBitmap[i]);
				image.setScaleType(ImageView.ScaleType.FIT_XY);
				image.setLongClickable(true);
				viewFilipper.addView(image, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));

			}
		}

		// 抽屉类 的实现
		mPlanetTitles = getResources().getStringArray(R.array.planets_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// set a custom shadow that overlays the main content when the drawer
		// opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		// set up the drawer's list view with items and click listener
		mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mPlanetTitles));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		sp = new SoundPool(2, AudioManager.STREAM_SYSTEM, 5);// 第一个参数为同时播放数据流的最大个数，第二数据流类型，第三为声音质量
		music = sp.load(this, R.raw.touch, 1); // 把你的声音素材放到res/raw里，第2个参数即为资源文件，第3个为音乐的优先级
		AudioManager am = (AudioManager) this.getSystemService(this.AUDIO_SERVICE);// 实例化AudioManager 对象
		float audioMaxVolumn = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);// 返回当前AudioManager
																				// 对象的最大音量值
		float audioCurrentVolumn = am.getStreamVolume(AudioManager.STREAM_MUSIC);// 返回当前AudioManager
																					// 对象的音量值
		volumnRatio = audioCurrentVolumn / audioMaxVolumn;

		GroupDredgePump.InitValve();// 泥泵
		GroupLine.InitValve(); // 状态线条
		GroupText.InitValve(); // 数值文本
		GroupRuler.InitValve(); // 数值标尺
		Group_BJD.InitValve(); // 报警灯
		GroupHDPump.InitValve();// 液压泵
		GroupCutter2.InitValve();// 桥架
		GroupCutterWheel.InitValve();// 绞刀头
		GroupDiesel.InitValve();// 柴油机
		GroupSolenoidValve.InitValve();// 电磁阀
		GroupBucketWheel.InitValve();

		GroupRunOut.InitValve();
		GroupFlowmeter.InitValve();
		NewGroupValves.InitValve();
		GroupTextcircle.InitValve();
		GroupClutch.InitValve();

		txt1 = (TextView) findViewById(R.id.text1);
		txt2 = (TextView) findViewById(R.id.text2);
		txt3 = (TextView) findViewById(R.id.text3);


		makeFilePath("/mnt/sdcard/mingrun/","setting.txt");
		//读取水密度 土密度
		try {
			Density.Waterdensity=Float.valueOf(read(0));
			Density.Soildensity=Float.valueOf(read(1));
			Density.Pipediameter=Float.valueOf(read(2));
			//读取累计产量
			Density.Cumulativeoutput=Float.valueOf(read(3));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 抽屉类的实现
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			selectItem(position);
		}
	}

	private void selectItem(int position) {

		mDrawerList.setItemChecked(position, true);
		switch (position) {
		case 0:
			Intent intent = new Intent();
			intent.setClass(GateValveActivity.this, SetNetConfig.class);
			startActivity(intent);
			break;
		case 1:
			Intent intent1 = new Intent();
			intent1.setClass(GateValveActivity.this, SetGpsConfig.class);
			startActivity(intent1);
			break;
		case 2:

			try {
				setting();//设置
			} catch (IOException e) {
				e.printStackTrace();
			}
			ad = new AlertDialog.Builder(GateValveActivity.this)
					.setView(sv)
					.show();
			WindowManager.LayoutParams params = ad.getWindow().getAttributes();
			//params.width = 750;
			//params.height = 1200;
			ad.getWindow().setAttributes(params);
			//ad.setView(view, 0, 0, 0, 0);



			break;
		case 3:

			File file = new File(sdPath + "/mingrun/docment.pdf");
			if (file.exists()) {
				Uri path = Uri.fromFile(file);
				Intent intent4 = new Intent(Intent.ACTION_VIEW);
				intent4.setDataAndType(path, "application/pdf");
				intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				try {
					startActivity(intent4);
				} catch (ActivityNotFoundException e) {
					Toast.makeText(this, "No Application Available to View PDF", Toast.LENGTH_SHORT).show();
				}
			}
			break;
		}
	}

	// 接受广播电量
	private BroadcastReceiver batteryChangedReceiver = new BroadcastReceiver() {

		public void onReceive(Context context, Intent intent) {
			if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
				int level = intent.getIntExtra("level", 0);
				int scale = intent.getIntExtra("scale", 100);
				battery = level * 100 / scale;
			}
		}
	};

	public class TimeThread extends Thread {
		@Override
		public void run() {
			do {
				try {
					Thread.sleep(1000);
					Message msg = new Message();
					msg.what = 1;
					mHandler.sendMessage(msg);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} while (true);
		}
	}

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case 1:
				long sysTime = System.currentTimeMillis();
				// sysTimeStr = DateFormat.format("hh:mm:ss", sysTime);
				Date currentTime = new Date(sysTime);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				dateString = formatter.format(currentTime);

//				wm = (WifiManager) getSystemService(WIFI_SERVICE); // getSystemService(String)，通过名字来返回系统级服务的句柄。返回类型随要求变化。
				wm = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE); // getSystemService(String)，通过名字来返回系统级服务的句柄。返回类型随要求变化。
				// 使用getSystemService(String)来取回WifiManager然后处理wifi接入，
				wi = wm.getConnectionInfo();// getConnectionInfo返回wifi连接的动态信息
				if (wi.getBSSID() != null)// getBSSID返回基本服务集标识符，如果未连接，返回null，否则返回MAC地址形式：XX:XX:XX:XX:XX
					strength = wi.getRssi();// 返回接收到的目前的802.11网络的信号强度
				// 显示IP地址
				// 获取wifi服务
//				WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
				WifiManager wifiManager = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
				// 判断wifi是否开启
				if (!wifiManager.isWifiEnabled()) {
					wifiManager.setWifiEnabled(true);
				}
				WifiInfo wifiInfo = wifiManager.getConnectionInfo();
				ipAddress = wifiInfo.getIpAddress();
				ip = intToIp(ipAddress);
				break;

			default:
				break;
			}
		}
	};

	private String intToIp(int i) {

		return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF) + "." + (i >> 24 & 0xFF);
	}

	// //////是控制屏幕常亮打开关闭生命周期
	@Override
	protected void onResume() {
		super.onResume();
		this.wakeLock.acquire();
	}

	@Override
	protected void onPause() {
		super.onPause();
		this.wakeLock.release();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add(Menu.NONE, Menu.FIRST + 1, 1, "网络设置");
		menu.add(Menu.NONE, Menu.FIRST + 2, 2, "解码库设置");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO 自动生成的方法存根
		////// 注册菜单事件
		switch (item.getItemId()) {
		case Menu.FIRST + 1:
			Intent intent1 = new Intent();
			intent1.setClass(GateValveActivity.this, SetNetConfig.class);

			startActivity(intent1);
			break;
		case Menu.FIRST + 2:
			Intent intent2 = new Intent();
			intent2.setClass(GateValveActivity.this, SetDecodeActivity.class);
			startActivity(intent2);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public boolean onTouchEvent(MotionEvent event) {

		int pointerCount = event.getPointerCount();
		int action = event.getAction();
		if (pointerCount == 1) {
			xInScreen = event.getX();
			yInScreen = event.getY();
			switch (action) {
			case MotionEvent.ACTION_DOWN:
				break;
			case MotionEvent.ACTION_UP:
				getTouchEvent();
				break;
			case MotionEvent.ACTION_MOVE:
				break;
			}
		}
		if (pointerCount == 2) {
			xInScreen = event.getX(0);
			yInScreen = event.getY(0);
			x1 = event.getX(1);
			y1 = event.getY(1);
			switch (action) {
			case MotionEvent.ACTION_DOWN:
				break;
			case MotionEvent.ACTION_UP:
				break;
			case MotionEvent.ACTION_MOVE:
				break;
			case MotionEvent.ACTION_POINTER_1_DOWN:
				break;
			case MotionEvent.ACTION_POINTER_1_UP:
				break;
			case MotionEvent.ACTION_POINTER_2_DOWN:
				break;
			case MotionEvent.ACTION_POINTER_2_UP:
				break;
			}
		}
		return super.onTouchEvent(event);
		// return gallery.onGalleryTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		return false;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO 自动生成的方法存根

		if (gestrueDetector.onTouchEvent(ev)) {

			ev.setAction(MotionEvent.ACTION_CANCEL);
		} else {
			onTouchEvent(ev);
		}
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		// TODO 自动生成的方法存根
		if ((Math.abs(e1.getX() - e2.getX()) > Math.abs(e1.getY() - e2.getY())) && (e1.getX() > 50)) {

			if (e1.getX() - e2.getX() > 120) {
				this.viewFilipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
				this.viewFilipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));
				this.viewFilipper.showNext();
				bId++;
				if (bId >= PageNum) {
					bId = 0;
				}
				return true;

			} else if (e1.getX() - e2.getX() < -120) {
				this.viewFilipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
				this.viewFilipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
				this.viewFilipper.showPrevious();
				// bId=viewFilipper.getId();
				bId--;
				if (bId < 0) {
					bId = PageNum - 1;
				}
				return true;
			}
		} else {
			if (e1.getY() - e2.getY() > 120) {
				Intent intent = new Intent();
				intent.setClass(GateValveActivity.this, SeekWindowActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.push_top_in, R.anim.push_top_out);
				finish();
				return true;
			} else if (e1.getY() - e2.getY() < -120) {
				Intent intent = new Intent();
				intent.setClass(GateValveActivity.this, SeekWindowActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out);
				finish();
				return true;
			}
		}

		return false;

	}

	@Override
	public void onLongPress(MotionEvent e) {

	}

	public boolean onDoubleTap(MotionEvent e) {
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO 自动生成的方法存根
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			new AlertDialog.Builder(this).setTitle("退出").setMessage("你确定退出吗?")
					.setPositiveButton("是", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO 自动生成的方法存根
							if (reTimer != null) {
								reTimer.cancel();
								reTimer = null;
							}

							if (connection != null) {
								unbindService(connection);
								connection = null;
							}
							// Intent intent1=new Intent(GateValveActivity.this,HipriService.class);
							// stopService(intent1);
							Intent intent = new Intent(GateValveActivity.this, NewMyService.class);
							stopService(intent);

							finish();
							// System.exit(0);
						}
					}).setNegativeButton("否", null).show();
		}
		return super.onKeyDown(keyCode, event);
	}

	private void drawBitmapById(int id) {
		synchronized (sBitmap) {
			Canvas canvas = new Canvas();
			if (id == 0) {
				canvas.setBitmap(sBitmap[0]);
				Paint paint = new Paint();
				Page001.DrawPage(canvas);
				canvas.drawBitmap(sBitmap[0], 0, 0, paint);
			}
			if (id == 1) {
				canvas.setBitmap(sBitmap[1]);
				Paint paint = new Paint();
				Page002.DrawPage(canvas);
				canvas.drawBitmap(sBitmap[1], 0, 0, paint);
			}
			if (id == 2) {
				canvas.setBitmap(sBitmap[2]);
				Paint paint = new Paint();
				Page003.DrawPage(canvas);
				canvas.drawBitmap(sBitmap[2], 0, 0, paint);
			}
			if (id == 3) {
				canvas.setBitmap(sBitmap[3]);
				Paint paint = new Paint();
				Page004.DrawPage(canvas);
				canvas.drawBitmap(sBitmap[3], 0, 0, paint);
			}
			if (id == 4) {
				canvas.setBitmap(sBitmap[4]);
				Paint paint = new Paint();
				Page005.DrawPage(canvas);
				canvas.drawBitmap(sBitmap[4], 0, 0, paint);
			}
		}

	}

	public long getSDFreeSize() {
		// 取得SD卡文件路径
		File path = Environment.getExternalStorageDirectory();
		StatFs sf = new StatFs(path.getPath());
		// 获取单个数据块的大小(Byte)
		long blockSize = sf.getBlockSize();
		// 空闲的数据块的数量
		long freeBlocks = sf.getAvailableBlocks();
		// 返回SD卡空闲大小
		// return freeBlocks * blockSize; //单位Byte
		// return (freeBlocks * blockSize)/1024; //单位KB
		return (freeBlocks * blockSize) / 1024 / 1024; // 单位MB
	}

	private void getworking_status(Caculate cacuData) {
	}

	public void getTouchEvent() {
		String con0 = " ";
		switch (bId) {
		case 000:

			s = 1;
			if (((GroupHDPump.hdpump[s].cx - 60) < xInScreen && xInScreen < (GroupHDPump.hdpump[s].cx + 60))
					&& ((GroupHDPump.hdpump[s].cy - 60) < yInScreen && yInScreen < (GroupHDPump.hdpump[s].cy + 60))) {

				// j = 2 * s;
				sp.play(music, volumnRatio, volumnRatio, 0, 0, 1);
				String[] str = { "启 动", "停 止" };
				new AlertDialog.Builder(GateValveActivity.this)
						.setTitle(GroupHDPump.hdpump[s].szText)
						.setItems(str, new DialogInterface.OnClickListener() { // content

							@Override
							public void onClick(DialogInterface dialog, int which) {

								switch (which) {
								case 0:
									myBinder.sendCommand(GetSendCommand(0));
									// myBinder.sendCommand(GetSendCommand(j +16));
									break;
								case 1:
									myBinder.sendCommand(GetSendCommand(1));
									// myBinder.sendCommand(GetSendCommand(j + 17));
									break;
								}

							}

						})

						.setNegativeButton("取  消", new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {

								dialog.dismiss(); // 关闭alertDialog

							}

						})

						.show();
			}
			break;
		}
	}

	////// 实时数据
	private Caculate cacuDate = null;
	byte[] sendCommand0 = { 0x24, 0x43, 0x01, 0x2C, 0x00, 0x00, 0x00, 0x00, 0x00, 0x04, 0x00, 0x10, 0x00, 0x01, 0x00,
			0xA9 - 256, 0x0D, 0x0A, 0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256,
			0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256,
			0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256 };

	public byte[] GetSendCommand(int num) {
		int wCheck = 0;
		byte[] bb = new byte[40];
		bb[0] = 0x24;
		bb[1] = 0x43;
		bb[2] = 0x01;
		bb[3] = 0x2C;
		bb[4] = 0x00;
		bb[5] = 0x00;
		bb[6] = 0x00;
		bb[7] = 0x00;
		bb[8] = 0x00;
		bb[9] = 0x04;
		bb[10] = 0x00;
		bb[11] = (byte) ((num / 8) & 0xFF);
		bb[12] = (byte) ((num % 8) & 0xFF);
		bb[13] = 0x01;
		for (int i = 0; i < 14; i++) {
			wCheck += bb[i];
		}
		bb[14] = (byte) ((wCheck >> 8) & 0xFF);
		if ((byte) ((wCheck) & 0xFF) > 127) {
			bb[15] = (byte) ((wCheck) & 0xFF - 256);
		} else {
			bb[15] = (byte) ((wCheck) & 0xFF);
		}
		bb[16] = 0x0D;
		bb[17] = 0x0A;
		bb[18] = 0xDD - 256;
		bb[19] = 0xDD - 256;
		bb[20] = 0xDD - 256;
		bb[21] = 0xDD - 256;
		bb[22] = 0xDD - 256;
		bb[23] = 0xDD - 256;
		bb[24] = 0xDD - 256;
		bb[25] = 0xDD - 256;
		bb[26] = 0xDD - 256;
		bb[27] = 0xDD - 256;
		bb[28] = 0xDD - 256;
		bb[29] = 0xDD - 256;
		bb[30] = 0xDD - 256;
		bb[31] = 0xDD - 256;
		bb[32] = 0xDD - 256;
		bb[33] = 0xDD - 256;
		bb[34] = 0xDD - 256;
		bb[35] = 0xDD - 256;
		bb[36] = 0xDD - 256;
		bb[37] = 0xDD - 256;
		bb[38] = 0xDD - 256;
		bb[39] = 0xDD - 256;
		return bb;
	}


	private void setting() throws IOException {
//        sv = (LinearLayout) getLayoutInflater().inflate(R.layout.setting, null);
		sv = (ScrollView) getLayoutInflater().inflate(R.layout.setting, null);
		et[0]=(EditText)sv.findViewById(R.id.et1);//水密度
		et[1]=(EditText)sv.findViewById(R.id.et2);//土密度
		et[2]=(EditText)sv.findViewById(R.id.et3);//管径
		et[0].setText(read(0));
		et[1].setText(read(1));
		et[2].setText(read(2));
		ok=(Button)sv.findViewById(R.id.btn);
		ok.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				str[0]= String.valueOf(et[0].getText());
				str[1]= String.valueOf(et[1].getText());
				str[2]= String.valueOf(et[2].getText());
				str[3]= String.valueOf(Density.Cumulativeoutput);
				stringTxt(str);//保存
				Density.Waterdensity=Float.valueOf(str[0]);
				Density.Soildensity=Float.valueOf(str[1]);
				Density.Pipediameter=Float.valueOf(str[2]);
				Toast.makeText(GateValveActivity.this, "设置完成!", Toast.LENGTH_LONG).show();
			}
		});
	}

	// 生成文件
	public File makeFilePath(String filePath, String fileName) {
		File file = null;
		makeRootDirectory(filePath);
		try {
			file = new File(filePath + fileName);
			if (!file.exists()) {
				file.createNewFile();
				stringTxt(new String[]{"0","0","0","0"});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}
	// 生成文件夹
	public static void makeRootDirectory(String filePath) {
		File file = null;
		try {
			file = new File(filePath);
			if (!file.exists()) {
				file.mkdir();
			}
		} catch (Exception e) {
		}
	}


	//存储  读取
	public static void stringTxt(String[] s){
		if(!isNumeric(s[3])){
			s[3]= String.valueOf(0);
		}
		String str="";
		for(int i=0;i<s.length;i++){
			str=str+s[i]+"\n";
		}
		try {
			File fs=new File("/mnt/sdcard/mingrun/setting.txt");
			FileOutputStream outputStream =new FileOutputStream(fs);
			outputStream.write(str.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String read(int a) throws IOException {//按行读取
		File file=new File("/mnt/sdcard/mingrun/setting.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String temp=null;
		String s="";
		while((temp=br.readLine())!=null){
			s+=temp+"\n";
		}
		String [] ss=s.split("\n");
//        for (int i = 0; i < ss.length; i++) {
//            System.out.println(ss[i]);
//        }
		if(a>=ss.length){
			System.out.println(file.delete());
			makeFilePath("/mnt/sdcard/mingrun/","setting.txt");
		}
		if(!isNumeric(ss[3])){
			ss[3]= String.valueOf(0);
		}
		return ss[a];
	}




	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}


}