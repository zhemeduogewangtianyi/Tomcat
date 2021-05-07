package com.carrot.sec.socket;

import com.carrot.sec.socket.client.SocketClient;
import com.carrot.sec.socket.server.HttpServer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

//        new Thread(() -> {
//            SocketClient socketClient = new SocketClient();
//            try {
//                Thread.sleep(5000);
//                socketClient.request();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();


        HttpServer httpServer = new HttpServer();
        httpServer.awaitRequest();

    }

}
