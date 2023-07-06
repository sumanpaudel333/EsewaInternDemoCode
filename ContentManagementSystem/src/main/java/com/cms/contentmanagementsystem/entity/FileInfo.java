package com.cms.contentmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("file-info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {
    @Id
    private String fileId;
    private String fileName;
    @CreatedDate
    private String createdDate;
}
