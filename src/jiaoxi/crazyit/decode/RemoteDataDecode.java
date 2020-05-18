package jiaoxi.crazyit.decode;

import java.nio.ByteBuffer;

import jiaoxi.crazyit.classes.Caculate;


public class RemoteDataDecode implements DecodeReceiveData {

////数据
	private int seekLen=14;
	private int anlogLen=1000;
	private int digitLen=1125;
	private boolean clientValid=false;
	private int maxDataLen=seekLen*8+seekLen+anlogLen*4+anlogLen+digitLen*2+4;
	Caculate cacuData;
	
	public RemoteDataDecode() {
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
		/*byte[] ss=new byte[8];
		ss[0]=sourceData[begin];
		ss[1]=sourceData[begin+1];
		ss[2]=sourceData[begin+2];
		ss[3]=sourceData[begin+4];
		ss[4]=sourceData[begin+5];
		ss[5]=sourceData[begin+6];
		ss[6]=sourceData[begin+7];
		ss[7]=sourceData[begin+8];
		ByteBuffer bb=ByteBuffer.wrap(ss);
		return bb.asDoubleBuffer().get();*/
	}
	private float bytesTofloat(byte[] sourceData,int begin){
		//return Float.intBitsToFloat(getInt(sourceData, begin));
		int l;
		   l=sourceData[begin];
		   l&=0xff;
		   l|=((long)sourceData[begin+1]<<8);
		   l&=0xffff;
		   l|=((long)sourceData[begin+2]<<16);
		   l&=0xffffff;
		   l|=((long)sourceData[begin+3]<<24);
		   l&=0xffffffffl;

		   return Float.intBitsToFloat(l);  

		/*byte[] ss=new byte[4];
		ss[0]=sourceData[begin];
		ss[1]=sourceData[begin+1];
		ss[2]=sourceData[begin+2];
		ss[3]=sourceData[begin+4];
		ByteBuffer bb=ByteBuffer.wrap(ss);
		return bb.asFloatBuffer().get();*/
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
				if(receiveLen<maxDataLen){
					clientValid=true;
					break;
				}
				if(receiveBuf[0]=='$' && receiveBuf[1]=='L' && receiveBuf[2]=='A' && receiveBuf[3]=='N'){	/////////实时数据
					//int dataLen=getInt(receiveBuf, 4);
					
					//if(checkSum(8+dataLen, receiveBuf[8+dataLen])){
						int index=4;
						for(int i=0;i<seekLen;i++){
							cacuData.seekData[i]=bytesTodouble(receiveBuf, index+i*8);
							//double s=bytesTodouble(buf, index+i*8);
						}
						index+=seekLen*8;
						for(int i=0;i<seekLen;i++){
							cacuData.seekEnable[i]=receiveBuf[index+i];
						}
						index+=seekLen;
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
						moveBuff(maxDataLen);
					/*}
					else{
						moveBuff(dataLen+11);
						clientValid=false;
					}*/
					
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
		// TODO 自动生成的方法存根
		return null;
	}

}
