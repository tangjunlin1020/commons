package com.wondersgroup.commons.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;


public class WavComposeUtils {

    public WavComposeUtils() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) throws Exception {
        WavCompose("13167039209", "eeee", 5, "aaa");

//        File indexFile=new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\111.wav");
//        List<File> listFile=new <File>ArrayList();  ;
//        listFile.add(new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\1.wav"));
//        listFile.add(new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\2.wav"));
//        listFile.add(new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\3.wav"));
//        listFile.add(new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\4.wav"));
//        listFile.add(new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\5.wav"));
//
//        File descFile=new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\eeee.wav");
//
//        WavComposeUtils.mergeFile(indexFile,listFile,descFile);
    }

    public static void WavCompose(String str, String uuid, int number, String planid) {
        String telNumChinese = toTelNumChinese(str);
        telNumChinese = telNumChinese.substring(telNumChinese.length() - number, telNumChinese.length());
        List listUrl = new ArrayList();

        listUrl.add("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\\\E.wav");
        for (int i = 0; i < telNumChinese.length(); i++) {
            listUrl.add((new StringBuilder("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\")).append(telNumChinese.charAt(i)).append(".wav").toString());
//            listUrl.add((new StringBuilder("/data/voiceRecord/" + planid + "/1-0/")).append(telNumChinese.charAt(i)).append(".wav").toString());
        }

        listUrl.add("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\E.wav");


        String mubiaoUrl = (new StringBuilder("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\")).append(uuid).append(".wav").toString();
        File hebingUrl = new File(mubiaoUrl);
        List list = new ArrayList();
        File file2 = null;
        for (int i = 0; i < listUrl.size(); i++) {
            file2 = new File((String) listUrl.get(i));
            list.add(file2);
        }

        try {
            mergeFile((File) list.get(0), list, hebingUrl);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    /**
     * wav语音文件合成，多文件合并
     */
    public static void mergeFile(File indexFile, List<File> listFile, File descFile)
            throws IOException, UnsupportedAudioFileException {
        AudioFileFormat aff = AudioSystem.getAudioFileFormat(indexFile);
        AudioInputStream ais = null;
        List<InputStream> inp = new ArrayList<InputStream>();
        long sum = 0;
        for (int i = 0; i < listFile.size(); i++) {
            ais = AudioSystem.getAudioInputStream(listFile.get(i));
            inp.add(ais);
            sum += ais.getFrameLength();
        }
        Enumeration<InputStream> e = Collections.enumeration(inp);
        SequenceInputStream sis = new SequenceInputStream(e);
        ais.getFrameLength();
        if (sum != 0) {
            AudioSystem.write(new AudioInputStream(sis, aff.getFormat(), sum), aff.getType(), descFile);
        }
        if (ais != null)
            ais.close();
        if (sis != null)
            sis.close();
    }

    /**
     * 手机号码转大写
     */
    public static String toTelNumChinese(String telNum) {
        //        String[] s1 = { "零", "要", "二", "三", "四", "五", "六", "七", "八", "九" };
        String[] s1 = {"0", "要", "2", "3", "4", "5", "6", "7", "8", "9"};
        String result = "";
        int n = telNum.length();
        for (int i = 0; i < n; i++) {
            int num = telNum.charAt(i) - '0';
            result += s1[num];
        }
        return result;
    }

}