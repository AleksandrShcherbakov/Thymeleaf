package com.work.thymeleaf.helper;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;

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
}
