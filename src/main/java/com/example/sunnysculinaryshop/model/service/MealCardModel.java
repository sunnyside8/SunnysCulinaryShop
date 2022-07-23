package com.example.sunnysculinaryshop.model.service;

import javax.persistence.Column;
import java.math.BigDecimal;

public class MealCardModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private String photo;

    public Long getId() {
        return id;
    }

    public MealCardModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MealCardModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public MealCardModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public MealCardModel setPhoto(String photo) {
        this.photo = photo;
        return this;
    }
}
