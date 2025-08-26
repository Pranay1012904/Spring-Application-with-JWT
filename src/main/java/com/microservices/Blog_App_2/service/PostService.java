package com.microservices.Blog_App_2.service;

import com.microservices.Blog_App_2.entity.Post;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


public interface PostService {

    Post createPost(Post post);

}
