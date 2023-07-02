package com.filestorage.filestoragedemo.repo;

import com.filestorage.filestoragedemo.model.FileStorage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileStorageRepo extends MongoRepository<FileStorage,String> {
}
