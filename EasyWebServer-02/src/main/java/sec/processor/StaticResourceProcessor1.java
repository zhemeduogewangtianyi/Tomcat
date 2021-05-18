package sec.processor;

import sec.entity.Request;
import sec.entity.Response;

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
