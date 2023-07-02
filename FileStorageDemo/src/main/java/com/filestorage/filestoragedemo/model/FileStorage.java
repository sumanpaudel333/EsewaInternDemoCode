package com.filestorage.filestoragedemo.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "file-storage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileStorage {
    private String fileId;
    private String fileName;
    private String fileType;
}
