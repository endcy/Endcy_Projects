package com.StringTest;

/**
 * Created by cxx on 2017/2/7.
 */
public class ChangeableStrBuffer {
    static void test(StringBuffer s, StringBuffer s2, String s3) {
        System.out.println("test1 s:" + s);//1
        System.out.println("test1 s2:" + s2);//2
        System.out.println("test1 s3:" + s3);
        s2 = s;//3        //利用s的引用，接下来s2的修改都是相当于外部s的修改
        s3 = "okno";
        s = new StringBuffer("new");//4
        System.out.println("test2 s:" + s);//5
        System.out.println("test2 s2:" + s2);//6
        System.out.println("test2 s3:" + s3);//6
        s.append("hah");//7
        s2.append("hah");//8
        System.out.println("test3 s:" + s);//5
        System.out.println("test3 s2:" + s2);//6
    }

    public static void setStr(StringBuffer str) {
        str.append("acx");
    }

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("good");
        StringBuffer s2 = new StringBuffer("bad");
        String s3 = "okok";
        test(s, s2, s3);
        System.out.println("end s: " + s);//9
        System.out.println("end s2: " + s2);//10
        System.out.println("end s3: " + s3);
        setStr(s2);
        System.out.println("lastchange s2" + s2);
    }

}
