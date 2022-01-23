package com.wondersgroup.commons.util.demo.io.audio;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 音频文件的合并
 *
 * @author tangjunlin
 * @date 2022/1/23 12:13
 */
public class AudioMergeUtil {
    public static void main(String[] args) throws Exception {
        String outmp3 = "src\\main\\resources\\audio\\wavChangeMp3\\mergeMp3.mp3";
        String outwav = "src\\main\\resources\\audio\\wavChangeMp3\\mergeWav.wav";//需要合并的文件最好格式要一致，否则就会出现变声的情况

        String filepath1 = "src\\main\\resources\\audio\\wavChangeMp3\\letter.mp3";
        String filepath2 = "src\\main\\resources\\audio\\wavChangeMp3\\a.mp3";
        String filepath3 = "src\\main\\resources\\audio\\wavChangeMp3\\3.mp3";
        String filepath4 = "src\\main\\resources\\audio\\wavChangeMp3\\2.mp3";
        String filepath5 = "src\\main\\resources\\audio\\wavChangeMp3\\V.mp3";

        String filepath11 = "src\\main\\resources\\audio\\wavChangeMp3\\letter.wav";
        String filepath12 = "src\\main\\resources\\audio\\wavChangeMp3\\a.wav";
        String filepath13 = "src\\main\\resources\\audio\\wavChangeMp3\\3.wav";
        String filepath14 = "src\\main\\resources\\audio\\wavChangeMp3\\2.wav";
        String filepath15 = "src\\main\\resources\\audio\\wavChangeMp3\\V.wav";
        AudioMergeUtil.audioMerge("mp3", outmp3, filepath1, filepath2, filepath3, filepath4, filepath5);
        AudioMergeUtil.audioMerge("wav", outwav, filepath11, filepath12, filepath13, filepath14, filepath15);
        System.out.println("合成完毕");
    }

    /**
     * 将多个wav合成一个新的wav
     *
     * @param out 输出文件
     * @param in  输入文件数组
     * @throws IOException
     */
    private static void audioMerge(String type, String out, String... in) throws Exception {
        File outFile = new File(out);
        if (!outFile.getParentFile().exists())
            outFile.getParentFile().mkdirs();
        if (!outFile.exists())
            outFile.createNewFile();
        OutputStream os = new FileOutputStream(outFile);// 追加
        for (int i = 0; i < in.length; i++) {
            File file1 = new File(in[i]);
            if (!file1.exists())
                continue;
            System.out.println(in[i] + "文件长度：" + file1.length());
            InputStream is = new FileInputStream(file1);
            if (type.equals("wav")) {
                if (i != 0) {
                    is.skip(444);// 跳过后面的.wav的文件头
                }
            }
            byte[] tempBuffer = new byte[1024];
            int nRed = 0;
            // 将wav全部内容复制到out.wav
            while ((nRed = is.read(tempBuffer, 0, 1024)) != -1) {
                os.write(tempBuffer, 0, nRed);
            }
            is.close();
        }
        os.flush();
        os.close();
        if (type.equals("wav")) {
            AudioMergeUtil audioMergeUtil = new AudioMergeUtil();
            // 到此完成了in数组全部wav合并成out.wav,但是此时播放out.wav,音频内容仍然只是第一个音频的内容，所以还要更改out.wav的文件头
            for (String s : in) audioMergeUtil.updateFileHead(s, false);
            audioMergeUtil.updateFileHead(out, true);//头部合成
        }
    }

    //更改文件头
    private void updateFileHead(String out, boolean ifUpdate) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(out, "rw");
        //long fileLength = raf.length();
        // 打开一个文件通道
        FileChannel channel = raf.getChannel();
        // 映射文件中的某一部分数据以读写模式到内存中
        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 44);// 文件头长度
        // 修改头部文件
        if (ifUpdate) {
            byte[] head1 = byteToByte(intToByteArray(headLength1));
            byte[] head2 = byteToByte(intToByteArray(headLength2));
            // 进行修改操作
            buffer.put(4, head1[0]);
            buffer.put(5, head1[1]);
            buffer.put(6, head1[2]);
            buffer.put(7, head1[3]);
            buffer.put(40, head2[0]);
            buffer.put(41, head2[1]);
            buffer.put(42, head2[2]);
            buffer.put(43, head2[3]);
            buffer.force();//强制输出，在buffer中的改动生效到文件
        } else {
            //noinspection ConstantConditions
            headLength1 = headLength1 + byteArrayToInt(byteToByte(new byte[]{buffer.get(4), buffer.get(5), buffer.get(6), buffer.get(7)}));
            //noinspection ConstantConditions
            headLength2 = headLength2 + byteArrayToInt(byteToByte(new byte[]{buffer.get(40), buffer.get(41), buffer.get(42), buffer.get(43)}));
        }
        buffer.clear();
        channel.close();
        raf.close();
    }

    private int headLength1 = 0;
    private int headLength2 = 0;

    public static int byteArrayToInt(byte[] b) {
        return b[3] & 0xFF | (b[2] & 0xFF) << 8 | (b[1] & 0xFF) << 16 | (b[0] & 0xFF) << 24;
    }

    public static byte[] intToByteArray(int a) {
        return new byte[]{(byte) ((a >> 24) & 0xFF), (byte) ((a >> 16) & 0xFF), (byte) ((a >> 8) & 0xFF), (byte) (a & 0xFF)};
    }

    //字节翻转
    public static byte[] byteToByte(byte[] a) {
        if (a.length == 4)
            return new byte[]{a[3], a[2], a[1], a[0]};
        return null;
    }


}
