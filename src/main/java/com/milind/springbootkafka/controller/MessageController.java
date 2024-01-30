package com.milind.springbootkafka.controller;

import com.milind.springbootkafka.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //  http://localhost:8080/api/v1/kafka/produce/message
    @GetMapping("/produce/{message}")
    public ResponseEntity<String> publish (@PathVariable String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok().body("length of message sent : "+message.length());
    }
}
