package com.renew.notificationservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import user.events.UserEvent;

@Service
public class kafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(kafkaConsumer.class);

    @KafkaListener(topics = "userEvent", groupId = "notification-service")
    public void consumeEvent(byte[] event){

        try {
            UserEvent userEvent= UserEvent.parseFrom(event);
            log.info("Received User Event:[userID:{},username:{}, email:{},tel:{},district:{}]",
                    userEvent.getUserID(),
                    userEvent.getUsername(),
                    userEvent.getEmail(),
                    userEvent.getTel(),
                    userEvent.getDistrict()
                    );
        } catch (InvalidProtocolBufferException e) {
            log.error("Error Deserializing event {}" ,e.getMessage());
        }

    }

}
