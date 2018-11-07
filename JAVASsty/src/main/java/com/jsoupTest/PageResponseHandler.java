package com.jsoupTest;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * ***************************************************************************
 * 功能说明：
 * 作    者： ChenXX
 * 创建日期： 2016/11/3
 * 版 本 号：1.0
 * ***************************************************************************
 */
public class PageResponseHandler implements ResponseHandler<Page> {

    private Page page;

    public PageResponseHandler(Page page) {
        this.page = page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return page;
    }

    @Override
    public Page handleResponse(HttpResponse response) throws IOException {

        StatusLine statusLine = response.getStatusLine();
        HttpEntity entity = response.getEntity();

        if (statusLine.getStatusCode() >= 300) {
            EntityUtils.consume(entity);
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }

        if (entity == null)
            return null;

        // 利用HTTPClient自带的EntityUtils把当前HttpResponse中的HttpEntity转化成HTML代码
        //String html = EntityUtils.toString(entity, Charset.forName("gbk")); //转为自定义的编码
        String html = EntityUtils.toString(entity);
        Document document = Jsoup.parse(html);
        Elements links = document.getElementsByTag("a");

        for (int i = 0; i < links.size(); i++) {
            Element link = links.get(i);
            page.addAnchor(link.attr("href"), link.text());
//            System.out.println(link.attr("href")+"  ----  "+ link.text());
        }

        // parse context of plain text from HTML code,
        Elements paragraphs = document.getElementsByTag("p");
        StringBuffer plainText = new StringBuffer(html.length() / 2);
        for (int i = 0; i < paragraphs.size(); i++) {
            Element paragraph = paragraphs.get(i);
            plainText.append(paragraph.text()).append("\n");
        }
        page.setPlainText(plainText.toString());

        return page;
    }

}