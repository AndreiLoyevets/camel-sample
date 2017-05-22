package com.aloievets.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew on 19.05.2017.
 */
@Component
public class FileToMqRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("file:data/inbox?noop=true")
                .split().tokenize("\n")
                .to("activemq:queue:testCamelQueue");
    }
}
