package com.example.sunnysculinaryshop.service;

import com.example.sunnysculinaryshop.model.entity.Meal;
import com.example.sunnysculinaryshop.model.entity.enums.MealTypeEnum;
import com.example.sunnysculinaryshop.model.service.MealCardModel;
import com.example.sunnysculinaryshop.model.service.MealFullViewModel;
import com.example.sunnysculinaryshop.repository.MealRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MealService {

    private final MealRepository mealRepository;
    private final ModelMapper modelMapper;


    public MealService(MealRepository mealRepository, ModelMapper modelMapper) {
        this.mealRepository = mealRepository;
        this.modelMapper = modelMapper;
    }

    public Set<Meal> getThreeRandomMeals() {
        Random rand = new Random();

        Set<Meal> randomMeals = new HashSet<>();
        long capacityOfTheRepository = mealRepository.count();

        while (randomMeals.size() < 3) {
            long randomIndex = rand.nextLong(capacityOfTheRepository);
            Meal mealById = mealRepository.getMealById(randomIndex);
            if(mealById == null){
                continue;
            }
            randomMeals.add(mealById);
        }
        return randomMeals;
    }

    public List<MealCardModel> getAllMealsByType(MealTypeEnum mealTypeEnum) {

        return mealRepository.getAllByMealType(mealTypeEnum).stream()
                .map(meal -> modelMapper.map(meal, MealCardModel.class))
                .collect(Collectors.toList());
    }


    public MealFullViewModel getMealById(Long id) {
        MealFullViewModel mealFullViewModel = modelMapper.map(mealRepository.getMealById(id),MealFullViewModel.class);
        return mealFullViewModel;
    }
}
