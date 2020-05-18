package jiaoxi.crazyit.classes.UISet;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import jiaoxi.crazyit.classes.PlaneInstallJx;

public class DrawShip {
    /**
     * 2020/5
     * 卢从洋
     * 画船体
     * @Param PlaneInstallJx pin
     * 接收ReadPlaneInstall方法中的PlaneInstallJx对象
     */

    private static int shipArraySize=12;  //画船所用的数组长度
    private PlaneInstallJx pin;
    public void drawShip(PlaneInstallJx pin,String filename){
        this.pin=pin;
        readFileByLines(filename);
    }

    public static void setShipArraySize(){
        boolean hasSD= Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
        String sdPath="";
        if(hasSD){
            sdPath=Environment.getExternalStorageDirectory().getPath();
        }
        DrawShip drawShip=new DrawShip();
        shipArraySize=drawShip.readFileByLines(sdPath+"/project/ship.txt");
        System.out.println("shipArraySize:"+shipArraySize);
    }
    public static int shipArrSize(){
        return shipArraySize;
    }

    /**
     * 读文件并完成绘制船体
     * @param fileName 船体文件路径
     *                 文件要求：x0,y0
     *                          x1,y1    //英文逗号隔开
     *                          ...
     *                 如此格式，绘图时，第一个点连接第二个点，第二个连第三个...（按老代码的思想来的）
     */
    public int readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            //以行为单位读取文件内容，一次读一整行
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int i=0;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                String temp[]=tempString.split(",");
                pin.ShipPlane[i].x=Float.parseFloat(temp[0]);
                pin.ShipPlane[i++].y=Float.parseFloat(temp[1]);
            }
            reader.close();
            return --i;
        } catch (IOException e) {
            oldShip();
            e.printStackTrace();
        }catch (IndexOutOfBoundsException e){
            oldShip();
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return 0;
    }

    //老的代码，保留备份
    public void oldShip(){
        /**
         * 尖头
         * Trunnion.x表示长度
         * Trunnion.y表示垂直高度（个人理解）
         */
        pin.Trunnion.x=60.9f;
        pin.Trunnion.y=9.1f;

        /**
         * 船体画法
         */
        pin.ShipPlane[0].x=86.1f;
        pin.ShipPlane[0].y=0f;
        pin.ShipPlane[1].x=0f;
        pin.ShipPlane[1].y=0f;
        pin.ShipPlane[2].x=0f;
        pin.ShipPlane[2].y=6.6f;
        pin.ShipPlane[3].x=13.1f;
        pin.ShipPlane[3].y=6.6f;
        pin.ShipPlane[4].x=13.1f;
        pin.ShipPlane[4].y=11.6f;
        pin.ShipPlane[5].x=0f;
        pin.ShipPlane[5].y=11.6f;
        pin.ShipPlane[6].x=0f;
        pin.ShipPlane[6].y=18.2f;
        pin.ShipPlane[7].x=86.1f;
        pin.ShipPlane[7].y=18.2f;
        pin.ShipPlane[8].x=86.1f;
        pin.ShipPlane[8].y=12.6f;
        pin.ShipPlane[9].x=57.4f;
        pin.ShipPlane[9].y=12.6f;
        pin.ShipPlane[10].x=57.4f;
        pin.ShipPlane[10].y=5.6f;
        pin.ShipPlane[11].x=86.1f;
        pin.ShipPlane[11].y=5.6f;
    }
}
