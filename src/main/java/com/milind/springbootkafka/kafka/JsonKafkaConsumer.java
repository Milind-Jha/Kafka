package com.milind.springbootkafka.kafka;

import com.milind.springbootkafka.dto.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    @KafkaListener(topics = "topic2name", groupId = "consumerGroup ")
    public void consume(Employee employee){
        LOGGER.info("Consumed : "+employee);
    }
}
