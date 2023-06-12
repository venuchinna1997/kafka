package com.example.apachekafka.service;

import com.example.apachekafka.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        log.info("Message sent: {}", message);
        kafkaTemplate.send(Constants.KAFKA_TOPIC_ONE, message);
    }
}
