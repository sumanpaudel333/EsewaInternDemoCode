package com.example.multipledatabaseconnectiontask.configdb.controller;

import com.example.multipledatabaseconnectiontask.configdb.dto.FileRequestDto;
import com.example.multipledatabaseconnectiontask.configdb.dto.FileResponseDto;
import com.example.multipledatabaseconnectiontask.configdb.service.FileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDetailController {

    private final FileService fileService;

    public FileDetailController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/getfilepath")
    public FileResponseDto getFilePath(@RequestBody FileRequestDto fileRequestDto) {
        return fileService.saveFileDetails(fileRequestDto);
    }
}
