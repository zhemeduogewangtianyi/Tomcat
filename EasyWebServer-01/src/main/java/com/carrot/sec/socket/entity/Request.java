package com.carrot.sec.socket.entity;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Request {

    private InputStream is;

    private String uri;

    public Request(InputStream is) {
        this.is = is;
        try {
            this.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取数据
    private void parse() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(is);
        StringBuilder sb = new StringBuilder();
        int len;
        byte[] data = new byte[2048];
//        while((len = bis.read(data)) != -1){
//            sb.append(new String(data , 0 , len));
//        }

        int read = bis.read(data);

        for(int j = 0 ; j < read ; j++){
            sb.append((char) data[j]);
        }


        String requestString = sb.toString();
        this.uri = this.parseUri(requestString);
    }

    //从解析的请求数据中获取 uri
    private String parseUri(String requestString){
        //GET /index.html HTTP/1.1
        //Host: 127.0.0.1:8001
        //Connection: Close

        int first = requestString.indexOf(" ");
        if(first != -1){
            String last = requestString.substring(first + 1);
            int tail = last.indexOf(" ");
            if(tail != -1){
                return last.substring(0, tail);
            }
        }
        return null;
    }

    //返回 url
    public String getUri(){
        return uri;
    }

}
