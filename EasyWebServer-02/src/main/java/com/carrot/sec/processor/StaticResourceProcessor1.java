package com.carrot.sec.processor;

import com.carrot.sec.entity.Request;
import com.carrot.sec.entity.Response;

import java.io.IOException;

public class StaticResourceProcessor1 {

    public void processor(Request request , Response response){
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
