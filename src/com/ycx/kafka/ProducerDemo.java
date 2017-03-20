package com.ycx.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by apple on 2017/3/16.
 */
public class ProducerDemo {
   /* public static void main2(String[] args) {
        Properties props = new Properties();
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "localhost:9091,localhost:9092");
        Producer<Integer, String> producer = new Producer<Integer, String>(new ProducerConfig(props));
        String topic = "lxw1234.com";

        File file = new File("/Users/apple/app.properties");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            while ((tempString = reader.readLine()) != null) {
                producer.send(new KeyedMessage<Integer, String>(topic,line + "---" + tempString));
                System.out.println("Success send [" + line + "] message ..");
                line++;
            }
            reader.close();
            System.out.println("Total send [" + line + "] messages ..");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {}
            }
        }
        producer.close();

    }*/

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9094");
        props.put("acks", "0");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("partitioner.class", "com.ycx.kafka.SimplePartitioner");


//        Map<String, Object> props2 = new HashMap<>();
//        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "my-stream-processing-application");
//        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//        StreamsConfig config = new StreamsConfig(props);
//
//        KStreamBuilder builder = new KStreamBuilder();
//        builder.
//        builder.stream("my-input-topic").mapValues(value -> value.toString()).to("my-output-topic");
//
//        KafkaStreams streams = new KafkaStreams(builder, config);
//        streams.start();




        Producer<String, String> producer = new KafkaProducer<>(props);



        for(int i = 0; i < 10000; i++) {
            Future<RecordMetadata> future = producer.send(new ProducerRecord<String, String>("ycx3", Integer.toString(i), Integer.toString(i)));
            System.out.println("produce " + Integer.toString(i) + "  " + Integer.toString(i));
            try {
                System.out.println(future.get().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //producer.close();
        }
    }
}

