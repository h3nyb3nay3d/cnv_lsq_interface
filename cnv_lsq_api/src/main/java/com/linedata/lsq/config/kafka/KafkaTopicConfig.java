package com.linedata.lsq.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    @Value("${TRUST_STORE_PASSWORD}")
    private String TRUST_STORE_PASSWORD;

    @Value("${TRUST_STORE_LOCATION}")
    private String TRUST_STORE_LOCATION;

    @Value("${KEY_STORE_LOCATION}")
    private String KEY_STORE_LOCATION;

    @Value("${KEY_STORE_PASSWORD}")
    private String KEY_STORE_PASSWORD;
    @Value("${PENDING_ASYNC_DEALS_BY_DEAL_EXTERNAL_ID_TOPIC}")
    private String PENDING_ASYNC_DEALS_BY_DEAL_EXTERNAL_ID_TOPIC;

    @Value("${PENDING_ASYNC_DEALS_BY_TIERS_TOPIC}")
    private String PENDING_ASYNC_DEALS_BY_TIERS_TOPIC;

    @Value("${STREAM_TOPIC}")
    private String STREAM_TOPIC;

    @Value("${REQUESTED_ASYNC_DEALS_TOPIC}")
    private String REQUESTED_ASYNC_DEALS_TOPIC;

    @Value("${PENDING_DRAWDOWNS_TOPIC}")
    private String PENDING_DRAWDOWNS_TOPIC;

    @Bean
    public NewTopic REQUESTED_ASYNC_DEALS_TOPIC() {
        NewTopic newTopic = new NewTopic(REQUESTED_ASYNC_DEALS_TOPIC, 1, (short) 1);
        newTopic.configs(topicConfig());
        return newTopic;
    }

    @Bean
    public NewTopic PENDING_ASYNC_DEALS_BY_DEAL_EXTERNAL_ID_TOPIC() {
        NewTopic newTopic = new NewTopic(PENDING_ASYNC_DEALS_BY_DEAL_EXTERNAL_ID_TOPIC, 1, (short) 1);
        newTopic.configs(topicConfig());
        return newTopic;
    }

    @Bean
    public NewTopic PENDING_ASYNC_DEALS_BY_TIERS_TOPIC() {
        NewTopic newTopic = new NewTopic(PENDING_ASYNC_DEALS_BY_TIERS_TOPIC, 1, (short) 1);
        Map<String, String> configProps = new HashMap<>(topicConfig());
        configProps.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "10485760");
        newTopic.configs(configProps);
        return newTopic;
    }

    @Bean
    public NewTopic PENDING_DRAWDOWNS_TOPIC() {
        NewTopic newTopic = new NewTopic(PENDING_DRAWDOWNS_TOPIC, 1, (short) 1);
        newTopic.configs(topicConfig());
        return newTopic;
    }

    @Bean
    public NewTopic STREAM_TOPIC() {
        NewTopic newTopic = new NewTopic(STREAM_TOPIC, 1, (short) 1);

        newTopic.configs(topicConfig());
        return newTopic;
    }

    private Map<String, String> topicConfig() {
        Map<String, String> configProps = new HashMap<>();
        configProps.put(TopicConfig.MIN_IN_SYNC_REPLICAS_CONFIG, "1");
        configProps.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, KEY_STORE_LOCATION);
        configProps.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, KEY_STORE_PASSWORD);
        configProps.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, TRUST_STORE_LOCATION);
        configProps.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, TRUST_STORE_PASSWORD);
        return configProps;
    }
}