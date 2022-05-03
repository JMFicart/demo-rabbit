package com.example.demo.receive;

import com.example.demo.models.Facture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MessageSender implements InitializingBean {

    private final RabbitTemplate rabbitTemplate;

    public MessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendFactureToReservation(String json){
//        Message message = MessageBuilder.withBody(json.getBytes())
//                        .setContentType("application/json")
//                        .build();
//        rabbitTemplate.send("topic.facture", "facture.compta", message);
        rabbitTemplate.convertAndSend("facture", "facture", json);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Facture f = new Facture(
                50,
                UUID.randomUUID()
        );

        ObjectMapper mapper = new ObjectMapper();
        String fJson = mapper.writeValueAsString(f);

        sendFactureToReservation(fJson);
    }
}
