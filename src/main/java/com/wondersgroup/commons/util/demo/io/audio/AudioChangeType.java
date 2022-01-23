package com.wondersgroup.commons.util.demo.io.audio;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;

/**
 * 音频类型转换工具类
 *
 * @author tangjunlin
 * @date 2022/1/21 17:13
 */
public class AudioChangeType {

    public static void main(String[] args) throws Exception {
        long oldTime = System.currentTimeMillis();

        changeWavToMp3("src\\main\\resources\\audio\\wavChangeMp3\\0.wav", "src\\main\\resources\\audio\\wavChangeMp3\\00.mp3");//单个WAV转mp3
        changeMp3ToWav("src\\main\\resources\\audio\\wavChangeMp3\\0.mp3", "src\\main\\resources\\audio\\wavChangeMp3\\00.wav");//单个mp3转WAV
        changeAllWavToMp3();//目录下所有的WAV转mp3

        System.out.println(getDuration(new File("src\\main\\resources\\audio\\wavChangeMp3\\0.wav")));//获取音频大小

        System.out.println("消耗：" + (System.currentTimeMillis() - oldTime) + "ms");
    }

    private static void changeWavToMp3(String localPath, String newPath) throws Exception {
        EncodingAttributes encodingAttributes = changeSingle("mp3");
        new Encoder().encode(new File(localPath), new File(newPath), encodingAttributes);
    }

    private static void changeMp3ToWav(String localPath, String newPath) throws Exception {
        EncodingAttributes encodingAttributes = changeSingle("wav");
        new Encoder().encode(new File(localPath), new File(newPath), encodingAttributes);
    }

    private static void changeAllWavToMp3() throws Exception {
        String localPaths = "src\\main\\resources\\audio\\wavChangeMp3\\";
        String[] list = new File(localPaths).list();
        for (int i = 0; i < list.length; i++) {
            String localPath = localPaths + list[i];
            if (localPath.contains(".wav")) {
                System.out.println(list[i]);
                System.out.println("原来：" + localPath);
                String newPath = localPath.replace(".wav", ".mp3");
                System.out.println("之后：" + newPath);
                AudioChangeType.changeWavToMp3(localPath, newPath);
            }
        }
    }

    private static EncodingAttributes changeSingle(String audioType) {
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(64000);//设置比特率
        audio.setSamplingRate(44100);
        EncodingAttributes encodingAttributes = new EncodingAttributes();
        if (audioType.equals("mp3")) {
            encodingAttributes.setFormat("mp3");//设置格式
        } else if (audioType.equals("wav")) {
            encodingAttributes.setFormat("wav");
        } else {
            return null;
        }
        encodingAttributes.setAudioAttributes(audio);
        encodingAttributes.setDuration(3600f); // 设置截取的时长
        return encodingAttributes;
    }

    public static Long getDuration(File source) {
        Encoder encoder = new Encoder();
        long ls = 0;
        MultimediaInfo m;
        try {
            m = encoder.getInfo(source);
            ls = m.getDuration();
        } catch (Exception e) {
            System.out.println("获取音频时长有误：" + e.getMessage());
        }
        return ls;
    }

}
