package com.example.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RabbitConfig {

    @Bean
    public ObjectMapper mapper(){
        return new ObjectMapper();
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean("facture_queue")
    public Queue factureQueue(){
        return new Queue("facture_queue", true);
    }

    @Bean("compta_queue")
    public Queue comptaQueue(){
        return new Queue("compta_queue", false);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topic.facture");
    }

    @Bean
    public Binding fBind(TopicExchange exchange,@Qualifier("facture_queue") Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("facture.*");
    }

    @Bean
    public Binding cBind(TopicExchange exchange,@Qualifier("compta_queue") Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("*.compta");
    }

    @Bean
    public List<Binding> bindings(TopicExchange exchange, List<Queue> queues){
        System.out.println(queues);
        return new ArrayList<>();
    }
}
