package com.example.sunnysculinaryshop.web;


import com.example.sunnysculinaryshop.model.binding.AddressBindingModel;
import com.example.sunnysculinaryshop.model.binding.UserLoginBindingModel;
import com.example.sunnysculinaryshop.model.binding.UserRegisterBindingModel;
import com.example.sunnysculinaryshop.model.entity.Address;
import com.example.sunnysculinaryshop.model.service.UserServiceModel;
import com.example.sunnysculinaryshop.service.AddressService;
import com.example.sunnysculinaryshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final AddressService addressService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, AddressService addressService, ModelMapper modelMapper) {
        this.userService = userService;
        this.addressService = addressService;
        this.modelMapper = modelMapper;
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



    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public AddressBindingModel addressBindingModel() {
        return new AddressBindingModel();
    }

}
