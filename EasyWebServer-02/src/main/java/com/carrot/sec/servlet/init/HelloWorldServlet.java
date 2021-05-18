package com.carrot.sec.servlet.init;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter writer = servletResponse.getWriter();
        StringBuilder sb = new StringBuilder("HTTP/1.1 200\r\n");
        sb.append("Content-Type: text/html;charset=UTF-8\r\n");
        sb.append("Content-Length: ");
        String content = "<h1>Hello World !</h1>";
        sb.append(content.length()).append("\r\n\r\n").append(content);
        writer.println(sb.toString());
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
