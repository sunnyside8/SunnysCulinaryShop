package com.example.sunnysculinaryshop.web;

import com.example.sunnysculinaryshop.model.entity.User;
import com.example.sunnysculinaryshop.service.OrderService;
import com.example.sunnysculinaryshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, UserService userService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/orders")
    public String order(@AuthenticationPrincipal UserDetails userDetails,
                        Model model) {
        User user = userService.getUserByUsername(userDetails.getUsername());
        if (user.getOrder().getMeals().isEmpty()){
            //TODO implement empty basket page
        }
        model.addAttribute("basket",orderService.getOrderByUserConvertedToMap(userDetails.getUsername()));


        return "order";
    }
}
