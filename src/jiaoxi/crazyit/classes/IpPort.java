package jiaoxi.crazyit.classes;

import java.io.Serializable;

public class IpPort implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8126477091915796797L;
	/////plc
	public int plc1Port;
	public int plc2Port;
	public int plc1IsValid;
	public int plc2IsValid;
	//////gps
	public String gpsIp;
	public int gpsPort;
	public int gpsIsValid;
	
	/////远端服务器
	public String remoteIp;
	public int remotePort;
	public int remoteValid;
	public int sendOrRecve;
}
