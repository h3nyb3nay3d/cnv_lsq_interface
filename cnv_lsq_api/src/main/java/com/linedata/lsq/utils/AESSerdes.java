package com.linedata.lsq.utils;

import com.linedata.lsq.model.events.DealRequest;
import com.linedata.lsq.model.wrappers.dealRelated.DealWrapper;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class AESSerdes {

    private AESSerdes() {}

    public static Serde<DealRequest> DealRequest() {
        AESSerializer<DealRequest> serializer = new AESSerializer<>();
        AESDeserializer<DealRequest> deserializer = new AESDeserializer<>();
        return Serdes.serdeFrom(serializer, deserializer);
    }

    public static Serde<DealWrapper> DealWrapper() {
        AESSerializer<DealWrapper> serializer = new AESSerializer<>();
        AESDeserializer<DealWrapper> deserializer = new AESDeserializer<>();
        return Serdes.serdeFrom(serializer, deserializer);
    }
}
