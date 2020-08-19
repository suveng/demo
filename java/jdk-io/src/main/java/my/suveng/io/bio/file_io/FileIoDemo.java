package my.suveng.io.bio.file_io;

import cn.hutool.core.util.RandomUtil;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author suwenguang
 **/
@Component
public class FileIoDemo {

    public void io() throws IOException {
        // 新建文件
        File file = new File("/data/logs/test.log");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        // 随机写入信息
        byte[] buff = new byte[64];
        for (int i = 0; i < 1000; i++) {
            buff = RandomUtil.randomBytes(buff.length);
            fileOutputStream.write(buff);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        // 读取信息
        FileInputStream fileInputStream = new FileInputStream(file);
        int i = 1;
        while (fileInputStream.read(buff) != -1) {
            System.out.println(i + "#" + Arrays.toString(buff));
            i++;
        }
        fileInputStream.close();
    }

}
