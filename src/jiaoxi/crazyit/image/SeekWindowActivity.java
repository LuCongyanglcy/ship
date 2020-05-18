package jiaoxi.crazyit.image;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import jiaoxi.crazyit.classes.Density;
import jiaoxi.crazyit.classes.UISet.DrawShip;
import jiaoxi.crazyit.brightness.BrightnessTools;
import jiaoxi.crazyit.classes.Caculate;
import jiaoxi.crazyit.classes.PlaneInstallJx;
import jiaoxi.crazyit.classes.Str_RealTimeSignal;
import jiaoxi.crazyit.classes.Str_Ship_Point;
import jiaoxi.crazyit.classes.Str_Trochoid_Real;
import jiaoxi.crazyit.classes.construct.Str_Arm_Size;
import jiaoxi.crazyit.classes.dig.DigData;
import jiaoxi.crazyit.classes.dig.OperaDig;
import jiaoxi.crazyit.classes.dxf.DrawDxfR12;
import jiaoxi.crazyit.classes.dxf.Dxf_r12;
import jiaoxi.crazyit.classes.dxf.Dxfr12_polyline;
import jiaoxi.crazyit.classes.history.HistoryParam;
import jiaoxi.crazyit.classes.xyz.DrawXYZ;
import jiaoxi.crazyit.classes.xyz.Str_Colors;
import jiaoxi.crazyit.classes.xyz.Str_Xyz;
import jiaoxi.crazyit.decode.ClientSocket;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.FloatMath;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class SeekWindowActivity extends Activity implements OnGestureListener {


	/*final int maxScreenWidth=2560;
	final int maxScreenHeight=1600;
	final int screenWidth=maxScreenWidth-300;
	final int screenHeight=maxScreenHeight-300;*/

    int maxScreenWidth;
    int maxScreenHeight;
    int screenWidth;
    int screenHeight;
    Rect strRect = new Rect();

    ///////2018/2/5 吴 连接连上位机
    String FILE_PATH = "/sdcard/project/";
    String ip = "192.168.0.2";
    //String ip="192.168.18.124";
    ClientSocket cs;
    int port = 30032;
    String sendMessage = "0";
    DataInputStream getMessageStream = null;
    static byte[] _byte = new byte[1024];

    //////定义下载的弹出窗口
    private PopupWindow popDownloadProgress;
    private View popView;

    boolean isStopDraw = true;
    ///////导入施工数据进度条
    ProgressDialog progress = null;
    ProgressDialog progress2 = null;

    ////旋转用
    float oldRotation = 0;
    float rotations = 0;////整图需要旋转的角度

    /////弧度,通过角度计算后的弧度
    float angle = 0;

    /////缩放用
    float oldDist = 1f;    /////计录多点触控第一次线长
    int mode = 0;        ///////计录触控模式

    //////移动
    PointF oldPoint = new PointF();/////移动时按下的第一个点坐标

    PointF oldBrightnessPoint = new PointF();////调节亮度的点
    //////亮度进度条
    ProgressDialog brightnessProgress = null;

    float scaleX = screenWidth / 10;
    float scaleY = screenHeight / 10;
    public int cc = 0;

    ///////////界面中心点
    double centerX;
    double centerY;

    //////是否以gps坐标作为中心点
    boolean isGpsCenter = true;

    //////右边文本字体大小
    final int rightFontSize = 45;
    ////////////给轨迹线固定分配内存,使平板不用重复分配内存导制速度变慢
    float[] trochoidPx = new float[10000];
    float[] trochoidPy = new float[10000];

    ///////画真北方向数据
    int[] northX = new int[7];
    int[] northY = new int[7];
    int[] northLX = new int[4];
    int[] northLY = new int[4];

    //////////下方按钮

    ImageButton btnOrigial = null;    /////恢复原如尺寸
    ImageButton btnNorth = null;////恢复真北方向
    ImageButton btnAutoCenter = null;/////船位自动回中心

    String[] str = new String[4];//保存


    ImageButton btnImport = null;// ///导入施工数据
    ImageButton btnIFC = null;//从电脑导入施工数据
    ImageButton btnClear = null;//清空累计产量

    // 历史回放按钮 沈阳加
    ImageButton btnHistoryOpen = null;// ///打开历史回放数据
    ImageButton btnHistorystart = null;// ///播放历史数据
    ImageButton btnHistorypause = null;// ///暂停历史数据
    ImageButton btnHistorystop = null;// ///停止历史数据
    ImageButton btnHistorylast = null;// ///快退看历史数据
    ImageButton btnHistorynext = null;// ///快进看历史数据
    SeekBar seekBar1;

    //历史回放
    public HistoryParam history = null;
    boolean ishistoryrecord;//记录数据
    boolean ishistoryreview;//回放数据

    String sdPath;

    private final int offset = 4;

    private Timer testTimer = null;


    private Timer newMessageTime = null;////////从服务器接收到新数据时启动
    private boolean isNewData;
    private boolean isShowNew = true;//////图片切换


    private ViewFlipper viewFilipper = null;
    private GestureDetector gestrueDetector = null;
    //////实时数据
    private Caculate cacuDate = null;

    ///////dxf文件
    private List<Dxf_r12> r12s = null;

    ///////dxf文件操作类
    //DrawDxfR12 drawDxf=new DrawDxfR12();

    ////////dig文件
    private List<DigData> digs = null;
    OperaDig od = new OperaDig();

    /////xyz文件
    private List<Str_Xyz> xyzs = null;
    //DrawXYZ dx=new DrawXYZ();

    ///////色深
    private Str_Colors colors = null;


    //////船舶平面安装位置
    private PlaneInstallJx planeInstall = null;

    /////临时数据
    private Str_RealTimeSignal strRealTimeSignal = null;
    //////计算后平面位置
    private Str_Ship_Point strShipPoint = null;
    ////////桥架数据
    private Str_Arm_Size strArmSize = null;

    ///////船舶形状bitmap
    private Bitmap shipBitmap = null;
    //////最终图
    private Bitmap finalBitmap = null;

    ///////画图对象,提成全局变量,不用每次new,减少主gc的机会
    Canvas canvas = null;

    Paint p = new Paint();

    ///////dxf,xyz等的数量
    int dNum = 0;

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

            maxScreenWidth = myBinder.getMaxScreenWidth();
            maxScreenHeight = myBinder.getMaxScreenHeight();
            screenWidth = myBinder.getScreenWidth();
            screenHeight = myBinder.getScreenHeight();

            shipBitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
            finalBitmap = Bitmap.createBitmap(maxScreenWidth, screenHeight, Bitmap.Config.ARGB_8888);

            canvas = new Canvas(shipBitmap);

            //历史回放 沈阳
            history = myBinder.getHistoryConfig();

            ImageView image = new ImageView(SeekWindowActivity.this);
            image.setImageBitmap(finalBitmap);
            image.setScaleType(ImageView.ScaleType.FIT_XY);
            image.setLongClickable(true);

            viewFilipper.addView(image, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));

            strRect.left = 0;
            strRect.top = 0;
            strRect.right = screenWidth;
            strRect.bottom = screenHeight;

            planeInstall = myBinder.getPlaneInstall();
            cacuDate = myBinder.getCaculate();
