package jiaoxi.crazyit.decode;

import java.nio.ByteBuffer;

import jiaoxi.crazyit.image.PlcData;

public class Decode6000 implements DecodeReceiveData {

	///////申请数据邻令
	byte[] sendCommand={0x24, 0x41, 0x00, 0x62, 0x00, 0x00, 0x0A, 0xFB-256, 0x00, 0x04, 0x00, 0x00, 0x00, 0x00, 0x01, 0xD0-256, 0x0D, 0x0A, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256};
	
	

	private boolean plcValid=false;
	
	////数据
	private int aiNum=548;
	private int diNum=496;

	private PlcData plcData;
	
	private byte[] receiveBuf=new byte[20480];
	private int receiveLen=0;
	
	public Decode6000() {
		// TODO 自动生成的构造函数存根
		plcData=new PlcData();
		plcData.aiData=new float[aiNum];
		plcData.diData=new byte[diNum];
	}



	@Override
	public int getSeekNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	//////寻找头
	private int getHead(){
		int nrd=-1;
		for(int i=0;i<receiveLen-1;i++){
			if(receiveBuf[i]=='$'){
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
	///////校验
	private boolean checkSum(int num,int check){
	/*	int wcheck=0x00;
		for(int i=0;i<num;i++){
			if(receiveBuf[i]<0){
				wcheck+=receiveBuf[i]+256;
			}else{
				wcheck+=receiveBuf[i];
			}
		}
		if(check<0){
			check+=256;
		}
		wcheck=wcheck<<2;
		wcheck=wcheck>>2;
		if(wcheck==check){
			return true;
		}
		else{
			return false;
		}*/
		return true;
	}
	
	
	public static int getInt(byte[] bytes,int begin)
    {
        return (0xff & bytes[begin+0]) | (0xff00 & (bytes[begin+1] << 8)) | (0xff0000 & (bytes[begin+2] << 16)) | (0xff000000 & (bytes[begin+3] << 24));
/*		 byte[] b= new byte[4];
		  b[0]= bytes[begin+0];
		  b[1]= bytes[begin+1];
		  b[2]= bytes[begin+2];
		  b[3]= bytes[begin+3];
		  String hex = new String(b);
//      return (0xff & bytes[begin+0]) | (0xff00 & (bytes[begin+1] << 8)) | (0xff0000 & (bytes[begin+2] << 16)) | (0xff000000 & (bytes[begin+3] << 24));
		  return Integer.valueOf(hex, 16);*/
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
//		return Float.intBitsToFloat(getInt(sourceData, begin));
		byte[] ss=new byte[4];
		ss[0]=sourceData[begin];
		ss[1]=sourceData[begin+1];
		ss[2]=sourceData[begin+2];
		ss[3]=sourceData[begin+3];
		ByteBuffer bb=ByteBuffer.wrap(ss);
		return bb.asFloatBuffer().get();
	}
	@Override
	public boolean decodeData(byte[] buf,int len) {
		// TODO Auto-generated method stub
		for(int i=0;i<len;i++){
			receiveBuf[receiveLen+i]=buf[i];
		}
		receiveLen+=len;
		while(receiveLen>0){
			int nBeginNum=getHead();
			if(nBeginNum==-1){
				clearBuff();
				plcValid=false;
				break;
			}
			if(nBeginNum>0){
				moveBuff(nBeginNum);
			}
			int b=0,b1=0;
			if(receiveBuf[2]<0){
				b=receiveBuf[2]+256;
				
			}
			else{
				b=receiveBuf[2];
			}
			if(receiveBuf[3]<0){
				b1=receiveBuf[3]+256;
			}
			else{
				b1=receiveBuf[3];
			}
			int nDB=(b<<8)+b1;
			
			if(nDB==98 && receiveBuf[1]=='A'){
				if(receiveBuf[8]<0){
					b=receiveBuf[8]+256;
					
				}
				else{
					b=receiveBuf[8];
				}
				if(receiveBuf[9]<0){
					b1=receiveBuf[9]+256;
				}
				else{
					b1=receiveBuf[9];
				}
				int wLen=(b<<8)+b1;;
				int headLen=10;
				int dataLen=headLen+wLen+4;
				
				if(receiveLen>=dataLen){
					
					if(receiveBuf[dataLen-4]<0){
						b=receiveBuf[dataLen-4]+256;
						
					}
					else{
						b=receiveBuf[dataLen-4];
					}
					if(receiveBuf[dataLen-3]<0){
						b1=receiveBuf[dataLen-3]+256;
					}
					else{
						b1=receiveBuf[dataLen-3];
					}
					int wCheck=(b<<8)+b1;
					
					if(receiveBuf[4]<0){
						b=receiveBuf[4]+256;
						
					}
					else{
						b=receiveBuf[4];
					}
					if(receiveBuf[5]<0){
						b1=receiveBuf[5]+256;
					}
					else{
						b1=receiveBuf[5];
					}
					
					int beg=(b<<8)+b1;
					
					if(receiveBuf[6]<0){
						b=receiveBuf[6]+256;
						
					}
					else{
						b=receiveBuf[6];
					}
					if(receiveBuf[7]<0){
						b1=receiveBuf[7]+256;
					}
					else{
						b1=receiveBuf[7];
					}
					
					int end=(b<<8)+b1;
					
					if(receiveBuf[dataLen-2]==0x0d && receiveBuf[dataLen-1]==0x0a && beg==0 && end==2811 && checkSum(dataLen-4, wCheck)){
						/////db3
					//	int iSize=128;
						int iSize=88;
						int ibegin=0;
						int ibuffBegin=headLen;
						for(int i=0;i<iSize;i++){
							plcData.aiData[ibegin+i]=bytesTofloat(receiveBuf, ibuffBegin+i*4);
						}
						///db203
						ibuffBegin+=iSize*4;
						ibegin+=iSize;
				//		iSize=128;
						iSize=88;
						for(int i=0;i<iSize;i++){
							plcData.aiData[ibegin+i]=bytesTofloat(receiveBuf, ibuffBegin+i*4);
						}
						////db5
						ibuffBegin+=iSize*4;
						ibegin+=iSize;
					//	iSize=56;
						iSize=16;
						for(int i=0;i<iSize;i++){
							plcData.aiData[ibegin+i]=bytesTofloat(receiveBuf, ibuffBegin+i*4);
						}
						
						///db204
						ibuffBegin+=iSize*4;
						ibegin+=iSize;
					//	iSize=56;
						iSize=16;
						for(int i=0;i<iSize;i++){
							plcData.aiData[ibegin+i]=bytesTofloat(receiveBuf, ibuffBegin+i*4);
						}
						///db20
						ibuffBegin+=iSize*4;
						ibegin+=iSize;
						plcData.diData[495]=receiveBuf[ibuffBegin];
					//	iSize=47;
						iSize=164;
						ibuffBegin+=2;
						for(int i=0;i<iSize;i++){
							plcData.aiData[ibegin+i]=bytesTofloat(receiveBuf, ibuffBegin+i*4);
						}
						//db2
						ibuffBegin+=iSize*4;
						ibegin+=iSize;
						iSize=176;
						for(int i=0;i<iSize;i++){
							plcData.aiData[ibegin+i]=bytesTofloat(receiveBuf, ibuffBegin+i*4);
						}
						
						///db4
						ibuffBegin+=iSize*4;
						ibegin=0;
				//		iSize=82;
						iSize=62;
						for(int i=0;i<iSize;i++){
							plcData.diData[ibegin+i]=receiveBuf[ibuffBegin+i];
						}
						///db6
						ibuffBegin+=iSize;
						ibegin+=iSize;
				//		iSize=64;
						iSize=56;
						for(int i=0;i<iSize;i++){
							plcData.diData[ibegin+i]=receiveBuf[ibuffBegin+i];
						}
						///db205
						ibuffBegin+=iSize;
						ibegin+=iSize;
				//		iSize=300;
						iSize=364;
						for(int i=0;i<iSize;i++){
							plcData.diData[ibegin+i]=receiveBuf[ibuffBegin+i];
						}
						moveBuff(dataLen);
						
						plcValid=true;
					}
					else{
						plcValid=false;
						clearBuff();
					}
				}
				else{
					plcValid=true;
					break;
				}
			}
			else{
				plcValid=false;
				clearBuff();
			}
		}
		return plcValid;
	}
	
	

	@Override
	public Object getObjectData() {
		// TODO 自动生成的方法存根
		return plcData;
	}



	@Override
	public int getAiNum() {
		// TODO Auto-generated method stub
		return aiNum;
	}


	@Override
	public int getDiNum() {
		// TODO Auto-generated method stub
		return diNum;
	}

	@Override
	public byte[] getApplyCommand() {
		// TODO Auto-generated method stub
		return sendCommand;
	}

}
