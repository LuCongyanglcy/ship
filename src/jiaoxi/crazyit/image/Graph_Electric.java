package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;

public class Graph_Electric {
	public float cx = 950;   //���ĵ�X
	public float cy = 150;  //���ĵ�Y
	public float circle=50;  //����Բ�İ뾶
	public boolean ifcolor=true;   //�ж���ɫ�Ƿ�Ϊ��ɫ
	public String string="G";  //�м��ı�����
	public float aiData = 0;  //��ʱ��
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);		//ʹ�ÿ���ݹ���
		canvas.save();
		canvas.translate(cx, cy);  //�ı�����ϵԭ��
		 int color=0;//Ȧ����ɫ
			if(ifcolor) color=Color.GRAY;
			else color=Color.RED;
			paint.setColor(color);
		    paint.setStrokeWidth(circle/10);//x����������ϸ
			paint.setStyle(Style.STROKE);
			canvas.drawCircle(0,0,circle, paint); //����һ��������Բ
			paint.setColor(color);
			paint.setStyle(Style.FILL);
			paint.setTypeface(Typeface.SERIF );
			paint.setTextSize(5*circle/4);
			canvas.drawText(string, -3*circle/5, circle/2, paint);
			canvas.restore();	//�ָ�ԭ������״̬
	}
}
