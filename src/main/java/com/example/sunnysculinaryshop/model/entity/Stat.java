package com.example.sunnysculinaryshop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "stats")
public class Stat extends BaseEntity{

    @ManyToOne
    private User user;

    @ManyToOne
    private Meal meal;


    @Column(name = "date_time",nullable = false)
    private LocalDateTime dateTime;

    public Stat() {
    }

    public User getUser() {
        return user;
    }

    public Stat setUser(User user) {
        this.user = user;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Stat setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Meal getMeal() {
        return meal;
    }

    public Stat setMeal(Meal meal) {
        this.meal = meal;
        return this;
    }
}
