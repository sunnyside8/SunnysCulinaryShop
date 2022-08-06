package com.example.sunnysculinaryshop.web;

import com.example.sunnysculinaryshop.service.StatService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticController {

    private final StatService statService;


    public StatisticController(StatService statService) {
        this.statService = statService;
    }

    @GetMapping("/statistic")
    public String showStatistic(Model model){
        model.addAttribute("stats",
                statService.findAllStats());
        return "statistic";
    }

}
