package com.NIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * ***************************************************************************
 * Description  :
 * Author       : cxx
 * Creation date: 2018/3/29.
 * Version      : 1.0
 * ***************************************************************************
 */
public class EchoClient {
    public static String SERVER_IP = "localhost";
    public static int SERVER_PORT = 8085;

    public static void main(String[] args) throws IOException {
        Socket client = new Socket(SERVER_IP, SERVER_PORT);
        PrintWriter pw = new PrintWriter(client.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入消息内容，enter换行继续发送：");
        boolean flag = true;
        while (flag) {
            String msg = sc.nextLine();
            pw.print(msg);
            pw.flush();
            String rec = br.readLine();
            if (rec != null)
                System.out.println("收到服务端消息：" + rec);
            if ("####".equals(rec)) {
                sc.close();
                client.close();
                flag = false;
            }
        }

    }
}
