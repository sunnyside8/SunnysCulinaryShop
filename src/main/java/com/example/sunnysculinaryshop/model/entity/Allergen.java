package com.example.sunnysculinaryshop.model.entity;

import com.example.sunnysculinaryshop.model.entity.enums.AllergenEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "allergens")
public class Allergen extends BaseEntity{



    @Enumerated(EnumType.STRING)
    private AllergenEnum allergen;

    public Allergen() {
    }

    public AllergenEnum getAllergen() {
        return allergen;
    }

    public Allergen setAllergen(AllergenEnum allergen) {
        this.allergen = allergen;
        return this;
    }
}
