package jiaoxi.crazyit.image;

import java.util.Timer;
import java.util.TimerTask;

import jiaoxi.crazyit.classes.DecodeList;



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
import android.widget.EditText;

public class SetDecodeActivity extends Activity {

	/* （非 Javadoc）
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	Button mBtnOk;
	EditText mEtPlc1DName;//////plc解码库名
	EditText mEtPlc2DName;//////plc解码库名
	EditText mEtGpsDName;//////gps解码库名

	private Handler handler;
	private Timer timer1;

	/////////获取服务连接
	private NewMyService.MyBinder myBinder;
	private ServiceConnection connection=new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			myBinder=(NewMyService.MyBinder)service;

		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setdecode);

		///////绑定服务
		Intent bindIntent=new Intent(SetDecodeActivity.this,NewMyService.class);
		bindService(bindIntent,connection,BIND_AUTO_CREATE);

		mBtnOk=(Button)findViewById(R.id.btnDecodeOk);
		mEtPlc1DName=(EditText)findViewById(R.id.plcName);
		mEtPlc2DName=(EditText)findViewById(R.id.plcName);
		mEtGpsDName=(EditText)findViewById(R.id.gpsName);

		mBtnOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				DecodeList dl=new DecodeList();
				dl.plc1Decode=mEtPlc1DName.getText().toString();
				dl.plc2Decode=mEtPlc2DName.getText().toString();
				dl.gpsDecode=mEtGpsDName.getText().toString();
				myBinder.setDecodeList(dl);

			////不需要再这样打开，直接关闭当前页面，就返回了上一级页面
//				Intent intent=new Intent(SetDecodeActivity.this,HandDraw1.class);
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
				DecodeList dl=myBinder.getDecodeList();
				mEtPlc1DName.setText(dl.plc1Decode);
				mEtPlc2DName.setText(dl.plc2Decode);
				mEtGpsDName.setText(dl.gpsDecode);
				super.handleMessage(msg);
			}

		};

		timer1=new Timer();
		timer1.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				Message msg=new Message();
				handler.sendMessage(msg);

			}
		}, 1000);
	}

	/* （非 Javadoc）
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO 自动生成的方法存根
////////界面关闭时，解除绑定
		if(connection!=null){
			unbindService(connection);
			connection=null;
		}
		if(timer1!=null){
			timer1.cancel();
			timer1=null;
		}
		super.onDestroy();
	}

}
