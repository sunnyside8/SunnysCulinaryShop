package com.example.sunnysculinaryshop.service;

import com.example.sunnysculinaryshop.model.entity.Meal;
import com.example.sunnysculinaryshop.model.entity.Stat;
import com.example.sunnysculinaryshop.model.entity.User;
import com.example.sunnysculinaryshop.model.service.StatServiceModel;
import com.example.sunnysculinaryshop.repository.StatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatService {


    private final StatRepository statRepository;
    private final UserService userService;
    private final MealService mealService;
    private final ModelMapper modelMapper;


    public StatService(StatRepository statRepository, UserService userService, MealService mealService, ModelMapper modelMapper) {
        this.statRepository = statRepository;
        this.userService = userService;
        this.mealService = mealService;
        this.modelMapper = modelMapper;
    }

    public void createLog(Long mealId) {
        Meal meal = mealService.getMealById(mealId);

        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        String username = authentication.getName();

        User user = userService.getUserByUsername(username);

        Stat stat = new Stat().setMeal(meal).setUser(user).setDateTime(LocalDateTime.now());

        statRepository.save(stat);
    }

    public List<StatServiceModel> findAllStats() {
        return statRepository.findAll()
                .stream()
                .map(stat ->{
                    StatServiceModel statServiceModel = modelMapper
                            .map(stat,StatServiceModel.class);
                        statServiceModel.setUser(
                                stat.getUser() == null
                                        ? "Anonymous"
                                        : stat.getUser().getUsername());
                    statServiceModel.setMeal(stat.getMeal().getName());
                    return statServiceModel;
                })
                .collect(Collectors.toList());
    }
}
