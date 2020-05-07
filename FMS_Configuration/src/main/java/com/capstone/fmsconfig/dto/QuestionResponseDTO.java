package com.capstone.fmsconfig.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDTO {

    private Integer questionId;
    private String questionDescription;
    private Integer totalAnswers;
    private String feedbackType;
}
