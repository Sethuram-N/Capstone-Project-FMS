package com.capstone.feedBackdatasetup.service;

import com.capstone.feedBackdatasetup.dto.OutreachEventInformationExcel;
import com.capstone.feedBackdatasetup.dto.OutreachEventSummaryExcel;
import com.capstone.feedBackdatasetup.dto.VolunteerEnrollmentDetailsNotAttendedExcel;
import com.capstone.feedBackdatasetup.dto.VolunteerEnrollmentDetailsUnregisteredExcel;
import com.capstone.feedBackdatasetup.entity.OutreachEventInformation;
import com.capstone.feedBackdatasetup.entity.OutreachEventSummary;
import com.capstone.feedBackdatasetup.entity.VolunteerEnrollmentDetailsNotAttend;
import com.capstone.feedBackdatasetup.entity.VolunteerEnrollmentDetailsUnregistered;
import com.capstone.feedBackdatasetup.mapper.ExcelToDtoObjMapper;
import com.capstone.feedBackdatasetup.repository.OutreachEventInformationRepository;
import com.capstone.feedBackdatasetup.repository.OutreachEventSummaryRepository;
import com.capstone.feedBackdatasetup.repository.VolunteerEnrollmentDetailsNotAttendRepository;
import com.capstone.feedBackdatasetup.repository.VolunteerEnrollmentDetailsUnregisteredRepository;
import com.capstone.feedBackdatasetup.utils.ExcelType;
import com.capstone.feedBackdatasetup.utils.FileOperations;
import io.github.mapper.excel.ExcelMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProcessExcel {

    private final ExcelToDtoObjMapper excelToDtoObjMapper;
    private final OutreachEventSummaryRepository outreachEventSummaryRepository;
    private final OutreachEventInformationRepository outreachEventInformationRepository;
    private final VolunteerEnrollmentDetailsNotAttendRepository volunteerEnrollmentDetailsNotAttendRepository;
    private final VolunteerEnrollmentDetailsUnregisteredRepository volunteerEnrollmentDetailsUnregisteredRepository;

    public String processOutRchEvtSummaryFile(File file) throws Throwable {
        if(ExcelType.isXLSX(file) || ExcelType.isXLS(file)) {
            List<OutreachEventSummaryExcel> items = ExcelMapper.mapFromExcel(file).toObjectOf(OutreachEventSummaryExcel.class).map();

            List<OutreachEventSummaryExcel> nonNullValues = items.stream().filter(FileOperations::checkNotNullObj).collect(Collectors.toList());

            List<OutreachEventSummary> outreachEventSummaryList = nonNullValues.parallelStream().map(excelToDtoObjMapper::getObj).collect(Collectors.toList());

            outreachEventSummaryRepository.saveAll(outreachEventSummaryList);
            log.info("OutreachEventSummary Saved");
            return "Saved Successfully";
        }else{
            return "File Type Not valid";
        }
    }

    public String processOutRchEvtInfoFile(File file) throws Throwable {
         if(ExcelType.isXLSX(file) || ExcelType.isXLS(file)) {
             List<OutreachEventInformationExcel> items = ExcelMapper.mapFromExcel(file).toObjectOf(OutreachEventInformationExcel.class).map();

             List<OutreachEventInformationExcel> outreachEventInformationExcelList = items.stream().filter(FileOperations::checkNotNullObj).collect(Collectors.toList());

             List<OutreachEventInformation> outreachEventInformationList = outreachEventInformationExcelList.parallelStream().map(excelToDtoObjMapper::getObj).collect(Collectors.toList());

             outreachEventInformationRepository.saveAll(outreachEventInformationList);
             log.info("Outreach Event Information Saved");
             return "Saved Successfully";
         }else {
             return "File Type Not Valid";
         }
    }

    public String processVolEnrDetNotAttFile(File file) throws Throwable {
        if(ExcelType.isXLSX(file) || ExcelType.isXLS(file)) {
            List<VolunteerEnrollmentDetailsNotAttendedExcel> items = ExcelMapper.mapFromExcel(file).toObjectOf(VolunteerEnrollmentDetailsNotAttendedExcel.class).map();

           List<VolunteerEnrollmentDetailsNotAttendedExcel> nonNullValues =  items.stream().filter(FileOperations::checkNotNullObj).collect(Collectors.toList());

           List<VolunteerEnrollmentDetailsNotAttend> volunteerEnrollmentDetailsNotAttendList = nonNullValues.parallelStream().map(excelToDtoObjMapper::getObj).collect(Collectors.toList());

           volunteerEnrollmentDetailsNotAttendRepository.saveAll(volunteerEnrollmentDetailsNotAttendList);
           log.info("Volunteer Details Not Attended Successfully");
           return "Saved Successfully";
        }else {
            return "File Type Not Valid";
        }
    }

    public String processVolEnrDetUnRegFile(File file) throws Throwable {
        if(ExcelType.isXLSX(file) || ExcelType.isXLS(file)) {
            List<VolunteerEnrollmentDetailsUnregisteredExcel> items = ExcelMapper.mapFromExcel(file).toObjectOf(VolunteerEnrollmentDetailsUnregisteredExcel.class).map();

            List<VolunteerEnrollmentDetailsUnregisteredExcel> nonNullValues = items.stream().filter(FileOperations::checkNotNullObj).collect(Collectors.toList());

           List<VolunteerEnrollmentDetailsUnregistered> volunteerEnrollmentDetailsUnregisteredList =  nonNullValues.parallelStream().map(excelToDtoObjMapper::getObj).collect(Collectors.toList());

           volunteerEnrollmentDetailsUnregisteredRepository.saveAll(volunteerEnrollmentDetailsUnregisteredList);
           log.info("Volunteer Details Un Registered Saved");
           return "Saved Successfully";
        }else {
            return "File Type Not Valid";
        }
    }
}
