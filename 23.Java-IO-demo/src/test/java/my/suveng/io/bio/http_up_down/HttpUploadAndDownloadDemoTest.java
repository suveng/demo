package my.suveng.io.bio.http_up_down;

import cn.hutool.core.util.RandomUtil;
import my.suveng.io.JavaIoApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;

/**
 *
 * @author suwenguang
 **/
class HttpUploadAndDownloadDemoTest extends JavaIoApplicationTest {

	@Test
	void upload() throws InterruptedException, IOException {
		Thread.sleep(1000 * 10);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
		File testFile = new File("/data/logs/test");
		if (!testFile.exists()){
			boolean newFile = testFile.createNewFile();
			if (!newFile){
				System.out.println("创建测试文件失败");
				return;
			}
		}

		FileWriter fileWriter = new FileWriter(testFile);
		for (int i = 0; i < 100; i++) {
			fileWriter.write(RandomUtil.randomString(64));
		}
		fileWriter.flush();
		fileWriter.close();

		FileInputStream value = new FileInputStream(testFile);
		value.getFD().sync();
		FileSystemResource fileSystemResource = new FileSystemResource(testFile);
		params.add("file", fileSystemResource);

		HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(params,headers);
		ResponseEntity<String> exchange = restTemplate.exchange("http://127.0.0.1:38089/http/upload", HttpMethod.POST, httpEntity, String.class);
		System.out.println(exchange.getBody());
	}

	@Test
	void download() throws InterruptedException {
		Thread.sleep(1000 * 10);

	}
}
