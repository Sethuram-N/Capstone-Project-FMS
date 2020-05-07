package com.capstone.feedBackdatasetup;

import com.capstone.feedBackdatasetup.controller.UploadExcelController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import java.io.File;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class FeedBackDataSetupApplication {

	public static void main(String[] args) {
		new File(UploadExcelController.uploadingDir).mkdirs();
		SpringApplication.run(FeedBackDataSetupApplication.class, args);
	}

}
