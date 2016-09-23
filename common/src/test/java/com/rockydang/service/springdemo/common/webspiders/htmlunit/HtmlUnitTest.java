package com.rockydang.service.springdemo.common.webspiders.htmlunit;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yanxiao on 16/4/19.
 */
public class HtmlUnitTest {

    @Test
    public void homePage() throws Exception {
        final WebClient webClient = new WebClient();
        try {
            final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
            System.out.println(page.getTitleText());
//            Assert.assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());

            System.out.println("aaa==>" + ("HtmlUnit – Welcome to HtmlUnit".equals(page.getTitleText())));


            final String pageAsXml = page.asXml();
            Assert.assertTrue(pageAsXml.contains("<body class=\"composite\">"));

            final String pageAsText = page.asText();
            Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
        } catch (Exception e) {
            System.out.println("aa==" + e);
        }
    }

    @Test
    public void getElements() throws Exception {
        final WebClient webClient = new WebClient();
        try {
            final HtmlPage page = webClient.getPage("http://some_url");
            final HtmlDivision div = page.getHtmlElementById("some_div_id");
            final HtmlAnchor anchor = page.getAnchorByName("anchor_name");
        } catch (Exception e) {

        }
    }

    @Test
    public void testPage() {
        final WebClient webClient = new WebClient();
        try {
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
//            final HtmlPage page = webClient.getPage("http://www.yanyulin.info");
            final HtmlPage page = webClient.getPage("http://ark.mogujie.com/jsonp/xinshui.articlelist/1");

            //1.获取返回状态、加载时间
            WebResponse webResponse = page.getWebResponse();
            int status = webResponse.getStatusCode();
            System.out.println("status==" + status);
            System.out.println("------------------------------");

            long loadTime = webResponse.getLoadTime();
            System.out.println("loadTime==" + loadTime);
            System.out.println("------------------------------");

            //2.页面详情
            System.out.println("page==" + page.asText());
            System.out.println("------------------------------");

            /*
             //3.获取div节点下的元素
              final HtmlDivision div = (HtmlDivision) page.getByXPath("//div").get(0);
                System.out.println(div.asXml());
                System.out.println("------------------------------");
             */

            //4.获取超链接
           /* List<HtmlAnchor> achList = page.getAnchors();
            for (HtmlAnchor ach : achList) {
                System.out.println(ach.getHrefAttribute());
            }*/

            webClient.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}