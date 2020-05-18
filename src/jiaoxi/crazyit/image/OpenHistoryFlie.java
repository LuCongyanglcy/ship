package jiaoxi.crazyit.image;

import java.io.File;

import jiaoxi.crazyit.classes.history.HistoryDateAdapter;
import jiaoxi.crazyit.classes.history.HistoryListView;
import jiaoxi.crazyit.classes.history.HistoryTimeAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class OpenHistoryFlie extends Activity {

	private HistoryListView datelistView;
	private HistoryListView timeListView;
	private HistoryDateAdapter historydateAdapter;
	private HistoryTimeAdapter historytimeAdapter;
	
	private int datefileNum = 0; //文件夹数量
	private int[] timefileNum = null; //文件夹中文件数量
	// ///SD卡路径
	private String sdPath;
	private String DatePath = "";
	private String[] TimePath = null;
	private File datefile;
	private File[] timefile=null;
	String cities[][] = new String[][] {
			new String[] { "全部美食", "本帮江浙菜", "川菜", "粤菜", "湘菜", "东北菜", "台湾菜",
					"新疆/清真", "素菜", "火锅", "自助餐", "小吃快餐", "日本", "韩国料理", "东南亚菜",
					"西餐", "面包甜点", "其他" },
			new String[] { "全部休闲娱乐", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
					"公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
					"桌面游戏", "更多休闲娱乐" },
			new String[] { "全部购物", "综合商场", "服饰鞋包", "运动户外", "珠宝饰品", "化妆品",
					"数码家电", "亲子购物", "家居建材", "书店", "书店", "眼镜店", "特色集市",
					"更多购物场所", "食品茶酒", "超市/便利店", "药店" },
			new String[] { "全部休闲娱乐", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
					"公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
					"桌面游戏", "更多休闲娱乐" },
			new String[] { "全", "咖啡厅", "酒吧", "茶馆", "KTV", "游乐游艺", "公园",
					"景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆", "桌面游戏",
					"更多休闲娱乐" },
			new String[] { "全部", "咖啡厅", "酒吧", "茶馆", "电影院", "游乐游艺", "公园",
					"景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆", "桌面游戏",
					"更多休闲娱乐" },
			new String[] { "全部休", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
					"公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
					"桌面游戏", "更多休闲娱乐" },
			new String[] { "全部休闲", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
					"公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
					"桌面游戏", "更多休闲娱乐" },
			new String[] { "全部休闲娱", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
					"公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
					"桌面游戏" },
			new String[] { "全部休闲娱乐", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
					"公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
					"桌面游戏", "更多休闲娱乐" },
			new String[] { "全部休闲aaa", "咖啡厅", "酒吧", "茶馆", "KTV", "电影院", "游乐游艺",
					"公园", "景点/郊游", "洗浴", "足浴按摩", "文化艺术", "DIY手工坊", "桌球馆",
					"桌面游戏" }, 
			};
//	String cities[][] = null;
	String foods[] = null;
	int images[] = null;
//	int images[] = new int[] { R.drawable.ic_historydate,
//			R.drawable.ic_historydate, R.drawable.ic_historydate,
//			R.drawable.ic_historydate, R.drawable.ic_historydate,
//			R.drawable.ic_historydate, R.drawable.ic_historydate,
//			R.drawable.ic_historydate, R.drawable.ic_historydate,
//			R.drawable.ic_historydate, R.drawable.ic_historydate , R.drawable.ic_historydate};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history_list_file);		
		// 获取文件列表
		sdPath = Environment.getExternalStorageDirectory().getPath();
		DatePath = sdPath + "/mingrun/History_Database";
		datefile = new File(DatePath);
		getFileList(datefile);		
//		cities = new String[datefileNum][30];
//		getHistoryFileList(timefile);
		
		init();
		historydateAdapter = new HistoryDateAdapter(getApplicationContext(),
				foods, images);
		datelistView.setAdapter(historydateAdapter);

		selectDefult();
		datelistView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub
				final int location = position;
				historydateAdapter.setSelectedPosition(position);
				historydateAdapter.notifyDataSetInvalidated();
				historytimeAdapter = new HistoryTimeAdapter(
						getApplicationContext(), cities, position);
				timeListView.setAdapter(historytimeAdapter);
				timeListView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int position, long arg3) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(),
								cities[location][position], Toast.LENGTH_SHORT)
								.show();
					}
				});
			}
		});
	}

	private void getFileList(File path) {

		File[] f1 = path.listFiles();
		datefileNum = f1.length;
		foods = new String[datefileNum];
		images = new int[datefileNum];
		TimePath = new String[datefileNum];
		timefile = new File[datefileNum];
		for(int i=0;i<datefileNum;i++)
		{
			images[i]=R.drawable.ic_historydate;
		}
		for (int i = 0; i < f1.length; i++) {
			foods[i] = f1[i].getName();
			TimePath[i] = f1[i].getPath();
			timefile[i] = new File(TimePath[i]);
		}		
	}

	private void getHistoryFileList(File[] path) {

		
		File[] f2 = path[0].listFiles();
		for(int i=0;i<f2.length;i++)
		{
			cities[0][i]=f2[i].getName();	
		}
		
		File[] f3 = path[1].listFiles();
		for(int i=0;i<f3.length;i++)
		{
			cities[1][i]=f3[i].getName();	
		}
		File[] f4 = path[2].listFiles();
		for(int i=0;i<f4.length;i++)
		{
			cities[2][i]=f4[i].getName();	
		}
		File[] f5 = path[3].listFiles();
		for(int i=0;i<f5.length;i++)
		{
			cities[3][i]=f5[i].getName();	
		}

	}

	private void init() {
		datelistView = (HistoryListView) findViewById(R.id.datelistView);
		timeListView = (HistoryListView) findViewById(R.id.timeListView);
	}

	private void selectDefult() {
		final int location = 0;
		historydateAdapter.setSelectedPosition(0);
		historydateAdapter.notifyDataSetInvalidated();
		historytimeAdapter = new HistoryTimeAdapter(getApplicationContext(),
				cities, 0);
		timeListView.setAdapter(historytimeAdapter);
		timeListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						cities[location][position], Toast.LENGTH_SHORT).show();
			}
		});
	}
}
