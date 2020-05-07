package com.capstone.fmsconfig.dto;

import com.capstone.fmsconfig.entity.Answer;
import com.capstone.fmsconfig.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditQuestionRequestDTO {

    private Question question;
    private List<Answer> answers;
}
