package com.nero.redispubsub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Nero
 * @since 2020-01-09 17:16
 */
@Service
public class RedisPublisher {

    @Autowired
    private JedisPool jedisPool;

    public void redisPublish(String channel, String mesaage){
        Jedis jedis = jedisPool.getResource();
        jedis.publish(channel, mesaage);
        jedis.close();
    }

}
