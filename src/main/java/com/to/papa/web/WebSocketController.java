package com.to.papa.web;

import com.to.papa.db.RedisConnector;
import com.to.papa.pojo.RequestMessage;
import com.to.papa.pojo.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WebSocketController {

    private static final Logger logger = LoggerFactory
			.getLogger(WebSocketController.class);

    @Autowired
    RedisConnector redisConnector;

    @Autowired
    CounterService counterService;

    @MessageMapping("/stomp")
    @SendTo("/topic/messages")
    public ResponseMessage postMessage(RequestMessage requestMessage) throws Exception {

        String message = requestMessage.getMessage();
        redisConnector.insert(message);

        List<String> latest = redisConnector.fetchRange(0,0);
        message = latest.get(0);

        logger.info(message);

        counterService.increment("services.webSocketController.postMessage.invoked");

        Thread.sleep(200); // simulated delay
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(message);
        return responseMessage;
    }
}
