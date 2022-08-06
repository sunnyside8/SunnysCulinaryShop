package com.example.sunnysculinaryshop.repository;

import com.example.sunnysculinaryshop.model.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
}
