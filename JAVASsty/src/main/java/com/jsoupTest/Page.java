package com.jsoupTest;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * ***************************************************************************
 * 功能说明：
 * 作    者： ChenXX
 * 创建日期： 2016/11/3
 * 版 本 号：1.0
 * ***************************************************************************
 */
public class Page implements Serializable {
    private String plainText;
    private Map anchor = new HashMap<String, String>();

    public Page(String url) {
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public void addAnchor(String href, String link) {
        anchor.put(href, link);
    }

    public Map getAnchors() {
        return anchor;
    }
}
