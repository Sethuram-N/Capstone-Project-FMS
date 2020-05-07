package com.capstone.fmsconfig.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequestDTO {

    private String feedbackType;
    private String answerType;
    private String questionDescription;
    private List<String> answers;
}
