package com.filestorage.filestoragedemo.service;

import com.filestorage.filestoragedemo.dto.FileStorageResponseDto;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class MinioService {
    private final MinioClient minioClient;
    private final FileStorageService fileStorageService;
    public FileStorageResponseDto uploadFile(String bucketName, String objectName, MultipartFile file){
        FileStorageResponseDto responseDto=new FileStorageResponseDto();
        try {
            minioClient.putObject(
                    PutObjectArgs
                            .builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .stream(file.getInputStream(),file.getSize(),-1)
                            .contentType(file.getContentType())
                            .build()
            );
            fileStorageService.saveFile(file.getOriginalFilename(),file.getContentType());
            responseDto.setFileName(file.getOriginalFilename());
            responseDto.setFileType(file.getContentType());
            System.out.println("File Uploaded Successfully");
            System.out.println(file.getContentType());
        } catch (IOException | ServerException | ErrorResponseException | InsufficientDataException |
                 InternalException | InvalidKeyException | InvalidResponseException | NoSuchAlgorithmException |
                 XmlParserException e) {
            throw new RuntimeException(e);
        }
        return responseDto;
        }
    }