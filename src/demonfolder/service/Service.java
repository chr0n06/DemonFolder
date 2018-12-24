/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demonfolder.service;

import com.sun.nio.zipfs.ZipPath;
import demonfolder.preferences.Preferences;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maxime
 */
public class Service {

    public void createFolderIfNotExist(File file) {
        if (!file.exists()) {
            System.out.println("creating directory: " + file.getName());
            boolean result = false;
            try {
                file.mkdir();
                result = true;
            } catch (SecurityException se) {
                System.out.println(se.getMessage());
            }
            if (result) {
                System.out.println("DIR created");
            }
        } else {
            System.out.println("File have not been created");
        }
    }

    public void classificationOfFiles() {
        File[] files = new File(Preferences.ROOT_PATH).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                switch (checkExtensionType(file)) {
                    case "Picture":
                        fileStatus(file, Preferences.PICTURE_PATH);
                        break;
                    case "Music":
                        fileStatus(file, Preferences.MUSIC_PATH);
                        break;
                    case "Document":
                        fileStatus(file, Preferences.DOCUMENT_PATH);
                        break;
                    default:
                        System.out.println("Unclassified");
                }
            }
        }
    }

    private void fileStatus(File file, String folderPath) {
        if (file.renameTo(new File(folderPath + "\\" + file.getName()))) {
            System.out.println("File is moved successful!");
        } else {
            System.out.println("File is failed to move!");
        }

    }

    private String checkExtensionType(File file) {
        String extension = getFileExtension(file);
        int cursor = 0;
        for (List<String> listExtension : Preferences.allExtensionList) {
            for (String typeExtension : listExtension) {
                if (extension.equals(typeExtension) && cursor == 0) {
                    return "Music";
                }
                if (extension.equals(typeExtension) && cursor == 1) {
                    return "Document";
                }
                if (extension.equals(typeExtension) && cursor == 2) {
                    return "Video";
                }
                if (extension.equals(typeExtension) && cursor == 3) {
                    return "Picture";
                }
            }
            cursor++;
        }
        return "Autre";
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }
}
