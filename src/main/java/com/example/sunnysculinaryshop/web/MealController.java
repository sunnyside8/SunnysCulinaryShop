package com.example.sunnysculinaryshop.web;

import com.example.sunnysculinaryshop.model.entity.enums.MealTypeEnum;
import com.example.sunnysculinaryshop.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/meals")
@Controller
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }


    @GetMapping("/all")
    public String mealPage(Model model){
        model.addAttribute("starters",mealService.getAllMealsByType(MealTypeEnum.Starter));
        model.addAttribute("main",mealService.getAllMealsByType(MealTypeEnum.Main));
        model.addAttribute("desserts",mealService.getAllMealsByType(MealTypeEnum.Dessert));
        System.out.println();
        return "all-meals";
    }


    @GetMapping("/{id}")
    public String mealPage(@PathVariable Long id, Model model){
//        model.addAttribute();
//        System.out.println();
        return "meal-page";
    }
}
