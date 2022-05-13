package com.wondersgroup.commons.util.demo.io.file;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author tangjunlin
 * @date 2022/5/7 12:06
 */
public class ReadText {
    public static void readTxtFile(String filePath) {
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            JSONObject js = new JSONObject();
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                int total = 0;
                int total1 = 0;
                int total2 = 0;
                int total3 = 0;
                int total4 = 0;
                int total5 = 0;
                int total6 = 0;
                int total7 = 0;
                int total8 = 0;
                int totalMax = 0;
                int maxTime = 0;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    total++;
//                    System.out.println(lineTxt); // 一行一行的读
                    String[] s = lineTxt.split(" ");
                    String t = s[10];
                    int integer = Integer.valueOf(t);
                    if (0 < integer && integer <= 1000)
                        total1++;
                    else if (integer > 1000 && integer <= 2000)
                        total2++;
                    else if (integer > 2000 && integer <= 3000)
                        total3++;
                    else if (integer > 3000 && integer <= 4000) {
                        total4++;
                    } else if (integer > 4000 && integer <= 5000) {
                        total5++;
                    } else if (integer > 5000 && integer <= 6000) {
                        total6++;
                    } else if (integer > 6000 && integer <= 7000) {
                        total7++;
                    } else if (integer > 7000 && integer <= 8000) {
                        total8++;
                    } else if (integer > 8000) {
                        totalMax++;
                        System.out.println(lineTxt);
                    } else if (integer > maxTime) {
                        maxTime = integer;
                    }
                }
                System.out.println("输出的总数：" + total);
                System.out.println("小于1秒：" + total1);
                System.out.println("1到2秒：" + total2);
                System.out.println("2到3秒：" + total3);
                System.out.println("3到4秒：" + total4);
                System.out.println("4到5秒：" + total5);
                System.out.println("5到6秒：" + total6);
                System.out.println("6到7秒：" + total7);
                System.out.println("7到8秒：" + total8);
                System.out.println("大于8秒：" + totalMax);
                System.out.println("最大相应时间：" + maxTime);
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        } finally {
        }
    }

    public static void main(String argv[]) {
        long startTime = System.currentTimeMillis();
        String filePath = "D:\\垃圾桶\\localhost_access_log.2022-05-09.txt";
        readTxtFile(filePath);
        long endTime = System.currentTimeMillis();
        float ss=(float)(endTime-startTime)/1000;
        System.out.println("执行时间："+ss+"s");

    }


}
