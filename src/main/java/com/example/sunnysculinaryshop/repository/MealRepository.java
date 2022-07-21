package com.example.sunnysculinaryshop.repository;

import com.example.sunnysculinaryshop.model.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal,Long> {

    Meal getMealById(Long id);
}
