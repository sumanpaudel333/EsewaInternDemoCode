package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.dto.AuthorResponseDto;
import com.blogging.mybloggingsite.model.Author;
import jakarta.mail.MessagingException;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    AuthorResponseDto registerAuthor(Author author) throws MessagingException, IOException;
    List<Author> getAllAuthor();
    Author getAuthorById(Long authorId);
}
