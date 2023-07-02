package com.filestorage.filestoragedemo.service;

import com.filestorage.filestoragedemo.model.FileStorage;
import com.filestorage.filestoragedemo.repo.FileStorageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {
    private final FileStorageRepo fileStorageRepo;

    @Override
    public String saveFile(String fileName,String fileType) {
        FileStorage fileStorage=new FileStorage();
        fileStorage.setFileName(fileName);
        fileStorage.setFileType(fileType);
        fileStorageRepo.save(fileStorage);
        return "File Details Saved Successfully";
    }
}
