package com.bjak.dxfreduce.util;

import lombok.extern.log4j.Log4j;

import java.io.File;

@Log4j
public class FileUtil {

    public static void deleteFile(File file) {
        if (file.exists()) {
            // dir type
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files == null || files.length == 0) {
                    if (!file.delete()) {
                        log.error("delete dir fail," + file.getAbsolutePath());
                    }
                } else {
                    log.error("can't delete a not empty dir," + file.getAbsolutePath());
                }
            } else { // file type
                if (!file.delete()) {
                    log.error("delete File fail" + file.getAbsolutePath());
                }
            }
        } else {
            log.warn("file not exists or not's a file" + file.getAbsolutePath());
        }
    }


}
