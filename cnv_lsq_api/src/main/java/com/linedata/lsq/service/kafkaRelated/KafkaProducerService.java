package com.linedata.lsq.service.kafkaRelated;

import com.linedata.lsq.model.events.DealRequest;
import com.linedata.lsq.service.kafkaRelated.api.KafkaProducerApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducerService implements KafkaProducerApi {

    private final Logger log = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, DealRequest> dealRequestKafkaTemplate;

    @Value("${REQUESTED_ASYNC_DEALS_TOPIC}")
    private String REQUESTED_ASYNC_DEALS_TOPIC;

    @Override
    public void sendDealRequest(DealRequest dealRequest) {
        ListenableFuture<SendResult<String, DealRequest>> future = dealRequestKafkaTemplate.send(REQUESTED_ASYNC_DEALS_TOPIC, dealRequest);
        future.addCallback(new ListenableFutureCallback<SendResult<String, DealRequest>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(ex);
            }

            @Override
            public void onSuccess(SendResult<String, DealRequest> result) {
                handleSuccess(result);
            }
        });
    }

    private void handleFailure(Throwable ex) {
        log.error("Unable to send message=[" + "DealRequest" + "] due to : " + ex.getMessage());
        try {
            throw ex;
        } catch (Throwable throwable) {
            log.error("Error in OnFailure: {}",throwable.getMessage());
        }
    }

    private void handleSuccess(SendResult<String, DealRequest> result) {
        log.info("Sent message=[" + "DealRequest" + "] to partition= [" + result.getRecordMetadata().partition() + "] with offset=[" + result.getRecordMetadata().offset() + "]" + " with key=[" + result.getProducerRecord().key() + "]");

    }
}
