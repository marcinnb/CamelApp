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

       /* String user = Config.USER;
        String password = Config.PASSWORD;
        String url = Config.URL;
        String driver = Config.DRIVER;

        Class.forName(driver).newInstance();
        DSLContext dslContext;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            dslContext = DSL.using(connection, SQLDialect.MYSQL);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        CamelContext context= new DefaultCamelContext();
        RestfulRoute restfulRoute= new RestfulRoute();
        context.addRoutes(restfulRoute);
        context.start();
        Thread.sleep(50000);
        context.stop();


    }
}
