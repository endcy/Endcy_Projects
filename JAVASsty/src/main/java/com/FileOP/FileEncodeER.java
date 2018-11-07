package com.FileOP;

import java.io.*;

/**
 * ***************************************************************************
 * 功能说明：
 * 作    者： ChenXX
 * 创建日期： 2016/10/26
 * 版 本 号：1.0
 * ***************************************************************************
 */
public class FileEncodeER {
    public static String file = "D:\\ZXJJ\\NCdata\\数据说明.txtx";

    public static void main(String[] args) {
        try {
//            System.out.println(new FileReader(file).getEncoding());       //获取文件的格式编码
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GB2312"));
            String temp;
            while ((temp=in.readLine())!=null){
                System.out.println(temp);
            }
            in.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new File(file+"x").createNewFile();
            PrintWriter pwx =new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file+"x"),"utf8")));
            pwx.println("·······日志打开后，每笔交易触发后会在NC安装目录下……");
            pwx.flush();
            pwx.close();
            System.out.println("临时文件写完成。");
//            new File(file+"x").delete();      //删除临时文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
