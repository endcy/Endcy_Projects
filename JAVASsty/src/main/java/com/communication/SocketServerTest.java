package com.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ***************************************************************************
 * 模块名称：
 * 功能说明：
 * 作    者： Chenxx
 * 创建日期： 2016/10/14
 * 版 本 号：1.0
 */
public class SocketServerTest {
    private int port;

    public SocketServerTest(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        SocketServerTest snetset = new SocketServerTest(8080);
        ServerSocket snet = null;
        Socket rnet = null;
        try {
            snet = new ServerSocket(snetset.port);
        } catch (IOException e) {
            System.out.println("ServerSocket port open error");
        }
        try {
            rnet = snet.accept();
            System.out.println(rnet.getInetAddress() + "is connected");
        } catch (IOException e) {
            System.out.println("ServerSocket listen error");
        }
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(rnet.getInputStream()));
            out = new PrintWriter(rnet.getOutputStream());
        } catch (IOException e) {
            System.out.println("Socket get Writer or Reader error");
        }
        String clientmsg = null;
        String sendmsg = "no";
        try {
            clientmsg = in.readLine();        //"username:endcy" + "&" + "password:123456"
            System.out.println(clientmsg);
            if (clientmsg.indexOf("username") >= 0 && clientmsg.indexOf("password") >= 0) {
                String username = clientmsg.substring(clientmsg.indexOf("username:") + 9, clientmsg.indexOf("password") - 1);
                String password = clientmsg.substring(clientmsg.indexOf("password:") + 9);
                System.out.println(username + "   " + password);
                if ("endcy".equals(username) && "123456".equals(password))
                    sendmsg = "ok";
            }
            out.println(sendmsg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                System.out.println("Close Connection or IO error");
            }
        }
    }
}
