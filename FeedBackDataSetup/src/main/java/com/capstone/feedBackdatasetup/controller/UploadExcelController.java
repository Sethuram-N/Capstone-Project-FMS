package com.capstone.feedBackdatasetup.controller;

import com.capstone.feedBackdatasetup.constants.DataSetupConstants;
import com.capstone.feedBackdatasetup.service.ExcelReadService;
import com.capstone.feedBackdatasetup.utils.FileOperations;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;


@Controller
@AllArgsConstructor
@Slf4j
public class UploadExcelController implements ErrorController {

    private final ExcelReadService excelReadService;

    public static final String uploadingDir = System.getProperty("user.dir") + "/uploadingDir";

    @GetMapping("/upload")
    public String uploadingModel(Model model) {
        File file = new File(uploadingDir);
        model.addAttribute("files", file.listFiles());
        return "uploading";
    }

    @PostMapping (value = "/upload")
    public String uploadingFile(@RequestParam("uploadingFiles")MultipartFile[] uploadingFiles) throws Throwable {

        log.info("Files to be uploaded as follows");
        Arrays.stream(uploadingFiles).filter(Objects::nonNull).forEach(f ->
                log.info("**File Name  ==>" + FileOperations.getFileNameAsString(f.getOriginalFilename())));

        for(MultipartFile uploadingFile : uploadingFiles) {

            File file = new File(uploadingDir + uploadingFile.getOriginalFilename());

            uploadingFile.transferTo(file);

            if(DataSetupConstants.LIST_OF_EXCEL.contains(FileOperations.getFileName(file))) {
                log.info("Processing the file ::" +file.getName());


                    String response = excelReadService.readExcel(file);


            } else {
                System.out.println("Incorrect File");
            }


        }
        return "redirect:/upload";

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/error")
    public String handleError() {
        return "error";
    }
}
