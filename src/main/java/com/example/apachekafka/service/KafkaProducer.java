package com.example.apachekafka.service;

import com.example.apachekafka.constants.Constants;
import com.example.apachekafka.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate1;

    public void sendMessage(String message){
        log.info("Message sent: {}", message);
        kafkaTemplate.send(Constants.KAFKA_TOPIC_ONE, message);
    }

    public void sendJsonMessage(User user){
        log.info("Json User Message sent: {}", user);
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,"gopal")
                .build();
        kafkaTemplate1.send(message);

    }
}
