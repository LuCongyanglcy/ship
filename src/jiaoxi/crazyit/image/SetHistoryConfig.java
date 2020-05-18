package jiaoxi.crazyit.image;

import jiaoxi.crazyit.classes.history.HistoryParam;
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

public class SetHistoryConfig extends Activity{

	Button mBtnOk;////确定按钮
	CheckBox mCbRecordData;//////记录数据
	CheckBox mCbReview;//////历史回放
	CheckBox mCbUpData;//////上传数据
	
	private Handler handler;
	HistoryParam historyparam = null;

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
			historyparam = myBinder.getHistoryConfig();
			handler.sendMessage(Message.obtain(handler, 1));
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sethistory);

		// /////绑定服务
		Intent bindIntent = new Intent(SetHistoryConfig.this, NewMyService.class);
		bindService(bindIntent, connection, BIND_AUTO_CREATE);
		
		mBtnOk=(Button)findViewById(R.id.btnhistoryOk);
		mCbRecordData = (CheckBox) findViewById(R.id.recorddata);
		mCbReview = (CheckBox) findViewById(R.id.review);
		mCbUpData = (CheckBox) findViewById(R.id.uploaddata);

		mBtnOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根

				// /////////获取网络配置
				if (mCbRecordData.isChecked()) {
					historyparam.bRecordData = true;
				} else {
					historyparam.bRecordData = false;
				}
				if (mCbReview.isChecked()) {
					historyparam.bReview = true;
				} else {
					historyparam.bReview = false;
				}
				if (mCbUpData.isChecked()) {
					historyparam.bUpData = true;
				} else {
					historyparam.bUpData = false;
				}
				myBinder.setHistoryConfig(historyparam);
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
					if(historyparam.bRecordData){
						mCbRecordData.setChecked(true);
					}
					else{
						mCbRecordData.setChecked(false);
					}
					if(historyparam.bReview){
						mCbReview.setChecked(true);
					}
					else{
						mCbReview.setChecked(false);
					}
					if(historyparam.bUpData){
						mCbUpData.setChecked(true);
					}
					else{
						mCbUpData.setChecked(false);
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
