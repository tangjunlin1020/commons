import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Wav文件多合一
 *
 * @author yujing 2020年6月15日15:43:20
 */
public class WavCompose{
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
            headLength1 = headLength1 + byteArrayToInt(byteToByte(new byte[]{buffer.get(4), buffer.get(5), buffer.get(6), buffer.get(7)}));;
            //noinspection ConstantConditions
            headLength2 = headLength2 + byteArrayToInt(byteToByte(new byte[]{buffer.get(40), buffer.get(41), buffer.get(42), buffer.get(43)}));;
        }
        buffer.clear();
        channel.close();
        raf.close();
    }

    /**
     * 将多个wav合成一个新的wav
     *
     * @param out 输出文件
     * @param in  输入文件数组
     * @throws IOException
     */
    public void addWav(String out, String... in) throws IOException {
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
            //System.out.println(in[i] + "文件长度：" + file1.length());
            InputStream is = new FileInputStream(file1);
            if (i != 0) {
                //noinspection ResultOfMethodCallIgnored
                is.skip(44);// 跳过后面的.wav的文件头
            }
            byte[] tempBuffer = new byte[1024];
            int nRed = 0;
            // 将wav全部内容复制到out.wav
            while ((nRed = is.read(tempBuffer)) != -1) {
                os.write(tempBuffer, 0, nRed);
                os.flush();
            }
            is.close();
        }
        os.close();
        // 到此完成了in数组全部wav合并成out.wav,但是此时播放out.wav,音频内容仍然只是第一个音频的内容，所以还要更改out.wav的文件头
//        for (String s : in) updateFileHead(s, false);
//        updateFileHead(out, true);//头部合成
    }

    public static void main(String[] args) throws IOException {
        String out = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\test2.wav";
        String filepath1 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\0.wav";
        String filepath2 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\5.wav";
        String filepath3 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\2.wav";
        String filepath4 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\3.wav";
        String filepath5 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\7.wav";
//        String filepath1 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\U.wav";
//        String filepath2 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\T.wav";
//        String filepath3 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\Z.wav";
//        String filepath4 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\AA.wav";
//        String filepath5 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\V.wav";
        String filepath6 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\letter.wav";
        String filepath7 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\number.wav";

        WavCompose wav = new WavCompose();
        wav.addWav(out, filepath1, filepath2, filepath3, filepath4, filepath5,filepath6,filepath7);
        System.out.println("合成完毕");

        String out2 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\test3.wav";
        String filepath11 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\A.wav";
        String filepath22 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\letter.wav";
        wav.addWav(out2, filepath11, filepath22);
        String out3 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\test4.mp3";
        String filepath14 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\A.mp3";
        String filepath24 = "E:\\ItemWorkspace\\IDEA_workspace\\commons\\src\\main\\resources\\wav\\letter.mp3";
        wav.addWav(out3, filepath14, filepath24);
        System.out.println("2合成完毕");
    }
}
