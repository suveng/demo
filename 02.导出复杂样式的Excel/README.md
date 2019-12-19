# freemarker导出复杂样式的Excel

## 代码地址:

[gitee](https://gitee.com/suveng/demo/tree/master/chapter.002)

https://gitee.com/suveng/demo/tree/master/chapter.002

代码存放于demo下面的chapter.002目录下, 每个模块都是独立开的springboot应用,可以直接运行 application

## 环境

- springboot 2.1.2
- Freemarker 2.3.28
- JDK1.8

## 步骤

### 1.找到对应Excel模板

我在网上找了一网站下载了一个Excel模板, [地址](https://www.6erp.cn/portfoliotype/exceltemplatedown)

下载的文件是[2018库存表](https://www.6erp.cn/download/2018%e5%ba%93%e5%ad%98%e8%a1%a8?wpdmdl=3444&refresh=5d6278fa5c9881566734586)

![](https://img2018.cnblogs.com/blog/1419387/201908/1419387-20190825200551854-396336777.png)


### 2.Excel模板导出为xml格式

将其导出为xml格式;直接文件另存为即可

![](https://img2018.cnblogs.com/blog/1419387/201908/1419387-20190825200730668-1182199891.png)

删除多余的数据, 将模板变量填进去, 这个变量是需要符合 freemarker 的变量规则的;

![](https://img2018.cnblogs.com/blog/1419387/201908/1419387-20190825201249119-1659346729.png)

具体内容可参考[文件](https://gitee.com/suveng/demo/blob/master/chapter.002/src/main/resources/templates/2018%E5%BA%93%E5%AD%98%E8%A1%A8.xml)



### 3.替换freemarker变量


关键修改: 

```
            <#list products as product>
                <Row>
                    <Cell>
                        <Data ss:Type="String">${product.name!}</Data>
                    </Cell>
                    <Cell>
                        <Data ss:Type="String">${product.number!}</Data>
                    </Cell>
                    <Cell>
                        <Data ss:Type="String">${product.type!}</Data>
                    </Cell>
                    <Cell>
                        <Data ss:Type="String">${product.unit!}</Data>
                    </Cell>
                    <Cell>
                        <Data ss:Type="String">${product.left!}</Data>
                    </Cell>
                    <Cell>
                        <Data ss:Type="String">${product.monthNumber!}</Data>
                    </Cell>
                    <Cell>
                        <Data ss:Type="String">${product.in!}</Data>
                    </Cell>
                    <Cell>
                        <Data ss:Type="String">${product.out!}</Data>
                    </Cell>
                    <Cell ss:StyleID="s54">
                        <Data ss:Type="String">${product.date?string('yyyy/MM/dd')}</Data>
                    </Cell>
                </Row>
            </#list>
```

自己可以拿到文件,对比一下.

具体 freemarker 语法, 可参考 [链接](http://www.kerneler.com/freemarker2.3.23/dgui_quickstart_basics.html) 

### 4.编写代码,变量替换

这里我使用我自己的脚手架,其实也是一个快速启动的服务端程序,使用的是springboot构建的.有兴趣可以过去看看[链接](https://gitee.com/suveng/demo/tree/master/chapter.001)

这里编写web接口: 导出模板Excel

这里的数据是自己模拟的,随机生成的无意义数据,使用了hutool工具包的randomUtil

> AppController.java

```
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
```



### 5. 结果展示

![](https://img2018.cnblogs.com/blog/1419387/201908/1419387-20190825202308403-1422124016.png)


## 存在问题

1. 变量替换,耗费CPU和内存并未经过测试,与POI这些组件相比到底哪个更好,这里存在疑问?

这里只是用作复杂样式的Excel数据导出,并不适合用作大量数据导出.hutool工具包中和easyExcel都是针对大量数据的Excel导出做了相应的优化,有需要可以查看对应文档

- [hutool](https://hutool.cn/docs/#/poi/Excel%E5%A4%A7%E6%95%B0%E6%8D%AE%E7%94%9F%E6%88%90-BigExcelWriter)

- [easyExcel](https://github.com/alibaba/easyexcel/blob/master/quickstart.md)
