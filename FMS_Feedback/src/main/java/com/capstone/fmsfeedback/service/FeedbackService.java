package com.capstone.fmsfeedback.service;

import com.capstone.fmsfeedback.dto.FeedbackQuestionsResponseDTO;
import com.capstone.fmsfeedback.entity.Feedback;
import com.capstone.fmsfeedback.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    DatabaseClient databaseClient;

    public Flux<Feedback> saveFeedback(List<Feedback> feedbackList) {
         return feedbackRepository.saveAll(feedbackList);
    }

    public Flux<FeedbackQuestionsResponseDTO> getFeedbackQuestions(String feedbackType) {

        Flux<FeedbackQuestionsResponseDTO> response = databaseClient.execute().sql(
                "select q.questionid, q.questiondescription, q.answertype, a.answerid, a.answertext from question q left join answer a on q.questionid=a.questionid where q.feedbacktype = :feedbackType")
                .bind("feedbackType", feedbackType).as(FeedbackQuestionsResponseDTO.class).fetch().all();
        return response;
    }

}
