package com.capstone.fmsconfig.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Question")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @Column("QuestionID")
    private Integer questionId;
    @Column("QuestionDescription")
    private String questionDescription;
    @Column("FeedbackType")
    private String feedbackType;
    @Column("AnswerType")
    private String answerType;
}
