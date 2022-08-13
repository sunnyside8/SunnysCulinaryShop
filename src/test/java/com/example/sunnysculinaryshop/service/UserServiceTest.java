package com.example.sunnysculinaryshop.service;

import com.example.sunnysculinaryshop.model.entity.Address;
import com.example.sunnysculinaryshop.model.entity.Meal;
import com.example.sunnysculinaryshop.model.entity.User;
import com.example.sunnysculinaryshop.model.entity.enums.SubscriptionEnum;
import com.example.sunnysculinaryshop.repository.RoleRepository;
import com.example.sunnysculinaryshop.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    ModelMapper modelMapper;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    RoleRepository repository;

    @Mock
    UserDetailsService userDetailsService;

    @Mock
    MealService mealService;


    @InjectMocks
    UserService userService;

    private User user;

    @BeforeEach
    void setMockOutput() {
        user = new User();
    }

    @Test
    void getUserByUsername_name() {
        when(userRepository.findByUsername("Name")).thenReturn(Optional.of(user));
        User userByName = userService.getUserByUsername("Name");

        assertEquals(userByName,user);
    }


    @Test
    void clearCartByUserUsername() {
        user.setOrder(List.of(new Meal()));
        when(userRepository.findByUsername("Name")).thenReturn(Optional.of(user));
        userService.clearCartByUserUsername("Name");
        assertEquals(user.getOrder().size(),0);
    }


    @Test
    void save() {
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userService.save(user));
    }

    @Test
    void addMealToUser() {
        user.setOrder(new ArrayList<>());
        when(userRepository.findByUsername("Name")).thenReturn(Optional.of(user));
        Meal meal = new Meal();
        when(mealService.getMealById(1L)).thenReturn(meal);

        assertTrue(userService.addMealToUser(1L,"Name"));
    }

    @Test
    void getAllMealsByUser_1() {
        user.setOrder(List.of(new Meal()));
        when(userRepository.findByUsername("Name")).thenReturn(Optional.of(user));

        assertEquals(userService.getUserByUsername("Name").getOrder().size(),1);
    }

    @Test
    void getAllMealsByUser_0() {
        user.setOrder(new ArrayList<>());
        when(userRepository.findByUsername("Name")).thenReturn(Optional.of(user));

        assertEquals(userService.getUserByUsername("Name").getOrder().size(),0);
    }


    @Test
    void switchTypeOfSubscription() {
        user.setSubscription(SubscriptionEnum.Start);
        when(userRepository.findByUsername("Name")).thenReturn(Optional.of(user));

        userService.switchTypeOfSubscription("Name",SubscriptionEnum.Extra);

        assertEquals(user.getSubscription(),SubscriptionEnum.Extra);

    }
}