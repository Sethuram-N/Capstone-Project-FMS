package com.capstone.fmsconfig.controller;

import com.capstone.fmsconfig.dto.EditQuestionRequestDTO;
import com.capstone.fmsconfig.dto.QuestionDTO;
import com.capstone.fmsconfig.dto.QuestionRequestDTO;
import com.capstone.fmsconfig.dto.QuestionResponseDTO;
import com.capstone.fmsconfig.entity.Question;
import com.capstone.fmsconfig.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.CorePublisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping("/question")
    public ResponseEntity<Mono<Void>> createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO) {
        Mono<Void> response = questionService.createQuestion(questionRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/question")
    public Flux<QuestionResponseDTO> getQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/question/{questionId}")
    public Flux<QuestionDTO> getQuestionById(@PathVariable Integer questionId) {
        return questionService.getQuestionById(questionId);
    }

    @PutMapping("/question")
    public Mono<Question> editQuestion(@RequestBody EditQuestionRequestDTO editQuestionRequestDTO) {
        return questionService.editQuestion(editQuestionRequestDTO);
    }
    @DeleteMapping("/question/{questionId}")
    public Mono<Void> deleteByQuestionId(@PathVariable Integer questionId) {
        return questionService.deleteQuestionById(questionId);
    }

}
