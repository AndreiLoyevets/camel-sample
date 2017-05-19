package com.aloievets.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew on 19.05.2017.
 */
@Component
public class FileCopierRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:data/inbox?noop=true")
                .to("file:data/outbox");
    }
}
