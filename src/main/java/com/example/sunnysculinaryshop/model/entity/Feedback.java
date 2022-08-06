package com.example.sunnysculinaryshop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "feedbacks")
public class Feedback extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String message;

    public Feedback() {
    }

    public String getName() {
        return name;
    }

    public Feedback setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Feedback setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Feedback setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Feedback setMessage(String message) {
        this.message = message;
        return this;
    }
}
