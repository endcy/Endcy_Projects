package com.getwebdata.test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.List;
import java.util.logging.Level;

public class HtmlUtilTest {

    @Test
    public void getTitles() {

        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        java.util.logging.Logger.getLogger("org.apache.http.client.HttpClient").setLevel(Level.OFF);
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);

        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage page = null;
        int initPage = 1;
        int articleNum = 0;
        do {
            System.out.println("获取文章列表页数：" + initPage);
            try {
                page = webClient.getPage("https://blog.csdn.net/u010760374/article/list/" + initPage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            webClient.waitForBackgroundJavaScript(3000);//javascript执行x秒
            String pageXml = page.asXml();
            Document document = Jsoup.parse(pageXml);
            List<Element> infoListEle = null;
            try {
                Elements list = document.getElementsByAttributeValue("class", "article-list");
                infoListEle = list != null && list.size() > 0 ? list.get(0).getElementsByAttributeValue("class", "article-item-box csdn-tracking-statistics") : null;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            if (infoListEle != null) {
                for (Element element : infoListEle) {
                    String href = element.getElementsByTag("h4").first().getElementsByTag("a").attr("href");
                    if (!href.contains("u010760374")) continue;
                    System.out.println(element.getElementsByTag("h4").first().getElementsByTag("a").text());
                    System.out.println(href);
                    articleNum++;
                }
                initPage++;
            }else {
                System.out.println("获取列表结束,共存在页数：" + --initPage + ";文章总计篇数：" + articleNum);
                initPage = 0;
            }
        } while (initPage != 0);
        webClient.close();
    }
}
