package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Graph_BigDoor {
	public float cx = 70;       //���ĵ�X
	public float cy = 180;       //���ĵ�Y
	public float percent=60;  //������ٷֱ�
	public float circle = 40;   //Բ�뾶
	public String szText = "";
	public float rotateAngle = 0;     //��ת�Ƕ�
	public boolean choiced = false;  //�Ƿ�ѡ��
	public boolean bCtrlInthisWnd = false;   //�ڴ������Ƿ��������
	public boolean closing = false;   //���ڹر�
	public boolean opening = false;    //���ڴ�
	public boolean open_state = false;  //��״̬
	public boolean close_state = false; //�ر�״̬
	public boolean compelling = false;  //��ǿ��
	public boolean enjoin = false;     //��ֹ
	public boolean failure = false;   //�豸���ϻ�����
	float px[] = new float[3]; //�����������������
	float py[] = new float[3]; //������������������
	float lx[]=new float[2];//����б�ܺ�����
	float ly[]=new float[2];//����б��������
	public float aiData = 0;
	public void drawGraph(Canvas canvas) {
		if(percent>100) percent=100;
		else if(percent<0) percent=0;
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//ʹ�ÿ���ݹ���
		//paint.setStyle(Paint.Style.FILL);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(2);
		int color = 0;
		canvas.save();//���浱ǰ����״̬
	     canvas.translate(cx, cy);//�ı�����ϵԭ��
		canvas.rotate(-rotateAngle, 0, 0);
		px[0]=-circle;   py[0]=0;
		px[1]=circle/2;  py[1]=(float) -0.866*circle;
		px[2]=circle/2;  py[2]=(float) 0.866*circle;
		lx[0]=(float) -0.707*circle;    ly[0]=(float) 0.707*circle;
		lx[1]=(float) 0.707*circle;     ly[1]=(float) -0.707*circle;
		
		if(enjoin){//��ֹ
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle, paint);
		     //��ɫ���Բ
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle*(100-aiData)/100, paint);
		     //����һ����ɫ����Բ
		     paint.setColor(Color.BLACK);
		     paint.setStrokeWidth(3);
		     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
		     //�����м��ɫ����
		     paint.setColor(Color.WHITE);
		     paint.setStrokeWidth(8);
		     canvas.drawLines(new float[]{lx[0],ly[0],lx[1],ly[1]}, paint);
		     //���ư�ɫбֱ��
		     paint.setStrokeWidth(5);//x����������ϸ
		     color = Color.argb(255, 0,139,139);
			 paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawCircle(0,0,circle, paint);
		     //����һ��������Բ
		     }	 
		else if(closing){//���ڹر�
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle, paint);
		     //��ɫ���Բ
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle*percent/100, paint);
		     //����һ����ɫ����Բ
		     paint.setColor(Color.BLACK);
		     paint.setStrokeWidth(3);
		     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
		     //�����м��ɫ����
		     paint.setStrokeWidth(5);//x����������ϸ
		     if(aiData%10==0)color = Color.argb(255, 0,139,139);
		     else color=Color.WHITE;
			 paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawCircle(0,0,circle, paint);
		     //����һ��������Բ
		     }
		 else if(opening){//���ڴ�
				 paint.setStrokeWidth(1);
			     paint.setColor(Color.argb(255,255,255,0));
			     paint.setStyle(Style.FILL);
			     canvas.drawCircle(0,0,circle, paint);
			     //��ɫ���Բ
				 paint.setStrokeWidth(1);
			     paint.setColor(Color.argb(255,81,81,81));
			     paint.setStyle(Style.FILL);
			     canvas.drawCircle(0,0,circle*(100-percent)/100, paint);
			     //����һ����ɫ����Բ
			     paint.setColor(Color.BLACK);
			     paint.setStrokeWidth(3);
			     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
			     //�����м��ɫ����
			     paint.setStrokeWidth(5);//x����������ϸ
			     if(aiData%10==0) color = Color.argb(255, 124,252,0);
			      else  color=Color.argb(255, 0,139,139);
				 paint.setColor(color);
			     paint.setStyle(Style.STROKE);
			     canvas.drawCircle(0,0,circle, paint);
			     //����һ��������Բ
			     }
		  else if (close_state) {//�ر�״̬
			  paint.setStrokeWidth(1);
			     paint.setColor(Color.argb(255,255,255,0));
			     paint.setStyle(Style.FILL);
			     canvas.drawCircle(0,0,circle, paint);
			     //��ɫ���Բ
				 paint.setStrokeWidth(1);
			     paint.setColor(Color.argb(255,81,81,81));
			     paint.setStyle(Style.FILL);
			     canvas.drawCircle(0,0,circle*percent/100, paint);
			     //����һ����ɫ����Բ
		     paint.setColor(Color.BLACK);
		     paint.setStrokeWidth(3);
		     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
		     //�����м��ɫ����
		     paint.setStrokeWidth(3);//����������ϸ
		     paint.setColor(Color.argb(200,193,205,193));
		     canvas.drawLines(new float[]{px[0],py[0],px[1],py[1],px[1],py[1],px[2],py[2],px[2],py[2],px[0],py[0]}, paint);
			 //���ư�ɫ��һ��������
		     paint.setStrokeWidth(5);//x����������ϸ
		     color = Color.argb(255, 0,139,139);
			 paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawCircle(0,0,circle, paint);
		     //����һ��������Բ
		     }
		  else if (open_state) {//�ر�״̬
			  paint.setStrokeWidth(1);
			     paint.setColor(Color.argb(255,255,255,0));
			     paint.setStyle(Style.FILL);
			     canvas.drawCircle(0,0,circle, paint);
			     //��ɫ���Բ
				 paint.setStrokeWidth(1);
			     paint.setColor(Color.argb(255,81,81,81));
			     paint.setStyle(Style.FILL);
			     canvas.drawCircle(0,0,circle*(100-percent)/100, paint);
			     //����һ����ɫ����Բ
			     paint.setColor(Color.BLACK);
			     paint.setStrokeWidth(3);
			     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
			     //�����м��ɫ����
			     paint.setStrokeWidth(5);//x����������ϸ
			     color = Color.argb(255, 0,139,139);
				 paint.setColor(color);
			     paint.setStyle(Style.STROKE);
			     canvas.drawCircle(0,0,circle, paint);
			     //����һ��������Բ
			     }
		 else if(failure) { //�豸���ϻ�����
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle, paint);
		     //��ɫ���Բ
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle*(100-aiData)/100, paint);
		     //����һ����ɫ����Բ
		     paint.setColor(Color.BLACK);
		     paint.setStrokeWidth(3);
		     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
		     //�����м��ɫ����
		     paint.setStrokeWidth(5);//x����������ϸ
			 paint.setColor(Color.RED);
		     paint.setStyle(Style.STROKE);
		     canvas.drawCircle(0,0,circle, paint);
		     //����һ��������Բ
		     }	 
		 else if(compelling) {//��ǿ�� 
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle, paint);
		     //��ɫ���Բ
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle*(100-aiData)/100, paint);
		     //����һ����ɫ����Բ
		     paint.setColor(Color.BLACK);
		     paint.setStrokeWidth(3);
		     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
		     //�����м��ɫ����
		     paint.setColor(Color.RED);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(-circle,-circle,circle,circle, paint);
		     //���������ĺ�ɫ����
		     paint.setStrokeWidth(5);//x����������ϸ
		     color = Color.argb(255, 0,139,139);
			 paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawCircle(0,0,circle, paint);
		     //����һ��������Բ
		     }	 
		 else{
			 paint.setStrokeWidth(1);
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawCircle(0,0,circle, paint);
		     //����һ����ɫ����Բ
		     paint.setColor(Color.BLACK);
		     paint.setStrokeWidth(3);
		     canvas.drawLines(new float[]{0,0,px[0],py[0],0,0,px[1],py[1],0,0,px[2],py[2]}, paint);
		     //�����м��ɫ����
		     paint.setStrokeWidth(5);//x����������ϸ
		     color = Color.argb(255, 0,139,139);
			 paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawCircle(0,0,circle, paint);
		     //����һ��������Բ
		 }
			 canvas.restore();	//�ָ�ԭ������״̬
		 }
}