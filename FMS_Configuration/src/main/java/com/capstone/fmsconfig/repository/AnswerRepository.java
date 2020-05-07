package com.capstone.fmsconfig.repository;

import com.capstone.fmsconfig.entity.Answer;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AnswerRepository extends ReactiveCrudRepository<Answer, Integer> {

    @Query("DELETE FROM Answer WHERE QuestionID = :questionId")
    public Mono<Integer> deleteByQuestionId(Integer questionId);
}
