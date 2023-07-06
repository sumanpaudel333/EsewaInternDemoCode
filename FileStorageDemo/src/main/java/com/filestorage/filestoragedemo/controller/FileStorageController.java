package com.filestorage.filestoragedemo.controller;

import com.filestorage.filestoragedemo.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileStorageController {
    private final FileStorageService fileStorageService;
    @PostMapping("/savefiledetails")
    public String saveFileDetails(@RequestBody String fileName, String fileType, MultipartFile file) throws IOException {
        String fileContent=new String(file.getBytes());
    return fileStorageService.saveFile(fileName,fileType,fileContent);
    }
}
