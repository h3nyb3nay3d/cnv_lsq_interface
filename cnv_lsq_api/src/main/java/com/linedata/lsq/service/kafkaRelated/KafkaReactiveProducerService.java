package com.linedata.lsq.service.kafkaRelated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaReactiveProducerService {

    private final Logger log = LoggerFactory.getLogger(KafkaReactiveProducerService.class);

    @Autowired
    private final ReactiveKafkaProducerTemplate<String, Object> reactiveKafkaProducerTemplate;

    @Value("${STREAM_TOPIC}")
    private String STREAM_TOPIC;

    public KafkaReactiveProducerService(ReactiveKafkaProducerTemplate<String, Object> reactiveKafkaProducerTemplate) {
        this.reactiveKafkaProducerTemplate = reactiveKafkaProducerTemplate;
    }

    public void sendObject(Object object) {
        reactiveKafkaProducerTemplate.send(STREAM_TOPIC, object)
                .doOnSuccess(senderResult ->
                    log.info("[ON_SUCCESS] REACTIVE PRODUCER SUCCESSFULLY PRODUCED {} = {} IN PARTITION {} IN OFFSET : {}",
                            object.getClass().getSimpleName(), object,
                            senderResult.recordMetadata().partition(), senderResult.recordMetadata().offset()))
                .subscribe();
    }
}