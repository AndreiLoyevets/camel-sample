package com.aloievets.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew on 22.05.2017.
 */
@Component
public class MqToConsoleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:queue:testCamelQueue")
                .process(System.out::println);
    }
}
