package com.example.sunnysculinaryshop.model.service;

import com.example.sunnysculinaryshop.model.entity.Meal;
import com.example.sunnysculinaryshop.model.entity.User;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class StatServiceModel {

    private Long id;
    private String user;
    private String meal;
    private LocalDateTime dateTime;


    public StatServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public StatServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUser() {
        return user;
    }

    public StatServiceModel setUser(String user) {
        this.user = user;
        return this;
    }

    public String getMeal() {
        return meal;
    }

    public StatServiceModel setMeal(String meal) {
        this.meal = meal;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public StatServiceModel setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
