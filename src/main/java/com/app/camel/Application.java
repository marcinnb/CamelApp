package com.app.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Application {
    public static void main(String[] args) throws Exception {

        Class.forName(Config.DRIVER).newInstance();

        CamelContext context = new DefaultCamelContext();
        RestfulRoute restfulRoute = new RestfulRoute();
        context.addRoutes(restfulRoute);
        context.start();
        Thread.sleep(50000);
        context.stop();
    }
}
