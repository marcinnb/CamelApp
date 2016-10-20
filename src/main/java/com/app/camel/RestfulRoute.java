package com.app.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class RestfulRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("restlet:http://localhost:9091/user?restletMethod=get")
                .to("direct:select");

        from("restlet:http://localhost:9091/user/{name}?restletMethod=get")
                .transform().simple("Hello ${header.name}")
                .to("direct:getUserWithName");

        from("restlet:http://localhost:9091/user?restletMethod=put")
                .to("direct:select")
                .transform().simple("put ");

        from("direct:select")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        JooqClass jooqClass = new JooqClass();

                        String body = jooqClass.getAllUsers();
                        exchange.getIn().setBody(body);
                    }
                })
                .transform().body();
    }
}
