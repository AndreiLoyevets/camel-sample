package com.aloievets.camel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Andrew on 19.05.2017.
 */
public class Launcher {

    public static void main(String[] args) throws Exception {
        new AnnotationConfigApplicationContext(AppConfig.class);
        Thread.sleep(10000);
    }
}
