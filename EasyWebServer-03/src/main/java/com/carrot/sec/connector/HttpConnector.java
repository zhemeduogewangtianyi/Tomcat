package com.carrot.sec.connector;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpConnector implements Runnable {

    boolean stopped;

    private String scheme = "http";

    public String getScheme() {
        return scheme;
    }

    /**
     * 1：等待 HTTP 请求
     * 2：为每个 请求创建一个 HttpProcessor 对象
     * 3：调用 HttpProcessor 的 processor() 方法
     * */
    @Override
    public void run() {
        ServerSocket serverSocket = null;
        int port = 8001;
        try {
            serverSocket = new ServerSocket(port,1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(!stopped){
            try {
                Socket socket = serverSocket.accept();
                //TODO HttpProcessor

            } catch (IOException e) {
                continue;
            }
        }

    }

    public void start(){
        Thread t = new Thread(this);
        t.start();
    }

}
