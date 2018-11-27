package com.work.thymeleaf.helper;

import com.sun.nio.zipfs.ZipPath;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Александр on 22.11.2018.
 */
public class Helper {
    public static void saveImageFromURL(URL url, Path path){
        try {
            BufferedInputStream inputStream = new BufferedInputStream(url.openStream());
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(path.toString()+"/1.jpg")));
            int i=inputStream.read();
            while (i!=-1){
                outputStream.write(i);
                i=inputStream.read();
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unZipArchiveToFolder(String zipPath, String path){
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipPath));
            ZipEntry zipEntry=zipInputStream.getNextEntry();
            String name;

            while (zipEntry != null){
                name=zipEntry.getName();
                FileOutputStream fileOutputStream = new FileOutputStream(new File(path+name));
                int c=zipInputStream.read();
                while (c!=-1){
                    fileOutputStream.write(c);
                    c=zipInputStream.read();
                }
                fileOutputStream.close();
                zipInputStream.closeEntry();
                zipEntry=zipInputStream.getNextEntry();
                if (name.endsWith(".zip")){
                    unZipArchiveToFolder("C:/giants/"+name,path);
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
