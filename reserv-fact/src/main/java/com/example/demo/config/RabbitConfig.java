package com.example.demo.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.Queue;
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
        return new Queue("facture_queue", true);
    }

    @Bean("reserve_queue")
    public Queue reserveQueue(){
        return new Queue("reserve_queue", false, true, true);
    }

    @Bean
    public FanoutExchange fanoutexchange(){
        return new FanoutExchange("fanout.facture");
    }

    @Bean
    public Binding fBind(TopicExchange exchange, @Qualifier("facture_queue") Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("facture.*");
    }

    @Bean
    public Binding cBind(TopicExchange exchange, @Qualifier("compta_queue") Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("*.compta");
    }

    public List<Binding> bindings(TopicExchange exchange, List<Queue> queues){
        System.out.println(queues);
        return new ArrayList<>();
    }

}