//			drawShip(0,shipBitmap.getWidth()/2,shipBitmap.getHeight()/2,2,2);
//			viewFilipper.postInvalidate();
            r12s = myBinder.getDxfR12s();
            digs = myBinder.getDigs();
            xyzs = myBinder.getXYZ();
            colors = myBinder.getColorSet();

            scaleX = myBinder.getScaleX();
            scaleY = myBinder.getScaleY();
            rotations = myBinder.getRotation();
            //lock=myBinder.getLockParam();
            //lock2=myBinder.getLock2Param();
            isGpsCenter = myBinder.getAutoCenter();

            strRealTimeSignal = myBinder.getRealTimeSignal();
            strArmSize = myBinder.getArmSize();
            strShipPoint = myBinder.getShipPoint();

            centerX = myBinder.getCenterX();
            centerY = myBinder.getCenterY();

            isNewData = myBinder.getIsNewData();

            btnImport.setBackgroundColor(Color.DKGRAY);
            btnIFC.setBackgroundColor(Color.DKGRAY);
            btnClear.setBackgroundColor(Color.DKGRAY);


            btnOrigial.setBackgroundColor(Color.DKGRAY);
            btnNorth.setBackgroundColor(Color.DKGRAY);
            if (isGpsCenter) {
                btnAutoCenter.setBackgroundColor(Color.GREEN);

            } else {
                btnAutoCenter.setBackgroundColor(Color.DKGRAY);

            }

            //历史回放沈阳
            if ((history.bRecordData == false) && (history.bReview == true)) {
                btnHistoryOpen.setVisibility(View.VISIBLE);
                btnHistorystart.setVisibility(View.VISIBLE);
                btnHistorypause.setVisibility(View.VISIBLE);
                btnHistorystop.setVisibility(View.VISIBLE);
                btnHistorylast.setVisibility(View.VISIBLE);
                btnHistorynext.setVisibility(View.VISIBLE);
                seekBar1.setVisibility(View.VISIBLE);

                btnHistoryOpen.setBackgroundColor(Color.WHITE);
                btnHistorystart.setBackgroundColor(Color.WHITE);
                btnHistorypause.setBackgroundColor(Color.WHITE);
                btnHistorystop.setBackgroundColor(Color.WHITE);
                btnHistorylast.setBackgroundColor(Color.WHITE);
                btnHistorynext.setBackgroundColor(Color.WHITE);
            }

            //////亮度

            BrightnessTools.getScreenBrightness(SeekWindowActivity.this);


            testTimer = new Timer();
            testTimer.schedule(new TimerTask() {

                @Override
                public void run() {
                    // TODO 自动生成的方法存根
//					testDegress+=10;
//					if(testDegress>=360){
//						testDegress=0;
//					}
//					Canvas c=new Canvas(shipBitmap);
//					c.drawColor(Color.TRANSPARENT,Mode.CLEAR);

                    if (isStopDraw) {
                        synchronized (connection) {
                            synchronized (finalBitmap) {
                                synchronized (shipBitmap) {
                                    /////////是否gps作为中心点
                                    if (isGpsCenter) {
                                        centerX = strShipPoint.P6[0];
                                        centerY = strShipPoint.P6[1];
                                        myBinder.setCenter(centerX, centerY);
                                    }

                                    canvas.setBitmap(shipBitmap);
                                    canvas.drawColor(Color.TRANSPARENT, Mode.CLEAR);


                                    angle = rotations * (float) Math.PI / 180;

                                    if (xyzs != null && xyzs.size() > 0) {
                                        int[] colorss = colors.colors;
                                        float[] deeps = colors.deeps;
                                        for (Str_Xyz xyz:xyzs){
                                            DrawXYZ.DrawXYZToCanvas(canvas, xyz, strRect, (float) centerX, (float) centerY, scaleX, scaleY, 30, 0, colorss, deeps, 20, colors.colorModel, angle);
                                        }
                                    }
                                    //Canvas canvas=new Canvas(shipBitmap);
                                    if (r12s != null && r12s.size() > 0) {
                                        for(Dxf_r12 r12:r12s) {
                                            DrawDxfR12.drawDxfR12(canvas, strRect, scaleX, scaleY, (float) centerX, (float) centerY, r12, angle);
                                        }
                                    }
                                    drawTrochoid(canvas, strRect, (float) centerX, (float) centerY, angle);

                                    drawNorth(canvas, angle);

                                    //drawShip(cacuDate.anlogData[67],rect,scaleX,scaleY,cacuDate.seekData[0],cacuDate.seekData[1]);
                                    drawShipPoint(canvas, strRect, (float) centerX, (float) centerY, Color.rgb(0, 0, 0), angle);

                                    canvas.setBitmap(finalBitmap);
                                    canvas.drawColor(Color.TRANSPARENT, Mode.CLEAR);
                                    canvas.drawBitmap(shipBitmap, 0, 0, null);
                                    drawDividingLine(canvas);
                                    drawRealText(canvas);
									/*Matrix m=new Matrix();
									m.postRotate(rotations, 400, 300);
									canvas.setBitmap(finalBitmap);
									canvas.drawColor(Color.TRANSPARENT, Mode.CLEAR);
									canvas.drawBitmap(shipBitmap, m, null);*/
                                    //Paint p=new Paint();
                                    p.setColor(Color.RED);
                                    p.setTextSize(20);

					/*				canvas.drawText(String.format("%.6f", cacuDate.seekData[10]), 0, shipBitmap.getHeight()-20, p);
									canvas.drawText(String.format("%.6f", cacuDate.seekData[11]), 80, shipBitmap.getHeight()-20, p);*/
                                    canvas.drawText(String.format("Heading :%.2f", cacuDate.anlogData[67]), 0, shipBitmap.getHeight() - 10, p);
                                    canvas.drawText(String.format("North Coordinate:%.2f", cacuDate.seekData[0]), 200, shipBitmap.getHeight() - 10, p);
                                    canvas.drawText(String.format("East Coordinate:%.2f", cacuDate.seekData[1]), 520, shipBitmap.getHeight() - 10, p);
                                    viewFilipper.postInvalidate();
                                }
                            }
                        }

                    }
                    //计算浓度 流量
                    Density.Concentration = (cacuDate.anlogData[100 + 32] - Density.Waterdensity) / (Density.Soildensity - Density.Waterdensity) * 100;//(数据字典产量-水密度)/(土密度-水密度)*100;
                    Density.flow = cacuDate.anlogData[100 + 32] * Math.PI * Density.Pipediameter * Density.Pipediameter / 4 * 3600;//流速*π*流量计管径*流量计管径/4*3600;

                    //计算小时产量率
                    Density.Hourlyyield = Density.Concentration * Density.flow / 100;
                    //Density.Hourlyyield=3600;
                    //累计产量
                    Density.Cumulativeoutput += Density.Hourlyyield / 3600 * 0.3;

                    cc++;
                    if (cc >= 200) {
                        cc = 0;
                        str[0] = String.valueOf(Density.Waterdensity);
                        str[1] = String.valueOf(Density.Soildensity);
                        str[2] = String.valueOf(Density.Pipediameter);
                        str[3] = String.valueOf(Density.Cumulativeoutput);
                        GateValveActivity.stringTxt(str);//保存
                    }
                }
            }, 300, 300);


        }
    };

    public RectF circumangle(RectF parameter, float centerx, float centery, float angle) {
        RectF rect = new RectF();
        double x1, y1, x2, y2;
        x1 = centerx;
        y1 = centery;
        x2 = parameter.left;
        y2 = parameter.top;
        rect.left = (int) ((x2 - x1) * Math.cos(angle) - (y2 - y1) * Math.sin(angle) + x1);
        rect.top = (int) ((x2 - x1) * Math.sin(angle) + (y2 - y1) * Math.cos(angle) + y1);
        rect.right = rect.left + parameter.right - parameter.left;
        rect.bottom = rect.top + parameter.bottom - parameter.top;
        return rect;
    }

    private String getTextByIndex(int index) {
        String rd = "";
        switch (index) {
            case 0:
                rd = "线方向:";
                break;
            case 1:
                rd = "艏向:";
                break;
            case 2:
                rd = "左横移速度:";
                break;
            case 3:
                rd = "右横移速度:";
                break;
            case 4:
                rd = "流压角:";
                break;
            case 5:
                rd = "刀头偏移:";
                break;
            case 6:
                rd = "横移速度:";
                break;
            case 7:
                rd = "目标距离:";
                break;
            case 8:
                rd = "绞刀深度:";
                break;
            case 9:
                rd = "绞刀角度:";
                break;
            case 10:
                rd = "流速:";
                break;
            case 11:
                rd = "密度:";
                break;
            case 12:
                rd = "潮位:";
                break;
            case 13:
                rd = "北向坐标:";
                break;
            case 14:
                rd = "东向坐标:";
                break;
            case 15:
                rd = "台车行程:";
                break;
            case 16:
                rd = "小时产量率:";
                break;
            case 17:
                rd = "桥架角度:";
                break;
            case 18:
                rd = "桥架平面投影:";
                break;
            case 19:
                rd = "挖泥厚度:";
                break;
            case 20:
                rd = "原始深度:";
                break;
            case 21:
                rd = "耳轴吃水:";
                break;
            case 22:
                rd = "纵倾:";
                break;
            case 23:
                rd = "横倾:";
                break;
            case 24:
                rd = "主桩偏移:";
                break;
            case 25:
                rd = "辅桩偏移:";
                break;
            case 26:
                rd = "绞刀压力:";
                break;
            case 27:
                rd = "绞刀转速:";
                break;
            case 28:
                rd = "水下泵转速:";
                break;
            case 29:
                rd = "1#舱内泵转速:";
                break;
            case 30:
                rd = "绞刀位置X:";
                break;
            case 31:
                rd = "绞刀位置Y:";
                break;
            case 32:
                rd = "主桩位置X:";
                break;
            case 33:
                rd = "主桩位置Y:";
                break;
            case 34:
                rd = "1#GPS-X:";
                break;
            case 35:
                rd = "1#GPS-Y:";
                break;
            case 36:
                rd = "水下泵真空:";
                break;
            case 37:
                rd = "水下泵排压:";
                break;
            case 38:
                rd = "1#舱内泵排压:";
                break;
            case 39:
                rd = "左艉锚出缆长度:";
                break;
            case 40:
                rd = "中艉锚出缆长度:";
                break;
            case 41:
                rd = "右艉锚出缆长度:";
                break;
            case 42:
                rd = "左横移角度:";
                break;
            case 43:
                rd = "右横移角度:";
                break;
            case 44:
                rd = "左艉锚出缆角度:";
                break;
            case 45:
                rd = "中艉锚出缆角度:";
                break;
            case 46:
                rd = "右艉锚出缆角度:";
                break;
            case 47:
                rd = "主桩前进:";
                break;
            case 48:
                rd = "当前进尺:";
                break;
            case 49:
                rd = "当前班组:";
                break;
            case 50:
                rd = "当前产量:";
                break;
            case 51:
                rd = "前班产量:";
                break;
            case 52:
                rd = "绞刀相对前进:";
                break;
            case 53:
                rd = "GPSN:";
                break;
            case 54:
                rd = "GPSE:";
                break;
            case 55:
                rd = "GPS2N:";
                break;
            case 56:
                rd = "GPS2E:";
                break;
            case 57:
                rd = "对地航速";
                break;
            case 58:
                rd = "2#舱内泵排压:";
                break;
            case 59:
                rd = "2#舱内泵转速:";
                break;
            default:
                rd = "无效:";
                break;
        }
        return rd;
    }

    /////////////////右边文本框
    private void drawRealText(Canvas canvas) {
        int txtSet = rightFontSize + 5;
        int txtSetX = 200;
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setTextSize(rightFontSize);
        canvas.drawText("COG :", screenWidth + 10, txtSet, paint);//对地航向
        canvas.drawText(String.format("%.2f", strRealTimeSignal.COG), screenWidth + txtSetX, txtSet, paint);

        paint.setColor(Color.GREEN);
        txtSet += rightFontSize + 40;
        canvas.drawText("SOG ：", screenWidth + 10, txtSet, paint);//对地航速
        canvas.drawText(String.format("%.2f", strRealTimeSignal.SOG), screenWidth + txtSetX, txtSet, paint);

        paint.setColor(Color.WHITE);
        txtSet += rightFontSize + 40;
        canvas.drawText("HDG：", screenWidth + 10, txtSet, paint);//船首向
        canvas.drawText(String.format("%.1f", strRealTimeSignal.heading), screenWidth + txtSetX, txtSet, paint);

//		paint.setColor(Color.CYAN);
//		txtSet+=rightFontSize+40;
//		canvas.drawText("Angle ：", screenWidth+10, txtSet, paint);//首向角度
//		canvas.drawText(String.format("%.1f", strRealTimeSignal.ShipAngle), screenWidth+txtSetX, txtSet, paint);

        paint.setColor(Color.MAGENTA);
        txtSet += rightFontSize + 40;
        canvas.drawText("GPS_X ：", screenWidth + 10, txtSet, paint);//GPS_X
        canvas.drawText(String.format("%.2f", strRealTimeSignal.GPS_X), screenWidth + txtSetX, txtSet, paint);

        paint.setColor(Color.MAGENTA);
        txtSet += rightFontSize + 40;
        canvas.drawText("GPS_Y：", screenWidth + 10, txtSet, paint);//GPS_Y
        canvas.drawText(String.format("%.2f", strRealTimeSignal.GPS_Y), screenWidth + txtSetX, txtSet, paint);

        paint.setColor(Color.MAGENTA);
        txtSet += rightFontSize + 40;
        canvas.drawText("GPS_Z :", screenWidth + 10, txtSet, paint);//GPS_Z
        canvas.drawText(String.format("%.2f", strRealTimeSignal.GPS_Z), screenWidth + txtSetX, txtSet, paint);

        paint.setColor(Color.RED);
        txtSet += rightFontSize + 40;
        canvas.drawText("GPS_N :", screenWidth + 10, txtSet, paint);//GPS北向坐标
        canvas.drawText(String.format("%.3f", strRealTimeSignal.GPS_N), screenWidth + txtSetX, txtSet, paint);

        paint.setColor(Color.RED);
        txtSet += rightFontSize + 40;
        canvas.drawText("GPS_E :", screenWidth + 10, txtSet, paint);//GPS东向坐标
        canvas.drawText(String.format("%.3f", strRealTimeSignal.GPS_E), screenWidth + txtSetX, txtSet, paint);

        paint.setColor(Color.YELLOW);
        txtSet += rightFontSize + 40;
        canvas.drawText("draft :", screenWidth + 10, txtSet, paint);//吃水深度
        canvas.drawText(String.format("%.3f", strRealTimeSignal.TrunnionGaugeDeep), screenWidth + txtSetX, txtSet, paint);

        paint.setColor(Color.WHITE);
        txtSet += rightFontSize + 40;
        canvas.drawText("Bridge :", screenWidth + 10, txtSet, paint);//桥架下放深度
        canvas.drawText(String.format("%.3f", strRealTimeSignal.TrunnionGaugeDeep1), screenWidth + txtSetX, txtSet, paint);

        paint.setColor(Color.GRAY);
        txtSet += rightFontSize + 40;
        canvas.drawText("Vacuum :", screenWidth + 10, txtSet, paint);//真空
        canvas.drawText(String.format("%.3f", strRealTimeSignal.SuctionPress), screenWidth + txtSetX, txtSet, paint);

        paint.setColor(Color.GRAY);
        txtSet += rightFontSize + 40;
        canvas.drawText("Pressure :", screenWidth + 10, txtSet, paint);//排压
        canvas.drawText(String.format("%.3f", strRealTimeSignal.SuctionPress1), screenWidth + txtSetX, txtSet, paint);

        paint.setColor(Color.GREEN);
        txtSet += rightFontSize + 40;
        canvas.drawText("Velocity:", screenWidth + 10, txtSet, paint);//流速
        canvas.drawText(String.format("%.3f", strRealTimeSignal.Velocity), screenWidth + txtSetX, txtSet, paint);

//		paint.setColor(Color.GREEN);
//		txtSet+=rightFontSize+40;
//		canvas.drawText("Density :", screenWidth+10, txtSet, paint);//密度
//		canvas.drawText(String.format("%.3f", strRealTimeSignal.TrunnionGaugeDeep), screenWidth+txtSetX, txtSet, paint);

        paint.setColor(Color.MAGENTA);
        txtSet += rightFontSize + 40;
        canvas.drawText("Sealing :", screenWidth + 10, txtSet, paint);//封水压力
        canvas.drawText(String.format("%.3f", strRealTimeSignal.SuctionPress2), screenWidth + txtSetX, txtSet, paint);

        paint.setColor(Color.WHITE);
        txtSet += rightFontSize + 40;
        canvas.drawText("Yield :", screenWidth + 10, txtSet, paint);//小时产量率
        canvas.drawText(String.format("%.1f", Density.Hourlyyield), screenWidth + txtSetX, txtSet, paint);

        paint.setColor(Color.WHITE);
        txtSet += rightFontSize + 40;
        canvas.drawText("Total :", screenWidth + 10, txtSet, paint);//累计产量
        canvas.drawText(String.format("%.0f", Density.Cumulativeoutput), screenWidth + txtSetX, txtSet, paint);

//		paint.setColor(Color.RED);
//		txtSet+=rightFontSize+5;
//		canvas.drawText(getTextByIndex(11), screenWidth+10, txtSet, paint);
//		canvas.drawText(String.format("%.2f", cacuDate.anlogData[1]), screenWidth+txtSetX, txtSet, paint);
//		paint.setColor(Color.WHITE);
//		txtSet+=rightFontSize+5;
//		canvas.drawText(getTextByIndex(10), screenWidth+10, txtSet, paint);
//		canvas.drawText(String.format("%.2f", strRealTimeSignal.Velocity), screenWidth+txtSetX, txtSet, paint);

        paint = null;
    }

    ////////画分割线
    private void drawDividingLine(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(0, screenHeight - 1);
        path.lineTo(maxScreenWidth, screenHeight - 1);
        path.lineTo(maxScreenWidth, 0);
        path.close();
        canvas.drawPath(path, paint);
        canvas.drawLine(screenWidth, 0, screenWidth, screenHeight - 1, paint);

        paint = null;
        path = null;
        //canvas.drawLine(0, 600, 1000, 600, paint);
    }

    //////画真北方向
    private void drawNorth(Canvas canvas, float angle) {
        int centerx = 100;
        int centery = screenHeight - 100;


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        float x = 0;
        float y = 0;
        /////真北方向数据初始化
        northX[0] = centerx;
        northY[0] = centery - 40;
        northX[1] = centerx - 15;
        northY[1] = centery - 20;
        northX[2] = centerx - 5;
        northY[2] = centery - 23;
        northX[3] = centerx - 5;
        northY[3] = centery - 10;
        northX[4] = centerx + 5;
        northY[4] = centery - 10;
        northX[5] = centerx + 5;
        northY[5] = centery - 23;
        northX[6] = centerx + 15;
        northY[6] = centery - 20;

        northLX[0] = centerx - 5;
        northLY[0] = centery + 10;
        northLX[1] = centerx - 5;
        northLY[1] = centery + 20;
        northLX[2] = centerx + 5;
        northLY[2] = centery + 20;
        northLX[3] = centerx + 5;
        northLY[3] = centery + 10;

        for (int i = 0; i < 7; i++) {
            x = northX[i];
            y = northY[i];
            northX[i] = (int) ((x - centerx) * (float) Math.cos(angle) - (y - centery) * (float) Math.sin(angle) + centerx);
            northY[i] = (int) ((x - centerx) * (float) Math.sin(angle) + (y - centery) * (float) Math.cos(angle) + centery);
        }
        for (int i = 0; i < 4; i++) {
            x = northLX[i];
            y = northLY[i];
            northLX[i] = (int) ((x - centerx) * (float) Math.cos(angle) - (y - centery) * (float) Math.sin(angle) + centerx);
            northLY[i] = (int) ((x - centerx) * (float) Math.sin(angle) + (y - centery) * (float) Math.cos(angle) + centery);
        }
        Path path = new Path();
        path.moveTo(northX[0], northY[0]);
        for (int i = 1; i < 7; i++) {
            path.lineTo(northX[i], northY[i]);
        }
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
        path.moveTo(northLX[0], northLY[0]);
        for (int i = 1; i < 4; i++) {
            path.lineTo(northLX[i], northLY[i]);
        }
        path.close();
        canvas.drawPath(path, paint);
        paint.setTextSize(15);
        canvas.drawText("N", centerx - 5, centery + 5, paint);

        paint = null;
        path = null;
    }

    ////////画轨迹线
    private void drawTrochoid(Canvas canvas, Rect rect, float centerx, float centery, float angle) {
        float pox, poy;
        float width = rect.width();
        float height = rect.height();
        pox = rect.left + 0.5f * width;
        poy = rect.top + 0.5f * height;
        float sX = width / (10 * scaleX);
        float sY = height / (10 * scaleY);


        Str_Trochoid_Real strTrochoidReal = myBinder.getTrochoidReal();

        float x = 0;
        float y = 0;

        for (int i = 0; i < strTrochoidReal.trochoidLenReal; i++) {
            trochoidPx[i] = pox + ((float) strTrochoidReal.strTrochoidReals[i].P6[1] - centery) * sX;
            trochoidPy[i] = poy - ((float) strTrochoidReal.strTrochoidReals[i].P6[0] - centerx) * sY;
            x = trochoidPx[i];
            y = trochoidPy[i];
            trochoidPx[i] = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
            trochoidPy[i] = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        }
        Paint paint = new Paint();
        paint.setStrokeWidth(1);
        for (int i = strTrochoidReal.trochoidRealIndex + 1; i < strTrochoidReal.trochoidLenReal - 1; i++) {
            if (Math.sqrt((strTrochoidReal.strTrochoidReals[i].P6[1] - strTrochoidReal.strTrochoidReals[i + 1].P6[1]) *
                    (strTrochoidReal.strTrochoidReals[i].P6[1] - strTrochoidReal.strTrochoidReals[i + 1].P6[1]) +
                    (strTrochoidReal.strTrochoidReals[i].P6[0] - strTrochoidReal.strTrochoidReals[i + 1].P6[0]) *
                            (strTrochoidReal.strTrochoidReals[i].P6[0] - strTrochoidReal.strTrochoidReals[i + 1].P6[0])) <= 40) {
                paint.setColor(getCurrentColor(strTrochoidReal.strTrochoidReals[i + 1].P6[2]));
                canvas.drawLine(trochoidPx[i], trochoidPy[i], trochoidPx[i + 1], trochoidPy[i = 1], paint);
            }
        }
        paint = null;
    }

    //////获取当前深度的颜色
    public int getCurrentColor(double sd) {
        int rr, gg, bb;
        int r1, r2, g1, g2, b1, b2;
        Str_Colors strColor = myBinder.getColorSet();
        if (sd <= strColor.deeps[0])
            return strColor.colors[0];
        if (sd >= strColor.deeps[19])
            return strColor.colors[19];
        int i;
        for (i = 0; i < 19; i++) {
            if (sd >= strColor.deeps[i] && sd < strColor.deeps[i + 1]) {
                if (strColor.colorModel) {
                    b1 = (strColor.colors[i]) & 0xff;
                    g1 = (strColor.colors[i] >> 8) & 0xff;
                    r1 = (strColor.colors[i] >> 16) & 0xff;
                    b2 = (strColor.colors[i + 1]) & 0xff;
                    g2 = (strColor.colors[i + 1] >> 8) & 0xff;
                    r2 = (strColor.colors[i + 1] >> 16) & 0xff;
                    if (strColor.deeps[i + 1] - strColor.deeps[i] == 0)
                        return strColor.colors[i];
                    rr = (int) ((sd - strColor.deeps[i]) / (strColor.deeps[i + 1] - strColor.deeps[i]) * (r2 - r1) + r1);
                    gg = (int) ((sd - strColor.deeps[i]) / (strColor.deeps[i + 1] - strColor.deeps[i]) * (g2 - g1) + g1);
                    bb = (int) ((sd - strColor.deeps[i]) / (strColor.deeps[i + 1] - strColor.deeps[i]) * (b2 - b1) + b1);
                    return Color.rgb(rr, gg, bb);

                } else
                    return strColor.colors[i];

            }
        }
        return Color.WHITE;
    }

    ////////新画船,下面的方法画船在问题
    private void drawShipPoint(Canvas canvas, Rect rect, float centerx, float centery, int backMode, float angle) {
        int width = rect.right - rect.left;
        int height = rect.bottom - rect.top;
        float sX = width / (10 * scaleX);
        float sY = height / (10 * scaleY);

        float x = 0;
        float y = 0;

        float pox = rect.left + 0.5f * width;
        float poy = rect.top + 0.5f * height;
        float y0 = poy - ((float) strShipPoint.P1[0] - centerx) * sY;
        float x0 = pox + ((float) strShipPoint.P1[1] - centery) * sX;
        float ra = 1 / 2.0f * sX;
        x = x0;
        y = y0;
        x0 = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
        y0 = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
//		RectF tmpRect=new RectF();
//		tmpRect.left=x0-ra;
//		tmpRect.right=x0+ra;
//		tmpRect.top=y0-ra;
//		tmpRect.bottom=y0+ra;
        //tmpRect=circumangle(tmpRect, centerx, centery, angle);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x0, y0, ra, paint);

        float[] px = new float[12];
        float[] py = new float[12];


        float x9 = 0, x10 = 0, y9 = 0, y10 = 0;
        for (int i = 0; i < DrawShip.shipArrSize(); i++) {
            px[i] = pox + (strShipPoint.ShipPlane[i].y - centery) * sX;
            py[i] = poy - (strShipPoint.ShipPlane[i].x - centerx) * sY;
            if (i == 9) {
                x9 = px[i];
                y9 = py[i];
            } else if (i == 10) {
                x10 = px[i];
                y10 = py[i];
            }
            x = px[i];
            y = py[i];
            px[i] = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
            py[i] = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        }


        Path path = new Path();
        path.moveTo(px[0], py[0]);
        for (int i = 1; i < DrawShip.shipArrSize(); i++) {
            path.lineTo(px[i], py[i]);
        }
        path.close();
        paint.setColor(Color.rgb(0, 255, 0));
        canvas.drawPath(path, paint);

        y0 = poy - (strShipPoint.MainStackPivot[0] - centerx) * sY;
        x0 = pox + (strShipPoint.MainStackPivot[1] - centery) * sX;
        float y1 = poy - (strShipPoint.MainStack[0] - centerx) * sY;
        float x1 = pox + (strShipPoint.MainStack[1] - centery) * sX;
        ra = 0.8f * sX;

        x = x0;
        y = y0;
        x0 = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
        y0 = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        x = x1;
        y = y1;
        x1 = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
        y1 = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        paint.setColor(Color.rgb(255, 0, 0));
        paint.setStrokeWidth(ra);
        canvas.drawLine(x0, y0, x1, y1, paint);

        y0 = poy - ((float) strShipPoint.P1[0] - centerx) * sY;
        x0 = pox + ((float) strShipPoint.P1[1] - centery) * sX;
        y1 = poy - ((float) strShipPoint.P3[0] - centerx) * sY;
        x1 = pox + ((float) strShipPoint.P3[1] - centery) * sX;
        x = x0;
        y = y0;
        x0 = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
        y0 = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        x = x1;
        y = y1;
        x1 = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
        y1 = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        ra = strArmSize.PipeRadum * sX;
        paint.setStrokeWidth(ra);
        canvas.drawLine(x0, y0, x1, y1, paint);

        ///////桥架外侧两根线
        paint.setColor(Color.rgb(255, 255, 255));
        x0 = x9 * 3 / 4 + x10 / 4;
        y0 = y9 * 3 / 4 + y10 / 4;
        y1 = poy - ((float) strShipPoint.P2[0] - centerx) * sY;
        x1 = pox + ((float) strShipPoint.P2[1] - centery) * sX;
        x = x0;
        y = y0;
        x0 = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
        y0 = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        x = x1;
        y = y1;
        x1 = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
        y1 = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        paint.setStrokeWidth(1);
        canvas.drawLine(x0, y0, x1, y1, paint);

        x0 = x9 * 1 / 4 + x10 * 3 / 4;
        y0 = y9 * 1 / 4 + y10 * 3 / 4;
        /////上面计算过一次,不用再计算
//		y1=poy-((float)strShipPoint.P2[0]-centerx)*sY;
//		x1=pox+((float)strShipPoint.P2[1]-centery)*sX;
        x = x0;
        y = y0;
        x0 = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
        y0 = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        canvas.drawLine(x0, y0, x1, y1, paint);


        /////绞刀头
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        //float ra1=strArmSize.CutterLength*sX;
        float ra2 = strArmSize.CutterRadum * sX;
        /////上面计算过一次,不用再计算
//			y1=poy-((float)strShipPoint.P2[0]-centerx)*sY;
//			x1=pox+((float)strShipPoint.P2[1]-centery)*sX;
		/*RectF rect0=new RectF();
		rect0.left=x1-ra2;
		rect0.right=x1+ra2;
		rect0.top=y1-ra1;
		rect0.bottom=y1+ra1;*/
        //////原程序这里做了很多运算,先省略
		/*float sweepAngle=(float)-strRealTimeSignal.ShipAngle+180;
		if(sweepAngle>360){
			sweepAngle=sweepAngle-360;
		}*/
        //////直接画个圆,减少计算
        //canvas.drawArc(rect0, (float)-strRealTimeSignal.ShipAngle,(float)-strRealTimeSignal.ShipAngle-180, true, paint);
        canvas.drawCircle(x1, y1, ra2, paint);

		/*y0=poy-((float)strShipPoint.P3[0]-centerx)*sY;
		x0=pox+((float)strShipPoint.P3[1]-centery)*sX;
		ra=1/2.0f*sX;
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.FILL);
		RectF temrect4=new RectF(x0-2*ra,y0-2*ra,x0+2*ra,y0+2*ra);
		canvas.drawArc(temrect4, 0, 360, false, paint);*/

        /////gps2
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.rgb(192, 0, 0));
        y0 = poy - ((float) strShipPoint.GPS2Point[0] - centerx) * sY;
        x0 = pox + ((float) strShipPoint.GPS2Point[1] - centery) * sX;
        x = x0;
        y = y0;
        x0 = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
        y0 = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        RectF temrect1 = new RectF(x0 - ra, y0 - ra, x0 + ra, y0 + ra);
        canvas.drawArc(temrect1, 0, 360, false, paint);

        //VirtualGPSPoint
        paint.setColor(Color.rgb(0, 255, 0));
        y0 = poy - ((float) strShipPoint.VirtualGPSPoint[0] - centerx) * sY;
        x0 = pox + ((float) strShipPoint.VirtualGPSPoint[1] - centery) * sX;
        x = x0;
        y = y0;
        x0 = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
        y0 = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        RectF temrect0 = new RectF(x0 - 2 * ra, y0 - 2 * ra, x0 + 2 * ra, y0 + 2 * ra);
        canvas.drawArc(temrect0, 0, 360, false, paint);

        //GPSPoint
        paint.setColor(Color.RED);
        y0 = poy - ((float) strShipPoint.GPSPoint[0] - centerx) * sY;
        x0 = pox + ((float) strShipPoint.GPSPoint[1] - centery) * sX;
        x = x0;
        y = y0;
        x0 = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
        y0 = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        temrect1.set(x0 - ra, y0 - ra, x0 + ra, y0 + ra);
        canvas.drawArc(temrect1, 0, 360, false, paint);


        ////主桩
        if (strRealTimeSignal.MainStackDown)
            paint.setColor(Color.RED);
        else
            paint.setColor(Color.WHITE);
        y0 = poy - ((float) strShipPoint.MainStack[0] - centerx) * sY;
        x0 = pox + ((float) strShipPoint.MainStack[1] - centery) * sX;
        x = x0;
        y = y0;
        x0 = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
        y0 = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        ra = sX;
        RectF temrect2 = new RectF(x0 - ra, y0 - ra, x0 + ra, y0 + ra);
