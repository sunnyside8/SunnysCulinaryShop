package com.example.sunnysculinaryshop.repository;

import com.example.sunnysculinaryshop.model.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends JpaRepository<Stat,Long> {
}
