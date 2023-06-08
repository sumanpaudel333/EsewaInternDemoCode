package com.blogging.mybloggingsite.controller;

import com.blogging.mybloggingsite.model.BlogPost;
import com.blogging.mybloggingsite.service.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blog")
public class BlogPostController {
    private final BlogPostService blogPostService;

    @PostMapping("/addnewpost")
    ResponseEntity<BlogPost> addNewBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost blogPost1 = blogPostService.addNewBlogPost(blogPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(blogPost1);
    }

    @GetMapping("/getallblog")
    ResponseEntity<List<BlogPost>> getAllBlogPost() {
        List<BlogPost> posts = blogPostService.getAllBlogpost();
        return ResponseEntity.status(HttpStatus.FOUND).body(posts);
    }

    @GetMapping("/getblogpostbyid/{blogPostId}")
    ResponseEntity<BlogPost> getBlogPostById(@PathVariable String blogPostId) {
        BlogPost blogPost = blogPostService.getBlogPostById(blogPostId);
        return ResponseEntity.status(HttpStatus.FOUND).body(blogPost);
    }
}
