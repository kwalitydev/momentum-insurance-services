package core.util;


import org.apache.commons.io.FileUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class FileUtil {

    public static String BASE_DIRECTORY;

    public static File createFile(String url,String name,String folderName,String subFolder) throws IOException {
        File newdir = new File(BASE_DIRECTORY+File.separator +folderName+File.separator+subFolder+File.separator);

        if (!newdir.exists()) {
          boolean created = newdir.mkdir();
          if(!created){
              throw new IOException();
          }
        }
        File file;
        file = new File(BASE_DIRECTORY+File.separator +folderName+File.separator+File.separator+subFolder+File.separator+ name + "." + getType(url));
        byte[] pdf = Base64.getDecoder().decode(removeBase64Header(url));
        BufferedOutputStream stream = new BufferedOutputStream(Files.newOutputStream(file.toPath()));
        stream.write(pdf);
        stream.close();
        return file;
    }

    private static String removeBase64Header(String base64) {
        String[] header = base64.split("[,]");
        if (header.length == 0) return null;
        return header[1];
    }

    public static String getType(String base64) {
        String[] header = base64.split("[;]");
        if (header.length == 0) return null;
        return header[0].split("[/]")[1];
    }

    public static String toBase64(String filePath) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(new File(BASE_DIRECTORY+filePath));
        return Base64.getEncoder().encodeToString(fileContent);
    }

    public static void copyFile(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }

}
