package my.suveng.jsoup.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/**
 * @author 苏文广 created at 2018/12/22
 * @Description: sitemap 生成工具类
 */
public class SiteMapXML {


  @Test
  public void test() throws IOException {
    this.createSiteMap("links.log");
    FileUtils.deleteQuietly(new File("links.log"));
  }

  private void createSiteMap(String linksPath) throws IOException {
    Document document = DocumentHelper.createDocument();
    Element locs = document.addElement("urlset").addAttribute("xmlns",
        "http://www.sitemaps.org/schemas/sitemap/0.9");
    List<String> strings = FileUtils.readLines(new File(linksPath), Charset.forName("utf-8"));
    for (String url : strings) {
      Element loc = locs.addElement("url");
      loc.addElement("loc").setText(url);
      loc.addElement("lastmod")
          .setText(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
    writeAndFlush(document);
  }

  private void writeAndFlush(Document document) {
    try {
      OutputFormat format = OutputFormat.createPrettyPrint();
      format.setEncoding(document.getXMLEncoding());
      Writer fileWriter = new FileWriter("sitemap.xml");
      XMLWriter xmlWriter = new XMLWriter(fileWriter, format);
      xmlWriter.write(document);
      xmlWriter.close();
    } catch (IOException e) {
      System.err.println("导出xml失败，检查 writeandflush()");
    }
  }

  /**
   * 对xml格式化并写入文件
   */
  protected void writeFile4Pretty(File file, Document document) throws IOException {

    OutputFormat format = OutputFormat.createPrettyPrint();
    format.setEncoding(document.getXMLEncoding());
    XMLWriter writer = new XMLWriter(new FileWriter(file), format);
    writer.write(document);
    writer.flush();
    writer.close();
  }

  /***
   * 格式化xml为string
   */
  protected String prettysString(Document document) throws IOException {
    OutputFormat format = OutputFormat.createPrettyPrint();
    format.setEncoding(document.getXMLEncoding());
    StringWriter stringWriter = new StringWriter();
    XMLWriter writer = new XMLWriter(stringWriter, format);
    writer.write(document);
    writer.close();
    return stringWriter.toString();
  }


}
