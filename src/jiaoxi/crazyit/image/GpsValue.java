package jiaoxi.crazyit.image;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GpsValue {

	public boolean bWestOrEast;			////西经或东经
	public boolean bSourthOrNorth;			////南纬或北纬
	public double m_Latitude;		///纬度
	public double m_Longitude;		///经度
	public int wQualityIndicator;		//信号质量
	public double m_SpeedOverGroundKnots;		////对地航速
	public int m_IsDataValid;		///数据是否有效  0未知，1有效，2无效
	public String m_Time;		//	时间
	//NMEA_DATE m_Date;		//	日期
	public double m_AntennaAltitudeMeters;		/////天线海拔高度
	public int	   m_nSatellites;			////接收卫星个数
	public double m_Bearing;				////首向---对地航向
	public double m_Heading;				////艏向---双天线的GPS输出

	//	水平精度因子（0.5~99.9）
	//	当精度的强弱度值近似等於1,表示成果非常理想。
	//	如果该值大於6,则表示成果不能接受,必须重新观测
	public double m_HDOP;
}
