package com.wondersgroup.commons.io.audio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class My {

    public static void main(String[] args) throws IOException {

//        String pathh="E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\";
        String pathh="E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav(1)\\wav\\";
        String[] lists= new File(pathh).list();
        for (int i = 0; i < lists.length; i++) {
            String path=pathh+lists[i];
            if(path.contains(".wav")) {
                System.out.println(lists[i]);
                File f = new File(path);
                RandomAccessFile rdf = null;
                rdf = new RandomAccessFile(f, "r");

                System.out.println("audio size: " + toInt(read(rdf, 4, 4))); // 音频文件大小

                System.out.println("audio format: " + toShort(read(rdf, 20, 2))); // 音频格式，1-PCM

                System.out.println("num channels: " + toShort(read(rdf, 22, 2))); // 1-单声道；2-双声道

                System.out.println("sample rate: " + toInt(read(rdf, 24, 4))); // 采样率、音频采样级别

                System.out.println("byte rate: " + toInt(read(rdf, 28, 4))); // 每秒波形的数据量

                System.out.println("block align: " + toShort(read(rdf, 32, 2))); // 采样帧的大小

                System.out.println("bits per sample: " + toShort(read(rdf, 34, 2))); // 采样位数

                rdf.close();

            }
        }
    }

    public static int toInt(byte[] b) {
        return ((b[3] << 24) + (b[2] << 16) + (b[1] << 8) + (b[0] << 0));
    }

    public static short toShort(byte[] b) {
        return (short) ((b[1] << 8) + (b[0] << 0));
    }

    public static byte[] read(RandomAccessFile rdf, int pos, int length) throws IOException {
        rdf.seek(pos);
        byte result[] = new byte[length];
        for (int i = 0; i < length; i++) {
            result[i] = rdf.readByte();
        }
        return result;
    }
}