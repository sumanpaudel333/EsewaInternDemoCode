package com.filestorage.filestoragedemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileStorageResponseDto {
    private String fileName;
    private String fileType;
    private String fileContent;
}
