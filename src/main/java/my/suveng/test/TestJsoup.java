package my.suveng.test;

import java.io.IOException;
import java.net.URLDecoder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

/**
 * @author 苏文广 created at 2018/12/22
 * @Description: 测试类
 */
public class TestJsoup {
    @Test
  public void testJ() throws IOException {
      String decode = URLDecoder
          .decode("https://suveng.github.io/blog/tag/%e6%95%88%e7%8e%87/index.html", "utf-8");
      Document document = Jsoup
          .connect(decode).get();
    }
}
