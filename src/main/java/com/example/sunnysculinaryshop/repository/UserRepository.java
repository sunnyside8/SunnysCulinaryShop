package com.example.sunnysculinaryshop.repository;

import com.example.sunnysculinaryshop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findAllByUsernameAndPassword(String username, String password);
}
