package com.example.sunnysculinaryshop.service;

import com.example.sunnysculinaryshop.model.entity.Meal;
import com.example.sunnysculinaryshop.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class MealService {

    private final MealRepository mealRepository;


    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
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
}
