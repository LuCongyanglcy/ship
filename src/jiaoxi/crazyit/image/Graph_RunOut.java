package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

//�ڶ�
public class Graph_RunOut {
	
	public float cx = 70;  //���ĵ�X
	public float cy = 250;  //���ĵ�Y
	public float staff=40;//��������ֵ
	public float rectWidth = 100;   //���ο��
	public float rectHeight = 350;   //���θ߶�
	public float higherDepth=1400;   //��߾�����
	public float underDepth=600;     //��;�����
	public float rulerhigher=1500; //��߿̶�
	public float rulerunder=500;     //��Ϳ̶�
	public float rulermain = 5;    //�̶ȳ����ȷ�
	public float rulersecond = 2;  //�̶ȳߴεȷ�
	public float rotateAngle = 0;     //��ת�Ƕ�
	public boolean switchdirection = false;  //�Ƿ�ת������
	public boolean ifint = false;  //�Ƿ����Ϳ̶�
	
	public void drawGraph(Canvas canvas) {
		
		Paint paint = new Paint();
		paint.setAntiAlias(true);		
		canvas.save();
		canvas.translate(cx, cy);
		canvas.rotate(rotateAngle, 0, 0);
		
		
		
		
		float a;
		if(rulerhigher < staff) a=rectWidth; 
		else if(rulerunder > staff) a=0; 
		else a=rectWidth*(-staff-rulerunder)/(rulerhigher-rulerunder);//�±���߳���
			
		
		float rx[]=new float[4]; //���Һ�����
		float ry[]=new float[3]; //����������
		
		rx[0]=0;
		rx[1]=rectWidth/2;
		rx[2]=rectWidth-a;
		rx[3]=rectWidth;
		
		ry[0]=0;
		ry[2]=rectHeight;
		

		
		paint.setStrokeWidth(3);
		paint.setColor(Color.GREEN);
		paint.setStyle(Style.STROKE);
		canvas.drawRect(rx[0], ry[0], rx[3], ry[2], paint);//���ο�
		
		//���
		// ��;����� <= ��������ֵ <= ��߾�����
		if(underDepth<= staff && staff<=higherDepth) paint.setColor(Color.GREEN);
		else paint.setColor(Color.RED);
		paint.setStyle(Style.FILL);
		canvas.drawRect(rx[1], ry[0], rx[2], ry[2], paint);//����PLC��״̬

		paint.setTextSize(30);
		if(ifint) {
			int ss = (int) staff;
			String sss=Integer.toString(ss);
			canvas.drawText(sss, rx[2]*99/100, 4*ry[2]/2, paint);
		}
		else {
			Float ss = staff;
			String sss=Float.toString(ss);
			canvas.drawText(sss, rx[2]*99/100, 4*ry[2]/2, paint);
		}		
		


		
		
		
		
		
		//�̶ȳ�
		float l=rectWidth/rulermain;//��С�̶�ֵ
		paint.setColor(Color.GREEN);
		for(int i=1;i<=rulermain;i++) canvas.drawLines(new float[]{i*l-l/2, ry[2], i*l-l/2, 6*ry[2]/5}, paint);//�ο̶� 
		 
		for(int i=0;i<=rulermain;i++) {
			canvas.drawLines(new float[]{i*l,ry[2], i*l, 3*ry[2]/2}, paint);//���̶�
			
			paint.setStyle(Style.FILL);
			String s;
			if(ifint) {
				int ln=(int)(rulerhigher-(rulerhigher-rulerunder)*i/rulermain);
				ln = -ln;
				s=Integer.toString(ln);
			}
			else {
				float li=(float)(rulerhigher-(rulerhigher-rulerunder)*i/rulermain);
				li = -li;
				s=Float.toString(li);
			}
			paint.setColor(Color.YELLOW);
			paint.setTextSize(30);
			canvas.drawText( s, i*l-l/12, ry[0],paint);//�̶���ֵ
		} 
		
		canvas.restore();	//�ָ�ԭ������״̬
     }
  }



