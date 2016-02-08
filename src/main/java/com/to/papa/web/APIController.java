package com.to.papa.web;

import com.to.papa.db.RedisConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    RedisConnector redisConnector;

    @RequestMapping("/latest/{size}")
    public List<String> latest(@PathVariable Integer size) {
        return redisConnector.fetchRange(0, size);
    }

    @RequestMapping("/all")
    public List<String> all() {
        return redisConnector.fetchRange(0, -1);
    }
}
