package com.example.sunnysculinaryshop.service;

import com.example.sunnysculinaryshop.model.binding.UserRegisterBindingModel;
import com.example.sunnysculinaryshop.model.entity.Address;
import com.example.sunnysculinaryshop.model.entity.Role;
import com.example.sunnysculinaryshop.model.entity.User;
import com.example.sunnysculinaryshop.model.entity.enums.RolesNameEnum;
import com.example.sunnysculinaryshop.model.service.UserServiceModel;
import com.example.sunnysculinaryshop.repository.RoleRepository;
import com.example.sunnysculinaryshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository repository;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleRepository repository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }


    public void saveUser(UserRegisterBindingModel userRegisterBindingModel, Address address) {
        User user = modelMapper.map(userRegisterBindingModel,User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAddress(address);

        Role userRole= repository.getRoleByRole(RolesNameEnum.USER);
        user.setRoles(Set.of(userRole));

        userRepository.save(user);

    }

    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return modelMapper.map(this.userRepository.findAllByUsernameAndPassword(username,password).orElse(null),UserServiceModel.class);
    }

    public void loginUser(UserServiceModel userServiceModel) {

        //todo LOGIN
    }
}
