package my.suveng.jsoup;

import java.io.IOException;
import my.suveng.jsoup.utils.Links;
import my.suveng.jsoup.utils.SiteMapXML;

/**
 * @author 苏文广 created at 2018/12/22
 * @Description:
 */
public class Main {
  public static void main(String[] args) throws IOException {
    Links links = new Links();
    //获取链接，并保存到links.log
    links.myblog(links);
    SiteMapXML siteMapXML = new SiteMapXML();
//    siteMapXML.createSiteMap("links.log");
    //生成后删除
//    FileUtils.deleteQuietly(new File("links.log"));
  }
}
