package com.capstone.fmsfeedback.controller;

import com.capstone.fmsfeedback.dto.FeedbackQuestionsResponseDTO;

import com.capstone.fmsfeedback.entity.Feedback;
import com.capstone.fmsfeedback.repository.FeedbackRepository;
import com.capstone.fmsfeedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/feedback/{feedbackType}")
    public Flux<FeedbackQuestionsResponseDTO> getFeedbackQuestions(@PathVariable String feedbackType) {
        return feedbackService.getFeedbackQuestions(feedbackType);
    }

    @PostMapping("/feedback")
    public ResponseEntity<Flux<Feedback>> saveFeedBack(@RequestBody List<Feedback> feedbackList) {
        Flux<Feedback> response = feedbackService.saveFeedback(feedbackList);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
