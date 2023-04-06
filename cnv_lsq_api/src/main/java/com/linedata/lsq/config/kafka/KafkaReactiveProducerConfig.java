package com.linedata.lsq.config.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;
import reactor.kafka.sender.SenderOptions;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaReactiveProducerConfig {

    @Value(value = "${BOOTSTRAP_SERVERS_CONFIG}")
    private String BOOTSTRAP_SERVERS_CONFIG;

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
    public ReactiveKafkaProducerTemplate<String, Object> reactiveKafkaProducerTemplate() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        configProps.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, KEY_STORE_LOCATION);
        configProps.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, KEY_STORE_PASSWORD);
        configProps.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, TRUST_STORE_LOCATION);
        configProps.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, TRUST_STORE_PASSWORD);
        configProps.put(AdminClientConfig.SECURITY_PROTOCOL_CONFIG, SECURITY_PROTOCOL);

        return new ReactiveKafkaProducerTemplate<>(SenderOptions.create(configProps));
    }
}