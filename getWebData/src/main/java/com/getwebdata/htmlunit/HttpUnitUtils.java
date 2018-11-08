package com.getwebdata.htmlunit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 获取执行异步js之后的界面内容
 */
public class HttpUnitUtils {
    private int timeout = 20000;
    private int waitForJSTime = 20000;
    private static HttpUnitUtils httpUnitUtils;

    private HttpUnitUtils() {
    }

    public static HttpUnitUtils getInstance() {
        if (httpUnitUtils == null)
            httpUnitUtils = new HttpUnitUtils();
        return httpUnitUtils;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getWaitForJSTime() {
        return waitForJSTime;
    }

    public void setWaitForJSTime(int waitForJSTime) {
        this.waitForJSTime = waitForJSTime;
    }

    public static Document parseHtmlToDoc(String html) throws Exception {
        return removeHtmlSpace(html);
    }

    public static Document removeHtmlSpace(String str) {
        Document doc = Jsoup.parse(str);
        String result = doc.html().replace("%nbsp;", "");
        return Jsoup.parse(result);
    }

    public WebClient getWebClient() {
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.setCssErrorHandler(new SilentCssErrorHandler());
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setTimeout(timeout);
        webClient.setJavaScriptTimeout(timeout);
        webClient.getCookieManager().setCookiesEnabled(true);
        return webClient;
    }

    public HtmlPage getHtmlPage(String url) throws Exception {
        WebClient webClient = getWebClient();
        HtmlPage page;
        try {
            page = webClient.getPage(url);
        } catch (Exception e) {
            webClient.close();
            throw e;
        }
        webClient.waitForBackgroundJavaScript(waitForJSTime);
        webClient.close();
        return page;
    }

    public String getHtmlPageResponse(String url) throws Exception {
        String result = "";
        HtmlPage page = getHtmlPage(url);
        result = page != null ? page.asXml() : result;
        return result;

    }

    public Document getHtmlPageResponseAsDocument(String url) throws Exception {
        return parseHtmlToDoc(getHtmlPageResponse(url));
    }
}
