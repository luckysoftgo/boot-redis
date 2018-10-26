package com.application.boot.controller;

import com.application.boot.redis.jedis.factory.JedisSimpleSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc redis 集群测试.
 * @author 孤狼
 * @url http://localhost:8080/redistest/redis/testdata
 */
@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private JedisSimpleSessionFactory factory;

    /**
     * 通过主键获得对象.
     */
    @RequestMapping(value = "/testdata")
    public void testdata() {
        String key = "data";
        String value = "test-";
        for (int i=0; i<1000;i++){
            factory.getRedisSession().setData(key,value+i);
            String tmpvalue = factory.getRedisSession().getData(key);
            System.out.println(tmpvalue );
        }
        value = factory.getRedisSession().getData(key);
        factory.getRedisSession().setData(key,"123456789");
        value = factory.getRedisSession().getData(key);
        System.out.println("value = " + value );
        factory.getRedisSession().setData(key,"123456789");
    }
}