package com.capstone.feedBackdatasetup.mapper;

import com.capstone.feedBackdatasetup.dto.OutreachEventInformationExcel;
import com.capstone.feedBackdatasetup.dto.OutreachEventSummaryExcel;
import com.capstone.feedBackdatasetup.dto.VolunteerEnrollmentDetailsNotAttendedExcel;
import com.capstone.feedBackdatasetup.dto.VolunteerEnrollmentDetailsUnregisteredExcel;
import com.capstone.feedBackdatasetup.entity.OutreachEventInformation;
import com.capstone.feedBackdatasetup.entity.OutreachEventSummary;
import com.capstone.feedBackdatasetup.entity.VolunteerEnrollmentDetailsNotAttend;
import com.capstone.feedBackdatasetup.entity.VolunteerEnrollmentDetailsUnregistered;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExcelToDtoObjMapper {

    OutreachEventSummary getObj(OutreachEventSummaryExcel outreachEventSummaryExcel);

    OutreachEventInformation getObj(OutreachEventInformationExcel outreachEventInformationExcel);

    VolunteerEnrollmentDetailsNotAttend getObj(VolunteerEnrollmentDetailsNotAttendedExcel volunteerEnrollmentDetailsNotAttendedExcel);

    VolunteerEnrollmentDetailsUnregistered getObj(VolunteerEnrollmentDetailsUnregisteredExcel volunteerEnrollmentDetailsUnregisteredExcel);
}
