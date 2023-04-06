package com.linedata.lsq.service.kafkaRelated;

import com.linedata.lsq.model.wrappers.dealRelated.DealWrapper;
import com.linedata.lsq.service.kafkaRelated.api.KafkaConsumerApi;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class KafkaConsumerService implements KafkaConsumerApi {

    @Autowired
    private Consumer<String, DealWrapper> dealConsumer;

    @Autowired
    private Consumer<String, List<DealWrapper>> dealListConsumer;

    @Value("${PENDING_ASYNC_DEALS_BY_DEAL_EXTERNAL_ID_TOPIC}")
    private String PENDING_ASYNC_DEALS_BY_DEAL_EXTERNAL_ID_TOPIC;

    @Value("${PENDING_ASYNC_DEALS_BY_TIERS_TOPIC}")
    private String PENDING_ASYNC_DEALS_BY_TIERS_TOPIC;

    @Value("${NUMBER_OF_PARTITIONS_PER_TOPIC}")
    private int NUMBER_OF_PARTITIONS_PER_TOPIC;


    private List<TopicPartition> PendingDealsTopicPartitionSetter(String topic, int n) {
        List<TopicPartition> topicPartitionList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            topicPartitionList.add(new TopicPartition(topic, i));
        }
        return topicPartitionList;
    }

    private <T> void resetOffset(Consumer<String, T> consumer, List<TopicPartition> topicPartitionList) {
        try {
            consumer.unsubscribe();
        } catch (IllegalStateException ignored) {
        }
        consumer.assign(topicPartitionList);
        consumer.seekToBeginning(topicPartitionList);
    }

    private <T> void subscribe(Consumer<String, T> consumer, String topic) {
        try {
            consumer.unsubscribe();
        } catch (IllegalStateException ignored) {
        }
        consumer.subscribe(Collections.singletonList(topic));
    }

    private <T> List<T> consumeAll(Consumer<String, T> consumer, List<TopicPartition> topicPartitionList) {
        int tmp_size = 0;
        List<T> recordsAsList = new ArrayList<>();
        while (true) {
            ConsumerRecords<String, T> records = consumer.poll(Duration.ofMillis(1000));
            recordsAsList.addAll(StreamSupport.stream(records.spliterator(), false).map(ConsumerRecord::value).collect(Collectors.toList()));
            if (tmp_size == recordsAsList.size())
                break;
            else
                tmp_size = recordsAsList.size();
        }
        dealConsumer.commitAsync();
        dealConsumer.unsubscribe();
        return recordsAsList;
    }

    private <T> List<T> consumeUnconsumed(Consumer<String, T> consumer) {
        ConsumerRecords<String, T> records = consumer.poll(Duration.ofMillis(1000));
        consumer.commitAsync();
        return StreamSupport.stream(records.spliterator(), false)
                .map(ConsumerRecord::value)
                .collect(Collectors.toList());
    }

    @Override
    public List<DealWrapper> consumeDealsFromCommittedOffset() {
        subscribe(dealConsumer, PENDING_ASYNC_DEALS_BY_DEAL_EXTERNAL_ID_TOPIC);
        return consumeUnconsumed(dealConsumer);
    }


    @Override
    public List<DealWrapper> consumeDealsFromBeginning() {
        List<TopicPartition> topicPartitionList = PendingDealsTopicPartitionSetter(PENDING_ASYNC_DEALS_BY_DEAL_EXTERNAL_ID_TOPIC, NUMBER_OF_PARTITIONS_PER_TOPIC);
        resetOffset(dealConsumer, topicPartitionList);
        return consumeAll(dealConsumer, topicPartitionList);
    }

    @Override
    public List<List<DealWrapper>> consumeDealListsFromBeginning() {
        List<TopicPartition> topicPartitionList = PendingDealsTopicPartitionSetter(PENDING_ASYNC_DEALS_BY_TIERS_TOPIC, NUMBER_OF_PARTITIONS_PER_TOPIC);
        resetOffset(dealListConsumer, topicPartitionList);
        return consumeAll(dealListConsumer, topicPartitionList);
    }

    @Override
    public List<List<DealWrapper>> consumeDealListsFromCommittedOffset() {
        subscribe(dealListConsumer, PENDING_ASYNC_DEALS_BY_TIERS_TOPIC);
        return consumeUnconsumed(dealListConsumer);
    }

}