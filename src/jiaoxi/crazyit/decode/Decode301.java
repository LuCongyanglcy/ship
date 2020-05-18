package jiaoxi.crazyit.decode;

import java.nio.ByteBuffer;

import jiaoxi.crazyit.image.PlcData;

public class Decode301 implements DecodeReceiveData {

	///////申请数据邻令  //01-02 关键字，03-04 DB号，05-06起始地址，07-08结束地址，09-10数据长度,11-14数据，15-16校验,17-18结尾
//	byte[] sendCommand={0x24, 0x41, 0x00, 0x62, 0x00, 0x00, 0x09, 0x88-256, 0x00, 0x04, 0x00, 0x00, 0x00, 0x00, 0x01, 0x5C, 0x0D, 0x0A, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256, 0xFF-256};
	byte[] sendCommand = null;


	private boolean plcValid=false;

	////数据
	private int aiNum=20;

	private PlcData plcData;

	private byte[] receiveBuf=new byte[20480];
	private int receiveLen=0;

	public Decode301() {
		// TODO 自动生成的构造函数存根
		plcData=new PlcData();
		plcData.aiData=new float[aiNum];
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
	private float bytesTofloat(byte[] sourceData,int begin){
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

			if(receiveBuf[0]==0x24 && receiveBuf[1]==0x41){
				int dataLen=86;
				if(receiveLen>=dataLen){

					if(receiveBuf[dataLen-2]==0x0d && receiveBuf[dataLen-1]==0x0a ){
						System.out.println("123444");
						////模量量4字节
						int ibuffBegin=2;
						int ibegin=0;
						int iSize=20;
						for(int i=0;i<iSize;i++){
							plcData.aiData[ibegin+i]=bytesTofloat(receiveBuf, ibuffBegin+i*4);
						}
						System.out.println("<<<<<");
						System.out.println(plcData.aiData[2]);
						System.out.println(">>>>>");
						moveBuff(dataLen);

						plcValid=true;
					}
					else{
						plcValid=false;
						clearBuff();
					}
				}
				else{
					plcValid=false;
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
		return 0;
	}

	@Override
	public byte[] getApplyCommand() {
		// TODO Auto-generated method stub
		return sendCommand;
	}

}