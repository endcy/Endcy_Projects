package com.communication;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************************************************
 * 功能说明：
 * 作    者： ChenXX
 * 创建日期： 2016/10/27
 * 版 本 号：1.0
 * ***************************************************************************
 */
public class ProxyVisit {

    //代理无效*****************************************
    public void postForm() {
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        // 依次是目标请求地址，端口号,协议类型
        HttpHost target = new HttpHost("http://tieba.baidu.com/f/search/res", 80,
                "http");
        // 依次是代理地址，代理端口号，协议类型
        HttpHost proxy = new HttpHost("192.168.77.175", 808, "http");
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

        // 请求地址
        HttpPost httpPost = new HttpPost("http://tieba.baidu.com/f/search/res");
        httpPost.setConfig(config);
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        // 参数名为pid，值是2
        formparams.add(new BasicNameValuePair("qw", "abcdefg"));

        UrlEncodedFormEntity entity;
        try {
            entity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httpPost.setEntity(entity);
            CloseableHttpResponse response = closeableHttpClient.execute(
                    target, httpPost);
            // getEntity()
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                // 打印响应内容
                System.out.println("response:"
                        + EntityUtils.toString(httpEntity, "UTF-8"));
            }
            // 释放资源
            closeableHttpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void proxyvist2() {
        //设置代理
        System.setProperty("http.proxySet", "true");
        System.setProperty("http.proxyHost", "10.1.2.188");
        System.setProperty("http.proxyPort", "80");
        //直接访问目的地址
        URL url = null;
        URLConnection con = null;
        InputStreamReader isr = null;
        try {
            url = new URL("http://www.baidu.com");
            con=url.openConnection();
            isr = new InputStreamReader(con.getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        char[] cs = new char[1024];
        int i = 0;
        try {
            while ((i = isr.read(cs)) > 0) {
                System.out.println(new String(cs, 0, i));
            }
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ProxyVisit py = new ProxyVisit();
//        py.postForm();
        py.proxyvist2();
    }


}

