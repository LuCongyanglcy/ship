package jiaoxi.crazyit.classes.dig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jiaoxi.crazyit.classes.dxf.Dxf_r12;

import android.R.color;
import android.R.layout;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;

public class OperaDig {

	public void readDigFileName(String fileName,List<DigData> strDigDatas){
		//DigData tmpDig=new DigData();
		DigData strDigData=new DigData();
		File f=new File(fileName);
		FileInputStream in=null;
		int FileLen=(int)f.length();
		byte[] s=new byte[FileLen];
		try {
			in=new FileInputStream(f);
			
			in.read(s);
			
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
		finally{
			try {
				in.close();
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		int FileSeek=0;
		byte[] files0=new byte[256];
		byte[] s0=new byte[256];
		byte Symbol;
		byte OldSymbol=0;
		double x,y;
		int color=0;
		int blue=0;
		int green=0;
		int red=0;
		
		String Label="";
		while(FileSeek<=FileLen){
			int Seek=0;
			FileSeek=ReadBlankData(s,files0,FileLen,FileSeek,256);	
			Symbol=files0[0];
			FileSeek=ReadBlankData(s,files0,FileLen,FileSeek,256);	
			y=Double.parseDouble((new String(files0)).trim());
			FileSeek=ReadBlankData(s,files0,FileLen,FileSeek,256);	
			x=Double.parseDouble((new String(files0)).trim());
			
			FileSeek=ReadLine_DIGData(s,files0,FileLen,FileSeek,256);	
			Label=new String(files0);
			//LabelLenth = lstrlen(Label);
			switch (Symbol) {
			case 'a':
				Str_General settleShip=new Str_General();
				settleShip.x=x;
				settleShip.y=y;
				settleShip.Label=Label;
				strDigData.StrSettleShip.add(settleShip);
				break;
				
			case 'b':
				Str_General lightShip=new Str_General();
				lightShip.x=x;
				lightShip.y=y;
				lightShip.Label=Label;
				strDigData.StrLightShip.add(lightShip);
				break;
				
			case 'c':
				Str_General oilWell=new Str_General();
				oilWell.x=x;
				oilWell.y=y;
				oilWell.Label=Label;
				strDigData.StrOilWell.add(oilWell);
				break;
			case 'd':
				Str_General waterStand=new Str_General();
				waterStand.x=x;
				waterStand.y=y;
				waterStand.Label=Label;
				strDigData.StrWaterStand.add(waterStand);
				break;
			case 'e':
				Str_General reportPoint=new Str_General();
				reportPoint.x=x;
				reportPoint.y=y;
				reportPoint.Label=Label;
				strDigData.StrReportPoint.add(reportPoint);
				break;
			case 'f':
				Str_General beacon=new Str_General();
				beacon.x=x;
				beacon.y=y;
				beacon.Label=Label;
				strDigData.StrBeacon.add(beacon);
				break;
			case 'g':
				Str_General redFlag=new Str_General();
				redFlag.x=x;
				redFlag.y=y;
				redFlag.Label=Label;
				strDigData.StrRedFlag.add(redFlag);
				break;
			case 'h':
				Str_General hospital=new Str_General();
				hospital.x=x;
				hospital.y=y;
				hospital.Label=Label;
				strDigData.StrHospital.add(hospital);
				break;
			case 'i':
				Str_General tree=new Str_General();
				tree.x=x;
				tree.y=y;
				tree.Label=Label;
				strDigData.StrTree.add(tree);
				break;
			case 'j':
				Str_General anchor=new Str_General();
				anchor.x=x;
				anchor.y=y;
				anchor.Label=Label;
				strDigData.StrAnchor.add(anchor);
				break;
			case 'k':
				Str_General chimney=new Str_General();
				chimney.x=x;
				chimney.y=y;
				chimney.Label=Label;
				strDigData.StrChimney.add(chimney);
				break;
			case 'l':
				Str_General waterTower=new Str_General();
				waterTower.x=x;
				waterTower.y=y;
				waterTower.Label=Label;
				strDigData.StrWaterTower.add(waterTower);
				break;
			case 'm':
				Str_General radarReflector=new Str_General();
				radarReflector.x=x;
				radarReflector.y=y;
				radarReflector.Label=Label;
				strDigData.StrRadarReflector.add(radarReflector);
				break;
			case 'n':
				Str_General isLandReef=new Str_General();
				isLandReef.x=x;
				isLandReef.y=y;
				isLandReef.Label=Label;
				strDigData.StrIslandReef.add(isLandReef);
				break;
			case 'o':
				Str_General aquatic=new Str_General();
				aquatic.x=x;
				aquatic.y=y;
				aquatic.Label=Label;
				strDigData.StrAquatic.add(aquatic);
				break;
			case 'p':
				Str_General buoy1=new Str_General();
				buoy1.x=x;
				buoy1.y=y;
				buoy1.Label=Label;
				strDigData.StrBuoy1.add(buoy1);
				break;
			case 'q':
				Str_General buoy2=new Str_General();
				buoy2.x=x;
				buoy2.y=y;
				buoy2.Label=Label;
				strDigData.StrBuoy2.add(buoy2);
				break;
			case 'r':
				Str_General buoy3=new Str_General();
				buoy3.x=x;
				buoy3.y=y;
				buoy3.Label=Label;
				strDigData.StrBuoy3.add(buoy3);
				break;
			case 's':
				Str_General buoy4=new Str_General();
				buoy4.x=x;
				buoy4.y=y;
				buoy4.Label=Label;
				strDigData.StrBuoy4.add(buoy4);
				break;
			case 't':
				Str_General buoy5=new Str_General();
				buoy5.x=x;
				buoy5.y=y;
				buoy5.Label=Label;
				strDigData.StrBuoy5.add(buoy5);
				break;
			case 'u':
				Str_General buoy6=new Str_General();
				buoy6.x=x;
				buoy6.y=y;
				buoy6.Label=Label;
				strDigData.StrBuoy6.add(buoy6);
				break;
			case 'v':
				Str_General buoy7=new Str_General();
				buoy7.x=x;
				buoy7.y=y;
				buoy7.Label=Label;
				strDigData.StrBuoy7.add(buoy7);
				break;
			case 'w':
				Str_General buoy8=new Str_General();
				buoy8.x=x;
				buoy8.y=y;
				buoy8.Label=Label;
				strDigData.StrBuoy8.add(buoy8);
				break;
			case 'x':
				Str_General buoy9=new Str_General();
				buoy9.x=x;
				buoy9.y=y;
				buoy9.Label=Label;
				strDigData.StrBuoy9.add(buoy9);
				break;
			case 'y':
				Str_General buoy10=new Str_General();
				buoy10.x=x;
				buoy10.y=y;
				buoy10.Label=Label;
				strDigData.StrBuoy10.add(buoy10);
				break;
			case 'V':
				Str_General fishNet=new Str_General();
				fishNet.x=x;
				fishNet.y=y;
				fishNet.Label=Label;
				strDigData.StrFishNet.add(fishNet);
				break;
			case 'Q':
				Str_General blackYellow=new Str_General();
				blackYellow.x=x;
				blackYellow.y=y;
				blackYellow.Label=Label;
				strDigData.StrBuoyBlackYellow.add(blackYellow);
				break;
			case 'U':
				Str_General num=new Str_General();
				num.x=x;
				num.y=y;
				num.Label=Label;
				strDigData.StrNum.add(num);
				break;
			case 'W':
				Str_General wrecks=new Str_General();
				wrecks.x=x;
				wrecks.y=y;
				wrecks.Label=Label;
				strDigData.StrWrecks.add(wrecks);
				break;
			case 'B':
				Str_General whiteBuoy=new Str_General();
				whiteBuoy.x=x;
				whiteBuoy.y=y;
				whiteBuoy.Label=Label;
				strDigData.StrWhiteBuoy.add(whiteBuoy);
				break;
			case 'M':
				Str_General greenBuoy=new Str_General();
				greenBuoy.x=x;
				greenBuoy.y=y;
				greenBuoy.Label=Label;
				strDigData.StrGreenBuoy.add(greenBuoy);
				break;
			case 'F':
				Str_General redBuoy=new Str_General();
				redBuoy.x=x;
				redBuoy.y=y;
				redBuoy.Label=Label;
				strDigData.StrRedBuoy.add(redBuoy);
				break;
			case 'T':
				Str_General text=new Str_General();
				text.x=x;
				text.y=y;
				text.Label=Label;
				strDigData.StrText.add(text);
				break;
			case 'L':
				Str_General light=new Str_General();
				light.x=x;
				light.y=y;
				light.Label=Label;
				strDigData.StrLight.add(light);
				break;
			case 'R':
				Str_General rack=new Str_General();
				rack.x=x;
				rack.y=y;
				rack.Label=Label;
				strDigData.StrRack.add(rack);
				break;
			case 'K':
				Str_General kettle=new Str_General();
				kettle.x=x;
				kettle.y=y;
				kettle.Label=Label;
				strDigData.StrKettle.add(kettle);
				break;
			case 'G':
				Str_General tideStation=new Str_General();
				tideStation.x=x;
				tideStation.y=y;
				tideStation.Label=Label;
				strDigData.StrTideStation.add(tideStation);
				break;
			case 'P':
				Str_General picket=new Str_General();
				picket.x=x;
				picket.y=y;
				picket.Label=Label;
				strDigData.StrPicket.add(picket);
				break;
			case 'N':
				Str_General navigateMark=new Str_General();
				navigateMark.x=x;
				navigateMark.y=y;
				navigateMark.Label=Label;
				strDigData.StrNavigateMark.add(navigateMark);
				break;
			case 'A':
				Str_Arc arc=new Str_Arc();
				arc.x=x;
				arc.y=y;
				//byte[] tmp=Label.getBytes();
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				arc.BeginAngle=Float.parseFloat((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				arc.EndAngle=Float.parseFloat((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				arc.Radum=Float.parseFloat((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				arc.Style=Integer.parseInt((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				color=Integer.parseInt((new String(s0)).trim());
				blue=(color & 0xff0000)>>16;
				green=(color & 0x00ff00)>>8;
				red=(color & 0x0000ff);
				arc.color=Color.rgb(red, green, blue);
				strDigData.StrArc.add(arc);
				break;
			case 'C':
				Str_Circle circle=new Str_Circle();
				circle.x=x;
				circle.y=y;
				//byte[] tmp1=Label.getBytes();
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				circle.Radum=Float.parseFloat((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				circle.Style=Integer.parseInt((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				
				color=Integer.parseInt((new String(s0)).trim());
				blue=(color & 0xff0000)>>16;
				green=(color & 0x00ff00)>>8;
				red=(color & 0x0000ff);
				circle.color=Color.rgb(red, green, blue);
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				if(Integer.parseInt((new String(s0)).trim())==1){
					circle.FillCircle=true;
				}
				else{
					circle.FillCircle=false;
				}
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				color=Integer.parseInt((new String(s0)).trim());
				blue=(color & 0xff0000)>>16;
				green=(color & 0x00ff00)>>8;
				red=(color & 0x0000ff);
				circle.FillColor=Color.rgb(red, green, blue);
				strDigData.StrCircle.add(circle);
				break;
			case 'X':
				Str_ColorLine colorLine=new Str_ColorLine();
				colorLine.BeginPoint_x=x;
				colorLine.BeginPoint_y=y;
				//byte[] tmp2=Label.getBytes();
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				colorLine.EndPoint_x=Double.parseDouble((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				colorLine.EndPoint_y=Double.parseDouble((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				colorLine.PenStyle=Integer.parseInt((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				color=Integer.parseInt((new String(s0)).trim());
				blue=(color & 0xff0000)>>16;
				green=(color & 0x00ff00)>>8;
				red=(color & 0x0000ff);
				colorLine.color=Color.rgb(red, green, blue);
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				colorLine.Width=Integer.parseInt((new String(s0)).trim());
				strDigData.StrColorLine.add(colorLine);
				break;
			case 'z':
				Str_Dykeline dykeLine=new Str_Dykeline();
				dykeLine.BeginPoint_x=x;
				dykeLine.BeginPoint_y=y;
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				dykeLine.EndPoint_x=Double.parseDouble((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				dykeLine.EndPoint_y=Double.parseDouble((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				dykeLine.PenStyle=Integer.parseInt((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				color=Integer.parseInt((new String(s0)).trim());
				blue=(color & 0xff0000)>>16;
				green=(color & 0x00ff00)>>8;
				red=(color & 0x0000ff);
				dykeLine.color=Color.rgb(red, green, blue);
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				dykeLine.Width=Integer.parseInt((new String(s0)).trim());
				strDigData.StrDykeline.add(dykeLine);
				break;
			case 'O':
				Str_Rectangle rectangle=new Str_Rectangle();
				rectangle.TopLeftX=x;
				rectangle.TopLeftY=y;
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				rectangle.RectLen=Float.parseFloat((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				rectangle.RectWidth=Float.parseFloat((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				rectangle.Angle=Integer.parseInt((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				rectangle.PenStyle=Integer.parseInt((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				color=Integer.parseInt((new String(s0)).trim());
				blue=(color & 0xff0000)>>16;
				green=(color & 0x00ff00)>>8;
				red=(color & 0x0000ff);
				rectangle.color=Color.rgb(red, green, blue);
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				rectangle.Width=Integer.parseInt((new String(s0)).trim());
				strDigData.StrRectangle.add(rectangle);
				break;
				//////////////////////后面这些数据获取有问题,要是连续两个不就合并成一个了
			case 'S':
				if(OldSymbol!='S'){
					Str_ShoreLine shoreLine=new Str_ShoreLine();
					shoreLine.x.add(x);
					shoreLine.y.add(y);
					strDigData.StrShoreLine.add(shoreLine);
				}
				else{
					//strDigData.StrShoreLine.set(location, object);
					Str_ShoreLine shoreLine=strDigData.StrShoreLine.get(strDigData.StrShoreLine.size()-1);
					shoreLine.x.add(x);
					shoreLine.y.add(y);
					
				}
				break;
			case 'I':
				if(OldSymbol!='I'){
					Str_ColorPolyline colorPolyline=new Str_ColorPolyline();
					colorPolyline.x.add(x);
					colorPolyline.y.add(y);
					Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
					color=Integer.parseInt((new String(s0)).trim());
					blue=(color & 0xff0000)>>16;
					green=(color & 0x00ff00)>>8;
					red=(color & 0x0000ff);
					colorPolyline.color=Color.rgb(red, green, blue);
					Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
					colorPolyline.PenStyle=Integer.parseInt((new String(s0)).trim());
					Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
					colorPolyline.LX=Integer.parseInt((new String(s0)).trim());
					Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
					colorPolyline.Width=Integer.parseInt((new String(s0)).trim());
					strDigData.StrColorPolyline.add(colorPolyline);
				}
				else{
					Str_ColorPolyline colorPolyline=strDigData.StrColorPolyline.get(strDigData.StrColorPolyline.size()-1);
					colorPolyline.x.add(x);
					colorPolyline.y.add(y);
				}
				
				
				break;
				
			case 'Y':
				if(OldSymbol!='Y'){
					Str_Solid solid=new Str_Solid();
					solid.x.add(x);
					solid.y.add(y);
					Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
					color=Integer.parseInt((new String(s0)).trim());
					blue=(color & 0xff0000)>>16;
					green=(color & 0x00ff00)>>8;
					red=(color & 0x0000ff);
					solid.FillColor=Color.rgb(red, green, blue);
					Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
					solid.FillMode=Integer.parseInt((new String(s0)).trim());
					Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
					color=Integer.parseInt((new String(s0)).trim());
					blue=(color & 0xff0000)>>16;
					green=(color & 0x00ff00)>>8;
					red=(color & 0x0000ff);
					solid.LineColor=Color.rgb(red, green, blue);
					Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
					solid.PenStyle=Integer.parseInt((new String(s0)).trim());
					strDigData.StrSolid.add(solid);
				}
				else{
					Str_Solid solid=strDigData.StrSolid.get(strDigData.StrSolid.size()-1);
					solid.x.add(x);
					solid.y.add(y);
				}
				break;
			case 'D':
				if(OldSymbol!='D'){
					Str_PolyBezier polyBezier=new Str_PolyBezier();
					polyBezier.x.add(x);
					polyBezier.y.add(y);
					Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
					color=Integer.parseInt((new String(s0)).trim());
					blue=(color & 0xff0000)>>16;
					green=(color & 0x00ff00)>>8;
					red=(color & 0x0000ff);
					polyBezier.color=Color.rgb(red, green, blue);
					Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
					polyBezier.PenStyle=Integer.parseInt((new String(s0)).trim());
					Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
					polyBezier.Width=Integer.parseInt((new String(s0)).trim());
					strDigData.StrPolyBezier.add(polyBezier);
				}
				else{
					Str_PolyBezier polyBezier=strDigData.StrPolyBezier.get(strDigData.StrPolyBezier.size()-1);
					polyBezier.x.add(x);
					polyBezier.y.add(y);
				}
				break;
				
			case 'Z':
				Str_BigText bigText=new Str_BigText();
				bigText.Point_x=x;
				bigText.Point_y=y;
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				bigText.Angle=Float.parseFloat((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				color=Integer.parseInt((new String(s0)).trim());
				blue=(color & 0xff0000)>>16;
				green=(color & 0x00ff00)>>8;
				red=(color & 0x0000ff);
				bigText.color=Color.rgb(red, green, blue);
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				bigText.FontSize=Integer.parseInt((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				bigText.Style=Integer.parseInt((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				bigText.Width=Integer.parseInt((new String(s0)).trim());
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				try {
					bigText.Text=(new String(s0,"GB2312")).trim();
				} catch (UnsupportedEncodingException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
					bigText.Text="转换出错";
				}
				//////////////这里先这样写,原程序上写的很奇怪,不知道目的
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				try {
					bigText.FontName=(new String(s0,"GB2312")).trim();
				} catch (UnsupportedEncodingException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				strDigData.StrBigText.add(bigText);
				break;
			case '[':
				Str_Image image=new Str_Image();
				image.x=x;
				image.y=y;
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				try {
					image.Label=(new String(s0,"GB2312")).trim();
				} catch (UnsupportedEncodingException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				try {
					image.PathName=(new String(s0,"GB2312")).trim();
				} catch (UnsupportedEncodingException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				Seek=ReadBlankData(files0, s0, files0.length, Seek, 256);
				try {
					image.FileName=(new String(s0,"GB2312")).trim();
				} catch (UnsupportedEncodingException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				strDigData.StrImage.add(image);
				break;
				
				///////这个读取dig文件的,原程序上bug多多,是不是被什么不懂的人改过,先写成这样,有问题再说了
			default:
				break;
			}
			OldSymbol=Symbol;
		}
		strDigDatas.add(strDigData);
	}
	public void saveSerDigs(String path,List<DigData> digs){
		File f=new File(path);
		if(f.exists()){
			f.delete();
		}
		try {
			OutputStream os=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(os);
			oos.writeObject(digs);
			oos.close();
			os.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public List<DigData> readSerDigs(String path){
		List<DigData> digs=new ArrayList<DigData>();
		try {
			
			InputStream in=new FileInputStream(path);
			ObjectInputStream ois=new ObjectInputStream(in);
			digs=(List<DigData>)ois.readObject();
			ois.close();
			in.close();
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return digs;
	}
	public int ReadLine_DIGData(byte[] s,byte[] s0,int FileLen,int seek,int MaxLen){
		int i,k;
		for(i=0;i<MaxLen;i++){
			s0[i]=0;
		}
		for(i=seek;i<FileLen;i++){
			if(s[i]==0x0d)
				break;
			}
		if(i-seek<MaxLen){
			for(k=0;k<i-seek;k++)
				s0[k]=s[seek+k];
			//	s0[k]=0;
		}
		return i+2;
	}
	public int ReadBlankData(byte[] s,byte[] s0,int FileLen,int seek,int MaxLen){
		int i,k;
		for(i=0;i<MaxLen;i++){
			s0[i]=0;
		}
		boolean Enable=false;
		for(i=seek;i<FileLen;i++){
			if((s[i]==' ' && i!=seek)||s[i]==10 || s[i]==13)
			{
				for(k=seek;k<i;k++)
				{
					if(s[k]!=' ' && s[k]!=10 && s[k]!=13)
					Enable=true;
				}
				if(Enable)
					break;
			}
		}
		if(i-seek<MaxLen)
		{
			for(k=0;k<i-seek;k++)
				s0[k]=s[seek+k];
		}
		return i+1;
	}
	
	public void drawDigData(Canvas canvas,Rect rect,double x_eve,double y_eve,double centerx,double centery,DigData dig){
		int width=rect.width();
		int height=rect.height();
		
		float sX=width/(10*(float)x_eve);
		float sY=height/(10*(float)y_eve);
		
		int num=dig.StrSettleShip.size();
		for(int i=0;i<num;i++){
			drawSettleShip_digData(canvas, rect, sX, sY, centerx, centery, dig.StrSettleShip.get(i), dig.BackMode);
		}
		num=dig.StrLightShip.size();
		for(int i=0;i<num;i++){
			drawLightShip_digData(canvas, rect, sX, sY, centerx, centery, dig.StrLightShip.get(i), dig.BackMode);
		}
		num=dig.StrOilWell.size();
		for(int i=0;i<num;i++){
			drawOilWell_digData(canvas, rect, sX, sY, centerx, centery, dig.StrOilWell.get(i), dig.BackMode);
		}
		num=dig.StrWaterStand.size();
		for(int i=0;i<num;i++){
			drawWaterStand_digData(canvas, rect, sX, sY, centerx, centery, dig.StrWaterStand.get(i), dig.BackMode);
		}
		num=dig.StrReportPoint.size();
		for(int i=0;i<num;i++){
			drawReportPoint_digData(canvas, rect, sX, sY, centerx, centery, dig.StrReportPoint.get(i), dig.BackMode);
		}
		num=dig.StrBeacon.size();
		for(int i=0;i<num;i++){
			drawBeacon_digData(canvas, rect, sX, sY, centerx, centery, dig.StrBeacon.get(i), dig.BackMode);
		}
		num=dig.StrRedFlag.size();
		for(int i=0;i<num;i++){
			drawReadFlag_digData(canvas, rect, sX, sY, centerx, centery,dig.StrRedFlag.get(i), dig.BackMode);
		}
		num=dig.StrHospital.size();
		for(int i=0;i<num;i++){
			drawHospital_digData(canvas, rect, sX, sY, centerx, centery, dig.StrHospital.get(i), dig.BackMode);
		}
		num=dig.StrTree.size();
		for(int i=0;i<num;i++){
			drawTree_digData(canvas, rect, sX, sY, centerx, centery, dig.StrTree.get(i), dig.BackMode);
		}
		num=dig.StrAnchor.size();
		for(int i=0;i<num;i++){
			drawAnchor_digData(canvas, rect, sX, sY, centerx, centery, dig.StrAnchor.get(i), dig.BackMode);
		}
		num=dig.StrChimney.size();
		for(int i=0;i<num;i++){
			drawChimney_digData(canvas, rect, sX, sY, centerx, centery,dig.StrChimney.get(i), dig.BackMode);
		}
		num=dig.StrWaterTower.size();
		for(int i=0;i<num;i++){
			drawWaterTower_digData(canvas, rect, sX, sY, centerx, centery, dig.StrWaterTower.get(i), dig.BackMode);
		}
		num=dig.StrRadarReflector.size();
		for(int i=0;i<num;i++){
			drawRadarReflector_digData(canvas, rect, sX, sY, centerx, centery, dig.StrRadarReflector.get(i), dig.BackMode);
		}
		num=dig.StrIslandReef.size();
		for(int i=0;i<num;i++){
			drawIslandReef_digData(canvas, rect, sX, sY, centerx, centery,dig.StrIslandReef.get(i), dig.BackMode);
		}
		num=dig.StrAquatic.size();
		for(int i=0;i<num;i++){
			drawAquatic_digData(canvas, rect, sX, sY, centerx, centery, dig.StrAquatic.get(i), dig.BackMode);
		}
		num=dig.StrBuoy1.size();
		for(int i=0;i<num;i++){
			drawBuoy1_digData(canvas, rect, sX, sY, centerx, centery, dig.StrBuoy1.get(i), dig.BackMode);
		}
		num=dig.StrBuoy2.size();
		for(int i=0;i<num;i++){
			drawBuoy2_digData(canvas, rect, sX, sY, centerx, centery, dig.StrBuoy2.get(i), dig.BackMode);
		}
		num=dig.StrBuoy3.size();
		for(int i=0;i<num;i++){
			drawBuoy3_digData(canvas, rect, sX, sY, centerx, centery, dig.StrBuoy3.get(i), dig.BackMode);
		}
		/////暂停,先做3G测试
		/*Iterator<Str_General> iSettleShip=dig.StrSettleShip.iterator();
		while(iSettleShip.hasNext()){
			drawSettleShip_digData(canvas, rect, x_eve, y_eve, centerx, centery, iSettleShip.next(), dig.BackMode);
		}
		Iterator<Str_General> iLightShip=dig.StrLightShip.iterator();
		while(iLightShip.hasNext()){
			drawLightShip_digData(canvas, rect, x_eve, y_eve, centerx, centery, iLightShip.next(), dig.BackMode);
		}
		Iterator<Str_General> iOilWell=dig.StrOilWell.iterator();
		while(iOilWell.hasNext()){
			drawOilWell_digData(canvas, rect, x_eve, y_eve, centerx, centery, iOilWell.next(), dig.BackMode);
		}
		Iterator<Str_General> iWaterStand=dig.StrWaterStand.iterator();
		while(iWaterStand.hasNext()){
			drawWaterStand_digData(canvas, rect, x_eve, y_eve, centerx, centery, iWaterStand.next(), dig.BackMode);
		}
		Iterator<Str_General> iReportPoint=dig.StrReportPoint.iterator();
		while(iReportPoint.hasNext()){
			drawReportPoint_digData(canvas, rect, x_eve, y_eve, centerx, centery, iReportPoint.next(), dig.BackMode);
		}
		Iterator<Str_General> iBeacon=dig.StrBeacon.iterator();
		while(iBeacon.hasNext()){
			drawBeacon_digData(canvas, rect, x_eve, y_eve, centerx, centery, iBeacon.next(), dig.BackMode);
		}
		Iterator<Str_General> iRedFlag=dig.StrRedFlag.iterator();
		while(iRedFlag.hasNext()){
			drawReadFlag_digData(canvas, rect, x_eve, y_eve, centerx, centery, iRedFlag.next(), dig.BackMode);
		}
		Iterator<Str_General> iHospital=dig.StrHospital.iterator();
		while(iHospital.hasNext()){
			drawHospital_digData(canvas, rect, x_eve, y_eve, centerx, centery, iHospital.next(), dig.BackMode);
		}
		Iterator<Str_General> iTree=dig.StrTree.iterator();
		while(iTree.hasNext()){
			drawTree_digData(canvas, rect, x_eve, y_eve, centerx, centery, iTree.next(), dig.BackMode);
		}
		Iterator<Str_General> iAnchor=dig.StrAnchor.iterator();
		while(iAnchor.hasNext()){
			drawAnchor_digData(canvas, rect, x_eve, y_eve, centerx, centery, iAnchor.next(), dig.BackMode);
		}
		Iterator<Str_General> iChimney=dig.StrChimney.iterator();
		while(iChimney.hasNext()){
			drawChimney_digData(canvas, rect, x_eve, y_eve, centerx, centery, iChimney.next(), dig.BackMode);
		}
		Iterator<Str_General> iWaterTower=dig.StrWaterTower.iterator();
		while(iWaterTower.hasNext()){
			drawWaterTower_digData(canvas, rect, x_eve, y_eve, centerx, centery, iWaterTower.next(), dig.BackMode);
		}
		Iterator<Str_General> iRadarReflector=dig.StrRadarReflector.iterator();
		while(iRadarReflector.hasNext()){
			drawRadarReflector_digData(canvas, rect, x_eve, y_eve, centerx, centery, iRadarReflector.next(), dig.BackMode);
		}
		Iterator<Str_General> iIslandReef=dig.StrIslandReef.iterator();
		while(iIslandReef.hasNext()){
			drawIslandReef_digData(canvas, rect, x_eve, y_eve, centerx, centery, iIslandReef.next(), dig.BackMode);
		}
		Iterator<Str_General> iAquatic=dig.StrAquatic.iterator();
		while(iAquatic.hasNext()){
			drawAquatic_digData(canvas, rect, x_eve, y_eve, centerx, centery, iAquatic.next(), dig.BackMode);
		}
		
		Iterator<Str_General> iBuoy1=dig.StrBuoy1.iterator();
		while(iBuoy1.hasNext()){
			drawBuoy1_digData(canvas, rect, x_eve, y_eve, centerx, centery, iBuoy1.next(), dig.BackMode);
		}
		
		Iterator<Str_General> iBuoy2=dig.StrBuoy2.iterator();
		while(iBuoy2.hasNext()){
			drawBuoy2_digData(canvas, rect, x_eve, y_eve, centerx, centery, iBuoy2.next(), dig.BackMode);
		}
		Iterator<Str_General> iBuoy3=dig.StrBuoy3.iterator();
		while(iBuoy3.hasNext()){
			drawBuoy3_digData(canvas, rect, x_eve, y_eve, centerx, centery, iBuoy3.next(), dig.BackMode);
		}
		Iterator<Str_General> iBuoy4=dig.StrBuoy4.iterator();
		while(iBuoy4.hasNext()){
			drawBuoy4_digData(canvas, rect, x_eve, y_eve, centerx, centery, iBuoy4.next(), dig.BackMode);
		}
		Iterator<Str_General> iBuoy5=dig.StrBuoy5.iterator();
		while(iBuoy5.hasNext()){
			drawBuoy5_digData(canvas, rect, x_eve, y_eve, centerx, centery, iBuoy5.next(), dig.BackMode);
		}
		Iterator<Str_General> iBuoy6=dig.StrBuoy6.iterator();
		while(iBuoy6.hasNext()){
			drawBuoy6_digData(canvas, rect, x_eve, y_eve, centerx, centery, iBuoy6.next(), dig.BackMode);
		}
		Iterator<Str_General> iBuoy7=dig.StrBuoy7.iterator();
		while(iBuoy7.hasNext()){
			drawBuoy7_digData(canvas, rect, x_eve, y_eve, centerx, centery, iBuoy7.next(), dig.BackMode);
		}
		Iterator<Str_General> iBuoy8=dig.StrBuoy8.iterator();
		while(iBuoy8.hasNext()){
			drawBuoy8_digData(canvas, rect, x_eve, y_eve, centerx, centery, iBuoy8.next(), dig.BackMode);
		}
		Iterator<Str_General> iBuoy9=dig.StrBuoy9.iterator();
		while(iBuoy9.hasNext()){
			drawBuoy9_digData(canvas, rect, x_eve, y_eve, centerx, centery, iBuoy9.next(), dig.BackMode);
		}
		Iterator<Str_General> iBuoy10=dig.StrBuoy10.iterator();
		while(iBuoy10.hasNext()){
			drawBuoy10_digData(canvas, rect, x_eve, y_eve, centerx, centery, iBuoy10.next(), dig.BackMode);
		}
		
		Iterator<Str_Image> iImage=dig.StrImage.iterator();
		while(iImage.hasNext()){
			drawImage_digData(canvas, rect, x_eve, y_eve, centerx, centery, iImage.next(), dig.BackMode);
		}
		
		Iterator<Str_General> iFishNet=dig.StrFishNet.iterator();
		while(iFishNet.hasNext()){
			drawFishNet_digData(canvas, rect, x_eve, y_eve, centerx, centery, iFishNet.next(), dig.BackMode);
		}
		Iterator<Str_General> iBuoyBlackYellow=dig.StrBuoyBlackYellow.iterator();
		while(iBuoyBlackYellow.hasNext()){
			drawBuoyBlackYellow_digData(canvas, rect, x_eve, y_eve, centerx, centery, iBuoyBlackYellow.next(), dig.BackMode);
		}
		Iterator<Str_General> iNum=dig.StrNum.iterator();
		while(iNum.hasNext()){
			drawNum_digData(canvas, rect, x_eve, y_eve, centerx, centery, iNum.next(), dig.BackMode);
		}
		Iterator<Str_General> iWrecks=dig.StrWrecks.iterator();
		while(iWrecks.hasNext()){
			drawWrecks_digData(canvas, rect, x_eve, y_eve, centerx, centery, iWrecks.next(), dig.BackMode);
		}
		
		Iterator<Str_Solid> iSolid=dig.StrSolid.iterator();
		while(iSolid.hasNext()){
			drawSolid_digData(canvas, rect, x_eve, y_eve, centerx, centery, iSolid.next(), dig.BackMode);
		}
		
		Iterator<Str_Circle> iCircle=dig.StrCircle.iterator();
		while(iCircle.hasNext()){
			drawCircle_digData(canvas, rect, x_eve, y_eve, centerx, centery, iCircle.next(), dig.BackMode);
		}
		
		Iterator<Str_General> iNavigateMark=dig.StrNavigateMark.iterator();
		while(iNavigateMark.hasNext()){
			drawNavigateMark_digData(canvas, rect, x_eve, y_eve, centerx, centery, iNavigateMark.next(), dig.BackMode);
		}
		
		Iterator<Str_General> iWhiteBuoy=dig.StrWhiteBuoy.iterator();
		while(iWhiteBuoy.hasNext()){
			drawWhiteBuoy_digData(canvas, rect, x_eve, y_eve, centerx, centery, iWhiteBuoy.next(), dig.BackMode);
		}
		
		Iterator<Str_General> iRedBuoy=dig.StrRedBuoy.iterator();
		while(iRedBuoy.hasNext()){
			drawRedBuoy_digData(canvas, rect, x_eve, y_eve, centerx, centery, iRedBuoy.next(), dig.BackMode);
		}
		
		Iterator<Str_General> iGreenBuoy=dig.StrGreenBuoy.iterator();
		while(iGreenBuoy.hasNext()){
			drawGreenBuoy_digData(canvas, rect, x_eve, y_eve, centerx, centery, iGreenBuoy.next(), dig.BackMode);
		}
		
		Iterator<Str_ShoreLine> iShoreLine=dig.StrShoreLine.iterator();
		while(iShoreLine.hasNext()){
			drawShorLine_digData(canvas, rect, x_eve, y_eve, centerx, centery, iShoreLine.next(), dig.BackMode);
		}
		
		Iterator<Str_General> iLight=dig.StrLight.iterator();
		while(iLight.hasNext()){
			drawLight_digData(canvas, rect, x_eve, y_eve, centerx, centery, iLight.next(), dig.BackMode);
		}
		
		Iterator<Str_General> iText=dig.StrText.iterator();
		while(iText.hasNext()){
			drawText_digData(canvas, rect, x_eve, y_eve, centerx, centery, iText.next(), dig.BackMode);
		}
		
		Iterator<Str_General> iPicket=dig.StrPicket.iterator();
		while(iPicket.hasNext()){
			drawPicket_digData(canvas, rect, x_eve, y_eve, centerx, centery, iPicket.next(), dig.BackMode);
		}
		
		Iterator<Str_General> iKettle=dig.StrKettle.iterator();
		while(iKettle.hasNext()){
			drawKettle_digData(canvas, rect, x_eve, y_eve, centerx, centery, iKettle.next(), dig.BackMode);
		}
		Iterator<Str_General> iRack=dig.StrRack.iterator();
		while(iRack.hasNext()){
			drawRack_digData(canvas, rect, x_eve, y_eve, centerx, centery, iRack.next(), dig.BackMode);
		}
		
		Iterator<Str_General> iTideStation=dig.StrTideStation.iterator();
		while(iTideStation.hasNext()){
			drawTideStation_digData(canvas, rect, x_eve, y_eve, centerx, centery, iTideStation.next(), dig.BackMode);
		}
		
		Iterator<Str_Arc> iArc=dig.StrArc.iterator();
		while(iArc.hasNext()){
			drawArc_digData(canvas, rect, x_eve, y_eve, centerx, centery, iArc.next(), dig.BackMode);
		}
		
		Iterator<Str_BigText> iBigText=dig.StrBigText.iterator();
		while(iBigText.hasNext()){
			drawBigText_digData(canvas, rect, x_eve, y_eve, centerx, centery, iBigText.next(), dig.BackMode);
		}
		
		Iterator<Str_ColorLine> iColorLine=dig.StrColorLine.iterator();
		while(iColorLine.hasNext()){
			drawColorLine_digData(canvas, rect, x_eve, y_eve, centerx, centery, iColorLine.next(), dig.BackMode);
		}
		
		Iterator<Str_Dykeline> iDykeLine=dig.StrDykeline.iterator();
		while(iDykeLine.hasNext()){
			drawDykeLine_digData(canvas, rect, x_eve, y_eve, centerx, centery, iDykeLine.next(), dig.BackMode);
		}
		
		Iterator<Str_ColorPolyline> iColorPolyline=dig.StrColorPolyline.iterator();
		while(iColorPolyline.hasNext()){
			drawColorPolyline_digData(canvas, rect, x_eve, y_eve, centerx, centery, iColorPolyline.next(), dig.BackMode);
		}
		
		Iterator<Str_PolyBezier> iPolyBezier=dig.StrPolyBezier.iterator();
		while(iPolyBezier.hasNext()){
			drawPolyBezier_digData(canvas, rect, x_eve, y_eve, centerx, centery, iPolyBezier.next(), dig.BackMode);
		}
		
		Iterator<Str_Rectangle> iRectangle=dig.StrRectangle.iterator();
		while(iRectangle.hasNext()){
			drawRectangle_digData(canvas, rect, x_eve, y_eve, centerx, centery, iRectangle.next(), dig.BackMode);
		}*/
	}
	
	public void drawRectangle_digData(Canvas canvas,Rect rect,double x_eve,double y_eve,double centerx,double centery,Str_Rectangle rectangle, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;


		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		int lineColor;
		if((rectangle.color^backMode)==0){
			lineColor=Color.rgb(255, 255, 255)^backMode;
		}
		else{
			lineColor=rectangle.color;
		}
		
		Paint paint=new Paint();
		paint.setColor(lineColor);
		paint.setStrokeWidth(rectangle.Width);
		paint.setStyle(Paint.Style.STROKE);
		PathEffect effect;
		switch (rectangle.PenStyle) {
		case 0:
			
			
			break;
		case 1:
			effect=new DashPathEffect(new float[]{4, 2},1);
			paint.setPathEffect(effect);
			
			break;
		case 2:
			effect=new DashPathEffect(new float[]{1, 2},1);
			paint.setPathEffect(effect);
			
			break;
		case 3:
			effect=new DashPathEffect(new float[]{1, 2,4,3},1);
			paint.setPathEffect(effect);
			
			break;
		case 4:
			effect=new DashPathEffect(new float[]{1, 2,1,2,4,3},1);
			paint.setPathEffect(effect);
			
			break;
		default:
			
			break;
		}
		
		int[] px=new int[4];
		int[] py=new int[4];
		px[0]=(int) (pox+(rectangle.TopLeftY -centery)*width/(10*x_eve));
		py[0]=(int) (poy-(rectangle.TopLeftX -centerx)*height/(10*y_eve));
		px[1] = (int) (px[0]+( rectangle.RectLen*Math.cos(rectangle.Angle*Math.PI/180) )*width/(10*x_eve));		/////右上点
		py[1] = (int) (py[0]+( rectangle.RectLen*Math.sin(rectangle.Angle*Math.PI/180) )*height/(10*y_eve));

		px[2] = (int) (px[1]-( rectangle.RectWidth*Math.sin(rectangle.Angle*Math.PI/180) )*width/(10*x_eve));		/////右下点
		py[2] = (int) (py[1]+( rectangle.RectWidth*Math.cos(rectangle.Angle*Math.PI/180) )*height/(10*y_eve));

		px[3] = (int) (px[0]-( rectangle.RectWidth*Math.sin(rectangle.Angle*Math.PI/180) )*width/(10*x_eve));		/////左下点
		py[3] = (int) (py[0]+( rectangle.RectWidth*Math.cos(rectangle.Angle*Math.PI/180) )*height/(10*y_eve));
		
		DrawLine_DIG(canvas, px[0], py[0], px[1], py[1], rectangle.PenStyle, rectangle.Width, lineColor, rect);
		DrawLine_DIG(canvas, px[1], py[1], px[2], py[2], rectangle.PenStyle, rectangle.Width, lineColor, rect);
		DrawLine_DIG(canvas, px[2], py[2], px[3], py[3], rectangle.PenStyle, rectangle.Width, lineColor, rect);
		DrawLine_DIG(canvas, px[3], py[3], px[0], py[0], rectangle.PenStyle, rectangle.Width, lineColor, rect);
	}
	
	public void drawPolyBezier_digData(Canvas canvas,Rect rect,double x_eve,double y_eve,double centerx,double centery,Str_PolyBezier polyBezier, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;


		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		int lineColor;
		if((polyBezier.color^backMode)==0){
			lineColor=Color.rgb(255, 255, 255)^backMode;
		}
		else{
			lineColor=polyBezier.color;
		}
		
		Paint paint=new Paint();
		paint.setColor(lineColor);
		paint.setStrokeWidth(polyBezier.Width);
		paint.setStyle(Paint.Style.STROKE);
		PathEffect effect;
		switch (polyBezier.PenStyle) {
		case 0:
			
			
			break;
		case 1:
			effect=new DashPathEffect(new float[]{4, 2},1);
			paint.setPathEffect(effect);
			
			break;
		case 2:
			effect=new DashPathEffect(new float[]{1, 2},1);
			paint.setPathEffect(effect);
			
			break;
		case 3:
			effect=new DashPathEffect(new float[]{1, 2,4,3},1);
			paint.setPathEffect(effect);
			
			break;
		case 4:
			effect=new DashPathEffect(new float[]{1, 2,1,2,4,3},1);
			paint.setPathEffect(effect);
			
			break;
		default:
			
			break;
		}
		
		
		int len=polyBezier.x.size();
		int[] px=new int[len];
		int[] py=new int[len];
		Iterator<Double> ix=polyBezier.x.iterator();
		Iterator<Double> iy=polyBezier.y.iterator();
		int index=0;
		while(ix.hasNext()){
			py[index]=(int) (poy-(ix.next()-centerx)*height/(10*y_eve));
			px[index]=(int) (pox+(iy.next()-centery)*width/(10*x_eve));
			index++;
		}

		Path path=new Path();
		path.moveTo(px[0], py[0]);
		for(int i=1;i<len-1;i++){
			path.quadTo(px[i], py[i], px[i+1], py[i+1]);
		}
		canvas.drawPath(path, paint);
	}
	
	public void drawColorPolyline_digData(Canvas canvas,Rect rect,double x_eve,double y_eve,double centerx,double centery,Str_ColorPolyline colorPolyline, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		double angleline=0;


		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		int lineColor;
		if((colorPolyline.color^backMode)==0){
			lineColor=Color.rgb(255, 255, 255)^backMode;
		}
		else{
			lineColor=colorPolyline.color;
		}
		if(colorPolyline.Width<1){
			colorPolyline.Width=1;
		}
		int len=colorPolyline.x.size();
		int[] px=new int[len];
		int[] py=new int[len];
		Iterator<Double> ix=colorPolyline.x.iterator();
		Iterator<Double> iy=colorPolyline.y.iterator();
		int index=0;
		while(ix.hasNext()){
			py[index]=(int) (poy-(ix.next()-centerx)*height/(10*y_eve));
			px[index]=(int) (pox+(iy.next()-centery)*width/(10*x_eve));
			index++;
		}
		if(colorPolyline.PenStyle<5){
			for(int i=0;i<len;i+=2){
				if(px[i]!=px[i+1] || py[i]!= py[i+1]){
					DrawLine_DIG(canvas, px[i], py[i], px[i+1], py[i+1], colorPolyline.PenStyle, colorPolyline.Width, lineColor, rect);
				}
			}
		}
		else{
			Paint paint=new Paint();
			paint.setColor(lineColor);
			paint.setStrokeWidth(colorPolyline.Width);
			paint.setStyle(Paint.Style.STROKE);
			for(int i=0;i<len;i+=2){
				if(px[i]!=px[i+1] || py[i]!= py[i+1]){
					if(px[i]==px[i+1]){
						if(py[i+1]>py[i]){
							angleline=Math.PI*0.5;
						}
						else{
							angleline=Math.PI*1.5;
						}
					}
					else{
						if(px[i+1]>px[i]){
							angleline=Math.atan((double)(py[i+1]-py[i])/(px[i+1]-px[i]));
							
						}
						else{
							angleline=Math.PI+Math.atan((double)(py[i+1]-py[i])/(px[i+1]-px[i]));
						}
					}
				}
				int ra=4;
				double length = Math.sqrt(Math.pow(colorPolyline.x.get(i)-colorPolyline.x.get(i+1),2)+Math.pow(colorPolyline.y.get(i)-colorPolyline.y.get(i+1),2));	
				double length2 = length*height/(10*y_eve);
				int NumberPoint = (int) (length2/(2*ra));
				double length1 = length2/NumberPoint;
				
				for(int ii=0;ii<NumberPoint;ii++){
					int ArcCenter_x = (int) (px[i] + length1*ii*Math.cos(angleline));
					int ArcCenter_y = (int) (py[i] + length1*ii*Math.sin(angleline));
					//								Rect.NormalizeRect();
					boolean bNeedDraw = rect.contains(ArcCenter_x,ArcCenter_y);
					if(bNeedDraw){
						canvas.drawCircle(ArcCenter_x, ArcCenter_y, (float)length1, paint);
					}
				}
				
			}
		}
		
	}
	public double GetJC_Y(double a1,double b1,double c1,double a2,double b2,double c2){
		//求解线形方程   a1*x+b1*y=c1;  a2*x+b2*y=c2;   得到Y值
		if(Math.abs(a2*b1-a1*b2)<=0.00000001)
			return -999999999999.99;
		else
			return (c1*a2-c2*a1)/(a2*b1-a1*b2);
	}
	public double GetXD_Y(double x1,double y1,double x2,double y2,double x3,double y3,double x4,double y4){
		//求解线段值Y  线段(x0,y0)(x1,y1) 线段(x2,y2)(x3,y3) 无值返回-9999。99
		double y0=0;
		y0=GetJC_Y(y2-y1,x1-x2,x1*y2-y1*x2,y4-y3,x3-x4,x3*y4-y3*x4);
		if(y0<=-999999999999.99+1)
			return -999999999999.99;
		if(Math.abs((y0-y1))>Math.abs((y2-y1))+0.00000001||Math.abs((y0-y2))>Math.abs((y2-y1))+0.00000001)
			return -999999999999.99;
		if(Math.abs((y0-y3))>Math.abs((y4-y3))+0.00000001||Math.abs((y0-y4))>Math.abs((y4-y3))+0.00000001)
			return -999999999999.99;
		return y0;
	}
	public double GetJC_X(double a1,double b1,double c1,double a2,double b2,double c2)
	{
		//求解线形方程   a1*x+b1*y=c1;  a2*x+b2*y=c2;	 得到X值
		if(Math.abs(a2*b1-a1*b2)<=0.00000001)
			return -999999999999.99;
		else
			return (c1*b2-c2*b1)/(a1*b2-a2*b1);
	}
	public double GetXD_X(double x1,double y1,double x2,double y2,double x3,double y3,double x4,double y4){
		//求解线段值X  线段(x0,y0)(x1,y1) 线段(x2,y2)(x3,y3) 无值返回-9999。99
		double x0;
		x0=GetJC_X(y2-y1,x1-x2,x1*y2-y1*x2,
				y4-y3,x3-x4,x3*y4-y3*x4);
		if(x0<=-999999999999.99+1)
			return -999999999999.99;
		if(Math.abs((x0-x1))>Math.abs((x2-x1))+0.00000001||Math.abs((x0-x2))>Math.abs((x2-x1))+0.00000001)
			return -999999999999.99;
		if(Math.abs((x0-x3))>Math.abs((x4-x3))+0.00000001||Math.abs((x0-x4))>Math.abs((x4-x3))+0.00000001)
			return -999999999999.99;
		return x0;
	}
	public boolean DrawLine_DIG(Canvas canvas,int x1,int y1,int x2,int y2,int PenStyle,int PenWidth,int PenColor,Rect rect){
//			CPen hPen3(PenStyle,PenWidth,PenColor);
//			CPen *pen0;
			double x3,y3,x4,y4;
			double jx1,jy1,jx2,jy2,jx3,jy3,jx4,jy4;  //四个计算结果
			double[] jx=new double[4];
			double[] jy=new double[4];
			
			boolean AA=rect.contains(x1,y1);
			boolean BB=rect.contains(x2,y2);
			int kk=0;
			Paint paint=new Paint();
			paint.setColor(PenColor);
			paint.setStrokeWidth(PenWidth);

			PathEffect effect;
			switch (PenStyle) {
			case 0:
				
				
				break;
			case 1:
				effect=new DashPathEffect(new float[]{4, 2},1);
				paint.setPathEffect(effect);
				
				break;
			case 2:
				effect=new DashPathEffect(new float[]{1, 2},1);
				paint.setPathEffect(effect);
				
				break;
			case 3:
				effect=new DashPathEffect(new float[]{1, 2,4,3},1);
				paint.setPathEffect(effect);
				
				break;
			case 4:
				effect=new DashPathEffect(new float[]{1, 2,1,2,4,3},1);
				paint.setPathEffect(effect);
				
				break;
			default:
				
				break;
			}
			
			if (AA && BB){  //  两个点在范围内
			
				canvas.drawLine(x1, y1, x2, y2, paint);
				return true;
			}

			if (AA && !BB){  // 第一个点在范围内
			
				x3 = rect.left;	
				x4 = rect.right;
				y3 = rect.top;	
				y4 = rect.top;
				jy1 = GetXD_Y(x1,y1,x2,y2,x3,y3,x4,y4);
				jx1 = GetXD_X(x1,y1,x2,y2,x3,y3,x4,y4);
				if (jy1 > -999999999999.99+1 && jx1 > -999999999999.99+1){
					canvas.drawLine(x1, y1, (float)jx1, (float)jy1, paint);

					return true;
				}
				x3 = (double)rect.right;	
				x4 = (double)rect.right;
				y3 = (double)rect.top;	
				y4 = (double)rect.bottom;
				jy1 = GetXD_Y(x1, y1, x2, y2, x3, y3, x4, y4);
				jx1 = GetXD_X(x1, y1, x2, y2, x3, y3, x4, y4);
				if (jy1 > -999999999999.99+1 && jx1 > -999999999999.99+1){
					canvas.drawLine(x1, y1, (float)jx1, (float)jy1, paint);

					return true;
				}
				x3=(double)rect.right;	x4=(double)rect.left;
				y3=(double)rect.bottom;	y4=(double)rect.bottom;
				jy1=GetXD_Y(x1,y1,x2,y2,x3,y3,x4,y4);
				jx1=GetXD_X(x1,y1,x2,y2,x3,y3,x4,y4);
				if(jy1>-999999999999.99+1 &&jx1>-999999999999.99+1){
					canvas.drawLine(x1, y1, (float)jx1, (float)jy1, paint);
					return true;
				}

				x3=(double)rect.left;	x4=(double)rect.left;
				y3=(double)rect.bottom;	y4=(double)rect.top;
				jy1=GetXD_Y(x1,y1,x2,y2,x3,y3,x4,y4);
				jx1=GetXD_X(x1,y1,x2,y2,x3,y3,x4,y4);
				if(jy1>-999999999999.99+1 && jx1>-999999999999.99+1){
					canvas.drawLine(x1, y1, (float)jx1, (float)jy1, paint);
					return true;
				}
			}

			if (!AA && BB)  //第一个点在范围内
			{
				x3 = (double)rect.left;	
				x4 = (double)rect.right;
				y3 = (double)rect.top;	
				y4 = (double)rect.top;
				jy1 = GetXD_Y(x1, y1, x2, y2, x3, y3, x4, y4);
				jx1 = GetXD_X(x1, y1, x2, y2, x3, y3, x4, y4);
				if (jy1 > -999999999999.99+1 && jx1 > -999999999999.99+1){

					canvas.drawLine(x2, y2, (float)jx1, (float)jy1, paint);
					return true;
				}
				x3 = (double)rect.right;	
				x4 = (double)rect.right;
				y3 = (double)rect.top;	
				y4 = (double)rect.bottom;
				jy1 = GetXD_Y(x1, y1, x2, y2, x3, y3, x4, y4);
				jx1 = GetXD_X(x1, y1, x2, y2, x3, y3, x4, y4);
				if (jy1 > -999999999999.99+1 && jx1 > -999999999999.99+1){

					canvas.drawLine(x2, y2, (float)jx1, (float)jy1, paint);
					return true;
				}
				x3 = (double)rect.right;	
				x4 = (double)rect.left;
				y3 = (double)rect.bottom;
				y4 = (double)rect.bottom;
				jy1 = GetXD_Y(x1, y1, x2, y2, x3, y3, x4, y4);
				jx1 = GetXD_X(x1, y1, x2, y2, x3, y3, x4, y4);
				if (jy1 > -999999999999.99+1 && jx1 > -999999999999.99+1){
					canvas.drawLine(x2, y2, (float)jx1, (float)jy1, paint);
					return true;
				}

				x3 = (double)rect.left;	
				x4 = (double)rect.left;
				y3 = (double)rect.bottom;
				y4 = (double)rect.top;
				jy1 = GetXD_Y(x1, y1, x2, y2, x3, y3, x4, y4);
				jx1 = GetXD_X(x1, y1, x2, y2, x3, y3, x4, y4);
				if (jy1 > -999999999999.99+1 && jx1 > -999999999999.99+1){
					canvas.drawLine(x2, y2, (float)jx1, (float)jy1, paint);
					return true;
				}
			}
			
			if(!AA && !BB)  //没有点在范围内
			{
				x3=(double)rect.left;	x4=(double)rect.right;
				y3=(double)rect.top;	y4=(double)rect.top;
				jy1=GetXD_Y(x1,y1,x2,y2,x3,y3,x4,y4);
				jx1=GetXD_X(x1,y1,x2,y2,x3,y3,x4,y4);
				if(jy1>-999999999999.99+1 && jx1>-999999999999.99+1){
					jx[kk]=jx1;jy[kk]=jy1;
					kk++;
				}
				x3=(double)rect.right;	x4=(double)rect.right;
				y3=(double)rect.top;	y4=(double)rect.bottom;
				jy2=GetXD_Y(x1,y1,x2,y2,x3,y3,x4,y4);
				jx2=GetXD_X(x1,y1,x2,y2,x3,y3,x4,y4);
				if(jy2>-999999999999.99+1  &&jx2>-999999999999.99+1){
					jx[kk]=jx2;jy[kk]=jy2;
					kk++;
				}
				x3=(double)rect.right;	x4=(double)rect.left;
				y3=(double)rect.bottom;	y4=(double)rect.bottom;
				jy3=GetXD_Y(x1,y1,x2,y2,x3,y3,x4,y4);
				jx3=GetXD_X(x1,y1,x2,y2,x3,y3,x4,y4);
				if(jy3>-999999999999.99+1 &&jx3>-999999999999.99+1){
					jx[kk]=jx3;jy[kk]=jy3;
					kk++;
				}
				x3=(double)rect.left;	x4=(double)rect.left;
				y3=(double)rect.bottom;	y4=(double)rect.top;
				jy4=GetXD_Y(x1,y1,x2,y2,x3,y3,x4,y4);
				jx4=GetXD_X(x1,y1,x2,y2,x3,y3,x4,y4);
				if(jy4>-999999999999.99+1 &&jx4>-999999999999.99+1){
					jx[kk]=jx4;jy[kk]=jy4;
					kk++;
				}
				if(kk<2)
					return false;
				else
				{
//					pen0=dcMem->SelectObject(&hPen3);
//					dcMem->MoveTo((int)jx[0],(int)jy[0]);
//					dcMem->LineTo((int)jx[1],(int)jy[1]);
//					dcMem->SelectObject(pen0);
//					hPen3.DeleteObject();
//					return TRUE;
					canvas.drawLine((float)jx[0], (float)jy[0], (float)jx[1], (float)jy[1], paint);
					return true;
				}
			}
			return true;	
		}
	public void drawDykeLine_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_Dykeline dykeLine, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0,x1,y1;


		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		int lineColor;
		if((dykeLine.color^backMode)==0){
			lineColor=Color.rgb(255, 255, 255)^backMode;
		}
		else{
			lineColor=dykeLine.color;
		}
		if(dykeLine.Width<1){
			dykeLine.Width=1;
		}
		y0=(int)(poy-(dykeLine.BeginPoint_x-centerx)*sY);
		x0=(int)(pox+(dykeLine.BeginPoint_y-centery)*sX);
		
		y1=(int)(poy-(dykeLine.EndPoint_x-centerx)*sY);
		x1=(int)(pox+(dykeLine.EndPoint_y-centery)*sX);
		
		double length,length1,length2;
		int NumberPoint;
		
		length = Math.sqrt(Math.pow(dykeLine.BeginPoint_x-dykeLine.EndPoint_x,2)+Math.pow(dykeLine.BeginPoint_y-dykeLine.EndPoint_y,2));	
		NumberPoint = (int) (length/10);
		length1 = length/NumberPoint;
		length2 = length1*sY;		//转换为象素	
		
		if(rect.contains(x0, y0) || rect.contains(x1,y1)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			//paint.setStyle(Paint.Style.STROKE);
			paint.setColor(lineColor);
			paint.setStrokeWidth(dykeLine.Width);
			double ArcCenter_x,ArcCenter_y;
			RectF ArcRect=new RectF();
			PointF Arcpoint=new PointF();
			PathEffect effect;
			switch (dykeLine.PenStyle) {
			case 0:
				
				if(NumberPoint <=1){
					canvas.drawLine(x0, y0, x1, y1, paint);
				}
				else{
					for(int i=0;i<NumberPoint;i++){
						ArcCenter_x = x0 + (x1-x0)*(i+0.5)/NumberPoint;
						ArcCenter_y = y0 + (y1-y0)*(i+0.5)/NumberPoint;
						ArcRect.left = (float) (ArcCenter_x - length2/2.0);
						ArcRect.right = (float) (ArcRect.left + length2);
						ArcRect.top = (float) (ArcCenter_y - length2/2.0);
						ArcRect.bottom = (float) (ArcRect.top + length2);
						Arcpoint.x = ArcRect.left;
						Arcpoint.y = (float) ArcCenter_y;
						
						canvas.drawArc(ArcRect, 0, 360, false, paint);
					}
				}
				break;
			case 1:
				effect=new DashPathEffect(new float[]{4, 2},1);
				paint.setPathEffect(effect);
				if(NumberPoint <=1){
					canvas.drawLine(x0, y0, x1, y1, paint);
				}
				else{
					for(int i=0;i<NumberPoint;i++){
						ArcCenter_x = x0 + (x1-x0)*(i+0.5)/NumberPoint;
						ArcCenter_y = y0 + (y1-y0)*(i+0.5)/NumberPoint;
						ArcRect.left = (float) (ArcCenter_x - length2/2.0);
						ArcRect.right = (float) (ArcRect.left + length2);
						ArcRect.top = (float) (ArcCenter_y - length2/2.0);
						ArcRect.bottom = (float) (ArcRect.top + length2);
						Arcpoint.x = ArcRect.left;
						Arcpoint.y = (float) ArcCenter_y;
						
						canvas.drawArc(ArcRect, 0, 360, false, paint);
					}
				}
				break;
			case 2:
				effect=new DashPathEffect(new float[]{1, 2},1);
				paint.setPathEffect(effect);
				if(NumberPoint <=1){
					canvas.drawLine(x0, y0, x1, y1, paint);
				}
				else{
					for(int i=0;i<NumberPoint;i++){
						ArcCenter_x = x0 + (x1-x0)*(i+0.5)/NumberPoint;
						ArcCenter_y = y0 + (y1-y0)*(i+0.5)/NumberPoint;
						ArcRect.left = (float) (ArcCenter_x - length2/2.0);
						ArcRect.right = (float) (ArcRect.left + length2);
						ArcRect.top = (float) (ArcCenter_y - length2/2.0);
						ArcRect.bottom = (float) (ArcRect.top + length2);
						Arcpoint.x = ArcRect.left;
						Arcpoint.y = (float) ArcCenter_y;
						
						canvas.drawArc(ArcRect, 0, 360, false, paint);
					}
				}
				break;
			case 3:
				effect=new DashPathEffect(new float[]{1, 2,4,3},1);
				paint.setPathEffect(effect);
				if(NumberPoint <=1){
					canvas.drawLine(x0, y0, x1, y1, paint);
				}
				else{
					for(int i=0;i<NumberPoint;i++){
						ArcCenter_x = x0 + (x1-x0)*(i+0.5)/NumberPoint;
						ArcCenter_y = y0 + (y1-y0)*(i+0.5)/NumberPoint;
						ArcRect.left = (float) (ArcCenter_x - length2/2.0);
						ArcRect.right = (float) (ArcRect.left + length2);
						ArcRect.top = (float) (ArcCenter_y - length2/2.0);
						ArcRect.bottom = (float) (ArcRect.top + length2);
						Arcpoint.x = ArcRect.left;
						Arcpoint.y = (float) ArcCenter_y;
						
						canvas.drawArc(ArcRect, 0, 360, false, paint);
					}
				}
				break;
			case 4:
				effect=new DashPathEffect(new float[]{1, 2,1,2,4,3},1);
				paint.setPathEffect(effect);
				if(NumberPoint <=1){
					canvas.drawLine(x0, y0, x1, y1, paint);
				}
				else{
					for(int i=0;i<NumberPoint;i++){
						ArcCenter_x = x0 + (x1-x0)*(i+0.5)/NumberPoint;
						ArcCenter_y = y0 + (y1-y0)*(i+0.5)/NumberPoint;
						ArcRect.left = (float) (ArcCenter_x - length2/2.0);
						ArcRect.right = (float) (ArcRect.left + length2);
						ArcRect.top = (float) (ArcCenter_y - length2/2.0);
						ArcRect.bottom = (float) (ArcRect.top + length2);
						Arcpoint.x = ArcRect.left;
						Arcpoint.y = (float) ArcCenter_y;
						
						canvas.drawArc(ArcRect, 0, 360, false, paint);
					}
				}
				break;
			default:
				if(NumberPoint <=1){
					canvas.drawLine(x0, y0, x1, y1, paint);
				}
				else{
					for(int i=0;i<NumberPoint;i++){
						ArcCenter_x = x0 + (x1-x0)*(i+0.5)/NumberPoint;
						ArcCenter_y = y0 + (y1-y0)*(i+0.5)/NumberPoint;
						ArcRect.left = (float) (ArcCenter_x - length2/2.0);
						ArcRect.right = (float) (ArcRect.left + length2);
						ArcRect.top = (float) (ArcCenter_y - length2/2.0);
						ArcRect.bottom = (float) (ArcRect.top + length2);
						Arcpoint.x = ArcRect.left;
						Arcpoint.y = (float) ArcCenter_y;
						
						canvas.drawArc(ArcRect, 0, 360, false, paint);
					}
				}
				break;
			}
		}
	}
	
	
	public void drawColorLine_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_ColorLine colorLine, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0,x1,y1;


		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		int lineColor;
		if((colorLine.color^backMode)==0){
			lineColor=Color.rgb(255, 255, 255)^backMode;
		}
		else{
			lineColor=colorLine.color;
		}
		if(colorLine.Width<1){
			colorLine.Width=1;
		}
		y0=(int)(poy-(colorLine.BeginPoint_x-centerx)*sY);
		x0=(int)(pox+(colorLine.BeginPoint_y-centery)*sX);
		
		y1=(int)(poy-(colorLine.EndPoint_x-centerx)*sY);
		x1=(int)(pox+(colorLine.EndPoint_y-centery)*sX);
		
		
		if(rect.contains(x0, y0) || rect.contains(x1,y1)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			//paint.setStyle(Paint.Style.STROKE);
			paint.setColor(lineColor);
			paint.setStrokeWidth(colorLine.Width);
			
			
			PathEffect effect;
			switch (colorLine.PenStyle) {
			case 0:
				
				canvas.drawLine(x0, y0, x1, y1, paint);
				break;
			case 1:
				effect=new DashPathEffect(new float[]{4, 2},1);
				paint.setPathEffect(effect);
				canvas.drawLine(x0, y0, x1, y1, paint);
				break;
			case 2:
				effect=new DashPathEffect(new float[]{1, 2},1);
				paint.setPathEffect(effect);
				canvas.drawLine(x0, y0, x1, y1, paint);
				break;
			case 3:
				effect=new DashPathEffect(new float[]{1, 2,4,3},1);
				paint.setPathEffect(effect);
				canvas.drawLine(x0, y0, x1, y1, paint);
				break;
			case 4:
				effect=new DashPathEffect(new float[]{1, 2,1,2,4,3},1);
				paint.setPathEffect(effect);
				canvas.drawLine(x0, y0, x1, y1, paint);
				break;
			default:
				canvas.drawLine(x0, y0, x1, y1, paint);
				break;
			}
		}
	}
	
	public void drawBigText_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_BigText bigText, int backMode){
		int fontSizeWidth;
		if(bigText.Style==0){
			fontSizeWidth=bigText.FontSize;
			//fontSizeHeight=bigText.FontSize*2;
		}
		else{
			fontSizeWidth=(int) (bigText.FontSize*sY);
			//fontSizeHeight = (int) (bigText.FontSize*2*rect.height()/(10*y_eve));
		}
		if(Math.abs(fontSizeWidth)<3){
			return;
		}
		
		StrXY_Dig[] StrXY=new StrXY_Dig[5];
		
		getSymbolPoint_BigText(bigText, StrXY, rect, sX, sY, centerx, centery);
		
		boolean aaa=false;
		for(int i=0;i<4;i++){
			if(rect.contains(StrXY[i].ScreenX,StrXY[i].ScreenY)){
				aaa=true;
				break;
			}
		}
		
		
		if(!aaa){
			StrXY[4].ScreenX = StrXY[0].ScreenX;
			StrXY[4].ScreenY = StrXY[0].ScreenY;
			for(int i = 0;i<4;i++){
				if( IsLineSegmentCross(new Point(StrXY[i].ScreenX,StrXY[i].ScreenY),new Point(StrXY[i+1].ScreenX,StrXY[i+1].ScreenY), new Point(rect.left,rect.top),new Point(rect.left,rect.bottom) ) ){
					aaa = true;

					break;
				}
				if( IsLineSegmentCross( new Point(StrXY[i].ScreenX,StrXY[i].ScreenY),new Point(StrXY[i+1].ScreenX,StrXY[i+1].ScreenY), new Point(rect.left,rect.top),new Point(rect.right,rect.top) ) ){
					aaa = true;
					
					break;
				}
				if( IsLineSegmentCross( new Point(StrXY[i].ScreenX,StrXY[i].ScreenY),new Point(StrXY[i+1].ScreenX,StrXY[i+1].ScreenY), new Point(rect.left,rect.bottom),new Point(rect.right,rect.bottom) ) ){
					aaa = true;
					
					break;
				}
				if( IsLineSegmentCross( new Point(StrXY[i].ScreenX,StrXY[i].ScreenY),new Point(StrXY[i+1].ScreenX,StrXY[i+1].ScreenY), new Point(rect.right,rect.top),new Point(rect.right,rect.bottom) ) ){
					aaa = true;
					break;
				}
			}
		}
		
		if(aaa){
			int textColor;
			if((bigText.color^backMode)==0){
				textColor=Color.rgb(255, 255, 255)^backMode;
			}
			else{
				textColor=bigText.color;
			}
			Paint paint=new Paint();
			paint.setColor(textColor);
			paint.setTextSize(fontSizeWidth);
			canvas.drawText(bigText.Text, StrXY[0].ScreenX, StrXY[0].ScreenY, paint);
		}
	}
	
	public boolean IsLineSegmentCross(Point pFirst1, Point pFirst2, Point pSecond1, Point pSecond2){
		//每个线段的两点都在另一个线段的左右不同侧，则能断定线段相交
		//公式对于向量(x1,y1)->(x2,y2),判断点(x3,y3)在向量的左边,右边,还是线上.
		//p=x1(y3-y2)+x2(y1-y3)+x3(y2-y1).p<0 左侧,	p=0 线上, p>0 右侧
		long Linep1,Linep2;
		//判断pSecond1和pSecond2是否在pFirst1->pFirst2两侧
		Linep1 = pFirst1.x * (pSecond1.y - pFirst2.y) +
			pFirst2.x * (pFirst1.y - pSecond1.y) +
			pSecond1.x * (pFirst2.y - pFirst1.y);
		Linep2 = pFirst1.x * (pSecond2.y - pFirst2.y) +
			pFirst2.x * (pFirst1.y - pSecond2.y) +
			pSecond2.x * (pFirst2.y - pFirst1.y);
		if ( ((Linep1 ^ Linep2) >= 0 ) && !(Linep1==0 && Linep2==0))//符号位异或为0:pSecond1和pSecond2在pFirst1->pFirst2同侧
		{
			return false;
		}
		//判断pFirst1和pFirst2是否在pSecond1->pSecond2两侧
		Linep1 = pSecond1.x * (pFirst1.y - pSecond2.y) +
			pSecond2.x * (pSecond1.y - pFirst1.y) +
			pFirst1.x * (pSecond2.y - pSecond1.y);
		Linep2 = pSecond1.x * (pFirst2.y - pSecond2.y) +
			pSecond2.x * (pSecond1.y - pFirst2.y) +
			pFirst2.x * (pSecond2.y - pSecond1.y);
		if ( ((Linep1 ^ Linep2) >= 0 ) && !(Linep1==0 && Linep2==0))//符号位异或为0:pFirst1和pFirst2在pSecond1->pSecond2同侧
		{
			return false;
		}
		//否则判为相交
		return true;
	}
	public void getSymbolPoint_BigText(Str_BigText StrBigText,StrXY_Dig[] StrXY,Rect rect,float sX,float sY,double centerx,double centery){

		int FontSizeWidth,FontSizeHeight;		////屏幕尺寸
		//	int FontSizeWidth0,FontSizeHeight0;		////
		if(StrBigText.Style==0)
		{
			FontSizeWidth=StrBigText.FontSize;
			FontSizeHeight = StrBigText.FontSize*2;
		} 
		else
		{
			FontSizeWidth=(int) (StrBigText.FontSize*sY);
			FontSizeHeight = (int) (StrBigText.FontSize*2*sY);
		}
		if(FontSizeWidth<1)
		{
			FontSizeHeight=2;
			FontSizeWidth=1;
		}
		StrXY[0].ScreenX=(int) (rect.centerX()+(StrBigText.Point_y-centery)*sX);
		StrXY[0].ScreenY=(int) (rect.centerY()-(StrBigText.Point_x-centerx)*sY);
		StrXY[1].ScreenX=(int) (StrXY[0].ScreenX-FontSizeHeight*Math.sin(StrBigText.Angle*Math.PI/180));		//左下点
		StrXY[1].ScreenY=(int) (StrXY[0].ScreenY+FontSizeHeight*Math.cos(StrBigText.Angle*Math.PI/180));
		StrXY[2].ScreenX=(int) (StrXY[1].ScreenX+FontSizeHeight*Math.cos(StrBigText.Angle*Math.PI/180)*StrBigText.Text.length()/2);
		StrXY[2].ScreenY=(int) (StrXY[1].ScreenY+FontSizeHeight*Math.sin(StrBigText.Angle*Math.PI/180)*StrBigText.Text.length()/2);
		StrXY[3].ScreenX=(int) (StrXY[0].ScreenX+FontSizeHeight*Math.cos(StrBigText.Angle*Math.PI/180)*StrBigText.Text.length()/2);
		StrXY[3].ScreenY=(int) (StrXY[0].ScreenY+FontSizeHeight*Math.sin(StrBigText.Angle*Math.PI/180)*StrBigText.Text.length()/2);

		StrXY[0].GroundY=StrBigText.Point_y;
		StrXY[0].GroundX=StrBigText.Point_x;
		StrXY[1].GroundX=StrXY[0].GroundX-StrBigText.FontSize*2*Math.cos(StrBigText.Angle*3.1415926/180);		//左下点
		StrXY[1].GroundY=StrXY[0].GroundY-StrBigText.FontSize*2*Math.sin(StrBigText.Angle*3.1415926/180);
		StrXY[2].GroundX=StrXY[1].GroundX-StrBigText.FontSize*2*Math.sin(StrBigText.Angle*3.1415926/180)*StrBigText.Text.length()/2;
		StrXY[2].GroundY=StrXY[1].GroundY+StrBigText.FontSize*2*Math.cos(StrBigText.Angle*3.1415926/180)*StrBigText.Text.length()/2;
		StrXY[3].GroundX=StrXY[0].GroundX-StrBigText.FontSize*2*Math.sin(StrBigText.Angle*3.1415926/180)*StrBigText.Text.length()/2;
		StrXY[3].GroundY=StrXY[0].GroundY+StrBigText.FontSize*2*Math.cos(StrBigText.Angle*3.1415926/180)*StrBigText.Text.length()/2;
	}
	public void drawArc_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_Arc arc, int backMode){
	
		int lineColor;
		if((arc.color^backMode)==0){
			lineColor=backMode^Color.rgb(255, 255, 255);
		}
		else{
			lineColor=arc.color;
		}
		
		Paint paint=new Paint();
		paint.setColor(lineColor);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(1);
		StrXY_Dig[] StrXY=new StrXY_Dig[4];
		getSymbolPoint_Arc(arc, StrXY, rect, sX, sY, centerx, centery);
		
		boolean aaa=false;
		for(int i=0;i<4;i++){
			if(rect.contains(StrXY[i].ScreenX,StrXY[i].ScreenY)){
				aaa=true;
				break;
			}
		}
		if(!aaa){
			return;
		}
		double radum=arc.Radum*sY;
		RectF r=new RectF();
		r.left=(int) (StrXY[0].ScreenX-radum);
		r.right=(int) (StrXY[0].ScreenX+radum);
		r.top=(int) (StrXY[0].ScreenY-radum);
		r.bottom=(int) (StrXY[0].ScreenY+radum);
		
		float startAngle=(float) (Math.atan2(StrXY[1].ScreenY, StrXY[1].ScreenX)*180/Math.PI);
		float sweepAngle=(float) (Math.atan2(StrXY[2].ScreenY, StrXY[2].ScreenX)*180/Math.PI);
		PathEffect effect;
		switch (arc.Style) {
		case 0:
			
			canvas.drawArc(r, startAngle, sweepAngle, false, paint);
			break;
		case 1:
			effect=new DashPathEffect(new float[]{4, 2},1);
			paint.setPathEffect(effect);
			canvas.drawArc(r, startAngle, sweepAngle, false, paint);
			break;
		case 2:
			effect=new DashPathEffect(new float[]{1, 2},1);
			paint.setPathEffect(effect);
			canvas.drawArc(r, startAngle, sweepAngle, false, paint);
			break;
		case 3:
			effect=new DashPathEffect(new float[]{1, 2,4,3},1);
			paint.setPathEffect(effect);
			canvas.drawArc(r, startAngle, sweepAngle, false, paint);
			break;
		case 4:
			effect=new DashPathEffect(new float[]{1, 2,1,2,4,3},1);
			paint.setPathEffect(effect);
			canvas.drawArc(r, startAngle, sweepAngle, false, paint);
			break;
		default:
			canvas.drawArc(r, startAngle, sweepAngle, false, paint);
			break;
		}
	}
	
	public void getSymbolPoint_Arc(Str_Arc arc,StrXY_Dig[] StrXY,Rect rect,float sX,float sY,double centerx,double centery){
		double radum;
		float CenterAlpha;

		if(arc.BeginAngle<arc.EndAngle)
			CenterAlpha = (arc.BeginAngle+arc.EndAngle)/2-180;
		else 
			CenterAlpha = (arc.BeginAngle+arc.EndAngle)/2;

		radum=arc.Radum*sY;
		StrXY[0].ScreenY= (int) (rect.centerY()-(arc.x-centerx)*sY);
		StrXY[0].ScreenX=(int) (rect.centerX()+(arc.y-centery)*sX);

		StrXY[1].ScreenX=(int) (StrXY[0].ScreenX+Math.sin(arc.BeginAngle*Math.PI/180)*radum);
		StrXY[1].ScreenY=(int) (StrXY[0].ScreenY-Math.cos(arc.BeginAngle*Math.PI/180)*radum);
		StrXY[2].ScreenX=(int) (StrXY[0].ScreenX+Math.sin(arc.EndAngle*Math.PI/180)*radum);
		StrXY[2].ScreenY=(int) (StrXY[0].ScreenY-Math.cos(arc.EndAngle*Math.PI/180)*radum);
		StrXY[3].ScreenX=(int) (StrXY[0].ScreenX+Math.sin(CenterAlpha*Math.PI/180)*radum);
		StrXY[3].ScreenY=(int) (StrXY[0].ScreenY-Math.cos(CenterAlpha*Math.PI/180)*radum);

		StrXY[0].GroundX  =arc.x;
		StrXY[0].GroundY  =arc.y;
		StrXY[1].GroundX  =arc.x + Math.cos(arc.BeginAngle*Math.PI/180)*arc.Radum;
		StrXY[1].GroundY  =arc.y + Math.sin(arc.BeginAngle*Math.PI/180)*arc.Radum;
		StrXY[2].GroundX  =arc.x + Math.cos(arc.EndAngle*Math.PI/180)*arc.Radum;
		StrXY[2].GroundY  =arc.y + Math.sin(arc.EndAngle*Math.PI/180)*arc.Radum;
		
		StrXY[3].GroundX  =arc.x + Math.cos(CenterAlpha*3.1415926/180)*arc.Radum;
		StrXY[3].GroundY  =arc.y + Math.sin(CenterAlpha*3.1415926/180)*arc.Radum;
	}
	public void drawTideStation_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General tideStation, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		//int ra=8;

		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(tideStation.x-centerx)*sY);
		x0=(int)(pox+(tideStation.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setStyle(Paint.Style.STROKE);
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStrokeWidth(1);
			canvas.drawCircle(x0, y0, 2, paint);
			
			Path path=new Path();
			path.moveTo(x0-5,y0-5);
			path.lineTo(x0-5,y0+5);
			path.lineTo(x0+5,y0+5);
			path.lineTo(x0+5,y0-5);
			path.close();
			canvas.drawPath(path, paint);
		}
		
	}
	
	public void drawRack_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General rack, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=4;
		int ra1=3;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(rack.x-centerx)*sY);
		x0=(int)(pox+(rack.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setStyle(Paint.Style.STROKE);
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStrokeWidth(1);
			
			canvas.drawLine(x0,y0-2*ra, x0,y0+2*ra, paint);
			canvas.drawLine(x0-2*ra,y0, x0+2*ra,y0, paint);
			canvas.drawLine(x0-2*ra1,y0-2*ra1, x0+2*ra1,y0+2*ra1, paint);
			canvas.drawLine(x0-2*ra1,y0+2*ra1, x0+2*ra1,y0-2*ra1, paint);
		}
		
	}
	
	public void drawKettle_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General kettle, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=8;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(kettle.x-centerx)*sY);
		x0=(int)(pox+(kettle.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setStyle(Paint.Style.STROKE);
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStrokeWidth(1);
			
			canvas.drawCircle(x0, y0, ra, paint);
			
			canvas.drawLine(x0-3,y0-4, x0-3,y0+4, paint);
			canvas.drawLine(x0+3,y0-4, x0+3,y0+4, paint);
			canvas.drawLine(x0-4,y0-3, x0+4,y0-3, paint);
			canvas.drawLine(x0-4,y0+3, x0+4,y0+3, paint);
		}
		
	}
	
	public void drawPicket_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General picket, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=5;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(picket.x-centerx)*sY);
		x0=(int)(pox+(picket.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setStyle(Paint.Style.STROKE);
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStrokeWidth(1);
			
			canvas.drawCircle(x0, y0, ra, paint);
			canvas.drawCircle(x0, y0, 8, paint);
			
			
		}
		
	}
	
	public void drawText_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General text, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		//int ra=4;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(text.x-centerx)*sY);
		x0=(int)(pox+(text.y-centery)*sX);
		
		Rect r=new Rect();
		r.top=y0;
		r.bottom=r.top+12;
		r.left=x0;
		r.right=r.left+text.Label.length()*6;
		boolean aaa=false;
		if(rect.contains(r.left,r.top))
			aaa=true;
		if(rect.contains(r.right,r.bottom))
			aaa=true;
		
		if(!aaa){
			return;
		}
		Paint paint=new Paint();

		if(text.Label!=null){
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setTextSize(6);
			canvas.drawText(text.Label, x0, y0, paint);

		}
		
		
	}
	
	public void drawLight_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General light, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(light.x-centerx)*sY);
		x0=(int)(pox+(light.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(Color.rgb(0, 255, 0));
			paint.setStrokeWidth(1);
			
			Rect r=new Rect();
			r.top=y0-8;
			r.bottom=r.top+15;
			r.left=x0-8;
			r.right=r.left+15;
			
			canvas.drawRect(r, paint);
		}
		
	}
	
	public void drawShorLine_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_ShoreLine shoreLine, int backMode){
		if(shoreLine.x.size()<2)
			return;
		int width=rect.width();
		int height=rect.height();
		float pox,poy;
		pox=(float) (rect.left+0.5*width);
		poy=(float) (rect.top+0.5*height);
		
		int length=shoreLine.x.size();
		float[] px=new float[length];
		float[] py=new float[length];
		
		Iterator<Double> ix=shoreLine.x.iterator();
		Iterator<Double> iy=shoreLine.y.iterator();
		int index=0;
		while(ix.hasNext()){
			px[index]=(float) (poy-(ix.next()-centerx)*sY);
			py[index]=(float) (pox+(iy.next()-centery)*sX);
			index++;
		}

		Paint paint=new Paint();
		paint.setColor(backMode^Color.rgb(255, 255, 255));
		paint.setStrokeWidth(1);
		for(int i=0;i<length;i+=2){
			canvas.drawLine(px[i], py[i], px[i+1], py[i+1], paint);
		}
	}
	
	public void drawGreenBuoy_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General greenBuoy, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=4;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(greenBuoy.x-centerx)*sY);
		x0=(int)(pox+(greenBuoy.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(Color.rgb(0, 255, 0));
			paint.setStrokeWidth(1);
			
			Path path=new Path();
			path.moveTo(x0+2,y0-15);
			path.lineTo(x0-2,y0-5);
			path.lineTo(x0-7,y0);
			path.lineTo(x0-1,y0);
			path.lineTo(x0-1,y0-1);
			path.lineTo(x0+1,y0-1);
			path.lineTo(x0+1,y0);
			path.lineTo(x0+7,y0);
			path.lineTo(x0+4,y0-3);

			path.close();
			canvas.drawPath(path, paint);
			
			paint.setStyle(Paint.Style.STROKE);
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			canvas.drawPath(path, paint);
			
			paint.setColor(Color.BLACK);
			canvas.drawLine(x0-1, y0-1, x0+1, y0-1, paint);
			
			if(greenBuoy.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(greenBuoy.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawRedBuoy_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General redBuoy, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=4;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(redBuoy.x-centerx)*sY);
		x0=(int)(pox+(redBuoy.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(Color.rgb(255, 0, 0));
			paint.setStrokeWidth(1);
			
			Path path=new Path();
			path.moveTo(x0+2,y0-15);
			path.lineTo(x0-2,y0-5);
			path.lineTo(x0-7,y0);
			path.lineTo(x0-1,y0);
			path.lineTo(x0-1,y0-1);
			path.lineTo(x0+1,y0-1);
			path.lineTo(x0+1,y0);
			path.lineTo(x0+7,y0);
			path.lineTo(x0+4,y0-3);

			path.close();
			canvas.drawPath(path, paint);
			
			paint.setStyle(Paint.Style.STROKE);
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			canvas.drawPath(path, paint);
			
			paint.setColor(Color.BLACK);
			canvas.drawLine(x0-1, y0-1, x0+1, y0-1, paint);
			
			if(redBuoy.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(redBuoy.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawWhiteBuoy_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General whiteBuoy, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=4;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(whiteBuoy.x-centerx)*sY);
		x0=(int)(pox+(whiteBuoy.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(Color.rgb(255, 255, 255));
			paint.setStrokeWidth(1);
			
			Path path=new Path();
			path.moveTo(x0+2,y0-15);
			path.lineTo(x0-2,y0-5);
			path.lineTo(x0-7,y0);
			path.lineTo(x0-1,y0);
			path.lineTo(x0-1,y0-1);
			path.lineTo(x0+1,y0-1);
			path.lineTo(x0+1,y0);
			path.lineTo(x0+7,y0);
			path.lineTo(x0+4,y0-3);

			path.close();
			canvas.drawPath(path, paint);
			
			paint.setStyle(Paint.Style.STROKE);
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			canvas.drawPath(path, paint);
			
			paint.setColor(Color.BLACK);
			canvas.drawLine(x0-1, y0-1, x0+1, y0-1, paint);
			
			if(whiteBuoy.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(whiteBuoy.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawNavigateMark_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General navigateMark, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=4;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(navigateMark.x-centerx)*sY);
		x0=(int)(pox+(navigateMark.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setStyle(Paint.Style.STROKE);
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStrokeWidth(1);
			
			canvas.drawCircle(x0, y0, ra, paint);
			Path path=new Path();
			path.moveTo(x0,y0-2*ra);
			path.lineTo(x0-2*ra,y0+ra);
			path.lineTo(x0+2*ra,y0+ra);

			path.close();
			canvas.drawPath(path, paint);
			
			
			if(navigateMark.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(navigateMark.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawCircle_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_Circle circle, int backMode){
		
		int width=rect.width();
		int height=rect.height();
		float pox,poy;
		float x0,y0,radum;
		
		pox=rect.left+0.5f*width;
		poy=rect.top+0.5f*height;
	
		canvas.drawColor(Color.TRANSPARENT);
		Paint paint=new Paint();
		paint.setStyle(Paint.Style.FILL);

		int lineColor,fillColor;
		if((circle.color^backMode)==0){
			lineColor=Color.rgb(255, 255, 255)^backMode;
		}
		else{
			lineColor=circle.color;
		}
		if((circle.FillColor^backMode)==0){
			fillColor=Color.rgb(255, 255, 255)^backMode;
		}
		else{
			fillColor=circle.FillColor;
		}
		
		
		
		y0=(float) (poy-(circle.x-centerx)*sY);
		x0=(float) (pox+(circle.y-centery)*sX);
		radum = circle.Radum*sY;
		if(circle.FillCircle){
			paint.setColor(fillColor);
			paint.setStyle(Paint.Style.FILL);
			canvas.drawCircle(x0, y0, radum, paint);
		}
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(lineColor);
		PathEffect effect;
		switch (circle.Style) {
		case 0:
			
			canvas.drawCircle(x0, y0, radum, paint);
			break;
		case 1:
			effect=new DashPathEffect(new float[]{4, 2},1);
			paint.setPathEffect(effect);
			canvas.drawCircle(x0, y0, radum, paint);
			break;
		case 2:
			effect=new DashPathEffect(new float[]{1, 2},1);
			paint.setPathEffect(effect);
			canvas.drawCircle(x0, y0, radum, paint);
			break;
		case 3:
			effect=new DashPathEffect(new float[]{1, 2,4,3},1);
			paint.setPathEffect(effect);
			canvas.drawCircle(x0, y0, radum, paint);
			break;
		case 4:
			effect=new DashPathEffect(new float[]{1, 2,1,2,4,3},1);
			paint.setPathEffect(effect);
			canvas.drawCircle(x0, y0, radum, paint);
			break;
		default:
			canvas.drawCircle(x0, y0, radum, paint);
			break;
		}
		
		
	}
	
	public void drawSolid_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_Solid solid, int backMode){
		if(solid.x.size()<2){
			return;
		}
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int length=solid.x.size();
		
		double[] px=new double[length];
		double[] py=new double[length];
		
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		for(int i=0;i<length;i++){
			py[i]=poy-(solid.x.get(i)-centerx)*sY;
			px[i]=pox+(solid.y.get(i)-centery)*sX;
		}
		/*Iterator<Double> ix=solid.x.iterator();
		Iterator<Double> iy=solid.y.iterator();
		int index=0;
		while(ix.hasNext()){
			py[index]=poy-(ix.next()-centerx)*height/(10*y_eve);
			px[index]=pox+(iy.next()-centery)*width/(10*y_eve);
			index++;
		}*/
		
		
		
		canvas.drawColor(Color.TRANSPARENT);
		Paint paint=new Paint();
		paint.setStyle(Paint.Style.FILL);

		int lineColor,fillColor;
		if((solid.LineColor^backMode)==0){
			lineColor=Color.rgb(255, 255, 255)^backMode;
		}
		else{
			lineColor=solid.LineColor;
		}
		if((solid.FillColor^backMode)==0){
			fillColor=Color.rgb(255, 255, 255)^backMode;
		}
		else{
			fillColor=solid.FillColor;
		}
		paint.setColor(fillColor);
		paint.setStrokeWidth(1);
		Path path=new Path();
		path.moveTo((float)px[0], (float)py[0]);
		for(int i=1;i<length;i++){
			path.lineTo((float)px[i], (float)py[i]);
		}
		path.close();

		canvas.drawPath(path, paint);

		paint.setColor(lineColor);
		paint.setStyle(Paint.Style.STROKE);
		canvas.drawPath(path, paint);
		
	}
	
	public void drawWrecks_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General wreaks, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(wreaks.x-centerx)*sY);
		x0=(int)(pox+(wreaks.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStrokeWidth(1);
			Path path=new Path();
			path.moveTo(x0+7, y0+4);
			path.lineTo(x0-4, y0+4);
			path.lineTo(x0-8, y0-3);

			path.close();
			canvas.drawPath(path, paint);
			
			paint.setStrokeWidth(2);
			canvas.drawLine(x0+7,y0+4, x0-8,y0+4, paint);
			canvas.drawLine(x0+1,y0-8, x0-1.7f,y0+2.3f, paint);
			
			
			paint.setColor(Color.BLACK);
			canvas.drawLine(x0-1, y0-1, x0+1, y0-1, paint);
			if(wreaks.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(wreaks.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawNum_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General num, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		//int ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(num.x-centerx)*sY);
		x0=(int)(pox+(num.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			
			paint.setStrokeWidth(1);
			
			if(num.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				
				paint.setTextSize(12*sY);
				canvas.drawText(num.Label, x0-9, y0-12, paint);
				
				paint.setStyle(Paint.Style.STROKE);
				Path path=new Path();
				path.moveTo(x0+10,y0-5);
				path.lineTo(x0+10,y0+5);
				path.lineTo(x0-10,y0+5);
				path.lineTo(x0-10,y0-5);
				canvas.drawPath(path, paint);
				
				
			}
		}
		
	}
	
	public void drawBuoyBlackYellow_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General buoyBlackYellow, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(buoyBlackYellow.x-centerx)*sY);
		x0=(int)(pox+(buoyBlackYellow.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(Color.rgb(255, 255, 0));
			paint.setStrokeWidth(1);
			Path path=new Path();
			path.moveTo(x0+2, y0-15);
			path.lineTo(x0-2, y0-5);
			path.lineTo(x0-7, y0);
			path.lineTo(x0-1, y0);
			path.lineTo(x0-1, y0-1);
			path.lineTo(x0, y0-1);
			
			path.close();
			canvas.drawPath(path, paint);
			
			paint.setColor(Color.rgb(0, 0, 0));
			path=new Path();
			path.moveTo(x0+2, y0-15);
			path.lineTo(x0, y0-1);
			path.lineTo(x0+1, y0-1);
			path.lineTo(x0+1, y0);
			path.lineTo(x0+7, y0);
			path.lineTo(x0+4, y0-3);
			
			path.close();
			canvas.drawPath(path, paint);
			
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStyle(Paint.Style.STROKE);
			path=new Path();			
			
			path.moveTo(x0+2,y0-15);
			path.lineTo(x0-2,y0-5);
			path.lineTo(x0-7,y0);
			path.lineTo(x0-1,y0);
			path.lineTo(x0-1,y0-1);
			path.lineTo(x0+1,y0-1);
			path.lineTo(x0+1,y0);
			path.lineTo(x0+7,y0);
			path.lineTo(x0+4,y0-3);
			path.close();
			canvas.drawPath(path, paint);
			
			paint.setColor(Color.BLACK);
			canvas.drawLine(x0-1, y0-1, x0+1, y0-1, paint);
			if(buoyBlackYellow.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(buoyBlackYellow.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawFishNet_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General fishNet, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(fishNet.x-centerx)*sY);
		x0=(int)(pox+(fishNet.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			
			paint.setStyle(Paint.Style.STROKE);
			
			paint.setColor(Color.rgb(255, 0, 0));
			
			paint.setStrokeWidth(1);
		
			Path path=new Path();
			path.moveTo(x0+14,y0);
			path.lineTo(x0+3,y0-6);
			path.lineTo(x0-3,y0-4);
			path.lineTo(x0-12,y0+5);
			
			canvas.drawPath(path, paint);

			path=new Path();
			path.moveTo(x0+14,y0);
			path.lineTo(x0+3,y0+6);
			path.lineTo(x0-3,y0+4);
			path.lineTo(x0-12,y0-5);
			
			canvas.drawPath(path, paint);
			
			canvas.drawLine(x0+6,y0+4, x0+4,y0, paint);
			canvas.drawLine(x0+4,y0, x0+6,y0-4, paint);
			
			Rect r=new Rect();
			r.left=x0+9;
			r.right=r.left+2;
			r.top=y0-1;
			r.bottom=y0+1;
			canvas.drawRect(r, paint);
			
			if(fishNet.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(fishNet.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawBuoy5_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General buoy5, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(buoy5.x-centerx)*sY);
		x0=(int)(pox+(buoy5.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			
			paint.setStyle(Paint.Style.STROKE);
			
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			
			paint.setStrokeWidth(3);

			
			canvas.drawLine(x0-8,y0, x0+8,y0, paint);
			canvas.drawLine(x0-3,y0+2, x0+3,y0+2, paint);
			
			Path path=new Path();
			path.moveTo(x0-3,y0);
			path.lineTo(x0-3,y0-18);
			path.lineTo(x0+3,y0-18);
			path.lineTo(x0+3,y0);
			
			canvas.drawPath(path, paint);
			
			canvas.drawLine(x0,y0-18, x0,y0-22, paint);
			path=new Path();
			path.moveTo(x0-3,y0-22);
			path.lineTo(x0+3,y0-22);
			path.lineTo(x0+3,y0-26);
			path.lineTo(x0-3,y0-26);
			path.lineTo(x0-3,y0-22);
			
			canvas.drawPath(path, paint);
			
			if(buoy5.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(buoy5.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawBuoy6_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General buoy6, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(buoy6.x-centerx)*sY);
		x0=(int)(pox+(buoy6.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			
			paint.setStyle(Paint.Style.STROKE);
			
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			
			paint.setStrokeWidth(1);

			
			Path path=new Path();
			path.moveTo(x0+4,y0);
			path.lineTo(x0-4,y0);
			path.lineTo(x0-4,y0-18);
			path.lineTo(x0+4,y0-18);
			path.close();
			canvas.drawPath(path, paint);
			
			canvas.drawLine(x0,y0-18, x0,y0-20, paint);
			path=new Path();
			path.moveTo(x0-4,y0-20);
			path.lineTo(x0+4,y0-20);
			path.lineTo(x0+4,y0-24);
			path.lineTo(x0-4,y0-24);
			path.close();
			
			canvas.drawPath(path, paint);
			
			path=new Path();
			path.moveTo(x0-4,y0);
			path.lineTo(x0-4,y0+4);
			path.lineTo(x0-10,y0+4);
			
			canvas.drawPath(path, paint);
			
			path=new Path();
			path.moveTo(x0+4,y0);
			path.lineTo(x0+4,y0+4);
			path.lineTo(x0+10,y0+4);
			
			canvas.drawPath(path, paint);
			
			if(buoy6.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(buoy6.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawBuoy7_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General buoy7, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(buoy7.x-centerx)*sY);
		x0=(int)(pox+(buoy7.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			
			paint.setStyle(Paint.Style.STROKE);
			
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			
			paint.setStrokeWidth(1);

			canvas.drawCircle(x0, y0+6, 2, paint);
			canvas.drawLine(x0-2,y0+6, x0-10,y0+6, paint);
			canvas.drawLine(x0+2,y0+6, x0+10,y0+6, paint);
			
			Path path=new Path();
			path.moveTo(x0-8,y0+6);
			path.lineTo(x0-3,y0-2);
			path.lineTo(x0+1,y0-7);
			path.lineTo(x0+6,y0+1);
			path.lineTo(x0+8,y0+6);
			//path.close();
			canvas.drawPath(path, paint);
			
			canvas.drawLine(x0+1,y0-7, x0+2,y0-10, paint);
			canvas.drawLine(x0,y0-9, x0+4,y0-8, paint);
			
			
			if(buoy7.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(buoy7.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawBuoy8_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General buoy8, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(buoy8.x-centerx)*sY);
		x0=(int)(pox+(buoy8.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(Color.RED);
			paint.setStrokeWidth(1);
			Path path=new Path();
			path.moveTo(x0+2, y0-15);
			path.lineTo(x0-2, y0-5);
			path.lineTo(x0-7, y0);
			path.lineTo(x0-1, y0);
			path.lineTo(x0-1, y0-1);
			path.lineTo(x0+1, y0-1);
			path.lineTo(x0+1, y0);
			path.lineTo(x0+7, y0);
			path.lineTo(x0+4, y0-3);
			path.close();
			canvas.drawPath(path, paint);
			
			paint.setColor(Color.WHITE);
			path=new Path();
			path.moveTo(x0+2, y0-15);
			path.lineTo(x0-0, y0-5);
			path.lineTo(x0-3, y0);
			path.lineTo(x0-1, y0);
			path.lineTo(x0-1, y0-1);
			path.lineTo(x0+1, y0-1);
			path.lineTo(x0+1, y0);
			path.lineTo(x0+3, y0);
			path.lineTo(x0+2, y0-3);
			path.close();
			canvas.drawPath(path, paint);
			
			paint.setColor(Color.RED);
			canvas.drawLine(x0-1, y0-1, x0+1, y0-1, paint);
			
			if(buoy8.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(buoy8.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawBuoy9_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General buoy9, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(buoy9.x-centerx)*sY);
		x0=(int)(pox+(buoy9.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(Color.rgb(255, 255, 0));
			paint.setStrokeWidth(1);
			Path path=new Path();
			path.moveTo(x0+2, y0-15);
			path.lineTo(x0-2, y0-5);
			path.lineTo(x0-7, y0);
			path.lineTo(x0-1, y0);
			path.lineTo(x0-1, y0-1);
			path.lineTo(x0+1, y0-1);
			path.lineTo(x0+1, y0);
			path.lineTo(x0+7, y0);
			path.lineTo(x0+4, y0-3);
			path.close();
			canvas.drawPath(path, paint);
			
			
			
			paint.setColor(Color.rgb(0, 0, 0));
			canvas.drawLine(x0-1, y0-1, x0+1, y0-1, paint);
			
			if(buoy9.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(buoy9.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawBuoy10_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General buoy10, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(buoy10.x-centerx)*sY);
		x0=(int)(pox+(buoy10.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(Color.rgb(0, 0, 0));
			paint.setStrokeWidth(1);
			Path path=new Path();
			path.moveTo(x0+2, y0-15);
			path.lineTo(x0-2, y0-5);
			path.lineTo(x0-7, y0);
			path.lineTo(x0-1, y0);
			path.lineTo(x0-1, y0-1);
			path.lineTo(x0+1, y0-1);
			path.lineTo(x0+1, y0);
			path.lineTo(x0+7, y0);
			path.lineTo(x0+4, y0-3);
			path.close();
			canvas.drawPath(path, paint);
			
			
			
			paint.setColor(Color.rgb(0, 0, 0));
			canvas.drawLine(x0-1, y0-1, x0+1, y0-1, paint);
			
			if(buoy10.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(buoy10.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawBuoy4_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General buoy4, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=14;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(buoy4.x-centerx)*sY);
		x0=(int)(pox+(buoy4.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(Color.RED);
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(2);
			RectF rf=new RectF();
			rf.left=x0-12;
			rf.top=y0-12;
			rf.right=x0+12;
			rf.bottom=y0+12;
			float startAngle=(float)(Math.atan2(-12, 2)*180/Math.PI);
			float sweepAngle=(float)(Math.atan2(-5, 11)*180/Math.PI);
			canvas.drawArc(rf, startAngle, sweepAngle, false, paint);
			
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			
			paint.setStrokeWidth(1);
			rf.left=x0+6;
			rf.top=y0-13;
			rf.right=x0+8.5f;
			rf.bottom=y0-10;
			canvas.drawArc(rf, 0, 360, false, paint);
			
			rf.left=x0-2;
			rf.top=y0+3;
			rf.right=x0+2;
			rf.bottom=y0+8;
			canvas.drawArc(rf, 0, 360, false, paint);
			
			
			//canvas.drawCircle(x0, y0+3, 2, paint);
			
			canvas.drawLine(x0-2,y0+5, x0-10,y0+5, paint);
			canvas.drawLine(x0+2,y0+5, x0+10,y0+5, paint);
			
			Path path=new Path();
			path.moveTo(x0+4,y0+5);
			path.lineTo(x0+3,y0+4);
			path.lineTo(x0+3,y0-1);
			path.lineTo(x0+6,y0-7);
			path.lineTo(x0+6,y0-10);
			path.lineTo(x0+4,y0-10);
			path.lineTo(x0-3,y0+2);
			path.lineTo(x0-7,y0+5);
			
			canvas.drawPath(path, paint);
			
			if(buoy4.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(buoy4.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawBuoy3_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General buoy3, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=10;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(buoy3.x-centerx)*sY);
		x0=(int)(pox+(buoy3.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(1);
			
			RectF rf=new RectF();
			rf.left=x0-2;
			rf.top=y0+1;
			rf.right=x0+2;
			rf.bottom=y0+5;
			canvas.drawArc(rf, 0, 360, false, paint);
			
			//canvas.drawCircle(x0, y0+3, 2, paint);
			
			canvas.drawLine(x0-10,y0+3, x0-2,y0+3, paint);
			canvas.drawLine(x0+10,y0+3, x0+2,y0+3, paint);
			
			Path path=new Path();
			path.moveTo(x0-7,y0+3);
			path.lineTo(x0-7,y0-5);
			path.lineTo(x0+7,y0-5);
			path.lineTo(x0+7,y0+3);
			
			canvas.drawPath(path, paint);
			
			if(buoy3.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(buoy3.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawBuoy2_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General buoy2, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=10;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(buoy2.x-centerx)*sY);
		x0=(int)(pox+(buoy2.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(1);
			
			//canvas.drawCircle(x0, y0+3, 2, paint);
			RectF rf=new RectF();
			rf.left=x0-2;
			rf.top=y0+1;
			rf.right=x0+2;
			rf.bottom=y0+5;
			canvas.drawArc(rf, 0, 360, false, paint);
			
			canvas.drawLine(x0-8,y0+3, x0-2,y0+3, paint);
			canvas.drawLine(x0+8,y0+3, x0+2,y0+3, paint);
			
			Path path=new Path();
			path.moveTo(x0-6,y0+3);
			path.lineTo(x0-4,y0-4);
			path.lineTo(x0+2,y0-8);
			path.lineTo(x0+5,y0-2);
			path.lineTo(x0+6,y0+3);
			
			canvas.drawPath(path, paint);
			
			if(buoy2.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(buoy2.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawImage_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_Image image, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		//int ra=10;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(image.x-centerx)*sY);
		x0=(int)(pox+(image.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			Paint paint=new Paint();
			
			Bitmap bitmap=getLoacalBitmap(image.PathName);
			
			canvas.drawBitmap(bitmap, x0, y0, paint);
		}
		
	}
	
	public static Bitmap getLoacalBitmap(String url) {
        try {
             FileInputStream fis = new FileInputStream(url);
             return BitmapFactory.decodeStream(fis);  ///把流转化为Bitmap图片         

          } catch (FileNotFoundException e) {
             e.printStackTrace();
             return null;
        }
   }


	
	public void drawBuoy1_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General buoy1, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=10;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(buoy1.x-centerx)*sY);
		x0=(int)(pox+(buoy1.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(1);
			
			canvas.drawCircle(x0, y0, 2, paint);
			
			canvas.drawLine(x0-8,y0, x0-2,y0, paint);
			canvas.drawLine(x0+2,y0, x0+8,y0, paint);
			
			Path path=new Path();
			path.moveTo(x0-6,y0);
			path.lineTo(x0-3,y0-8);
			path.lineTo(x0+8,y0-5);
			path.lineTo(x0+6,y0);
			
			canvas.drawPath(path, paint);
			
			if(buoy1.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(buoy1.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawAquatic_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General aquatic, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=10;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(aquatic.x-centerx)*sY);
		x0=(int)(pox+(aquatic.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(2);
			
			canvas.drawLine(x0-8,y0-4, x0+6,y0-4, paint);
			canvas.drawLine(x0-3,y0-4, x0-8,y0+4, paint);
			canvas.drawLine(x0,y0-4, x0,y0+2, paint);
			canvas.drawLine(x0+3,y0-4, x0+5,y0, paint);
			
			if(aquatic.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(aquatic.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawIslandReef_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General islandReef, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=10;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(islandReef.x-centerx)*sY);
		x0=(int)(pox+(islandReef.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(1);
			
			Path path=new Path();
			path.moveTo(x0, y0-9);
			path.lineTo(x0+1, y0-6);
			path.lineTo(x0+7, y0-1);
			path.lineTo(x0+4, y0+10);
			path.lineTo(x0+1, y0+7);
			path.lineTo(x0-4, y0+5);
			path.lineTo(x0-2, y0);
			path.lineTo(x0-7, y0-2);
			path.lineTo(x0-5, y0-6);
			path.lineTo(x0-1, y0-9);
			canvas.drawPath(path, paint);
			
			if(islandReef.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(islandReef.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawRadarReflector_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General radarReflector, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(radarReflector.x-centerx)*sY);
		x0=(int)(pox+(radarReflector.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(Color.rgb(255, 0, 0));
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(2);
			
			RectF rf=new RectF();
			rf.left=x0-ra;
			rf.top=y0-ra;
			rf.right=x0+ra;
			rf.bottom=y0+ra;
			float beginAngle=(float)(Math.atan2(-6, 10)*180/Math.PI);
			float sweepAngle=(float)(Math.atan2(-6, -10)*180/Math.PI);
			
			canvas.drawArc(rf, beginAngle, sweepAngle, false, paint);
			
			canvas.drawLine(x0-10.09f,y0-6, x0-14.6169f,y0-9, paint);

			canvas.drawLine(x0-5.6952f,y0-11, x0-8.2524f,y0-15, paint);
			
			canvas.drawLine(x0,y0-12, x0,y0-17, paint);
			canvas.drawLine(x0+5.6952f,y0-11, x0+8.2524f,y0-15, paint);
			canvas.drawLine(x0+10.09f,y0-6, x0+14.6169f,y0-9, paint);
			
			
			if(radarReflector.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(radarReflector.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawWaterTower_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General waterTower, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=20;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(waterTower.x-centerx)*sY);
		x0=(int)(pox+(waterTower.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(1);
			
			canvas.drawLine(x0-7,y0, x0+7,y0, paint);
			Path path=new Path();
			
			path.moveTo(x0-5,y0);
			path.lineTo(x0-5,y0-5);
			path.lineTo(x0-2,y0 - 5);
			path.lineTo(x0-2,y0 - 14);
			path.lineTo(x0-6,y0 - 14);
			path.lineTo(x0-6,y0 - 19);
			path.lineTo(x0+6,y0 - 19);
			path.lineTo(x0+6,y0-14);
			
			path.lineTo(x0+2,y0 - 14);
			path.lineTo(x0+2,y0-5);
			path.lineTo(x0+5,y0-5);
			path.lineTo(x0+5,y0);

			canvas.drawPath(path, paint);
	
			canvas.drawLine(x0-2,y0-14, x0+2,y0-14, paint);
			
			if(waterTower.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(waterTower.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawChimney_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General chimney, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=15;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(chimney.x-centerx)*sY);
		x0=(int)(pox+(chimney.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(1);
			
			canvas.drawLine(x0-4,y0, x0+4,y0, paint);
			Path path=new Path();
			
			path.moveTo(x0-2,y0);
			path.lineTo(x0-2,y0-6);
			path.lineTo(x0-1,y0-6);
			path.lineTo(x0-1,y0-17);
			path.lineTo(x0,y0-20);
			path.lineTo(x0+1,y0-17);
			path.lineTo(x0+1,y0-6);
			path.lineTo(x0+2,y0-6);
			path.close();
			canvas.drawPath(path, paint);

			
			
			RectF rf=new RectF();
			rf.left=x0;
			rf.top=y0-21;
			rf.right=x0+5;
			rf.bottom=y0-19;
			canvas.drawArc(rf, 0, 360, false, paint);
			
			rf.left=x0+5;
			rf.top=y0-21;
			rf.right=x0+10;
			rf.bottom=y0-19;
			canvas.drawArc(rf, 0, 360, false, paint);
			
			if(chimney.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(chimney.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawAnchor_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General anchor, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=15;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(anchor.x-centerx)*sY);
		x0=(int)(pox+(anchor.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(1);
			
			canvas.drawLine(x0-5,y0-5, x0,y0, paint);
			canvas.drawLine(x0,y0, x0+5,y0-5, paint);
			canvas.drawLine(x0,y0, x0,y0-ra, paint);
			canvas.drawLine(x0-5,y0-12, x0+5,y0-12, paint);
			
			RectF rf=new RectF();
			rf.left=x0-2;
			rf.top=y0-19;
			rf.right=x0+2;
			rf.bottom=y0-15;
			canvas.drawArc(rf, 0, 360, false, paint);
			
			if(anchor.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(anchor.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawTree_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General tree, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=20;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(tree.x-centerx)*sY);
		x0=(int)(pox+(tree.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(backMode^Color.rgb(0, 255, 0));
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(1);
			canvas.drawLine(x0-5,y0, x0+5,y0, paint);
			
			Path path=new Path();
			path.moveTo(x0, y0-20);
			path.lineTo(x0 - 3, y0 - 14);
			path.lineTo(x0, y0 - 14);
			path.lineTo(x0 - 5, y0 - 10);
			path.lineTo(x0, y0 - 10);
			path.lineTo(x0 - 7, y0 - 5);
			path.lineTo(x0 - 1, y0 - 5);
			path.lineTo(x0 - 1, y0);
			path.lineTo(x0 + 1, y0);
			path.lineTo(x0 + 1, y0 - 5);
			path.lineTo(x0 + 7, y0 - 5);
			path.lineTo(x0, y0 - 10);
			path.lineTo(x0 + 5, y0 - 10);
			path.lineTo(x0, y0 - 14);
			path.lineTo(x0 + 3, y0 - 14);
			path.close();
			canvas.drawPath(path, paint);
			
			if(tree.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(tree.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	
	public void drawHospital_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General hospital, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(hospital.x-centerx)*sY);
		x0=(int)(pox+(hospital.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(1);
			RectF rf=new RectF();
			rf.left=x0-ra;
			rf.top=y0-ra;
			rf.right=x0+ra;
			rf.bottom=y0+ra;
			canvas.drawArc(rf, 0, 360, false, paint);
			
			paint.setColor(Color.rgb(255, 0, 0));
			paint.setStrokeWidth(3);
			canvas.drawLine(x0-ra+2,y0, x0+ra-2,y0, paint);
			canvas.drawLine(x0,y0-ra+2, x0,y0+ra-2, paint);
			
			if(hospital.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(hospital.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawReadFlag_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General redFlag, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(redFlag.x-centerx)*sY);
		x0=(int)(pox+(redFlag.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(Color.rgb(255, 0, 0));
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(2);
			canvas.drawLine(x0-ra/2,y0, x0+ra/2,y0, paint);
			canvas.drawLine(x0,y0, x0,y0-ra*2, paint);
			
			paint.setStrokeWidth(5);
			canvas.drawLine(x0+1,y0-ra*3/2, x0+ra/2,y0-ra*3/2, paint);

			paint.setStrokeWidth(1);
			if(redFlag.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(redFlag.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawBeacon_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General beacon, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=14;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(beacon.x-centerx)*sY);
		x0=(int)(pox+(beacon.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(Color.rgb(255, 0, 0));
			paint.setStyle(Paint.Style.STROKE);
			
			Path path=new Path();
			path.moveTo(x0-ra, y0-ra);
			path.lineTo(x0-16, y0-13);
			path.lineTo(x0-11, y0-9);
			path.lineTo(x0-4, y0-4);
			//path.close();
			canvas.drawPath(path, paint);
			
			path=new Path();
			path.moveTo(x0-ra, y0-ra);
			path.lineTo(x0-13, y0-16);
			path.lineTo(x0-9, y0-11);
			path.lineTo(x0-4, y0-4);
			//path.close();
			canvas.drawPath(path, paint);
			
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			path=new Path();
			path.moveTo(x0-4, y0-1);
			path.lineTo(x0-1, y0-1);
			path.lineTo(x0, y0-5);
			path.lineTo(x0+1, y0-1);
			path.lineTo(x0+5, y0-1);
			path.lineTo(x0 + 2, y0 + 1);
			path.lineTo(x0 + 3, y0 + 4);
			path.lineTo(x0, y0+2);
			path.lineTo(x0 - 3, y0 + 4);
			path.lineTo(x0 - 2, y0 + 1);
			path.lineTo(x0 - 5, y0 - 2);
			//path.close();
			canvas.drawPath(path, paint);
			
			if(beacon.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(beacon.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawReportPoint_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General reportPoint, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(reportPoint.x-centerx)*sY);
		x0=(int)(pox+(reportPoint.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(Color.rgb(255, 0, 0));
			paint.setStyle(Paint.Style.STROKE);
			
			Path path=new Path();
			path.moveTo(x0-ra, y0);
			path.lineTo(x0, y0-ra/2);
			path.lineTo(x0+ra, y0);
			path.lineTo(x0, y0+ra/2);
			path.close();
			canvas.drawPath(path, paint);
			
			RectF rf=new RectF();
			rf.left=x0-5.37f;
			rf.top=y0-5.37f;
			rf.right=x0+5.37f;
			rf.bottom=y0+5.37f;

			canvas.drawArc(rf, 0, 360, false, paint);
			
			if(reportPoint.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(reportPoint.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawWaterStand_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General waterStand, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=10;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(waterStand.x-centerx)*sY);
		x0=(int)(pox+(waterStand.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(Color.rgb(255, 0, 0));
			paint.setStyle(Paint.Style.STROKE);
			
			RectF rf=new RectF();
			rf.left=x0-ra;
			rf.top=y0-ra;
			rf.right=x0+ra;
			rf.bottom=y0+ra;

			canvas.drawArc(rf, 0, 360, false, paint);
			
			paint.setStyle(Paint.Style.FILL);
			Path path=new Path();
			path.moveTo(x0, y0 - ra);
			path.lineTo(x0 - ra/2, y0);
			path.lineTo(x0, y0 +ra);
			path.lineTo(x0 +ra/2, y0);
			path.close();
			canvas.drawPath(path, paint);
			if(waterStand.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(waterStand.Label, x0-ra*5, y0+ra/2, paint);
				
			}

		}
		
	}
	
	public void drawOilWell_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General oilWell, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0;
		int ra=14;
		int line= 2;
		int ra2 =3;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(oilWell.x-centerx)*sY);
		x0=(int)(pox+(oilWell.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStyle(Paint.Style.STROKE);
			Path path=new Path();
			path.moveTo(x0-ra2,y0-ra2);
			path.lineTo(x0+ra2-0.5f,y0-ra2);
			path.lineTo(x0+ra2-0.5f,y0+ra2);
			path.lineTo(x0-ra2,y0+ra2);
			path.close();
			canvas.drawPath(path, paint);
			
			RectF rf=new RectF();
			rf.left=x0-line;
			rf.top=y0-line;
			rf.right=x0+line;
			rf.bottom=y0+line;

			canvas.drawArc(rf, 0, 360, false, paint);
			
			paint.setColor(Color.rgb(255, 0, 0));
			path=new Path();
			path.moveTo(x0 - ra, y0 - ra);
			path.lineTo(x0 - 16, y0 - 13);
			path.lineTo(x0 - 12, y0 - 9);
			path.lineTo(x0 - 4, y0 - 4);
			path.close();
			canvas.drawPath(path, paint);
			
			path=new Path();
			path.moveTo(x0 - ra, y0 - ra);
			path.lineTo(x0 - 13, y0 - 16);
			path.lineTo(x0 - 9, y0 - 12);
			path.lineTo(x0 - 4, y0 - 4);
			path.close();
			canvas.drawPath(path, paint);
			
			if(oilWell.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(oilWell.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	
	public void drawSettleShip_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General settleShip, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0,ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(settleShip.x-centerx)*sY);
		x0=(int)(pox+(settleShip.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(Color.rgb(255, 0, 0));
			canvas.drawLine(x0-ra*2/3-1, y0, x0+ra*2/3, y0, paint);
			canvas.drawLine(x0-ra/3, y0-ra/4, x0-ra/3, y0+ra/4, paint);
			canvas.drawLine(x0, y0-ra/3, x0, y0+ra/3, paint);
			canvas.drawLine(x0+ra/3, y0-ra/4, x0+ra/3, y0+ra/4, paint);
			
			if(settleShip.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(settleShip.Label, x0-ra*5, y0+ra/2, paint);
				
			}
		}
		
	}
	public void drawLightShip_digData(Canvas canvas,Rect rect,float sX,float sY,double centerx,double centery,Str_General lightShip, int backMode){
		int width=rect.width();
		int height=rect.height();
		double pox,poy;
		int x0,y0,ra=12;
		pox=rect.left+0.5*width;
		poy=rect.top+0.5*height;
		
		y0=(int)(poy-(lightShip.x-centerx)*sY);
		x0=(int)(pox+(lightShip.y-centery)*sX);
		
		
		if(rect.contains(x0, y0)){
			canvas.drawColor(Color.TRANSPARENT);
			Paint paint=new Paint();
			paint.setColor(Color.rgb(255, 0, 0));
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(2);
			
			RectF rf=new RectF();
			rf.left=x0-ra;
			rf.top=y0-ra;
			rf.right=x0+ra;
			rf.bottom=y0+ra;
			
			//////这里计算不知道对不对
			float beginAngle=(float)(Math.atan2(-ra, -ra/2)*180/Math.PI);
			float sweepAngle=(float)(Math.atan2(-ra, ra/2)*180/Math.PI);
			canvas.drawArc(rf, beginAngle, sweepAngle, false, paint);
			
			paint.setColor(backMode^Color.rgb(255, 255, 255));
			paint.setStrokeWidth(1);
			canvas.drawLine(x0, y0, x0, y0-ra*4/5, paint);
			canvas.drawLine(x0-2, y0-ra*4/5-2, x0+2,y0-ra*4/5+2, paint);
			canvas.drawLine(x0-2, y0-ra*4/5+2, x0+2, y0-ra*4/5-2, paint);
			rf.left=x0-ra/5;
			rf.top=y0;
			rf.right=x0+ra/5+1;
			rf.bottom=y0+ra*2/5;
			canvas.drawArc(rf, 0, 360, false, paint);
			
			canvas.drawLine(x0, y0-ra/5, x0-ra/5, y0-ra/5, paint);
			canvas.drawLine(x0, y0-ra/5, x0+ra/5+1, y0-ra/5, paint);
			canvas.drawLine(x0-ra/5, y0+ra/5, x0-ra, y0+ra/5, paint);
			canvas.drawLine(x0+ra/5, y0+ra/5, x0+ra-1, y0+ra/5, paint);
			canvas.drawLine(x0-ra*3/5, y0+ra/5,x0-ra*3/5, y0-ra/10, paint);
			Path path=new Path();
			
			path.moveTo(x0-ra*3/5, y0-ra/10);
			path.lineTo(x0-ra/3, y0-ra/10);
			path.lineTo(x0-ra/5, y0-ra/10);
			path.lineTo(x0-ra*2/5, y0-ra*2/5);
			path.lineTo(x0-ra*4/5, y0-ra*2/5);
			path.close();
			canvas.drawPath(path, paint);
			canvas.drawLine(x0-ra/2,y0-ra*2/5, x0-ra/2,y0-ra*4/5, paint);
			
			canvas.drawLine(x0+ra*3/5,y0+ra/5, x0+ra*3/5,y0-ra/10, paint);
			path=new Path();
			path.moveTo(x0+ra*3/5,y0-ra/10);
			path.lineTo(x0+ra/3,y0-ra/10);
			path.lineTo(x0+ra/5,y0-ra/5);
			path.lineTo(x0+ra*2/5,y0-ra*2/5);
			path.lineTo(x0+ra*4/5,y0-ra*2/5);
			path.close();
			canvas.drawPath(path, paint);
			canvas.drawLine(x0+ra/2,y0-ra*2/5, x0+ra/2,y0-ra*4/5, paint);
			
			if(lightShip.Label!=null){
				paint.setColor(backMode^Color.rgb(255, 255, 255));
				paint.setTextSize(12*sY);
				canvas.drawText(lightShip.Label, x0-ra*5, y0+ra/2, paint);
				
			}
			
		}
		
	}
}
