package my.suveng.io.bio.http_up_down;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * http服务上传和下载demo
 * 
 * @author suwenguang
 **/
@Controller
@RequestMapping("/http")
public class HttpUploadAndDownloadDemo {

    /**
     * 上传
     * 
     * @author suwenguang
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        Assert.notNull(file);
        String dir = "/data/logs/upload/";
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            boolean mkdir = dirFile.mkdirs();
            if (!mkdir) {
                System.out.println("创建目录失败");
                return "创建目录失败";
            }
        }

        String dest = dir + new DateTime().toString("yyyy-MM-dd");
        File destFile = new File(dest);
        if (!destFile.exists()) {
            boolean newFile = destFile.createNewFile();
            if (!newFile) {
                System.out.println("创建文件失败");
                return "创建文件失败";
            }
        }

        file.transferTo(destFile);
        return "success";
    }

    /**
     * 下载
     * 
     * @author suwenguang
     */
    @RequestMapping("/download")
    public void download(HttpServletResponse response) throws IOException {

        response.setContentType("application/x-msdownload");
        String pathname = "/data/logs/test";
        File file = new File(pathname);
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
            if (!newFile) {
                System.out.println("创建文件失败");
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "创建文件失败");
                return;
            }
        }

        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < 10; i++) {
            fileWriter.write(RandomUtil.randomString(64));
        }
        fileWriter.flush();
        fileWriter.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.getFD().sync();

        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            FileUtil.writeToStream(file, outputStream);
        }
    }
}
