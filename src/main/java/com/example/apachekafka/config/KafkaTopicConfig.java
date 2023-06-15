package com.example.apachekafka.config;

import com.example.apachekafka.constants.Constants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic learningTopic(){
        return TopicBuilder.name(Constants.KAFKA_TOPIC_ONE).build();
    }


    public NewTopic learningJsonTopic(){
        return TopicBuilder.name(Constants.KAFKA_TOPIC_TWO).build();
    }
}
