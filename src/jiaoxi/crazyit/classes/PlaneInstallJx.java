package jiaoxi.crazyit.classes;

import java.io.Serializable;

import jiaoxi.crazyit.classes.UISet.DrawShip;

public class PlaneInstallJx implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -109349549819464043L;
	public PO_XY gps1;
	public PO_XY gps2;

	public PO_XY Trunnion;				//����
	public PO_XY Winch_Left;			//���ƽʳ�λ��-----
	public PO_XY Winch_Right;
	public PO_XY MainStackPivot;		//��׮֧��
	public PO_XY AssitantStack;		//��׮
	public PO_XY[] ShipPlane;
	public int  ShipAngleFrom;
	public int SeekType;				///��������---0����λ׮̨����1�����¶�λ 2��˫��׮
	public boolean MainStackCorrect;		/////��λ׮�ź�����
	
	public PlaneInstallJx() {
		// TODO �Զ����ɵĹ��캯�����
		gps1=new PO_XY();
		gps2=new PO_XY();
		Trunnion=new PO_XY();
		Winch_Left=new PO_XY();
		Winch_Right=new PO_XY();
		MainStackPivot=new PO_XY();
		AssitantStack=new PO_XY();
		ShipPlane=new PO_XY[12];
		for(int i = 0; i< DrawShip.shipArrSize(); i++){
			ShipPlane[i]=new PO_XY();
		}
	}
}
