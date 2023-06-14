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
        String subject = "Thank You for Registering with us!";
        String body = "Thank you for registering with us. Enjoy Blogging!";
        emailService.sendWithoutAttachement(author.getEmail(), author.getEmail(), subject, body);
        Author author1 = authorRepository.save(author);
        return modelMapper.map(author1, AuthorResponseDto.class);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow();
    }
}
