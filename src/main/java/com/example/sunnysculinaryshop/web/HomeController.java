package com.example.sunnysculinaryshop.web;

import com.example.sunnysculinaryshop.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final MealService mealService;

    public HomeController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public String index(Model model){

        model.addAttribute("randomMeals",mealService.getThreeRandomMeals());
        System.out.println();
        return "index";
    }

    @GetMapping("/contacts")
    public String contactForm(){
        return "contact";
    }



}
