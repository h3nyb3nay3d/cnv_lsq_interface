package com.linedata.lsq.config.kafka;

import com.linedata.lsq.model.events.DealRequest;
import com.linedata.lsq.model.wrappers.dealRelated.DealWrapper;
import com.linedata.lsq.utils.AESSerializer;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

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

    private Map<String, Object> producerPropertiesSetter() {

        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);

        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        configProps.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, "10485760");
        configProps.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);

        configProps.put(ProducerConfig.RETRIES_CONFIG, "10");
        configProps.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, "1000");

        configProps.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, KEY_STORE_LOCATION);
        configProps.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, KEY_STORE_PASSWORD);
        configProps.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, TRUST_STORE_LOCATION);
        configProps.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, TRUST_STORE_PASSWORD);
        configProps.put(AdminClientConfig.SECURITY_PROTOCOL_CONFIG, SECURITY_PROTOCOL);

        return configProps;
    }

    @Bean
    public ProducerFactory<String, DealWrapper> dealProducerFactory() {
        return new DefaultKafkaProducerFactory<>(producerPropertiesSetter());
    }

    @Bean
    public KafkaTemplate<String, DealWrapper> dealKafkaTemplate() {
        return new KafkaTemplate<>(dealProducerFactory());
    }

    @Bean
    public ProducerFactory<String, List<DealWrapper>> dealListProducerFactory() {
        return new DefaultKafkaProducerFactory<>(producerPropertiesSetter());
    }

    @Bean
    public KafkaTemplate<String, List<DealWrapper>> dealListKafkaTemplate() {
        return new KafkaTemplate<>(dealListProducerFactory());
    }

    @Bean
    public ProducerFactory<String, DealRequest> dealRequestProducerFactory() {
        return new DefaultKafkaProducerFactory<>(producerPropertiesSetter());
    }

    @Bean
    public KafkaTemplate<String, DealRequest> dealRequestKafkaTemplate() {
        return new KafkaTemplate<>(dealRequestProducerFactory());
    }
}