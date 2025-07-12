package com.nitesh.taskman.util;

import java.io.File;

public class AppPaths {
    public static String getDataFilePath(String fileName) {
        String os = System.getProperty("os.name").toLowerCase();
        String baseDir;

        if (os.contains("win")) {
            baseDir = System.getenv("APPDATA");
        } else if (os.contains("mac")) {
            baseDir = System.getProperty("user.home") + "/Library/Application support";
        } else {
            baseDir = System.getProperty("user.home") + "/.local/share";
        }

        String appDir = baseDir + "/taskman";

        File dir = new File(appDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }     
        return appDir + "/" + fileName;
    }
}
