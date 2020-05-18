package jiaoxi.crazyit.classes.xyz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class DrawXYZ {
    public static double[] px = null;
    public static double[] py = null;
    public static Kryo kryo = new Kryo();

    public List<Str_Xyz> readSerXYZ(String fileName) {
        List<Str_Xyz> xyzs = null;
        File f = new File(fileName);
        if (!f.exists()) {
            return xyzs = new ArrayList<Str_Xyz>();
        }

        Input input = null;
        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            input = new Input(new FileInputStream(raf.getFD()), 65535);
            xyzs = (List<Str_Xyz>) kryo.readObject(input, ArrayList.class);

            int xnum = xyzs.size();
            int maxLen = 0;
            for (int i = 0; i < xnum; i++) {
                if (xyzs.get(i).x.size() > maxLen) {
                    maxLen = xyzs.get(i).x.size();
                }
            }
            if (maxLen > 0) {
                px = new double[maxLen];
                py = new double[maxLen];
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (input != null) {
                input.close();
            }
        }
        return xyzs;
    }

    public void saveSerXYZ(String fileName, List<Str_Xyz> xyzs) {
        Output output = null;
        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
            output = new Output(new FileOutputStream(raf.getFD()), 65535);
            kryo.writeObject(output, xyzs);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    public void readXYZFile(String fileName, List<Str_Xyz> strxyzs) {
        File f = new File(fileName);
        InputStream in = null;
        int fileLen = (int) f.length();

        byte[] s = new byte[fileLen];

        try {
            in = new FileInputStream(f);

            in.read(s);
            //in.close();
        } catch (Exception e) {
            return;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Str_Xyz strxyz = new Str_Xyz();
        int seek = 0;
        byte[] s0 = new byte[20];
        byte[] ss = new byte[100];
        seek = readLine(s, ss, fileLen, seek, 100);   //不懂要干嘛  27
        int seek0 = 0;           //10
        seek0 = readBlankData_XYZ(ss, s0, ss.length, seek0, 20);
        double y = Double.parseDouble((new String(s0)).trim());
        strxyz.y.add(y);
        strxyz.maxY = y;
        strxyz.minY = y;
        seek0 = readBlankData_XYZ(ss, s0, ss.length, seek0, 20);
        double x = Double.parseDouble((new String(s0)).trim());
        strxyz.x.add(x);
        strxyz.maxX = x;
        strxyz.minX = x;
        seek0 = readBlankData_XYZ(ss, s0, ss.length, seek0, 20);
        float z = Float.parseFloat((new String(s0)).trim());
        strxyz.z.add(z);
        strxyz.maxZ = z;
        strxyz.minZ = z;

        while (seek < fileLen) {
            seek = readLine(s, ss, fileLen, seek, 100);
            seek0 = 0;
            seek0 = readBlankData_XYZ(ss, s0, ss.length, seek0, 20);
            double y1 = Double.parseDouble((new String(s0)).trim());
            strxyz.y.add(y1);
            if (y1 > strxyz.maxY) {
                strxyz.maxY = y1;
            }
            if (y1 < strxyz.minY) {
                strxyz.minY = y1;
            }
            seek0 = readBlankData_XYZ(ss, s0, ss.length, seek0, 20);
            double x1 = Double.parseDouble((new String(s0)).trim());
            strxyz.x.add(x1);
            if (x1 > strxyz.maxX) {
                strxyz.maxX = x1;
            }
            if (x1 < strxyz.minX) {
                strxyz.minX = x1;
            }
            seek0 = readBlankData_XYZ(ss, s0, ss.length, seek0, 20);
            float z1 = Float.parseFloat((new String(s0)).trim());
            strxyz.z.add(z1);
            if (z1 > strxyz.maxZ) {
                strxyz.maxZ = z1;
            }
            if (z1 < strxyz.minZ) {
                strxyz.minZ = z1;
            }
        }
        strxyzs.add(strxyz);
    }

    public int readBlankData_XYZ(byte[] s, byte[] s0, int fileLen, int seek, int maxLen) {
        int i, k;
        for (i = 0; i < maxLen; i++) {
            s0[i] = 0;
        }
        boolean enable = false;
        for (i = seek; i < fileLen; i++) {
            if (((s[i] == ' ' || s[i] == '\t' || s[i] == ',') && i != seek) || s[i] == 10 || s[i] == 13 || s[i] == 0) {
                for (k = seek; k < i; k++) {
                    if (s[k] != ' ' && s[k] != '\t' && s[k] != ',' && s[k] != 10 && s[k] != 13) {
                        enable = true;
                    }
                }
                if (enable)
                    break;
            }
        }
        if (i - seek < maxLen) {
            for (k = 0; k < i - seek; k++) {
                s0[k] = s[seek + k];
            }
        }
        return i + 1;
    }

    public int readLine(byte[] s, byte[] s0, int fileLen, int seek, int maxLen) {
        int i, k;
        for (i = 0; i < maxLen; i++) {
            s0[i] = 0;
        }
        for (i = seek; i < fileLen; i++) {
            if (s[i] == 0x0d) {
                break;
            }
        }
        if (i - seek < maxLen) {
            for (k = 0; k < i - seek; k++) {
                s0[k] = s[seek + k];
            }
        }
        return i + 2;
    }

    public static void DrawXYZToCanvas(Canvas canvas, Str_Xyz strxyz, Rect rect, double centerx, double centery, double x_eve, double y_eve, float filterMax, float filterMin, int[] color, float[] colorDeep, int numOfRGB, boolean colorModel, float angle) {

        double height = rect.height();
        double width = rect.width();
        int currentColor = Color.rgb(0, 0, 0);

        double pox, poy;
        pox = rect.left + 0.5 * width;
        poy = rect.top + 0.5 * height;
        int len = strxyz.x.size();
		/*double[] px=new double[len];
		double[] py=new double[len];*/

        canvas.drawColor(Color.TRANSPARENT);

        //修改iSpace2=36；原程序为500    PC版本中为36
        int iSpace2 = 36;//过滤水深数据 数值越高 过滤越厉害 显示数值越少 画面越流畅
        int iSpace = 0;
		
		/*Iterator<Double> ix=strxyz.x.iterator();
		Iterator<Double> iy=strxyz.y.iterator();
		int index=0;
		while(ix.hasNext()){
			px[index]=pox+(iy.next()-centery)*width/(10*x_eve);
			py[index]=poy-(ix.next()-centerx)*height/(10*y_eve);
			index++;
		}*/
        List<Double> lx = strxyz.x;
        List<Double> ly = strxyz.y;

        float scaleX = (float) (width / (10 * x_eve));
        float scaleY = (float) (height / (10 * y_eve));
        double x = 0;
        double y = 0;
        for (int i = 0; i < len; i++) {
			/*px[i]=pox+(ly.get(i)-centery)*width/(10*x_eve);
			py[i]=poy-(lx.get(i)-centerx)*height/(10*y_eve);*/
            /////修改,本来写的旋转画布,虽简单,速度也快,但字也跟着转了,不方便看
            px[i] = pox + (ly.get(i) - centery) * scaleX;
            py[i] = poy - (lx.get(i) - centerx) * scaleY;
            x = px[i];
            y = py[i];
            px[i] = (x - pox) * Math.cos(angle) - (y - poy) * Math.sin(angle) + pox;
            py[i] = (x - pox) * Math.sin(angle) + (y - poy) * Math.cos(angle) + poy;
        }
        double oldX = 0;
        double oldY = 0;
        List<Float> lz = strxyz.z;
        for (int i = 0; i < len; i++) {

            iSpace = (int) ((px[i] - oldX) * (px[i] - oldX) + (py[i] - oldY) * (py[i] - oldY));

            if (iSpace > iSpace2) {
                float z = lz.get(i);
                if (rect.contains((int) px[i], (int) py[i]) && z >= filterMin && z <= filterMax) {
                    currentColor = getCurrentColor(z, color, colorDeep, numOfRGB, colorModel);
                    Paint paint = new Paint();
                    paint.setColor(currentColor);//字体颜色
                    paint.setTextSize(20);//字体大小
                    canvas.drawPoint((float) px[i], (float) py[i], paint);
                    canvas.drawText(String.valueOf(z), (float) px[i] - 3, (float) py[i] - 8, paint);
                    //canvas.drawText(String.valueOf(z),convertToFloat(lx.get(i)),convertToFloat(ly.get(i)),paint);
                    paint = null;
                }
                oldX = px[i];
                oldY = py[i];
            }

        }

    }

    public static int getCurrentColor(float sd, int[] strColor, float[] colorDeep, int numOfRGB, boolean colorModel) {
        int ddd = Color.rgb(255, 255, 255);
        int rr, gg, bb;
        int r1, r2, g1, g2, b1, b2;
        if (numOfRGB < 1) {
            return ddd;
        }
        if (sd <= colorDeep[0]) {
            return strColor[0];
        }
        if (sd >= colorDeep[numOfRGB - 1]) {
            return strColor[numOfRGB - 1];
        }
        for (int i = 0; i < numOfRGB - 1; i++) {
            if (sd >= colorDeep[i] && sd < colorDeep[i + 1]) {
                if (colorModel) {
                    r1 = (strColor[i]) & 0xff;
                    g1 = (strColor[i] >> 8) & 0xff;
                    b1 = (strColor[i] >> 16) & 0xff;
                    r2 = (strColor[i + 1]) & 0xff;
                    g2 = (strColor[i + 1] >> 8) & 0xff;
                    b2 = (strColor[i + 1] >> 16) & 0xff;
                    if (colorDeep[i + 1] - colorDeep[i] == 0) return strColor[i];
                    rr = (int) ((sd - colorDeep[i]) / (colorDeep[i + 1] - colorDeep[i]) * (r2 - r1) + r1);
                    gg = (int) ((sd - colorDeep[i]) / (colorDeep[i + 1] - colorDeep[i]) * (g2 - g1) + g1);
                    bb = (int) ((sd - colorDeep[i]) / (colorDeep[i + 1] - colorDeep[i]) * (b2 - b1) + b1);
                    ddd = Color.rgb(rr, gg, bb);
                    //			ddd=(sd-StrColor[i].SD)/(StrColor[i+1].SD-StrColor[i].SD)
                    //				*(StrColor[i+1].Color-StrColor[i].Color)+StrColor[i].Color;
                } else
                    ddd = strColor[i];
                return ddd;
            }
        }
        return ddd;
    }
}
