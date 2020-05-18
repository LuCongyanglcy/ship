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
	
	private int datefileNum = 0; //�ļ�������
	private int[] timefileNum = null; //�ļ������ļ�����
	// ///SD��·��
	private String sdPath;
	private String DatePath = "";
	private String[] TimePath = null;
	private File datefile;
	private File[] timefile=null;
	String cities[][] = new String[][] {
			new String[] { "ȫ����ʳ", "���ｭ���", "����", "����", "���", "������", "̨���",
					"�½�/����", "�ز�", "���", "������", "С�Կ��", "�ձ�", "��������", "�����ǲ�",
					"����", "������", "����" },
			new String[] { "ȫ����������", "������", "�ư�", "���", "KTV", "��ӰԺ", "��������",
					"��԰", "����/����", "ϴԡ", "��ԡ��Ħ", "�Ļ�����", "DIY�ֹ���", "�����",
					"������Ϸ", "������������" },
			new String[] { "ȫ������", "�ۺ��̳�", "����Ь��", "�˶�����", "�鱦��Ʒ", "��ױƷ",
					"����ҵ�", "���ӹ���", "�Ҿӽ���", "���", "���", "�۾���", "��ɫ����",
					"���๺�ﳡ��", "ʳƷ���", "����/������", "ҩ��" },
			new String[] { "ȫ����������", "������", "�ư�", "���", "KTV", "��ӰԺ", "��������",
					"��԰", "����/����", "ϴԡ", "��ԡ��Ħ", "�Ļ�����", "DIY�ֹ���", "�����",
					"������Ϸ", "������������" },
			new String[] { "ȫ", "������", "�ư�", "���", "KTV", "��������", "��԰",
					"����/����", "ϴԡ", "��ԡ��Ħ", "�Ļ�����", "DIY�ֹ���", "�����", "������Ϸ",
					"������������" },
			new String[] { "ȫ��", "������", "�ư�", "���", "��ӰԺ", "��������", "��԰",
					"����/����", "ϴԡ", "��ԡ��Ħ", "�Ļ�����", "DIY�ֹ���", "�����", "������Ϸ",
					"������������" },
			new String[] { "ȫ����", "������", "�ư�", "���", "KTV", "��ӰԺ", "��������",
					"��԰", "����/����", "ϴԡ", "��ԡ��Ħ", "�Ļ�����", "DIY�ֹ���", "�����",
					"������Ϸ", "������������" },
			new String[] { "ȫ������", "������", "�ư�", "���", "KTV", "��ӰԺ", "��������",
					"��԰", "����/����", "ϴԡ", "��ԡ��Ħ", "�Ļ�����", "DIY�ֹ���", "�����",
					"������Ϸ", "������������" },
			new String[] { "ȫ��������", "������", "�ư�", "���", "KTV", "��ӰԺ", "��������",
					"��԰", "����/����", "ϴԡ", "��ԡ��Ħ", "�Ļ�����", "DIY�ֹ���", "�����",
					"������Ϸ" },
			new String[] { "ȫ����������", "������", "�ư�", "���", "KTV", "��ӰԺ", "��������",
					"��԰", "����/����", "ϴԡ", "��ԡ��Ħ", "�Ļ�����", "DIY�ֹ���", "�����",
					"������Ϸ", "������������" },
			new String[] { "ȫ������aaa", "������", "�ư�", "���", "KTV", "��ӰԺ", "��������",
					"��԰", "����/����", "ϴԡ", "��ԡ��Ħ", "�Ļ�����", "DIY�ֹ���", "�����",
					"������Ϸ" }, 
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
		// ��ȡ�ļ��б�
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
