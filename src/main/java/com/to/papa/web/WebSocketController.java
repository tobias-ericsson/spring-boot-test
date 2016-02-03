package com.to.papa.web;

import com.to.papa.pojo.RequestMessage;
import com.to.papa.pojo.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/stomp")
    @SendTo("/topic/greetings")
    public ResponseMessage greeting(RequestMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Hello, " + message.getMessage() + "!");
        return responseMessage;
    }
}
