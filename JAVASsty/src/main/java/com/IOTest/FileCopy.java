package com.IOTest;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/4/18.
 * Version      : 1.0
 * ***************************************************************************
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        String inPath = "C:\\Users\\Administrator\\Desktop\\2017国家党建纪实.txt";
        String outPath = "E:\\搜狗高速下载\\iotest.txt";
//        fileCopy1(inPath,outPath);
        fileCopyNIO(inPath,outPath);
    }

    public static void fileCopy1(String inPath, String outPath) throws IOException {
        //该语法为jdk1.7的TWR语法
        try (InputStream in = new FileInputStream(inPath)) {
            try (OutputStream out = new FileOutputStream(outPath)) {
                byte[] buffer = new byte[4096];
                int bytesToRead;
                while ((bytesToRead = in.read(buffer)) != -1)
                    out.write(buffer, 0, bytesToRead);
            }
        }
        System.out.println("way1 finished!");
    }

    //NIO实现
    public static void fileCopyNIO(String inPath, String outPath) throws IOException {
        try (FileInputStream in = new FileInputStream(inPath)) {
            try (FileOutputStream out = new FileOutputStream(outPath)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while (inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
        System.out.println("way2 finished!");
    }

}
