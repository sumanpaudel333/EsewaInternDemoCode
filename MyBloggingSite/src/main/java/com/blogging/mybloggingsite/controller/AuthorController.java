package com.blogging.mybloggingsite.controller;

import com.blogging.mybloggingsite.dto.AuthorRequestDto;
import com.blogging.mybloggingsite.dto.AuthorResponseDto;
import com.blogging.mybloggingsite.dto.BlogResponseDto;
import com.blogging.mybloggingsite.service.AuthorService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/register")
    ResponseEntity<AuthorResponseDto> registerAuthor(@RequestBody AuthorRequestDto author) throws MessagingException, IOException {
        AuthorResponseDto author1 = authorService.registerAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(author1);
    }

    @GetMapping("/getallauthor")
    ResponseEntity<List<AuthorResponseDto>> getAllAuthor() {
        List<AuthorResponseDto> authorList = authorService.getAllAuthor();
        return ResponseEntity.status(HttpStatus.FOUND).body(authorList);
    }

    @GetMapping("/getauthorbyid/{authorId}")
    ResponseEntity<AuthorResponseDto> getAuthorById(@PathVariable long authorId) {
        AuthorResponseDto author = authorService.getAuthorById(authorId);
        return ResponseEntity.status(HttpStatus.FOUND).body(author);
    }

    @GetMapping("/getauthorpostsbyid/{authorId}")
    ResponseEntity<List<BlogResponseDto>> getAuthorPostsById(@PathVariable Long authorId) {
        List<BlogResponseDto> blogResponseDto = authorService.getAuthorBlogById(authorId);
        return ResponseEntity.status(HttpStatus.FOUND).body(blogResponseDto);
    }
}
