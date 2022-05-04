package com.example.demo.receive;

import com.example.demo.models.Reservation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class MessageReservationSender implements InitializingBean {
    private final RabbitTemplate rabbitTemplate;

    public MessageReservationSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendReservationToFacturation(String json){
//        Message message = MessageBuilder.withBody(json.getBytes())
//                        .setContentType("application/json")
//                        .build();
//        rabbitTemplate.send("topic.facture", "facture.compta", message);
        rabbitTemplate.convertAndSend("reserve.facture", "reservation", json);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Reservation r = new Reservation (
                UUID.randomUUID(),
                LocalDate.of(2022,7,1),
                LocalDate.of(2022,7,15),
                Reservation.Status.DEMANDE
        );

        ObjectMapper mapper = new ObjectMapper();
        String rJson = mapper.writeValueAsString(r);

        System.out.println("Réservation" + rJson);

        sendReservationToFacturation(rJson);
    }
}
