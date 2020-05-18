package jiaoxi.crazyit.image;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Paint.Style;
//���
public class Graph_Textcircle {
	public float cx = 950;   //���ĵ�X
	public float cy = 150;  //���ĵ�Y
	public float rectWidth=50;  //������ο�
	public float rectHight=50;  //������ο�
	public boolean ifcolor=false;   //�ж���ɫ�Ƿ�Ϊ��ɫ
	public String string="G";  //�м��ı�����
	public float aiData = 0;  //��ʱ��
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//ʹ�ÿ���ݹ���
		canvas.save();
		canvas.translate(cx, cy);  //�ı�����ϵԭ��
		 int color=0;//Ȧ����ɫ
			if(ifcolor) color=Color.GREEN;
			else color=Color.GRAY;
			paint.setColor(color);
		    paint.setStrokeWidth(rectWidth/20);//x����������ϸ
		    
		    paint.setStyle(Style.STROKE);
		    RectF oval002 = new RectF(-rectWidth/2,-rectHight/2, rectWidth/2, rectHight/2);
		      canvas.drawArc(oval002, 0, 360, false, paint);
			paint.setColor(color);
			paint.setStyle(Style.FILL);
			paint.setTypeface(Typeface.SERIF );
			paint.setTextSize(5*rectWidth/8);
			canvas.drawText(string, -3*rectWidth/10, rectWidth/4, paint);
			 canvas.restore();	//�ָ�ԭ������״̬
	}
}
