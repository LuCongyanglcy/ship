package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Graph_SmallDoor {
	public float cx = 70;       //���ĵ�X
	public float cy = 90;       //���ĵ�Y
	public float percent=60;  //������ٷֱ�
	public String szText = "";
	public float rectWidth = 80;   //С���ο��
	public float rectHeight = 70;  //С���θ߶�
	public float rotateAngle = 0;  //��ת�Ƕ�
	public boolean choiced = false;  //�Ƿ�ѡ��
	public boolean bCtrlInthisWnd = false;   //�ڴ������Ƿ��������
	public boolean closing = false;   //���ڹر�
	public boolean opening = false;    //���ڴ�
	public boolean open_state = false;  //��״̬
	public boolean close_state = false; //�ر�״̬
	public boolean compelling = false;  //��ǿ��
	public boolean enjoin = false;     //��ֹ
	public boolean failure = false;   //�豸���ϻ�����
	float lx[]=new float[2];//С���κ�����
	float ly[]=new float[2];//С����������
	float px[]=new float[2];//����κ�����
	float py[]=new float[2];//�����������
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
		px[0]=-5*rectWidth/8;   py[0]=-9*rectHeight/16;
		px[1]=5*rectWidth/8;   py[1]=9*rectHeight/16;
		lx[0]=-rectWidth/2;   ly[0]=-rectHeight/2;
		lx[1]=rectWidth/2;   ly[1]=rectHeight/2;
	   if(enjoin){//�豸���ϻ�����
			 paint.setStrokeWidth(3);
			 color = Color.argb(255, 0,139,139); 
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //���������ľ���
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[1], paint);
		     //����һ����ɫ���ľ���
		     paint.setColor(Color.WHITE);
		     paint.setStrokeWidth(8);
		     canvas.drawLines(new float[]{lx[0]+3,0,lx[1]-3,0}, paint);
		     //���ư�ɫֱֱ��
		}
	   else if(closing){//���ڹر�
			 paint.setStrokeWidth(3);
			 if(aiData%10==0) color = Color.argb(255, 0,139,139);
		      else  color=Color.argb(255,81,81,81);
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //���������ľ���
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[1]*(50-percent)/50,lx[1],ly[1], paint);
		     //����һ����ɫ���ľ���
		     paint.setStrokeWidth(1);
			 paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[1]*(50-percent)/50, paint);
		     //����һ����ɫ���ľ���
		     }
		else if(opening){//���ڴ�
			 paint.setStrokeWidth(3);
			 if(aiData%10==0) color = Color.argb(255, 124,252,0);
		      else  color=Color.argb(255, 0,139,139);
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //���������ľ���
			 paint.setStrokeWidth(1);
			 paint.setStrokeWidth(1);
			 paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     if(percent>100) percent=100;
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[0]*(50-percent)/50, paint);
		     //����һ����ɫ���ľ���
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0]*(50-percent)/50,lx[1],ly[1], paint);
		     //����һ����ɫ���ľ���
		     }
		else if(close_state){//�ر�״̬
			 paint.setStrokeWidth(3);
			 color = Color.argb(255, 0,139,139); 
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //���������ľ���
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[1]*(50-percent)/50,lx[1],ly[1], paint);
		     //����һ����ɫ���ľ���
		     paint.setStrokeWidth(1);
			 paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[1]*(50-percent)/50, paint);
		     //����һ����ɫ���ľ���
		}
		else if(open_state){//��״̬
			 paint.setStrokeWidth(3);
			 color = Color.argb(255, 0,139,139); 
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //���������ľ���
		     paint.setStrokeWidth(1);
			 paint.setStrokeWidth(1);
			 paint.setColor(Color.argb(255,255,255,0));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[0]*(50-percent)/50, paint);
		     //����һ����ɫ���ľ���
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0]*(50-percent)/50,lx[1],ly[1], paint);
		     //����һ����ɫ���ľ���
		}
		else if(failure){//�豸���ϻ�����
			 paint.setStrokeWidth(3);
			 color = Color.argb(255, 0,139,139); 
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //���������ľ���
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[1], paint);
		     //����һ����ɫ���ľ���
		}
		else if(compelling){//��ǿ��
			 paint.setStrokeWidth(3);
			 color = Color.argb(255, 0,139,139); 
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //���������ľ���
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[1], paint);
		     //����һ����ɫ���ľ���
		     paint.setColor(Color.RED);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(5*px[0]/4,7*py[0]/6,5*px[1]/4,7*py[1]/6, paint);
		     //���������ĺ�ɫ����

		}
		else{
			paint.setStrokeWidth(3);
			 color = Color.argb(255, 0,139,139); 
		     paint.setColor(color);
		     paint.setStyle(Style.STROKE);
		     canvas.drawRect(px[0],py[0],px[1],py[1], paint);
		     //���������ľ���
		     paint.setColor(Color.argb(255,81,81,81));
		     paint.setStyle(Style.FILL);
		     canvas.drawRect(lx[0],ly[0],lx[1],ly[1], paint);
		     //����һ����ɫ���ľ���
		}
	     canvas.restore();	//�ָ�ԭ������״̬
		     }
	}