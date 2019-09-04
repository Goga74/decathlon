package com.izamtest.decatlon.service;

import java.io.File;

public class FilenameUtils {
    public static String getFileType(final String filename) {
        return new File(filename).getName().substring(filename.lastIndexOf(".") + 1);
    }

    public static String getFileNameWithoutExtension(final String filename) {
        return new File(filename).getName().substring(0, filename.indexOf("."));
    }

}
