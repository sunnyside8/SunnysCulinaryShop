package com.example.sunnysculinaryshop.model.entity;

import com.example.sunnysculinaryshop.model.entity.enums.AllergenEnum;
import com.example.sunnysculinaryshop.model.entity.enums.MealTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "meals")

public class Meal extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MealTypeEnum mealType;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Allergen> allergens;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Ingredient> ingredients;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Lob
    private String photo;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<User> user;

    public Meal() {
    }

    public String getName() {
        return name;
    }

    public Meal setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Meal setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public MealTypeEnum getMealType() {
        return mealType;
    }

    public Meal setMealType(MealTypeEnum mealType) {
        this.mealType = mealType;
        return this;
    }

    public Set<Allergen> getAllergens() {
        return allergens;
    }

    public Meal setAllergens(Set<Allergen> allergens) {
        this.allergens = allergens;
        return this;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public Meal setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public Meal setPhoto(String photo) {
        this.photo = photo;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Objects.equals(name, meal.name) && Objects.equals(price, meal.price) && mealType == meal.mealType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, mealType);
    }

    public String getDescription() {
        return description;
    }

    public Meal setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<User> getUser() {
        return user;
    }

    public Meal setUser(Set<User> user) {
        this.user = user;
        return this;
    }
}
