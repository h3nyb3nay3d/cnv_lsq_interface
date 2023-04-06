package com.linedata.lsq.config.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.Collections;

@Configuration
public class KafkaReactiveConsumerConfig {

    @Value("${STREAM_TOPIC}")
    private String STREAM_TOPIC;

    @Value(value = "${BOOTSTRAP_SERVERS_CONFIG}")
    private String BOOTSTRAP_SERVERS_CONFIG;

    @Value(value = "${STREAMING_GROUP_ID}")
    private String STREAMING_GROUP_ID;

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

    @Bean
    public ReceiverOptions<String, Object> kafkaReceiverOptions(KafkaProperties kafkaProperties) {

        kafkaProperties.getProperties().put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
        kafkaProperties.getProperties().put(ConsumerConfig.GROUP_ID_CONFIG, STREAMING_GROUP_ID);
        kafkaProperties.getProperties().put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        kafkaProperties.getProperties().put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
        kafkaProperties.getProperties().put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

        kafkaProperties.getProperties().put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, KEY_STORE_LOCATION);
        kafkaProperties.getProperties().put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, KEY_STORE_PASSWORD);
        kafkaProperties.getProperties().put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, TRUST_STORE_LOCATION);
        kafkaProperties.getProperties().put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, TRUST_STORE_PASSWORD);
        kafkaProperties.getProperties().put(AdminClientConfig.SECURITY_PROTOCOL_CONFIG, SECURITY_PROTOCOL);

        JsonDeserializer<Object> jsonDeserializer = new JsonDeserializer<>();
        jsonDeserializer.addTrustedPackages("*");

        ReceiverOptions<String, Object> basicReceiverOptions = ReceiverOptions.create(kafkaProperties.buildConsumerProperties());

        return basicReceiverOptions.subscription(Collections.singletonList(STREAM_TOPIC));
    }

    @Bean
    public ReactiveKafkaConsumerTemplate<String, Object> reactiveKafkaConsumerTemplate(ReceiverOptions<String, Object> kafkaReceiverOptions) {
        return new ReactiveKafkaConsumerTemplate<>(kafkaReceiverOptions);
    }
}