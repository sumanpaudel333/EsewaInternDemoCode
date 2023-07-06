package com.cms.contentmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("file-content")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileContent {
    @Id
    private String id;
    private String fileContent;
}
