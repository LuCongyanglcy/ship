package jiaoxi.crazyit.image;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Random;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import jiaoxi.crazyit.sql.DBHelper;
import jiaoxi.crazyit.sql.SpecialAdapter;

public class AlarmQuery extends ListActivity {
	public boolean isRed=false;
	public Cursor c;
	public Cursor temp;
	public DBHelper helper;
	public static int color;
	
	

    public static String key;
    public static String start="1970-01-01";
    public static String end="2100-12-31";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		helper=new DBHelper(this);
		//查询数据，获取游标
        Intent intent = getIntent();
        if (intent != null) {
            key = intent.getStringExtra("key");
            start = intent.getStringExtra("start");
            end = intent.getStringExtra("end");
            switch(key) {
            case "查看全部":
            	c=helper.query();
            	break;
            case "查看正常":
            	c=helper.query("正常");
            	break;
            case "查看报警":
            	c=helper.query("报警");
            	break;
            case "查看日期":
            	c=helper.query(strtolong(start),strtolong(end));
            	break;
            }
        }
		//列表项目数组
		String[] from={"_id","time","name","state"};
		//列表项ID
		int[] to={R.id.text0,R.id.text1,R.id.text2,R.id.text6};
		//适配器
//		SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.activity_alarmquery,c,from,to);
		SimpleCursorAdapter adapter=new SpecialAdapter(this,R.layout.activity_alarmquery,c,from,to);//自定义变色的SimpleCursorAdapter函数
		////////////
		//列表视图
		ListView listView=getListView();
		//为列表视图添加视图 
		listView.setAdapter(adapter);
		//设置提示对话框
		final AlertDialog.Builder builder=new AlertDialog.Builder(this);
		
		listView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				final long temp=arg3;
				builder.setMessage("确定要删除吗?")
				.setPositiveButton("是", 
						new DialogInterface.OnClickListener() {	
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						//删除数据库
						helper.delete((int) temp);
						Cursor c=helper.query();
						String[] from={"_id","time","name","state"};
						int[] to={R.id.text0,R.id.text1,R.id.text2,R.id.text6};						
						SimpleCursorAdapter adapter=new SpecialAdapter(getApplicationContext(),
								R.layout.activity_alarmquery,c,from,to);
						ListView listView=getListView();
						listView.setAdapter(adapter);
					}
				}).setNegativeButton("否", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
					}					
				});
				AlertDialog ad=builder.create();
				ad.show();			
			}			
		});
		helper.close();
	} 
	public static int getcolor() {
		return color;
	}
    public long strtolong(String str) {//年月日int格式
    	long l = 0;
    	int temp=1970;
    	int yearday=0;
    	boolean isLeapYear;
    	int [] larray = new int[3];//年月日
    	larray[0]=Integer.parseInt(str.substring(0,4));//年
    	larray[1]=Integer.parseInt(str.substring(5,6));//月
    	larray[2]=Integer.parseInt(str.substring(7,9));//日
//    	larray[2]=Long.parseLong(str.substring(8,9));//日
    	GregorianCalendar gre = new GregorianCalendar();
    	while(temp<larray[0]) {
    		temp++;
        	if(isLeapYear=gre.isLeapYear(temp)) {
        		yearday+=366;
        	}else {
        		yearday+=365;
        	}
    	}
    	yearday+=day(larray[0],larray[1],larray[2]);
    	l=(yearday-1)*86400-28800;//减8小时时差
    	return l;
    }
    public int day(int year,int month,int day) {//第几天
    	GregorianCalendar gre = new GregorianCalendar();  
    	boolean isLeapYear=gre.isLeapYear(year);
    	int m2=isLeapYear?29:28;
    	int i=0;
    	switch(month) {
    	case 1:
    		i=0;
    		break;
    	case 2:
    		i=31;
    		break;
    	case 3:
    		i=31+m2;
    		break;
    	case 4:
    		i=31+m2+31;
    		break;
    	case 5:
    		i=31+m2+31+30;
    		break;
    	case 6:
    		i=31+m2+31+30+31;
    		break;
    	case 7:
    		i=31+m2+31+30+31+30;
    		break;
    	case 8:
    		i=31+m2+31+30+31+30+31;
    		break;
    	case 9:
    		i=31+m2+31+30+31+30+31+31;
    		break;
    	case 10:
    		i=31+m2+31+30+31+30+31+30;
    		break;
    	case 11:
    		i=31+m2+31+30+31+30+31+30+31;
    		break;
    	case 12:
    		i=31+m2+31+30+31+30+31+30+31+30;
    		break;
    	}
    	return i+day;
    }
}
