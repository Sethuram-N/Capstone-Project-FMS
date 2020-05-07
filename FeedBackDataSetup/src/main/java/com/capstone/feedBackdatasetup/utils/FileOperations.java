package com.capstone.feedBackdatasetup.utils;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.reflect.Field;

@Component
public class FileOperations {

    public static String getFileName(File file) {
        return getFileNameAsString(file.toString());
    }

    public static String getFileNameAsString(String file) {
        return FilenameUtils.removeExtension(FilenameUtils.getName(file));
    }

    public static boolean checkNotNullObj(Object obj) {
        for (Field f : obj.getClass().getDeclaredFields()) {
            try{
                if(f.get(obj) != null)
                    return true;
            }catch(IllegalAccessException ex){
                ex.printStackTrace();
            }
        }
        return false;
    }
}
