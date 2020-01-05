package com.redis.redis;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.springframework.data.repository.init.ResourceReader.Type.JSON;

@RestController
public class RedisController {
    Jedis jedis = new Jedis("localhost");
    @PostMapping("/redis")
    void redis(@RequestBody Redis redis){
        jedis.set(redis.key, redis.value);
    }
    @GetMapping("/redis")
    Redis redis(@RequestBody  RequestRedis key){
        System.out.println();
        jedis.keys("");
        return new Redis("key",jedis.get(key.key));
    }
    @GetMapping("/redis/all")
    Set<String> redis (){
        ArrayList<Redis> listRedis=null ;
        Set<String> listKey = jedis.keys("*");
        System.out.println(listKey);
        return  jedis.keys("*");
    }

}
