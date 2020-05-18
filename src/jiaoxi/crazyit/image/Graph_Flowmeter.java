package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Paint.Style;

//���ưڿ�
public class Graph_Flowmeter {
	public float cx = 950; // ���ĵ�X
	public float cy = 550; // ���ĵ�Y
	public float Circle = 800; // Բ��뾶
	public float staff = -38.4f;// �ܶȱ���ֵ
	public float higherDepth=40;   //��߾�����
	public float underDepth=-40;     //��;�����
	private int color = Color.RED;
	

	public void drawxx(Canvas canvas,float scale,int color){//������ͷ
		canvas.save(); 
		Paint paint = new Paint();
		Path path = new Path();
		paint.setColor(color);
		paint.setAntiAlias(true); // ʹ�ÿ���ݹ���
		paint.setStyle(Style.FILL);
		
		canvas.rotate(scale);
		path.moveTo(-10, -Circle-15-30);
		path.lineTo(10, -Circle-15-30);
		path.lineTo(0,-Circle+5-30);
		path.close();
		canvas.drawPath(path, paint);
		canvas.restore();
	}
	public void drawxxs(Canvas canvas,float scale){//��ǰ
		canvas.save(); 
		Paint paint = new Paint();
		Path path = new Path();
		paint.setColor(Color.GREEN);
		paint.setAntiAlias(true); // ʹ�ÿ���ݹ���
		paint.setStyle(Style.FILL);
		
		canvas.rotate(scale);
		path.moveTo(-10, -Circle-15-30);
		path.lineTo(10, -Circle-15-30);
		path.lineTo(0,-Circle+5-30);
		path.close();
		String str = scale+"";
		canvas.drawPath(path, paint);
		
		paint.setTextSize(25);
		paint.setColor(Color.YELLOW);
		canvas.drawText(str, -20, -Circle+5-60, paint);
		canvas.restore();
	}
	public void drawx(Canvas canvas){//���
		canvas.save(); 
		Paint paint = new Paint();
		paint.setAntiAlias(true); // ʹ�ÿ���ݹ���
		paint.setStyle(Style.FILL);
		
		canvas.rotate(45);
		String str = 45+"";
		paint.setTextSize(25);
		paint.setColor(Color.YELLOW);
		canvas.drawText(str, -20, -Circle+60, paint);
		
		canvas.rotate(-90);
		str = -45+"";
		paint.setTextSize(25);
		paint.setColor(Color.YELLOW);
		canvas.drawText(str, -20, -Circle+60, paint);
		canvas.restore();
	}

	public void drawGraph(Canvas canvas) {
		canvas.save();
		canvas.translate(cx, cy); // �ı�����ϵԭ��
		Paint paint = new Paint();
		paint.setAntiAlias(true); // ʹ�ÿ���ݹ���

		
		

		paint.setStyle(Style.STROKE);
		RectF oval001 = new RectF(-Circle, -Circle, Circle, Circle);// ���ø��µĳ����Σ�ɨ�����
		
		paint.setColor(Color.GREEN);
		paint.setStrokeWidth(Circle / 400);
		for (int i = 1; i <= (11); i++) {
			float sin01 = (float)Math.sin((3.14159*i*9+113)/180);// �̶�
			float cos01 = (float)Math.cos((3.14159*i*9+113)/180);
			canvas.drawLine(-98*Circle*cos01/100, -98*Circle*sin01/100,
							-100*Circle*cos01/100, -100*Circle*sin01/100, paint);
		}
		color=Color.RED;
		drawxx(canvas,-45,color);
		drawxx(canvas,45,color);//���Ƕ�
		color=Color.BLUE;
		drawxx(canvas,higherDepth,color);//������
		drawxx(canvas,underDepth,color);
		color=Color.GREEN;
		drawxxs(canvas,staff);//��ǰ�Ƕ�
		drawx(canvas);
		
		
		paint.setStrokeWidth(Circle / 200);
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.GREEN);
		canvas.drawArc(oval001, -135, 90, false, paint);//�ܶȱ���
		
		
		// ��;����� <= ��������ֵ <= ��߾�����
		if(underDepth<= staff && staff<=higherDepth) paint.setColor(Color.GREEN);
		else paint.setColor(Color.RED);
		if(staff > 45) staff = 45;
		if(staff < -45) staff = -45;

		
		RectF oval002 = new RectF(-Circle*101/99, -Circle*101/99, Circle*101/99, Circle*101/99);// ���ø��µĳ����Σ�ɨ�����
		canvas.drawArc(oval002, -90,staff, false,paint);//����PLC״̬���ܶȱ�״̬

		canvas.restore(); // �ָ�ԭ������״̬
	}
}
