package com.linedata.lsq.config.kafka;

import com.linedata.ekip.std.services.deal.entity.Deal;
import com.linedata.lsq.model.events.DealRequest;
import com.linedata.lsq.model.wrappers.dealRelated.DealWrapper;
import com.linedata.lsq.service.beanRelated.BeanFinderService;
import com.linedata.lsq.service.beanRelated.DealLevelsFillerService;
import com.linedata.lsq.utils.AESSerdes;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@EnableKafka
@EnableKafkaStreams
public class KafkaStreamsConfig {

    @Value("${BOOTSTRAP_SERVERS_CONFIG}")
    private String BOOTSTRAP_SERVERS_CONFIG;

    @Value("${APPLICATION_ID_CONFIG}")
    private String APPLICATION_ID_CONFIG;

    @Value("${REQUESTED_ASYNC_DEALS_TOPIC}")
    private String REQUESTED_ASYNC_DEALS_TOPIC;

    @Value("${PENDING_ASYNC_DEALS_BY_DEAL_EXTERNAL_ID_TOPIC}")
    private String PENDING_ASYNC_DEALS_BY_DEAL_EXTERNAL_ID_TOPIC;

    @Value("${PENDING_ASYNC_DEALS_BY_TIERS_TOPIC}")
    private String PENDING_ASYNC_DEALS_BY_TIERS_TOPIC;

    @Autowired
    private BeanFinderService beanFinderService;

    @Autowired
    private DealLevelsFillerService dealLevelsFillerService;

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

    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration kafkaStreams() {

        Map<String, Object> props = new HashMap<>();

        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, APPLICATION_ID_CONFIG);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, JsonSerde.class);
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, DealRequest.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, KEY_STORE_LOCATION);
        props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, KEY_STORE_PASSWORD);
        props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, TRUST_STORE_LOCATION);
        props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, TRUST_STORE_PASSWORD);
        props.put(AdminClientConfig.SECURITY_PROTOCOL_CONFIG, SECURITY_PROTOCOL);

        return new KafkaStreamsConfiguration(props);
    }

    @Bean
    public KStream<String, DealWrapper> dealAsyncKStream(StreamsBuilder builder) {

        Serde<DealRequest> dealRequestSerde = new JsonSerde<>(DealRequest.class);
        Serde<DealWrapper> dealSerde = new JsonSerde<>(DealWrapper.class);

        KStream<String, DealWrapper> dealAsyncKStream = builder
                .stream(REQUESTED_ASYNC_DEALS_TOPIC, Consumed.with(Serdes.String(), dealRequestSerde))
                .filter((key, value) -> value.isByDealExternalId())
                .map(new DealKeyValueMapper())
                .mapValues((key,value)-> {
                    Deal deal = beanFinderService.getLiteDealByExternalId(value.getExternalId());
                    DealWrapper dealWrapper = new DealWrapper();
                    switch (value.getLevel()){
                        case 0:
                            dealWrapper = new DealWrapper(deal);
                            break;
                        case 1:
                            dealWrapper = dealLevelsFillerService.deal1LevelFiller(deal);
                            break;
                        case 2:
                            dealWrapper = dealLevelsFillerService.deal2LevelFiller(deal);
                            break;
                        case 3:
                            dealWrapper = dealLevelsFillerService.deal3LevelFiller(deal);
                            break;
                        case 4:
                            dealWrapper = dealLevelsFillerService.deal4LevelFiller(deal);
                            break;
                        case 5:
                            dealWrapper = dealLevelsFillerService.deal5LevelFiller(deal);
                            break;
                        case 6:
                            dealWrapper = dealLevelsFillerService.deal6LevelFiller(deal);
                            break;
                    }
                    return dealWrapper;
                });

        dealAsyncKStream.to(PENDING_ASYNC_DEALS_BY_DEAL_EXTERNAL_ID_TOPIC, Produced.with(Serdes.String(), dealSerde));

        return dealAsyncKStream;
    }

    @Bean
    public KStream<String, List<DealWrapper>> dealListAsyncKStream(StreamsBuilder builder) {

        Serde<DealRequest> dealRequestSerde = new JsonSerde<>(DealRequest.class);
        Serde<List<DealWrapper>> dealSerde = new JsonSerde<>(List.class);

        KStream<String, List<DealWrapper>> dealAsyncKStream = builder
                .stream(REQUESTED_ASYNC_DEALS_TOPIC, Consumed.with(Serdes.String(), dealRequestSerde))
                .filter((key, value) -> !value.isByDealExternalId())
                .map(new DealKeyValueMapper())
                .mapValues((key,value)-> {
                    List<Deal> dealList = beanFinderService.getLiteDealsByThirdPartyTiersId(value.getExternalId());
                    switch (value.getLevel()){
                        case 0:
                            return dealList.parallelStream().map(DealWrapper::new).collect(Collectors.toList());
                        case 1:
                            return dealList.parallelStream().map(deal -> dealLevelsFillerService.deal1LevelFiller(deal)).collect(Collectors.toList());
                        case 2:
                            return dealList.parallelStream().map(deal -> dealLevelsFillerService.deal2LevelFiller(deal)).collect(Collectors.toList());
                        case 3:
                            return dealList.parallelStream().map(deal -> dealLevelsFillerService.deal3LevelFiller(deal)).collect(Collectors.toList());
                        case 4:
                            return dealList.parallelStream().map(deal -> dealLevelsFillerService.deal4LevelFiller(deal)).collect(Collectors.toList());
                        case 5:
                            return dealList.parallelStream().map(deal -> dealLevelsFillerService.deal5LevelFiller(deal)).collect(Collectors.toList());
                        case 6:
                            return dealList.parallelStream().map(deal -> dealLevelsFillerService.deal6LevelFiller(deal)).collect(Collectors.toList());
                    }
                    return null;
                });

        dealAsyncKStream.to(PENDING_ASYNC_DEALS_BY_TIERS_TOPIC, Produced.with(Serdes.String(), dealSerde));

        return dealAsyncKStream;
    }


    public static class DealKeyValueMapper implements KeyValueMapper<String, DealRequest, KeyValue<String, DealRequest>> {
        @Override
        public KeyValue<String, DealRequest> apply(String key, DealRequest value) {
            return new KeyValue<>(value.getLocalDateTime()+"", value);
        }
    }
}
