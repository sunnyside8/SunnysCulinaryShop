package com.example.sunnysculinaryshop.model.binding;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FeedbackBindingModel {

    @NotBlank
    private String name;

    @Email
    private String email;

    private Long phoneNumber;

   @Size(min = 5)
    private String message;

    public String getName() {
        return name;
    }

    public FeedbackBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public FeedbackBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public FeedbackBindingModel setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public FeedbackBindingModel setMessage(String message) {
        this.message = message;
        return this;
    }
}
