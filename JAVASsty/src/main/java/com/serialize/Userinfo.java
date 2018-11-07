package com.serialize;

/**
 * ***************************************************************************
 * 功能说明：
 * 作    者： ChenXX
 * 创建日期： 2016/11/4
 * 版 本 号：1.0
 * ***************************************************************************
 */

public class Userinfo {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;


    public Userinfo() {
        super();
    }

    public Userinfo(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
