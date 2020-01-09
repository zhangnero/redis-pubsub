package com.nero.redispubsub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Nero
 * @since 2020-01-09 17:06
 */
@Configuration
public class RedisConfig {

    @Bean
    public JedisPool jedisPool(){

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxWaitMillis(10 * 1000);
        jedisPoolConfig.setMinIdle(5);
        jedisPoolConfig.setMinIdle(10);


        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 1000, "123456");

        return jedisPool;
    }
}
