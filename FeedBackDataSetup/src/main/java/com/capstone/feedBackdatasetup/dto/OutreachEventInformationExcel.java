package com.capstone.feedBackdatasetup.dto;

import io.github.mapper.excel.annotation.Column;
import lombok.Data;

import java.util.Date;

@Data
public class OutreachEventInformationExcel {
    @Column(name = "Event ID")
    public String eventId;
    @Column(name = "Base Location")
    public String baseLocation;
    @Column(name = "Beneficiary Name")
    public String beneficiaryName;
    @Column(name = "Council Name")
    public String councilName;
    @Column(name = "Event Name")
    public String eventName;
    @Column(name = "Event Desccription")
    public String eventDescription;
    @Column(name = "Event Date (DD-MM-YY)", pattern = "dd-MM-yy")
    public Date eventDate;
    @Column(name = "Employee ID")
    public Integer employeeId;
    @Column(name = "Employee Name")
    public String employeeName;
    @Column(name = "Volunteer Hours")
    public Double volunteerHours;
    @Column(name = "Travel Hours")
    public Double travelHours;
    @Column(name = "Lives Impacted")
    public Integer livesImpacted;
    @Column(name = "Business Unit")
    public String businessUnit;
    @Column(name = "Status")
    public String status;
    @Column(name = "IIEP Category")
    public String IIEPcategory;

}
