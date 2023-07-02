package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.dto.BlogPostRequestDto;
import com.blogging.mybloggingsite.dto.BlogResponseDto;
import com.blogging.mybloggingsite.model.Author;
import com.blogging.mybloggingsite.model.BlogPost;
import com.blogging.mybloggingsite.model.Category;
import com.blogging.mybloggingsite.repo.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {
    private final BlogPostRepository blogPostRepository;
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final ModelMapper modelMapper;

    @Override
    public BlogResponseDto addNewBlogPost(BlogPostRequestDto blogPost) {
        BlogPost blogPost1 = modelMapper.map(blogPost, BlogPost.class);
        Category category = categoryService.getCategoryByName(blogPost.getCategoryName());
        Author author = authorService.getAuthorByUsername(blogPost.getAuthorUserName());
        if (category == null) {
            throw new RuntimeException("Category does not exist! Please review your category");
        }
        blogPost1.setCategory(category);
        blogPost1.setAuthor(author);
        blogPost1.setPostStatus("Unpublished");
        blogPostRepository.save(blogPost1);
        return modelMapper.map(blogPost, BlogResponseDto.class);
    }

    @Override
    public BlogResponseDto getBlogPostById(String blogPostId) {
        BlogPost blogPost = blogPostRepository.findById(blogPostId).orElseThrow();
        return modelMapper.map(blogPost, BlogResponseDto.class);
    }
    @Override
    public List<BlogPost> getBlogPostByPublishedDate(Date blogPostPublishedDate) {
        return blogPostRepository.findBlogPostByPublishedDate(blogPostPublishedDate);
       /* List<BlogResponseDto> blogResponseDto=new ArrayList<>();
        for (BlogPost blogPost1:blogPost){
            BlogResponseDto responseDto=modelMapper.map(blogPost1, BlogResponseDto.class);
            blogResponseDto.add(responseDto);
        }
        return blogResponseDto;*/
    }

    @Override
    public List<BlogResponseDto> getAllBlogpost() {
        List<BlogPost> posts = blogPostRepository.findAll();
        List<BlogResponseDto> blogResponseDto = new ArrayList<>();
        for (BlogPost blogPost : posts) {
            if (blogPost.getPostStatus().equals("Published")) {
                BlogResponseDto blogResponseDto1 = modelMapper.map(blogPost, BlogResponseDto.class);
                blogResponseDto.add(blogResponseDto1);
            }
        }
        return blogResponseDto;
    }

    @Override
    public BlogResponseDto editBlogPost(String blogPostId, BlogPostRequestDto blogPost) {
        blogPostRepository.findById(blogPostId).orElseThrow();
        BlogPost blogPost2 = modelMapper.map(blogPost, BlogPost.class);
        Category category = categoryService.getCategoryByName(blogPost.getCategoryName());
        Author author = authorService.getAuthorByUsername(blogPost.getAuthorUserName());
        if (category == null) {
            throw new RuntimeException("Category does not exist! Please review your category");
        }
        blogPost2.setCategory(category);
        blogPost2.setBlogPostId(blogPostId);
        blogPost2.setAuthor(author);
        blogPostRepository.save(blogPost2);
        return modelMapper.map(blogPost2, BlogResponseDto.class);
    }
}
