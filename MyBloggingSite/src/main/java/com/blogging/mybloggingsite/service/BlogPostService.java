package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.dto.BlogPostRequestDto;
import com.blogging.mybloggingsite.dto.BlogResponseDto;

import java.util.List;

public interface BlogPostService {
    BlogResponseDto addNewBlogPost(BlogPostRequestDto blogPost);

    BlogResponseDto getBlogPostById(String blogPostId);

    List<BlogResponseDto> getAllBlogpost();

    BlogResponseDto editBlogPost(String blogPostId, BlogPostRequestDto blogPost);
}
