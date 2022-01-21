package com.wondersgroup.commons.io.audio;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;

/**
 * 音频工具类
 * @author tangjunlin
 * @date: 2022/1/20
 *
*/


public class AudioWavUtils  {

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

    public static void main(String[] args) throws Exception {
        File source=new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\6.wav");
        System.out.println(getDuration(source));
    }
}