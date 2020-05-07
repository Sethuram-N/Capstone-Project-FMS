package com.capstone.feedBackdatasetup.service;

import com.capstone.feedBackdatasetup.constants.DataSetupConstants;
import com.capstone.feedBackdatasetup.utils.FileOperations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@AllArgsConstructor
public class ExcelReadService {

    private final ProcessExcel processExcel;

    public String readExcel(File file) throws Throwable {
        String response = null;
        if(DataSetupConstants.OUT_EVT_SUMM.equals(FileOperations.getFileName(file))) {
             response = processExcel.processOutRchEvtSummaryFile(file);
        }
        if(DataSetupConstants.OUT_EVT_INFO.equals(FileOperations.getFileName(file))) {
            response = processExcel.processOutRchEvtInfoFile(file);
        }
        if(DataSetupConstants.VOL_EN_DET_NOT_ATT.equals(FileOperations.getFileName(file))) {
            response = processExcel.processVolEnrDetNotAttFile(file);
        }
        if(DataSetupConstants.VOL_EN_DET_UNREG.equals(FileOperations.getFileName(file))) {
            response = processExcel.processVolEnrDetUnRegFile(file);
        }
        return " ";
    }
}