//		canvas.drawArc(temrect2, 0, 360, false, paint);//白圈

        /////辅桩
        if (strRealTimeSignal.AssitantStackDown)
            paint.setColor(Color.RED);
        else
            paint.setColor(Color.WHITE);
        y0 = poy - ((float) strShipPoint.AssitantStack[0] - centerx) * sY;
        x0 = pox + ((float) strShipPoint.AssitantStack[1] - centery) * sX;
        x = x0;
        y = y0;
        x0 = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
        y0 = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        temrect2.set(x0 - ra, y0 - ra, x0 + ra, y0 + ra);
        canvas.drawArc(temrect2, 0, 360, false, paint);

        /////主桩支点
        paint.setColor(Color.RED);
        y0 = poy - ((float) strShipPoint.MainStackPivot[0] - centerx) * sY;
        x0 = pox + ((float) strShipPoint.MainStackPivot[1] - centery) * sX;
        x = x0;
        y = y0;
        x0 = (x - pox) * (float) Math.cos(angle) - (y - poy) * (float) Math.sin(angle) + pox;
        y0 = (x - pox) * (float) Math.sin(angle) + (y - poy) * (float) Math.cos(angle) + poy;
        temrect2.set(x0 - ra, y0 - ra, x0 + ra, y0 + ra);
        canvas.drawArc(temrect2, 0, 360, false, paint);

        px = null;
        py = null;
        paint = null;
        path = null;
    }


    @Override
    protected void onDestroy() {
        // TODO 自动生成的方法存根

        if (testTimer != null) {
            testTimer.cancel();
            testTimer = null;
        }
        if (newMessageTime != null) {
            newMessageTime.cancel();
            newMessageTime = null;
        }
        synchronized (connection) {
            if (connection != null) {
                unbindService(connection);
                connection = null;
            }
        }
        synchronized (finalBitmap) {
            if (finalBitmap != null) {
                finalBitmap.recycle();
                finalBitmap = null;
            }
        }
        synchronized (shipBitmap) {
            if (shipBitmap != null) {
                shipBitmap.recycle();
                shipBitmap = null;
            }
        }
        super.onDestroy();
    }


    ///////读取back.log文件
    private void readBack() {
        new Thread(new Runnable() {

            @Override
            public void run() {

                String path = sdPath + "/project/";

                File f = new File(path + "Back.Log");
                InputStream in = null;
                int len = (int) f.length();
                byte[] s = new byte[len];
                try {
                    in = new FileInputStream(f);
                    in.read(s);
                } catch (Exception e) {
                    // TODO: handle exception
                    progress.incrementProgressBy(45);
                    if (progress.getProgress() >= 100) {
                        progress.cancel();
                        isStopDraw = true;
                    }
                    return;
                } finally {
                    try {
                        if (in != null)
                            in.close();
                    } catch (IOException e) {
                        // TODO 自动生成的 catch 块
                        e.printStackTrace();
                    }
                }
                myBinder.clearDxfR12();
                try {
                    String backString = new String(s, "GB2312");
                    String[] arrayBackString = backString.split(",");
                    int num = Integer.parseInt(arrayBackString[0]);
                    for (int i = 1; i < num * 2; i += 2) {
                        if (arrayBackString[i].substring(arrayBackString[i].length() - 3).equals("DXF")||arrayBackString[i].substring(arrayBackString[i].length() - 3).equals("dxf")) {
                            String fileName = path + arrayBackString[i].replace("\r\n", "");
                            File ff = new File(fileName);
                            if (ff.exists()) {
                                myBinder.readDxf(fileName);
                            }
                        } else {
                            //////dig文件,暂时不处理
                        }

                    }
                    r12s = myBinder.getDxfR12s();
                    int dnum = r12s.size();
                    int maxLen = 0;
                    for (int i = 0; i < dnum; i++) {
                        List<Dxfr12_polyline> tmpPoly = r12s.get(i).strPolyline;
                        int pnum = tmpPoly.size();
                        for (int ii = 0; ii < pnum; ii++) {
                            if (tmpPoly.get(ii).point_x.size() > maxLen) {
                                maxLen = tmpPoly.get(ii).point_x.size();
                            }
                        }
                    }
                    if (maxLen < 4) {
                        maxLen = 4;
                    }
                    DrawDxfR12.px = new double[maxLen];
                    DrawDxfR12.py = new double[maxLen];

                    progress.incrementProgressBy(45);
                    if (progress.getProgress() >= 100) {
                        progress.cancel();
                        isStopDraw = true;
                    }
                } catch (UnsupportedEncodingException e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }
            }

        }).start();

    }

    ///////读取deep.log文件
    private void readDeep() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO 自动生成的方法存根

                String path = sdPath + "/project/";

                File f = new File(path + "Deep.LOG");
                InputStream in = null;
                int len = (int) f.length();
                byte[] s = new byte[len];
                try {
                    in = new FileInputStream(f);
                    in.read(s);
                } catch (Exception e) {
                    // TODO: handle exception
                    progress.incrementProgressBy(45);
                    if (progress.getProgress() >= 100) {
                        progress.cancel();
                        isStopDraw = true;
                    }
                    return;
                } finally {
                    try {
                        if (in != null)
                            in.close();
                    } catch (IOException e) {
                        // TODO 自动生成的 catch 块
                        e.printStackTrace();
                    }
                }
                myBinder.clearXYZ();
                try {
                    String deepString = new String(s, "GB2312");
                    String[] arrayDeepString = deepString.split(",");
                    int num = Integer.parseInt(arrayDeepString[0]);
                    for (int i = 3; i < num * 5; i += 5) {
                        if (arrayDeepString[i].substring(arrayDeepString[i].length() - 3).equals("XYZ") ||
                                arrayDeepString[i].substring(arrayDeepString[i].length() - 3).equals("xyz")) {
                            String fileName = path + arrayDeepString[i].replace("\r\n", "");
                            File ff = new File(fileName);
                            if (ff.exists()) {
                                myBinder.readXYZFile(fileName);
                            }
                        } else {
                            //////MTX文件,暂时不处理
                        }

                    }
                    xyzs = myBinder.getXYZ();
                    int xnum = xyzs.size();
                    int maxLen = 0;
                    for (int i = 0; i < xnum; i++) {
                        if (xyzs.get(i).x.size() > maxLen) {
                            maxLen = xyzs.get(i).x.size();
                        }
                    }
                    if (maxLen > 0) {
                        DrawXYZ.px = new double[maxLen];
                        DrawXYZ.py = new double[maxLen];
                    }
                    progress.incrementProgressBy(45);
                    if (progress.getProgress() >= 100) {
                        progress.cancel();
                        isStopDraw = true;
                    }
                } catch (UnsupportedEncodingException e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }

            }
        }).start();

    }

    public void readGpsParam() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO 自动生成的方法存根
                String path = sdPath + "/project/GPSParam.Dat";
                myBinder.readGpsParamFromOutFile(path);
                progress.incrementProgressBy(10);
                if (progress.getProgress() >= 100) {
                    progress.cancel();
                    isStopDraw = true;
                }
            }
        }).start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_window);
        /////绑定服务
        Intent bindIntent = new Intent(SeekWindowActivity.this, NewMyService.class);
        bindService(bindIntent, connection, BIND_AUTO_CREATE);
        startService(bindIntent);


		/*Intent intent=new Intent(BeginActivity.this,HipriService.class);
		startService(intent);*/

        viewFilipper = (ViewFlipper) findViewById(R.id.viewFlipper1);
        gestrueDetector = new GestureDetector(this, this);


        btnOrigial = (ImageButton) findViewById(R.id.ibOriginal);
        btnNorth = (ImageButton) findViewById(R.id.ibNorth);
        btnAutoCenter = (ImageButton) findViewById(R.id.ibAutoCenter);


        btnImport = (ImageButton) findViewById(R.id.ibImport);
        btnIFC = (ImageButton) findViewById(R.id.ibIFC);
        btnClear = (ImageButton) findViewById(R.id.ibClear);

        //历史回放 沈阳
        btnHistoryOpen = (ImageButton) findViewById(R.id.historyopen);
        btnHistorystart = (ImageButton) findViewById(R.id.historystart);
        btnHistorypause = (ImageButton) findViewById(R.id.historypause);
        btnHistorystop = (ImageButton) findViewById(R.id.historystop);
        btnHistorylast = (ImageButton) findViewById(R.id.historylast);
        btnHistorynext = (ImageButton) findViewById(R.id.historynext);
        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);

        btnImport.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO 自动生成的方法存根
				/*isNewData=false;
				btnImport.setImageResource(R.drawable.ic_internet);
				myBinder.setIsNewData(isNewData);
				showWindow(v);*/
                new AlertDialog.Builder(SeekWindowActivity.this)
