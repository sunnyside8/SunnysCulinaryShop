package com.example.sunnysculinaryshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String getOrder(){
        return "order";
    }
}
