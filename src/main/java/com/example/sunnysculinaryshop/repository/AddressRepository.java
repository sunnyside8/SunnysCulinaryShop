package com.example.sunnysculinaryshop.repository;

import com.example.sunnysculinaryshop.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

        Address getByUser_Id(Long user_id);
}
