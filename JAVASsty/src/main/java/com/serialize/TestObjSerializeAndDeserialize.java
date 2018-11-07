package com.serialize;

import java.io.*;

/**
 * ***************************************************************************
 * 功能说明：
 * 作    者： ChenXX
 * 创建日期： 2016/11/3
 * 版 本 号：1.0
 * ***************************************************************************
 */
public class TestObjSerializeAndDeserialize {
    /*
     * 序列化
     */
    public static void SerializePerson() throws IOException {
        Person person = new Person();
        person.setName("中国人");
        person.setAge(22);
        person.setSex("male");
        new File("E:/test.txt").createNewFile();
        ObjectOutputStream objos = new ObjectOutputStream(new FileOutputStream(new File("E:/test.txt")));
        objos.writeObject(person);
        objos.flush();
        objos.close();
        System.out.println("Serialize OK!");
    }
    /*
     *反序列化
     */
    public static void DeserializePerson() throws IOException, ClassNotFoundException {
        ObjectInputStream objin = new ObjectInputStream(new FileInputStream(new File("E:/test.txt")));
        Person person = (Person) objin.readObject();
        System.out.println(person.getName() + "  " + person.getAge() + "  " + person.getSex());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        SerializePerson();
        DeserializePerson();
    }
}
