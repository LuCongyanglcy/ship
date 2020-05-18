package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class Graph_Value {
	public float cx = 50;  //���ĵ�X
	public float cy = 50;  //���ĵ�Y
	public float rectWidth = 45;   //���ο��
	public float rectHeight = 25;  //���θ߶�
	public float rotateAngle = 0;  //��ת�Ƕ�
	public String szText = "";  //��������
	public boolean choiced = false;  //�Ƿ�ѡ��
	public boolean bCtrlInthisWnd = false;   //�ڴ������Ƿ��������
	public boolean closeing = false;   //���ڹر�
	public boolean opening = false;    //���ڴ�
	public boolean open_state = false;  //��״̬
	public boolean close_state = false; //�ر�״̬
	public boolean open_false = false;  //�ٿ�
	public boolean close_false = false;  //�ٹ�
	public boolean open_fail = false;    //��ʧ��
	public boolean close_fail = false;   //�ر�ʧ��
	public boolean open_allow = false;   //����������
	public boolean close_allow = false;  //�ر���������
	public boolean enjoin = false;     //��ֹʹ��
	public boolean compelling = false;  //��ǿ��
	public boolean bmanual = false;    //�ֶ���

	public float aiData = 0;
	
	float ptX[] = new float[6];
	float ptY[] = new float[6];

	float rectX[] = new float[4];
	float rectY[] = new float[4];

	
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//ʹ�ÿ���ݹ���
		paint.setStyle(Paint.Style.FILL);

		//����·��
		Path path = new Path();
		
		rectX[0] = cx- rectWidth/2;
		rectY[0] = cy-rectHeight/2;
		rectX[1] = cx - rectWidth/2;
		rectY[1] = cy + rectHeight/2;
		rectX[2] = cx + rectWidth/2;
		rectY[2] = cy + rectHeight/2;
		rectX[3] = cx + rectWidth/2;
		rectY[3] = cy - rectHeight/2;
		int color = 0;
		canvas.save();
		canvas.rotate(-rotateAngle, cx, cy);  
		//���ڹ�
		if (closeing) {
			ptX[0] = (float) (rectWidth * (100 - aiData)/100.0 + cx-rectWidth/2);
			ptY[0] = (float) (rectHeight * (100 - aiData)/100.0 + cy - rectHeight/2);
			ptX[1] = (float) (rectWidth * (100 - aiData)/100.0 + cx-rectWidth/2);
			ptY[1] = (float) ((-rectHeight) * (100 - aiData)/100.0 + cy + rectHeight/2);
			ptX[2] = (float) (rectWidth/2 + cx);
			ptY[2] = (float) (rectHeight/2 + cy);
			ptX[3] = (float) (rectWidth/2 + cx);
			ptY[3] = (float) (cy - rectHeight/2);
				
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//�պ�·��
			//ѡ�񻭲�������java����˳ʱ��Ϊ����������˷���
		//	canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 128, 128, 128);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//����·��
		}
		//���ڿ�
		else if (opening) {
			ptX[0] = (float) (-rectWidth * (100 - aiData)/100.0 + cx+rectWidth/2);
			ptY[0] = (float) (-rectHeight * (100 - aiData)/100.0 + cy + rectHeight/2);
			ptX[1] = (float) (-rectWidth * (100 - aiData)/100.0 + cx+rectWidth/2);
			ptY[1] = (float) ((rectHeight) * (100 - aiData)/100.0 + cy - rectHeight/2);
			ptX[2] = (float) (cx - rectWidth/2);
			ptY[2] = (float) (cy - rectHeight/2);
			ptX[3] = (float) (cx - rectWidth/2);
			ptY[3] = (float) (cy + rectHeight/2);
				
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//�պ�·��
			//ѡ�񻭲�������java����˳ʱ��Ϊ����������˷���
		//	canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 0, 255, 0);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//����·��
		}
		//��״̬��ر�״̬ͬʱ����
		else if (open_state && close_state) {
			ptX[0] = (float) (cx - rectWidth/2);
			ptY[0] = (float) (cy - rectHeight/2);
			ptX[1] = (float) (cx - rectWidth/2);
			ptY[1] = (float) (cy + rectHeight/2);
			ptX[2] = (float) (cx + rectWidth/2);
			ptY[2] = (float) (cy + rectHeight/2);
			ptX[3] = (float) (cx + rectWidth/2);
			ptY[3] = (float) (cy - rectHeight/2);
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//�պ�·��
			//ѡ�񻭲�������java����˳ʱ��Ϊ����������˷���
		//	canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 255, 0, 0);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//����·��
			ptX[0] = ptX[0] - 2;
			ptY[0] = ptY[0] - 2;
			ptX[1] = ptX[1] - 2;
			ptY[1] = ptY[1] + 2;
			ptX[2] = ptX[2] + 2;
			ptY[2] = ptY[2] + 2;
			ptX[3] = ptX[3] + 2;
			ptY[3] = ptY[3] - 2;

			canvas.drawLine(ptX[0], ptY[0], ptX[1], ptY[1], paint);
			canvas.drawLine(ptX[1], ptY[1], ptX[2], ptY[2], paint);
			canvas.drawLine(ptX[2], ptY[2], ptX[3], ptY[3], paint);
			canvas.drawLine(ptX[3], ptY[3], ptX[0], ptY[0], paint);
		}
		//�ٹ�9
		else if (close_false) {
			ptX[0] = (float) (cx - rectWidth/2);
			ptY[0] = (float) (cy - rectHeight/2);
			ptX[1] = (float) (cx - rectWidth/2);
			ptY[1] = (float) (cy + rectHeight/2);
			ptX[2] = (float) (cx + rectWidth/2);
			ptY[2] = (float) (cy + rectHeight/2);
			ptX[3] = (float) (cx + rectWidth/2);
			ptY[3] = (float) (cy - rectHeight/2);
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//�պ�·��
			//ѡ�񻭲�������java����˳ʱ��Ϊ����������˷���
		//	canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 0, 128, 0);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//����·��
			ptX[0] = ptX[0] - 2;
			ptY[0] = ptY[0] - 2;
			ptX[1] = ptX[1] - 2;
			ptY[1] = ptY[1] + 2;
			ptX[2] = ptX[2] + 2;
			ptY[2] = ptY[2] + 2;
			ptX[3] = ptX[3] + 2;
			ptY[3] = ptY[3] - 2;
			color = Color.argb(255, 255, 0, 0);
			paint.setColor(color);
			canvas.drawLine(ptX[0], ptY[0], ptX[1], ptY[1], paint);
			canvas.drawLine(ptX[1], ptY[1], ptX[2], ptY[2], paint);
			canvas.drawLine(ptX[2], ptY[2], ptX[3], ptY[3], paint);
			canvas.drawLine(ptX[3], ptY[3], ptX[0], ptY[0], paint);
		}
		//�ٿ�10
		else if (open_false) {
			ptX[0] = (float) (cx - rectWidth/2);
			ptY[0] = (float) (cy - rectHeight/2);
			ptX[1] = (float) (cx - rectWidth/2);
			ptY[1] = (float) (cy + rectHeight/2);
			ptX[2] = (float) (cx + rectWidth/2);
			ptY[2] = (float) (cy + rectHeight/2);
			ptX[3] = (float) (cx + rectWidth/2);
			ptY[3] = (float) (cy - rectHeight/2);
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//�պ�·��
			//ѡ�񻭲�������java����˳ʱ��Ϊ����������˷���
		//	canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 64, 64, 64);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//����·��
			ptX[0] = ptX[0] - 2;
			ptY[0] = ptY[0] - 2;
			ptX[1] = ptX[1] - 2;
			ptY[1] = ptY[1] + 2;
			ptX[2] = ptX[2] + 2;
			ptY[2] = ptY[2] + 2;
			ptX[3] = ptX[3] + 2;
			ptY[3] = ptY[3] - 2;
			color = Color.argb(255, 255, 0, 0);
			paint.setColor(color);
			canvas.drawLine(ptX[0], ptY[0], ptX[1], ptY[1], paint);
			canvas.drawLine(ptX[1], ptY[1], ptX[2], ptY[2], paint);
			canvas.drawLine(ptX[2], ptY[2], ptX[3], ptY[3], paint);
			canvas.drawLine(ptX[3], ptY[3], ptX[0], ptY[0], paint);
		}
		//��״̬
		else if (open_state) {
			ptX[0] = (float) (cx - rectWidth/2);
			ptY[0] = (float) (cy - rectHeight/2);
			ptX[1] = (float) (cx - rectWidth/2);
			ptY[1] = (float) (cy + rectHeight/2);
			ptX[2] = (float) (cx + rectWidth/2);
			ptY[2] = (float) (cy + rectHeight/2);
			ptX[3] = (float) (cx + rectWidth/2);
			ptY[3] = (float) (cy - rectHeight/2);
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//�պ�·��
			//ѡ�񻭲�������java����˳ʱ��Ϊ����������˷���
			//canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 0, 255, 0);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//����·��
		}
		//��״̬
		else if (close_state) {
			ptX[0] = (float) (cx - rectWidth/2);
			ptY[0] = (float) (cy - rectHeight/2);
			ptX[1] = (float) (cx - rectWidth/2);
			ptY[1] = (float) (cy + rectHeight/2);
			ptX[2] = (float) (cx + rectWidth/2);
			ptY[2] = (float) (cy + rectHeight/2);
			ptX[3] = (float) (cx + rectWidth/2);
			ptY[3] = (float) (cy - rectHeight/2);
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//�պ�·��
			//ѡ�񻭲�������java����˳ʱ��Ϊ����������˷���
			//canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 192, 192, 192);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//����·��
		}
		//��ʧ��
		else if (open_fail) {
			
			ptX[0] = (float) (-rectWidth * (100 - 80)/100.0 + cx+rectWidth/2);
			ptY[0] = (float) (-rectHeight * (100 - 80)/100.0 + cy + rectHeight/2);
			ptX[1] = (float) (-rectWidth * (100 - 80)/100.0 + cx+rectWidth/2);
			ptY[1] = (float) ((rectHeight) * (100 - 80)/100.0 + cy - rectHeight/2);
			ptX[2] = (float) (cx - rectWidth/2);
			ptY[2] = (float) (cy - rectHeight/2);
			ptX[3] = (float) (cx - rectWidth/2);
			ptY[3] = (float) (cy + rectHeight/2);
				
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//�պ�·��
			//ѡ�񻭲�������java����˳ʱ��Ϊ����������˷���
			//canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 0, 255, 0);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//����·��
		}
		//�ر�ʧ��
		else if (close_fail) {
			ptX[0] = (float) (rectWidth * (100 - 80)/100.0 + cx-rectWidth/2);
			ptY[0] = (float) (rectHeight * (100 - 80)/100.0 + cy - rectHeight/2);
			ptX[1] = (float) (rectWidth * (100 - 80)/100.0 + cx-rectWidth/2);
			ptY[1] = (float) ((-rectHeight) * (100 - 80)/100.0 + cy + rectHeight/2);
			ptX[2] = (float) (rectWidth/2 + cx);
			ptY[2] = (float) (rectHeight/2 + cy);
			ptX[3] = (float) (rectWidth/2 + cx);
			ptY[3] = (float) (cy - rectHeight/2);
				
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//�պ�·��
			//ѡ�񻭲�������java����˳ʱ��Ϊ����������˷���
			//canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 128, 128, 128);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//����·��
		}
		//����������
		else if (open_allow) {
			ptX[0] = (float) (-rectWidth * (100 - 70)/100.0 + cx+rectWidth/2);
			ptY[0] = (float) (-rectHeight * (100 - 70)/100.0 + cy + rectHeight/2);
			ptX[1] = (float) (-rectWidth * (100 - 70)/100.0 + cx+rectWidth/2);
			ptY[1] = (float) ((rectHeight) * (100 - 70)/100.0 + cy - rectHeight/2);
			ptX[2] = (float) (cx - rectWidth/2);
			ptY[2] = (float) (cy - rectHeight/2);
			ptX[3] = (float) (cx - rectWidth/2);
			ptY[3] = (float) (cy + rectHeight/2);
				
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//�պ�·��
			//ѡ�񻭲�������java����˳ʱ��Ϊ����������˷���
			//canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 0, 128, 0);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//����·��
		}
		//ֹͣ��������
		else if (close_allow) {
			ptX[0] = (float) (rectWidth * (100 - 70)/100.0 + cx-rectWidth/2);
			ptY[0] = (float) (rectHeight * (100 - 70)/100.0 + cy - rectHeight/2);
			ptX[1] = (float) (rectWidth * (100 - 70)/100.0 + cx-rectWidth/2);
			ptY[1] = (float) ((-rectHeight) * (100 - 70)/100.0 + cy + rectHeight/2);
			ptX[2] = (float) (rectWidth/2 + cx);
			ptY[2] = (float) (rectHeight/2 + cy);
			ptX[3] = (float) (rectWidth/2 + cx);
			ptY[3] = (float) (cy - rectHeight/2);
				
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//�պ�·��
			//ѡ�񻭲�������java����˳ʱ��Ϊ����������˷���
			//canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 64, 64, 64);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//����·��
		}
		else {
			ptX[0] = (float) (rectWidth * (100 - 80)/100.0 + cx-rectWidth/2);
			ptY[0] = (float) (rectHeight * (100 - 80)/100.0 + cy - rectHeight/2);
			ptX[1] = (float) (rectWidth * (100 - 80)/100.0 + cx-rectWidth/2);
			ptY[1] = (float) ((-rectHeight) * (100 - 80)/100.0 + cy + rectHeight/2);
			ptX[2] = (float) (rectWidth/2 + cx);
			ptY[2] = (float) (rectHeight/2 + cy);
			ptX[3] = (float) (rectWidth/2 + cx);
			ptY[3] = (float) (cy - rectHeight/2);
				
			path.moveTo(ptX[0], ptY[0]);
			path.lineTo(ptX[2], ptY[2]);
			path.lineTo(ptX[3], ptY[3]);
			path.lineTo(ptX[1], ptY[1]);
			path.close();//�պ�·��
			//ѡ�񻭲�������java����˳ʱ��Ϊ����������˷���
			//canvas.rotate(-rotateAngle, cx, cy);  
			color = Color.argb(255, 0, 128, 128);
			paint.setColor(color);
			canvas.drawPath(path, paint);	//����·��
		}
		
		//��բ����

		if (enjoin) {
			color = Color.argb(255, 128, 128, 128);
		}
		else if (close_fail || compelling) {
			color = Color.argb(255, 255, 0, 0);
		}
		else if (open_allow || close_allow) {
			color = Color.argb(255, 0, 255, 255);
		}
		else {
			color = Color.argb(255, 139, 139, 139);
		}
		ptX[0] = (float) (cx - rectWidth/2);
		ptY[0] = (float) (cy - rectHeight/2);
		ptX[1] = (float) (cx - rectWidth/2);
		ptY[1] = (float) (cy + rectHeight/2);
		ptX[2] = (float) (cx + rectWidth/2);
		ptY[2] = (float) (cy + rectHeight/2);
		ptX[3] = (float) (cx + rectWidth/2);
		ptY[3] = (float) (cy - rectHeight/2);
		paint.setColor(color);
		canvas.drawLine(ptX[0], ptY[0], ptX[2], ptY[2], paint);
		canvas.drawLine(ptX[1], ptY[1], ptX[3], ptY[3], paint);
		canvas.drawLine(ptX[2], ptY[2], ptX[3], ptY[3], paint);
		canvas.drawLine(ptX[0], ptY[0], ptX[1], ptY[1], paint);

		//�豸��ǿ��
		if (compelling) {
			color = Color.argb(255, 255, 0, 0);
			paint.setColor(color);
			canvas.drawLine(ptX[0], ptY[0], ptX[1], ptY[1], paint);
			canvas.drawLine(ptX[1], ptY[1], ptX[2], ptY[2], paint);
			canvas.drawLine(ptX[2], ptY[2], ptX[3], ptY[3], paint);
			canvas.drawLine(ptX[3], ptY[3], ptX[0], ptY[0], paint);
		}
		//�ֶ���
		if (bmanual) {
			ptX[4] = cx;
			ptY[4] = cy;
			ptX[5] = cx;
			ptY[5] = (float) (cy - rectHeight * (0.7));
			color = Color.argb(255, 128, 128, 128);
			paint.setColor(color);
			canvas.drawLine(ptX[4], ptY[4], ptX[5], ptY[5], paint);
			canvas.drawCircle(ptX[5], ptY[5], 2, paint);
		}
		canvas.restore();

	}
}
