package com.linedata.lsq.service.kafkaRelated.api;

import com.linedata.lsq.model.wrappers.dealRelated.DealWrapper;
import org.apache.kafka.clients.consumer.Consumer;

import java.util.List;

public interface KafkaConsumerApi {

    List<DealWrapper> consumeDealsFromBeginning();

    List<DealWrapper> consumeDealsFromCommittedOffset();

    List<List<DealWrapper>> consumeDealListsFromBeginning();

    List<List<DealWrapper>> consumeDealListsFromCommittedOffset();
}
