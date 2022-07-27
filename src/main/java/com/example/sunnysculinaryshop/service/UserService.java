package com.example.sunnysculinaryshop.service;

import com.example.sunnysculinaryshop.model.binding.UserRegisterBindingModel;
import com.example.sunnysculinaryshop.model.entity.Address;
import com.example.sunnysculinaryshop.model.entity.Order;
import com.example.sunnysculinaryshop.model.entity.Role;
import com.example.sunnysculinaryshop.model.entity.User;
import com.example.sunnysculinaryshop.model.entity.enums.RolesNameEnum;
import com.example.sunnysculinaryshop.model.service.UserServiceModel;
import com.example.sunnysculinaryshop.repository.RoleRepository;
import com.example.sunnysculinaryshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository repository;
    private final UserDetailsService userDetailsService;

    public UserService(UserRepository userRepository, OrderService orderService, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleRepository repository, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
        this.userDetailsService = userDetailsService;
    }


    public void saveUser(UserRegisterBindingModel userRegisterBindingModel, Address address) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAddress(address);

        Role userRole = repository.getRoleByRole(RolesNameEnum.USER);
        user.setRoles(Set.of(userRole));

        userRepository.save(user);

    }

    public UserServiceModel findByUsername(String username) {
        return modelMapper.map(getUserByUsername(username), UserServiceModel.class);
    }

    public User getUserByUsername(String username){
        return  this.userRepository.findByUsername(username).orElse(null);
    }


    private void login(User user) {
        UserDetails userDetails =
               userDetailsService.loadUserByUsername(user.getEmail());

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );

        SecurityContextHolder.
                getContext().
                setAuthentication(auth);
    }

    public void clearCartByUserUsername(String username) {
        userRepository.findByUsername(username).get().setOrder(new Order());
    }

    public void save(User user) {
        userRepository.save(user);
    }
}

