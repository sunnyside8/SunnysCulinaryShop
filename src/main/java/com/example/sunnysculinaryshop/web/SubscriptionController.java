package com.example.sunnysculinaryshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SubscriptionController {

    @GetMapping("/subscriptions")
    private String subscription(){
        return "subscription";
    }


}
