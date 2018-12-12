package com.blueribbon.commons.verticles;

public class KafkaStringSenderVerticle extends KafkaSenderVerticle<String> {

    @Override
    protected String getMessage(String message) {
        return message;
    }
}
