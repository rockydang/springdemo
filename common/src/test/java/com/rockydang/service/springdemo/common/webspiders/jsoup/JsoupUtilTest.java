package com.rockydang.service.springdemo.common.webspiders.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

/**
 * Created by yanxiao on 16/4/25.
 */
public class JsoupUtilTest {

    @Test
    public void TestParse() {

        try {
            // 直接从字符串中输入 HTML 文档
          /*  String html = "<html><head><title> 开源中国社区 </title></head>"
                    + "<body><p> 这里是 jsoup 项目的相关文章 </p></body></html>";
            Document document = Jsoup.parse(html);
            System.out.println(document.text());*/

            // 从 URL 直接加载 HTML 文档
           /* Document doc = Jsoup.connect("http://www.oschina.net/").get();
            String title = doc.title();
            System.out.println(title);*/

            Connection conn = Jsoup.connect("http://www.mogujie.com/");
            Connection.Response r = conn.execute();
            System.out.println("statusCode= " + r.statusCode());

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
