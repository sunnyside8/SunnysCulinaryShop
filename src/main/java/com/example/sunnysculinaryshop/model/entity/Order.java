package com.example.sunnysculinaryshop.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @ManyToMany
    private List<Meal> meals;

    @ManyToOne
    private User user;

    private BigDecimal sum;

    @Column(name = "is_finished")
    boolean isFinished;

    public Order() {
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public Order setMeals(List<Meal> meals) {
        this.meals = meals;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public int getSum() {
        return this.meals.stream().map(Meal::getPrice)
                .map(BigDecimal::intValue).
                reduce(0, Integer::sum);
    }

}
