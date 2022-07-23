package com.example.sunnysculinaryshop.model.service;

import com.example.sunnysculinaryshop.model.entity.Allergen;
import com.example.sunnysculinaryshop.model.entity.Ingredient;
import com.example.sunnysculinaryshop.model.entity.enums.MealTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

public class MealFullViewModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private MealTypeEnum mealType;
    private Set<Allergen> allergens;
    private Set<Ingredient> ingredients;
    private String photo;
    private String description;


    public Long getId() {
        return id;
    }

    public MealFullViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MealFullViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public MealFullViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public MealTypeEnum getMealType() {
        return mealType;
    }

    public MealFullViewModel setMealType(MealTypeEnum mealType) {
        this.mealType = mealType;
        return this;
    }

    public Set<Allergen> getAllergens() {
        return allergens;
    }

    public MealFullViewModel setAllergens(Set<Allergen> allergens) {
        this.allergens = allergens;
        return this;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public MealFullViewModel setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public MealFullViewModel setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MealFullViewModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
