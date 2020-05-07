package com.capstone.fmsfeedback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackQuestionsResponseDTO {

    private Integer questionId;
    private String questionDescription;
    private Integer answerId;
    private String answerText;
    private String answerType;
}
