package com.example.sunnysculinaryshop.model.binding;

import com.example.sunnysculinaryshop.model.entity.enums.GenderEn;
import com.example.sunnysculinaryshop.model.validation.UniqueUserEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotBlank
    @Size(min = 3,max =30)
    private String username;

    @Email
    @UniqueUserEmail(message = "Email should be unique")
    private String email;

    @NotBlank
    @Size(min = 5,max =20)
    private String password;

    @NotBlank
    @Size(min = 3,max = 50)
    private String fullName;

    @NotBlank
    @Size(min = 5,max =20)
    private String confirmPassword;

    @NotNull
    private GenderEn gender;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public GenderEn getGender() {
        return gender;
    }

    public UserRegisterBindingModel setGender(GenderEn gender) {
        this.gender = gender;
        return this;
    }
}
