package edu.ptithcm.util;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @author Le Ngoc Tu
 */
public class FileProcess{

    /**
     * @return <code>null</code> neu khong chon file nao
     */
    public static File chooseFile(FileFilter filter, String dialogTitle, Component parent){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(dialogTitle);
        fileChooser.setFileFilter(filter);

        int selection = fileChooser.showOpenDialog(parent);
        if(selection == JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    /**
     * @return <code>null</code> neu khong chon file nao
     */
    public static File chooseImageFile(String dialogTitle, Component parent){
        File f = chooseFile(
                new FileNameExtensionFilter("Image File", "jpg", "jpeg", "png"),
                dialogTitle,
                parent
        );
        if(f == null)
            return null;
        String ext = getFilExtension(f.getName());
        if(!(ext == "jpg" || ext != "png" || ext != "jpeg"))
            return null;
        return f;
    }

    /**
     * Copy file, neu o noi den da ton tai thi thay the file cu thanh file moi
     */
    public static void copyFile(String sourcePath, String destinationPath) throws IOException {
        Files.copy(Path.of(sourcePath), Path.of(destinationPath), StandardCopyOption.REPLACE_EXISTING);
    }

    public static String getFilExtension(String fileName){
        int index = fileName.lastIndexOf('.');
        if(index == -1)
            throw new IllegalArgumentException("getFilExtension(String fileName): fileName khong hop le!");

        return fileName.substring(index+1);
    }
}