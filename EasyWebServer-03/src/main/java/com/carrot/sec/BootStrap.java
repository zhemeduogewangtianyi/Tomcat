package com.carrot.sec;

import com.carrot.sec.connector.HttpConnector;

public final class BootStrap {

    public static void main(String[] args) {

        HttpConnector connector = new HttpConnector();
        connector.start();

    }

}
