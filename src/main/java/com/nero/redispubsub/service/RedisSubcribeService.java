package com.nero.redispubsub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import javax.annotation.PostConstruct;

/**
 * @author Nero
 * @since 2020-01-09 17:31
 */
@Service
public class RedisSubcribeService {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private JedisPubSub jedisPubSub;

    @PostConstruct
    public void init(){

        Runnable runnable = ()->{

            Jedis jedis = jedisPool.getResource();
            jedis.subscribe(jedisPubSub, "channelOne", "channelTwo");
            jedis.close();
        };

        new Thread(runnable).start();

        Runnable runnable1 = ()->{

            Jedis jedis = jedisPool.getResource();
            jedis.subscribe(jedisPubSub, "channelOne", "channelTwo");
            jedis.close();
        };

        new Thread(runnable).start();

    }
}
