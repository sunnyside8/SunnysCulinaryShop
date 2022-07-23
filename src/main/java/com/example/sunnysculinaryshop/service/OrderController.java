package com.example.sunnysculinaryshop.service;

import com.example.sunnysculinaryshop.model.service.UserWithOrderAndAddressService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;

public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, UserService userService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    public String order(@AuthenticationPrincipal UserDetails userDetails,
                        Model model) {
        UserWithOrderAndAddressService userWithOrderAndAddress = modelMapper.map(userService.findByUsername(userDetails.getUsername()),UserWithOrderAndAddressService.class);

        if (userWithOrderAndAddress.getOrder().getMeals().isEmpty()){
            //TODO implement empty basket page
        }
        return "order";
    }
}
