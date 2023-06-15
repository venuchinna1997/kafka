package com.example.apachekafka.service;

import com.example.apachekafka.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.apachekafka.entity.User;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = Constants.KAFKA_TOPIC_ONE, groupId = Constants.GROUP_ID)
    public void consume(String message){
        log.info("Message Received: {}", message);
    }

    @KafkaListener(topics = Constants.KAFKA_TOPIC_TWO, groupId = Constants.GROUP_ID)
    public void consume(User user){
        log.info("Josn message Received: {}", user.toString());
    }
}
