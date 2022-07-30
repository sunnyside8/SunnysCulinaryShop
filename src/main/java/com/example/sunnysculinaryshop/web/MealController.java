package com.example.sunnysculinaryshop.web;

import com.example.sunnysculinaryshop.model.entity.enums.MealTypeEnum;
import com.example.sunnysculinaryshop.model.user.ShopUserDetails;
import com.example.sunnysculinaryshop.service.MealService;
import com.example.sunnysculinaryshop.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/meals")
@Controller
public class MealController {

    private final MealService mealService;
    private final UserService userService;

    public MealController(MealService mealService, UserService userService) {
        this.mealService = mealService;
        this.userService = userService;
    }


    @GetMapping("/all")
    public String mealPage(Model model) {
        model.addAttribute("starters", mealService.getAllMealsByType(MealTypeEnum.Starter));
        model.addAttribute("main", mealService.getAllMealsByType(MealTypeEnum.Main));
        model.addAttribute("desserts", mealService.getAllMealsByType(MealTypeEnum.Dessert));
        System.out.println();
        return "all-meals";
    }


    @GetMapping("/{id}")
    public String mealPage(@PathVariable Long id, Model model,
                           @AuthenticationPrincipal ShopUserDetails userDetails) {
        model.addAttribute("meal", mealService.getMealFullViewById(id));
        return "meal-page";
    }


    @GetMapping("/add/{id}")
    public String addMealToOrder(@PathVariable Long id,
                                 @AuthenticationPrincipal ShopUserDetails userDetails) {
        System.out.println();
        userService.addMealToUser(id, userDetails.getUsername());
        return "redirect:/{id}";
    }



    @GetMapping("/desserts")
    public String dessertsPage(Model model) {
        model.addAttribute("desserts", mealService.getAllMealsByType(MealTypeEnum.Dessert));
        return "desserts";
    }

    @GetMapping("/starters")
    public String startersPage(Model model) {
        model.addAttribute("starters", mealService.getAllMealsByType(MealTypeEnum.Starter));
        return "starters";
    }


    @GetMapping("/mains")
    public String mainsPage(Model model) {
        model.addAttribute("mains", mealService.getAllMealsByType(MealTypeEnum.Main));
        return "mains";
    }


}
