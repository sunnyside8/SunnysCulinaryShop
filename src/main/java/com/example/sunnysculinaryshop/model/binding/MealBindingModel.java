package com.example.sunnysculinaryshop.model.binding;

import com.example.sunnysculinaryshop.model.entity.Allergen;
import com.example.sunnysculinaryshop.model.entity.Ingredient;
import com.example.sunnysculinaryshop.model.entity.enums.MealTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

public class MealBindingModel {

    private String name;

    private BigDecimal price;

    private MealTypeEnum mealType;

    private Set<Allergen> allergens;

    private Set<Ingredient> ingredients;
}
