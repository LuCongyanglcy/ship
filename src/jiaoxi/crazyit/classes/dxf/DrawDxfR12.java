package jiaoxi.crazyit.classes.dxf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.SystemClock;

public class DrawDxfR12 {
    //public List dxf_r12s;
    //////读取dxf文件
    public static double[] px = null;
    public static double[] py = null;
    public static Kryo kryo = new Kryo();
    public static Paint paint = new Paint();
    public static int[] colorTableR12 = {
            Color.rgb(255, 255, 255),
            Color.rgb(255, 0, 0),
            Color.rgb(255, 255, 0),
            Color.rgb(0, 255, 0),
            Color.rgb(0, 255, 255),
            Color.rgb(0, 0, 255),
            Color.rgb(255, 0, 255),
            Color.rgb(255, 255, 255),
            Color.rgb(127, 127, 127),
            Color.rgb(192, 192, 192),
            Color.rgb(255, 0, 0),
            Color.rgb(255, 128, 128),
            Color.rgb(192, 0, 0),
            Color.rgb(207, 103, 96),
            Color.rgb(144, 0, 0),
            Color.rgb(159, 72, 79),
            Color.rgb(127, 0, 0),
            Color.rgb(128, 64, 64),
            Color.rgb(64, 0, 0),
            Color.rgb(64, 32, 32),
            Color.rgb(255, 56, 0),
            Color.rgb(255, 160, 128),
            Color.rgb(192, 48, 0),
            Color.rgb(208, 128, 96),
            Color.rgb(144, 32, 0),
            Color.rgb(144, 96, 80),
            Color.rgb(128, 24, 0),
            Color.rgb(112, 72, 48),
            Color.rgb(64, 16, 0),
            Color.rgb(80, 48, 32),
            Color.rgb(255, 128, 0),        //30
            Color.rgb(255, 192, 128),
            Color.rgb(192, 96, 0),
            Color.rgb(192, 151, 96),
            Color.rgb(144, 72, 0),
            Color.rgb(144, 112, 64),
            Color.rgb(112, 56, 0),
            Color.rgb(128, 96, 64),
            Color.rgb(64, 32, 0),
            Color.rgb(80, 56, 32),        //39
            Color.rgb(255, 192, 0),        //40
            Color.rgb(255, 224, 128),
            Color.rgb(192, 152, 0),
            Color.rgb(192, 176, 96),
            Color.rgb(144, 112, 0),
            Color.rgb(144, 128, 64),
            Color.rgb(112, 95, 0),
            Color.rgb(112, 104, 48),
            Color.rgb(64, 55, 0),
            Color.rgb(80, 64, 32),        //49
            Color.rgb(255, 255, 0),        //50
            Color.rgb(255, 255, 128),
            Color.rgb(192, 200, 0),
            Color.rgb(192, 200, 96),
            Color.rgb(144, 151, 0),
            Color.rgb(144, 151, 78),
            Color.rgb(127, 127, 0),
            Color.rgb(127, 127, 63),
            Color.rgb(80, 72, 0),
            Color.rgb(80, 72, 32),        //59
            Color.rgb(176, 255, 0),        //60
            Color.rgb(223, 255, 128),
            Color.rgb(144, 200, 0),
            Color.rgb(176, 200, 96),
            Color.rgb(112, 151, 0),
            Color.rgb(127, 151, 64),
            Color.rgb(96, 127, 0),
            Color.rgb(112, 127, 63),
            Color.rgb(48, 72, 0),
            Color.rgb(63, 72, 32),        //69
            Color.rgb(127, 255, 0),        //70
            Color.rgb(191, 255, 128),
            Color.rgb(96, 200, 0),
            Color.rgb(144, 200, 96),
            Color.rgb(80, 151, 0),
            Color.rgb(111, 151, 79),
            Color.rgb(64, 127, 0),
            Color.rgb(96, 127, 63),
            Color.rgb(32, 72, 0),
            Color.rgb(48, 72, 32),        //79
            Color.rgb(64, 255, 0),        //80
            Color.rgb(160, 255, 128),
            Color.rgb(48, 200, 0),
            Color.rgb(128, 200, 96),
            Color.rgb(32, 151, 0),
            Color.rgb(95, 151, 79),
            Color.rgb(31, 127, 0),
            Color.rgb(80, 127, 63),
            Color.rgb(16, 72, 0),
            Color.rgb(47, 72, 32),        //89
            Color.rgb(0, 255, 0),        //90
            Color.rgb(128, 255, 128),
            Color.rgb(0, 200, 0),
            Color.rgb(96, 200, 96),
            Color.rgb(0, 151, 0),
            Color.rgb(79, 151, 79),
            Color.rgb(0, 127, 0),
            Color.rgb(63, 127, 63),
            Color.rgb(0, 72, 0),
            Color.rgb(32, 72, 32),        //99
            Color.rgb(0, 255, 48),        //100
            Color.rgb(128, 255, 160),
            Color.rgb(0, 200, 48),
            Color.rgb(96, 200, 112),
            Color.rgb(0, 151, 32),
            Color.rgb(79, 151, 95),
            Color.rgb(0, 127, 31),
            Color.rgb(63, 127, 79),
            Color.rgb(0, 72, 16),
            Color.rgb(32, 72, 48),        //109
            Color.rgb(0, 255, 128),        //110
            Color.rgb(128, 255, 191),
            Color.rgb(0, 200, 96),
            Color.rgb(96, 200, 159),
            Color.rgb(0, 151, 79),
            Color.rgb(79, 151, 111),
            Color.rgb(0, 127, 63),
            Color.rgb(63, 127, 95),
            Color.rgb(0, 72, 32),
            Color.rgb(32, 72, 63),        //119
            Color.rgb(0, 255, 191),        //120
            Color.rgb(128, 255, 223),
            Color.rgb(0, 200, 144),
            Color.rgb(96, 200, 176),
            Color.rgb(0, 151, 111),
            Color.rgb(79, 151, 128),
            Color.rgb(0, 127, 80),
            Color.rgb(63, 127, 111),
            Color.rgb(0, 72, 48),
            Color.rgb(32, 72, 63),        //129
            Color.rgb(0, 255, 255),        //130
            Color.rgb(128, 255, 255),
            Color.rgb(0, 200, 192),
            Color.rgb(96, 200, 192),
            Color.rgb(0, 151, 159),
            Color.rgb(79, 151, 159),
            Color.rgb(0, 127, 127),
            Color.rgb(48, 127, 112),
            Color.rgb(0, 72, 64),
            Color.rgb(32, 72, 80),        //139
            Color.rgb(0, 191, 255),        //140
            Color.rgb(128, 223, 255),
            Color.rgb(0, 151, 192),
            Color.rgb(96, 176, 192),
            Color.rgb(0, 112, 159),
            Color.rgb(79, 135, 144),
            Color.rgb(0, 88, 127),
            Color.rgb(48, 104, 112),
            Color.rgb(0, 55, 64),
            Color.rgb(32, 63, 64),        //149
            Color.rgb(0, 127, 255),        //150
            Color.rgb(128, 184, 255),
            Color.rgb(0, 96, 192),
            Color.rgb(96, 152, 192),
            Color.rgb(0, 72, 144),
            Color.rgb(79, 112, 144),
            Color.rgb(0, 56, 112),
            Color.rgb(63, 95, 127),
            Color.rgb(0, 39, 79),
            Color.rgb(32, 55, 64),        //159
            Color.rgb(0, 63, 255),        //160
            Color.rgb(128, 158, 255),
            Color.rgb(0, 48, 192),
            Color.rgb(96, 127, 192),
            Color.rgb(0, 39, 144),
            Color.rgb(79, 95, 144),
            Color.rgb(0, 31, 112),
            Color.rgb(63, 79, 127),
            Color.rgb(0, 16, 79),
            Color.rgb(32, 47, 79),        //169
            Color.rgb(0, 0, 255),        //170
            Color.rgb(128, 127, 255),
            Color.rgb(0, 0, 192),
            Color.rgb(96, 103, 192),
            Color.rgb(0, 0, 144),
            Color.rgb(79, 72, 144),
            Color.rgb(0, 0, 127),
            Color.rgb(63, 63, 127),
            Color.rgb(0, 0, 64),
            Color.rgb(32, 39, 79),        //179
            Color.rgb(64, 0, 255),        //180
            Color.rgb(159, 127, 255),
            Color.rgb(48, 0, 192),
            Color.rgb(127, 103, 192),
            Color.rgb(32, 0, 144),
            Color.rgb(95, 72, 144),
            Color.rgb(32, 0, 127),
            Color.rgb(79, 63, 127),
            Color.rgb(16, 0, 64),
            Color.rgb(48, 39, 79),        //189
            Color.rgb(128, 0, 255),        //190
            Color.rgb(192, 127, 255),
            Color.rgb(96, 0, 192),
            Color.rgb(144, 103, 192),
            Color.rgb(79, 0, 144),
            Color.rgb(111, 72, 144),
            Color.rgb(64, 0, 127),
            Color.rgb(95, 63, 127),
            Color.rgb(32, 0, 64),
            Color.rgb(48, 32, 64),        //199
            Color.rgb(192, 0, 255),        //200
            Color.rgb(223, 127, 255),
            Color.rgb(144, 0, 192),
            Color.rgb(175, 103, 192),
            Color.rgb(111, 0, 144),
            Color.rgb(127, 72, 144),
            Color.rgb(95, 0, 127),
            Color.rgb(111, 63, 127),
            Color.rgb(48, 0, 64),
            Color.rgb(63, 39, 79),        //209
            Color.rgb(255, 0, 255),        //210
            Color.rgb(255, 127, 255),
            Color.rgb(192, 0, 192),
            Color.rgb(207, 103, 192),
            Color.rgb(144, 0, 144),
            Color.rgb(144, 72, 144),
            Color.rgb(127, 0, 127),
            Color.rgb(127, 63, 127),
            Color.rgb(95, 0, 64),
            Color.rgb(64, 39, 79),        //219
            Color.rgb(255, 0, 191),        //220
            Color.rgb(255, 127, 223),
            Color.rgb(192, 0, 159),
            Color.rgb(192, 96, 175),
            Color.rgb(144, 0, 112),
            Color.rgb(144, 72, 128),
            Color.rgb(127, 0, 95),
            Color.rgb(127, 63, 111),
            Color.rgb(95, 0, 48),
            Color.rgb(64, 39, 63),        //229
            Color.rgb(255, 0, 127),        //230
            Color.rgb(255, 127, 191),
            Color.rgb(192, 0, 96),
            Color.rgb(192, 96, 144),
            Color.rgb(144, 0, 64),
            Color.rgb(144, 72, 112),
            Color.rgb(127, 0, 64),
            Color.rgb(127, 63, 96),
            Color.rgb(95, 0, 32),
            Color.rgb(64, 39, 48),        //239
            Color.rgb(255, 0, 64),        //240
            Color.rgb(255, 127, 158),
            Color.rgb(192, 0, 48),
            Color.rgb(192, 96, 128),
            Color.rgb(144, 0, 32),
            Color.rgb(144, 72, 96),
            Color.rgb(127, 0, 31),
            Color.rgb(127, 63, 80),
            Color.rgb(95, 0, 16),
            Color.rgb(64, 39, 47),        //249
            Color.rgb(47, 47, 47),        //250
            Color.rgb(96, 96, 96),        //251
            Color.rgb(128, 128, 128),        //252
            Color.rgb(176, 176, 176),        //253
            Color.rgb(208, 208, 208),        //254
            Color.rgb(255, 255, 255)        //255

    };

