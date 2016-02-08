package com.to.papa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class WebController {

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/test")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "test");
        return "welcome";
    }


}
