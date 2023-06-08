package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.model.BlogPost;

import java.util.List;

public interface BlogPostService {
    BlogPost addNewBlogPost(BlogPost blogPost);
    BlogPost getBlogPostById(String blogPostId);
    List<BlogPost> getAllBlogpost();
}
