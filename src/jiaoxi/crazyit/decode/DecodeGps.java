package jiaoxi.crazyit.decode;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import jiaoxi.crazyit.classes.gps.GpsValue;


public class DecodeGps implements DecodeReceiveData {

	String gpsData="";
	GpsValue gv=new GpsValue();
	private boolean gpsValid=false;
	
	public static String utc2Local(String utcTime, String utcTimePatten, 
			 String localTimePatten) { 
			 SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePatten); 
			 utcFormater.setTimeZone(TimeZone.getTimeZone("UTC")); 
			 Date gpsUTCDate = null; 
			 try { 
			 gpsUTCDate = utcFormater.parse(utcTime); 
			 } catch (ParseException e) { 
			 e.printStackTrace(); 
			 } 
			 SimpleDateFormat localFormater = new SimpleDateFormat(localTimePatten); 
			 localFormater.setTimeZone(TimeZone.getDefault()); 
			 String localTime = localFormater.format(gpsUTCDate.getTime()); 
			 return localTime; 
			 }
	@Override
	public boolean decodeData(byte[] buf, int len) {
		// TODO Auto-generated method stub
		try {
			String tmpString=new String(buf,0,len,"utf-8");
			gpsData=tmpString;
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		String []datas=gpsData.split("\n");
		for(int i=0;i<datas.length;i++){
			String []subDatas=datas[i].split(",");
			
			if(subDatas[0].equals("$GPGGA")){
				gv.m_Time=utc2Local(subDatas[1],"hhmmss.sss","hh-mm-ss");
				if(subDatas[2].length()>=20){
					return false;
				}
				gv.m_Latitude=Double.parseDouble(subDatas[2]);
				if(subDatas[3].equals("S")){
					gv.bSourthOrNorth=true;
				}
				else{
					gv.bSourthOrNorth=false;
				}
				if(subDatas[4].length()>=20){
					return false;
				}
				gv.m_Longitude=Double.parseDouble(subDatas[4]);
				if(subDatas[5].equals("W")){
					gv.bWestOrEast=true;
				}
				else{
					gv.bWestOrEast=false;
				}
				gv.wQualityIndicator=Integer.parseInt(subDatas[6]);
				gv.m_nSatellites=Integer.parseInt(subDatas[7]);
				gv.m_HDOP=Double.parseDouble(subDatas[8]);
				gv.m_AntennaAltitudeMeters=Double.parseDouble(subDatas[9]);//海拔高度
				
				gpsValid=true;
			}
			else if(subDatas[0].equals("$HEHDT")){
				if(subDatas[1]== null)
				{
					gv.m_Heading = 0;
				}
				gv.m_Heading=Double.parseDouble(subDatas[1]);
				gpsValid=true;
			}
			else if(subDatas[0].equals("$GPVTG")){
				gv.m_Bearing=Double.parseDouble(subDatas[1]);//对地航向
				gv.m_SpeedOverGroundKnots=Double.parseDouble(subDatas[5]);//对地航速
				gpsValid=true;
			}			
			else if(subDatas[0].equals("$GPHDT")){
				if(subDatas[1] == "")
				{
					gv.m_Heading=0;
				}
				else
					gv.m_Heading =Double.parseDouble(subDatas[1]);
				
				gpsValid=true;
			}
			
		}
		return gpsValid;
	}


	/* （非 Javadoc）
	 * @see org.crazyit.image.DecodeReceiveData#getObjectData()
	 */
	@Override
	public Object getObjectData() {
		// TODO 自动生成的方法存根
		return gv;
	}
	@Override
	public int getSeekNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAiNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDiNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] getApplyCommand() {
		// TODO Auto-generated method stub
		return null;
	}

}
