package jiaoxi.crazyit.sql;

import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
	//数据库名称
	public static final String DB_NAME="alarm24.db";//5
	//表名
	public static final String DB_TABLE="alarm";
	//声明SQLite对象
	private SQLiteDatabase db;
	private static final String DATABASE_CREATE="create table alarm("
			+ "_id integer primary key autoincrement,"
			+ "state text,"
			+ "name text,"
			+ "Spare2 text, "
			+ "Spare3 text, "
			+ "Spare4 integer, "
			+ "timeint integer,"
			+ "time text not null )";
	
	public DBHelper(Context mcontext) {
		super(mcontext, DB_NAME, null, 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		this.db=db;
		db.execSQL(DATABASE_CREATE);
	}
	//插入
	public void insert(ContentValues values)
	{
		SQLiteDatabase db=getWritableDatabase();
		db.insert(DB_TABLE, null, values);
		db.close();
	}
	//查询全部
	public Cursor query()
	{
		SQLiteDatabase db=getWritableDatabase();
		Cursor c=db.query(DB_TABLE, null, null, null, null, null, null);
		return c;
		
	}
	//按日期查询
	public Cursor query(long startdate,long enddate)
	{
		SQLiteDatabase db=getWritableDatabase();
		Cursor c=db.query(DB_TABLE,null,"timeint>? and timeint<?",new String[]{""+startdate+"",""+(enddate+86400)+""},null,null,null);
		return c;
		
	}
	public Cursor query(String a)
	{
		SQLiteDatabase db=getWritableDatabase();
		Cursor c=db.query(DB_TABLE,null,"state=?",new String[]{""+a+""},null,null,null);
		return c;
		
	}
	//删除
	public void delete(int id)
	{
		if(db==null)
			db=getWritableDatabase();
		db.delete(DB_TABLE, "_id=?",new String[] {String.valueOf(id)});
	}
	//删除一年前数据
	public void autodelete(long nowtime)
	{
		if(db==null)
			db=getWritableDatabase();
		db.delete(DB_TABLE, "timeint<?",new String[] {String.valueOf((nowtime-31536000))});
		System.out.println("已删除数据");
	}
	//关闭数据库
	public void close()
	{
		if(db!=null)
			db.close();
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	// strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
//    public static Date stringToDate(String strTime, String formatType)
//            throws ParseException {
//        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
//        Date date = null;
//        date = formatter.parse(strTime);
//        return date;
//    }
}