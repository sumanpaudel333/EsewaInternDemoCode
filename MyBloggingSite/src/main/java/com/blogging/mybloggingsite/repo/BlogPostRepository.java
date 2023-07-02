package com.blogging.mybloggingsite.repo;

import com.blogging.mybloggingsite.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost,String> {
    List<BlogPost> findBlogPostByAuthor_AuthorId(Long authorId);
    List<BlogPost> findBlogPostByPublishedDate(Date date);
}
