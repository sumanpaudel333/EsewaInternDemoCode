package com.blogging.mybloggingsite.repo;

import com.blogging.mybloggingsite.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost,String> {
}
