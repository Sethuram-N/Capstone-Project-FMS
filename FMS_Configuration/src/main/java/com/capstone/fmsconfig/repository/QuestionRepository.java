package com.capstone.fmsconfig.repository;

import com.capstone.fmsconfig.entity.Question;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends ReactiveCrudRepository<Question, Integer> {
}
