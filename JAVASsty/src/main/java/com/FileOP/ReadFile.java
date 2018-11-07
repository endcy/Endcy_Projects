package com.FileOP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * ***************************************************************************
 * 功能说明：
 * 作    者： ChenXX
 * 创建日期： 2016/10/26
 * 版 本 号：1.0
 * ***************************************************************************
 */
public class ReadFile {
    public static String file = "D:\\ZXJJ\\NCdata\\数据说明.txt";
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader in = new BufferedReader(fr);
            String temp;
            while ((temp=in.readLine())!=null){
                System.out.println(temp);
                if(temp.contains("比如debugmax.log日志中Date: "))
                    System.out.println("*********找到匹配串*********");
            }
            in.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
