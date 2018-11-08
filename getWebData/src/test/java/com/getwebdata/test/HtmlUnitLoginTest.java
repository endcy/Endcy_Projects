package com.getwebdata.test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.getwebdata.htmlunit.HttpUnitUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HtmlUnitLoginTest {
    private static String url = "https://www.douban.com/login";

    @Test
    public void loginTest() throws Exception {
        WebClient webClient = HttpUnitUtils.getInstance().getWebClient();
        HtmlPage page = webClient.getPage(url);
        HtmlForm form = (HtmlForm) page.getElementById("lzform");
        HtmlTextInput username = (HtmlTextInput) form.getInputByName("form_email");
        HtmlPasswordInput password = (HtmlPasswordInput) form.getInputByName("form_password");
        username.click();
        username.setValueAttribute("endcy@qq.com");
        password.click();
        password.setValueAttribute("qq852817726");
//        HtmlSubmitInput button = (HtmlSubmitInput) page.getByXPath("//input[contains(@class,'pass-button pass-button-submit')]").get(0);
        HtmlSubmitInput button = (HtmlSubmitInput) form.getInputByValue("登录");
        HtmlPage retPage = button.click();
        webClient.waitForBackgroundJavaScript(1000 * 5);
        System.out.println(retPage.getUrl().toString());
        System.out.println(retPage.asXml());
        Set<Cookie> cookies = webClient.getCookieManager().getCookies();
        Map<String, String> responseCookies = new HashMap<>();
        for (Cookie c : cookies) {
            responseCookies.put(c.getName(), c.getValue());
            System.out.println(c.getName() + ":" + c.getValue());
        }
        webClient.close();
        System.out.println("End!");
    }
}
