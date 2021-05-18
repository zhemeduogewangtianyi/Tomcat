package sec.entity;

import sec.constant.Constants;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Locale;

public class Response implements ServletResponse {

    private OutputStream os;

    private Request request;

    private PrintWriter pw;

    public Response(OutputStream os, Request request) {
        this.os = os;
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        File file = new File(Constants.WEB_INFO,request.getUri());
        if(file.exists()){
            FileInputStream fis = new FileInputStream(file);

            StringBuilder sb = new StringBuilder("HTTP/1.1 200\r\n");
            sb.append("Content-Type: text/html;charset=UTF-8\r\n");
            sb.append("Content-Length: ");


            StringBuilder buff = new StringBuilder();
            byte[] data = new byte[1024];
            int len;
            while ((len = fis.read(data)) != -1){
                buff.append(new String(data , 0 , len));
            }

            String content = buff.toString();
            sb.append(content.length()).append("\r\n\r\n");
            sb.append(content);

            os.write(sb.toString().getBytes());
            fis.close();
        }else{
            String body = "<h1>文件没找着</h1>";
            String res = "HTTP/1.1 404 File Not Found\r\nContent-Type: text/html;charset=UTF-8\r\nContent-Length: "+body.length()+"\r\n\r\n" + body;
            os.write(res.getBytes());
        }
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        pw = new PrintWriter(os,true);
        return pw;
    }

    @Override
    public void setCharacterEncoding(String s) {

    }

    @Override
    public void setContentLength(int i) {

    }

    @Override
    public void setContentType(String s) {

    }

    @Override
    public void setBufferSize(int i) {

    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public void flushBuffer() throws IOException {

    }

    @Override
    public void resetBuffer() {

    }

    @Override
    public boolean isCommitted() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void setLocale(Locale locale) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }
}
