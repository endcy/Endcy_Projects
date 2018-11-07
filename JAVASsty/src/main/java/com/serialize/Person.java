package com.serialize;

import java.io.Serializable;

/**
 * ***************************************************************************
 * 功能说明：Description:测试对象序列化和反序列化
 * 作    者： ChenXX
 * 创建日期： 2016/11/1
 * 版 本 号：1.0
 * ***************************************************************************
 */

public class Person implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -5809782578272943999L;
    private int age;
    private String name;
    private String sex;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}