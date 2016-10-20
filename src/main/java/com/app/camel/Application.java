package com.app.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;

public class Application {
    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();
        RestfulRoute restfulRoute = new RestfulRoute();
        context.addRoutes(restfulRoute);
        context.start();
        Thread.sleep(50000);
        context.stop();
    }
}
