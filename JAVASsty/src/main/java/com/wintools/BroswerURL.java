package com.wintools;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

/**
 * ***************************************************************************
 * 功能说明：
 * 作    者： ChenXX
 * 创建日期： 2016/10/26
 * 版 本 号：1.0
 * ***************************************************************************
 */
public class BroswerURL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x == 1)
            try {
                URI uri = new URI("http://www.google.cn.hk");
                Desktop.getDesktop().browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        else {
            String cmd = "cmd /c start iexplore http://www.baidu.com";
            try {
                Runtime.getRuntime().exec(cmd);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
