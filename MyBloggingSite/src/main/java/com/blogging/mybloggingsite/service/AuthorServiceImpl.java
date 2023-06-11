package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.config.SecurityConfiguration;
import com.blogging.mybloggingsite.model.Author;
import com.blogging.mybloggingsite.repo.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Author registerAuthor(Author author) {
        String pass=bCryptPasswordEncoder.encode(author.getPassword());
        author.setPassword(pass);
        return authorRepository.save(author);
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
