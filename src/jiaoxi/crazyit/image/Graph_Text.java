package jiaoxi.crazyit.image;

import java.text.DecimalFormat;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;

public class Graph_Text {
	public int defaultColor = Color.argb(255, 255, 255, 0);  //文字默认颜色
	public int statusColor = Color.argb(255,255, 0, 0);  //状态时文本颜色
	
	public boolean dbgColor = false;//是否显示背景颜色
	public int bgColor = Color.BLACK;//背景颜色
	public int textColor = Color.WHITE;//文本颜色
	
	public boolean bStatus = false;  //状态
	public int cx = 50;  //起点X
	public int cy = 50;  //起点Y
	public float sValue = 0;
	public String sText = "";
	public boolean bText = false; //是否显示数值
	public int textSize = 10;
	public int format = 0;
	public boolean isFont_right = false;//字体对齐方式
	public boolean isFont_center = false;
	public boolean isFont_center2 = false;
	public String unitText ="";
	
	public void drawGraph(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true); // 使用抗锯齿功能
		paint.setStyle(Style.FILL);
		if (isFont_right) {
			paint.setTextAlign(Paint.Align.RIGHT);
		}
		if(isFont_center||isFont_center2){
			paint.setTextAlign(Paint.Align.CENTER);
		}
		paint.setColor(defaultColor);
		paint.setTextSize(textSize);
		String sShowView = "";
		if (bText == true) {
			if (bStatus) {
				paint.setColor(statusColor);
				canvas.drawText(sText, cx, cy, paint);
			}else{
				paint.setColor(Color.WHITE);
				if(dbgColor){
					Rect bounds = new Rect();
					paint.getTextBounds(sText, 0, sText.length(), bounds);
					float textWidth = bounds.width();
					float textHeight = bounds.height();
					
					paint.setColor(bgColor);
					if(isFont_right){
						canvas.drawRect((float) (cx-textSize/10-textWidth), cy-textSize, cx+textSize/2, cy+textSize/4, paint);
					}else if(isFont_center){
						canvas.drawRect(cx-textSize,cy-textSize,(float) (cx+textSize*1.5),cy+textSize/4, paint);
					}else if(isFont_center2){
						canvas.drawRect(cx-textSize/3,cy-textSize,(float) (cx+textSize/1.33),cy+textSize/4, paint);
					}else if(isFont_right==false){
						canvas.drawRect(cx, cy-textSize, (float) (cx+textWidth+textSize/1.7), cy+textSize/4, paint);
					}
					paint.setColor(textColor);
					canvas.drawText(sText,cx+textSize/4, cy, paint);
				}else{
					canvas.drawText(sText, cx, cy-textSize/2, paint);
				}
			}
		}
		else {
			switch (format) {
			case 0:{
				DecimalFormat fnum = new DecimalFormat("0");
				sShowView = fnum.format(sValue);
			}
			break;
			case 1: {
				DecimalFormat fnum = new DecimalFormat("0.0");
				sShowView = fnum.format(sValue);
			}
			break;
			case 2: {
				DecimalFormat fnum = new DecimalFormat("0.00");
				sShowView = fnum.format(sValue);
			}
			break;
			default : {
				DecimalFormat fnum = new DecimalFormat("0.000");
				sShowView = fnum.format(sValue);
			}
			break;
			}
			sText = sShowView  + unitText;
			canvas.drawText(sShowView, cx, cy, paint);

			
			
			if (bStatus) {
				paint.setColor(statusColor);
				canvas.drawText(sShowView, cx, cy, paint);
			}
		}
	}
	public int getTextWidth(String text, Paint paint) { 
		Rect bounds = new Rect();
		paint.getTextBounds(text, 0, text.length(), bounds);
		int width = bounds.left + bounds.width();
		return width;
		}
	public int getTextHeight(String text, Paint paint) { 
		Rect bounds = new Rect();
		paint.getTextBounds(text, 0, text.length(), bounds);
		int height = bounds.bottom + bounds.height();
		return height;
		}
	
	

}