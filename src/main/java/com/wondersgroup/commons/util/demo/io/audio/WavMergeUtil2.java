package com.wondersgroup.commons.io.audio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 获取wav头文件然后合并成单个wav
 *
 * @author zcf
 * @date 2017-10-17
 */
/**
 * 获取wav头文件然后合并成单个wav
 * @author zcf
 * @date 2017-10-17
 */
public class WavMergeUtil2 {
    /**
     * meger多个wav
     * @param inputs 多个wav
     * @param output 要生成的wav
     * @throws IOException
     */
    public static void mergeWav(File[] inputs, String output) throws IOException {
        if (inputs.length < 1) {
            return;
        }
        try(FileInputStream fis = new FileInputStream(inputs[0]);
            FileOutputStream fos = new FileOutputStream(new File(output))){
            byte[] buffer = new byte[10240 * 4];
            int total = 0;
            int count;
            while ((count = fis.read(buffer)) > -1) {
                fos.write(buffer, 0, count);
                total += count;
            }
            fis.close();
            for (int i = 1; i < inputs.length; i++) {
                File file = inputs[i];
                try(FileInputStream fisH = new FileInputStream(file)){
                    Header header = resolveHeader(fisH);
                    FileInputStream dataInputStream = header.dataInputStream;
                    while ((count = dataInputStream.read(buffer)) > -1) {
                        fos.write(buffer, 0, count);
                        total += count;
                    }
                }
            }
            fos.flush();
            fos.close();
            FileInputStream fisHo = new FileInputStream(new File(output));
            Header outputHeader = resolveHeader(fisHo);
            outputHeader.dataInputStream.close();
            try(RandomAccessFile res = new RandomAccessFile(output, "rw")){
                res.seek(4);
                byte[] fileLen = intToByteArray(total + outputHeader.dataOffset - 8);
                res.write(fileLen, 0, 4);
                res.seek(outputHeader.dataSizeOffset);
                byte[] dataLen = intToByteArray(total);
                res.write(dataLen, 0, 4);
            }
        }
    }
    /**
     * 解析头部，并获得文件指针指向数据开始位置的InputStreram，记得使用后需要关闭
     */
    private static Header resolveHeader(FileInputStream fis) throws IOException {
        byte[] byte4 = new byte[4];
        byte[] buffer = new byte[2048];
        int readCount = 0;
        Header header = new Header();
        fis.read(byte4);// RIFF
        fis.read(byte4);
        readCount += 8;
        header.fileSizeOffset = 4;
        header.fileSize = byteArrayToInt(byte4);
        fis.read(byte4);// WAVE
        fis.read(byte4);// fmt
        fis.read(byte4);
        readCount += 12;
        int fmtLen = byteArrayToInt(byte4);
        fis.read(buffer, 0, fmtLen);
        readCount += fmtLen;
        fis.read(byte4);// data or fact
        readCount += 4;
        if (isFmt(byte4, 0)) {// 包含fmt段
            fis.read(byte4);
            int factLen = byteArrayToInt(byte4);
            fis.read(buffer, 0, factLen);
            fis.read(byte4);// data
            readCount += 8 + factLen;
        }
        fis.read(byte4);// data size
        int dataLen = byteArrayToInt(byte4);
        header.dataSize = dataLen;
        header.dataSizeOffset = readCount;
        readCount += 4;
        header.dataOffset = readCount;
        header.dataInputStream = fis;
        return header;
    }
    private static boolean isRiff(byte[] bytes, int start) {
        if (bytes[start + 0] == 'R' && bytes[start + 1] == 'I' && bytes[start + 2] == 'F' && bytes[start + 3] == 'F') {
            return true;
        } else {
            return false;
        }
    }
    private static boolean isFmt(byte[] bytes, int start) {
        if (bytes[start + 0] == 'f' && bytes[start + 1] == 'm' && bytes[start + 2] == 't' && bytes[start + 3] == ' ') {
            return true;
        } else {
            return false;
        }
    }
    private static boolean isData(byte[] bytes, int start) {
        if (bytes[start + 0] == 'd' && bytes[start + 1] == 'a' && bytes[start + 2] == 't' && bytes[start + 3] == 'a') {
            return true;
        } else {
            return false;
        }
    }
    /**
     * 将int转化为byte[]
     */
    private static byte[] intToByteArray(int data) {
        return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(data).array();
    }
    /**
     * 将short转化为byte[]
     */
    private static byte[] shortToByteArray(short data) {
        return ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(data).array();
    }
    /**
     * 将byte[]转化为short
     */
    private static short byteArrayToShort(byte[] b) {
        return ByteBuffer.wrap(b).order(ByteOrder.LITTLE_ENDIAN).getShort();
    }
    /**
     * 将byte[]转化为int
     */
    private static int byteArrayToInt(byte[] b) {
        return ByteBuffer.wrap(b).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }
    /**
     * 头部部分信息
     */
    static class Header {
        public int fileSize;
        public int fileSizeOffset;
        public int dataSize;
        public int dataSizeOffset;
        public int dataOffset;
        public FileInputStream dataInputStream;
    }

    public static void main(String[] args) throws IOException {
        File[] files = {
//                new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\letter.wav"),
                new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\B.wav"),
                new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\5.wav"),
                new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\1.wav"),
                new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\8.wav"),
                new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\4.wav"),
                new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\W.wav"),

                new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\0.wav"),
                new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\A.wav"),
                new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\3.wav"),
//                new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\N.wav"),
//                new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\N.wav"),
//                new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\N.wav"),
        };
        mergeWav(files, "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav - new\\merge.wav");
//		FileOutputStream out =new FileOutputStream(new File("E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\ssd.wav"));
//		out.write(mergeWav(files));
        System.out.printf("执行结束1");
    }
}
