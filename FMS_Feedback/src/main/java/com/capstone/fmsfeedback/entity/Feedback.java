package com.capstone.fmsfeedback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Feedback")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    @Id
    @Column("FeedbackID")
    private Integer feedbackId;
    @Column("EventID")
    private String eventId;
    @Column("EmployeeID")
    private Integer employeeId;
    @Column("FeedbackType")
    private String feedbackType;
    @Column("QuestionDescription")
    private String questionDescription;
    @Column("AnswerText")
    private String answerText;
}
