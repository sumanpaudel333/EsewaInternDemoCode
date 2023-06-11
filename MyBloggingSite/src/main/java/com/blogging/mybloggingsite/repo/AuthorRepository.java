package com.blogging.mybloggingsite.repo;

import com.blogging.mybloggingsite.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    Optional<Author> findByUserName(String userName);
}
