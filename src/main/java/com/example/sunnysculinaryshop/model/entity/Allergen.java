package com.example.sunnysculinaryshop.model.entity;

import com.example.sunnysculinaryshop.model.entity.enums.AllergenEnum;

import javax.persistence.*;

@Entity
@Table(name = "allergens")
public class Allergen extends BaseEntity{



    @Enumerated(EnumType.STRING)
    private AllergenEnum allergen;

    @Lob
    private String picture;

    public Allergen() {
    }

    public AllergenEnum getAllergen() {
        return allergen;
    }

    public Allergen setAllergen(AllergenEnum allergen) {
        this.allergen = allergen;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public Allergen setPicture(String picture) {
        this.picture = picture;
        return this;
    }
}
