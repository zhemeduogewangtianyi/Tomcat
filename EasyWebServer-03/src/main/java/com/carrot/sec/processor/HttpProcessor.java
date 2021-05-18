package com.carrot.sec.processor;

import com.carrot.sec.entity.HttpRequest;
import org.apache.catalina.connector.http.SocketInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpProcessor {

    public void process(Socket socket) {

        SocketInputStream sis = null;
        OutputStream os = null;
        try {
            sis = new SocketInputStream(socket.getInputStream(), 2048);
            os = socket.getOutputStream();

//            new HttpRequest();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
