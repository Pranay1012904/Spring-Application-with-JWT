package com.microservices.Blog_App_2.repository;

import com.microservices.Blog_App_2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
