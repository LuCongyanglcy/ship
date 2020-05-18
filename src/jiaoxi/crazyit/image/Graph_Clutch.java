package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
//�����
public class Graph_Clutch {
	public float cx = 70;  //���ĵ�X
	public float cy = 250;  //���ĵ�Y
	public float rectWidth = 30;   //���ο��
	public float rectHeight = 50;   //���θ߶�
	public boolean RTU=false;   //ң��
	public boolean running=false;   //����״̬
	public boolean stop=false;   //����ֹͣ
	public float aiData = 0;
	public float distance = 1;//���ż�ľ����
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//ʹ�ÿ���ݹ���
		canvas.save();
		canvas.translate(cx, cy);//�ı�����ϵԭ��
		if(running) distance=0.7f;
		paint.setColor(Color.WHITE);//������Χ�׷���
		 paint.setStrokeWidth(2*rectWidth/5);
		 canvas.drawLines(new float[]{-3*distance*rectWidth/10,-rectHeight/2,-3*distance*rectWidth/10,rectHeight/2}, paint);
		 canvas.drawLines(new float[]{3*distance*rectWidth/10,-rectHeight/2,3*distance*rectWidth/10,rectHeight/2}, paint);
	    int color=0;
		if(running) color=Color.GREEN;
		else if(stop)color=Color.GRAY;
		else if(RTU)color=Color.RED;
		else color=Color.RED;
		paint.setColor(color);//�����м��ɫС����
		paint.setStrokeWidth(rectWidth/5);
		canvas.drawLines(new float[]{-3*distance*rectWidth/10,-rectHeight/2+rectWidth/7,-3*distance*rectWidth/10,rectHeight/2-rectWidth/7}, paint);
		canvas.drawLines(new float[]{3*distance*rectWidth/10,-rectHeight/2+rectWidth/7,3*distance*rectWidth/10,rectHeight/2-rectWidth/7}, paint);
		 canvas.restore();	//�ָ�ԭ������״̬ 
	}
}
