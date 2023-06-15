package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.dto.AuthorRequestDto;
import com.blogging.mybloggingsite.dto.AuthorResponseDto;
import com.blogging.mybloggingsite.dto.BlogResponseDto;
import com.blogging.mybloggingsite.model.Author;
import jakarta.mail.MessagingException;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    AuthorResponseDto registerAuthor(AuthorRequestDto author) throws MessagingException, IOException;

    List<AuthorResponseDto> getAllAuthor();

    AuthorResponseDto getAuthorById(Long authorId);

    List<BlogResponseDto> getAuthorBlogById(Long authorId);

    Author getAuthorByUsername(String authorUsername);
}
