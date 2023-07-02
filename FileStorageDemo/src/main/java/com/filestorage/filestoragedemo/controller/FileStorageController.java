package com.filestorage.filestoragedemo.controller;

import com.filestorage.filestoragedemo.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileStorageController {
    private final FileStorageService fileStorageService;
    @PostMapping("/savefiledetails")
    public String saveFileDetails(@RequestBody String fileName,String fileType) {
    return fileStorageService.saveFile(fileName,fileType);
    }
}
