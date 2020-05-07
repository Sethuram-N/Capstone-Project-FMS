package com.capstone.fmsconfig.service;

import com.capstone.fmsconfig.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;

    public Mono<Void> deleteAnswerById(Integer answerId) {
        return answerRepository.deleteById(answerId);
    }
}
