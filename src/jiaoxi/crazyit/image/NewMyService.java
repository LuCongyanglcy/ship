package jiaoxi.crazyit.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


import jiaoxi.crazyit.classes.UISet.DrawShip;
import jiaoxi.crazyit.mygps.OperaMyGps;
import jiaoxi.crazyit.upload.StreamTool;
import jiaoxi.crazyit.upload.UploadLogService;
import jiaoxi.crazyit.zip.ZipUtils;
import jiaoxi.crazyit.classes.Caculate;
import jiaoxi.crazyit.classes.DecodeList;
import jiaoxi.crazyit.classes.HistoryCaculate;
import jiaoxi.crazyit.classes.IpPort;
import jiaoxi.crazyit.classes.OperaStrTrochoidReal;
import jiaoxi.crazyit.classes.OperaTraceLine;
import jiaoxi.crazyit.classes.PO_XY;
import jiaoxi.crazyit.classes.PlaneInstallJx;
import jiaoxi.crazyit.classes.Str_Arm_Location;
import jiaoxi.crazyit.classes.Str_RealTimeSignal;
import jiaoxi.crazyit.classes.Str_Ship_Point;
import jiaoxi.crazyit.classes.Str_TraceLine;
import jiaoxi.crazyit.classes.Str_Trochoid_Real;
import jiaoxi.crazyit.classes.construct.OperaConstructParam;
import jiaoxi.crazyit.classes.construct.Str_Arm_Size;
import jiaoxi.crazyit.classes.dig.DigData;
import jiaoxi.crazyit.classes.dig.OperaDig;
import jiaoxi.crazyit.classes.dxf.DrawDxfR12;
import jiaoxi.crazyit.classes.dxf.Dxf_r12;
import jiaoxi.crazyit.classes.gps.GpsConvertClass;
import jiaoxi.crazyit.classes.gps.GpsConvertParamClass;
import jiaoxi.crazyit.classes.gps.GpsParam;
import jiaoxi.crazyit.classes.gps.GpsValue;
import jiaoxi.crazyit.classes.history.HistoryClass;
import jiaoxi.crazyit.classes.history.HistoryParam;
import jiaoxi.crazyit.classes.xyz.DrawXYZ;
import jiaoxi.crazyit.classes.xyz.OperaColor;
import jiaoxi.crazyit.classes.xyz.Str_Colors;
import jiaoxi.crazyit.classes.xyz.Str_Xyz;
import jiaoxi.crazyit.decode.DecodeReceiveData;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.widget.Toast;

public class NewMyService extends Service {

	static public boolean plcconect1=false;//PLC连接状态
	static public boolean plcconect2=false;//PLC连接状态
	static public boolean serverconect=false;//远程服务器连接状态
	float rotations=0;////整图需要旋转的角度
	boolean gpsTest=false;/////模拟gps测试
	double lat=3852.9237;
	double lon=11810.9880;
	double headt=305.09;
	boolean bWestOrEast=false;
	boolean bSourthOrNorth=false;

	//上传文件
///////导入施工数据进度条
	public int length;
	private UploadLogService logService;
	private boolean start=true;
	private ZipUtils zip;
	final int maxScreenWidth=2560;
	final int maxScreenHeight=1600;
	final int screenWidth=maxScreenWidth-450;
	final int screenHeight=maxScreenHeight-160;
	float scaleX=screenWidth/10;
	float scaleY=screenHeight/10;

	////////文件下载管理器
	DownloadManager downloadManager=null;//(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
	///定时检查工程文件版本,如果有新版本,开始下载
	Timer downloadCanTimer=null;
	boolean isNewData=false;//////是否有新数据
	float projectVersion;//////工程文件版本号
	String downloadScanfile="http://112.83.126.129/project/projectVersion.txt";
	long versionId;//////下载版本文件id
	boolean isDownload=false;/////是否有文件在下载,如果在下载,跳过版本文件的下载检测
	private CompleteReceiver completeReceiver;//////下载监听器

	//////长度
	private final int seekNum=14;
	private final int aiNum=1000;
	private final int diNum=1125;

	//////电源管理,使屏幕常亮
	PowerManager powerManager = null;
	WakeLock wakeLock = null;

	///////////////是否启用本机自带gps
	boolean isMyGps=false;

	/////////////gps数据
	GpsValue gv;
	/*////////远程服务器ip
    String remoteIP="192.168.2.99";//"112.83.126.129";已写入配置文件
*/    //////远程服务器socket
	SocketServer remoteSocket=new SocketServer();
	////////设定是接收数据还是发送数据
	// boolean isSend=false;/////true发送数据方,false,接收数据方
	Timer sendDataTimer=null;/////发送数据定时器
	byte[] sendByte=new byte[4+seekNum*8+seekNum+aiNum*4+aiNum+diNum*2];
	int maxRemoteTime=20;



	////////////锁定旋转缩放参数
	int lock=2;
	/////单指操作参数
	int lock2=0;
	/////船位是否自动回中心
	boolean isGpsCenter=true;
	/////保存中心点
	double centerX=0;
	double centerY=0;

	////////////dxf数据
	List<Dxf_r12> dxfr12s=null;
	/////dig数据
	List<DigData> digs=null;
	////////xyz数据
	List<Str_Xyz> xyzs=null;

	/////////颜色深度
	Str_Colors colors=null;

	//////sd卡是否存在
	private boolean hasSD=false;
	/////SD卡路径
	private String sdPath;
	////////当前程序路径
	private String installPath;


	///////船舶平面安装位置
	private PlaneInstallJx planeInstall=null;
	///////桥架尺寸
	private Str_Arm_Size strArmSize=new Str_Arm_Size();
	//////计算后的平面位置
	private Str_Ship_Point strShipPoint=new Str_Ship_Point();

	///////定义在这里,防止在定时器里不停分配造成主gc
	PO_XY BasePoint_Plane=new PO_XY();		//平面控制基准点
	PO_XY BasePoint_Install=new PO_XY();	//相对基准点


	////////跟踪线
	private Str_TraceLine strTraceLine=null;

	///////网络连接配置
	private IpPort netConfig=null;
	///////历史回放配置
	private HistoryParam hp=null;
	///////解码库配置
	private DecodeList dl=null;

	private MyBinder mBinder = new MyBinder();
	SocketServer ss1;	//////plc
	int ssMaxTime=30;
	int ss1AiNum=0;////plc的模拟量和开关量的数量
	int ss1DiNum=0;

	SocketServer ss2;	//////plc
	int ss2AiNum=0;////plc的模拟量和开关量的数量
	int ss2DiNum=0;

	SocketServer gpsSocket;/////gps
	int gpsMaxTime=30;///////10秒后重连



	///////实时数据
	Str_RealTimeSignal strRealTimeSignal=new Str_RealTimeSignal();

	/////////////记录疏浚点,轨迹线用
	List<Str_Ship_Point> strTrochoid=new ArrayList<Str_Ship_Point>();	//////记录数据用
	//	Str_Ship_Point[] strTrochoidReal=new Str_Ship_Point[10000];/////画轨迹线用
	int trochoidLen=0;				/////另外有个int记录数量,每次用size判断耗时
	//	int trochoidLenReal=0;
//	int trochoidRealIndex=0;	//////指示数据开始位置
	Str_Trochoid_Real strTrochoidReal=new Str_Trochoid_Real();
	float recordDistance=2;			//////记录数据时绞刀最小移动距离
	float beginRecord=5;				////////记录数据时绞刀最小深度

	//////绞刀位置
	Str_Arm_Location strArmLocation=new Str_Arm_Location();

	///////////最终数据
	private Caculate finalCacuData;


	////////////////////历史数据
	List<HistoryCaculate> historyCaculates=new ArrayList<HistoryCaculate>();
	Date oldDate=null;
	Date newDate=new Date();
	File Datef = null; //沈阳
	private String Datefpath = "";

	////////10秒主录一次数据
	final int delayTime=10;
	final int hCaculatesNum=3600/delayTime;
	//////先把历史数据中每个list子项new出来,以免每10秒new一个影响速度
	HistoryCaculate[] hCaculate=new HistoryCaculate[hCaculatesNum];
	int hCaculateIndex=0;

	/////////gps参数
	GpsParam gp;

	Timer serviceTimer=null;////////用来整合数据
	Timer planeTimer=null;//////计算所有平面信息用
	Timer realTimer=null;///////获取临时数据
	Timer maxTimer=null;///////网络重新连接定时器
	Timer historyTimer=null;///////历史数据定时器
	Timer historySaveTimer=null;//////1秒检测一次时间,如果小时改变,保存数据
	Timer uploadTimer=null;//////30秒检测一次时间

