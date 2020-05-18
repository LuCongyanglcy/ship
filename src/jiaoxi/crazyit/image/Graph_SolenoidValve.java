package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;

//��Բ�ε�
public class Graph_SolenoidValve {
	public float cx = 250;  //���ĵ�X
	public float cy = 250;  //���ĵ�Y
	public float rectWidth = 40;
	public float rectHeight = 40;
	public boolean blink_sign = false;  // ��־λ��������
	public boolean electricity = false;  //��ŷ��õ�
	public boolean conditional_electricity = false;  //��ŷ��������õ�
	public boolean adjustable = false;  //��ŷ��������õ�

	
	public float rectX[] = new float[4];
	public float rectY[] = new float[4];
	
	public void drawGraph(Canvas canvas) {
		 int color =Color.GREEN;
	
		canvas.save();//���浱ǰ����״̬
	     canvas.translate(cx, cy);//�ı�����ϵԭ��
	     
	 	Paint paint = new Paint();
		paint.setAntiAlias(true);		//ʹ�ÿ���ݹ���
		paint.setStrokeWidth(3); // ���û��ʵĿ��
		paint.setStyle(Style.FILL);
	
		float circle=(float)Math.sqrt((rectWidth/2)*(rectWidth/2)+(rectHeight/2)*(rectHeight/2));
		if(electricity){
			paint.setStyle(Style.FILL);
			paint.setColor( Color.WHITE);
			canvas.drawCircle(0,0,(circle*40/100), paint);
		}
	   if(conditional_electricity){
			paint.setStyle(Style.STROKE);
			paint.setColor( Color.WHITE);
			canvas.drawCircle(0,0,(circle*40/100), paint);
		}
	   if(adjustable){
			paint.setColor( Color.GRAY);
			canvas.drawLine(-rectWidth*45/100,-rectHeight*45/100,rectWidth*45/100,rectHeight*45/100,paint);
			canvas.drawLine(-rectWidth*45/100,rectHeight*45/100,rectWidth*45/100,-rectHeight*45/100,paint);
		}
		

		if(blink_sign){
		paint.setColor(color);
		paint.setStyle(Style.FILL);
		canvas.drawCircle(0,0,(circle*40/100), paint);
//		else paint.setColor( Color.argb(255, 192, 192, 192));
//		canvas.drawRect(-rectWidth/2,-rectHeight/2,rectWidth/2,rectHeight/2,paint);
//		canvas.drawRoundRect(new RectF(-rectWidth/2,-rectHeight/2,rectWidth/2,rectHeight/2),rectWidth*2/100, rectWidth*2/100, paint);//�ڶ���������x�뾶��������������y�뾶    
		}
		
		canvas.restore();	//�ָ�ԭ������״̬
	}
}
