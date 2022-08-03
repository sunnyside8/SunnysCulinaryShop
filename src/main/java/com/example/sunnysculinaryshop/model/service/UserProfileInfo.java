package com.example.sunnysculinaryshop.model.service;

import com.example.sunnysculinaryshop.model.entity.enums.SubscriptionEnum;

public class UserProfileInfo {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String fullName;

    private SubscriptionEnum subscriptionEnum;

    public Long getId() {
        return id;
    }

    public UserProfileInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserProfileInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserProfileInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserProfileInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserProfileInfo setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public SubscriptionEnum getSubscriptionEnum() {
        return subscriptionEnum;
    }

    public UserProfileInfo setSubscriptionEnum(SubscriptionEnum subscriptionEnum) {
        this.subscriptionEnum = subscriptionEnum;
        return this;
    }
}
