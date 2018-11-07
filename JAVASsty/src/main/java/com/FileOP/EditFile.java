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
public class EditFile {
    public static String file = "D:\\ZXJJ\\NCdata\\数据说明.txt";

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader in = new BufferedReader(fr);
            FileWriter fw = new FileWriter(file + "x");
            PrintWriter pw = new PrintWriter(fw);
            String temp;
            while ((temp = in.readLine()) != null) {
                if (temp.contains("注意：")) {
                    temp = temp + "******";
                    System.out.println("*********找到匹配串*********");
                }
                pw.println(temp);
                pw.flush();
            }
            pw.close();
            fw.close();
            in.close();
            fr.close();
            System.out.println("临时文件写操作完成。");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader frx = new FileReader(file + "x");
            BufferedReader inx = new BufferedReader(frx);
            FileWriter fwx = new FileWriter(file);
            PrintWriter pwx = new PrintWriter(fwx);
            String tempx;
            while ((tempx = inx.readLine()) != null) {
                pwx.println(tempx);
                pwx.flush();
            }
            pwx.close();
            fwx.close();
            inx.close();
            frx.close();
            new File(file+"x").delete();
            System.out.println("写文件完成，删除临时文件。");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
