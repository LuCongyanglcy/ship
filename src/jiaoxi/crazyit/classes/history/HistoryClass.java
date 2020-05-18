package jiaoxi.crazyit.classes.history;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class HistoryClass {

	public static HistoryParam ReadHistoryParam(String fileName){

		HistoryParam historyParam;
		try {
			FileInputStream in=new FileInputStream(fileName);
			ObjectInputStream ois=new ObjectInputStream(in);
			historyParam=(HistoryParam)ois.readObject();
			ois.close();
			in.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			historyParam=new HistoryParam();
			historyParam.bRecordData=true;
			historyParam.bReview=false;
			historyParam.bUpData=false;
		}
		
		return historyParam;
	}
	
	public static void SaveHistoryParam(String fileName,HistoryParam hp){
		File f=new File(fileName);
		if(f.exists()){
			f.delete();
		}
		try {
			OutputStream os=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(os);
			oos.writeObject(hp);
			oos.close();
			os.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
