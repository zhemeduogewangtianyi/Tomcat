package com.carrot.sec.socket.server;

import com.carrot.sec.socket.entity.Request;
import com.carrot.sec.socket.entity.Response;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    //资源目录，放 html 啥的
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "WEB-INFO";

    //关闭指令
    public static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    //等待请求的到来
    public void awaitRequest() throws IOException {

        //创建一个服务端 Socket 第二个参数是 请求的传入连接队列的最大长度
        ServerSocket ss = new ServerSocket(8001,1,InetAddress.getByName("127.0.0.1"));

        while(true){
            //阻塞等到请求的到来
            Socket accept = ss.accept();

            InputStream is = accept.getInputStream();
            OutputStream os = accept.getOutputStream();

            Request request = new Request(is);

            Response response = new Response(request, os);

            os.close();
            is.close();
        }

    }

}
