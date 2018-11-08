package com.getwebdata.getinfo.vo;

import java.util.concurrent.ArrayBlockingQueue;

public class TaskVO {
    private ArrayBlockingQueue<String> urls;
    private String initUrl;     //初始页面位置
    private String lastUrl; //初始URL页码在RUL中倒数的位置

    public String getLastUrl() {
        return lastUrl;
    }

    public String getInitUrl() {
        return initUrl;
    }

    public void setInitUrl(String initUrl,String lastUrl) {
        this.initUrl = initUrl;
        this.lastUrl = lastUrl;
    }

    public ArrayBlockingQueue<String> getUrls() {
        return urls;
    }

    public void setUrls(ArrayBlockingQueue<String> urls) {
        this.urls = urls;
    }
}
