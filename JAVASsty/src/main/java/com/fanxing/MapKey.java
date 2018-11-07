package com.fanxing;

import java.util.HashMap;
import java.util.Map;

/**
 * ***************************************************************************
 * 功能说明：
 * 作    者： ChenXX
 * 创建日期： 2016/11/10
 * 版 本 号： 1.0
 * ***************************************************************************
 */
public class MapKey {
    public static void main(String[] args) {
        Map map = new HashMap<String,String>();

        map.put("ok",1);
        map.put("ok",2);
        map.put("sk",3);
        System.out.println(map.get("ok"));
        System.out.println(map.get("sk"));
    }
}
