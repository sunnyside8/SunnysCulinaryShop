package com.example.sunnysculinaryshop.repository;

import com.example.sunnysculinaryshop.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {


}
