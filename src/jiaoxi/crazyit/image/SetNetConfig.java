package jiaoxi.crazyit.image;

import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import jiaoxi.crazyit.classes.IpPort;



import jiaoxi.crazyit.image.R;
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

public class SetNetConfig extends Activity {

	Button mBtnOk;////确定按钮
	EditText mEtPlcPort;//////plc监听端口
	CheckBox mCbPlcValid;//////plc是否启用
	EditText mEtGpsIp;////gps网关ip
	EditText mEtGpsPort;////gps端口
	CheckBox mCbGpsValid;/////gps是否启用

	EditText mEtRemoteIp;/////远端服务器
	EditText mEtRemotePort;
	CheckBox mCbRemoteValid;
	CheckBox mCbRemoteSendOrRecve;

	IpPort config=null;

	private Handler handler;

	/////////获取服务连接
	private NewMyService.MyBinder myBinder;
	private ServiceConnection connection=new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service)
		{
			// TODO Auto-generated method stub
			myBinder=(NewMyService.MyBinder)service;
			config=myBinder.getNetConfig();
			handler.sendMessage(Message.obtain(handler,1));
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.netconfig);

		///////绑定服务
		Intent bindIntent=new Intent(SetNetConfig.this,NewMyService.class);
		bindService(bindIntent,connection,BIND_AUTO_CREATE);

		mBtnOk=(Button)findViewById(R.id.btnOk);
		mEtPlcPort=(EditText)findViewById(R.id.plcPort);
		mCbPlcValid=(CheckBox)findViewById(R.id.plcValid);

		mEtGpsIp=(EditText)findViewById(R.id.gpsIp);
		mEtGpsPort=(EditText)findViewById(R.id.gpsPort);
		mCbGpsValid=(CheckBox)findViewById(R.id.gpsValid);

		mEtRemoteIp=(EditText)findViewById(R.id.remoteIp);
		mEtRemotePort=(EditText)findViewById(R.id.remotePort);
		mCbRemoteValid=(CheckBox)findViewById(R.id.remoteValid);
		mCbRemoteSendOrRecve=(CheckBox)findViewById(R.id.sendOrRecve);

		mBtnOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根

				///////////获取网络配置

				config.plc2Port=Integer.parseInt(mEtPlcPort.getText().toString());
				if(mCbPlcValid.isChecked()){
					config.plc2IsValid=1;
				}
				else{
					config.plc2IsValid=0;
				}
				config.gpsIp=mEtGpsIp.getText().toString();
				config.gpsPort=Integer.parseInt(mEtGpsPort.getText().toString());
				if(mCbGpsValid.isChecked()){
					config.gpsIsValid=1;
				}
				else{
					config.gpsIsValid=0;
				}
				config.remoteIp=mEtRemoteIp.getText().toString();
				config.remotePort=Integer.parseInt(mEtRemotePort.getText().toString());
				if(mCbRemoteValid.isChecked()){
					config.remoteValid=1;
				}
				else{
					config.remoteValid=0;
				}
				if(mCbRemoteSendOrRecve.isChecked()){
					config.sendOrRecve=1;
				}
				else{
					config.sendOrRecve=0;
				}
				myBinder.setNetConfig(config);

				////不需要再这样打开，直接关闭当前页面，就返回了上一级页面
//				Intent intent=new Intent(SetNetConfig.this,HandDraw1.class);
//				startActivity(intent);
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

					mEtPlcPort.setText(String.valueOf(config.plc1Port));
					if(config.plc1IsValid==0){
						mCbPlcValid.setChecked(false);
					}
					else{
						mCbPlcValid.setChecked(true);
					}
					mEtPlcPort.setText(String.valueOf(config.plc2Port));
					if(config.plc2IsValid==0){
						mCbPlcValid.setChecked(false);
					}
					else{
						mCbPlcValid.setChecked(true);
					}
					mEtGpsIp.setText(config.gpsIp);
					mEtGpsPort.setText(String.valueOf(config.gpsPort));
					if(config.gpsIsValid==0){
						mCbGpsValid.setChecked(false);
					}
					else{
						mCbGpsValid.setChecked(true);
					}
					mEtRemoteIp.setText(config.remoteIp);
					mEtRemotePort.setText(String.valueOf(config.remotePort));
					if(config.remoteValid==0){
						mCbRemoteValid.setChecked(false);
					}
					else{
						mCbRemoteValid.setChecked(true);
					}
					if(config.sendOrRecve==0){
						mCbRemoteSendOrRecve.setChecked(false);
					}
					else{
						mCbRemoteSendOrRecve.setChecked(true);
					}
				}
				super.handleMessage(msg);
			}

		};


		///////从服务获取数据，填入界面

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
