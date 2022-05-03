package com.example.demo.receive;

import com.example.demo.models.Facture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    private Logger logger = LoggerFactory.getLogger(MessageReceiver.class);

    @RabbitListener(queues="facture_queue")
    public void receiveFacture(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Facture f = mapper.readValue(message, Facture.class);
        logger.info("Facture received - " + f);
    }

    @RabbitListener(queues="compta_queue")
    public void receiveCompta(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Facture f = mapper.readValue(message, Facture.class);
        logger.info("Compta received - " + message);
    }
}
