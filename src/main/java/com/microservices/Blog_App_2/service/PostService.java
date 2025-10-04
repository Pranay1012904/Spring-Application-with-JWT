package com.microservices.Blog_App_2.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservices.Blog_App_2.entity.Post;
import com.microservices.Blog_App_2.dto.PostResponse;


public interface PostService {

    Post createPost(Post post);

    PostResponse getAllPost(int pageNo, int pageSize);

    Post getPostById(Long id);

    String deletePostById(Long id)throws JsonProcessingException;

}
