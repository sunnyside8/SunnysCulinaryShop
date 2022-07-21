package com.example.sunnysculinaryshop.service;

import com.example.sunnysculinaryshop.model.entity.Role;
import com.example.sunnysculinaryshop.model.entity.User;
import com.example.sunnysculinaryshop.model.user.ShopUserDetails;
import com.example.sunnysculinaryshop.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class ShopUsersDeteilsService implements UserDetailsService {
    private final UserRepository userRepository;

    public ShopUsersDeteilsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return userRepository.
                findByUsername(username).
                map(this::map).
                orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));
    }

    private UserDetails map(User userEntity) {

        return new ShopUserDetails(
                userEntity.getId(),
                userEntity.getPassword(),
                userEntity.getUsername(),
                userEntity.getFullName(),
                userEntity.getEmail(),
                userEntity.
                        getRoles().
                        stream().
                        map(this::map).
                        toList());
    }

    private GrantedAuthority map(Role userRole) {
        return new SimpleGrantedAuthority("ROLE_" +
                userRole.
                        getRole().name());
    }
}
