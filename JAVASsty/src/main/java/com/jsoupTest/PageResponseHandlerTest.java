package com.jsoupTest;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ***************************************************************************
 * 功能说明：
 * 作    者： ChenXX
 * 创建日期： 2016/11/3
 * 版 本 号：1.0
 * ***************************************************************************
 */
public class PageResponseHandlerTest {

    HttpClient httpclient;

    PageResponseHandler pageResponseHandler;

    final String url = "http://news.163.com/13/0903/11/97RHS2NS0001121M.html";

    Page page = new Page(url);

    @Before
    public void setUp() throws Exception {
        httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        pageResponseHandler = new PageResponseHandler(page);
        httpclient.execute(httpget, pageResponseHandler);
    }

    @After
    public void tearDown() throws Exception {
        httpclient.getConnectionManager().shutdown();
    }

    @Test
    public void test() {
        System.out.println(page.getPlainText());
        System.out.println(page.getAnchors().size());;
    }
}