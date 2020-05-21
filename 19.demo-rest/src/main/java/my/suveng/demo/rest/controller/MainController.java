package my.suveng.demo.rest.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author suwenguang
 **/
@RestController
public class MainController {

	/**
	 * 指定请求方法
	 * 这里的 value和path不能同时使用
	 *
	 * @author suwenguang
	 */
	@RequestMapping(value = {"/get", "get.do"}, method = {RequestMethod.GET})
	public String get() {
		return "hello";
	}

	/**
	 * 参数前置条件,使用 params可以增加判定条件, 如果条件不通过,则返回400
	 * @author suwenguang
	 */
	@RequestMapping(value = {"/get/params"}, method = {RequestMethod.GET}, params = {"id!=100"})
	public String getParams(@RequestParam(value = "id") String id) {
		return "hello" + id;
	}


	/**
	 * consume设置contentType, 如果不在consumes里面的type则不处理,并返回415 不支持媒体类型
	 * @author suwenguang
	 */
	@RequestMapping(value = "/consume", consumes = {"application/json"})
	public String consume() {
		return "consume";
	}

	/**
	 * produce设置返回的contenttype类型, 如果header的accept没有这个content type则返回416,不可接受类型
	 * @author suwenguang
	 */
	@RequestMapping(value = "/produce", produces = "application/json")
	public String produce(HttpServletRequest request) {
		return "produce---"+request.getRemoteAddr()+"---"+request.getRemotePort()+"---"+request.getRequestURI();
	}

	/**
	 * header属性, 设置了之后,如果http的请求头没有这个header信息或者header信息不等,报404错误
	 * @author suwenguang
	 */
	@RequestMapping(value = "/header", headers = {"name=suveng"})
	public String header() {
		return "header";
	}


	/**
	 * Restful 返回
	 * @author suwenguang
	 */
	@RequestMapping("/rest")
	public String restful(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_OK);
		return "rest";
	}

	/**
	 * post 参数 表单
	 * 从参数里面获取
	 * @author suwenguang
	 */
	@RequestMapping("/post/form")
	public String formPost(String hello, String test) {

		return "hello=" + hello + "test=" + test;
	}

	/**
	 * post 参数 表单
	 * 从url里面获取
	 * @author suwenguang
	 */
	@RequestMapping("/post/{id}")
	public String formPost(@PathVariable(required = true,name = "id") String hello) {
		return "hello=" + hello;
	}

	/**
	 * post 参数 json
	 * @author suwenguang
	 */
	@RequestMapping("/post/json")
	public String jsonPost(@RequestBody RequestData requestData) {
		return "";
	}

	/**
	 * post multiform-part 上传文件
	 * @author suwenguang
	 */
	@RequestMapping("/post/upload")
	public String uploadPost(@RequestParam("file") MultipartFile file, RequestData requestData) {
		try {
			file.transferTo(new File("/data/logs/file-1"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/**
	 * post 下载文件
	 * @author suwenguang
	 */
	@RequestMapping("/post/download")
	public void download(HttpServletResponse response) {
		File file = new File("./hello");
		byte[] buff = new byte[64];

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			for (int i = 0; i < 100; i++) {
				Random random = new Random(2);
				random.nextBytes(buff);
				fileOutputStream.write(buff);
			}
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


		response.setContentType("application/x-msdownload");
		try {
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
			ServletOutputStream outputStream = response.getOutputStream();

			FileInputStream fileInputStream = new FileInputStream(file);
			while ((fileInputStream.read(buff,0,buff.length)) != -1){
				outputStream.write(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
