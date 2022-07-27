package com.example.sunnysculinaryshop.repository;

import com.example.sunnysculinaryshop.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    Optional<Order> findByUser_Username(String user_username);
}
