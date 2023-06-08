package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.model.BlogPost;
import com.blogging.mybloggingsite.repo.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostServiceImpl implements BlogPostService{
    private final BlogPostRepository blogPostRepository;

    @Override
    public BlogPost addNewBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public BlogPost getBlogPostById(String blogPostId) {
        return blogPostRepository.findById(blogPostId).orElseThrow();
    }

    @Override
    public List<BlogPost> getAllBlogpost() {
        return blogPostRepository.findAll();
    }
}
