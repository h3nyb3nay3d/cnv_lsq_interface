package com.linedata.lsq.service.kafkaRelated;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@Service
public class KafkaReactiveConsumerService {

    private final Logger log = LoggerFactory.getLogger(KafkaReactiveConsumerService.class);

    @Autowired
    private ReactiveKafkaConsumerTemplate<String, Object> reactiveKafkaConsumerTemplate;

    @Autowired
    private KafkaReactiveProducerService kafkaReactiveProducerService;

    private ConnectableFlux<Object> dealPublisher;

    @PostConstruct
    private void init() {
        dealPublisher = reactiveKafkaConsumerTemplate.receiveAutoAck()
                .map(ConsumerRecord::value)
                .publish();
        dealPublisher.connect();
    }

    public Flux<Object> consumeDeals() {
        Object[] tmp = new Object[1];
        return dealPublisher
                .doOnNext(object -> {
                    tmp[0] = object;
                    log.info("[ON_NEXT] REACTIVE CONSUMER SUCCESSFULLY CONSUMED {} = {}", object.getClass().getSimpleName(), object);
                })
                .doOnError(throwable -> log.error("[ON_ERROR] SOMETHING BAD HAPPENED WHILE CONSUMING : {}", throwable.getMessage()))
                .doOnCancel(() -> log.info("[ON_CANCEL] REACTIVE CONSUMER CONSUMPTION WAS CANCELED"))
                .doFinally(signalType -> log.info("[FINALLY] REACTIVE CONSUMER STOPPED WITH SIGNAL = {}", signalType))
                .doOnTerminate(() -> {
                    log.info("[ON_TERMINATE]");
                    kafkaReactiveProducerService.sendObject(tmp[0]);
                });
    }
}