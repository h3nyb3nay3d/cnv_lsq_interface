package com.linedata.lsq.service.kafkaRelated.api;

import com.linedata.lsq.model.events.DealRequest;

public interface KafkaProducerApi {
    void sendDealRequest(DealRequest dealRequest);
}
