package com.to.papa;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class Start {

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

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Start.class, args);
    }

}
