package jiaoxi.crazyit.sql;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import jiaoxi.crazyit.image.AlarmQuery;

public class SpecialAdapter extends SimpleCursorAdapter{

	AlarmQuery al;
	public DBHelper helper;
	public Cursor c;
	private String str;

	public SpecialAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
		super(context, layout, c, from, to);
		// TODO Auto-generated constructor stub
	}

//	private int color ;

	public View getView(int position, View v, ViewGroup parent) {  
		View view = super.getView(position, v, parent);  
		
		helper=new DBHelper(mContext);
		/////////////////////////////////
		switch(al.key) {
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
        	c=helper.query(strtolong(al.start),strtolong(al.end));
        	break;
        }

		/////////////////////////////////
		c.moveToFirst();
		int a=position;
		c.moveToPosition(position);
		if(c.getString(1).equals("正常")) {
	  		  view.setBackgroundColor(Color.rgb(152,251,152));  
		}else if(c.getString(1).equals("报警")) {
	  		  view.setBackgroundColor(Color.rgb(252,157,154));  
		}
		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		System.out.println(c.getCount());
		System.out.println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
//		if(c!=null&&c.moveToFirst()){
//			do {
//		    	  int a = c.getColumnIndex("state");
//		    	  str = c.getString(1);
//		    	  if(str.equals("正常")) {
//		    		  color=Color.GREEN;
//		    	  }else if(str.equals("报警")){
//		    		  color=Color.RED;
//		    	  }else {
//		    		  color=Color.GRAY;
//		    	  }
//		  		  view.setBackgroundColor(color);  
//		      }while(c.moveToNext());
//		}
//		if(r.nextInt(2)==1) {
//			view.setBackgroundColor(Color.RED);  
//		}else {
//			view.setBackgroundColor(Color.GREEN);  
//			}
        return view;  
    }  
	public long strtolong(String str) {//年
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
    		i=31+m2+31+30+31+30+31+31+30;
    		break;
    	case 11:
    		i=31+m2+31+30+31+30+31+31+30+31;
    		break;
    	case 12:
    		i=31+m2+31+30+31+30+31+31+30+31+30;
    		break;
    	}
    	return i+day;
    }
}
