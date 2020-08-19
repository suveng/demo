package my.suveng.io.nio;

import cn.hutool.core.util.RandomUtil;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * java nio channel demo
 * 
 * @author suwenguang
 **/
public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
        File dir = new File("/data/logs/");
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                System.out.println("创建文件夹失败");
                return;
            }
        }

        RandomAccessFile file = new RandomAccessFile("/data/logs/test", "rw");

        FileChannel channel = file.getChannel();

        ByteBuffer writeBuffer = ByteBuffer.allocate(128);
        writeBuffer.clear();
        String s = RandomUtil.randomNumbers(128);

        writeBuffer.put(s.getBytes());
        int length = 0;
        writeBuffer.flip();
        while ((length = channel.write(writeBuffer)) != 0) {
            /*
             * 注意，这里不需要clear，将缓冲中的数据写入到通道中后 第二次接着上一次的顺序往下读
             */
            System.out.println("写入长度:" + length);
        }
        writeBuffer.flip();
        StringBuilder stringBuilder = new StringBuilder();
        while (writeBuffer.hasRemaining()) {
            stringBuilder.append((char) writeBuffer.get());
        }
        System.out.println("写入: " + stringBuilder.toString());
        writeBuffer.clear();
        file.close();
        channel.close();

        ByteBuffer buf = ByteBuffer.allocate(64);

        RandomAccessFile rw = new RandomAccessFile("/data/logs/test", "rw");
        channel = rw.getChannel();
        int bytesRead = channel.read(buf);

        while (bytesRead != -1) {

            System.out.println("\nRead " + bytesRead);
            buf.flip();

            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = channel.read(buf);
        }

    }
}
