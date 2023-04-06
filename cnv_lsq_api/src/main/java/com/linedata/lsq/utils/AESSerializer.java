package com.linedata.lsq.utils;

import org.apache.kafka.common.errors.SerializationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

public class AESSerializer<T> extends JsonSerializer<T> {

    public static final String AES_SECRET_KEY = "aes.serializer.secret.keys";
    public static final String AES_SALT_KEY = "aes.serializer.salt.keys";

    @Value(value = "AES_SECRET_KEY_VALUE")
    private String secret;
    @Value(value = "AES_SALT_KEY_VALUE")
    private String salt;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        super.configure(configs, isKey);
        secret = (String) configs.get(AES_SECRET_KEY);
        if (secret == null) {
            throw new SerializationException(AES_SECRET_KEY + " cannot be null.");
        }

        salt = (String) configs.get(AES_SALT_KEY);
        if (salt == null) {
            throw new SerializationException(AES_SALT_KEY + " cannot be null.");
        }
    }

    @Override
    public byte[] serialize(String topic, T data) {
        byte[] json = super.serialize(topic, data);
        return AES.encrypt(json, secret, salt);
    }
}