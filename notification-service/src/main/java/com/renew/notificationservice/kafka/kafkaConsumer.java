package com.renew.notificationservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import user.events.UserEvent;

@Service
public class kafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(kafkaConsumer.class);

    @KafkaListener(topics = "user", groupId = "notification-service")
    public void consumeEvent(byte[] event){
        try {
            UserEvent userEvent= UserEvent.parseFrom(event);
        } catch (Exception e) {
            log.error("Error deserializing event" + e.getMessage());
        }
    }

}
