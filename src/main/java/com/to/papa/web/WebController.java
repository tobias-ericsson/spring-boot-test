package com.to.papa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
public class WebController {

    @RequestMapping("/")
    String home() {
        return "index";
    }

    @RequestMapping("/test")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "test");
        return "welcome";
    }

    @RequestMapping("/logout2")
    public String logout(HttpServletRequest request, Map<String, Object> model) {
        request.getSession(false).invalidate();
        return "index";
    }
}
