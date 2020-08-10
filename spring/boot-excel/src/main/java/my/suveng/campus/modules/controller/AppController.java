package my.suveng.campus.modules.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import my.suveng.campus.modules.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * description:
 * @author suwenguang
 * @date 2019-08-25
 * @version 1.0.0
 **/
@Controller
public class AppController {
	@Autowired
	private Configuration configuration;

	@RequestMapping("/export")
	public void export(HttpServletResponse response) throws Exception {
		//自己封装号数据实体
		ArrayList<Product> products = new ArrayList<>();

		//构造数据
		for (int i = 0; i < 100; i++) {
			Product e = new Product();
			e.setName(RandomUtil.randomString(5));
			e.setNumber(RandomUtil.randomString(2));
			e.setOut(RandomUtil.randomString(2));
			e.setIn(RandomUtil.randomString(2));
			e.setType(RandomUtil.randomString(5));
			e.setUnit(RandomUtil.randomString(4));
			e.setMonthNumber(RandomUtil.randomString(1));
			e.setDate(new Date());
			products.add(e);
		}
		HashMap<String, Object> map = new HashMap<>();
		map.put("products", products);

		//构造输出流
		Template template = configuration.getTemplate("2018库存表.xml", "UTF-8");
		String fileName = "/data/files/" + DateUtil.now() + ".xlsx";
		File file = new File(fileName);
		FileWriter out = new FileWriter(fileName);
		//变量替换
		template.process(map, out);

		//将文件输出到response,返回给客户端
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[in.available()];
		in.read(buffer);
		in.close();
		response.reset();
		response.addHeader("Content-Disposition", "attachment;filename=file.xlsx");
		ServletOutputStream outputStream = response.getOutputStream();
		response.setContentType("application/octet-stream");
		outputStream.write(buffer);
		outputStream.flush();
		outputStream.close();
	}
}
