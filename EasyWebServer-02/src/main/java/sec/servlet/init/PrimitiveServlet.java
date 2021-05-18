package sec.servlet.init;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 1：等待 HTTP 请求
 * 2：创建一个 ServletRequest 对象 和 ServletResponse 对象
 * 3：若请求的是一个静态资源，则调用 StaticResourceProcessor 对象的 process() 方法，传入
 * ServletRequest 对象和 ServletResponse 对象
 * 4：若请求的是 Servlet ，则载入响应的 Servlet 类，调用其 service() 方法，传入 ServletRequest 对象和 ServletResponse 对象
 *
 * 在 servlet 容器中，每次请求 servlet 都会载入响应的 servlet 类
 *
 * 涉及到的类：
 *  HttpServlet1
 *  Request
 *  Response
 *  StaticResourceProcessor
 *  ServletProcessor1
 *  Constants
 * */
public class PrimitiveServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
        PrintWriter writer = servletResponse.getWriter();
        StringBuilder sb = new StringBuilder("HTTP/1.1 200\r\n");
        sb.append("Content-Type: text/html;charset=UTF-8\r\n");
        sb.append("Content-Length: ");
        String content = "<h1>service</h1>";
        sb.append(content.length()).append("\r\n\r\n").append(content);
        writer.println(sb.toString());
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
