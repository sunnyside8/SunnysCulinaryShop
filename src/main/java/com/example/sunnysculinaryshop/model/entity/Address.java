package com.example.sunnysculinaryshop.model.entity;

import com.example.sunnysculinaryshop.model.entity.enums.AreaCityEn;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address extends BaseEntity{


    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "area_city")
    private AreaCityEn areaCity;

    @Column(nullable = false)
    private String town;


    @Column(nullable = false)
    private String address;

    @OneToOne(mappedBy = "address")
    private User user;
    public Address() {
    }

    public AreaCityEn getAreaCity() {
        return areaCity;
    }

    public Address setAreaCity(AreaCityEn areaCity) {
        this.areaCity = areaCity;
        return this;
    }

    public String getTown() {
        return town;
    }

    public Address setTown(String town) {
        this.town = town;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Address setAddress(String address) {
        this.address = address;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Address setUser(User user) {
        this.user = user;
        return this;
    }
}
