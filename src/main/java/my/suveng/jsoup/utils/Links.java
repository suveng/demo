package my.suveng.jsoup.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author 苏文广 created at 2018/12/22
 * @Description: jsoup 教程 实战 爬取连接
 */
@Data
public class Links {

  /**
   * 我的域名
   */
  private static final String DOMAIN = "https://suveng.github.io";
  /**
   * 目标域名
   */
  private String targetDomain = "https://suveng.github.io";
  /**
   * 保存了的链接
   */
  private Set<String> saved = new HashSet<>();

  /**
   * 中间变量,为jsoup 获取到的href
   */
  String href;
  /**
   * 短链接
   */
  String shortHref;
  /**
   * 最终链接
   */
  String targetHref;
  /**
   * 链接类型
   */
  Integer hrefType;

 public void myblog(Links jsoupMain) throws IOException {
  Document doc = Jsoup.connect(Links.DOMAIN+"/blog").get();
  Elements links = doc.select("a[href]");
  jsoupMain.saveLinksByElements(links);

}
  private void saveLinksByElements(Elements links) throws IOException {
    if (links == null) {
      return;
    }
    for (Element element : links) {
      //处理连接类型
      dealwithHref(element);
      if (!saved.contains(targetHref)) {
        System.out.println("\nlink : " + targetHref);
        System.out.println("text : " + element.text());
        Elements targetLink = getLinks(targetHref);
        if (targetLink == null) {
          return;
        }
        saveLinks();
        saveLinksByElements(targetLink);
      }
    }
  }

  /**
   * 处理连接
   */
  private void dealwithHref(Element element) {

    targetHref=element.attr("abs:href");
    //处理编码
    try {
      this.targetHref = URLDecoder.decode(targetHref, "utf-8");
    } catch (UnsupportedEncodingException e) {
      System.err.println("不支持的编码，建议换成utf-8");
      this.targetHref = null;
      return;
    }
    dealwithDomain();
  }

  /**
   * 判断是否是当前域名，只有当前域名才支持爬取，不支持跨域
   */
  private void dealwithDomain() {
    if (!this.targetHref.contains(this.targetDomain)){
      this.targetHref=null;
    }
  }

  /**
   * 获取链接
   * @param url targetHref
   * @return  document.select("a[href]");
   */
  private Elements getLinks(String url) {
    try {
      Connection connect = Jsoup.connect(url);
      Document document;
      document = connect.get();
      return document.select("a[href]");
    } catch (Exception e) {
      System.err.println("错误链接");
      return null;
    }
  }

  /**
   * 保存链接
   * @throws IOException 读写文件
   */
  private void saveLinks() throws IOException {
    saved.add(this.targetHref);
    File links = new File("links.log");
    FileUtils.writeStringToFile(links, this.targetHref + '\n', "utf-8", true);
  }


}
