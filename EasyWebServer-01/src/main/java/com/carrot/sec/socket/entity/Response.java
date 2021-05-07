package com.carrot.sec.socket.entity;

import com.carrot.sec.socket.server.HttpServer;

import java.io.*;

public class Response {

    private OutputStream os;

    private Request request;

    public Response(Request request,OutputStream os) {
        this.os = os;
        this.request = request;
        try {
            sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendStaticResource() throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(os);
        String uri = request.getUri();
        String resourcePath = HttpServer.WEB_ROOT + File.separator + uri;
        File file = new File(resourcePath);
        if(file.exists()){
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream readFile = new BufferedInputStream(fis);
            byte[] data = new byte[2048];
            int len;
            String http = "HTTP/1.1 200\r\n" +
                    "Content-Type: text/html;charset=UTF-8\r\n" +
                    "Content-Length: ";
            StringBuilder buff = new StringBuilder();
            while((len = readFile.read(data)) != -1){
                buff.append(new String(data , 0 , len));
            }
            http += buff.toString().length() + "\r\n\r\n";
            http += buff.toString();
            os.write(http.getBytes());
            fis.close();
        }else{
            String body = "<h1>文件没找着</h1>";
            String res = "HTTP/1.1 404 File Not Found\r\nContent-Type: text/html;charset=UTF-8\r\nContent-Length: "+body.length()+"\r\n\r\n" + body;
            bos.write(res.getBytes());
        }
        bos.close();
    }
}
