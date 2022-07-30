package com.example.sunnysculinaryshop.model.binding;

import com.example.sunnysculinaryshop.model.entity.enums.AreaCityEn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressBindingModel {

    @NotNull
    private AreaCityEn areaCity;

    @NotBlank
    @Size(min = 3,max =20)
    private String town;


    @NotBlank
    @Size(min = 3,max =50)
    private String address;

    public AddressBindingModel() {
    }

    public AreaCityEn getAreaCity() {
        return areaCity;
    }

    public AddressBindingModel setAreaCity(AreaCityEn areaCity) {
        this.areaCity = areaCity;
        return this;
    }

    public String getTown() {
        return town;
    }

    public AddressBindingModel setTown(String town) {
        this.town = town;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AddressBindingModel setAddress(String address) {
        this.address = address;
        return this;
    }
}