    //////读取序列化数据
    public List<Dxf_r12> readSerDxfr12(String fileName) {
        List<Dxf_r12> r12s = null;
        File f = new File(fileName);
        if (!f.exists()) {
            return r12s = new ArrayList<Dxf_r12>();
        }

        Input input = null;
        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            input = new Input(new FileInputStream(raf.getFD()), 65535);
            r12s = (List<Dxf_r12>) kryo.readObject(input, ArrayList.class);

            int dnum = r12s.size();
            int maxLen = 0;
            for (int i = 0; i < dnum; i++) {
                List<Dxfr12_polyline> tmpPoly = r12s.get(i).strPolyline;
                int pnum = tmpPoly.size();
                for (int ii = 0; ii < pnum; ii++) {
                    if (tmpPoly.get(ii).point_x.size() > maxLen) {
                        maxLen = tmpPoly.get(ii).point_x.size();
                    }
                }
            }
            if (maxLen < 4) {
                maxLen = 4;
            }

            px = new double[maxLen];
            py = new double[maxLen];
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (input != null) {
                input.close();
            }
        }
        return r12s;
		/*List<Dxf_r12> r12s=new ArrayList<Dxf_r12>();
		try {

			InputStream in=new FileInputStream(fileName);
			ObjectInputStream ois=new ObjectInputStream(in);
			r12s=(List<Dxf_r12>)ois.readObject();
			ois.close();
			in.close();

			int dnum=r12s.size();
			int maxLen=0;
			for(int i=0;i<dnum;i++){
				List<Dxfr12_polyline> tmpPoly=r12s.get(i).strPolyline;
				int pnum=tmpPoly.size();
				for(int ii=0;ii<pnum;ii++){
					if(tmpPoly.get(ii).point_x.size()>maxLen){
						maxLen=tmpPoly.get(ii).point_x.size();
					}
				}
			}
			if(maxLen<4){
				maxLen=4;
			}
			DrawDxfR12.px=new double[maxLen];
			DrawDxfR12.py=new double[maxLen];

		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return r12s;*/
    }

    public void writeSerDxfr12(String filename, List<Dxf_r12> r12s) {
        Output output = null;
        try {
            RandomAccessFile raf = new RandomAccessFile(filename, "rw");
            output = new Output(new FileOutputStream(raf.getFD()), 65535);
            kryo.writeObject(output, r12s);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (output != null) {
                output.close();
            }
        }

    }

    public void readDxfr12(String fileName, List<Dxf_r12> r12s) {
        Dxf_r12 r12 = new Dxf_r12();

        File file = new File(fileName);
        System.out.println(fileName);
        InputStream in = null;

        byte[] s0 = new byte[30];
        long seek = 0;
        try {
            //ByteArrayOutputStream stream=new ByteArrayOutputStream();
            in = new FileInputStream(file);
            long fileLen = file.length();
            byte[] ss = new byte[(int) fileLen];
            in.read(ss);
            long tick = SystemClock.elapsedRealtime();

            while (seek < fileLen) {
                if (SystemClock.elapsedRealtime() - tick >= 50000) {
                    return;
                }
                seek = readLine_r12(ss, s0, fileLen, seek, 30);
                if (s0[0] == '$' && s0[1] == 'E' && s0[2] == 'X' && s0[3] == 'T' && s0[4] == 'M' && s0[5] == 'I' && s0[6] == 'N') {
                    seek = getExtMin_r12(ss, seek, fileLen, r12);
                }
                if (s0[0] == '$' && s0[1] == 'E' && s0[2] == 'X' && s0[3] == 'T' && s0[4] == 'M' && s0[5] == 'A' && s0[6] == 'X') {
                    seek = getExtMax_r12(ss, seek, fileLen, r12);
                }
                if (s0[0] == '$' && s0[1] == 'L' && s0[2] == 'I' && s0[3] == 'M' && s0[4] == 'M' && s0[5] == 'I' && s0[6] == 'N') {
                    seek = getLimMin_r12(ss, seek, fileLen, r12);
                }
                if (s0[0] == '$' && s0[1] == 'L' && s0[2] == 'I' && s0[3] == 'M' && s0[4] == 'M' && s0[5] == 'A' && s0[6] == 'X') {
                    seek = getLimMax_r12(ss, seek, fileLen, r12);
                }

                if (s0[0] == 'P' && s0[1] == 'O' && s0[2] == 'I' && s0[3] == 'N' && s0[4] == 'T') {
                    Dxfr12_point dxfpoint = new Dxfr12_point();
                    seek = getPointR12(ss, seek, fileLen, dxfpoint);
                    if (dxfpoint.point_x <= r12.extMax_x && dxfpoint.point_x >= r12.extMin_x && dxfpoint.point_y <= r12.extMax_y && dxfpoint.point_y >= r12.extMin_y) {
                        r12.strPoint.add(dxfpoint);
                    }
                }

                if (s0[0] == 'L' && s0[1] == 'I' && s0[2] == 'N' && s0[3] == 'E') {

                    Dxfr12_line dxfLine = new Dxfr12_line();
                    seek = getLineR12(ss, seek, fileLen, dxfLine);
                    if (dxfLine.beginPoint_x <= r12.extMax_x && dxfLine.beginPoint_x >= r12.extMin_x && dxfLine.beginPoint_y <= r12.extMax_y && dxfLine.beginPoint_y >= r12.extMin_y
                            && dxfLine.endPoint_x <= r12.extMax_x && dxfLine.endPoint_x >= r12.extMin_x && dxfLine.endPoint_y <= r12.extMax_y && dxfLine.endPoint_y >= r12.extMin_y) {
                        r12.strLine.add(dxfLine);
                    }

                }
                if (s0[0] == 'C' && s0[1] == 'I' && s0[2] == 'R' && s0[3] == 'C' && s0[4] == 'L' && s0[5] == 'E') {
                    Dxfr12_circle dxfCircle = new Dxfr12_circle();
                    seek = getCircleR12(ss, seek, fileLen, dxfCircle);
                    if (dxfCircle.point_x <= r12.extMax_x && dxfCircle.point_x >= r12.extMin_x && dxfCircle.point_y <= r12.extMax_y && dxfCircle.point_y >= r12.extMin_y) {
                        r12.strCircle.add(dxfCircle);
                    }
                }

                if (s0[0] == 'A' && s0[1] == 'R' && s0[2] == 'C') {
                    Dxfr12_arc dxfArc = new Dxfr12_arc();
                    seek = getArcR12(ss, seek, fileLen, dxfArc);
                    if (dxfArc.point_x <= r12.extMax_x && dxfArc.point_x >= r12.extMin_x && dxfArc.point_y <= r12.extMax_y && dxfArc.point_y >= r12.extMin_y) {
                        r12.strArc.add(dxfArc);
                    }
                }

                if (s0[0] == 'S' && s0[1] == 'O' && s0[2] == 'L' && s0[3] == 'I' && s0[4] == 'D') {
                    Dxfr12_solid dxfSolid = new Dxfr12_solid();
                    seek = getSolidR12(ss, seek, fileLen, dxfSolid);
                    if (dxfSolid.point1_x <= r12.extMax_x && dxfSolid.point1_x >= r12.extMin_x        ////必须判断
                            && dxfSolid.point1_y <= r12.extMax_y && dxfSolid.point1_y >= r12.extMin_y
                            && dxfSolid.point2_x <= r12.extMax_x && dxfSolid.point2_x >= r12.extMin_x        ////必须判断
                            && dxfSolid.point2_y <= r12.extMax_y && dxfSolid.point2_y >= r12.extMin_y
                            && dxfSolid.point3_x <= r12.extMax_x && dxfSolid.point3_x >= r12.extMin_x        ////必须判断
                            && dxfSolid.point3_y <= r12.extMax_y && dxfSolid.point3_y >= r12.extMin_y
                            && dxfSolid.point4_x <= r12.extMax_x && dxfSolid.point4_x >= r12.extMin_x        ////必须判断
                            && dxfSolid.point4_y <= r12.extMax_y && dxfSolid.point4_y >= r12.extMin_y) {
                        r12.strSolid.add(dxfSolid);
                    }
                }
                if (s0[0] == 'P' && s0[1] == 'O' && s0[2] == 'L' && s0[3] == 'Y' && s0[4] == 'L' && s0[5] == 'I' && s0[6] == 'N' && s0[7] == 'E') {
                    Dxfr12_polyline dxfpoly = new Dxfr12_polyline();
                    seek = getPolyLineR12(ss, seek, fileLen, dxfpoly);
                    boolean inRect = true;

                    for (int kt = 1; kt < dxfpoly.point_x.size(); kt++) {
                        if (dxfpoly.point_x.get(kt) > r12.extMax_x || dxfpoly.point_x.get(kt) < r12.extMin_x        ////必须判断
                                || dxfpoly.point_y.get(kt) > r12.extMax_y || dxfpoly.point_y.get(kt) < r12.extMin_y) {
                            inRect = false;
                            break;
                        }
                    }
                    if (inRect) {
                        r12.strPolyline.add(dxfpoly);
                    }
                }
                if (s0[0] == 'T' && s0[1] == 'E' && s0[2] == 'X' && s0[3] == 'T') {
                    Dxfr12_text dxfText = new Dxfr12_text();
                    seek = getTextR12(ss, seek, fileLen, dxfText);
                    if (dxfText.point_x <= r12.extMax_x && dxfText.point_x >= r12.extMin_x && dxfText.point_y <= r12.extMax_y && dxfText.point_y >= r12.extMin_y) {
                        r12.strText.add(dxfText);
                    }
                }
            }
            r12s.add(r12);

        } catch (Exception e) {
            // TODO: handle exception
            try {
                in.close();

            } catch (Exception e2) {
                // TODO: handle exception
            }


        } finally {
            try {
                in.close();

            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
    }

    private long getPolyLineR12(byte[] s, long seek, long fileLen, Dxfr12_polyline poly) {
        byte[] s0 = new byte[100];
        int code;
        poly.penStyle = 0;
        long tick = SystemClock.elapsedRealtime();
        while (true) {
            if (SystemClock.elapsedRealtime() - tick > 1000) {
                return seek;
            }
            seek = readLine_r12(s, s0, fileLen, seek, 20);
            code = Integer.parseInt((new String(s0)).trim());
            switch (code) {
                case 70:
                    seek = readLine_r12(s, s0, fileLen, seek, 20);
                    poly.lx = Integer.parseInt((new String(s0)).trim());
                    break;
                case 10:
                    seek = readLine_r12(s, s0, fileLen, seek, 20);
                    poly.point_y.add(Double.parseDouble((new String(s0)).trim()));
                    break;
                case 20:
                    seek = readLine_r12(s, s0, fileLen, seek, 20);
                    poly.point_x.add(Double.parseDouble((new String(s0)).trim()));
                    break;
                case 30:
                    seek = readLine_r12(s, s0, fileLen, seek, 20);
                    break;
                case 6:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    poly.penStyle = 0;
                    if (s0[0] == 'C' && s0[1] == 'O' && s0[2] == 'N' && s0[3] == 'T' && s0[4] == 'I' && s0[5] == 'U') {
                        poly.penStyle = 0;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '0' && s0[9] == '2' && s0[10] == 'W') {
                        poly.penStyle = 1;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '0' && s0[9] == '7' && s0[10] == 'W') {
                        poly.penStyle = 2;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '1' && s0[9] == '0' && s0[10] == 'W') {
                        poly.penStyle = 3;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '1' && s0[9] == '2' && s0[10] == 'W') {
                        poly.penStyle = 4;
                    }
                    break;
                case 39:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    poly.width = Integer.parseInt((new String(s0)).trim());
                    break;
                case 62:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    poly.color = Integer.parseInt((new String(s0)).trim());

                    break;
                case 0:
                    seek = readLine_r12(s, s0, fileLen, seek, 20);
                    if (s0[0] == 'S' && s0[1] == 'E' && s0[2] == 'Q' && s0[3] == 'E')
                        return seek;
                    else {
                        seek = readLine_r12(s, s0, fileLen, seek, 100);
                    }
                default:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    break;
            }
        }
    }

    private long getTextR12(byte[] s, long seek, long fileLen, Dxfr12_text text) {
        byte[] s0 = new byte[100];
        int code;
        text.penStyle = 0;
        long tick = SystemClock.elapsedRealtime();
        while (true) {
            if (SystemClock.elapsedRealtime() - tick > 1000) {
                return seek;
            }
            seek = readLine_r12(s, s0, fileLen, seek, 100);
            code = Integer.parseInt((new String(s0)).trim());
            switch (code) {
                case 70:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    text.lx = Integer.parseInt((new String(s0)).trim());
                    break;
                case 10:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    text.point_y = Double.parseDouble((new String(s0)).trim());
                    break;
                case 20:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    text.point_x = Double.parseDouble((new String(s0)).trim());
                    break;

                case 6:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    text.penStyle = 0;
                    if (s0[0] == 'C' && s0[1] == 'O' && s0[2] == 'N' && s0[3] == 'T' && s0[4] == 'I' && s0[5] == 'U') {
                        text.penStyle = 0;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '0' && s0[9] == '2' && s0[10] == 'W') {
                        text.penStyle = 1;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '0' && s0[9] == '7' && s0[10] == 'W') {
                        text.penStyle = 2;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '1' && s0[9] == '0' && s0[10] == 'W') {
                        text.penStyle = 3;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '1' && s0[9] == '2' && s0[10] == 'W') {
                        text.penStyle = 4;
                    }
                    break;
                case 39:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    text.width = Integer.parseInt((new String(s0)).trim());
                    break;
                case 62:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    text.color = Integer.parseInt((new String(s0)).trim());

                    break;
                case 0:
                    return seek;
                case 1:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    try {
                        text.text = (new String(s0, "GB2312")).trim();
                    } catch (UnsupportedEncodingException e) {
                        // TODO 自动生成的 catch 块
                        e.printStackTrace();
                        text.text = "字符串转换错误";
                    }
                    break;
                case 40:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    text.fontSize = Double.parseDouble((new String(s0)).trim());
                    break;
                default:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    break;
            }
        }
    }

    private long getSolidR12(byte[] s, long seek, long fileLen, Dxfr12_solid solid) {
        byte[] s0 = new byte[100];
        int code;
        long tick = SystemClock.elapsedRealtime();
        while (true) {
            if (SystemClock.elapsedRealtime() - tick > 1000) {
                return seek;
            }
            seek = readLine_r12(s, s0, fileLen, seek, 100);
            code = Integer.parseInt((new String(s0)).trim());
            switch (code) {
                case 10:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    solid.point1_y = Double.parseDouble((new String(s0)).trim());
                    break;
                case 20:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    solid.point1_x = Double.parseDouble((new String(s0)).trim());
                    break;
                case 11:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    solid.point2_y = Double.parseDouble((new String(s0)).trim());
                    break;
                case 21:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    solid.point2_x = Double.parseDouble((new String(s0)).trim());
                    break;
                case 12:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    solid.point3_y = Double.parseDouble((new String(s0)).trim());
                    break;
                case 22:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    solid.point3_x = Double.parseDouble((new String(s0)).trim());
                    break;
                case 13:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    solid.point4_y = Double.parseDouble((new String(s0)).trim());
                    break;
                case 23:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    solid.point4_x = Double.parseDouble((new String(s0)).trim());
                    break;

                case 6:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    solid.penStyle = 0;
                    if (s0[0] == 'C' && s0[1] == 'O' && s0[2] == 'N' && s0[3] == 'T' && s0[4] == 'I' && s0[5] == 'U') {
                        solid.penStyle = 0;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '0' && s0[9] == '2' && s0[10] == 'W') {
                        solid.penStyle = 1;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '0' && s0[9] == '7' && s0[10] == 'W') {
                        solid.penStyle = 2;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '1' && s0[9] == '0' && s0[10] == 'W') {
                        solid.penStyle = 3;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '1' && s0[9] == '2' && s0[10] == 'W') {
                        solid.penStyle = 4;
                    }
                    break;
                case 39:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    solid.width = Integer.parseInt((new String(s0)).trim());
                    break;
                case 62:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    solid.color = Integer.parseInt((new String(s0)).trim());

                    break;
                case 0:
                    return seek;
                default:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    break;
            }
        }
    }

    private long getArcR12(byte[] s, long seek, long fileLen, Dxfr12_arc arc) {
        byte[] s0 = new byte[100];
        int code;
        arc.penStyle = 0;
        long tick = SystemClock.elapsedRealtime();
        while (true) {
            if (SystemClock.elapsedRealtime() - tick > 1000) {
                return seek;
            }
            seek = readLine_r12(s, s0, fileLen, seek, 100);
            code = Integer.parseInt((new String(s0)).trim());
            switch (code) {
                case 10:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    arc.point_y = Double.parseDouble((new String(s0)).trim());
                    break;
                case 20:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    arc.point_x = Double.parseDouble((new String(s0)).trim());
                    break;
                case 40:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    arc.radum = Double.parseDouble((new String(s0)).trim());
                    break;
                case 50:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    arc.beginAngle = Double.parseDouble((new String(s0)).trim());
                    break;
                case 51:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    arc.endAngle = Double.parseDouble((new String(s0)).trim());
                    break;
                case 6:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    arc.penStyle = 0;
                    if (s0[0] == 'C' && s0[1] == 'O' && s0[2] == 'N' && s0[3] == 'T' && s0[4] == 'I' && s0[5] == 'U') {
                        arc.penStyle = 0;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '0' && s0[9] == '2' && s0[10] == 'W') {
                        arc.penStyle = 1;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '0' && s0[9] == '7' && s0[10] == 'W') {
                        arc.penStyle = 2;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '1' && s0[9] == '0' && s0[10] == 'W') {
                        arc.penStyle = 3;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '1' && s0[9] == '2' && s0[10] == 'W') {
                        arc.penStyle = 4;
                    }
                    break;
                case 39:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    arc.width = Integer.parseInt((new String(s0)).trim());
                    break;
                case 62:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    arc.color = Integer.parseInt((new String(s0)).trim());

                    break;
                case 0:
                    return seek;
                default:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    break;
            }
        }
    }

    private long getCircleR12(byte[] s, long seek, long fileLen, Dxfr12_circle circle) {
        byte[] s0 = new byte[100];
        int code;
        circle.penStyle = 0;
        long tick = SystemClock.elapsedRealtime();
        while (true) {
            if (SystemClock.elapsedRealtime() - tick > 1000) {
                return seek;
            }
            seek = readLine_r12(s, s0, fileLen, seek, 100);
            code = Integer.parseInt((new String(s0)).trim());
            switch (code) {
                case 10:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    circle.point_y = Double.parseDouble((new String(s0)).trim());
                    break;
                case 20:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    circle.point_x = Double.parseDouble((new String(s0)).trim());
                    break;
                case 40:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    circle.radum = Double.parseDouble((new String(s0)).trim());
                    break;
                case 6:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    circle.penStyle = 0;
                    if (s0[0] == 'C' && s0[1] == 'O' && s0[2] == 'N' && s0[3] == 'T' && s0[4] == 'I' && s0[5] == 'U') {
                        circle.penStyle = 0;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '0' && s0[9] == '2' && s0[10] == 'W') {
                        circle.penStyle = 1;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '0' && s0[9] == '7' && s0[10] == 'W') {
                        circle.penStyle = 2;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '1' && s0[9] == '0' && s0[10] == 'W') {
                        circle.penStyle = 3;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '1' && s0[9] == '2' && s0[10] == 'W') {
                        circle.penStyle = 4;
                    }
                    break;
                case 39:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    circle.width = Integer.parseInt((new String(s0)).trim());
                    break;
                case 62:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    circle.color = Integer.parseInt((new String(s0)).trim());

                    break;
                case 0:
                    return seek;
                default:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    break;
            }
        }
    }

    private long getLineR12(byte[] s, long seek, long fileLen, Dxfr12_line line) {
        byte[] s0 = new byte[100];
        int code;
        long tick = SystemClock.elapsedRealtime();
        while (true) {
            if (SystemClock.elapsedRealtime() - tick > 1000) {
                return seek;
            }
            seek = readLine_r12(s, s0, fileLen, seek, 100);

            code = Integer.parseInt((new String(s0)).trim());
            switch (code) {
                case 10:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    line.beginPoint_y = Double.parseDouble((new String(s0)).trim());

                    break;
                case 20:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    line.beginPoint_x = Double.parseDouble((new String(s0)).trim());

                    break;

                case 11:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    line.endPoint_y = Double.parseDouble((new String(s0)).trim());

                    break;
                case 21:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    line.endPoint_x = Double.parseDouble((new String(s0)).trim());

                    break;
                case 6:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    line.penStyle = 0;
                    if (s0[0] == 'C' && s0[1] == 'O' && s0[2] == 'N' && s0[3] == 'T' && s0[4] == 'I' && s0[5] == 'U') {
                        line.penStyle = 0;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '0' && s0[9] == '2' && s0[10] == 'W') {
                        line.penStyle = 1;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '0' && s0[9] == '7' && s0[10] == 'W') {
                        line.penStyle = 2;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '1' && s0[9] == '0' && s0[10] == 'W') {
                        line.penStyle = 3;
                    }
                    if (s0[5] == 'I' && s0[6] == 'S' && s0[7] == 'O' && s0[8] == '1' && s0[9] == '2' && s0[10] == 'W') {
                        line.penStyle = 4;
                    }
                    break;
                case 39:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    line.width = Integer.parseInt((new String(s0)).trim());
                    break;
                case 62:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    line.color = Integer.parseInt((new String(s0)).trim());
                    break;
                case 0:
                    return seek;
                default:
                    seek = readLine_r12(s, s0, fileLen, seek, 100);
                    break;
            }
        }
    }

    private long getPointR12(byte[] s, long seek, long fileLen, Dxfr12_point point) {
        byte[] s0 = new byte[100];
        int code;
        long tick = SystemClock.elapsedRealtime();
        while (true) {
            if (SystemClock.elapsedRealtime() - tick > 1000) {
                return seek;
            }
            seek = readLine_r12(s, s0, fileLen, seek, 30);
            code = Integer.parseInt((new String(s0)).trim());
            switch (code) {
                case 10:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    point.point_y = Double.parseDouble((new String(s0)).trim());
                    break;
                case 20:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    point.point_x = Double.parseDouble((new String(s0)).trim());
                    break;
                case 62:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    point.color = Integer.parseInt((new String(s0)).trim());
                    break;
                case 0:
                    return seek;
                default:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    break;
            }
        }
    }

    private long getExtMin_r12(byte[] s, long seek, long fileLen, Dxf_r12 r12) {
        byte[] s0 = new byte[100];
        int code;
        long tick = SystemClock.elapsedRealtime();
        while (true) {
            if (SystemClock.elapsedRealtime() - tick > 1000) {
                return seek;
            }
            seek = readLine_r12(s, s0, fileLen, seek, 30);

            code = Integer.parseInt((new String(s0)).trim());
            switch (code) {
                case 10:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    r12.extMin_y = Double.parseDouble((new String(s0)).trim());
                    break;
                case 20:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    r12.extMin_x = Double.parseDouble((new String(s0)).trim());
                    break;
                case 9:
                    return seek;
                case 30:
                    return seek;

            }
        }

    }

    private long getExtMax_r12(byte[] s, long seek, long fileLen, Dxf_r12 r12) {
        byte[] s0 = new byte[100];

        int code;
        long tick = SystemClock.elapsedRealtime();
        while (true) {
            if (SystemClock.elapsedRealtime() - tick > 1000) {
                return seek;
            }
            seek = readLine_r12(s, s0, fileLen, seek, 30);
            code = Integer.parseInt((new String(s0)).trim());
            switch (code) {
                case 10:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    r12.extMax_y = Double.parseDouble((new String(s0)).trim());
                    break;
                case 20:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    r12.extMax_x = Double.parseDouble((new String(s0)).trim());
                    break;
                case 9:
                    return seek;
                case 30:
                    return seek;

            }
        }

    }

    private long getLimMin_r12(byte[] s, long seek, long fileLen, Dxf_r12 r12) {
        byte[] s0 = new byte[100];
        int code;
        long tick = SystemClock.elapsedRealtime();
        while (true) {
            if (SystemClock.elapsedRealtime() - tick > 1000) {
                return seek;
            }
            seek = readLine_r12(s, s0, fileLen, seek, 30);
            code = Integer.parseInt((new String(s0)).trim());
            switch (code) {
                case 10:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    r12.limMin_y = Double.parseDouble((new String(s0)).trim());
                    break;
                case 20:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    r12.limMin_x = Double.parseDouble((new String(s0)).trim());
                    break;
                case 9:
                    return seek;
                case 30:
                    return seek;

            }
        }

    }

    private long getLimMax_r12(byte[] s, long seek, long fileLen, Dxf_r12 r12) {
        byte[] s0 = new byte[100];

        int code;
        long tick = SystemClock.elapsedRealtime();
        while (true) {
            if (SystemClock.elapsedRealtime() - tick > 1000) {
                return seek;
            }
            seek = readLine_r12(s, s0, fileLen, seek, 30);
            code = Integer.parseInt((new String(s0)).trim());
            switch (code) {
                case 10:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    r12.limMax_y = Double.parseDouble((new String(s0)).trim());
                    break;
                case 20:
                    seek = readLine_r12(s, s0, fileLen, seek, 30);
                    r12.limMax_x = Double.parseDouble((new String(s0)).trim());
                    break;
                case 9:
                    return seek;
                case 30:
                    return seek;

            }
        }

    }

    private long readLine_r12(byte[] s, byte[] s0, long fileLen, long seek, long maxlen) {
        for (int i = 0; i < maxlen; i++) {
            s0[i] = 0;
        }
        long i, k;
        for (i = seek; i < fileLen; i++) {
            if (s[(int) i] == 0x0d) {
                break;
            }
        }
        if (i - seek < maxlen) {
            for (k = 0; k < i - seek; k++) {
                s0[(int) k] = s[(int) (seek + k)];
            }
        }
        return i + 2;
    }

    //public void drawPointR12(Canvas canvas,Rect rect,double x_eve,double y_eve,double centerx,double centery,Dxfr12_point dxfPoint,int backMode){
    public static void drawPointR12(Canvas canvas, Rect rect, double pox, double poy, double scaleX, double scaleY, double centerx, double centery, Dxfr12_point dxfPoint, int backMode, float angle) {
        //double x0,y0;
        int pointColor;

        //Paint paint=new Paint();
        //paint.setAntiAlias(true);
        if (dxfPoint.color >= 256 || dxfPoint.color <= 0) {
            pointColor = backMode ^ Color.rgb(255, 255, 255);////////////这里要与背景异或运算,java里不知道对不对

        } else {
            pointColor = colorTableR12[dxfPoint.color];
        }
        paint.setColor(pointColor);
        py[0] = poy - (dxfPoint.point_x - centerx) * scaleY;
        px[0] = pox + (dxfPoint.point_y - centery) * scaleX;
        double x, y;
        x = px[0];
        y = py[0];
        px[0] = (x - pox) * Math.cos(angle) - (y - poy) * Math.sin(angle) + pox;
        py[0] = (x - pox) * Math.sin(angle) + (y - poy) * Math.cos(angle) + poy;
        if (rect.contains((int) px[0], (int) py[0])) {
            canvas.drawPoint((int) px[0], (int) py[0], paint);
        }

        //paint=null;
    }

    //public void drawLineR12(Canvas canvas,Rect rect,double x_eve,double y_eve,double centerx,double centery,Dxfr12_line dxfLine,int backMode){
    public static void drawLineR12(Canvas canvas, Rect rect, float pox, float poy, float scaleX, float scaleY, float centerx, float centery, Dxfr12_line dxfLine, int backMode, float angle) {
        int lineColor;
        //float x0,y0,x1,y1;

        if (dxfLine.color >= 256 || dxfLine.color <= 0) {
            lineColor = backMode ^ Color.rgb(255, 255, 255);
        } else {
            lineColor = colorTableR12[dxfLine.color];
        }
        //Paint paint=new Paint();
        //paint.setAntiAlias(true);
        paint.setColor(lineColor);
        paint.setStrokeWidth(dxfLine.width);

        py[0] = poy - (dxfLine.beginPoint_x - centerx) * scaleY;
        px[0] = pox + (dxfLine.beginPoint_y - centery) * scaleX;
        double x, y;
        x = px[0];
        y = py[0];
        px[0] = (x - pox) * Math.cos(angle) - (y - poy) * Math.sin(angle) + pox;
        py[0] = (x - pox) * Math.sin(angle) + (y - poy) * Math.cos(angle) + poy;
        py[1] = poy - (dxfLine.endPoint_x - centerx) * scaleY;
        px[1] = pox + (dxfLine.endPoint_y - centery) * scaleX;
        x = px[1];
        y = py[1];
        px[1] = (x - pox) * Math.cos(angle) - (y - poy) * Math.sin(angle) + pox;
        py[1] = (x - pox) * Math.sin(angle) + (y - poy) * Math.cos(angle) + poy;
        //if(rect.contains((int)px[0],(int)py[0]) || rect.contains((int)px[1],(int)py[1])){
        PathEffect effect;
        switch (dxfLine.penStyle) {
            case 0:
                canvas.drawLine((int) px[0], (int) py[0], (int) px[1], (int) py[1], paint);
                break;
            case 1:
                effect = new DashPathEffect(new float[]{4, 2}, 1);
                paint.setPathEffect(effect);
                canvas.drawLine((int) px[0], (int) py[0], (int) px[1], (int) py[1], paint);
                break;
            case 2:
                effect = new DashPathEffect(new float[]{1, 2}, 1);
                paint.setPathEffect(effect);
                canvas.drawLine((int) px[0], (int) py[0], (int) px[1], (int) py[1], paint);
                break;
            case 3:
                effect = new DashPathEffect(new float[]{1, 2, 4, 3}, 1);
                paint.setPathEffect(effect);
                canvas.drawLine((int) px[0], (int) py[0], (int) px[1], (int) py[1], paint);
                break;
            case 4:
                effect = new DashPathEffect(new float[]{1, 2, 1, 2, 4, 3}, 1);
                paint.setPathEffect(effect);
                canvas.drawLine((int) px[0], (int) py[0], (int) px[1], (int) py[1], paint);
                break;
            default:
                canvas.drawLine((int) px[0], (int) py[0], (int) px[1], (int) py[1], paint);
                break;
        }
        effect = null;
        //}
        //paint=null;

    }

    public static void drawCircleR12(Canvas canvas, Rect rect, float pox, float poy, float scaleX, float scaleY, float centerx, float centery, Dxfr12_circle dxfCircle, int backMode, float angle) {
        int circleColor;
        //float x0,y0;

        if (dxfCircle.color >= 256 || dxfCircle.color <= 0) {
            circleColor = backMode ^ Color.rgb(255, 255, 255);
        } else {
            circleColor = colorTableR12[dxfCircle.color];
        }
        //Paint paint=new Paint();
        //paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(circleColor);
        py[0] = poy - (dxfCircle.point_x - centerx) * scaleY;
        px[0] = pox + (dxfCircle.point_y - centery) * scaleX;
        double x, y;
        x = px[0];
        y = py[0];
        px[0] = (x - pox) * Math.cos(angle) - (y - poy) * Math.sin(angle) + pox;
        py[0] = (x - pox) * Math.sin(angle) + (y - poy) * Math.cos(angle) + poy;

        RectF rect1 = new RectF();
        rect1.left = (float) (px[0] - dxfCircle.radum * scaleY);
        rect1.right = (float) (px[0] + dxfCircle.radum * scaleY);
        rect1.top = (float) (py[0] - dxfCircle.radum * scaleY);
        rect1.bottom = (float) (py[0] + dxfCircle.radum * scaleY);
        //Rect r=new Rect();
//		r.left=(int)rect1.left;
//		r.right=(int)rect1.right;
//		r.top=(int)rect1.top;
//		r.bottom=(int)rect1.bottom;
//		if(rect.contains(r)){
        //if(rect.contains((int)rect1.left,(int)rect1.top) || rect.contains((int)rect1.left,(int)rect1.bottom) || rect.contains((int)rect1.right,(int)rect1.top) || rect.contains((int)rect1.right,(int)rect1.bottom)){
        canvas.drawArc(rect1, 0, 360, false, paint); ///////这里是画的圆弧
        //}
        rect1 = null;
        //paint=null;
    }

    //////画圆弧
    public static void drawArcR12(Canvas canvas, Rect rect, float pox, float poy, float scaleX, float scaleY, float centerx, float centery, Dxfr12_arc dxfArc, int backMode, float angle) {
        int arcColor;
        //float x0,y0;

        if (dxfArc.color >= 256 || dxfArc.color <= 0) {
            arcColor = backMode ^ Color.rgb(255, 255, 255);
        } else {
            arcColor = colorTableR12[dxfArc.color];
        }
        //Paint paint=new Paint();
        //paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(arcColor);
        float ra = (float) dxfArc.radum * scaleY;

        py[0] = poy - (dxfArc.point_x - centerx) * scaleY;
        px[0] = pox + (dxfArc.point_y - centery) * scaleX;
        double x, y;
        x = px[0];
        y = py[0];
        px[0] = (x - pox) * Math.cos(angle) - (y - poy) * Math.sin(angle) + pox;
        py[0] = (x - pox) * Math.sin(angle) + (y - poy) * Math.cos(angle) + poy;

        RectF rect1 = new RectF();
        rect1.left = (float) (px[0] - ra);
        rect1.right = (float) (px[0] + ra);
        rect1.top = (float) (py[0] - ra);
        rect1.bottom = (float) (py[0] + ra);
        //Rect r=new Rect();
//		r.left=(int)rect1.left;
//		r.right=(int)rect1.right;
//		r.top=(int)rect1.top;
//		r.bottom=(int)rect1.bottom;
//		if(rect.contains(r)){
        float tmpAngle = angle * 180 / (float) Math.PI;
        //if(rect.contains((int)rect1.left,(int)rect1.top) || rect.contains((int)rect1.left,(int)rect1.bottom) || rect.contains((int)rect1.right,(int)rect1.top) || rect.contains((int)rect1.right,(int)rect1.bottom)){
        canvas.drawArc(rect1, (float) dxfArc.beginAngle + tmpAngle, (float) dxfArc.endAngle + tmpAngle, false, paint); ///////这里是画的圆弧
        //}

        rect1 = null;
        //paint=null;
    }

    //////填充
    public static void drawSolidR12(Canvas canvas, Rect rect, float pox, float poy, float scaleX, float scaleY, float centerx, float centery, Dxfr12_solid dxfSolid, int backMode, float angle) {
        int solidColor;
        //double pox,poy;
        //PointF[] po=new PointF[4];


        if (dxfSolid.color >= 256 || dxfSolid.color <= 0) {
            solidColor = backMode ^ Color.rgb(255, 255, 255);
        } else {
            solidColor = colorTableR12[dxfSolid.color];
        }
        //Paint paint=new Paint();
        //paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(solidColor);

        py[0] = poy - (dxfSolid.point1_x - centerx) * scaleY;
        px[0] = pox + (dxfSolid.point1_y - centery) * scaleX;
        double x, y;
        x = px[0];
        y = py[0];
        px[0] = (x - pox) * Math.cos(angle) - (y - poy) * Math.sin(angle) + pox;
        py[0] = (x - pox) * Math.sin(angle) + (y - poy) * Math.cos(angle) + poy;

        py[1] = poy - (dxfSolid.point2_x - centerx) * scaleY;
        px[1] = pox + (dxfSolid.point2_y - centery) * scaleX;
        x = px[1];
        y = py[1];
        px[1] = (x - pox) * Math.cos(angle) - (y - poy) * Math.sin(angle) + pox;
        py[1] = (x - pox) * Math.sin(angle) + (y - poy) * Math.cos(angle) + poy;
        py[2] = poy - (dxfSolid.point3_x - centerx) * scaleY;
        px[2] = pox + (dxfSolid.point3_y - centery) * scaleX;
        x = px[2];
        y = py[2];
        px[2] = (x - pox) * Math.cos(angle) - (y - poy) * Math.sin(angle) + pox;
        py[2] = (x - pox) * Math.sin(angle) + (y - poy) * Math.cos(angle) + poy;
        py[3] = poy - (dxfSolid.point4_x - centerx) * scaleY;
        px[3] = pox + (dxfSolid.point4_y - centery) * scaleX;
        x = px[3];
        y = py[3];
        px[3] = (x - pox) * Math.cos(angle) - (y - poy) * Math.sin(angle) + pox;
        py[3] = (x - pox) * Math.sin(angle) + (y - poy) * Math.cos(angle) + poy;

        if (rect.contains((int) px[0], (int) py[0]) || rect.contains((int) px[1], (int) py[1]) || rect.contains((int) px[2], (int) py[2]) || rect.contains((int) px[3], (int) py[3])) {
            Path path = new Path();
            path.moveTo((float) px[0], (float) py[0]);
            path.lineTo((float) px[1], (float) py[1]);
            path.lineTo((float) px[2], (float) py[2]);
            path.lineTo((float) px[3], (float) py[3]);
            path.close();

            canvas.drawPath(path, paint);
            path = null;
        }

        //paint=null;

    }

    //////画多边形
    public static void drawPolyR12(Canvas canvas, Rect rect, float pox, float poy, float scaleX, float scaleY, float centerx, float centery, Dxfr12_polyline dxfPolyline, int backMode, float angle) {
        int polyColor;
        //double pox,poy;


//		int width=rect.width();
//		int height=rect.height();
//		pox=rect.left+0.5*width;
//		poy=rect.top+0.5*height;
        if (dxfPolyline.color >= 256 || dxfPolyline.color <= 0) {
            polyColor = backMode ^ Color.rgb(255, 255, 255);
        } else {
            polyColor = colorTableR12[dxfPolyline.color];
        }
        int len = dxfPolyline.point_x.size();
		/*float [] px=new float[len];
		float[] py=new float[len];*/
        double x, y;
        for (int i = 0; i < len; i++) {
            px[i] = pox + (dxfPolyline.point_y.get(i) - centery) * scaleX;
            py[i] = poy - (dxfPolyline.point_x.get(i) - centerx) * scaleY;
            x = px[i];
            y = py[i];
            px[i] = (x - pox) * Math.cos(angle) - (y - poy) * Math.sin(angle) + pox;
            py[i] = (x - pox) * Math.sin(angle) + (y - poy) * Math.cos(angle) + poy;
        }
        boolean isdraw = false;
        for (int i = 0; i < len; i++) {
            if (rect.contains((int) px[i],(int) py[i])) {
                isdraw = true;
                break;
            }
        }
        if (isdraw) {
            Path path = new Path();
            path.moveTo((float) px[1], (float) py[1]);

            for (int i = 1; i < len; i++) {
                path.lineTo((float) px[i], (float) py[i]);
            }

            //Paint paint=new Paint();
            //paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(polyColor);
            PathEffect effect;
            switch (dxfPolyline.penStyle) {
                case 0:

                    canvas.drawPath(path, paint);
                    break;
                case 1:
                    effect = new DashPathEffect(new float[]{4, 2}, 1);
                    paint.setPathEffect(effect);
                    canvas.drawPath(path, paint);
                    break;
                case 2:
                    effect = new DashPathEffect(new float[]{1, 2}, 1);
                    paint.setPathEffect(effect);
                    canvas.drawPath(path, paint);
                    break;
                case 3:
                    effect = new DashPathEffect(new float[]{1, 2, 4, 3}, 1);
                    paint.setPathEffect(effect);
                    canvas.drawPath(path, paint);
                    break;
                case 4:
                    effect = new DashPathEffect(new float[]{1, 2, 1, 2, 4, 3}, 1);
                    paint.setPathEffect(effect);
                    canvas.drawPath(path, paint);
                    break;
                default:
                    canvas.drawPath(path, paint);
                    break;
            }

            effect = null;
            path = null;
        }


//		Path path=new Path();
//		path.moveTo((float)(pox+(dxfPolyline.point_y.get(0)-centery)*scaleX),(float)( poy-(dxfPolyline.point_x.get(0)-centerx)*scaleY));
//
//		for(int i=1;i<len;i++){
//			path.lineTo((float)(pox+(dxfPolyline.point_y.get(i)-centery)*scaleX),(float)( poy-(dxfPolyline.point_x.get(i)-centerx)*scaleY));
//		}
        //path.close();

    }

    //////画文本
    public static void drawTextR12(Canvas canvas, Rect rect, float pox, float poy, float scaleX, float scaleY, float centerx, float centery, Dxfr12_text dxfText, int backMode, float angle) {
        int textColor;


        if (dxfText.color >= 256 || dxfText.color <= 0) {
            textColor = backMode ^ Color.rgb(255, 255, 255);
        } else {
            textColor = colorTableR12[dxfText.color];
        }

        py[0] = poy - (dxfText.point_x - centerx) * scaleY;
        px[0] = pox + (dxfText.point_y - centery) * scaleX;
        double x = px[0];
        double y = py[0];
        px[0] = (x - pox) * Math.cos(angle) - (y - poy) * Math.sin(angle) + pox;
        py[0] = (x - pox) * Math.sin(angle) + (y - poy) * Math.cos(angle) + poy;
        if (rect.contains((int) px[0], (int) py[0])) {
            /////字体大小计算,原程序是计算的一个rect
            float tSize = (float) (dxfText.fontSize * scaleY / 2);
            //Paint paint=new Paint();
            //paint.setAntiAlias(true);
            paint.setColor(textColor);
            paint.setTextSize(tSize);
            paint.setTypeface(Typeface.DEFAULT);

            canvas.drawText(dxfText.text, (float) px[0], (float) py[0], paint);
        }


    }

    public static void drawDxfR12(Canvas canvas, Rect rect, float x_eve, float y_eve, float centerx, float centery, Dxf_r12 r12, float angle) {
        int width = rect.width();
        int height = rect.height();
        float pox = rect.left + 0.5f * width;
        float poy = rect.top + 0.5f * height;
        float scaleX = width / (10 * x_eve);
        float scaleY = height / (10 * y_eve);

        for(Dxfr12_text text:r12.strText){
            drawTextR12(canvas, rect, pox, poy, scaleX, scaleY, centerx, centery, text, r12.backMode, angle);
        }
        for(Dxfr12_polyline polyline:r12.strPolyline){
            drawPolyR12(canvas, rect, pox, poy, scaleX, scaleY, centerx, centery, polyline, r12.backMode, angle);
        }
        for(Dxfr12_circle circle:r12.strCircle){
            drawCircleR12(canvas, rect, pox, poy, scaleX, scaleY, centerx, centery, circle, r12.backMode, angle);
        }
        for(Dxfr12_arc arc:r12.strArc){
            drawArcR12(canvas, rect, pox, poy, scaleX, scaleY, centerx, centery, arc, r12.backMode, angle);
        }
        for(Dxfr12_solid solid:r12.strSolid){
            drawSolidR12(canvas, rect, pox, poy, scaleX, scaleY, centerx, centery, solid, r12.backMode, angle);
        }
        for(Dxfr12_line line:r12.strLine){
            drawLineR12(canvas, rect, pox, poy, scaleX, scaleY, centerx, centery, line, r12.backMode, angle);
        }
        for(Dxfr12_point point:r12.strPoint){
            drawPointR12(canvas, rect, pox, poy, scaleX, scaleY, centerx, centery, point, r12.backMode, angle);
        }
    }
}
