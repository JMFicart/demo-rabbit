package com.example.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RabbitConfig {

    @Bean
    public RabbitAdmin rabbitadmin(ConnectionFactory connectionfactory){
        return new RabbitAdmin(connectionfactory);
    }

    @Bean("facture_queue")
    public Queue factureQueue(){
        return new Queue("facture_queue", true,  false, false);
    }

    @Bean("reserve_queue")
    public Queue reserveQueue(){
        return new Queue("reserve_queue", true, false, false);
    }

    @Bean
    public DirectExchange exchange( ){
        return new DirectExchange("reserve.facture");
    }
    @Bean
    public Binding fBind(DirectExchange exchange, @Qualifier("facture_queue") Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("facture");
    }

    @Bean
    public Binding rBind(DirectExchange exchange, @Qualifier("reserve_queue") Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("reservation");
    }

    public List<Binding> bindings(TopicExchange exchange, List<Queue> queues){
        System.out.println(queues);
        return new ArrayList<>();
    }
}
