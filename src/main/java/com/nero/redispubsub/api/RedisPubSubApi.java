package com.nero.redispubsub.api;

import com.nero.redispubsub.service.RedisPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nero
 * @since 2020-01-09 17:29
 */
@RestController
@RequestMapping(value = "redispubsubapi")
public class RedisPubSubApi {

    @Autowired
    private RedisPublisher redisPublisher;

    @RequestMapping(value = "publish", method = RequestMethod.GET)
    public void publishMessage(@RequestParam String channel, @RequestParam String message){
        redisPublisher.redisPublish(channel, message);
    }

}
