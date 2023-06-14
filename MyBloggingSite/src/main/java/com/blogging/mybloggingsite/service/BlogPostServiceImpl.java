package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.dto.BlogPostRequestDto;
import com.blogging.mybloggingsite.dto.BlogResponseDto;
import com.blogging.mybloggingsite.model.Author;
import com.blogging.mybloggingsite.model.BlogPost;
import com.blogging.mybloggingsite.model.Category;
import com.blogging.mybloggingsite.repo.AuthorRepository;
import com.blogging.mybloggingsite.repo.BlogPostRepository;
import com.blogging.mybloggingsite.repo.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {
    private final BlogPostRepository blogPostRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Override
    public BlogResponseDto addNewBlogPost(BlogPostRequestDto blogPost) {
        BlogPost blogPost1 = modelMapper.map(blogPost, BlogPost.class);
        Category category = categoryRepository.findCategoryByCategoryName(blogPost.getCategoryName());
        Author author = authorRepository.findByUserName(blogPost.getAuthorUserName()).orElseThrow();
        if (category == null) {
            throw new RuntimeException("Category does not exist! Please review your category");
        }
        blogPost1.setCategory(category);
        blogPost1.setAuthor(author);
        blogPostRepository.save(blogPost1);
        return modelMapper.map(blogPost, BlogResponseDto.class);
    }

    @Override
    public BlogResponseDto getBlogPostById(String blogPostId) {
        BlogPost blogPost = blogPostRepository.findById(blogPostId).orElseThrow();
        return modelMapper.map(blogPost, BlogResponseDto.class);
    }

    @Override
    public List<BlogResponseDto> getAllBlogpost() {
        List<BlogPost> posts = blogPostRepository.findAll();
        List<BlogResponseDto> blogResponseDtos = new ArrayList<>();
        for (BlogPost blogPost : posts) {
            BlogResponseDto blogResponseDto = modelMapper.map(blogPost, BlogResponseDto.class);
            blogResponseDtos.add(blogResponseDto);
        }
        return blogResponseDtos;
    }

    @Override
    public BlogResponseDto editBlogPost(String blogPostId, BlogPostRequestDto blogPost) {
        BlogPost blogPost1 = blogPostRepository.findById(blogPostId).orElseThrow();
        BlogPost blogPost2 = modelMapper.map(blogPost, BlogPost.class);
        Category category = categoryRepository.findCategoryByCategoryName(blogPost.getCategoryName());
        Author author = authorRepository.findByUserName(blogPost.getAuthorUserName()).orElseThrow();
        if (category==null) {
            throw new RuntimeException("Category does not exist! Please review your category");
        }
        blogPost2.setCategory(category);
        blogPost2.setBlogPostId(blogPostId);
        blogPost2.setAuthor(author);
        blogPostRepository.save(blogPost2);
        return modelMapper.map(blogPost2, BlogResponseDto.class);
    }
}
