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
public class OutreachEventSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String outreachEventSummaryId;

    private String eventId;

    private String month;

    private String baseLocation;

    private String beneficiaryName;

    private String venueAddress;

    private String councilName;

    private String project;

    private String category;

    private String eventName;

    private String eventDescription;

    private Date eventDate;

    private Integer totalNoOfVolunteers;

    private Double totalVolunteerHours;

    private Double totalTravelHours;

    private Double overallVolunteerHours;

    private Integer livesImpacted;

    private Integer activityType;

    private String status;

    private Integer pocId;

    private String pocName;

    private String pocContact;

    @CreationTimestamp
    private LocalDateTime createdTimeStamp;

    @UpdateTimestamp
    private LocalDateTime updatedTimeStamp;
}
