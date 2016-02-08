package com.to.papa.web;

import com.to.papa.db.RedisConnector;
import com.to.papa.pojo.RequestMessage;
import com.to.papa.pojo.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WebSocketController {

    @Autowired
    RedisConnector redisConnector;

    @MessageMapping("/stomp")
    @SendTo("/topic/messages")
    public ResponseMessage postMessage(RequestMessage requestMessage) throws Exception {

        String message = requestMessage.getMessage();
        redisConnector.insert(message);

        List<String> latest = redisConnector.fetchRange(0,0);
        message = latest.get(0);

        Thread.sleep(200); // simulated delay
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(message);
        return responseMessage;
    }
}
