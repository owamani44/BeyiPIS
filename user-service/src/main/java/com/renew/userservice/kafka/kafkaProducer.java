package com.renew.userservice.kafka;

import com.renew.userservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import user.events.UserEvent;


@Service
public class kafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(kafkaProducer.class);
    private final KafkaTemplate<String,byte[]> kafkaTemplate;

    public kafkaProducer(KafkaTemplate<String,byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(User user){
        UserEvent event = UserEvent.newBuilder()
                .setUserID(user.getUserid().toString())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setTel(user.getTel())
                .setDistrict(user.getDistrict())
                .setEventType("USER EVENT CREATED")
                .build();
        try {
            kafkaTemplate.send("user",event.toByteArray());
        } catch (Exception e) {
            log.error("Error while getting event: {} ",event);
        }
    }
}
