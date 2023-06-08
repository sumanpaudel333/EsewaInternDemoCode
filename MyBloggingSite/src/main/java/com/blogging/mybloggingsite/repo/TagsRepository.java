package com.blogging.mybloggingsite.repo;

import com.blogging.mybloggingsite.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tags,Long> {
}
