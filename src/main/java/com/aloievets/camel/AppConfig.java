package com.aloievets.camel;

import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Andrew on 19.05.2017.
 */
@Configuration
@ComponentScan
public class AppConfig extends CamelConfiguration {
}