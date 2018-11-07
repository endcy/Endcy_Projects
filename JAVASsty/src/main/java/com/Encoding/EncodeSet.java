package com.Encoding;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2016/10/12.
 */
public class EncodeSet {

    public static void main(String[] args) {
        String str = "GBK:张三 这里是中文设置 123456 ok! ";
        try {
            String encStr1 = URLEncoder.encode(str, "UTF-8");
            String changeStr1 = URLDecoder.decode(encStr1, "UTF-8");    //统一编码转码和回转可改变
            String encStr2 = URLEncoder.encode(str, "GB2312");
            String changeStr2 = URLDecoder.decode(encStr2, "GB2312");
            String encStr3 = URLEncoder.encode(str, "GBK");
            String changeStr3 = URLDecoder.decode(encStr3, "UTF-8");
            String encStr4 = URLEncoder.encode(str, "ISO-8859-1");
            String changeStr4 = URLDecoder.decode(encStr4, "UTF-8");
            String encStr5 = URLEncoder.encode(str, "UTF-8");
            String changeStr5 = URLDecoder.decode(encStr5, "GBK");
            System.out.println(str + "     " + str.getBytes());
            System.out.println("utf-8转码后解码为utf-8   " + encStr1 + "     " + changeStr1);
            System.out.println("GB2312转码后解码为GB2312   " + encStr2 + "     " + changeStr2);
            System.out.println("GBK转码后解码为utf-8   " + encStr3 + "     " + changeStr3);
            System.out.println("ISO-8859-1转码后解码为utf-8   " + encStr4 + "     " + changeStr4);
            System.out.println("utf-8转码后解码为GBK   " + encStr5 + "     " + changeStr5);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
