package com.nero.redispubsub.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPubSub;

/**
 * @author Nero
 * @since 2020-01-09 17:20
 */
@Service
public class RedisSubcriber extends JedisPubSub{

    private static final Logger logger = LoggerFactory.getLogger(RedisSubcriber.class);

    @Override
    public void onMessage(String channel, String message) {
        logger.info("channel: {}, received message: {}", channel, message);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        logger.info("onUnsubscribe: {},subscribedChannels: {}", channel, subscribedChannels);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        logger.info("onSubscribe: {},subscribedChannels: {}", channel, subscribedChannels);
    }
}
