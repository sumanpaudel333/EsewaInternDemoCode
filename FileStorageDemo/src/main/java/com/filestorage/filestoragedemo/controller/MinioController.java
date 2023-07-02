package com.filestorage.filestoragedemo.controller;

import com.filestorage.filestoragedemo.dto.FileStorageResponseDto;
import com.filestorage.filestoragedemo.service.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class MinioController {
    private final MinioService minioService;

    @PostMapping("/uploadfile")
    public FileStorageResponseDto uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        String bucketName = "demostorage";
        String objectName = multipartFile.getOriginalFilename();
        return minioService.uploadFile(bucketName, objectName, multipartFile);
    }
}