	/////////service要加载的解码库
	//String sClass="com.android.Decode11000";

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return mBinder;
	}

	/////////定时下载版本文件,检测版本号是否比当前版本号新
	private void downloadScanVersion(){
		downloadCanTimer=new Timer();
		downloadCanTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				if(!isDownload){
					File f=new File(sdPath+"/project");
					if(!f.exists()){
						f.mkdir();
					}
					Uri uri=Uri.parse(downloadScanfile);
					Request request=new Request(uri);
					request.setDestinationInExternalPublicDir(sdPath+"/project/", "projectVersion.txt");
					request.setNotificationVisibility(Request.VISIBILITY_HIDDEN);
					isDownload=true;
					versionId=downloadManager.enqueue(request);
				}
			}
		}, 2000,1800000);/////2秒后检测,以后30分钏检测一次
	}
	//////读取工程文件版本号
	private float readProjectVersion(String path){
		//File f=new File(installPath+"/projectVersion.txt");
		File f=new File(path);
		InputStream in=null;
		try {
			int len=(int) f.length();
			in=new FileInputStream(f);
			byte[] s=new byte[len];
			in.read(s);
			projectVersion=Float.parseFloat(new String(s,"gb2312"));
			return projectVersion;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}
	/////写入版本号数据
	private void saveProjectVersion(float version){

		try {
			FileOutputStream outStream=new FileOutputStream(installPath+"/projectVersion.txt",true);
			OutputStreamWriter writer=new OutputStreamWriter(outStream,"gb2312");
			writer.write(String.valueOf(version));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	////////判断sd卡是否存在,获取sd卡路径,安装路径
	public void getPath(Context context){
		hasSD=Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
		if(hasSD){
			sdPath=Environment.getExternalStorageDirectory().getPath();
		}
		installPath=context.getFilesDir().getPath();


	}

	/////////////////获得绞刀参数
	public void getArmLocation_DredgeCutter(){
		strArmLocation.XYZ_1[0]=0;/////耳轴位置
		strArmLocation.XYZ_1[1]=0;
		strArmLocation.XYZ_1[2]=strRealTimeSignal.TrunnionGaugeDeep-strRealTimeSignal.Tide;//吸口至工程0位距离
		strArmLocation.XYZ_2[0]=strArmLocation.XYZ_1[0]+strArmSize.BridgeLength*Math.cos(strRealTimeSignal.BridgeAngle*Math.PI/180);
		strArmLocation.XYZ_2[1]=strArmLocation.XYZ_1[1];
		strArmLocation.XYZ_2[2]=strArmLocation.XYZ_1[2]+strArmSize.BridgeLength*Math.sin(strRealTimeSignal.BridgeAngle*Math.PI/180);/////与绞刀连接点

		strArmLocation.XYZ_3[0]=strArmLocation.XYZ_2[0];////后面0/////+0*Math.cos(strRealTimeSignal.CutterHeadAngle*Math.PI/180);
		strArmLocation.XYZ_3[1]=strArmLocation.XYZ_2[1];
		strArmLocation.XYZ_3[2]=strArmLocation.XYZ_2[2]+(strArmSize.CutterLength)*Math.sin(strRealTimeSignal.CutterHeadAngle*Math.PI/180)+strArmSize.CutterRadum;		//--绞刀与泥底接触点

		strArmLocation.XYZ_4[0]=strArmLocation.XYZ_2[0]+strArmSize.CutterRadum;
		strArmLocation.XYZ_4[1]=strArmLocation.XYZ_2[1];
		strArmLocation.XYZ_4[2]=strArmLocation.XYZ_2[2];		//右边点
	}

	//////获得平面定位的平面数据
	public void getPlaneLocation_DredgeCutter(){
		int i = 0;
		strShipPoint.GPSPoint[0] = strRealTimeSignal.GPS_X;
		strShipPoint.GPSPoint[1] = strRealTimeSignal.GPS_Y;
		strShipPoint.GPSPoint[2] = strRealTimeSignal.GPS_Z;
		strShipPoint.GPS2Point[0]= strRealTimeSignal.GPS2_X;
		strShipPoint.GPS2Point[1] = strRealTimeSignal.GPS2_Y;
		/*PO_XY BasePoint_Plane=new PO_XY();		//平面控制基准点
		PO_XY BasePoint_Install=new PO_XY();	//相对基准点
*/
		BasePoint_Plane.x = (float) strRealTimeSignal.GPS_X;
		BasePoint_Plane.y = (float) strRealTimeSignal.GPS_Y;
		BasePoint_Plane.z = (float) strRealTimeSignal.GPS_Z;
		BasePoint_Install = planeInstall.gps1;		////等于GPS安装点

		for (i=0;i<DrawShip.shipArrSize();i++){
			strShipPoint.ShipPlane[i].x=(float) (BasePoint_Plane.x+(planeInstall.ShipPlane[i].x-BasePoint_Install.x)*Math.cos(strRealTimeSignal.ShipAngle)
					-(planeInstall.ShipPlane[i].y-BasePoint_Install.y)*Math.sin(strRealTimeSignal.ShipAngle));
			strShipPoint.ShipPlane[i].y=(float) (BasePoint_Plane.y+(planeInstall.ShipPlane[i].x-BasePoint_Install.x)*Math.sin(strRealTimeSignal.ShipAngle)
					+(planeInstall.ShipPlane[i].y-BasePoint_Install.y)*Math.cos(strRealTimeSignal.ShipAngle));

		}

		strShipPoint.VirtualGPSPoint[0]=BasePoint_Plane.x+(planeInstall.gps1.x-BasePoint_Install.x)*Math.cos(strRealTimeSignal.ShipAngle)
				-(planeInstall.gps1.y-BasePoint_Install.y)*Math.sin(strRealTimeSignal.ShipAngle);
		strShipPoint.VirtualGPSPoint[1]=BasePoint_Plane.y+(planeInstall.gps1.x-BasePoint_Install.x)*Math.sin(strRealTimeSignal.ShipAngle)
				+(planeInstall.gps1.y-BasePoint_Install.y)*Math.cos(strRealTimeSignal.ShipAngle);

		strShipPoint.MainStackPivot[0]=(float) (BasePoint_Plane.x+(planeInstall.MainStackPivot.x-BasePoint_Install.x)*Math.cos(strRealTimeSignal.ShipAngle)
				-(planeInstall.MainStackPivot.y-BasePoint_Install.y)*Math.sin(strRealTimeSignal.ShipAngle));
		strShipPoint.MainStackPivot[1]=(float) (BasePoint_Plane.y+(planeInstall.MainStackPivot.x-BasePoint_Install.x)*Math.sin(strRealTimeSignal.ShipAngle)
				+(planeInstall.MainStackPivot.y-BasePoint_Install.y)*Math.cos(strRealTimeSignal.ShipAngle));


		strShipPoint.AssitantStack[0]=(float) (BasePoint_Plane.x+(planeInstall.AssitantStack.x-BasePoint_Install.x)*Math.cos(strRealTimeSignal.ShipAngle)
				-(planeInstall.AssitantStack.y-BasePoint_Install.y)*Math.sin(strRealTimeSignal.ShipAngle));
		strShipPoint.AssitantStack[1]=(float) (BasePoint_Plane.y+(planeInstall.AssitantStack.x-BasePoint_Install.x)*Math.sin(strRealTimeSignal.ShipAngle)
				+(planeInstall.AssitantStack.y-BasePoint_Install.y)*Math.cos(strRealTimeSignal.ShipAngle));

		strShipPoint.MainStack[0]=(float) (BasePoint_Plane.x+((planeInstall.MainStackPivot.x-strRealTimeSignal.MainStackLength)
				-BasePoint_Install.x)*Math.cos(strRealTimeSignal.ShipAngle)-(planeInstall.MainStackPivot.y-BasePoint_Install.y)*Math.sin(strRealTimeSignal.ShipAngle));
		strShipPoint.MainStack[1]=(float) (BasePoint_Plane.y+((planeInstall.MainStackPivot.x-strRealTimeSignal.MainStackLength)
				-BasePoint_Install.x)*Math.sin(strRealTimeSignal.ShipAngle)
				+(planeInstall.MainStackPivot.y-BasePoint_Install.y)*Math.cos(strRealTimeSignal.ShipAngle));

		double ax = 0,ay = 0;
		strShipPoint.P1[0]=BasePoint_Plane.x+(planeInstall.Trunnion.x-BasePoint_Install.x)*Math.cos(strRealTimeSignal.ShipAngle)
				-(planeInstall.Trunnion.y-BasePoint_Install.y)*Math.sin(strRealTimeSignal.ShipAngle);
		strShipPoint.P1[1]=BasePoint_Plane.y+(planeInstall.Trunnion.x-BasePoint_Install.x)*Math.sin(strRealTimeSignal.ShipAngle)
				+(planeInstall.Trunnion.y-BasePoint_Install.y)*Math.cos(strRealTimeSignal.ShipAngle);

		ax=(strArmLocation.XYZ_2[0]-strArmLocation.XYZ_1[0]);
		ay=(strArmLocation.XYZ_2[1]-strArmLocation.XYZ_1[1]);
		strShipPoint.P2[0]=strShipPoint.P1[0]+ax*Math.cos(strRealTimeSignal.ShipAngle)-ay*Math.sin(strRealTimeSignal.ShipAngle);
		strShipPoint.P2[1]=strShipPoint.P1[1]+ax*Math.sin(strRealTimeSignal.ShipAngle)+ay*Math.cos(strRealTimeSignal.ShipAngle);
		ax=(strArmLocation.XYZ_3[0]-strArmLocation.XYZ_2[0]);
		ay=(strArmLocation.XYZ_3[1]-strArmLocation.XYZ_2[1]);
		strShipPoint.P3[0]=strShipPoint.P2[0]+ax*Math.cos(strRealTimeSignal.ShipAngle)-ay*Math.sin(strRealTimeSignal.ShipAngle);
		strShipPoint.P3[1]=strShipPoint.P2[1]+ax*Math.sin(strRealTimeSignal.ShipAngle)+ay*Math.cos(strRealTimeSignal.ShipAngle);
		ax=(strArmLocation.XYZ_4[0]-strArmLocation.XYZ_3[0]);
		ay=(strArmLocation.XYZ_4[1]-strArmLocation.XYZ_3[1]);
		strShipPoint.P4[0]=strShipPoint.P3[0]+ax*Math.cos(strRealTimeSignal.ShipAngle)-ay*Math.sin(strRealTimeSignal.ShipAngle);
		strShipPoint.P4[1]=strShipPoint.P3[1]+ax*Math.sin(strRealTimeSignal.ShipAngle)+ay*Math.cos(strRealTimeSignal.ShipAngle);
		ax=(strArmLocation.XYZ_5[0]-strArmLocation.XYZ_4[0]);
		ay=(strArmLocation.XYZ_5[1]-strArmLocation.XYZ_4[1]);
		strShipPoint.P5[0]=strShipPoint.P4[0]+ax*Math.cos(strRealTimeSignal.ShipAngle)-ay*Math.sin(strRealTimeSignal.ShipAngle);
		strShipPoint.P5[1]=strShipPoint.P4[1]+ax*Math.sin(strRealTimeSignal.ShipAngle)+ay*Math.cos(strRealTimeSignal.ShipAngle);

		strShipPoint.P1[2]=strArmLocation.XYZ_1[2];
		strShipPoint.P2[2]=strArmLocation.XYZ_2[2];
		strShipPoint.P3[2]=strArmLocation.XYZ_3[2];
		strShipPoint.P4[2]=strArmLocation.XYZ_4[2];
		strShipPoint.P5[2]=strArmLocation.XYZ_5[2];
		strShipPoint.P6[2]=strArmLocation.XYZ_6[2];

		strShipPoint.P6[0] = strShipPoint.P3[0];
		strShipPoint.P6[1] = strShipPoint.P3[1];


		///////////////// 锚位等于计算的数据
		strShipPoint.AnchorLeftMove[0] = strRealTimeSignal.LeftMove_X;
		strShipPoint.AnchorLeftMove[1] = strRealTimeSignal.LeftMove_Y;
		strShipPoint.AnchorRightMove[0] = strRealTimeSignal.RightMove_X;
		strShipPoint.AnchorRightMove[1] = strRealTimeSignal.RightMove_Y;
		strShipPoint.AnchorLeftTail[0] = strRealTimeSignal.LeftTail_X;
		strShipPoint.AnchorLeftTail[1] = strRealTimeSignal.LeftTail_Y;
		strShipPoint.AnchorCenterTail[0]= strRealTimeSignal.CenterTail_X;
		strShipPoint.AnchorCenterTail[1] = strRealTimeSignal.CenterTail_Y;
		strShipPoint.AnchorRightTail[0] = strRealTimeSignal.RightTail_X;
		strShipPoint.AnchorRightTail[1] = strRealTimeSignal.RightTail_Y;
	}

	////获取定位锚的平面坐标
	public void getAnchorLocation_DredgeCutter(){
		strShipPoint.GPSPoint[0]=strRealTimeSignal.GPS_X;
		strShipPoint.GPSPoint[1]=strRealTimeSignal.GPS_Y;
		strShipPoint.GPSPoint[2]=strRealTimeSignal.GPS_Z;
		/*PO_XY BasePoint_Plane=new PO_XY();		//平面控制基准点
		PO_XY BasePoint_Install=new PO_XY();	//相对基准点
*/		//	float PIE = 3.1415926;

		if(strRealTimeSignal.MainStackDown==true && (planeInstall.MainStackCorrect == true) ){		///////如果主桩下
			BasePoint_Plane.x=strShipPoint.MainStack[0];
			BasePoint_Plane.y=strShipPoint.MainStack[1];
			BasePoint_Install.x= planeInstall.MainStackPivot.x - strRealTimeSignal.MainStackLength;
			BasePoint_Install.y = planeInstall.MainStackPivot.y ;

		}
		else{		////如果主桩在上

			BasePoint_Plane.x = (float) strRealTimeSignal.GPS_X;
			BasePoint_Plane.y = (float) strRealTimeSignal.GPS_Y;
			BasePoint_Plane.z = (float) strRealTimeSignal.GPS_Z;
			BasePoint_Install = planeInstall.gps1;		////等于GPS安装点
		}
		/////////////// 左右横移锚 /////////////////---左右横移锚与角度有关

		strShipPoint.AnchorRodPivot_Left[0]=(float) (BasePoint_Plane.x+(planeInstall.Winch_Left.x-planeInstall.Trunnion.x - BasePoint_Install.x)*Math.cos(strRealTimeSignal.ShipAngle)*Math.cos(strRealTimeSignal.BridgeAngle*Math.PI/180)
				-(planeInstall.Winch_Left.y-BasePoint_Install.y)*Math.sin(strRealTimeSignal.ShipAngle));
		strShipPoint.AnchorRodPivot_Left[1]=(float) (BasePoint_Plane.y+(planeInstall.Winch_Left.x-planeInstall.Trunnion.x - -BasePoint_Install.x)*Math.sin(strRealTimeSignal.ShipAngle)*Math.cos(strRealTimeSignal.BridgeAngle*Math.PI/180)
				+(planeInstall.Winch_Left.y-BasePoint_Install.y)*Math.cos(strRealTimeSignal.ShipAngle));

		strShipPoint.AnchorRodPivot_Right[0]=(float) (BasePoint_Plane.x+(planeInstall.Winch_Right.x-planeInstall.Trunnion.x - -BasePoint_Install.x)*Math.cos(strRealTimeSignal.ShipAngle)*Math.cos(strRealTimeSignal.BridgeAngle*Math.PI/180)
				-(planeInstall.Winch_Right.y-BasePoint_Install.y)*Math.sin(strRealTimeSignal.ShipAngle));
		strShipPoint.AnchorRodPivot_Right[1]=(float) (BasePoint_Plane.y+(planeInstall.Winch_Right.x-planeInstall.Trunnion.x - -BasePoint_Install.x)*Math.sin(strRealTimeSignal.ShipAngle)*Math.cos(strRealTimeSignal.BridgeAngle*Math.PI/180)
				+(planeInstall.Winch_Right.y-BasePoint_Install.y)*Math.cos(strRealTimeSignal.ShipAngle));
	}
	//////////增加疏浚点
	public void addTrochoid_DredgeCutter(){
		if(strShipPoint.P6[2]>=beginRecord){
			if(trochoidLen>=10000){
				saveTrochoid_DredgeCutter();
				return;
			}
			if(strTrochoidReal.trochoidLenReal>=10000){
				int tmpIndex=strTrochoidReal.trochoidRealIndex-1;
				if(tmpIndex<0){
					tmpIndex=9999;
				}
				if((strTrochoidReal.strTrochoidReals[tmpIndex].P5[0]-strShipPoint.P5[0])*(strTrochoidReal.strTrochoidReals[tmpIndex].P5[0]-strShipPoint.P5[0])+(strTrochoidReal.strTrochoidReals[tmpIndex].P5[1]-strShipPoint.P5[1])*(strTrochoidReal.strTrochoidReals[tmpIndex].P5[1]-strShipPoint.P5[1])>=recordDistance*recordDistance && strShipPoint.P6[3]>beginRecord){
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AnchorCenterTail[0]=strShipPoint.AnchorCenterTail[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AnchorCenterTail[1]=strShipPoint.AnchorCenterTail[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AnchorLeftMove[0]=strShipPoint.AnchorLeftMove[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AnchorLeftMove[1]=strShipPoint.AnchorLeftMove[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AnchorLeftTail[0]=strShipPoint.AnchorLeftTail[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AnchorLeftTail[1]=strShipPoint.AnchorLeftTail[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AnchorRightMove[0]=strShipPoint.AnchorRightMove[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AnchorRightMove[1]=strShipPoint.AnchorRightMove[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AnchorRightTail[0]=strShipPoint.AnchorRightTail[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AnchorRightTail[1]=strShipPoint.AnchorRightTail[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AnchorRodPivot_Left[0]=strShipPoint.AnchorRodPivot_Left[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AnchorRodPivot_Left[1]=strShipPoint.AnchorRodPivot_Left[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AnchorRodPivot_Right[0]=strShipPoint.AnchorRodPivot_Right[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AnchorRodPivot_Right[1]=strShipPoint.AnchorRodPivot_Right[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AssitantStack[0]=strShipPoint.AssitantStack[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].AssitantStack[1]=strShipPoint.AssitantStack[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].GPS2Point[0]=strShipPoint.GPS2Point[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].GPS2Point[1]=strShipPoint.GPS2Point[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].GPS2Point[2]=strShipPoint.GPS2Point[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].GPSPoint[0]=strShipPoint.GPSPoint[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].GPSPoint[1]=strShipPoint.GPSPoint[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].GPSPoint[2]=strShipPoint.GPSPoint[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].MainStack[0]=strShipPoint.MainStack[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].MainStack[1]=strShipPoint.MainStack[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].MainStackPivot[0]=strShipPoint.MainStackPivot[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].MainStackPivot[1]=strShipPoint.MainStackPivot[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P1[0]=strShipPoint.P1[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P1[1]=strShipPoint.P1[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P1[2]=strShipPoint.P1[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P2[0]=strShipPoint.P2[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P2[1]=strShipPoint.P2[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P2[2]=strShipPoint.P2[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P3[0]=strShipPoint.P3[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P3[1]=strShipPoint.P3[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P3[2]=strShipPoint.P3[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P4[0]=strShipPoint.P4[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P4[1]=strShipPoint.P4[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P4[2]=strShipPoint.P4[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P5[0]=strShipPoint.P5[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P5[1]=strShipPoint.P5[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P5[2]=strShipPoint.P5[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P6[0]=strShipPoint.P6[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P6[1]=strShipPoint.P6[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].P6[2]=strShipPoint.P6[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].ShipPlane=strShipPoint.ShipPlane;
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidRealIndex].Time=new Date(System.currentTimeMillis());

					strTrochoidReal.trochoidRealIndex++;
					if(strTrochoidReal.trochoidRealIndex>=10000){
						strTrochoidReal.trochoidRealIndex=0;
					}
				}

			}
			else if(strTrochoidReal.trochoidLenReal==0){

				strTrochoidReal.strTrochoidReals[0].AnchorCenterTail[0]=strShipPoint.AnchorCenterTail[0];
				strTrochoidReal.strTrochoidReals[0].AnchorCenterTail[1]=strShipPoint.AnchorCenterTail[1];
				strTrochoidReal.strTrochoidReals[0].AnchorLeftMove[0]=strShipPoint.AnchorLeftMove[0];
				strTrochoidReal.strTrochoidReals[0].AnchorLeftMove[1]=strShipPoint.AnchorLeftMove[1];
				strTrochoidReal.strTrochoidReals[0].AnchorLeftTail[0]=strShipPoint.AnchorLeftTail[0];
				strTrochoidReal.strTrochoidReals[0].AnchorLeftTail[1]=strShipPoint.AnchorLeftTail[1];
				strTrochoidReal.strTrochoidReals[0].AnchorRightMove[0]=strShipPoint.AnchorRightMove[0];
				strTrochoidReal.strTrochoidReals[0].AnchorRightMove[1]=strShipPoint.AnchorRightMove[1];
				strTrochoidReal.strTrochoidReals[0].AnchorRightTail[0]=strShipPoint.AnchorRightTail[0];
				strTrochoidReal.strTrochoidReals[0].AnchorRightTail[1]=strShipPoint.AnchorRightTail[1];
				strTrochoidReal.strTrochoidReals[0].AnchorRodPivot_Left[0]=strShipPoint.AnchorRodPivot_Left[0];
				strTrochoidReal.strTrochoidReals[0].AnchorRodPivot_Left[1]=strShipPoint.AnchorRodPivot_Left[1];
				strTrochoidReal.strTrochoidReals[0].AnchorRodPivot_Right[0]=strShipPoint.AnchorRodPivot_Right[0];
				strTrochoidReal.strTrochoidReals[0].AnchorRodPivot_Right[1]=strShipPoint.AnchorRodPivot_Right[1];
				strTrochoidReal.strTrochoidReals[0].AssitantStack[0]=strShipPoint.AssitantStack[0];
				strTrochoidReal.strTrochoidReals[0].AssitantStack[1]=strShipPoint.AssitantStack[1];
				strTrochoidReal.strTrochoidReals[0].GPS2Point[0]=strShipPoint.GPS2Point[0];
				strTrochoidReal.strTrochoidReals[0].GPS2Point[1]=strShipPoint.GPS2Point[1];
				strTrochoidReal.strTrochoidReals[0].GPS2Point[2]=strShipPoint.GPS2Point[2];
				strTrochoidReal.strTrochoidReals[0].GPSPoint[0]=strShipPoint.GPSPoint[0];
				strTrochoidReal.strTrochoidReals[0].GPSPoint[1]=strShipPoint.GPSPoint[1];
				strTrochoidReal.strTrochoidReals[0].GPSPoint[2]=strShipPoint.GPSPoint[2];
				strTrochoidReal.strTrochoidReals[0].MainStack[0]=strShipPoint.MainStack[0];
				strTrochoidReal.strTrochoidReals[0].MainStack[1]=strShipPoint.MainStack[1];
				strTrochoidReal.strTrochoidReals[0].MainStackPivot[0]=strShipPoint.MainStackPivot[0];
				strTrochoidReal.strTrochoidReals[0].MainStackPivot[1]=strShipPoint.MainStackPivot[1];
				strTrochoidReal.strTrochoidReals[0].P1[0]=strShipPoint.P1[0];
				strTrochoidReal.strTrochoidReals[0].P1[1]=strShipPoint.P1[1];
				strTrochoidReal.strTrochoidReals[0].P1[2]=strShipPoint.P1[2];
				strTrochoidReal.strTrochoidReals[0].P2[0]=strShipPoint.P2[0];
				strTrochoidReal.strTrochoidReals[0].P2[1]=strShipPoint.P2[1];
				strTrochoidReal.strTrochoidReals[0].P2[2]=strShipPoint.P2[2];
				strTrochoidReal.strTrochoidReals[0].P3[0]=strShipPoint.P3[0];
				strTrochoidReal.strTrochoidReals[0].P3[1]=strShipPoint.P3[1];
				strTrochoidReal.strTrochoidReals[0].P3[2]=strShipPoint.P3[2];
				strTrochoidReal.strTrochoidReals[0].P4[0]=strShipPoint.P4[0];
				strTrochoidReal.strTrochoidReals[0].P4[1]=strShipPoint.P4[1];
				strTrochoidReal.strTrochoidReals[0].P4[2]=strShipPoint.P4[2];
				strTrochoidReal.strTrochoidReals[0].P5[0]=strShipPoint.P5[0];
				strTrochoidReal.strTrochoidReals[0].P5[1]=strShipPoint.P5[1];
				strTrochoidReal.strTrochoidReals[0].P5[2]=strShipPoint.P5[2];
				strTrochoidReal.strTrochoidReals[0].P6[0]=strShipPoint.P6[0];
				strTrochoidReal.strTrochoidReals[0].P6[1]=strShipPoint.P6[1];
				strTrochoidReal.strTrochoidReals[0].P6[2]=strShipPoint.P6[2];
				strTrochoidReal.strTrochoidReals[0].ShipPlane=strShipPoint.ShipPlane;
				strTrochoidReal.strTrochoidReals[0].Time=new Date(System.currentTimeMillis());

				strTrochoidReal.trochoidLenReal++;
			}
			else if(strTrochoidReal.trochoidLenReal<10000){
				if((strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal-1].P5[0]-strShipPoint.P5[0])*(strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal-1].P5[0]-strShipPoint.P5[0])+(strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal-1].P5[1]-strShipPoint.P5[1])*(strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal-1].P5[1]-strShipPoint.P5[1])>=recordDistance*recordDistance && strShipPoint.P6[3]>beginRecord){
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AnchorCenterTail[0]=strShipPoint.AnchorCenterTail[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AnchorCenterTail[1]=strShipPoint.AnchorCenterTail[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AnchorLeftMove[0]=strShipPoint.AnchorLeftMove[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AnchorLeftMove[1]=strShipPoint.AnchorLeftMove[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AnchorLeftTail[0]=strShipPoint.AnchorLeftTail[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AnchorLeftTail[1]=strShipPoint.AnchorLeftTail[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AnchorRightMove[0]=strShipPoint.AnchorRightMove[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AnchorRightMove[1]=strShipPoint.AnchorRightMove[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AnchorRightTail[0]=strShipPoint.AnchorRightTail[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AnchorRightTail[1]=strShipPoint.AnchorRightTail[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AnchorRodPivot_Left[0]=strShipPoint.AnchorRodPivot_Left[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AnchorRodPivot_Left[1]=strShipPoint.AnchorRodPivot_Left[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AnchorRodPivot_Right[0]=strShipPoint.AnchorRodPivot_Right[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AnchorRodPivot_Right[1]=strShipPoint.AnchorRodPivot_Right[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AssitantStack[0]=strShipPoint.AssitantStack[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].AssitantStack[1]=strShipPoint.AssitantStack[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].GPS2Point[0]=strShipPoint.GPS2Point[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].GPS2Point[1]=strShipPoint.GPS2Point[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].GPS2Point[2]=strShipPoint.GPS2Point[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].GPSPoint[0]=strShipPoint.GPSPoint[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].GPSPoint[1]=strShipPoint.GPSPoint[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].GPSPoint[2]=strShipPoint.GPSPoint[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].MainStack[0]=strShipPoint.MainStack[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].MainStack[1]=strShipPoint.MainStack[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].MainStackPivot[0]=strShipPoint.MainStackPivot[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].MainStackPivot[1]=strShipPoint.MainStackPivot[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P1[0]=strShipPoint.P1[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P1[1]=strShipPoint.P1[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P1[2]=strShipPoint.P1[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P2[0]=strShipPoint.P2[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P2[1]=strShipPoint.P2[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P2[2]=strShipPoint.P2[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P3[0]=strShipPoint.P3[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P3[1]=strShipPoint.P3[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P3[2]=strShipPoint.P3[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P4[0]=strShipPoint.P4[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P4[1]=strShipPoint.P4[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P4[2]=strShipPoint.P4[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P5[0]=strShipPoint.P5[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P5[1]=strShipPoint.P5[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P5[2]=strShipPoint.P5[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P6[0]=strShipPoint.P6[0];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P6[1]=strShipPoint.P6[1];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].P6[2]=strShipPoint.P6[2];
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].ShipPlane=strShipPoint.ShipPlane;
					strTrochoidReal.strTrochoidReals[strTrochoidReal.trochoidLenReal].Time=new Date(System.currentTimeMillis());

					strTrochoidReal.trochoidLenReal++;
				}
			}

			if(trochoidLen==0){
				Str_Ship_Point ssp=new Str_Ship_Point();
				ssp.AnchorCenterTail[0]=strShipPoint.AnchorCenterTail[0];
				ssp.AnchorCenterTail[1]=strShipPoint.AnchorCenterTail[1];
				ssp.AnchorLeftMove[0]=strShipPoint.AnchorLeftMove[0];
				ssp.AnchorLeftMove[1]=strShipPoint.AnchorLeftMove[1];
				ssp.AnchorLeftTail[0]=strShipPoint.AnchorLeftTail[0];
				ssp.AnchorLeftTail[1]=strShipPoint.AnchorLeftTail[1];
				ssp.AnchorRightMove[0]=strShipPoint.AnchorRightMove[0];
				ssp.AnchorRightMove[1]=strShipPoint.AnchorRightMove[1];
				ssp.AnchorRightTail[0]=strShipPoint.AnchorRightTail[0];
				ssp.AnchorRightTail[1]=strShipPoint.AnchorRightTail[1];
				ssp.AnchorRodPivot_Left[0]=strShipPoint.AnchorRodPivot_Left[0];
				ssp.AnchorRodPivot_Left[1]=strShipPoint.AnchorRodPivot_Left[1];
				ssp.AnchorRodPivot_Right[0]=strShipPoint.AnchorRodPivot_Right[0];
				ssp.AnchorRodPivot_Right[1]=strShipPoint.AnchorRodPivot_Right[1];
				ssp.AssitantStack[0]=strShipPoint.AssitantStack[0];
				ssp.AssitantStack[1]=strShipPoint.AssitantStack[1];
				ssp.GPS2Point[0]=strShipPoint.GPS2Point[0];
				ssp.GPS2Point[1]=strShipPoint.GPS2Point[1];
				ssp.GPS2Point[2]=strShipPoint.GPS2Point[2];
				ssp.GPSPoint[0]=strShipPoint.GPSPoint[0];
				ssp.GPSPoint[1]=strShipPoint.GPSPoint[1];
				ssp.GPSPoint[2]=strShipPoint.GPSPoint[2];
				ssp.MainStack[0]=strShipPoint.MainStack[0];
				ssp.MainStack[1]=strShipPoint.MainStack[1];
				ssp.MainStackPivot[0]=strShipPoint.MainStackPivot[0];
				ssp.MainStackPivot[1]=strShipPoint.MainStackPivot[1];
				ssp.P1[0]=strShipPoint.P1[0];
				ssp.P1[1]=strShipPoint.P1[1];
				ssp.P1[2]=strShipPoint.P1[2];
				ssp.P2[0]=strShipPoint.P2[0];
				ssp.P2[1]=strShipPoint.P2[1];
				ssp.P2[2]=strShipPoint.P2[2];
				ssp.P3[0]=strShipPoint.P3[0];
				ssp.P3[1]=strShipPoint.P3[1];
				ssp.P3[2]=strShipPoint.P3[2];
				ssp.P4[0]=strShipPoint.P4[0];
				ssp.P4[1]=strShipPoint.P4[1];
				ssp.P4[2]=strShipPoint.P4[2];
				ssp.P5[0]=strShipPoint.P5[0];
				ssp.P5[1]=strShipPoint.P5[1];
				ssp.P5[2]=strShipPoint.P5[2];
				ssp.P6[0]=strShipPoint.P6[0];
				ssp.P6[1]=strShipPoint.P6[1];
				ssp.P6[2]=strShipPoint.P6[2];
				ssp.ShipPlane=strShipPoint.ShipPlane;
				ssp.Time=new Date(System.currentTimeMillis());

				strTrochoid.add(ssp);
				trochoidLen++;
			}
			else{
				if((strTrochoid.get(trochoidLen).P5[0]-strShipPoint.P5[0])*(strTrochoid.get(trochoidLen).P5[0]-strShipPoint.P5[0])+(strTrochoid.get(trochoidLen).P5[1]-strShipPoint.P5[1])*(strTrochoid.get(trochoidLen).P5[1]-strShipPoint.P5[1])>=recordDistance*recordDistance && strShipPoint.P6[3]>beginRecord){
					Str_Ship_Point ssp=new Str_Ship_Point();
					ssp.AnchorCenterTail[0]=strShipPoint.AnchorCenterTail[0];
					ssp.AnchorCenterTail[1]=strShipPoint.AnchorCenterTail[1];
					ssp.AnchorLeftMove[0]=strShipPoint.AnchorLeftMove[0];
					ssp.AnchorLeftMove[1]=strShipPoint.AnchorLeftMove[1];
					ssp.AnchorLeftTail[0]=strShipPoint.AnchorLeftTail[0];
					ssp.AnchorLeftTail[1]=strShipPoint.AnchorLeftTail[1];
					ssp.AnchorRightMove[0]=strShipPoint.AnchorRightMove[0];
					ssp.AnchorRightMove[1]=strShipPoint.AnchorRightMove[1];
					ssp.AnchorRightTail[0]=strShipPoint.AnchorRightTail[0];
					ssp.AnchorRightTail[1]=strShipPoint.AnchorRightTail[1];
					ssp.AnchorRodPivot_Left[0]=strShipPoint.AnchorRodPivot_Left[0];
					ssp.AnchorRodPivot_Left[1]=strShipPoint.AnchorRodPivot_Left[1];
					ssp.AnchorRodPivot_Right[0]=strShipPoint.AnchorRodPivot_Right[0];
					ssp.AnchorRodPivot_Right[1]=strShipPoint.AnchorRodPivot_Right[1];
					ssp.AssitantStack[0]=strShipPoint.AssitantStack[0];
					ssp.AssitantStack[1]=strShipPoint.AssitantStack[1];
					ssp.GPS2Point[0]=strShipPoint.GPS2Point[0];
					ssp.GPS2Point[1]=strShipPoint.GPS2Point[1];
					ssp.GPS2Point[2]=strShipPoint.GPS2Point[2];
					ssp.GPSPoint[0]=strShipPoint.GPSPoint[0];
					ssp.GPSPoint[1]=strShipPoint.GPSPoint[1];
					ssp.GPSPoint[2]=strShipPoint.GPSPoint[2];
					ssp.MainStack[0]=strShipPoint.MainStack[0];
					ssp.MainStack[1]=strShipPoint.MainStack[1];
					ssp.MainStackPivot[0]=strShipPoint.MainStackPivot[0];
					ssp.MainStackPivot[1]=strShipPoint.MainStackPivot[1];
					ssp.P1[0]=strShipPoint.P1[0];
					ssp.P1[1]=strShipPoint.P1[1];
					ssp.P1[2]=strShipPoint.P1[2];
					ssp.P2[0]=strShipPoint.P2[0];
					ssp.P2[1]=strShipPoint.P2[1];
					ssp.P2[2]=strShipPoint.P2[2];
					ssp.P3[0]=strShipPoint.P3[0];
					ssp.P3[1]=strShipPoint.P3[1];
					ssp.P3[2]=strShipPoint.P3[2];
					ssp.P4[0]=strShipPoint.P4[0];
					ssp.P4[1]=strShipPoint.P4[1];
					ssp.P4[2]=strShipPoint.P4[2];
					ssp.P5[0]=strShipPoint.P5[0];
					ssp.P5[1]=strShipPoint.P5[1];
					ssp.P5[2]=strShipPoint.P5[2];
					ssp.P6[0]=strShipPoint.P6[0];
					ssp.P6[1]=strShipPoint.P6[1];
					ssp.P6[2]=strShipPoint.P6[2];
					ssp.ShipPlane=strShipPoint.ShipPlane;
					ssp.Time=new Date(System.currentTimeMillis());

					strTrochoid.add(ssp);
					trochoidLen++;
				}
			}
		}
	}
	public void saveTrochoid_DredgeCutter(){
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				List<Str_Ship_Point> ssp=new ArrayList<Str_Ship_Point>();
				for(int i=0;i<trochoidLen;i++){
					ssp.add(strTrochoid.get(i));
				}
				///////清空疏浚点
				strTrochoid.clear();
				trochoidLen=0;
				/////保存
				if(hasSD){
					SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
					String beginTime=formatter.format(ssp.get(0).Time);
					String fileName=sdPath+"/DredgeData/"+beginTime+".ppl";
					File f=new File(fileName);
					if(f.exists()){
						f.delete();
					}
					try {
						OutputStream os=new FileOutputStream(f);
						ObjectOutputStream oos=new ObjectOutputStream(os);
						oos.writeObject(ssp);
						oos.close();
						os.close();
					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	/////////////// 计算所有的平面信息
	public void CaculatePlaneData(){
		getArmLocation_DredgeCutter();//////这几个里面分配内存的需要处理一下,时间一长就会造成主gc调用,使平板很卡
		getPlaneLocation_DredgeCutter();
		getAnchorLocation_DredgeCutter();
		addTrochoid_DredgeCutter();
	}

	/////////////// 从CACULATEDATA中获得临时计算的数据，需要仔细核对
	public void getRealTimeSignal(){


		//		计算潮位
		strRealTimeSignal.Tide=finalCacuData.anlogData[44];
//		gps1x
		strRealTimeSignal.GPS_X = finalCacuData.seekData[0];

		//	gps1y
		strRealTimeSignal.GPS_Y = finalCacuData.seekData[1];

		//	gps1z
//		strRealTimeSignal.GPS_Z = finalCacuData.seekData[6];
		strRealTimeSignal.GPS_Z = finalCacuData.anlogData[44];

		//	gps2x
		strRealTimeSignal.GPS2_X = finalCacuData.seekData[2];

		//	gps2y
		strRealTimeSignal.GPS2_Y = finalCacuData.seekData[3];

		//	移动gpsx
		strRealTimeSignal.MoveGPS_X = finalCacuData.seekData[8];

		//	移动gpsy
		strRealTimeSignal.MoveGPS_Y = finalCacuData.seekData[9];

		//	gps速度
		strRealTimeSignal.GPS_Speed = finalCacuData.anlogData[70];


		strRealTimeSignal.COG = finalCacuData.anlogData[64];//对地航向
		strRealTimeSignal.SOG = finalCacuData.anlogData[70];//对地航速
		strRealTimeSignal.heading = finalCacuData.anlogData[67];//船首向

		//	主桩下信号	永远写FALSE
		strRealTimeSignal.MainStackDown = false;
		//	辅助桩下信号	永远写FALSE
		strRealTimeSignal.AssitantStackDown = false;

		//	船体角度
		strRealTimeSignal.ShipAngle = finalCacuData.anlogData[67]*Math.PI/180;
//		strRealTimeSignal.ShipAngle = finalCacuData.anlogData[67];

		//	耳轴吃水
		strRealTimeSignal.TrunnionGaugeDeep = finalCacuData.anlogData[142];

		//	桥架下放深度
		strRealTimeSignal.TrunnionGaugeDeep1 = finalCacuData.anlogData[172];

		//	桥架角度
		strRealTimeSignal.BridgeAngle = finalCacuData.anlogData[143];
		//   绞刀深度
		strRealTimeSignal.CutterDeep = finalCacuData.anlogData[125];

		//	主桩行程
		strRealTimeSignal.MainStackLength = finalCacuData.anlogData[130];

		//	平面投影长度
		strRealTimeSignal.PlaneLen = (float) (strArmSize.BridgeLength*Math.cos(strRealTimeSignal.BridgeAngle*Math.PI/180)
				+ (planeInstall.Trunnion.x - planeInstall.MainStackPivot.x + strRealTimeSignal.MainStackLength));

		//	水下泵转速
		strRealTimeSignal.SMSpeed = finalCacuData.anlogData[110];

		//	绞刀转速
		strRealTimeSignal.SpeedCutter = finalCacuData.anlogData[7];

		//	绞刀工作压力
		strRealTimeSignal.CutterPress = finalCacuData.anlogData[111];

//		//	1#舱内泵转速
//		strRealTimeSignal.CabinPumpSpeed = finalCacuData.anlogData[9];
//
//		//	2#舱内泵转速
//		strRealTimeSignal.CabinPumpSpeed1 = finalCacuData.anlogData[10];
//
//		//	横移速度
//		strRealTimeSignal.MoveSpeed = finalCacuData.anlogData[61];

//		//	左横移速度
//		strRealTimeSignal.MoveSpeed_Left = finalCacuData.anlogData[17];
//
//		//	右横移速度
//		strRealTimeSignal.MoveSpeed_Right = finalCacuData.anlogData[18];
//
//		//	浓度
//		strRealTimeSignal.PercentDensity = finalCacuData.anlogData[38];
//
//		//	流速
		strRealTimeSignal.Velocity = finalCacuData.anlogData[132];
//
//		//	小时产量率
//		strRealTimeSignal.ProductRate = finalCacuData.anlogData[40];

		//	水下泵吸入真空
		strRealTimeSignal.SuctionPress = finalCacuData.anlogData[127];

		//	水下泵排出压力
		strRealTimeSignal.SuctionPress1 = finalCacuData.anlogData[128];

		//	水下泵封水压力
		strRealTimeSignal.SuctionPress2 = finalCacuData.anlogData[126];

//		//	1#舱内泵排出压力
//		strRealTimeSignal.DischargePress1 = finalCacuData.anlogData[13];
//
//		//	2#舱内泵排出压力
//		strRealTimeSignal.DischargePress2 = finalCacuData.anlogData[14];
//
//		//	左横移角度
//		strRealTimeSignal.LeftMoveAngle = finalCacuData.anlogData[88];
//
//		//	右横移角度
//		strRealTimeSignal.RightMoveAngle = finalCacuData.anlogData[89];


//		//	左艉锚角度
//		strRealTimeSignal.LeftTailAngle = finalCacuData.anlogData[90];
//
//		//	中艉锚角度
//		strRealTimeSignal.CenterTailAngle = finalCacuData.anlogData[91];
//
//
//		//	右艉锚角度
//		strRealTimeSignal.RightTailAngle = finalCacuData.anlogData[92];
//
//		//	左横移锚x
//		strRealTimeSignal.LeftMove_X = finalCacuData.anlogData[78];
//
//		//	左横移锚y
//		strRealTimeSignal.LeftMove_Y = finalCacuData.anlogData[79];
//
//		//	右横移锚x
//		strRealTimeSignal.RightMove_X = finalCacuData.anlogData[80];
//
//		//	右横移锚y
//		strRealTimeSignal.RightMove_Y = finalCacuData.anlogData[81];
//
//		//	艉左锚x
//		strRealTimeSignal.LeftTail_X = finalCacuData.anlogData[82];
//
//		//	艉左锚y
//		strRealTimeSignal.LeftTail_Y = finalCacuData.anlogData[83];
//
//		//	艉中锚x
//		strRealTimeSignal.CenterTail_X = finalCacuData.anlogData[84];
//
//		//	艉中锚y
//		strRealTimeSignal.CenterTail_Y = finalCacuData.anlogData[85];
//
//		//	艉右锚x
//		strRealTimeSignal.RightTail_X = finalCacuData.anlogData[86];
//
//		//	艉右锚x
//		strRealTimeSignal.RightTail_Y = finalCacuData.anlogData[87];
//
//		//	管路平均浓度
//		strRealTimeSignal.AvergeDensity = finalCacuData.anlogData[58];
//
//		//	阻尼系数
//		strRealTimeSignal.R = finalCacuData.anlogData[59];
//
//		//	当前班组
//		strRealTimeSignal.currGroup = (int) finalCacuData.anlogData[30];
//
//		//	当前班组产量
//		strRealTimeSignal.groupProduct = finalCacuData.anlogData[46];
//
//		//	前班组产量
//		strRealTimeSignal.lastProduct = finalCacuData.anlogData[32];



//		//	根据实际情况修改代码
//		//	横移方向
//		if (((finalCacuData.digitData[0]>>4)&0x01) == 0x01){
//			//	左
//			strRealTimeSignal.MoveDirect = -1;
//		}
//		else if (((finalCacuData.digitData[0]>>5)&0x01) == 0x01){
//			//	右
//			strRealTimeSignal.MoveDirect = 1;
//		}
//		else{
//			//	停
//			strRealTimeSignal.MoveDirect = 0;
//		}

		strRealTimeSignal.GPS_E=finalCacuData.seekData[10];
		strRealTimeSignal.GPS_N=finalCacuData.seekData[11];
		strRealTimeSignal.GPS2_E=finalCacuData.seekData[12];
		strRealTimeSignal.GPS2_N=finalCacuData.seekData[13];


//		//	5个锚的定位
//		if(((finalCacuData.digitData[1]>>0)&0x01)==1){
//			strRealTimeSignal.LeftAnchorIsUp=true;
//		}
//		else{
//			strRealTimeSignal.LeftAnchorIsUp=false;
//		}
//		if(((finalCacuData.digitData[1]>>1)&0x01)==1){
//			strRealTimeSignal.RightAnchorIsUp=true;
//		}
//		else{
//			strRealTimeSignal.RightAnchorIsUp=false;
//		}
//		if(((finalCacuData.digitData[1]>>2)&0x01)==1){
//			strRealTimeSignal.LeftTailIsUp=true;
//		}
//		else{
//			strRealTimeSignal.LeftTailIsUp=false;
//		}
//
//		if(((finalCacuData.digitData[1]>>3)&0x01)==1){
//			strRealTimeSignal.CenterTailIsUp=true;
//		}
//		else{
//			strRealTimeSignal.CenterTailIsUp=false;
//		}
//		if(((finalCacuData.digitData[1]>>4)&0x01)==1){
//			strRealTimeSignal.RightTailIsUp=true;
//		}
//		else{
//			strRealTimeSignal.RightTailIsUp=false;
//		}
//
		if(strTraceLine.strLines.size()>0){
			strRealTimeSignal.CutterDis = (float) getX_TraceLine(strShipPoint.P6[0],strShipPoint.P6[1],
					strTraceLine.strLines.get(strTraceLine.currentSectionLine).LineEndPointX,
					strTraceLine.strLines.get(strTraceLine.currentSectionLine).LineEndPointY,
					strTraceLine.strLines.get(strTraceLine.currentSectionLine).LineBeginPointX,
					strTraceLine.strLines.get(strTraceLine.currentSectionLine).LineBeginPointY);
		}

		//	线方向
		if (strTraceLine.strLines.size() > 0){
			strRealTimeSignal.currentTraceLineAngle = strTraceLine.strLines.get(strTraceLine.currentSectionLine).LineAngle * 180 / Math.PI;
		}
		else{
			strRealTimeSignal.currentTraceLineAngle = 0.0f;
		}
	}
	public double getX_TraceLine(double x,double y,double x1,double y1,double x2,double y2){	//获取相对某根线的前进距离
		double angle=getAngle_TraceLine(x1,y1,x2,y2);
		return (x-x1)*Math.cos(angle)+(y-y1)*Math.sin(angle);
	}
	public double getAngle_TraceLine(double x1,double y1,double x2,double y2){
		double alpha;
		if(x2-x1==0){
			if(y2-y1>0)
				alpha=Math.PI/2;
			else alpha=-Math.PI/2;
		}
		else{
			if(x2-x1>0){
				alpha=Math.atan((y2-y1)/(x2-x1));
			}
			else{
				if(y2-y1>=0)
					alpha=Math.atan((y2-y1)/(x2-x1))+Math.PI;
				else
					alpha=Math.atan((y2-y1)/(x2-x1))-Math.PI;
			}
		}
		if(alpha<0)
			alpha+=2*Math.PI;
		return alpha;
	}
	//////读取颜色深度文件
	public void readColorDeep(String path){
		OperaColor oc=new OperaColor();
		colors=oc.read_color(path);

		oc.saveSer_color(installPath+"/Config_construct/colorSet.jiaoxi", colors);
	}
	//////读取序列化后的color
	public void readSerColorDeep(){
		OperaColor oc=new OperaColor();
//		colors=oc.readSer_color(installPath+"/Config_construct/colorSet.jiaoxi");
		if(colors==null){
			colors=new Str_Colors();
			colors.colorModel=false;
		}
	}
	/////////读取xyz文件
	public void readXYZ(String path){     //读取XYZ file
		DrawXYZ dx=new DrawXYZ();
		dx.readXYZFile(path, xyzs);

		dx.saveSerXYZ(installPath+"/xyzFile.jiaoxi", xyzs);
	}
	////////读取序列化后的xzy
	public void readserXYZ(){
		DrawXYZ dx=new DrawXYZ();
		xyzs=dx.readSerXYZ(installPath+"/xyzFile.jiaoxi");
	}
	///////读取dig文件
	public void readDig(String path){
		OperaDig od=new OperaDig();
		od.readDigFileName(path, digs);

		od.saveSerDigs(installPath+"/digFile.jiaoxi", digs);
	}
	/////读取序列化后的dig
	public void readSerDig(){
		OperaDig od=new OperaDig();
		digs=od.readSerDigs(installPath+"/digFile.jiaoxi");
	}
	//////////////读取dxf文件
	public void readDxfR12(String path){
		DrawDxfR12 dd=new DrawDxfR12();
		dd.readDxfr12(path, dxfr12s);

		dd.writeSerDxfr12(installPath+"/dxfFile.jiaoxi", dxfr12s);
	}

	//////读取序列化dxf
	public void readSerDxfR12(){
		DrawDxfR12 dd=new DrawDxfR12();
		dxfr12s=dd.readSerDxfr12(installPath+"/dxfFile.jiaoxi");
	}

	/////整合数据代码
	private void conformityData(){
		if(serviceTimer!=null){
			serviceTimer.cancel();
			serviceTimer=null;
		}
		serviceTimer=new Timer();
		serviceTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				if(netConfig.remoteValid==1 && netConfig.sendOrRecve==1 && remoteSocket.decodeResult){
					serverconect = true;
					maxRemoteTime=30;
					Caculate tmpcaculate=(Caculate)remoteSocket.decodeData.getObjectData();
					for(int i=0;i<seekNum;i++){
						finalCacuData.seekData[i]=tmpcaculate.seekData[i];
						finalCacuData.seekEnable[i]=tmpcaculate.seekEnable[i];
					}
					for(int i=0;i<aiNum;i++){
						finalCacuData.anlogData[i]=tmpcaculate.anlogData[i];
						finalCacuData.anlogEnable[i]=tmpcaculate.anlogEnable[i];
					}
					for(int i=0;i<diNum;i++){
						finalCacuData.digitData[i]=tmpcaculate.digitData[i];
						finalCacuData.digitEnbale[i]=tmpcaculate.digitEnbale[i];
					}
					return;
				}
				if(remoteSocket.decodeResult==false)
				{
					serverconect = false;
				}
				if(gpsTest){
					Convert_Gps1();
					finalCacuData.anlogData[66]=(float)headt;
					finalCacuData.anlogEnable[66]=4;
					finalCacuData.anlogData[67]=(float)headt;
					finalCacuData.anlogEnable[67]=4;

				}
				else if(gpsSocket.decodeResult){
					gpsMaxTime=30;
					gv=(GpsValue) gpsSocket.decodeData.getObjectData();

					//////gps数据转换
					Convert_Gps1();
					///gps对地航向
					finalCacuData.anlogData[64]=(float) gv.m_Bearing;////gps里没取这值
					finalCacuData.anlogEnable[64]=4;
					/////双天线gps方向
					finalCacuData.anlogData[66]=(float)gv.m_Heading;
					finalCacuData.anlogEnable[66]=4;
					///////1#gps信号质量
					finalCacuData.anlogData[68]=(float)gv.m_nSatellites;
					finalCacuData.anlogData[68]=4;

					////////船体方向，先从gps中获取，以后需修改
					finalCacuData.anlogData[67]=(float)gv.m_Heading;
					finalCacuData.anlogEnable[67]=4;

					//////1#gps对地航速
					finalCacuData.anlogData[70]=(float)gv.m_SpeedOverGroundKnots;
					finalCacuData.anlogEnable[70]=4;


					//////海拔高度
					finalCacuData.anlogData[44]=(float)gv.m_AntennaAltitudeMeters;
					finalCacuData.anlogEnable[44]=4;


				}
				else{
					if(isMyGps && OperaMyGps.gpsValid && OperaMyGps.isLocation){
						//////gps数据转换
						Convert_Gps1();
						///gps对地航向
						finalCacuData.anlogData[64]=(float) OperaMyGps.bearing;////gps里没取这值
						finalCacuData.anlogEnable[64]=4;
						///gps对地航速
						finalCacuData.anlogData[70]=(float)OperaMyGps.speed;
						finalCacuData.anlogEnable[70]=4;
					}
				}
				///////plc数据处理先简单这样写,具体数据对应再说
				if(ss1.decodeResult){
					plcconect1 = true;
					ssMaxTime=30;
					ss1AiNum=ss1.decodeData.getAiNum();
					ss1DiNum=ss1.decodeData.getDiNum();
					PlcData pd=(PlcData)ss1.decodeData.getObjectData();
					for(int i=0;i<ss1AiNum;i++){
						finalCacuData.anlogData[100+i]=pd.aiData[i];

					}
					for(int i=0;i<ss1DiNum;i++){
						finalCacuData.digitData[i]=pd.diData[i];
					}
				}
				else
				{
					plcconect1 = false;
				}
				///////plc数据处理先简单这样写,具体数据对应再说
				if(ss2.decodeResult){
					plcconect2 = true;
					ssMaxTime=30;
					ss2AiNum=ss2.decodeData.getAiNum();
					ss2DiNum=ss2.decodeData.getDiNum();
					PlcData pd=(PlcData)ss2.decodeData.getObjectData();
					for(int i=0;i<ss2AiNum;i++){
						finalCacuData.anlogData[200+i]=pd.aiData[i];
					}
				}
				else
				{
					plcconect2 = false;
				}
			}
		}, 1000,300);
	}

	public static long getLong(byte[] bytes,int begin)
	{
		return(0xffL & (long)bytes[begin+0]) | (0xff00L & ((long)bytes[begin+1] << 8)) | (0xff0000L & ((long)bytes[begin+2] << 16)) | (0xff000000L & ((long)bytes[begin+3] << 24))
				| (0xff00000000L & ((long)bytes[begin+4] << 32)) | (0xff0000000000L & ((long)bytes[begin+5] << 40)) | (0xff000000000000L & ((long)bytes[begin+6] << 48)) | (0xff00000000000000L & ((long)bytes[begin+7] << 56));
	}

	private double bytesTodouble(byte[] sourceData,int begin){
		long l=getLong(sourceData,begin);

		return Double.longBitsToDouble(l);
	}

	public static int getInt(byte[] bytes,int begin)
	{
		return (0xff & bytes[begin+0]) | (0xff00 & (bytes[begin+1] << 8)) | (0xff0000 & (bytes[begin+2] << 16)) | (0xff000000 & (bytes[begin+3] << 24));
	}

	//////从文kikk件中读取gps参数
	private void readGpsParamFromFile(String fileName){
		gp=GpsConvertClass.readGpsParamFromFile(fileName);
		GpsConvertClass.saveGpsParam(installPath+"/GpsParam.jiaoxi", gp);
	}

	// ///////读取gps参数
	private GpsParam ReadGpsParam() {
		return GpsConvertClass.ReadGpsParam(installPath + "/GpsParam.jiaoxi");
	}

	// ///////读取history参数
	private HistoryParam ReadHistoryParam() {
		return HistoryClass.ReadHistoryParam(installPath + "/HistoryParam.jiaoxi");
	}

	// /////gps数据转换
	private void Convert_Gps1(){
		GpsConvertParamClass gcpc=new GpsConvertParamClass();
		if(gpsTest){
			System.out.println("GPSTEST");
			finalCacuData.seekEnable[0]=4;
			finalCacuData.seekEnable[1]=4;
			finalCacuData.seekEnable[10]=4;
			finalCacuData.seekEnable[11]=4;

			double gps1_ys_x=(int)lat/100+((int)lat-((int)lat)/100*100)*1.0/60+(lat-(int)lat)/60;
			gps1_ys_x=gps1_ys_x*3.1415926535898/180;
			if(bSourthOrNorth){
				gps1_ys_x=-gps1_ys_x;
			}
			finalCacuData.seekData[10]=gps1_ys_x*180/3.1415926535898;
			double gps1_ys_y=(int)lon/100+((int)lon-((int)lon)/100*100)*1.0/60+(lon-(int)lon)/60;
			gps1_ys_y=gps1_ys_y*3.1415926535898/180;
			if(bWestOrEast){
				gps1_ys_y=-gps1_ys_y;
			}
			finalCacuData.seekData[11]=gps1_ys_y*180/3.1415926535898;

			GpsConvertClass.WGS84BLH_XYZ(gps1_ys_x, gps1_ys_y, 0, gcpc, gp);
			GpsConvertClass.XYZ_BEJ54XYZ(gcpc.gx, gcpc.gy, gcpc.gz, gcpc, gp);
			GpsConvertClass.BEJ54XYZ_BEJ54BLH(gcpc.x54,gcpc.y54,gcpc.z54,gcpc,gp);
			GpsConvertClass.BEJ545BLH_GAOSXYZ(gcpc.b,gcpc.l,gcpc.h,gcpc,gp);

			finalCacuData.seekData[0]=gcpc.xx;
			finalCacuData.seekData[1]=gcpc.yy;
			finalCacuData.anlogData[44]=(float) gcpc.zz;
			finalCacuData.anlogEnable[44]=4;
		}
		else if(gpsSocket.decodeResult){

			finalCacuData.seekEnable[0]=4;
			finalCacuData.seekEnable[1]=4;
			finalCacuData.seekEnable[10]=4;
			finalCacuData.seekEnable[11]=4;
			double gps1_ys_x=(int)gv.m_Latitude/100+((int)gv.m_Latitude-((int)gv.m_Latitude)/100*100)*1.0/60+(gv.m_Latitude-(int)gv.m_Latitude)/60;
			gps1_ys_x=gps1_ys_x*3.1415926535898/180;
			if(gv.bSourthOrNorth){
				gps1_ys_x=-gps1_ys_x;
			}
			finalCacuData.seekData[10]=gps1_ys_x*180/3.1415926535898;
			double gps1_ys_y=(int)gv.m_Longitude/100+((int)gv.m_Longitude-((int)gv.m_Longitude)/100*100)*1.0/60+(gv.m_Longitude-(int)gv.m_Longitude)/60;
			gps1_ys_y=gps1_ys_y*3.1415926535898/180;
			if(gv.bWestOrEast){
				gps1_ys_y=-gps1_ys_y;
			}
			finalCacuData.seekData[11]=gps1_ys_y*180/3.1415926535898;

			GpsConvertClass.WGS84BLH_XYZ(gps1_ys_x, gps1_ys_y, gv.m_AntennaAltitudeMeters, gcpc, gp);
			GpsConvertClass.XYZ_BEJ54XYZ(gcpc.gx, gcpc.gy, gcpc.gz, gcpc, gp);
			GpsConvertClass.BEJ54XYZ_BEJ54BLH(gcpc.x54,gcpc.y54,gcpc.z54,gcpc,gp);
			GpsConvertClass.BEJ545BLH_GAOSXYZ(gcpc.b,gcpc.l,gcpc.h,gcpc,gp);

			finalCacuData.seekData[0]=gcpc.xx;
			finalCacuData.seekData[1]=gcpc.yy;
			finalCacuData.anlogData[44]=(float) gcpc.zz;
			finalCacuData.anlogEnable[44]=4;
		}
		else{
			if(isMyGps && OperaMyGps.gpsValid && OperaMyGps.isLocation){
				finalCacuData.seekEnable[0]=4;
				finalCacuData.seekEnable[1]=4;
				finalCacuData.seekEnable[10]=4;
				finalCacuData.seekEnable[11]=4;
				double gps1_ys_x=OperaMyGps.lat;//(int)OperaMyGps.lat/100+((int)OperaMyGps.lat-((int)OperaMyGps.lat)/100*100)*1.0/60+(OperaMyGps.lat-(int)OperaMyGps.lat)/60;
				gps1_ys_x=gps1_ys_x*3.1415926535898/180;
				/*if(gv.bSourthOrNorth){
					gps1_ys_x=-gps1_ys_x;
				}*/
				finalCacuData.seekData[10]=gps1_ys_x*180/3.1415926535898;
				double gps1_ys_y=OperaMyGps.lng;//(int)OperaMyGps.lng/100+((int)OperaMyGps.lng-((int)OperaMyGps.lng)/100*100)*1.0/60+(OperaMyGps.lng-(int)OperaMyGps.lng)/60;
				gps1_ys_y=gps1_ys_y*3.1415926535898/180;
				/*if(gv.bWestOrEast){
					gps1_ys_y=-gps1_ys_y;
				}*/
				finalCacuData.seekData[11]=gps1_ys_y*180/3.1415926535898;

				GpsConvertClass.WGS84BLH_XYZ(gps1_ys_x, gps1_ys_y, OperaMyGps.altitude, gcpc, gp);
				GpsConvertClass.XYZ_BEJ54XYZ(gcpc.gx, gcpc.gy, gcpc.gz, gcpc, gp);
				GpsConvertClass.BEJ54XYZ_BEJ54BLH(gcpc.x54,gcpc.y54,gcpc.z54,gcpc,gp);
				GpsConvertClass.BEJ545BLH_GAOSXYZ(gcpc.b,gcpc.l,gcpc.h,gcpc,gp);

				finalCacuData.seekData[0]=gcpc.xx;
				finalCacuData.seekData[1]=gcpc.yy;
				finalCacuData.anlogData[44]=(float) gcpc.zz;
				finalCacuData.anlogEnable[44]=4;
			}
		}
	}

	//////读取网络配置
	private IpPort readNetConfig(){
		IpPort nc;
		try {
			InputStream in=new FileInputStream(installPath+"/Config_net/netport.jiaoxi");
			ObjectInputStream ois=new ObjectInputStream(in);
			nc=(IpPort)ois.readObject();
			ois.close();
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			nc=new IpPort();
			nc.plc1Port=2001;
			nc.plc1IsValid=1;
			nc.plc2Port=2002;
			nc.plc2IsValid=1;
			nc.gpsIp="192.168.10.97";
			nc.gpsPort=4005;
			nc.gpsIsValid=1;
			nc.remoteIp="112.83.126.129";
			nc.remotePort=60001;
			nc.remoteValid=0;
			nc.sendOrRecve=0;
		}
		return nc;
	}
	/////////////保存网络配置
	private void SaveNetConfig(){
		File f=new File(installPath+"/Config_net/netport.jiaoxi");
		if(f.exists()){
			f.delete();
		}
		try {
			OutputStream os=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(os);
			oos.writeObject(netConfig);
			oos.close();
			os.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/////读取解码库配置
	private DecodeList readDecode(){
		DecodeList d;
		try {
			InputStream in=new FileInputStream(installPath+"/decodeList.jiaoxi");
			ObjectInputStream ois=new ObjectInputStream(in);
			d=(DecodeList)ois.readObject();
			ois.close();
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			d=new DecodeList();
			d.plc1Decode="Decode300";
			d.plc2Decode="Decode301";
			d.gpsDecode="DecodeGps";
		}
		return d;
	}

	///////保存解码库配置
	private void SaveDecode(){
		File f=new File(installPath+"/decodeList.jiaoxi");
		if(f.exists()){
			f.delete();
		}
		try {
			OutputStream os=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(os);
			oos.writeObject(dl);
			oos.close();
			os.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	//////////导入桥架尺过
	private void readArmSizeByFile(String fileName){
		OperaConstructParam ocp=new OperaConstructParam();
		strArmSize=ocp.readArmSize(fileName);
		ocp.saveSerArmSize(installPath+"/Config_construct/ArmSize.jiaoxi", strArmSize);
	}
	///////读取序列化后的桥架尺寸
	private void readSerArmSize(){
		OperaConstructParam ocp=new OperaConstructParam();
		strArmSize=ocp.readSerArmSize(installPath+"/Config_construct/ArmSize.jiaoxi");
	}
	//////保存船舶安装位置
	private void savePlaneInstall(){
		File f=new File(installPath+"/Config_construct/PlaneInstall.jiaoxi");
		if(f.exists()){
			f.delete();
		}
		try {
			OutputStream os=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(os);
			oos.writeObject(planeInstall);
			oos.close();
			os.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	////////读取船舶安装位置方法
	private PlaneInstallJx ReadPlaneInstall(){
		PlaneInstallJx pin;
		try {
			InputStream in=new FileInputStream(installPath+"/Config_construct/PlaneInstall.jiaoxi");
			ObjectInputStream ois=new ObjectInputStream(in);
			pin=(PlaneInstallJx)ois.readObject();
			ois.close();
			in.close();
			/*Properties prop=op.getProperties(installPath+ "/planeInstall.properties");

			/////gps位置
			pin.gps1.x=Float.parseFloat(prop.get("gps1x").toString());
			pin.gps1.y=Float.parseFloat(prop.get("gps1y").toString());
			pin.gps2.x=Float.parseFloat(prop.get("gps2x").toString());
			pin.gps2.y=Float.parseFloat(prop.get("gps2y").toString());

			////左吸口
			pin.leftSuction.x=Float.parseFloat(prop.get("leftSuctionx").toString());
			pin.leftSuction.y=Float.parseFloat(prop.get("leftSuctiony").toString());
			////右吸口
			pin.rightSuction.x=Float.parseFloat(prop.get("rightSuctionx").toString());
			pin.rightSuction.y=Float.parseFloat(prop.get("rightSuctiony").toString());

			///////船舶形状
			pin.shipPlane[0].x=Float.parseFloat(prop.get("shipPlane0x").toString());
			pin.shipPlane[0].y=Float.parseFloat(prop.get("shipPlane0y").toString());
			pin.shipPlane[1].x=Float.parseFloat(prop.get("shipPlane1x").toString());
			pin.shipPlane[1].y=Float.parseFloat(prop.get("shipPlane1y").toString());
			pin.shipPlane[2].x=Float.parseFloat(prop.get("shipPlane2x").toString());
			pin.shipPlane[2].y=Float.parseFloat(prop.get("shipPlane2y").toString());
			pin.shipPlane[3].x=Float.parseFloat(prop.get("shipPlane3x").toString());
			pin.shipPlane[3].y=Float.parseFloat(prop.get("shipPlane3y").toString());
			pin.shipPlane[4].x=Float.parseFloat(prop.get("shipPlane4x").toString());
			pin.shipPlane[4].y=Float.parseFloat(prop.get("shipPlane4y").toString());
			pin.shipPlane[5].x=Float.parseFloat(prop.get("shipPlane5x").toString());
			pin.shipPlane[5].y=Float.parseFloat(prop.get("shipPlane5y").toString());
			pin.shipPlane[6].x=Float.parseFloat(prop.get("shipPlane6x").toString());
			pin.shipPlane[6].y=Float.parseFloat(prop.get("shipPlane6y").toString());

			/////驾驶台
			pin.navigatorRoom[0].x=Float.parseFloat(prop.get("navigatorRoom0x").toString());
			pin.navigatorRoom[0].y=Float.parseFloat(prop.get("navigatorRoom0y").toString());
			pin.navigatorRoom[1].x=Float.parseFloat(prop.get("navigatorRoom1x").toString());
			pin.navigatorRoom[1].y=Float.parseFloat(prop.get("navigatorRoom1y").toString());
			pin.navigatorRoom[2].x=Float.parseFloat(prop.get("navigatorRoom2x").toString());
			pin.navigatorRoom[2].y=Float.parseFloat(prop.get("navigatorRoom2y").toString());
			pin.navigatorRoom[3].x=Float.parseFloat(prop.get("navigatorRoom3x").toString());
			pin.navigatorRoom[3].y=Float.parseFloat(prop.get("navigatorRoom3y").toString());

			////泥舱
			pin.bigDoor[0].x=Float.parseFloat(prop.get("bigDoor0x").toString());
			pin.bigDoor[0].y=Float.parseFloat(prop.get("bigDoor0y").toString());
			pin.bigDoor[1].x=Float.parseFloat(prop.get("bigDoor1x").toString());
			pin.bigDoor[1].y=Float.parseFloat(prop.get("bigDoor1y").toString());
			pin.bigDoor[2].x=Float.parseFloat(prop.get("bigDoor2x").toString());
			pin.bigDoor[2].y=Float.parseFloat(prop.get("bigDoor2y").toString());
			pin.bigDoor[3].x=Float.parseFloat(prop.get("bigDoor3x").toString());
			pin.bigDoor[3].y=Float.parseFloat(prop.get("bigDoor3y").toString());

			//////船体解度来源
			pin.shipAngleFrom=Integer.parseInt(prop.get("shipAngleFrom").toString());
			////艏吹口
			pin.dischargePort.x=Float.parseFloat(prop.get("dischargePortx").toString());
			pin.dischargePort.y=Float.parseFloat(prop.get("dischargePorty").toString());

			/////艏吹口半径
			pin.dischargeRadum=Float.parseFloat(prop.get("dischargeRadum").toString());

			pin.gpsSpeedUnit=Integer.parseInt(prop.get("gpsSpeedUnit").toString());
			/////当前使用的gps
			pin.iCurrentLocationGps=Integer.parseInt(prop.get("iCurrentLocationGps").toString());
			pin.bUseGps2BackGps1=Boolean.parseBoolean(prop.get("bUseGps2BackGps1").toString());*/

		} catch (Exception e) {
			// TODO: handle exception
			pin=new PlaneInstallJx();
			pin.gps1.x=49f;
			pin.gps1.y=9.1f;
			pin.gps2.x=89.5f;
			pin.gps2.y=14.7f;
			pin.MainStackPivot.x=5f;
			pin.MainStackPivot.y=9.1f;
			pin.AssitantStack.x=-1.38f;
			pin.AssitantStack.y=14.1f;
			pin.Winch_Left.x=93.829f;
			pin.Winch_Left.y=5.5f;
			pin.Winch_Right.x=93.829f;
			pin.Winch_Right.y=12.7f;
			DrawShip drawShip=new DrawShip();
			drawShip.drawShip(pin,sdPath+"/project/ship.txt");
			pin.ShipAngleFrom=1;
			pin.SeekType=0;
			/*pin.gps1.x=108.85f;
			pin.gps1.y=6.45f;
			pin.gps2.x=107.96f;
			pin.gps2.y=22.34f;

			////左吸口
			pin.leftSuction.x=45.15f;
			pin.leftSuction.y=0f;
			////右吸口
			pin.rightSuction.x=45.15f;
			pin.rightSuction.y=26.2f;

			///////船舶形状
			pin.shipPlane[0].x=130.25f;
			pin.shipPlane[0].y=13.1f;
			pin.shipPlane[1].x=106f;
			pin.shipPlane[1].y=0f;
			pin.shipPlane[2].x=3.16f;
			pin.shipPlane[2].y=0f;
			pin.shipPlane[3].x=0f;
			pin.shipPlane[3].y=0.2f;
			pin.shipPlane[4].x=0f;
			pin.shipPlane[4].y=26f;
			pin.shipPlane[5].x=3.16f;
			pin.shipPlane[5].y=26.2f;
			pin.shipPlane[6].x=106f;
			pin.shipPlane[6].y=26.2f;

			/////驾驶台
			pin.navigatorRoom[0].x=114.77f;
			pin.navigatorRoom[0].y=4.7f;
			pin.navigatorRoom[1].x=98.73f;
			pin.navigatorRoom[1].y=4.7f;
			pin.navigatorRoom[2].x=98.73f;
			pin.navigatorRoom[2].y=21.5f;
			pin.navigatorRoom[3].x=114.77f;
			pin.navigatorRoom[3].y=21.5f;

			/////驾驶台
			pin.bigDoor[0].x=95.2f;
			pin.bigDoor[0].y=4.5f;
			pin.bigDoor[1].x=32.2f;
			pin.bigDoor[1].y=4.5f;
			pin.bigDoor[2].x=32.2f;
			pin.bigDoor[2].y=21.7f;
			pin.bigDoor[3].x=95.2f;
			pin.bigDoor[3].y=21.7f;
			//////船体解度来源
			pin.shipAngleFrom=1;
			////速度单位
			pin.gpsSpeedUnit=3;////1米/秒,2米/分,3节
			////定位gps
			pin.iCurrentLocationGps=0;
			////
			pin.bUseGps2BackGps1=false;
			pin.bShowZX=false;*/
		}
		return pin;
	}

	// /上传服务器的历史数据先压缩
	private void UploadHistoryFile(String sf) {
		try {
			ZipUtils.zip(sf, sf + ".zip");
			// ZipUtil.unzip("/data/data/com.comc/databases.zip",
			// "/data/data/com.comc/databases");
			File uploadFile = new File(sf + ".zip");
			if(uploadFile.exists()){
				uploadFile(uploadFile);
			}else{
				Toast.makeText(NewMyService.this, "no file", 1).show();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 上传文件
	 *
	 * @param uploadFile
	 */
	private void uploadFile(final File uploadFile) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
//					uploadbar.setMax((int) uploadFile.length());
					String souceid = logService.getBindId(uploadFile);
					String head = "Content-Length=" + uploadFile.length()
							+ ";filename=" + uploadFile.getName()
							+ ";sourceid=" + (souceid == null ? "" : souceid)
							+ "\r\n";
					Socket socket = new Socket("192.168.2.186", 7878);
					OutputStream outStream = socket.getOutputStream();
					outStream.write(head.getBytes());

					PushbackInputStream inStream = new PushbackInputStream(
							socket.getInputStream());
					String response = StreamTool.readLine(inStream);
					String[] items = response.split(";");
					String responseid = items[0].substring(items[0]
							.indexOf("=") + 1);
					String position = items[1].substring(items[1].indexOf("=") + 1);
					if (souceid == null) {// 代表原来没有上传过此文件，往数据库添加一条绑定记录
						logService.save(responseid, uploadFile);
					}
					RandomAccessFile fileOutStream = new RandomAccessFile(
							uploadFile, "r");
					fileOutStream.seek(Integer.valueOf(position));
					byte[] buffer = new byte[1024];
					int len = -1;
					length = Integer.valueOf(position);
					while (start && (len = fileOutStream.read(buffer)) != -1) {
						outStream.write(buffer, 0, len);
						length += len;
//						Message msg = new Message();
//						msg.getData().putInt("size", length);
//						handler.sendMessage(msg);
					}
					fileOutStream.close();
					outStream.close();
					inStream.close();
					socket.close();
					if (length == uploadFile.length())
					{
						logService.delete(uploadFile);
						uploadFile.delete();
						start = false;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	//////保存历史数据
	private void saveHistoryData(String sf){
//		if(historyCaculates.size()<10){/////记录数据小于60条,不记录
//			historyCaculates.clear();
//			hCaculateIndex=0;
//			return;
//		}
		if(hasSD){
			String filename="";
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			filename=sf+"/"+format.format(historyCaculates.get(0).date)+"-"+format.format(historyCaculates.get(historyCaculates.size()-1).date)+".DAT";

			File f=new File(filename);
			if(f.exists()){
				f.delete();
			}
			try {
				OutputStream os=new FileOutputStream(f);
				ObjectOutputStream oos=new ObjectOutputStream(os);
				oos.writeObject(historyCaculates);
				oos.close();
				os.close();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		historyCaculates.clear();
		hCaculateIndex=0;

	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Notification notification=new Notification(R.drawable.ic_launcher,"疏浚服务启动",System.currentTimeMillis());
		Intent notificationIntent=new Intent(this,SeekWindowActivity.class);
		PendingIntent pendingIntent=PendingIntent.getActivity(this, 0, notificationIntent, 0);
		notification.setLatestEventInfo(this, "疏浚界面", "点击打开疏浚界面", pendingIntent);
		startForeground(1, notification);
		//////屏幕常亮
		powerManager = (PowerManager)this.getSystemService(Context.POWER_SERVICE);
		wakeLock = this.powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Lock");
		wakeLock.acquire();

		logService = new UploadLogService(this);//创建上传服务

		ss1=new SocketServer();
		ss2=new SocketServer();
		gpsSocket=new SocketServer();
		////////获取路径
		getPath(this);
		/////发送广播
		Intent broadIntent=new Intent();
		broadIntent.setAction("android.intent.action.MY_RECEIVER");
		broadIntent.putExtra("progress", 1);
		sendBroadcast(broadIntent);

		////创建必要目录
		File tmpDir=new File(installPath+"/Config_net");
		if(!tmpDir.exists()){
			tmpDir.mkdir();
		}
		tmpDir=new File(installPath+"/Config_construct");
		if(!tmpDir.exists()){
			tmpDir.mkdir();
		}
		tmpDir=new File(sdPath+"/mingrun");//软件配置等文件
		if(!tmpDir.exists()){
			tmpDir.mkdir();
		}
		if(hasSD){
			tmpDir=new File(sdPath+"/mingrun/History_Database");
			if(!tmpDir.exists()){
				tmpDir.mkdir();
			}
		}
		tmpDir=new File(sdPath+"/DredgeData");
		if(!tmpDir.exists()){
			tmpDir.mkdir();
		}

		// ///发送广播
		broadIntent.putExtra("progress", 2);
		sendBroadcast(broadIntent);


		////整合后的数据初始化
		finalCacuData=new Caculate();
		finalCacuData.seekData=new double[seekNum];
		finalCacuData.seekEnable=new byte[seekNum];
		finalCacuData.anlogData=new float[aiNum];
		finalCacuData.anlogEnable=new byte[aiNum];
		finalCacuData.digitData=new byte[diNum];
		finalCacuData.digitEnbale=new byte[diNum];

		/////////历史数据
		for(int i=0;i<hCaculatesNum;i++){
			hCaculate[i]=new HistoryCaculate();
			hCaculate[i].caculate.seekData=new double[seekNum];
			hCaculate[i].caculate.seekEnable=new byte[seekNum];
			hCaculate[i].caculate.anlogData=new float[aiNum];
			hCaculate[i].caculate.anlogEnable=new byte[aiNum];
			hCaculate[i].caculate.digitData=new byte[diNum];
			hCaculate[i].caculate.digitEnbale=new byte[diNum];
			hCaculate[i].date=new Date();
		}
		/////////读取船舶平面安装位置
		planeInstall=ReadPlaneInstall();
		//////读取桥架数据
		readSerArmSize();
		///////服务创建时读取网络配置
		netConfig=readNetConfig();
		///////服务创建时读取历史数据配置
		hp=ReadHistoryParam();

		//////////读取解码库设置
		dl=readDecode();

		/////发送广播
		broadIntent.putExtra("progress", 3);
		sendBroadcast(broadIntent);



		///////gps参数
		gp=ReadGpsParam();
		////色深
		readSerColorDeep();
		///dxf
		readSerDxfR12();
		///xyz
		readserXYZ();

		////////获取gps经纬度////经纬度直接读取OperaMyGps中的lat和lng
		OperaMyGps.setRequestLocation(this);


		/////发送广播
		broadIntent.putExtra("progress", 4);
		sendBroadcast(broadIntent);

		setClassName(dl.plc1Decode,ss1);
		setClassName(dl.plc2Decode,ss2);
		setClassName(dl.gpsDecode, gpsSocket);
		if(netConfig.plc1IsValid==1){
			ss1.beginListen1(netConfig.plc1Port);
		}
		if(netConfig.plc2IsValid==1){
			ss2.beginListen2(netConfig.plc2Port);
		}
		if(netConfig.gpsIsValid==1){
			gpsSocket.connectServer(netConfig.gpsIp, netConfig.gpsPort);
		}

		///////发送解码库是空解码库,不做任何处理,以后应该是服务器发申请数据命令,socket再发实时数据过去
		if(netConfig.sendOrRecve==0){
			setClassName("RemoteDecode",remoteSocket);
		}
		else{
			setClassName("RemoteDataDecode",remoteSocket);
		}
		remoteSocket.connectServer(netConfig.remoteIp,netConfig.remotePort);
		/////发送广播
		broadIntent.putExtra("progress", 5);
		sendBroadcast(broadIntent);
		//setClassName("Decode11000",ss);

		//////读取跟踪线
		OperaTraceLine otl=new OperaTraceLine();
		strTraceLine=otl.readSerStrTraceLine(installPath+"/xh.jiaoxi");

		////////////读取轨迹线
		Str_Trochoid_Real tmpReal=OperaStrTrochoidReal.readSerTrochoidReal(installPath+"/currentTrochoid.jiaoxi");
		long time0=System.currentTimeMillis();

		if(tmpReal.trochoidRealIndex>-1){
			Calendar cal1=Calendar.getInstance();

			cal1.setTime(tmpReal.strTrochoidReals[tmpReal.trochoidRealIndex].Time);
			long time1=cal1.getTimeInMillis();
			if((time0-time1)/1000/3600/24>10){
				strTrochoidReal=new Str_Trochoid_Real();
			}
			else{
				strTrochoidReal=tmpReal;
			}
		}
		else if(tmpReal.trochoidLenReal>0){
			Calendar cal1=Calendar.getInstance();

			cal1.setTime(tmpReal.strTrochoidReals[tmpReal.trochoidLenReal-1].Time);
			long time1=cal1.getTimeInMillis();
			if((time0-time1)/1000/3600/24>10){
				strTrochoidReal=new Str_Trochoid_Real();
			}
			else{
				strTrochoidReal=tmpReal;
			}
		}


		/////发送广播
		broadIntent.putExtra("progress", 6);
		sendBroadcast(broadIntent);


		//////开始整合数据
		conformityData();
		//////200ms获取一次临时数据
		realTimer=new Timer();
		realTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				getRealTimeSignal();
			}
		}, 1000,200);
		////////300ms计算一次平面数据
		planeTimer=new Timer();
		planeTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				CaculatePlaneData();
			}
		}, 1000,300);

		////////检测连接是否正常
		maxTimer=new Timer();
		maxTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				if(netConfig.gpsIsValid==1){
					if(gpsMaxTime>0){
						gpsMaxTime--;
					}
					if(gpsMaxTime<=0){
						//gps1Socket.closeSocket();
						gpsSocket.stop=true;
						gpsMaxTime=30;
						gpsSocket.connectServer(netConfig.gpsIp, netConfig.gpsPort);////这个如果一直连接不上,也会造成主gc的执行

					}
				}
				if(netConfig.plc1IsValid==1){
					if(ssMaxTime>0){
						ssMaxTime--;
					}
					if(ssMaxTime<=0){
						if(ss1.cSocket!=null){
							try {
								ss1.cSocket.close();
								ss1.cSocket=null;
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
						ssMaxTime=30;
						plcconect1 = false;
					}
					if(netConfig.remoteValid==1){
						maxRemoteTime--;
						if(maxRemoteTime<=0){
							if(sendDataTimer!=null){
								sendDataTimer.cancel();
								sendDataTimer=null;
							}
							remoteSocket.stop=true;
							maxRemoteTime=20;

							remoteSocket.connectServer(netConfig.remoteIp,netConfig.remotePort);
							serverconect = true;
							remoteSendDate();
						}
					}
				}

				if(netConfig.plc2IsValid==1){
					if(ssMaxTime>0){
						ssMaxTime--;
					}
					if(ssMaxTime<=0){
						if(ss2.cSocket!=null){
							try {
								ss2.cSocket.close();
								ss2.cSocket=null;
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
						ssMaxTime=30;
						plcconect2 = false;
					}
					if(netConfig.remoteValid==1){
						maxRemoteTime--;
						if(maxRemoteTime<=0){
							if(sendDataTimer!=null){
								sendDataTimer.cancel();
								sendDataTimer=null;
							}
							remoteSocket.stop=true;
							maxRemoteTime=20;

							remoteSocket.connectServer(netConfig.remoteIp,netConfig.remotePort);
							serverconect = true;
							remoteSendDate();
						}
					}
				}
			}
		}, 1000,1000);
		if ((hp.bRecordData == true) && (hp.bReview == false)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			// ///计录当前时间
			oldDate = new Date(System.currentTimeMillis());

			Datefpath = sdPath + "/mingrun/History_Database/"
					+ format.format(oldDate);
			Datef = new File(Datefpath);
			if (!Datef.exists()) {
				Datef.mkdir();
			}
			// ////开启历史数据计录定时器
			historyTimer = new Timer();
			historyTimer.schedule(new TimerTask() {

				@Override
				public void run() {
					// TODO 自动生成的方法存根

					for (int i = 0; i < seekNum; i++) {
						hCaculate[hCaculateIndex].caculate.seekData[i] = finalCacuData.seekData[i];
						hCaculate[hCaculateIndex].caculate.seekEnable[i] = finalCacuData.seekEnable[i];
					}
					for (int i = 0; i < aiNum; i++) {
						hCaculate[hCaculateIndex].caculate.anlogData[i] = finalCacuData.anlogData[i];
						hCaculate[hCaculateIndex].caculate.anlogEnable[i] = finalCacuData.anlogEnable[i];

					}
					for (int i = 0; i < diNum; i++) {
						hCaculate[hCaculateIndex].caculate.digitData[i] = finalCacuData.digitData[i];
						hCaculate[hCaculateIndex].caculate.digitEnbale[i] = finalCacuData.digitEnbale[i];
					}
					hCaculate[hCaculateIndex].date.setTime(System
							.currentTimeMillis());
					historyCaculates.add(hCaculate[hCaculateIndex]);
					hCaculateIndex++;
					if (hCaculateIndex >= hCaculatesNum) {
						hCaculateIndex = hCaculatesNum - 1;
					}
				}
			}, 1000, 10000);// //10秒计录一次数据

			// //////////检测时间是否符合保存历史数据
			historySaveTimer = new Timer();
			historySaveTimer.schedule(new TimerTask() {

				@Override
				public void run() {
					// TODO 自动生成的方法存根
					// Date newDate=new
					// Date(System.currentTimeMillis());//////这些new出来的对象都是麻烦事,时间一长就会造成主gc的调用,而且不停的new,就会造成不停的gc
					newDate.setTime(System.currentTimeMillis());
					SimpleDateFormat format1 = new SimpleDateFormat(
							"yyyy-MM-dd");
					if (oldDate.getHours() != newDate.getHours()) {
						if(hp.bUpData)
						{
							UploadHistoryFile(Datefpath);
						}


						saveHistoryData(Datefpath);
						if (oldDate.getDate() != newDate.getDate()) {
							Datefpath = sdPath + "/mingrun/History_Database/"
									+ format1.format(newDate);
							Datef = new File(Datefpath);
							if (!Datef.exists()) {
								Datef.mkdir();
							}
						}
						oldDate.setTime(newDate.getTime());

					}

				}
			}, 1000, 1000);// //1秒检测一次
		}
		////////发送数据
		remoteSendDate();

		/////读取现用工程版本
		projectVersion=readProjectVersion(installPath+"/projectVersion.txt");
		/////////注册下载监听器
		completeReceiver=new CompleteReceiver();
		registerReceiver(completeReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

//		String f123= sdPath + "/121";
//		UploadHistoryFile(f123);  //测试
//		final File uploadFile = new File(sdPath + "/121.zip");
//		if((start ==false) && (length<uploadFile.length()))
//		{
//			// ////开启历史数据计录定时器
//						uploadTimer = new Timer();
//						uploadTimer.schedule(new TimerTask() {
//
//							@Override
//							public void run() {
//								uploadFile(uploadFile);
//
//
//							}
//						}, 1000, 30000);// //30计录一次数据
//		}
		/////发送广播
		broadIntent.putExtra("progress", 7);
		sendBroadcast(broadIntent);

		super.onCreate();
	}

	private void remoteSendDate() {
		// TODO 自动生成的方法存根
		if(netConfig.remoteValid==1 && netConfig.sendOrRecve==0){
			if(sendDataTimer!=null){
				sendDataTimer.cancel();
				sendDataTimer=null;
			}
			sendDataTimer=new Timer();
			sendDataTimer.schedule(new TimerTask() {

				@Override
				public void run() {
					// TODO 自动生成的方法存根
					int index=0;
					sendByte[0]='$';
					sendByte[1]='L';
					sendByte[2]='A';
					sendByte[3]='N';
					index=4;
					for(int i=0;i<seekNum;i++){
						doubleToByte(finalCacuData.seekData[i], sendByte, index);
						index+=8;
					}
					for(int i=0;i<seekNum;i++){
						sendByte[i+index]=finalCacuData.seekEnable[i];
					}
					index+=seekNum;
					for(int i=0;i<aiNum;i++){
						floatToByte(finalCacuData.anlogData[i], sendByte, index);
						index+=4;
					}
					for(int i=0;i<aiNum;i++){
						sendByte[i+index]=finalCacuData.anlogEnable[i];
					}
					index+=aiNum;
					for(int i=0;i<diNum;i++){
						sendByte[i+index]=finalCacuData.digitData[i];
					}
					index+=diNum;
					for(int i=0;i<diNum;i++){
						sendByte[i+index]=finalCacuData.digitEnbale[i];
					}
					remoteSocket.SendCommandRealData(sendByte);
				}
			}, 1000,1000);
		}
	}

	public static void doubleToByte(double d,byte[] b,int index){

		long l = Double.doubleToLongBits(d);
		for(int i = 0; i < 8; i++ ){
			b[i+index]= new Long(l).byteValue();
			l=l>>8;
		}
	}
	public static void floatToByte(float d,byte[] b,int index){

		int l = Float.floatToIntBits(d);
		for(int i = 0; i < 4; i++ ){
			b[i+index]= new Integer(l).byteValue();
			l=l>>8;
		}
	}


	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		/////反注册下载监听器
		unregisterReceiver(completeReceiver);
		if(downloadCanTimer!=null){
			downloadCanTimer.cancel();
			downloadCanTimer=null;
		}
		if(maxTimer!=null){
			maxTimer.cancel();
			maxTimer=null;
		}
		if(ss1!=null){
			ss1.closeSocket();
		}
		if(ss2!=null){
			ss2.closeSocket();
		}
		if(gpsSocket!=null){
			gpsSocket.closeSocket();
		}
		if(sendDataTimer!=null){
			sendDataTimer.cancel();
			sendDataTimer=null;
		}
		if(remoteSocket!=null){
			remoteSocket.closeSocket();
		}
		// //保存历史数据
		if ((hp.bRecordData == true) && (hp.bReview == false)) {
			saveHistoryData(Datefpath);
		}
		/////保存正在使用的轨迹线
		OperaStrTrochoidReal.saveTrochoidReal(installPath+"/currenTrochoid.jiaoxi", strTrochoidReal);

		wakeLock.release();

		Process.killProcess(Process.myPid());
		super.onDestroy();
	}


	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
	}


	class MyBinder extends Binder{
		public void sendCommand(byte[] command){
			ss1.SendCommand(command);
		}
		//////返回实时数据
		public Caculate getCaculate(){
			return finalCacuData;
		}

		/////返回船舶平面安装位置
		public PlaneInstallJx getPlaneInstall(){
			return planeInstall;
		}
//		public SocketServer getSocket(){111111111
//			return ss1;
//		}
		public SocketServer getGpsSocket(){
			return gpsSocket;
		}


		public IpPort getNetConfig(){
			return netConfig;
		}
		public HistoryParam getHistoryConfig(){
			return hp;
		}
		public GpsParam getGpsConfig(){
			return gp;
		}
		////////设置和保存网络酣眠置
		public void setNetConfig(IpPort ipPort){
//			netConfig.plc1Port=ipPort.plc1Port;
//			netConfig.plc1IsValid=ipPort.plc1IsValid;
			netConfig.plc2Port=ipPort.plc2Port;
			netConfig.plc2IsValid=ipPort.plc2IsValid;
			netConfig.gpsIp=ipPort.gpsIp;
			netConfig.gpsPort=ipPort.gpsPort;
			netConfig.gpsIsValid=ipPort.gpsIsValid;
			netConfig.remoteIp=ipPort.remoteIp;
			netConfig.remotePort=ipPort.remotePort;
			netConfig.remoteValid=ipPort.remoteValid;
			netConfig.sendOrRecve=ipPort.sendOrRecve;

			SaveNetConfig();

			if(netConfig.plc1IsValid==0){
				ss1.closeSocket();
			}
			else{
				////重新启动plc监听
				ss1.stop=true;
				ss1.beginListen1(netConfig.plc1Port);
			}
			if(netConfig.plc2IsValid==0){
				ss2.closeSocket();
			}
			else{
				////重新启动plc监听
				ss2.stop=true;
				ss2.beginListen2(netConfig.plc2Port);
			}
			if(netConfig.gpsIsValid==0){

				gpsSocket.closeSocket();
			}
			else{
				gpsSocket.stop=true;
				gpsSocket.connectServer(netConfig.gpsIp, netConfig.gpsPort);
			}

			if(netConfig.remoteValid==0){
				if(sendDataTimer!=null){
					sendDataTimer.cancel();
					sendDataTimer=null;
				}

				remoteSocket.closeSocket();

			}
			else{
				if(sendDataTimer!=null){
					sendDataTimer.cancel();
					sendDataTimer=null;
				}
				remoteSocket.stop=true;
				remoteSocket.connectServer(netConfig.remoteIp, netConfig.remotePort);

				remoteSendDate();//发送数据

			}
		}
		////////设置和保存GPS设置
		public void setGpsConfig(GpsParam gpsparam){
			gp.GPS_CS_a=gpsparam.GPS_CS_a;
			gp.GPS_CS_f=gpsparam.GPS_CS_f;
			gp.GPS_CS_ZYZWX=gpsparam.GPS_CS_ZYZWX;
			gp.GPS_CS_Tx=gpsparam.GPS_CS_Tx;
			gp.GPS_CS_Ty=gpsparam.GPS_CS_Ty;
			gp.GPS_CS_Tz=gpsparam.GPS_CS_Tz;
			gp.GPS_CS_S=gpsparam.GPS_CS_S;
			gp.GPS_CS_Rx=gpsparam.GPS_CS_Rx;
			gp.GPS_CS_Ry=gpsparam.GPS_CS_Ry;
			gp.GPS_CS_Rz=gpsparam.GPS_CS_Rz;
			gp.GPS_CS_DeltaX=gpsparam.GPS_CS_DeltaX;
			gp.GPS_CS_DeltaY=gpsparam.GPS_CS_DeltaY;
			gp.GPS_CS_DeltaZ=gpsparam.GPS_CS_DeltaZ;
			gp.GPS_UTM_Scale=gpsparam.GPS_UTM_Scale;
			gp.GPS_CS_Mode=gpsparam.GPS_CS_Mode;
			gp.bLocalChange=gpsparam.bLocalChange;
			gp.fRotateCenterX=gpsparam.fRotateCenterX;
			gp.fRotateCenterY=gpsparam.fRotateCenterY;
			gp.fRotateAngle=gpsparam.fRotateAngle;
			gp.fRotateScale=gpsparam.fRotateScale;

			GpsConvertClass.saveGpsParam(installPath+"/GpsParam.jiaoxi", gp);
		}
		////////设置和保存历史回放设置
		public void setHistoryConfig(HistoryParam historyParam){
			hp.bRecordData=historyParam.bRecordData;
			hp.bReview=historyParam.bReview;
			hp.bUpData=historyParam.bUpData;

			HistoryClass.SaveHistoryParam(installPath+"/HistoryParam.jiaoxi", hp);
		}
		public DecodeList getDecodeList(){
			return dl;
		}
		///////设置和保存解码库
		public void setDecodeList(DecodeList dl1){
			dl.plc1Decode=dl1.plc1Decode;
			dl.plc2Decode=dl1.plc2Decode;
			dl.gpsDecode=dl1.gpsDecode;

			SaveDecode();
			setClassName(dl.plc1Decode, ss1);
			setClassName(dl.plc2Decode, ss2);
			setClassName(dl.gpsDecode, gpsSocket);
		}

		////获取dxf文件列表
		public List<Dxf_r12> getDxfR12s(){
			return dxfr12s;
		}
		public void clearDxfR12(){
			dxfr12s.clear();
		}

		//////先暴露读取dxf方法
		public void readDxf(String path){
			readDxfR12(path);
		}

		public void readSerDxf(){
			readSerDxfR12();
		}

		public void readDigFile(String path){
			readDig(path);
		}
		public void readSerDigs(){
			readSerDig();
		}
		public List<DigData> getDigs(){
			return digs;
		}

		public void clearXYZ(){
			xyzs.clear();
		}
		public void readXYZFile(String path){
			readXYZ(path);
		}
		public void readSerXYZFile(){
			readserXYZ();
		}
		public List<Str_Xyz> getXYZ(){
			return xyzs;
		}
		public void readColorSet(String path){
			readColorDeep(path);
		}
		public void readSerColorSet(){
			readSerColorDeep();
		}
		public Str_Colors getColorSet(){
			return colors;
		}

		public int getMaxScreenWidth(){
			return maxScreenWidth;
		}
		public int getMaxScreenHeight(){
			return maxScreenHeight;
		}
		public int getScreenWidth(){
			return screenWidth;
		}
		public int getScreenHeight(){
			return screenHeight;
		}

		public void setScale(float sX,float sY,float angle){
			scaleX=sX;
			scaleY=sY;
			rotations=angle;
		}

		// /gps
		public void readGpsParamFromOutFile(String fileName) {
			readGpsParamFromFile(fileName);
		}
		////////缩放
		public float getScaleX(){
			return scaleX;
		}
		public float getScaleY(){
			return scaleY;
		}
		//////旋转角度
		public float getRotation(){
			return rotations;
		}
		////////旋转缩放锁定参数
		public int getLockParam(){
			return lock;
		}
		public void setLockParam(int l){
			lock=l;
		}
		public int getLock2Param(){
			return lock2;
		}
		public void setLock2Param(int l){
			lock2=l;
		}
		public boolean getAutoCenter(){
			return isGpsCenter;
		}
		public void setAutoCenter(boolean i){
			isGpsCenter=i;
		}
		public Str_Ship_Point getShipPoint(){
			return strShipPoint;
		}
		public Str_Arm_Size getArmSize(){
			return strArmSize;
		}
		public Str_RealTimeSignal getRealTimeSignal(){
			return strRealTimeSignal;
		}
		public Str_Trochoid_Real getTrochoidReal(){
			return strTrochoidReal;
		}

		public double getCenterX(){
			return centerX;
		}
		public double getCenterY(){
			return centerY;
		}
		public void setCenter(double cx,double cy){
			centerX=cx;
			centerY=cy;
		}

		public boolean getIsNewData(){
			return isNewData;
		}
		public void setIsNewData(boolean i){
			isNewData=i;
		}
//		public void setApplyClassName(String className,SocketServer s){
//			setClassName(className,s);
//		}
	}

	///////设置加载的解码库
	public void setClassName(String className,SocketServer s){
		String tmpClassName="jiaoxi.crazyit.decode."+className;
		loadClassName(tmpClassName,s);
//		seekData=s.decodeData.getSeekData();
//		seekNum=s.decodeData.getSeekNum();
//		aiData=s.decodeData.getAiData();
//		aiDataNum=s.decodeData.getAiNum();
//		diData=s.decodeData.getDiData();
//		diDataNum=s.decodeData.getDiNum();
//		seekEnable=s.decodeData.getSeekEnable();
//		anlogEnable=s.decodeData.getAnlogEnable();
//		digitEnable=s.decodeData.getDigitEnable();
		s.applyCommand=s.decodeData.getApplyCommand();
		if(s.applyCommand!=null){
			s.startAutoSend();
		}
		else{
			s.stopAutoSend();
		}
	}
	public void loadClassName(String className,SocketServer s){
		try {
			Class c=Class.forName(className);
			s.decodeData=(DecodeReceiveData)c.newInstance();
			//m=c.getMethod("decodeData", params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	public class SocketServer {
		DecodeReceiveData decodeData=null;
		ServerSocket server1=null;;
		ServerSocket server2=null;;
		byte[] sCommand;
		byte[] applyCommand;
		Socket cSocket=null;
		OutputStream outStream=null;
		InputStream inStream=null;
		String serverIp;
		int serverPort;
		byte[] buf=new byte[10240];
		boolean isAutoSend=false;
		boolean stop=false;
		private Timer timer1=null;

		private boolean decodeResult=false;

		public boolean getDecodeResult(){
			return decodeResult;
		}
		public void startAutoSend(){
			isAutoSend=true;
			if(timer1!=null){
				timer1.cancel();
				timer1=null;
			}
			timer1=new Timer();
			timer1.schedule(new TimerTask() {

				@Override
				public void run() {
					// TODO 自动生成的方法存根
					if(isAutoSend){
						SendCommand(applyCommand);
					}
				}
			}, 1000,300);

		}
		public void stopAutoSend(){
			isAutoSend=false;
			if(timer1!=null){
				timer1.cancel();
				timer1=null;
			}
		}
//		public void setApplyCommand(byte[] command){
//			applyCommand=command;
//			if(timer1!=null){
//				timer1.cancel();
//				timer1=null;
//			}
//			timer1=new Timer();
//			timer1.schedule(new TimerTask() {
//
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					if(isAutoSend){
//						SendCommand(applyCommand);
//					}
//				}
//			}, 300,300);
//
//		}

		public void connectServer(String ip,int port){
			try {
				if(inStream!=null){
					inStream.close();
					inStream=null;
				}
				if(outStream!=null){
					outStream.close();
					outStream=null;
				}
				if(cSocket!=null){
					cSocket.close();
					cSocket=null;
				}
				if(server1!=null){
					server1.close();
					server1=null;
				}
				if(server2!=null){
					server2.close();
					server2=null;
				}
				/*if(timer1!=null){
					timer1.cancel();
					timer1=null;
				}*/
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			serverIp=ip;
			serverPort=port;

			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						if(cSocket!=null){
							cSocket.close();
							cSocket=null;
						}
						cSocket=new Socket(serverIp, serverPort);
						if(cSocket!=null){
							outStream=cSocket.getOutputStream();

							inStream=cSocket.getInputStream();

							stop=false;
							new Thread(new Runnable() {

								@Override
								public void run() {
									// TODO Auto-generated method stub
									//buf=new byte[10240];
									while(!stop){
										if(cSocket.equals(null)||cSocket.isClosed()||!cSocket.isConnected()||cSocket.isInputShutdown()||cSocket.isOutputShutdown()){
											stop=true;
											break;
										}
										try {
											int len=inStream.read(buf);

											///////这里解码
											//m.invoke(buf, len);
											if(len>0){
												decodeResult= decodeData.decodeData(buf, len);
											}
											else{
												decodeResult=false;
												if(stop){
													break;
												}
											}

										} catch (Exception e) {
											// TODO: handle exception
										}
									}
								}
							}).start();
							/*Intent intent=new Intent();
							intent.setAction("android.intent.action.MY_RECEIVER");
							intent.putExtra("connectState", true);
							sendBroadcast(intent);*/
						}
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


				}
			}).start();
		}

		public void SendCommandRealData(byte[] command){
			sCommand=command;
//			cS=s;
//			cW=w;
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						if(cSocket!=null && cSocket.isConnected() && outStream!=null){
							outStream.write(sCommand);
							outStream.flush();
							maxRemoteTime=20;
						}
						else{

							/*Intent intent=new Intent();
							intent.setAction("android.intent.action.MY_RECEIVER");
							intent.putExtra("connectState", false);
							sendBroadcast(intent);*/

							//stopTime();

							//Toast.makeText(MyService.this, "服务器已断开连接", Toast.LENGTH_SHORT).show();
						}

					} catch (Exception e) {
						// TODO: handle exception
						/*Intent intent=new Intent();
						intent.setAction("android.intent.action.MY_RECEIVER");
						intent.putExtra("connectState", false);
						sendBroadcast(intent);*/
						//stopTime();

						//Toast.makeText(MyService.this, "服务器已断开连接", Toast.LENGTH_SHORT).show();
					}
				}
			}).start();

		}

		public void SendCommand(byte[] command){
			sCommand=command;
//			cS=s;
//			cW=w;
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						if(cSocket!=null && cSocket.isConnected() && outStream!=null){
							outStream.write(sCommand);
							outStream.flush();
							//maxRemoteTime=30;
						}
						else{

							/*Intent intent=new Intent();
							intent.setAction("android.intent.action.MY_RECEIVER");
							intent.putExtra("connectState", false);
							sendBroadcast(intent);*/

							//stopTime();

							//Toast.makeText(MyService.this, "服务器已断开连接", Toast.LENGTH_SHORT).show();
						}

					} catch (Exception e) {
						// TODO: handle exception
						/*Intent intent=new Intent();
						intent.setAction("android.intent.action.MY_RECEIVER");
						intent.putExtra("connectState", false);
						sendBroadcast(intent);*/
						//stopTime();

						//Toast.makeText(MyService.this, "服务器已断开连接", Toast.LENGTH_SHORT).show();
					}
				}
			}).start();

		}
		///关闭
		public void closeSocket(){
			stop=true;
			try {
				if(outStream!=null){
					outStream.close();
					outStream=null;
				}
				if(inStream!=null){
					inStream.close();
					inStream=null;
				}
				if(cSocket!=null){
					cSocket.close();
					cSocket=null;
				}
				if(server1!=null){
					server1.close();
					server1=null;
				}
				if(server2!=null){
					server2.close();
					server2=null;
				}
				if(timer1!=null){
					timer1.cancel();
					timer1=null;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}


		}

		///////监听1
		public void beginListen1(int port){
			try{
				if(inStream!=null){
					inStream.close();
					inStream=null;
				}
				if(outStream!=null){
					outStream.close();
					outStream=null;
				}
				if(cSocket!=null){
					cSocket.close();
					cSocket=null;
				}
				if(server1!=null){
					server1.close();
					server1=null;
				}
				/*if(timer1!=null){
					timer1.cancel();
					timer1=null;
				}*/
				server1 = new ServerSocket(port);
			}catch(IOException e){
				e.printStackTrace();
			}
			stop=false;
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(!stop){
						try{
							/*Intent intent=new Intent();
							intent.setAction("android.intent.action.MY_RECEIVER");
							intent.putExtra("connectState", true);
							sendBroadcast(intent);*/


							cSocket = server1.accept();

							outStream=cSocket.getOutputStream();
							inStream=cSocket.getInputStream();

							new Thread(new Runnable() {

								@Override
								public void run() {
									// TODO Auto-generated method stub
									//buf=new byte[10240];
									while(true){
//										if(cSocket.equals(null)||cSocket.isClosed()||!cSocket.isConnected()||cSocket.isInputShutdown()||cSocket.isOutputShutdown()){
//											break;
//										}
										try {
											int len=inStream.read(buf);

											///////这里解码
											//m.invoke(buf, len);

											if(len>0){
												decodeResult=decodeData.decodeData(buf, len);
											}
											else{
												decodeResult=false;
											}
										} catch (Exception e) {
											// TODO: handle exception
											e.printStackTrace();
										}
									}
								}
							}).start();

						}catch(IOException e){
							e.printStackTrace();
						}
					}
				}
			}).start();

		}
		///////监听2
		public void beginListen2(int port){
			try{
				if(inStream!=null){
					inStream.close();
					inStream=null;
				}
				if(outStream!=null){
					outStream.close();
					outStream=null;
				}
				if(cSocket!=null){
					cSocket.close();
					cSocket=null;
				}
				if(server2!=null){
					server2.close();
					server2=null;
				}
				/*if(timer1!=null){
					timer1.cancel();
					timer1=null;
				}*/
				server2 = new ServerSocket(port);
			}catch(IOException e){
				e.printStackTrace();
			}
			stop=false;
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(!stop){
						try{
							/*Intent intent=new Intent();
							intent.setAction("android.intent.action.MY_RECEIVER");
							intent.putExtra("connectState", true);
							sendBroadcast(intent);*/


							cSocket = server2.accept();

							outStream=cSocket.getOutputStream();
							inStream=cSocket.getInputStream();

							new Thread(new Runnable() {

								@Override
								public void run() {
									// TODO Auto-generated method stub
									//buf=new byte[10240];
									while(true){
//										if(cSocket.equals(null)||cSocket.isClosed()||!cSocket.isConnected()||cSocket.isInputShutdown()||cSocket.isOutputShutdown()){
//											break;
//										}
										try {
											int len=inStream.read(buf);

											///////这里解码
											//m.invoke(buf, len);

											if(len>0){
												decodeResult=decodeData.decodeData(buf, len);
											}
											else{
												decodeResult=false;
											}
										} catch (Exception e) {
											// TODO: handle exception
											e.printStackTrace();
										}
									}
								}
							}).start();

						}catch(IOException e){
							e.printStackTrace();
						}
					}
				}
			}).start();

		}
	}

	//////监听器
	class CompleteReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO 自动生成的方法存根
			long completeDownlodId=intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
			if(completeDownlodId==versionId){
				float version=readProjectVersion(sdPath+"/project/projectVersion.txt");
				if(version>projectVersion){
					///////这里开始下载工程文件
				}
				else{
					isDownload=false;
				}
			}
		}

	};

	//////////下载文件
	private void downloadNewFile(){

	}
}
