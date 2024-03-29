package com.example.sunnysculinaryshop.repository;

import com.example.sunnysculinaryshop.model.entity.Meal;
import com.example.sunnysculinaryshop.model.entity.User;
import com.example.sunnysculinaryshop.model.entity.enums.MealTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal,Long> {

    Meal getMealById(Long id);

    List<Meal> getAllByMealType(MealTypeEnum mealType);


}
