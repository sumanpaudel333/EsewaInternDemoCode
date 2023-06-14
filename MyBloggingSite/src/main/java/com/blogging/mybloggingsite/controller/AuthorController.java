package com.blogging.mybloggingsite.controller;

import com.blogging.mybloggingsite.dto.AuthorResponseDto;
import com.blogging.mybloggingsite.model.Author;
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
    ResponseEntity<AuthorResponseDto> registerAuthor(@RequestBody Author author) throws MessagingException, IOException {
        AuthorResponseDto author1=authorService.registerAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(author1);
    }
    @GetMapping("/getallauthor")
    ResponseEntity<List<Author>> getAllAuthor(){
        List<Author> authorList=authorService.getAllAuthor();
        return ResponseEntity.status(HttpStatus.FOUND).body(authorList);
    }
    @GetMapping("/getauthorbyid/{authorId}")
    ResponseEntity<Author> getAuthorById(@PathVariable long authorId){
        Author author=authorService.getAuthorById(authorId);
        return ResponseEntity.status(HttpStatus.FOUND).body(author);
    }
}
