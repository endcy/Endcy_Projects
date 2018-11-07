package com;

import org.apache.commons.codec.binary.Base64;

import java.util.HashMap;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/6/15.
 * Version      : 1.0
 * ***************************************************************************
 */
public class Test {

    public static void main(String[] args) {
//        Integer var1 = new Integer(1);
//        Integer var2 = var1;
//        doSomething(var2);
//        System.out.print(var1.intValue());
//        System.out.print(var1 == var2);
//        System.out.println(var2);
        A a = new A();
        a.setX(1);
        A b = a;
        doSomething(b);
//        b.setX(3);
        System.out.println(a.getX());
        System.out.println(b.getX());
        System.out.println(a==b);
        int x=5,j=10;
        System.out.println(x+~j);
        String str1 = "abc";
        System.out.println(str1.hashCode());
        System.out.println("ABCDEa123abc".hashCode());  // 165374702
        System.out.println("ABCDFB123abc".hashCode()); //  165374702
        HashMap map = new HashMap();
        map.put("ABCDEa123abc",1);
        map.put("ABCDFB123abc",2);
        System.out.println("ABCDEa123abc"=="ABCDFB123abc");
        System.out.println("ABCDEa123abc".equals("ABCDFB123abc"));
        System.out.println(map.get("ABCDEa123abc"));
        System.out.println(map.get("ABCDFB123abc"));
        String temp = "23dsaf8738r0%%872-78dhsa";
        String deco = Base64.encodeBase64String(temp.getBytes());
        System.out.println(deco);
        System.out.println("---------");
        System.out.println(new String(Base64.decodeBase64(deco)));
    }

    public static void doSomething(Integer integer) {
        integer = new Integer(2);
    }


//    public static void doSomething(A a) {
//        a.setX(2);
//    }

    public static void doSomething(A a) {
        a.setX(4);
        a = new A();
        a.setX(2);
//        return a;
    }
}

class A {
    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}