package ru.derevenskikh.TraineeTest.utils;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;

@Getter
@Setter
@NoArgsConstructor
public class PathObject {
    @JsonAlias("file_path")
    private String filePath;

    public String getCheckSum(){
        File file = new File(filePath);
        CRC32 crc32 = new CRC32();

        byte[] buffer = new byte[1024];
        int countBytes;

        try (FileInputStream in = new FileInputStream(file)) {
            while ((countBytes = in.read(buffer)) != -1) {
                crc32.update(buffer, 0, countBytes);
            }
        } catch (IOException ignore) {ignore.printStackTrace();}
        crc32.toString();
        return  Long.toString(crc32.getValue());
    }
}
