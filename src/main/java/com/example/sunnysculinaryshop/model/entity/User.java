package com.example.sunnysculinaryshop.model.entity;

import com.example.sunnysculinaryshop.model.entity.enums.SubscriptionEnum;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "full_name")
    private String fullName;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;

    @OneToOne
    private Order order;

    private SubscriptionEnum subscription;

    @OneToOne
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User() {
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public SubscriptionEnum getSubscription() {
        return subscription;
    }

    public User setSubscription(SubscriptionEnum subscription) {
        this.subscription = subscription;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public User setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public User setOrder(Order order) {
        this.order = order;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(fullName, user.fullName) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, username, password, email);
    }
}
