package com.capstone.feedBackdatasetup.utils;

import org.springframework.stereotype.Component;
import com.capstone.feedBackdatasetup.constants.DataSetupConstants;

import java.io.File;

@Component
public class ExcelType {

    public static boolean isXLSX(File file) {
        String fileName = file.getName();
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        return fileExtensionName.equals(DataSetupConstants.XLSX);
    }

    public static boolean isXLS(File file) {
        String fileName = file.getName();
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        return fileExtensionName.equals(DataSetupConstants.XLS);
    }
}
