package com.carrot.sec;

import com.carrot.sec.servlet.HttpServlet1;

public class Main {

    public static void main(String[] args) {
        HttpServlet1 servlet = new HttpServlet1();
        servlet.await();
    }

}
