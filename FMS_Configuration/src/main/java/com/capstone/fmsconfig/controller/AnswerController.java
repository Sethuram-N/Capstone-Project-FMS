package com.capstone.fmsconfig.controller;

import com.capstone.fmsconfig.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @DeleteMapping("/answer/{id}")
    public Mono<Void> deleteAnswer(Integer id) {
            return answerService.deleteAnswerById(id);
    }
}
