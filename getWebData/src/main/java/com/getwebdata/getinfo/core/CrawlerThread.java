package com.getwebdata.getinfo.core;

import com.getwebdata.getinfo.utils.InfoType;

public abstract class CrawlerThread<T> implements Runnable {
    protected String url;
    protected Enum<InfoType> type;
    protected T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public CrawlerThread(String url, Enum<InfoType> type) {
        this.url = url;
        this.type = type;
    }

    public abstract void saveInfo(T info);    //save info
//    public abstract void
}
