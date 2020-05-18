package jiaoxi.crazyit.image;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CheckCutter extends Activity{
	EditText mEtcutterdeep1;//////第一点绞刀深度
	EditText mEtcutterdeep2;//////第二点绞刀深度
	float cutterdeep1,cutterdeep2;
	byte[] sendCommand0 = { 0x24, 0x42, 0x00, 0x0A, 0x00, 0x00, 0x00, 0x09,
			0x00, 0x0A, 0x41, 0x21, 0x99-256, 0x9A-256, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x05, 0x02, 0x1D, 0x0D,
			0x0A, 0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256,
			0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256,
			0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256, 0xDD - 256,
			0xDD - 256, 0xDD - 256 };
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
			}
		};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkpipe);

		///////绑定服务
		Intent bindIntent = new Intent(CheckCutter.this, NewMyService.class);
		bindService(bindIntent, connection, BIND_AUTO_CREATE);
		
		mEtcutterdeep1=(EditText)findViewById(R.id.cutterdeep1);
		mEtcutterdeep2=(EditText)findViewById(R.id.cutterdeep2);
	}
	public void button1(View v) {  
		cutterdeep1=Float.parseFloat(mEtcutterdeep1.getText().toString());
		myBinder.sendCommand(GetSendCommand(cutterdeep1,1));
//		myBinder.sendCommand(sendCommand0);
		Toast.makeText(getApplicationContext(), "提示：已经发送数据给PLC！", 
				Toast.LENGTH_SHORT).show();	
      }
	public void button2(View v) {  
		cutterdeep2=Float.parseFloat(mEtcutterdeep2.getText().toString());
		myBinder.sendCommand(GetSendCommand(cutterdeep2,2));
//		myBinder.sendCommand(sendCommand0);
		Toast.makeText(getApplicationContext(), "提示：已经发送数据给PLC！", 
				Toast.LENGTH_SHORT).show();	
      }
	public void exitbutton(View v) {  
    	this.finish();    	
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

	public byte[] GetSendCommand(float num,int index)
	{
		 // 把float转换为byte[]  
	    int fbit = Float.floatToIntBits(num);  
	      
	    byte[] b = new byte[4];    
	    for (int i = 0; i < 4; i++) {    
	        b[i] = (byte) (fbit >> (24 - i * 8));    
	    }   
	      
	    // 翻转数组  
	    int len = b.length;  
	    // 建立一个与源数组元素类型相同的数组  
	    byte[] dest = new byte[len];  
	    // 为了防止修改源数组，将源数组拷贝一份副本  
	    System.arraycopy(b, 0, dest, 0, len);  
	    byte temp;  
	    // 将顺位第i个与倒数第i个交换  
	    for (int i = 0; i < len / 2; ++i) {  
	        temp = dest[i];  
	        dest[i] = dest[len - i - 1];  
	        dest[len - i - 1] = temp;  
	    }  
		int wCheck = 0;
		int a = 0;
		byte[] bb = new byte[40];
		bb[0]=0x24; //标志位
		bb[1]=0x42;
		bb[2]=0x00; //DB号
		bb[3]=0x0A;
		bb[4]=0x00; //起始地址
		bb[5]=0x00;
		bb[6]=0x00; //结束地址
		bb[7]=0x09;
		bb[8]=0x00; //数据长度
		bb[9]=0x0A;
		if(index == 1)
		{
			if(dest[3]<0)
			{  
				a++;
			}
			bb[10]=dest[3]; 
			if(dest[2]<0)
			{			
				a++;
			}
			bb[11]=dest[2]; 
			if(dest[1]<0)
			{
				a++;
			}
			bb[12]=dest[1]; 
			if(dest[0]<0)
			{
				a++;
			}
			bb[13]=dest[0];  //数据开始处
				
			bb[14]=0x00;
			bb[15]=0x00;		
			bb[16]=0x00;
			bb[17]=0x00;
			bb[18]=0x00;
			bb[19]=(byte) index;  //数据结束共10字节
		}
		if(index == 2)
		{
			bb[10]=0x00; //数据开始处
			bb[11]=0x00;		
			bb[12]=0x00;
			bb[13]=0x00;
			if(dest[3]<0)
			{  
				a++;
			}
			if(dest[2]<0)
			{  
				a++;
			}
			if(dest[1]<0)
			{  
				a++;
			}
			if(dest[0]<0)
			{  
				a++;
			}
			bb[14]=dest[3];  
			bb[15]=dest[2];
	        bb[16]=dest[1];
			bb[17]=dest[0];			
			bb[18]=0x00;
			bb[19]=(byte) index;  //数据结束共10字节
		}
		for(int i=0; i<20; i++)
		{
			wCheck += bb[i];
		}		
		bb[20]=(byte) (((wCheck+256*a)>>8)&0xFF);		
		if((byte)((wCheck)&0xFF) > 127)
		{
			bb[21]=(byte) ((wCheck)&0xFF -256);
		}
		else
		{
			bb[21]=(byte) ((wCheck)&0xFF);
		}				
		
		bb[22]=0x0D;   //结束标志位
		bb[23]=0x0A;
		bb[24]=0xFF-256; //填充数据
		bb[25]=0xFF-256;
		bb[26]=0xFF-256;
		bb[27]=0xFF-256;
		bb[28]=0xFF-256;
		bb[29]=0xFF-256;
		bb[30]=0xFF-256;
		bb[31]=0xFF-256;
		bb[32]=0xFF-256;
		bb[33]=0xFF-256;
		bb[34]=0xFF-256;
		bb[35]=0xFF-256;
		bb[36]=0xFF-256;
		bb[37]=0xFF-256;
		bb[38]=0xFF-256;
		bb[39]=0xFF-256;
		return bb;		
	}
}
