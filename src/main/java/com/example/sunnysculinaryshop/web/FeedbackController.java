package com.example.sunnysculinaryshop.web;

import com.example.sunnysculinaryshop.model.binding.FeedbackBindingModel;
import com.example.sunnysculinaryshop.service.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/contacts")
    public String contactForm(){
        return "contact";
    }

    @PostMapping("/contacts")
    public String receiveContacts(@Valid FeedbackBindingModel feedbackBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors() ){
            redirectAttributes.addFlashAttribute("feedbackBindingModel", feedbackBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.feedbackBindingModel", bindingResult);
            return "redirect:contacts";
        }

        feedbackService.saveFeedback(feedbackBindingModel);
        return "redirect:/";
    }

    @ModelAttribute
    private FeedbackBindingModel feedbackBindingModel(){
        return new FeedbackBindingModel();
    }
}
