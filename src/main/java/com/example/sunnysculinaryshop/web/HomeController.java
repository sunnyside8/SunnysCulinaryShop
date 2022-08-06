package com.example.sunnysculinaryshop.web;

import ch.qos.logback.core.util.FixedDelay;
import com.example.sunnysculinaryshop.model.entity.Meal;
import com.example.sunnysculinaryshop.service.MealService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class HomeController {

    private final MealService mealService;

    public HomeController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("randomMeals", getThreeRandomMealsEveryWorkDay());
        System.out.println();
        return "index";
    }

   // @Scheduled(cron = "43 3 * * * *")
    @Scheduled(fixedDelay = 1000)
    private Set<Meal> getThreeRandomMealsEveryWorkDay() {
        return mealService.getThreeRandomMeals();
    }


}

