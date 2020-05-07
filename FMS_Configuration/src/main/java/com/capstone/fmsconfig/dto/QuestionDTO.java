package com.capstone.fmsconfig.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private Integer questionId;
    private String questionDescription;
    private String feedbackType;
    private String answerType;
    private Integer answerId;
    private String answerText;
}
