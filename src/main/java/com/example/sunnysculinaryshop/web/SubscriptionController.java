package com.example.sunnysculinaryshop.web;

import com.example.sunnysculinaryshop.model.entity.enums.SubscriptionEnum;
import com.example.sunnysculinaryshop.model.user.ShopUserDetails;
import com.example.sunnysculinaryshop.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubscriptionController {

    private final UserService userService;

    public SubscriptionController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/subscriptions")
    private String subscription(){
        return "subscription";
    }


    @PostMapping("/subscriptions/{type}")
    private String addSubscriptions(@PathVariable String type,@AuthenticationPrincipal ShopUserDetails userDetails){
        userService.switchTypeOfSubscription(userDetails.getUsername(),SubscriptionEnum.valueOf(type));
        System.out.println();
        return "subscription";
    }


}
