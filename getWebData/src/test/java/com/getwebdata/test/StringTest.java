package com.getwebdata.test;

public class StringTest {
    public static void main(String[] args) {
        String img = "https://blog.csdn.net/../article/details/47037917";
        String img2 = "../../../icon/109/1.png";
        System.out.println(img);
        System.out.println(img.replaceAll("\\.\\./",""));
        System.out.println(img.replaceAll("/.",""));
        System.out.println(img.contains("../.."));
        System.out.println(img2.contains("../.."));

    }
}
