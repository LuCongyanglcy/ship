package jiaoxi.crazyit.image;

import jiaoxi.crazyit.image.R;
import jiaoxi.crazyit.classes.gps.GpsParam;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SetGpsConfig extends Activity {

	Button mBtnOk;////确定按钮
	Button mBtnCancel;////取消按钮
	EditText mEtRadius;//////椭球半径
	EditText mEtFlattening;//////扁率
	EditText mEttCentralline;//////中央子午线
	EditText mEtgpsTx;//////GPS参数-TX
	EditText mEtgpsTy;//////GPS参数-TY
	EditText mEtgpsTz;//////GPS参数-TZ
	EditText mEtgpsRx;//////GPS参数-RX
	EditText mEtgpsRy;//////GPS参数-RY
	EditText mEtgpsRz;//////GPS参数-RZ
	EditText mEtgpsX;//////X修正
	EditText mEtgpsY;//////Y修正
	EditText mEtgpsZ;//////Z修正
	EditText mEtgpsS;//////GPS参数-S
	EditText mEtprojectscale;//////投影比例
	CheckBox mCbmode;/////工程坐标/经纬度

	CheckBox mCblocalrotate;/////使用当地坐标
	EditText mEtrotateX;//////旋转中心X
	EditText mEtrotateY;//////旋转中心Y
	EditText mEtangle;//////旋转角度
	EditText mEtscale;//////缩放比例
	
	private Handler handler;
	GpsParam gpsconfig;
	// ///////获取服务连接
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
			gpsconfig=myBinder.getGpsConfig();
			handler.sendMessage(Message.obtain(handler, 1));
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setgps);

		// /////绑定服务
		Intent bindIntent = new Intent(SetGpsConfig.this, NewMyService.class);
		bindService(bindIntent, connection, BIND_AUTO_CREATE);
		
		mBtnOk=(Button)findViewById(R.id.btngpsOk);
		mBtnCancel=(Button)findViewById(R.id.btngpsCancel);
		
		mEtRadius=(EditText)findViewById(R.id.Radius);
		mEtFlattening=(EditText)findViewById(R.id.Flattening);
		mEttCentralline=(EditText)findViewById(R.id.Centralline);
		mEtgpsTx=(EditText)findViewById(R.id.gpsTx);
		mEtgpsTy=(EditText)findViewById(R.id.gpsTy);
		mEtgpsTz=(EditText)findViewById(R.id.gpsTz);
		mEtgpsRx=(EditText)findViewById(R.id.gpsRx);
		mEtgpsRy=(EditText)findViewById(R.id.gpsRy);
		mEtgpsRz=(EditText)findViewById(R.id.gpsRz);
		mEtgpsX=(EditText)findViewById(R.id.gpsX);
		mEtgpsY=(EditText)findViewById(R.id.gpsY);
		mEtgpsZ=(EditText)findViewById(R.id.gpsZ);
		mEtgpsS=(EditText)findViewById(R.id.gpsS);
		mEtprojectscale=(EditText)findViewById(R.id.projectscale);
		mCbmode=(CheckBox)findViewById(R.id.mode);
		
		mCblocalrotate = (CheckBox) findViewById(R.id.localrotate);
		mEtrotateX = (EditText) findViewById(R.id.rotateX);
		mEtrotateY = (EditText) findViewById(R.id.rotateY);
		mEtangle = (EditText) findViewById(R.id.angle);
		mEtscale = (EditText) findViewById(R.id.scale);

		mBtnOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根

				// /////////获取GPS配置

				gpsconfig.GPS_CS_a = Double.parseDouble(mEtRadius.getText()
						.toString());
				gpsconfig.GPS_CS_f = Double.parseDouble(mEtFlattening.getText()
						.toString());
				gpsconfig.GPS_CS_ZYZWX = Double.parseDouble(mEttCentralline.getText()
						.toString());
				gpsconfig.GPS_CS_Tx = Double.parseDouble(mEtgpsTx.getText()
						.toString());
				gpsconfig.GPS_CS_Ty = Double.parseDouble(mEtgpsTy.getText()
						.toString());
				gpsconfig.GPS_CS_Tz = Double.parseDouble(mEtgpsTz.getText()
						.toString());
				gpsconfig.GPS_CS_Rx = Double.parseDouble(mEtgpsRx.getText()
						.toString());
				gpsconfig.GPS_CS_Ry = Double.parseDouble(mEtgpsRy.getText()
						.toString());				
				gpsconfig.GPS_CS_Rz = Double.parseDouble(mEtgpsRz.getText()
						.toString());
				gpsconfig.GPS_CS_DeltaX = Double.parseDouble(mEtgpsX.getText()
						.toString());
				gpsconfig.GPS_CS_DeltaY = Double.parseDouble(mEtgpsY.getText()
						.toString());				
				gpsconfig.GPS_CS_DeltaZ = Double.parseDouble(mEtgpsZ.getText()
						.toString());
				gpsconfig.GPS_CS_S = Double.parseDouble(mEtgpsS.getText()
						.toString());
				gpsconfig.GPS_UTM_Scale = Double.parseDouble(mEtprojectscale.getText()
						.toString());				
				if (mCbmode.isChecked()) {
					gpsconfig.GPS_CS_Mode = 1;
				} else {
					gpsconfig.GPS_CS_Mode = 0;
				}

				
				
				if (mCblocalrotate.isChecked()) {
					gpsconfig.bLocalChange = true;
				} else {
					gpsconfig.bLocalChange = false;
				}
				gpsconfig.fRotateCenterX = Double.parseDouble(mEtrotateX.getText()
						.toString());
				gpsconfig.fRotateCenterY = Double.parseDouble(mEtrotateY.getText()
						.toString());
				gpsconfig.fRotateAngle = Double.parseDouble(mEtangle.getText()
						.toString());
				gpsconfig.fRotateScale = Double.parseDouble(mEtscale.getText()
						.toString());
				myBinder.setGpsConfig(gpsconfig);//保存设置
				finish();
			}
		});

		mBtnCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
		     handler=new Handler(){

			/* （非 Javadoc）
			 * @see android.os.Handler#handleMessage(android.os.Message)
			 */
			@Override
			public void handleMessage(Message msg) {
				// TODO 自动生成的方法存根
				if(msg.what==1){
					
					mEtRadius.setText(String.valueOf(gpsconfig.GPS_CS_a));
					mEtFlattening.setText(String.valueOf(gpsconfig.GPS_CS_f));
					mEttCentralline.setText(String.valueOf(gpsconfig.GPS_CS_ZYZWX));
					mEtgpsTx.setText(String.valueOf(gpsconfig.GPS_CS_Tx));
					mEtgpsTy.setText(String.valueOf(gpsconfig.GPS_CS_Ty));
					mEtgpsTz.setText(String.valueOf(gpsconfig.GPS_CS_Tz));
					mEtgpsRx.setText(String.valueOf(gpsconfig.GPS_CS_Rx));
					mEtgpsRy.setText(String.valueOf(gpsconfig.GPS_CS_Ry));
					mEtgpsRz.setText(String.valueOf(gpsconfig.GPS_CS_Rz));
					mEtgpsX.setText(String.valueOf(gpsconfig.GPS_CS_DeltaX));
					mEtgpsY.setText(String.valueOf(gpsconfig.GPS_CS_DeltaY));
					mEtgpsZ.setText(String.valueOf(gpsconfig.GPS_CS_DeltaZ));
					mEtgpsS.setText(String.valueOf(gpsconfig.GPS_CS_S));
					mEtprojectscale.setText(String.valueOf(gpsconfig.GPS_UTM_Scale));
					if(gpsconfig.GPS_CS_Mode==0){
						mCbmode.setChecked(false);
					}
					else{
						mCbmode.setChecked(true);
					}
					
					
					if(gpsconfig.bLocalChange){
						mCblocalrotate.setChecked(true);
					}
					else{
						mCblocalrotate.setChecked(false);
					}
					mEtrotateX.setText(String.valueOf(gpsconfig.fRotateCenterX));
					mEtrotateY.setText(String.valueOf(gpsconfig.fRotateCenterY));
					mEtangle.setText(String.valueOf(gpsconfig.fRotateAngle));
					mEtscale.setText(String.valueOf(gpsconfig.fRotateScale));
				}
				super.handleMessage(msg);
			}
			
		};
	}
	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
		
		////////界面关闭时，解除绑定
		if(connection!=null){
			unbindService(connection);
			connection=null;
		}
		
		super.onDestroy();
	}
}
