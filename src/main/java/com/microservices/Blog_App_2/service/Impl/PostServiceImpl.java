package com.microservices.Blog_App_2.service.Impl;

import com.microservices.Blog_App_2.entity.Post;
import com.microservices.Blog_App_2.repository.PostRepository;
import com.microservices.Blog_App_2.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor

public class PostServiceImpl implements PostService {

    private static final Logger logger= LoggerFactory.getLogger(PostServiceImpl.class);

    private PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        logger.info(String.format("CLASS::%s",this.getClass().getSimpleName()));
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

}
