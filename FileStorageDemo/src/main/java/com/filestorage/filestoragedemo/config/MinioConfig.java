package com.filestorage.filestoragedemo.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {
    @Value("${minio.url}")
    private String minioUrl;
    @Value("${minio.accessKey}")
    private String minioAccessKey;
    @Value("${minio.secretKey}")
    private String minioSecretKey;

    @Bean
    MinioClient minioClient() {
        return MinioClient
                .builder()
                .endpoint(minioUrl)
                .credentials(minioAccessKey,minioSecretKey)
                .build();
    }
}
