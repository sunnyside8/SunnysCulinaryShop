package com.example.sunnysculinaryshop.web;

import com.example.sunnysculinaryshop.model.entity.Meal;
import com.example.sunnysculinaryshop.model.user.ShopUserDetails;
import com.example.sunnysculinaryshop.service.MealService;
import com.example.sunnysculinaryshop.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;
@Controller
public class OrdersController {
        private final UserService userService;
        private final MealService mealService;

    public OrdersController(UserService userService, MealService mealService) {
        this.userService = userService;
        this.mealService = mealService;
    }

    @GetMapping("/order")
    public String order(Model model, @AuthenticationPrincipal ShopUserDetails userDetails){
        List<Meal> mealsByUser = userService.getAllMealsByUser(userDetails.getUsername());
        model.addAttribute("order",mealsByUser);
        BigDecimal price = mealsByUser.stream().map(Meal::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("totalPrice",price);
        price = price.add(BigDecimal.TEN);
        model.addAttribute("totalPriceWithShipping",price);
        return "order";
    }

    @GetMapping("remove-meal/{id}")
    public String removeMeal(@PathVariable Long id, @AuthenticationPrincipal ShopUserDetails userDetails){
        Meal meal = mealService.getMealById(id);
        userService.removeMealFromUser(meal,userDetails.getUsername());
        return "redirect:/users/order";
    }

    @PostMapping("/order")
    public String orderDone(@AuthenticationPrincipal ShopUserDetails userDetails){
        userService.clearCartByUserUsername(userDetails.getUsername());
        return "redirect:/done";
    }

//    @GetMapping("/clear-cart")
//    public String clearCart(@AuthenticationPrincipal ShopUserDetails userDetails) {
//        userService.clearCartByUserUsername(userDetails.getUsername());
//        return "redirect:/";
//    }

    @GetMapping("/done")
    public String done(){
        return "done";
    }


    @GetMapping("/subscription")
    public String subscription(){
        return "subscription";
    }

    @PostMapping("/subscription")
    public String addSubscription(){
        return "redirect:/";
    }

}
