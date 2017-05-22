package com.aloievets.camel;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsConfiguration;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Andrew on 19.05.2017.
 */
@Configuration
@ComponentScan
public class AppConfig extends CamelConfiguration {

    @Bean
    public ActiveMQConnectionFactory jmsConnectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616");
        return connectionFactory;
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    PooledConnectionFactory pooledConnectionFactory() {
        PooledConnectionFactory factory = new PooledConnectionFactory();
        factory.setMaxConnections(8);
        factory.setConnectionFactory(jmsConnectionFactory());
        return factory;
    }

    @Bean
    JmsConfiguration jmsConfiguration() {
        JmsConfiguration configuration = new JmsConfiguration();
        configuration.setConnectionFactory(pooledConnectionFactory());
        configuration.setConcurrentConsumers(10);
        return configuration;
    }

    @Bean
    ActiveMQComponent activeMQComponent() {
        ActiveMQComponent component = new ActiveMQComponent();
        component.setConfiguration(jmsConfiguration());
        return component;
    }
}