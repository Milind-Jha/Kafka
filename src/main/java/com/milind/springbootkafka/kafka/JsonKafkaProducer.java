package com.milind.springbootkafka.kafka;


import com.milind.springbootkafka.dto.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class JsonKafkaProducer {

    private final static Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, Employee> kafkaTemplate;


    public JsonKafkaProducer(KafkaTemplate<String, Employee> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Employee employee){

        LOGGER.info("Message sent "+employee);

        Message<Employee> message = MessageBuilder.withPayload(employee).
                setHeader(KafkaHeaders.TOPIC, "topic2name")
                .build();

        kafkaTemplate.send(message);
    }
}
