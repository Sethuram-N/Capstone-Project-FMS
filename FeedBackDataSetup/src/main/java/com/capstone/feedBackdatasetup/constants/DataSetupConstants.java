package com.capstone.feedBackdatasetup.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSetupConstants {

    public static final Integer LIST_SPLIT_SIZE = 50;

    public static final String XLSX = ".xlsx";

    public static final String XLS = ".xls";

    public static final String VOL_EN_DET_NOT_ATT = "Volunteer_Enrollment Details_Not_Attend";

    public static final String VOL_EN_DET_UNREG = "Volunteer_Enrollment Details_Unregistered";

    public static final String OUT_EVT_SUMM = "Outreach Event Summary";

    public static final String OUT_EVT_INFO = "Outreach Event Information";

    public static final List<String> LIST_OF_EXCEL = new ArrayList<>
            (Arrays.asList(VOL_EN_DET_NOT_ATT, VOL_EN_DET_UNREG, OUT_EVT_SUMM, OUT_EVT_INFO));

    public static final List<String> LIST_OF_OEI = new ArrayList<>(Arrays.asList("Event ID", "Base Location",
            "Beneficiary Name", "Council Name", "Event Name", "Event Description", "Event Date (DD-MM-YY)",
            "Employee ID", "Employee Name", "Volunteer Hours", "Travel Hours", "Lives Impacted", "Business Unit",
            "Status", "IIEP Category"));

}
