package com.tejas.springtut;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {

    @RequestMapping("/")
    public String firstHandler(){
        return "Spring-Boot Project";
    }
    
}
