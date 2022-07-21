package com.example.sunnysculinaryshop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ingredients")
public class Ingredient extends BaseEntity {

    private String name;

    @Column(name = "is_organic")
    private boolean isOrganic;

    public Ingredient() {
    }

    public String getName() {
        return name;
    }

    public Ingredient setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isOrganic() {
        return isOrganic;
    }

    public Ingredient setOrganic(boolean organic) {
        isOrganic = organic;
        return this;
    }
}
