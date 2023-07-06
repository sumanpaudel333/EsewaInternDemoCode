package com.cms.contentmanagementsystem.repo;

import com.cms.contentmanagementsystem.entity.FileContent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileContentRepository extends ReactiveMongoRepository<FileContent,String> {
}
