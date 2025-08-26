package com.microservices.Blog_App_2.repository;

import com.microservices.Blog_App_2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
