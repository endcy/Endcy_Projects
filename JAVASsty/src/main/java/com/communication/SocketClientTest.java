package com.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ***************************************************************************
 * 模块名称：
 * 功能说明：
 * 作    者： Chenxx
 * 创建日期： 2016/10/14
 * 版 本 号：1.0
 */
public class SocketClientTest {
    public static void main(String[] args) {
        SocketInfoSet netset = new SocketInfoSet("127.0.0.1", 8080);
        Socket net = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            net = new Socket(netset.getIp(), netset.getPort());
            out = new PrintWriter(net.getOutputStream(), true);
        } catch (UnknownHostException e) {
            System.out.println("Server ip error");
        } catch (IOException e) {
            System.out.println("Server port error");
        }
        //发送一行信息
        out.println("username:endcy" + "&" + "password:123456");
        out.flush();
        String recmsg = "";
        try {
                in = new BufferedReader(new InputStreamReader(net.getInputStream()));
                recmsg = in.readLine();
        } catch (IOException e) {
            System.out.println("Server get Msg error");
        } finally {
            try {
                out.close();
                in.close();
                net.close();
            } catch (IOException e) {
                System.out.println("Close Connection or IO error");
            }
        }
        if ("ok".equals(recmsg)) {
            System.out.println("Talk socket is OK");
        } else
            System.out.println(recmsg);
    }

}

class SocketInfoSet {
    private String ip;
    private int port;

    public SocketInfoSet(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }
}
