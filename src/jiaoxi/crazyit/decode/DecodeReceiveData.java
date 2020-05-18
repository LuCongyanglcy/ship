package jiaoxi.crazyit.decode;

public interface DecodeReceiveData {
	public boolean decodeData(byte[] buf,int len);
	public Object getObjectData();	
	public int getSeekNum();
	public int getAiNum();
	public int getDiNum();
	public byte[] getApplyCommand();
}
