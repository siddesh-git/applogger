package com.k2m.log;


import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class LogService {

    public void logMessage(String msg) throws IOException {

        File file = new File("/Users/s0s01ts/Desktop/test/loggingtest.txt");

        if(!file.exists()){
            file.createNewFile();
        }
        FileUtils.writeStringToFile(
                file, msg, StandardCharsets.UTF_8, true);
    }
}
