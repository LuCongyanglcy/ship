package jiaoxi.crazyit.image;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import jiaoxi.crazyit.sql.*;

public class AlarmDatabase extends Activity{
	private TextView tv1 ;
	private TextView tv2;
	private Button btn1;//查看全部
	private Button btn2;//查看正常
	private Button btn3;//查看报警
	private Button btndate;//日期确定按钮
	private int alarmtime;
	private SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy年MM月dd日   HH:mm:ss");     
	private Date curDate =  new Date(System.currentTimeMillis()); 
	
	//用于日期选择器
	private int mYear, mMonth, mDay;//
    private TextView date1;
    private TextView date2;
    final int DATE_DIALOG = 0;
    int temp = 0;
    
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);
		btn1=(Button)findViewById(R.id.alarmbutton1);
		btn2=(Button)findViewById(R.id.alarmbutton2);
		btn3=(Button)findViewById(R.id.alarmbutton3);
		btndate=(Button)findViewById(R.id.datebutton);
		date1=(TextView)findViewById(R.id.date1);
		date2=(TextView)findViewById(R.id.date2);
		
		
		final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);
		
		date1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	temp=1;
                showDialog(DATE_DIALOG);
            }
        });
		date2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	temp=2;
                showDialog(DATE_DIALOG);
            }
        });
		btn1.setOnClickListener(new OnClickListener()//查看全部
		{
			@Override
			public void onClick(View v) {
				ContentValues value=new ContentValues();
				DBHelper helper=new DBHelper(getApplicationContext());
				Intent intent=new Intent(AlarmDatabase.this,AlarmQuery.class);
				intent.putExtra("key", "查看全部");
				startActivity(intent);
			}
		});
		btn2.setOnClickListener(new OnClickListener()//查看正常
		{
			@Override
			public void onClick(View v) {
				ContentValues value=new ContentValues();
				DBHelper helper=new DBHelper(getApplicationContext());
				Intent intent=new Intent(AlarmDatabase.this,AlarmQuery.class);
				intent.putExtra("key", "查看正常");
				startActivity(intent);
			}
		});
		btn3.setOnClickListener(new OnClickListener()//查看报警
		{
			@Override
			public void onClick(View v) {
				ContentValues value=new ContentValues();
				DBHelper helper=new DBHelper(getApplicationContext());
				Intent intent=new Intent(AlarmDatabase.this,AlarmQuery.class);
				intent.putExtra("key", "查看报警");
				startActivity(intent);
			}
		});
		btndate.setOnClickListener(new OnClickListener()//按日期查询
				{
					@Override
					public void onClick(View v) {
						Intent intent=new Intent(AlarmDatabase.this,AlarmQuery.class);
						intent.putExtra("key", "查看日期");
						intent.putExtra("start",date1.getText()+"");
						intent.putExtra("end",date2.getText()+"");
						startActivity(intent);
					}
				});
		}
	protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }
	public void setdate() {
        switch(temp) {
        case 1:
        	date1.setText(new StringBuffer().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
        	break;
        case 2:
        	date2.setText(new StringBuffer().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
        	break;
        }
    }
	private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            setdate();
        }
    };
}