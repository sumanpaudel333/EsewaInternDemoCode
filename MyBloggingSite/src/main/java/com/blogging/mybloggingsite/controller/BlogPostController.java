package com.blogging.mybloggingsite.controller;

import com.blogging.mybloggingsite.dto.BlogPostRequestDto;
import com.blogging.mybloggingsite.dto.BlogResponseDto;
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
    ResponseEntity<BlogResponseDto> addNewBlogPost(@RequestBody BlogPostRequestDto blogPost) {
        BlogResponseDto blogPost1 = blogPostService.addNewBlogPost(blogPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(blogPost1);
    }

    @GetMapping("/getallblog")
    ResponseEntity<List<BlogResponseDto>> getAllBlogPost() {
        List<BlogResponseDto> posts = blogPostService.getAllBlogpost();
        return ResponseEntity.status(HttpStatus.FOUND).body(posts);
    }

    @GetMapping("/getblogpostbyid/{blogPostId}")
    ResponseEntity<BlogResponseDto> getBlogPostById(@PathVariable String blogPostId) {
        BlogResponseDto blogPost = blogPostService.getBlogPostById(blogPostId);
        return ResponseEntity.status(HttpStatus.FOUND).body(blogPost);
    }

    @PostMapping("/editblogpostbyid/{blogPostId}")
    ResponseEntity<BlogResponseDto> editBlogPostById(@PathVariable String blogPostId, @RequestBody BlogPostRequestDto blogRequestDto) {
        BlogResponseDto blogPost = blogPostService.editBlogPost(blogPostId, blogRequestDto);
        return ResponseEntity.status(HttpStatus.FOUND).body(blogPost);
    }
}
