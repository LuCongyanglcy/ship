package jiaoxi.crazyit.decode;

import jiaoxi.crazyit.classes.Caculate;

public class DecodeClient11000 implements DecodeReceiveData {

///////申请数据邻令
	byte[] sendCommand={0x24, 0x4C, 0x41, 0x4E, 0x01, 0x00, 0x00, 0x00, 0x52, 0x52, 0x0A, 0x0D};
	
	////数据
	private int seekLen=14;
	private int anlogLen=1000;
	private int digitLen=1125;
	private boolean clientValid=false;
	
	Caculate cacuData;
	
	public DecodeClient11000() {
		// TODO 自动生成的构造函数存根
		cacuData=new Caculate();
		cacuData.seekData=new double[seekLen];
		cacuData.seekEnable=new byte[seekLen];
		cacuData.anlogData=new float[anlogLen];
		cacuData.anlogEnable=new byte[anlogLen];
		cacuData.digitData=new byte[digitLen];
		cacuData.digitEnbale=new byte[digitLen];
	}
	
	@Override
	public Object getObjectData() {
		// TODO 自动生成的方法存根
		return cacuData;
	}

	private byte[] receiveBuf=new byte[20480];
	private int receiveLen=0;
	
	public static int getInt(byte[] bytes,int begin)
    {
        return (0xff & bytes[begin+0]) | (0xff00 & (bytes[begin+1] << 8)) | (0xff0000 & (bytes[begin+2] << 16)) | (0xff000000 & (bytes[begin+3] << 24));
    }

	public static long getLong(byte[] bytes,int begin)
    {
        return(0xffL & (long)bytes[begin+0]) | (0xff00L & ((long)bytes[begin+1] << 8)) | (0xff0000L & ((long)bytes[begin+2] << 16)) | (0xff000000L & ((long)bytes[begin+3] << 24))
         | (0xff00000000L & ((long)bytes[begin+4] << 32)) | (0xff0000000000L & ((long)bytes[begin+5] << 40)) | (0xff000000000000L & ((long)bytes[begin+6] << 48)) | (0xff00000000000000L & ((long)bytes[begin+7] << 56));
    }
	
	private double bytesTodouble(byte[] sourceData,int begin){
		long l=getLong(sourceData,begin);
		
		return Double.longBitsToDouble(l);
	}
	private float bytesTofloat(byte[] sourceData,int begin){
		return Float.intBitsToFloat(getInt(sourceData, begin));
	}
	
	///////校验
	private boolean checkSum(int num,byte check){
		byte wcheck=0x00;
		for(int i=0;i<num;i++){
			if(receiveBuf[i]<0){
				wcheck+=receiveBuf[i]+256;
			}else{
				wcheck+=receiveBuf[i];
			}
		}
		
		if(wcheck==check){
			return true;
		}
		else{
			return false;
		}
	}
	//////寻找头
	private int getHead(){
		int nrd=-1;
		for(int i=0;i<receiveLen-1;i++){
			if(receiveBuf[i]=='$' && receiveBuf[i+1]=='L' && receiveBuf[i+2]=='A' && receiveBuf[i+3]=='N'){
				nrd=i;
				break;
			}
		}
		return nrd;
	}
	/////清除数据
	private void clearBuff(){
		for(int i=0;i<receiveLen;i++){
			receiveBuf[i]=0;
		}
		receiveLen=0;
	}
	
	///////移动数据
	private boolean moveBuff(int len){
		if(receiveLen<1){
			return false;
		}
		if(receiveLen<len){
			clearBuff();
			return false;
		}
		for(int i=0;i<receiveLen-len;i++){
			receiveBuf[i]=receiveBuf[len+i];
		}
		receiveLen-=len;
		return true;
	}
	@Override
	public boolean decodeData(byte[] buf, int len) {
		// TODO Auto-generated method stub
		
		if(len>0){
			for(int i=0;i<len;i++){
				receiveBuf[receiveLen+i]=buf[i];
			}
			receiveLen+=len;
			while(receiveLen>0){
				int nBeginNum=getHead();
				if(nBeginNum==-1){
					clearBuff();
					clientValid=false;
					break;
				}
				if(nBeginNum>0){
					moveBuff(nBeginNum);
				}
				if(receiveLen<9355){
					clientValid=true;
					break;
				}
				if(receiveBuf[0]=='$' && receiveBuf[1]=='L' && receiveBuf[2]=='A' && receiveBuf[3]=='N'){	/////////实时数据
					int dataLen=getInt(receiveBuf, 4);
					
					if(checkSum(8+dataLen, receiveBuf[8+dataLen])){
						int index=8;
						for(int i=0;i<seekLen;i++){
							cacuData.seekData[i]=bytesTodouble(receiveBuf, index+i*8);
							//double s=bytesTodouble(buf, index+i*8);
						}
						index+=seekLen*8;
						for(int i=0;i<seekLen;i++){
							cacuData.seekEnable[i]=receiveBuf[index+i];
						}
						index+=12;
						for(int i=0;i<anlogLen;i++){
							cacuData.anlogData[i]=bytesTofloat(receiveBuf, index+i*4);
						}
						index+=anlogLen*4;
						for(int i=0;i<anlogLen;i++){
							cacuData.anlogEnable[i]=receiveBuf[index+i];
						}
						index+=anlogLen;
						for(int i=0;i<digitLen;i++){
							cacuData.digitData[i]=receiveBuf[index+i];
						}
						index+=digitLen;
						for(int i=0;i<digitLen;i++){
							cacuData.digitEnbale[i]=receiveBuf[index+i];
						}
						clientValid=true;
					}
					else{
						moveBuff(dataLen+11);
						clientValid=false;
					}
					
				}
				else{
					clientValid=false;
				}
			}
			
		}	
		else{
			clientValid=false;
		}
		return clientValid;
	}

	
	

	@Override
	public int getSeekNum() {
		// TODO Auto-generated method stub
		return seekLen;
	}

	

	@Override
	public int getAiNum() {
		// TODO Auto-generated method stub
		return anlogLen;
	}

	
	@Override
	public int getDiNum() {
		// TODO Auto-generated method stub
		return digitLen;
	}

	@Override
	public byte[] getApplyCommand() {
		// TODO Auto-generated method stub
		return sendCommand;
	}

}
