package com.capstone.feedBackdatasetup.dto;

import io.github.mapper.excel.annotation.Column;
import lombok.Data;

import java.util.Date;


@Data
public class OutreachEventSummaryExcel {

    @Column(name = "Event ID")
    public String eventId;
    @Column(name = "Month")
    public String month;
    @Column(name = "Base Location")
    public String baseLocation;
    @Column(name = "Beneficiary Name")
    public String beneficiaryName;
    @Column(name = "Venue Address")
    public String venueAddress;
    @Column(name = "Council Name")
    public String councilName;
    @Column(name = "project")
    public String project;
    @Column(name = "Category")
    public String category;
    @Column(name = "Event Name")
    public String eventName;
    @Column(name = "Event Description")
    public String eventDescription;
    @Column(name = "Event Date (DD-MM-YY)", pattern = "dd-MM-yy")
    public Date eventDate;
    @Column(name = "Total No. of Volunteers")
    private Integer totalNoOfVolunteers;
    @Column(name = "Total Volunteer Hours")
    private Double totalVolunteerHours;
    @Column(name = "Total Travel Hours")
    private Double totalTravelHours;
    @Column(name = "Overall Volunteer Hours")
    private Double overallVolunteerHours;
    @Column(name = "Lives Impacted")
    private Integer livesImpacted;
    @Column(name = "Activity Type")
    private Integer activityType;
    @Column(name = "Status")
    private String status;
    @Column(name = "POC ID")
    private Integer pocId;
    @Column(name = "POC Name")
    private String pocName;
    @Column(name = "POC Contact")
    private String pocContact;
}
