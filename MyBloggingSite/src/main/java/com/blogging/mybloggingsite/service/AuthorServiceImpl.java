package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.dto.AuthorResponseDto;
import com.blogging.mybloggingsite.model.Author;
import com.blogging.mybloggingsite.repo.AuthorRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EmailService emailService;
    private final ModelMapper modelMapper;

    @Override
    public AuthorResponseDto registerAuthor(Author author) throws MessagingException, IOException {
        String pass = bCryptPasswordEncoder.encode(author.getPassword());
        author.setPassword(pass);
        /* List<Author> authorList = authorRepository.findAll();
         *//* for (Author author1 : authorList) {
            if (author.getEmail().equals(author1.getEmail()) || author.getUsername().equals(author1.getUsername())) {
                throw new RuntimeException("Could not register Author! Author with this email/user already exists. Try Logging in!");
            }
        }*/
        author.setRole("USER");
        String subject = "Thank You for Registering with us!";
        String body = "Thank you for registering with us. Enjoy Blogging!";
        emailService.sendWithoutAttachement(author.getEmail(), author.getEmail(), subject, body);
        Author author1 = authorRepository.save(author);
        return modelMapper.map(author1, AuthorResponseDto.class);
    }

    @Override
    public List<AuthorResponseDto> getAllAuthor() {
        List<Author> authorList = authorRepository.findAll();
        List<AuthorResponseDto> authorResponseDto = new ArrayList<>();
        for (Author author : authorList) {
            AuthorResponseDto authorResponseDto1 = modelMapper.map(author, AuthorResponseDto.class);
            authorResponseDto.add(authorResponseDto1);
        }
        return authorResponseDto;
    }

    @Override
    public Author getAuthorById(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow();
    }
}