//				.setTitle("导入施工数据")
                        .setMessage("Input construction data?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO 自动生成的方法存根
                                if (Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
                                    sdPath = Environment.getExternalStorageDirectory().getPath();
                                    //String path=sdPath+"/project/";
                                    //String backPath=path+"Back.Log";
                                    /////进度条
                                    dialog.cancel();
                                    progress = new ProgressDialog(SeekWindowActivity.this);
                                    progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                                    progress.setTitle("Please wait");
                                    progress.setMessage("Inputting construction data");
                                    progress.setIndeterminate(false);
                                    progress.setProgress(0);
                                    progress.setMax(100);
                                    progress.setCancelable(true);
                                    progress.show();

                                    isStopDraw = false;
                                    readBack();
                                    readDeep();
                                    readGpsParam();
                                } else {
                                    Toast.makeText(SeekWindowActivity.this, "SD card is not inserted", Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();

            }
        });
        //2019/4/17
        btnClear.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                new AlertDialog.Builder(SeekWindowActivity.this)
//				.setTitle("导入施工数据")
                        .setMessage("Clear Total?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // TODO 自动生成的方法存根
                                Density.Cumulativeoutput = 0;
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            }
        });

        //2018/2/2 吴

        btnIFC.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SeekWindowActivity.this)
//				.setTitle("下载施工数据")
                        .setMessage("Download construction data?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                progress2 = new ProgressDialog(SeekWindowActivity.this);
                                progress2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                                progress2.setTitle("Please wait");
                                progress2.setMessage("Downloading construction data");
                                progress2.setIndeterminate(false);
                                progress2.setProgress(0);
                                progress2.setMax(100);
                                progress2.setCancelable(true);
                                progress2.show();
                                new Thread() {
                                    @Override
                                    public void run() {
                                        if (createConnection()) {
                                            try {
                                                sendMessage();
                                            } catch (IOException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                            }
                                            isStopDraw = false;
                                            try {
                                                getNewFile();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            //getMessage();
                                        }
                                    }
                                }.start();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();

            }
        });

        btnOrigial.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO 自动生成的方法存根
                scaleX = screenWidth / 10;
                scaleY = screenHeight / 10;
                myBinder.setScale(scaleX, scaleY, rotations);
            }
        });

        btnNorth.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO 自动生成的方法存根
                rotations = 0;
                myBinder.setScale(scaleX, scaleY, rotations);
            }
        });
        btnAutoCenter.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO 自动生成的方法存根
                if (isGpsCenter) {
                    isGpsCenter = false;
                    btnAutoCenter.setBackgroundColor(Color.DKGRAY);
                    //btnAutoCenter.setTextColor(Color.WHITE);
                } else {
                    isGpsCenter = true;
                    btnAutoCenter.setBackgroundColor(Color.GREEN);
                    //btnAutoCenter.setTextColor(Color.BLUE);
                }

                myBinder.setAutoCenter(isGpsCenter);
            }
        });

        //历史回放沈阳
        btnHistoryOpen.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SeekWindowActivity.this, OpenHistoryFlie.class);
                startActivity(intent);
            }
        });
        btnHistorystart.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO 自动生成的方法存根
            }
        });
        btnHistorypause.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO 自动生成的方法存根
            }
        });
        btnHistorystop.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO 自动生成的方法存根
            }
        });
        btnHistorylast.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO 自动生成的方法存根
            }
        });
        btnHistorynext.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO 自动生成的方法存根
            }
        });
        seekBar1.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

        });

        newMessageTime = new Timer();
        newMessageTime.schedule(new TimerTask() {

            @Override
            public void run() {
                // TODO 自动生成的方法存根
                if (isNewData) {
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO 自动生成的方法存根
							/*Message message = new Message();
							message.what = 2;*/
                            mHandler.sendMessage(Message.obtain(mHandler, 2));
                            //message.recycle();
                        }
                    }).start();
                }
            }
        }, 1000, 500);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(Menu.NONE, Menu.FIRST + 1, 1, "网络设置");
        menu.add(Menu.NONE, Menu.FIRST + 2, 2, "解码库设置");
		/*
		menu.add(Menu.NONE,Menu.FIRST+3,3,"测试xyz");
		menu.add(Menu.NONE,Menu.FIRST+4,4,"测试序列化后的xyz");*/
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO 自动生成的方法存根
        //////注册菜单事件
        switch (item.getItemId()) {
            case Menu.FIRST + 1:
                Intent intent1 = new Intent();
//			intent1.setClass(SeekWindowActivity.this, SetNetConfig.class);

                startActivity(intent1);
                break;
            case Menu.FIRST + 2:
                Intent intent2 = new Intent();
                intent2.setClass(SeekWindowActivity.this, SetDecodeActivity.class);
                startActivity(intent2);
                break;
        }
			/*
		case Menu.FIRST+3:
			if(Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)){
				String sdPath=Environment.getExternalStorageDirectory().getPath();
				String gpsPath=sdPath+"/gpsParam.txt";
				myBinder.readGpsParamFromOutFile(gpsPath);

				String dxfPath=sdPath+"/三期浚前CLEAR.DXF";
				myBinder.readDxf(dxfPath);
				String colorPath=sdPath+"/ColorSet.CFG";
				myBinder.readColorSet(colorPath);
				colors=myBinder.getColorSet();

				String xyzpath=sdPath+"/1#贮泥坑20040828.XYZ";
				myBinder.readXYZFile(xyzpath);

			}
			else{
				Toast.makeText(SeekWindowActivity.this, "未插入sd卡", Toast.LENGTH_SHORT).show();
			}


			break;
		case Menu.FIRST+4:
			myBinder.readSerDxf();
			r12s=myBinder.getDxfR12s();
			myBinder.readSerColorSet();
			colors=myBinder.getColorSet();

			myBinder.readSerXYZFile();
			xyzs=myBinder.getXYZ();

			break;
		default:
			break;
		}*/
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onDown(MotionEvent arg0) {
        // TODO 自动生成的方法存根
        return false;
    }

    public boolean onTouch(MotionEvent event) {
        // TODO 自动生成的方法存根
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                float mX = event.getX();
                float mY = event.getY();
                if (Math.abs(mX - maxScreenWidth) < 80 && (mY < 700)) {
                    mode = 4;////////调节亮度
                    oldBrightnessPoint.x = mX;
                    oldBrightnessPoint.y = mY;
                    drawAdjust("亮度", BrightnessTools.nowBrightnessValue);

                } else {
                    if ((mX < screenWidth) && (mY < screenHeight))    //沈阳改
                    {
                        mode = 1;////移动模式
                        float angle = rotations * (float) Math.PI / 180;

                        float x, y;

                        x = mX;
                        y = mY;
                        mX = (int) ((x - (strRect.right - strRect.left) / 2) * (float) Math.cos(angle) + (y - (strRect.bottom - strRect.top) / 2) * (float) Math.sin(angle) + (strRect.right - strRect.left) / 2);
                        mY = (int) (-(x - (strRect.right - strRect.left) / 2) * (float) Math.sin(angle) + (y - (strRect.bottom - strRect.top) / 2) * (float) Math.cos(angle) + (strRect.bottom - strRect.top) / 2);

                        oldPoint.x = mX;
                        oldPoint.y = mY;
                    }

                }
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                int pointerCount = event.getPointerCount();
                if (pointerCount == 2) {

                    oldDist = spacing(event);
                    //oldRotation=rotation(event);
                    if (oldDist > 10f) {

                        mode = 2;

                    }
                } else {
                    mode = 3;
                    oldRotation = rotation(event);
                }
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                if (mode == 4) {
                    BrightnessTools.saveBrightness(BrightnessTools.nowBrightnessValue);
                }
                mode = 0;
                break;

            case MotionEvent.ACTION_MOVE:
                if (mode == 1) {
                    isGpsCenter = false;
                    myBinder.setAutoCenter(isGpsCenter);
                    btnAutoCenter.setBackgroundColor(Color.DKGRAY);
                    float mX2 = event.getX();
                    float mY2 = event.getY();
                    float angle2 = rotations * (float) Math.PI / 180;
                    float x2, y2;

                    x2 = mX2;
                    y2 = mY2;
                    mX2 = (int) ((x2 - (strRect.right - strRect.left) / 2) * (float) Math.cos(angle2) + (y2 - (strRect.bottom - strRect.top) / 2) * (float) Math.sin(angle2) + (strRect.right - strRect.left) / 2);
                    mY2 = (int) (-(x2 - (strRect.right - strRect.left) / 2) * (float) Math.sin(angle2) + (y2 - (strRect.bottom - strRect.top) / 2) * (float) Math.cos(angle2) + (strRect.bottom - strRect.top) / 2);

                    centerX += (mY2 - oldPoint.y) * 10 * scaleX / screenWidth;
                    centerY -= (mX2 - oldPoint.x) * 10 * scaleY / screenHeight;
                    oldPoint.x = mX2;
                    oldPoint.y = mY2;
                    myBinder.setCenter(centerX, centerY);
                } else if (mode == 2) {
                    float newDist = spacing(event);

                    if (newDist > 10f) {

                        float s = 1 + newDist / oldDist / 60;
                        if (newDist > oldDist) {
                            scaleX /= s;
                            scaleY /= s;
                        } else {
                            scaleX *= s;
                            scaleY *= s;
                        }

                        if (scaleX > screenWidth) {
                            scaleX = screenWidth;
                        }
                        if (scaleY > screenHeight) {
                            scaleY = screenHeight;
                        }
                        if (scaleX < screenWidth / 100) {
                            scaleX = screenWidth / 100;
                        }
                        if (scaleY < screenHeight / 100) {
                            scaleY = screenHeight / 100;
                        }
                        oldDist = newDist;
                        myBinder.setScale(scaleX, scaleY, rotations);
                    }
                } else if (mode == 3) {
                    float ro = rotation(event);
                    rotations += ro - oldRotation;

                    if (rotations >= 360) {
                        rotations -= 360;
                    }
                    if (rotations < 0) {
                        rotations += 360;
                    }
                    oldRotation = ro;
                    myBinder.setScale(scaleX, scaleY, rotations);
                } else if (mode == 4) {
                    float mY2 = event.getY();
                    BrightnessTools.nowBrightnessValue += (oldBrightnessPoint.y - mY2);
                    if (BrightnessTools.nowBrightnessValue > 250) {
                        BrightnessTools.nowBrightnessValue = 250;
                    }
                    if (BrightnessTools.nowBrightnessValue < 1) {
                        BrightnessTools.nowBrightnessValue = 1;
                    }
                    BrightnessTools.setBrightness(this, BrightnessTools.nowBrightnessValue);

                    drawAdjust("亮度", BrightnessTools.nowBrightnessValue);
                    oldBrightnessPoint.y = mY2;
                }

                break;
        }

        return false;
    }

    /////计算旋转角度
    private float rotation(MotionEvent event) {
        double delta_x = (event.getX(0) - event.getX(1));
        double delta_y = (event.getY(0) - event.getY(1));
        double radians = Math.atan2(delta_y, delta_x);
        return (float) Math.toDegrees(radians);
    }

    private float rotation(float x1, float y1, float x2, float y2) {
        double delta_x = (x1 - x2);
        double delta_y = (y1 - y2);
        double radians = Math.atan2(delta_y, delta_x);
        return (float) Math.toDegrees(radians);
    }

    ///////计算两点间线长
    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return FloatMath.sqrt(x * x + y * y);
    }

    private float spacing(float x1, float y1, float x2, float y2) {
        float x = x1 - x2;
        float y = y1 - y2;
        return FloatMath.sqrt(x * x + y * y);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO 自动生成的方法存根
        if (gestrueDetector.onTouchEvent(ev)) {
            ev.setAction(MotionEvent.ACTION_CANCEL);
        } else {
            onTouch(ev);
        }
        return super.dispatchTouchEvent(ev);

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float arg2,
                           float arg3) {
        // TODO 自动生成的方法存根
        if (Math.abs(e1.getX() - e2.getX()) > Math.abs(e1.getY() - e2.getY())) {
//			if(e1.getX()-e2.getX()>120){
//				this.viewFilipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
//				this.viewFilipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));
//				this.viewFilipper.showNext();
//				bId++;
//				if(bId>=bitmapNum){
//					bId=0;
//				}
//				return true;
//			}
//			else if(e1.getX()-e2.getX()<-120){
//				this.viewFilipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
//				this.viewFilipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
//				this.viewFilipper.showPrevious();
//				//bId=viewFilipper.getId();
//				bId--;
//				if(bId<0){
//					bId=bitmapNum-1;
//				}
//				return true;
//			}
        } else {
            if (e1.getX() - screenWidth > 0 && e1.getY() - e2.getY() > 100) {
                Intent intent = new Intent();
                intent.setClass(SeekWindowActivity.this, GateValveActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_top_in, R.anim.push_top_out);
                finish();
                return true;
            } else if (e1.getX() - screenWidth > 0 && e2.getY() - e1.getY() > 100) {
                Intent intent = new Intent();
                intent.setClass(SeekWindowActivity.this, GateValveActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out);
                finish();
                return true;
            }
            if (Math.abs(e1.getY() - maxScreenHeight) < 40 && e1.getY() - e2.getY() > 100) {
                PopupMenu popmenu = new PopupMenu(this, this.btnImport);
                MenuInflater inflater = popmenu.getMenuInflater();
                inflater.inflate(R.menu.seek_window, popmenu.getMenu());
                popmenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // TODO 自动生成的方法存根
//						switch (item.getItemId()) {
//						case R.id.mSetNet:
//							Intent intent1=new Intent();
//							intent1.setClass(SeekWindowActivity.this, SetNetConfig.class);
//
//							startActivity(intent1);
//							break;
//						case R.id.mSetDecode:
//							Intent intent2=new Intent();
//							intent2.setClass(SeekWindowActivity.this,SetDecodeActivity.class);
//							startActivity(intent2);
//							break;
//						default:
//							break;
//						}
                        return true;
                    }
                });
                popmenu.show();
                return true;
            }
