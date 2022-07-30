package com.example.sunnysculinaryshop.web;


import com.example.sunnysculinaryshop.model.binding.AddressBindingModel;
import com.example.sunnysculinaryshop.model.binding.UserRegisterBindingModel;
import com.example.sunnysculinaryshop.model.entity.Address;
import com.example.sunnysculinaryshop.model.entity.Meal;
import com.example.sunnysculinaryshop.model.user.ShopUserDetails;
import com.example.sunnysculinaryshop.service.AddressService;
import com.example.sunnysculinaryshop.service.MealService;
import com.example.sunnysculinaryshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final AddressService addressService;
    private final ModelMapper modelMapper;
    private final MealService mealService;

    public UserController(UserService userService, AddressService addressService, ModelMapper modelMapper, MealService mealService) {
        this.userService = userService;
        this.addressService = addressService;
        this.modelMapper = modelMapper;
        this.mealService = mealService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(
            @Valid UserRegisterBindingModel userRegisterBindingModel,
            @Valid AddressBindingModel addressBindingModel,
            BindingResult bindingResult, RedirectAttributes redirectAttributes,
            BindingResult bindingResultAddress, RedirectAttributes redirectAttributesAddress) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        if (bindingResultAddress.hasErrors()) {
            redirectAttributesAddress.addFlashAttribute("addressBindingModel", addressBindingModel);
            redirectAttributesAddress.addFlashAttribute("org.springframework.validation.BindingResult.addressBindingModel", bindingResultAddress);
            return "redirect:register";
        }

        Address address = addressService.addNewAddress(addressBindingModel);
        userService.saveUser(userRegisterBindingModel,address);

        return "redirect:login";
    }


    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/order")
    public String order(Model model,@AuthenticationPrincipal ShopUserDetails userDetails){
        List<Meal> mealsByUser = userService.getAllMealsByUser(userDetails.getUsername());
        model.addAttribute("order",mealsByUser);
        model.addAttribute("totalPrice",mealsByUser.stream().map(Meal::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        return "order";
    }


    @GetMapping("/clear-cart")
    public String clearCart(@AuthenticationPrincipal ShopUserDetails userDetails) {
        userService.clearCartByUserUsername(userDetails.getUsername());
        return "redirect:/";
    }


    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public AddressBindingModel addressBindingModel() {
        return new AddressBindingModel();
    }

}
