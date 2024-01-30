package com.example.app.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerConfig {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "10.10.10.181:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        
        for (int i = 0; i < 100; i++){
            ProducerRecord<String, String> record = new ProducerRecord<>("apps-topic", "Send Data number " + i);
            producer.send(record);    
        }

        producer.close();
    }
}
