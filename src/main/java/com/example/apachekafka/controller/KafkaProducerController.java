package com.example.apachekafka.controller;

import com.example.apachekafka.entity.User;
import com.example.apachekafka.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/v1/kafka")
public class KafkaProducerController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String message){
         kafkaProducer.sendMessage(message);
         return ResponseEntity.ok("Message sent to Kafka Topic");
    }

    @PostMapping("/jsonPublish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to Kafka Topic");
    }
}
