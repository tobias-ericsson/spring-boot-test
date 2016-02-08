package com.to.papa.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tobias on 2016-02-08.
 */
@Service
public class RedisConnector {

    private static String LIST_NAME = "messages";

    @Autowired
    private StringRedisTemplate template;

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps;

    public void insert(String message) {
        listOps.leftPush(LIST_NAME, message);
    }

    public List<String> fetchLatest(int size) {
        return listOps.range(LIST_NAME, 0, size);
    }
}
