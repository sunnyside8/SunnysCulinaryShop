package com.example.sunnysculinaryshop.model.service;

import com.example.sunnysculinaryshop.model.entity.Address;
import com.example.sunnysculinaryshop.model.entity.Order;

public class UserWithOrderAndAddressService {

    private Long id;
    private Address address;
    private Order order;
    private String username;
    private String email;

    public Long getId() {
        return id;
    }

    public UserWithOrderAndAddressService setId(Long id) {
        this.id = id;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public UserWithOrderAndAddressService setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public UserWithOrderAndAddressService setOrder(Order order) {
        this.order = order;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserWithOrderAndAddressService setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserWithOrderAndAddressService setEmail(String email) {
        this.email = email;
        return this;
    }
}
