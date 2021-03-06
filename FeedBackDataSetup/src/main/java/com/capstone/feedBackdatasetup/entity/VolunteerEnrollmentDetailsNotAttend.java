package com.capstone.feedBackdatasetup.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerEnrollmentDetailsNotAttend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String volunteerEnrollmentDetailsNotAttendId;

    private String eventId;

    private String eventName;

    private String beneficiaryName;

    private String baseLocation;

    private Date eventDate;

    private Integer employeeId;
    @CreationTimestamp
    private LocalDateTime createdTimeStamp;
    @UpdateTimestamp
    private LocalDateTime updatedTimeStamp;
}
