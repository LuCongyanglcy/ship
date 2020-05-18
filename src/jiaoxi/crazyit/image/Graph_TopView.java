package jiaoxi.crazyit.image;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

public class Graph_TopView {

	public Graph_TopView() {
		// TODO Auto-generated constructor stub
	}
	public float cx = 250;  //中心点X
	public float cy = 200;  //中心点Y
	public float width = 400;   //矩形宽度
	public float height = 200;  //矩形高度
	public float DragMidDistance=5;//耙中距离
	public float DragHeadDistance=10;//耙头距离
	public float DragArm1x=0;//第一节耙臂X坐标
	public float DragArm1y;//第一节耙臂Y坐标
	public float DragArm2x;//第二节耙臂X坐标
	public float DragArm2y;//第二节耙臂Y坐标
	public float Elbowx;//弯管X坐标
	public float Elbowy;//弯管Y坐标
	public float DragHeadx;//耙头X坐标
	public float DragHeady;//耙头Y坐标
	public float TotalLength;//耙管总长度
	public float maxValue =10;//最大量程
	public float minValue =-10;//最小量程
	public float Radius;//耙管半径
	public int average = 0;//刻度尺平均分成几分
	public boolean direction=false;//是否翻转
	public boolean vertical =true;//是否垂直
	public boolean zuopa=false;//是否左耙
	public void drawGraph(Canvas canvas){
		canvas.translate(cx,cy);//设置绘图原点坐标
		Rect rect=new Rect((int)(-width/2),(int)(-height/2),(int)(width/2),(int)(height/2));//定义矩形区域
		Paint paintred=new Paint();//耙头红色画笔
		paintred.setAntiAlias(true);		//使用抗锯齿功能
		paintred.setColor(Color.RED);
		Paint paintyellow=new Paint();//耙臂黄色画笔
		paintyellow.setAntiAlias(true);		//使用抗锯齿功能
		paintyellow.setColor(Color.YELLOW);
		Paint paintgray=new Paint();//坐标轴和刻度字符画笔
		paintgray.setAntiAlias(true);		//使用抗锯齿功能
		paintgray.setColor(Color.GRAY);
		Paint painthe=new Paint();//耙头棕色画笔
		painthe.setAntiAlias(true);		//使用抗锯齿功能
		painthe.setColor(Color.rgb(153,153,51));
		Paint paintgreen=new Paint();//耙头绿色画笔
		paintgreen.setAntiAlias(true);//使用抗锯齿功能
		paintgreen.setColor(Color.GREEN);
		if((maxValue==0)&&(minValue==0)){//默认的量程和刻度,默认为10和-10；
			maxValue=10;
			minValue=-10;
		}
		if(average==0){//默认比例尺分成2份
			average=2;
		}
		int averageKD;//刻度
		int TopValue,BottomValue;//刻度尺最高点最低点位置
		TopValue=rect.bottom-(int)(0.9*height);
		BottomValue=rect.bottom-(int)(0.1*height);
		if(vertical){
			canvas.save();//锁定画布
			canvas.rotate(90);//画布旋转90度
			canvas.drawLine((float)(rect.right-0.1*width), TopValue, (float)(rect.right-0.1*width), BottomValue, paintgray);//绘制比例尺线段
			Point ChangePoint =new Point(0,0);
			for(int i=0;i<(average+1);i++){//绘制刻度尺
				averageKD=TopValue+i*(int)(0.8*height)/average;
				ChangePoint.x=rect.right-(int)(0.1*width)+5;//每个刻度线的长度
				ChangePoint.y=averageKD;//每个刻度线的高度
				canvas.drawLine((float)(rect.right-0.1*width),averageKD,ChangePoint.x,ChangePoint.y,paintgray);//绘制刻度线
				Rect TextRect = new Rect();//刻度线上面的刻度字体所在的矩形
				TextRect.left=ChangePoint.x;
				TextRect.right=rect.right;
				TextRect.top=averageKD-7;
				TextRect.bottom=averageKD+7;
				if(direction){//判断是否翻转
					String changetostring=String.valueOf(minValue+i*(maxValue-minValue)/average);
					canvas.drawText(changetostring, TextRect.left, averageKD, paintgray);//显示刻度文本
				}
				else{
					String changetostring=String.valueOf(-(minValue+i*(maxValue-minValue)/average));
					canvas.drawText(changetostring, TextRect.left, averageKD, paintgray);//显示刻度文本
				}
		}
			canvas.drawLine(rect.left, (rect.top+rect.bottom)/2, (float)(rect.left+0.9*width),  (rect.top+rect.bottom)/2, paintgray);//绘制水平横线
			double base;//比例尺的一个单位长度
			base=0.4*height/maxValue;
			Radius=(float) (0.5*base);//耙管半径等于0.5个单位
			Point XikouPoint=new Point((int) (rect.left+0.05*width),(rect.top+rect.bottom)/2);//吸口点的坐标
			Point Pati[]=new Point[14];//耙臂坐标数组
			if(direction){
				DragArm1x=(int)((DragArm1x/TotalLength)*0.75*width+XikouPoint.x);//第一节耙臂X坐标
				DragArm1y=(int)(DragArm1y*base+XikouPoint.y);//第一节耙臂Y坐标
				DragArm2x=(int)((DragArm2x/TotalLength)*0.75*width+XikouPoint.x);//第二节耙臂X坐标
				DragArm2y=(int)(DragArm2y*base+XikouPoint.y);//第二节耙臂Y坐标
				Elbowx=(int)((Elbowx/TotalLength)*0.75*width+XikouPoint.x);//弯管X坐标
				Elbowy=(int)(Elbowy*base+XikouPoint.y);//弯管Y坐标
				DragHeadx=(int)((DragHeadx/TotalLength)*0.75*width+XikouPoint.x);//耙头X坐标
				DragHeady=(int)(DragHeady*base+XikouPoint.y);//耙头Y坐标
				Pati[0]=new Point((int) (XikouPoint.x-Radius),XikouPoint.y);//耙臂坐标数组
				Pati[1]=new Point((int) (XikouPoint.x+Radius),XikouPoint.y);
				Pati[2]=new Point((int) (XikouPoint.x+Radius),(int) (Elbowy-Radius));
				Pati[3]=new Point((int) Elbowx,(int) (Elbowy-Radius));
				Pati[4]=new Point((int) (DragArm1x),(int) (DragArm1y-Radius));
				Pati[5]=new Point((int) (DragArm2x),(int) (DragArm2y-Radius));
				Pati[6]=new Point((int)(DragHeadx-0.05*width),(int) (DragHeady-3*Radius));
				Pati[7]=new Point((int)(DragHeadx),(int)(DragHeady-3*Radius));
				Pati[8]=new Point((int)(DragHeadx),(int)(DragHeady+3*Radius));
				Pati[9]=new Point((int)(DragHeadx-0.05*width),(int)(DragHeady+3*Radius));
				Pati[10]=new Point((int) (DragArm2x),(int)(DragArm2y+Radius));
				Pati[11]=new Point((int) (DragArm1x),(int)(DragArm1y+Radius));
				Pati[12]=new Point((int) Elbowx,(int)(Elbowy+Radius));
				Pati[13]=new Point((int)(XikouPoint.x-Radius),(int)(Elbowy+Radius));
			}
			else
			{
				DragArm1x=(int)(DragArm1x/TotalLength*0.75*width+XikouPoint.x);//第一节耙臂X坐标
				DragArm1y=(int)(XikouPoint.y-DragArm1y*base);//第一节耙臂Y坐标
				DragArm2x=(int)(DragArm2x/TotalLength*0.75*width+XikouPoint.x);//第二节耙臂X坐标
				DragArm2y=(int)(XikouPoint.y-DragArm2y*base);//第二节耙臂Y坐标
				Elbowx=(int)(Elbowx/TotalLength*0.75*width+XikouPoint.x);//弯管X坐标
				Elbowy=(int)(XikouPoint.y-Elbowy*base);//弯管Y坐标
				DragHeadx=(int)(DragHeadx/TotalLength*0.75*width+XikouPoint.x);//耙头X坐标
				DragHeady=(int)(XikouPoint.y-DragHeady*base);//耙头Y坐标
				Pati[0]=new Point((int) (XikouPoint.x-Radius),XikouPoint.y);//耙臂坐标数组
				Pati[1]=new Point((int) (XikouPoint.x+Radius),XikouPoint.y);
				Pati[2]=new Point((int) (XikouPoint.x+Radius),(int) (Elbowy+Radius));
				Pati[3]=new Point((int) Elbowx,(int) (Elbowy+Radius));
				Pati[4]=new Point((int) (DragArm1x),(int) (DragArm1y+Radius));
				Pati[5]=new Point((int) (DragArm2x),(int) (DragArm2y+Radius));
				Pati[6]=new Point((int)(DragHeadx-0.05*width),(int) (DragHeady+3*Radius));
				Pati[7]=new Point((int)(DragHeadx),(int)(DragHeady+3*Radius));
				Pati[8]=new Point((int)(DragHeadx),(int)(DragHeady-3*Radius));
				Pati[9]=new Point((int)(DragHeadx-0.05*width),(int) (DragHeady-3*Radius));
				Pati[10]=new Point((int) (DragArm2x),(int)(DragArm2y-Radius));
				Pati[11]=new Point((int) (DragArm1x),(int)(DragArm1y-Radius));
				Pati[12]=new Point((int) Elbowx,(int)(Elbowy-Radius));
				Pati[13]=new Point((int)(XikouPoint.x-Radius),(int)(Elbowy-Radius));
			}
			Rect MidTextRect = new Rect();//显示耙中参数的矩形
			if(direction){
				MidTextRect.left=(int) (DragArm1x-10);
				MidTextRect.right=(int) (DragArm1x+10);
				MidTextRect.top=Pati[11].y+10;
				MidTextRect.bottom=MidTextRect.top+10;
			}
			else{
				MidTextRect.left=(int) (DragArm1x)-10;
				MidTextRect.right=(int) (DragArm1x)+10;
				MidTextRect.bottom=(int)(Pati[11].y)-10;
				MidTextRect.top=(int) (MidTextRect.bottom-10);
			}
			String Midtostring=String.valueOf(DragMidDistance);//将耙中参数转化成String
			canvas.drawText(Midtostring, MidTextRect.left, MidTextRect.top, paintgray);//显示耙中参数
			Rect PtyTextRect = new Rect();//显示耙头参数的矩形
			if(direction){
				PtyTextRect.left=(int) (DragHeadx-10);
				PtyTextRect.right=(int) (DragHeadx+10);
				PtyTextRect.bottom=Pati[8].y+10;
				PtyTextRect.top=Pati[8].y+20;	
			}
			else{
				PtyTextRect.left=(int) (DragHeadx-10);
				PtyTextRect.right=(int) (DragHeadx+10);
				PtyTextRect.bottom=Pati[8].y-10;
				PtyTextRect.top=Pati[8].y-20;	
			}
			String Ptytostring=String.valueOf(DragHeadDistance);//将耙头参数转化成String
			canvas.drawText(Ptytostring,PtyTextRect.left,PtyTextRect.top, paintgray);//显示耙头参数
			Path pathwan=new Path();//绘制弯管path
			pathwan.moveTo(Pati[0].x,Pati[0].y);
			pathwan.lineTo(Pati[1].x,Pati[1].y);
			pathwan.lineTo(Pati[2].x,Pati[2].y);
			pathwan.lineTo(Pati[3].x,Pati[3].y);
			pathwan.lineTo(Pati[12].x,Pati[12].y);
			pathwan.lineTo(Pati[13].x,Pati[13].y);
			pathwan.close();
			canvas.drawPath(pathwan, paintyellow);
			Path pathyi=new Path();//绘制第一节耙管path
			pathyi.moveTo(Pati[3].x,Pati[3].y);
			pathyi.lineTo(Pati[4].x, Pati[4].y);
			pathyi.lineTo(Pati[11].x, Pati[11].y);
			pathyi.lineTo(Pati[12].x,Pati[12].y);
			pathyi.close();
			canvas.drawPath(pathyi, paintyellow);
			Path pather=new Path();//绘制第二节耙管path
			pather.moveTo(Pati[4].x, Pati[4].y);
			pather.lineTo(Pati[5].x, Pati[5].y);
			pather.lineTo(Pati[10].x,Pati[10].y);
			pather.lineTo(Pati[11].x,Pati[11].y);
			pather.close();
			canvas.drawPath(pather, paintyellow);
			Path pathpatou=new Path();//绘制耙头path
			pathpatou.moveTo(Pati[5].x, Pati[5].y);
			pathpatou.lineTo(Pati[6].x,Pati[6].y);
			pathpatou.lineTo(Pati[7].x,Pati[7].y);
			pathpatou.lineTo(Pati[8].x,Pati[8].y);
			pathpatou.lineTo(Pati[9].x,Pati[9].y);
			pathpatou.lineTo(Pati[10].x,Pati[10].y);
			pathpatou.close();
			canvas.drawPath(pathpatou, painthe);
			Path pathpafu=new Path();//绘制耙头覆盖的红色path
			pathpafu.moveTo(Pati[6].x, Pati[6].y);
			pathpafu.lineTo(Pati[7].x-1,Pati[7].y);
			pathpafu.lineTo(Pati[8].x-1,Pati[8].y);
			pathpafu.lineTo(Pati[9].x, Pati[9].y);
			pathpafu.close();
			if(zuopa){
				canvas.drawPath(pathpafu, paintred);
			}
			else{
				canvas.drawPath(pathpafu, paintgreen);
			}
			canvas.drawLine(Pati[3].x, Pati[3].y,Pati[12].x, Pati[12].y, painthe);//弯管处竖线
			canvas.drawLine(Pati[4].x, Pati[4].y,Pati[11].x, Pati[11].y, painthe);//第一节耙管竖线
			canvas.drawLine((int)(rect.left+0.9*width),(int)(rect.bottom+rect.top)/2,(int)(rect.left+0.9*width),DragHeady+3*Radius, paintyellow);//耙头距离黄色投影线
			canvas.restore();
		}
		else{
			canvas.drawLine((float)(rect.right-0.1*width), TopValue, (float)(rect.right-0.1*width), BottomValue, paintgray);//绘制比例尺线段
			Point ChangePoint =new Point(0,0);
			for(int i=0;i<(average+1);i++){//绘制刻度尺
				averageKD=TopValue+i*(int)(0.8*height)/average;
				ChangePoint.x=rect.right-(int)(0.1*width)+5;//每个刻度线的长度
				ChangePoint.y=averageKD;//每个刻度线的高度
				canvas.drawLine((float)(rect.right-0.1*width),averageKD,ChangePoint.x,ChangePoint.y,paintgray);//绘制刻度线
				Rect TextRect = new Rect();//刻度线刻度字体所在的矩形
				TextRect.left=ChangePoint.x;
				TextRect.right=rect.right;
				TextRect.top=averageKD-7;
				TextRect.bottom=averageKD+7;
				if(direction){//判断是否翻转
					String changetostring=String.valueOf(minValue+i*(maxValue-minValue)/average);
					canvas.drawText(changetostring, TextRect.left, averageKD, paintgray);//显示刻度文本
				}
				else{
					String changetostring=String.valueOf(-(minValue+i*(maxValue-minValue)/average));
					canvas.drawText(changetostring, TextRect.left, averageKD, paintgray);//显示刻度文本
				}
			}
			canvas.drawLine(rect.left, (rect.top+rect.bottom)/2, (float)(rect.left+0.9*width),  (rect.top+rect.bottom)/2, paintgray);//绘制水平横线
			double base;//比例尺的一个单位长度
			base=0.4*height/maxValue;
			Radius=(float) (0.5*base);//弯管半径
			Point XikouPoint=new Point((int) (rect.left+0.05*width),(rect.top+rect.bottom)/2);//吸口点
			Point Pati[]=new Point[14];//耙臂坐标数组
			if(direction){
				DragArm1x=(int)((DragArm1x/TotalLength)*0.75*width+XikouPoint.x);//第一节耙臂X坐标
				DragArm1y=(int)(DragArm1y*base+XikouPoint.y);//第一节耙臂Y坐标
				DragArm2x=(int)((DragArm2x/TotalLength)*0.75*width+XikouPoint.x);//第二节耙臂X坐标
				DragArm2y=(int)(DragArm2y*base+XikouPoint.y);//第二节耙臂Y坐标
				Elbowx=(int)((Elbowx/TotalLength)*0.75*width+XikouPoint.x);//弯管X坐标
				Elbowy=(int)(Elbowy*base+XikouPoint.y);//弯管Y坐标
				DragHeadx=(int)((DragHeadx/TotalLength)*0.75*width+XikouPoint.x);//耙头X坐标
				DragHeady=(int)(DragHeady*base+XikouPoint.y);//耙头Y坐标
				Pati[0]=new Point((int) (XikouPoint.x-Radius),XikouPoint.y);//耙臂坐标数组
				Pati[1]=new Point((int) (XikouPoint.x+Radius),XikouPoint.y);
				Pati[2]=new Point((int) (XikouPoint.x+Radius),(int) (Elbowy-Radius));
				Pati[3]=new Point((int) Elbowx,(int) (Elbowy-Radius));
				Pati[4]=new Point((int) (DragArm1x),(int) (DragArm1y-Radius));
				Pati[5]=new Point((int) (DragArm2x),(int) (DragArm2y-Radius));
				Pati[6]=new Point((int)(DragHeadx-0.05*width),(int) (DragHeady-3*Radius));
				Pati[7]=new Point((int)(DragHeadx),(int)(DragHeady-3*Radius));
				Pati[8]=new Point((int)(DragHeadx),(int)(DragHeady+3*Radius));
				Pati[9]=new Point((int)(DragHeadx-0.05*width),(int)(DragHeady+3*Radius));
				Pati[10]=new Point((int) (DragArm2x),(int)(DragArm2y+Radius));
				Pati[11]=new Point((int) (DragArm1x),(int)(DragArm1y+Radius));
				Pati[12]=new Point((int) Elbowx,(int)(Elbowy+Radius));
				Pati[13]=new Point((int)(XikouPoint.x-Radius),(int)(Elbowy+Radius));
			}
			else
			{
				DragArm1x=(int)(DragArm1x/TotalLength*0.75*width+XikouPoint.x);//第一节耙臂X坐标
				DragArm1y=(int)(XikouPoint.y-DragArm1y*base);//第一节耙臂Y坐标
				DragArm2x=(int)(DragArm2x/TotalLength*0.75*width+XikouPoint.x);//第二节耙臂X坐标
				DragArm2y=(int)(XikouPoint.y-DragArm2y*base);//第二节耙臂Y坐标
				Elbowx=(int)(Elbowx/TotalLength*0.75*width+XikouPoint.x);//弯管X坐标
				Elbowy=(int)(XikouPoint.y-Elbowy*base);//弯管Y坐标
				DragHeadx=(int)(DragHeadx/TotalLength*0.75*width+XikouPoint.x);//耙头X坐标
				DragHeady=(int)(XikouPoint.y-DragHeady*base);//耙头Y坐标
				Pati[0]=new Point((int) (XikouPoint.x-Radius),XikouPoint.y);//耙臂坐标数组
				Pati[1]=new Point((int) (XikouPoint.x+Radius),XikouPoint.y);
				Pati[2]=new Point((int) (XikouPoint.x+Radius),(int) (Elbowy+Radius));
				Pati[3]=new Point((int) Elbowx,(int) (Elbowy+Radius));
				Pati[4]=new Point((int) (DragArm1x),(int) (DragArm1y+Radius));
				Pati[5]=new Point((int) (DragArm2x),(int) (DragArm2y+Radius));
				Pati[6]=new Point((int)(DragHeadx-0.05*width),(int) (DragHeady+3*Radius));
				Pati[7]=new Point((int)(DragHeadx),(int)(DragHeady+3*Radius));
				Pati[8]=new Point((int)(DragHeadx),(int)(DragHeady-3*Radius));
				Pati[9]=new Point((int)(DragHeadx-0.05*width),(int) (DragHeady-3*Radius));
				Pati[10]=new Point((int) (DragArm2x),(int)(DragArm2y-Radius));
				Pati[11]=new Point((int) (DragArm1x),(int)(DragArm1y-Radius));
				Pati[12]=new Point((int) Elbowx,(int)(Elbowy-Radius));
				Pati[13]=new Point((int)(XikouPoint.x-Radius),(int)(Elbowy-Radius));
			}
			Rect MidTextRect = new Rect();//显示耙中参数的矩形
			if(direction){
				MidTextRect.left=(int) (DragArm1x-10);
				MidTextRect.right=(int) (DragArm1x+10);
				MidTextRect.top=Pati[11].y+10;
				MidTextRect.bottom=MidTextRect.top+10;
			}
			else{
				MidTextRect.left=(int) (DragArm1x)-10;
				MidTextRect.right=(int) (DragArm1x)+10;
				MidTextRect.bottom=(int)(Pati[11].y)-10;
				MidTextRect.top=(int) (MidTextRect.bottom-10);
			}
			String Midtostring=String.valueOf(DragMidDistance);//将耙中参数转化成String
			canvas.drawText(Midtostring, MidTextRect.left, MidTextRect.top, paintgray);//显示耙中参数
			Rect PtyTextRect = new Rect();//显示耙头参数的矩形
			if(direction){
				PtyTextRect.left=(int) (DragHeadx-10);
				PtyTextRect.right=(int) (DragHeadx+10);
				PtyTextRect.bottom=Pati[8].y+10;
				PtyTextRect.top=Pati[8].y+20;	
			}
			else{
				PtyTextRect.left=(int) (DragHeadx-10);
				PtyTextRect.right=(int) (DragHeadx+10);
				PtyTextRect.bottom=Pati[8].y-10;
				PtyTextRect.top=Pati[8].y-20;	
			}
			String Ptytostring=String.valueOf(DragHeadDistance);
			canvas.drawText(Ptytostring,PtyTextRect.left,PtyTextRect.top, paintgray);//显示耙头参数
			Path pathwan=new Path();//绘制弯管path
			pathwan.moveTo(Pati[0].x,Pati[0].y);
			pathwan.lineTo(Pati[1].x,Pati[1].y);
			pathwan.lineTo(Pati[2].x,Pati[2].y);
			pathwan.lineTo(Pati[3].x,Pati[3].y);
			pathwan.lineTo(Pati[12].x,Pati[12].y);
			pathwan.lineTo(Pati[13].x,Pati[13].y);
			pathwan.close();
			canvas.drawPath(pathwan, paintyellow);
			Path pathyi=new Path();//绘制第一节耙管path
			pathyi.moveTo(Pati[3].x,Pati[3].y);
			pathyi.lineTo(Pati[4].x, Pati[4].y);
			pathyi.lineTo(Pati[11].x, Pati[11].y);
			pathyi.lineTo(Pati[12].x,Pati[12].y);
			pathyi.close();
			canvas.drawPath(pathyi, paintyellow);
			Path pather=new Path();//绘制第二节耙管path
			pather.moveTo(Pati[4].x, Pati[4].y);
			pather.lineTo(Pati[5].x, Pati[5].y);
			pather.lineTo(Pati[10].x,Pati[10].y);
			pather.lineTo(Pati[11].x,Pati[11].y);
			pather.close();
			canvas.drawPath(pather, paintyellow);
			Path pathpatou=new Path();//绘制耙头path
			pathpatou.moveTo(Pati[5].x, Pati[5].y);
			pathpatou.lineTo(Pati[6].x,Pati[6].y);
			pathpatou.lineTo(Pati[7].x,Pati[7].y);
			pathpatou.lineTo(Pati[8].x,Pati[8].y);
			pathpatou.lineTo(Pati[9].x,Pati[9].y);
			pathpatou.lineTo(Pati[10].x,Pati[10].y);
			pathpatou.close();
			canvas.drawPath(pathpatou, painthe);
			Path pathpafu=new Path();//绘制耙头覆盖矩形path
			pathpafu.moveTo(Pati[6].x, Pati[6].y);
			pathpafu.lineTo(Pati[7].x-1,Pati[7].y);
			pathpafu.lineTo(Pati[8].x-1,Pati[8].y);
			pathpafu.lineTo(Pati[9].x, Pati[9].y);
			pathpafu.close();
			if(zuopa){
				canvas.drawPath(pathpafu, paintred);
			}
			else{
				canvas.drawPath(pathpafu, paintgreen);
			}
			canvas.drawLine(Pati[3].x, Pati[3].y,Pati[12].x, Pati[12].y, painthe);
			canvas.drawLine(Pati[4].x, Pati[4].y,Pati[11].x, Pati[11].y, painthe);
			canvas.drawLine((int)(rect.left+0.9*width),(int)(rect.bottom+rect.top)/2,(int)(rect.left+0.9*width),DragHeady+3*Radius, paintyellow);
		}
	}

}
