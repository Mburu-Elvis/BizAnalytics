package com.bizanalytics.dataIngestor.controller;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.opencsv.CSVReader;

import java.io.*;
import java.util.Arrays;

@RestController()
@RequestMapping("/api/v1/ingestor/upload")
public class FileIngestionController {

    @Value("${file.upload.allowedTypes}")
    private String[] allowedTypes;

    @PostMapping("/data")
    public ResponseEntity<String> handleDataUpload(@RequestParam("file")MultipartFile file) {
        String fileType = file.getContentType();
        if (!Arrays.asList(allowedTypes).contains(fileType)) {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                    .body("Invalid file type. Allowed types are: " + String.join(", ", allowedTypes));
        }

        try {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(new InputStreamReader(file.getInputStream()));
            for (CSVRecord record: records) {
                System.out.println(record);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("File uploaded successfully");
    }
}
