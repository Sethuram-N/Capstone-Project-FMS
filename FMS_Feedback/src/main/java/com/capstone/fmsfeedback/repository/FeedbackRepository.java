package com.capstone.fmsfeedback.repository;

import com.capstone.fmsfeedback.entity.Feedback;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends ReactiveCrudRepository<Feedback, Integer> {
}
