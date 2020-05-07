package com.capstone.fmsconfig.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Answer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    @Id
    @Column("AnswerID")
    private Integer answerId;
    @Column("QuestionID")
    private Integer questionId;
    @Column("AnswerText")
    private String answerText;
}
