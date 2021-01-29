package com.example.demo3;

import com.example.model.FeedbackModel;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class Feed {

    public static FeedbackModel newFeedback = new FeedbackModel();

    public static KafkaConsumer<String, String> createConsumer(String topic) {
        String bootstrapServer = "127.0.0.1:9092";
        String groupId = "kafka-con-1";

        // Create consumer configs
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "100");


        // Create consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList(topic));
        return consumer;
    }

//    public static FeedbackModel createNewFeedback(String feedback) {
//        FeedbackModel newFeedback = new FeedbackModel();
//        newFeedback.setFeedback(feedback);
//        return newFeedback;
//    }

//    public static String createNewFeedback(String feedback) {
//        String newFeeds = feedback;
//        return newFeeds;
//    }
//

    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger(HelloResource.class.getName());


        KafkaConsumer<String, String> consumer = createConsumer("new-feedback");

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
//            System.out.println(records.toString());
            for (ConsumerRecord<String, String> record : records) {
//                logger.info("value: " + );
//                String id = record.topic() + "_" + record.partition() + "_" + record.offset();
//                logger.info("Partition: " + record.partition() + ", Offset: " + record.offset());
//                logger.info(id);
//                list.add(record.value());
//                createNewFeedback(record.value());

                newFeedback.setFeedback(record.value());
                System.out.println(newFeedback.getFeedback());
            }
        }
    }
}
