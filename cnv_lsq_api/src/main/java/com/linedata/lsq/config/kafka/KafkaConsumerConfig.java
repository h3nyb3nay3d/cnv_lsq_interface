package com.linedata.lsq.config.kafka;

import com.linedata.lsq.model.wrappers.dealRelated.DealWrapper;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${BOOTSTRAP_SERVERS_CONFIG}")
    private String BOOTSTRAP_SERVERS;

    @Value(value = "${DEAL_LIST_CONSUMER_GROUP_ID}")
    private String DEAL_LIST_CONSUMER_GROUP_ID;

    @Value(value = "${DEAL_CONSUMER_GROUP_ID}")
    private String DEAL_CONSUMER_GROUP_ID;

    @Value("${SECURITY_PROTOCOL}")
    private String SECURITY_PROTOCOL;

    @Value("${TRUST_STORE_PASSWORD}")
    private String TRUST_STORE_PASSWORD;

    @Value("${TRUST_STORE_LOCATION}")
    private String TRUST_STORE_LOCATION;

    @Value("${KEY_STORE_LOCATION}")
    private String KEY_STORE_LOCATION;

    @Value("${KEY_STORE_PASSWORD}")
    private String KEY_STORE_PASSWORD;

    private Map<String, Object> consumerPropertiesSetter() {
        Map<String, Object> properties = new HashMap<>();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        properties.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, "10485760");
        properties.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, "10485760");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        properties.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, KEY_STORE_LOCATION);
        properties.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, KEY_STORE_PASSWORD);
        properties.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, TRUST_STORE_LOCATION);
        properties.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, TRUST_STORE_PASSWORD);
        properties.put(AdminClientConfig.SECURITY_PROTOCOL_CONFIG, SECURITY_PROTOCOL);

        return properties;
    }


    @Bean
    public ConsumerFactory<String, DealWrapper> dealConsumerFactory() {
        Map<String, Object> properties = consumerPropertiesSetter();
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, DEAL_CONSUMER_GROUP_ID);

        JsonDeserializer<DealWrapper> jsonDeserializer = new JsonDeserializer<>();
        jsonDeserializer.addTrustedPackages("*");
        return new DefaultKafkaConsumerFactory<>(properties, new StringDeserializer(), jsonDeserializer);
    }

    @Bean
    public Consumer<String, DealWrapper> dealConsumer() {
        return dealConsumerFactory().createConsumer();
    }

    @Bean
    public ConsumerFactory<String, List<DealWrapper>> dealListConsumerFactory() {
        Map<String, Object> properties = consumerPropertiesSetter();
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, DEAL_LIST_CONSUMER_GROUP_ID);

        JsonDeserializer<List<DealWrapper>> jsonDeserializer = new JsonDeserializer<>();
        jsonDeserializer.addTrustedPackages("*");
        return new DefaultKafkaConsumerFactory<>(properties, new StringDeserializer(), jsonDeserializer);
    }

    @Bean
    public Consumer<String, List<DealWrapper>> dealListConsumer() {
        return dealListConsumerFactory().createConsumer();
    }
}