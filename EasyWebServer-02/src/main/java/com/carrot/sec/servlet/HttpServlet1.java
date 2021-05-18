package com.carrot.sec.servlet;

import com.carrot.sec.entity.Request;
import com.carrot.sec.entity.Response;
import com.carrot.sec.processor.ServletProcessor1;
import com.carrot.sec.processor.StaticResourceProcessor1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServlet1 {

    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    private boolean shutdown = false;

    public void await(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8001,1, InetAddress.getByName("127.0.0.1"));
            while(!shutdown){
                Socket socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();

                Request request = new Request(is);

                Response response = new Response(os,request);

                if(request.getUri().startsWith("/servlet/")){
                    ServletProcessor1 servletProcessor1 = new ServletProcessor1();
                    servletProcessor1.processor(request,response);
                }else{
                    StaticResourceProcessor1 staticResourceProcessor1 = new StaticResourceProcessor1();
                    staticResourceProcessor1.processor(request,response);
                }

                os.close();
                is.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
