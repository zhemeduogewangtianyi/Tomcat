package com.carrot.sec.socket.client;

import java.io.*;
import java.net.Socket;

public class SocketClient {

    public void request() throws IOException, InterruptedException {
        //创建一个 Socket
        Socket socket = new Socket("127.0.0.1",8001);

        //获得输入输出流
        PrintWriter pw = new PrintWriter(socket.getOutputStream() , true);

        //根据请求协议发送协议内容
        pw.println("GET /index.html HTTP/1.1");
        pw.println("Host: 127.0.0.1:8001");
        pw.println("Connection: Close");
        pw.println();

        socket.shutdownOutput();

        //读取返回的内容
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        StringBuilder buff = new StringBuilder();
        int len;
        byte[] data = new byte[1024];
        while ((len = bis.read(data)) != -1){
            buff.append(new String(data , 0 , len));
            Thread.sleep(50);
        }

        //撸数据
        System.out.println(buff.toString());

        bis.close();
        socket.close();

    }

}
