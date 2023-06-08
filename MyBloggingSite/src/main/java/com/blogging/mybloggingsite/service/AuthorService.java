package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.model.Author;

import java.util.List;

public interface AuthorService {
    Author registerAuthor(Author author);
    List<Author> getAllAuthor();
    Author getAuthorById(Long authorId);
}
