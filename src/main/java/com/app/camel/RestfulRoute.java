package com.app.camel;

import com.app.camel.Config;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by britenet on 2016-10-20.
 */
public class RestfulRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {





        from("restlet:http://localhost:9091/user?restletMethod=get")
                .to("direct:select");



        from("restlet:http://localhost:9091/user/{name}?restletMethod=get")
                .transform().simple("Hello ${header.name}");

        from("restlet:http://localhost:9091/user?restletMethod=put")
                .to("direct:select")
                .transform().simple("put ");

        from("direct:select")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        JooqClass jooqClass= new JooqClass();

                        String body= jooqClass.select();
                        exchange.getIn().setBody(body);


                    }
                })
        .transform().body();

    }
}