//			if(e1.getY()-e2.getY()>180 && arg3<-120){
//				Intent intent=new Intent();
//				intent.setClass(SeekWindowActivity.this, GateValveActivity.class);
//				startActivity(intent);
//				overridePendingTransition(R.anim.push_top_in, R.anim.push_top_out);
//				finish();
//				return true;
//			}
//			else if(e1.getY()-e2.getY()<-180 && arg3>120){
//				Intent intent=new Intent();
//				intent.setClass(SeekWindowActivity.this, GateValveActivity.class);
//				startActivity(intent);
//				overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out);
//				finish();
//				return true;
//			}
        }
        return false;
    }


    @Override
    public void onLongPress(MotionEvent arg0) {
        // TODO 自动生成的方法存根
        mode = 1;/////移动模式
        float angle = rotations * (float) Math.PI / 180;
        float mX = arg0.getX();
        float mY = arg0.getY();
        float x, y;

        x = mX;
        y = mY;
        mX = (int) ((x - (strRect.right - strRect.left) / 2) * (float) Math.cos(angle) + (y - (strRect.bottom - strRect.top) / 2) * (float) Math.sin(angle) + (strRect.right - strRect.left) / 2);
        mY = (int) (-(x - (strRect.right - strRect.left) / 2) * (float) Math.sin(angle) + (y - (strRect.bottom - strRect.top) / 2) * (float) Math.cos(angle) + (strRect.bottom - strRect.top) / 2);

        oldPoint.x = mX;
        oldPoint.y = mY;
		/*new AlertDialog.Builder(this)
		.setTitle("锁定")
		.setSingleChoiceItems(new String[]{"锁定旋转","锁定缩放","全部取消"}, lock, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO 自动生成的方法存根
				lock=which;
				myBinder.setLockParam(lock);
				dialog.dismiss();
			}
		})
		.setNegativeButton("取消", null)
		.show();*/
    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
                            float arg3) {
        // TODO 自动生成的方法存根
        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0) {
        // TODO 自动生成的方法存根

    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {
        // TODO 自动生成的方法存根
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO 自动生成的方法存根
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(this)
                    .setTitle("退出")
                    .setMessage("是否确定退出?")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO 自动生成的方法存根
                            if (testTimer != null) {
                                testTimer.cancel();
                                testTimer = null;
                            }

                            if (connection != null) {
                                unbindService(connection);
                                connection = null;


                            }
					/*Intent intent1=new Intent(SeekWindowActivity.this,HipriService.class);
					stopService(intent1);*/
                            Intent intent = new Intent(SeekWindowActivity.this, NewMyService.class);
                            stopService(intent);

                            finish();
                        }
                    })
                    .setNegativeButton("取消", null)
                    .show();
        }
        return super.onKeyDown(keyCode, event);
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {//此方法在ui线程运行
            if (msg.what == 1) {
                //btnSingleRoute.setBackgroundColor(Color.DKGRAY);
            } else if (msg.what == 2) {
                if (isShowNew) {
                    btnImport.setImageResource(R.drawable.ic_internetnew);

                } else {
                    btnImport.setImageResource(R.drawable.ic_internet);

                }
                isShowNew = !isShowNew;
            }

        }

    };

    @Override
    protected void onStart() {
        // TODO 自动生成的方法存根

        super.onStart();
    }

    ////////弹出窗口的方法
    private void showWindow(View parent) {


        if (popDownloadProgress == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            popView = layoutInflater.inflate(R.layout.download_popwindow, null, false);

            LinearLayout lay = (LinearLayout) popView.findViewById(R.id.listdown);
            Button btndownloadImport = new Button(this);
            btndownloadImport.setText("导入数据");
            lay.addView(btndownloadImport);
            //mainLayout.addView(btnBack);

            popDownloadProgress = new PopupWindow(popView, 300, 300);
        }

        popDownloadProgress.setFocusable(true);
        popDownloadProgress.setBackgroundDrawable(new BitmapDrawable());
        //WindowManager windowManager=(WindowManager)getSystemService(Context.WINDOW_SERVICE);
        //int xPos=windowManager.getDefaultDisplay().getWidth()/2-popDownloadProgress.getWidth()/2;
        popDownloadProgress.showAsDropDown(parent, -200, 100);


    }

    private void getNewFile() throws IOException {
        int passedlen = 0;
        File mFile = new File(FILE_PATH + "temp.zip");
        DataInputStream inputStream = null;
        inputStream = cs.getMessageStream();
        byte[] buffer = new byte[2048];
        if (mFile.exists()) {
            mFile.delete();
        }
        try {
            mFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(FILE_PATH + "temp.zip"));
        while (true) {
            int read = 0;
            if (inputStream != null) {
                read = inputStream.read(buffer, 0, buffer.length);
            }
            if (
                    buffer[read - 8] == 13 &&
                            buffer[read - 7] == 10 &&
                            buffer[read - 6] == -85 &&
                            buffer[read - 5] == -68 &&
                            buffer[read - 4] == -51 &&
                            buffer[read - 3] == -34 &&
                            buffer[read - 2] == -17 &&
                            buffer[read - 1] == -6
            ) {
                buffer[read - 8] = 0;
                buffer[read - 7] = 0;
                buffer[read - 6] = 0;
                buffer[read - 5] = 0;
                buffer[read - 4] = 0;
                buffer[read - 3] = 0;
                buffer[read - 2] = 0;
                buffer[read - 1] = 0;
                fileOut.write(buffer, 0, read - 8);
                break;
            }
            //
            passedlen += read;
            if (read <= 0) {
                break;
            }
            fileOut.write(buffer, 0, read);
        }

        upzipFile(new File(FILE_PATH + "/" + "temp.zip"), FILE_PATH);//解压
        deleteFile(FILE_PATH + "/" + "temp.zip");//删除
        progress2.cancel();//进度条
        fileOut.flush();
        fileOut.close();
    }

    //2018/2/5 吴
    private void getMessage() {
        if (cs == null) {
            return;
        }
        DataInputStream inputStream = null;
        inputStream = cs.getMessageStream();
        try {
            String savePath = FILE_PATH;
            //int bufferSize = 8192;
            int bufferSize = 2048;
            byte[] buf = new byte[bufferSize];
            int passedlen = 0;
            long len = 0;  //接收的长度
            savePath += inputStream.readByte();
            DataOutputStream fileOut = new DataOutputStream(new BufferedOutputStream(new BufferedOutputStream(new FileOutputStream(savePath))));
            len = inputStream.readLong();
            Log.d("AndoridClient", "文件的长度为:" + len);
            Log.d("AndroidClient", "开始接收文件");
            while (true) {
                int read = 0;
                if (inputStream != null) {
                    read = inputStream.read(buf);
                }
                passedlen += read;
                if (read == -1) {
                    break;
                }
                progress2.incrementProgressBy((int) (passedlen * 100 / len));
                if (progress2.getProgress() >= 100) {
                    progress2.cancel();//进度条
                }
                Log.d("AndroidClient", "文件接收了" + (passedlen * 100 / len) + "%/n");
                fileOut.write(buf, 0, read);
            }
            Log.d("AndroidClient", "文件接收完成" + savePath);  //文件传输接收下载完成
            fileOut.close();
            upzipFile(new File(FILE_PATH + "/" + "temp.zip"), FILE_PATH);//解压
            deleteFile(FILE_PATH + "/" + "temp.zip");//删除

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void sendMessage() throws IOException {
        if (cs == null) {
            return;
        }
        cs.sendMessage(sendMessage);
    }

    boolean createConnection() {
        cs = new ClientSocket(ip, port);
        cs.createConnection();
        System.out.println("连接服务器成功");
        System.out.println(ip);
        System.out.println(port);
        return true;
    }

    public static List<File> upzipFile(String zipPath, String descDir) {
        System.out.println("upzipFile运行");
        return upzipFile(new File(zipPath), descDir);
    }

    /**
     * 对.zip文件进行解压缩
     *
     * @param zipFile 解压缩文件
     * @param descDir 压缩的目标地址，如：D:\\测试 或 /mnt/d/测试
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static List<File> upzipFile(File zipFile, String descDir) {
        System.out.println("upzipFileFILE运行");
        List<File> _list = new ArrayList<File>();
        try {
            ZipFile _zipFile = new ZipFile(zipFile, "GBK");
            for (Enumeration entries = _zipFile.getEntries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                File _file = new File(descDir + File.separator + entry.getName());
                if (entry.isDirectory()) {
                    _file.mkdirs();
                } else {
                    File _parent = _file.getParentFile();
                    if (!_parent.exists()) {
                        _parent.mkdirs();
                    }
                    InputStream _in = _zipFile.getInputStream(entry);
                    OutputStream _out = new FileOutputStream(_file);
                    int len = 0;
                    while ((len = _in.read(_byte)) > 0) {
                        _out.write(_byte, 0, len);
                    }
                    _in.close();
                    _out.flush();
                    _out.close();
                    _list.add(_file);
                }
            }
        } catch (IOException e) {
        }
        System.out.println("upzipFile运行完毕");
//        System.out.println(_list.get(0));
        return _list;
    }

    /**
     * 对临时生成的文件夹和文件夹下的文件进行删除
     */
    public static void deletefile(String delpath) {

        System.out.println("DELETE运行");
        try {
            File file = new File(delpath);
            if (!file.isDirectory()) {
                file.delete();
            } else if (file.isDirectory()) {
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File delfile = new File(delpath + File.separator + filelist[i]);
                    if (!delfile.isDirectory()) {
                        delfile.delete();
                    } else if (delfile.isDirectory()) {
                        deletefile(delpath + File.separator + filelist[i]);
                    }
                }
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean deleteFile(String fileName) {//删除文件
        File file = new File(fileName);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除" + fileName + "成功!");
                return true;
            } else {
                System.out.println("删除" + fileName + "失败!");
                return false;
            }
        } else {
            System.out.println("删除失败：" + fileName + "不存在!");
            return false;
        }
    }

    ///////////////////////////
    //////////画亮度调节条
    private void drawAdjust(String title, int value) {
        Canvas canvas = new Canvas();
        canvas.drawColor(Color.TRANSPARENT);
        canvas.setBitmap(finalBitmap);
        int cX = maxScreenWidth - 40;
        int cY = maxScreenHeight / 2;
        //canvas.setBitmap(finalBitmap);
        Paint p = new Paint();
        p.setStrokeWidth(1);
        p.setColor(Color.WHITE);
        p.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(cX - 5, cY - 50);
        path.lineTo(cX - 5, cY + 50);
        path.lineTo(cX + 5, cY + 50);
        path.lineTo(cX + 5, cY - 50);
        path.close();
        canvas.drawPath(path, p);
        p.setStyle(Paint.Style.FILL);
        canvas.drawText(title, cX - 10, cY - 60, p);
        value = value * 100 / 250;
        path.reset();
        path.moveTo(cX - 5, cY + 50 - value);
        path.lineTo(cX - 5, cY + 50);
        path.lineTo(cX + 5, cY + 50);
        path.lineTo(cX + 5, cY + 50 - value);
        path.close();
        canvas.drawPath(path, p);

        canvas = null;
    }

}
