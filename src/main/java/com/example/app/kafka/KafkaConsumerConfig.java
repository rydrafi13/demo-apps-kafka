package com.example.app.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerConfig {
    public static void main(String[] args) {
     Properties properties = new Properties();
     properties.setProperty("bootstrap.servers", "10.10.10.181:9092");
     properties.setProperty("group.id", "APPS");
     properties.setProperty("enable.auto.commit", "true");
     properties.setProperty("auto.commit.interval.ms", "1000");
     properties.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
     properties.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

     KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
     consumer.subscribe(Arrays.asList("apps-topic"));

     while (true) {
         ConsumerRecords<String, String> records = consumer.poll(java.time.Duration.ofMillis(100));
         for (ConsumerRecord<String, String> record : records){
            System.out.println("Received data : " + record.value());
         }
     }
    }
}
