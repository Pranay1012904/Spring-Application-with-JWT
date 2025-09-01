package com.microservices.Blog_App_2.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservices.Blog_App_2.entity.Post;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    Post createPost(Post post);

    List<Post> getAllPost();

    Post getPostById(Long id);

    String deletePostById(Long id)throws JsonProcessingException;

}
