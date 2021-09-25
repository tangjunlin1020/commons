package com.wondersgroup.commons.io;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;

import java.io.File;


/**
 * TODO
 * 音频文件wav转mp3格式
 *
 * @author tangjunlin
 * @date 2021/9/15 10:51
 * @since
 */
public class ChangeMp3 {
    public static void main(String[] args) throws Exception {
        Long time1 = System.currentTimeMillis();
        ChangeMp3 changeMp3 = new ChangeMp3();
//        changeMp3.changeSingle();
        changeMp3.changeAll();
        System.out.println("消耗：" + (System.currentTimeMillis() - time1) + "ms");
    }

    /**
     * 单个文件转换
     *
     * @throws Exception
     */
    public void changeSingle() throws Exception {
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(64000);//设置比特率
        audio.setSamplingRate(44100);
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");//设置格式
        attrs.setAudioAttributes(audio);
//attrs.setDuration(360f); // 设置截取的时长
        Encoder encoder = new Encoder();
        encoder.encode(new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\A.wav"), new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\A.mp3"), attrs);
    }

    public void changeAll() throws Exception {
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(64000);//设置比特率
        audio.setSamplingRate(44100);
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");//设置格式
        attrs.setAudioAttributes(audio);
//attrs.setDuration(360f); // 设置截取的时长
        Encoder encoder = new Encoder();
        String path="E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav";
        String[] lists= new File(path).list();
        for (int i = 0; i < lists.length; i++) {
            System.out.println(lists[i]);
            path=path+lists[i];

        }

//        encoder.encode(new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\A.wav"), new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\A.mp3"), attrs);

    }
}
