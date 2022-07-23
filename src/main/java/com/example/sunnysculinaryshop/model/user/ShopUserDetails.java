package com.example.sunnysculinaryshop.model.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class ShopUserDetails implements UserDetails {
    private final Long id;
    private final String password;
    private final String username;
    private final String fullName;
    private final String email;
    private final Collection<GrantedAuthority> authorities;

    public ShopUserDetails(Long id, String password, String username, String fullName, String email, Collection<GrantedAuthority> authorities) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
