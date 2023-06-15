package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.dto.AuthorRequestDto;
import com.blogging.mybloggingsite.dto.AuthorResponseDto;
import com.blogging.mybloggingsite.dto.BlogResponseDto;
import com.blogging.mybloggingsite.model.Author;
import com.blogging.mybloggingsite.model.BlogPost;
import com.blogging.mybloggingsite.repo.AuthorRepository;
import com.blogging.mybloggingsite.repo.BlogPostRepository;
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
    private final BlogPostRepository blogPostRepository;

    @Override
    public AuthorResponseDto registerAuthor(AuthorRequestDto author) throws MessagingException, IOException {
        Author author1 = modelMapper.map(author, Author.class);
        String pass = bCryptPasswordEncoder.encode(author1.getPassword());
        author1.setPassword(pass);
        /* List<Author> authorList = authorRepository.findAll();
         *//* for (Author author1 : authorList) {
            if (author.getEmail().equals(author1.getEmail()) || author.getUsername().equals(author1.getUsername())) {
                throw new RuntimeException("Could not register Author! Author with this email/user already exists. Try Logging in!");
            }
        }*/
        author1.setRole("USER");
        String subject = "Thank You for Registering with us!";
        String body = "Thank you for registering with us. Enjoy Blogging!";
        emailService.sendWithoutAttachement(author.getEmail(), author.getEmail(), subject, body);
        Author author2 = authorRepository.save(author1);
        return modelMapper.map(author2, AuthorResponseDto.class);
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
    public AuthorResponseDto getAuthorById(Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow();
        return modelMapper.map(author, AuthorResponseDto.class);
    }

    @Override
    public Author getAuthorByUsername(String authorUsername) {
        return authorRepository.findByUserName(authorUsername).orElseThrow();
    }

    @Override
    public List<BlogResponseDto> getAuthorBlogById(Long authorId) {
        List<BlogPost> posts = blogPostRepository.findBlogPostByAuthor_AuthorId(authorId);
        List<BlogResponseDto> blogResponseDto = new ArrayList<>();
        for (BlogPost blogPost : posts) {
            BlogResponseDto blogResponseDto1 = modelMapper.map(blogPost, BlogResponseDto.class);
            blogResponseDto.add(blogResponseDto1);
        }
        return blogResponseDto;
    }
}
