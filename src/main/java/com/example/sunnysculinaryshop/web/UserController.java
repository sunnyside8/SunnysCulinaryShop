package com.example.sunnysculinaryshop.web;


import com.example.sunnysculinaryshop.model.binding.AddressBindingModel;
import com.example.sunnysculinaryshop.model.binding.UserRegisterBindingModel;
import com.example.sunnysculinaryshop.model.entity.Address;
import com.example.sunnysculinaryshop.model.entity.Meal;
import com.example.sunnysculinaryshop.model.service.UserProfileInfo;
import com.example.sunnysculinaryshop.model.user.ShopUserDetails;
import com.example.sunnysculinaryshop.service.AddressService;
import com.example.sunnysculinaryshop.service.MealService;
import com.example.sunnysculinaryshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
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

    @GetMapping ("/profile")
    public String profile(){

        return "profile";
    }

    @PostMapping("/profile")
    public String profileFill(Model model, @AuthenticationPrincipal ShopUserDetails userDetails){
        UserProfileInfo map = modelMapper.map(userService.getUserByUsername(userDetails.getUsername()), UserProfileInfo.class);
        model.addAttribute("user",map);
        model.addAttribute("address",addressService.getAddressStringByUserId(userDetails.getId()));
        return "profile";
    }


    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public AddressBindingModel addressBindingModel() {
        return new AddressBindingModel();
    }


    //    @GetMapping("/update")
//    public String changeProfile(@AuthenticationPrincipal ShopUserDetails userDetails,Model model){
//        model.addAttribute("user",
//                modelMapper.map(userService.getUserByUsername(userDetails.getUsername()),UserProfileInfo.class));
//        return "profile-edit";
//    }
//
//    @PatchMapping("/update")
//    public String updateConfirm(Model model){
//        model.addAttribute("changedName",);
//
//        return "redirect:/users/profile";
//    }

}
