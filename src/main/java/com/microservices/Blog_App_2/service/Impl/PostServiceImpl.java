package com.microservices.Blog_App_2.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.Blog_App_2.entity.Post;
import com.microservices.Blog_App_2.exception.ResourceNotFoundException;
import com.microservices.Blog_App_2.repository.PostRepository;
import com.microservices.Blog_App_2.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor

public class PostServiceImpl implements PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    private PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        logger.info(String.format("CLASS::%s", this.getClass().getSimpleName()));
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    @Override
    public List<Post> getAllPost() {
        logger.debug(String.format("CLASS::%s METHOD::GETALLPOSTS", this.getClass().getSimpleName()));
        List<Post> allPosts = postRepository.findAll();
        return allPosts;
    }

    @Override
    public Post getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("POST WITH ID :: %d NOT FOUND", id)));
        return post;
    }

    @Override
    public String deletePostById(Long id) throws JsonProcessingException {
        getPostById(id);
        postRepository.deleteById(id);
        HashMap<Long, String> hm = new HashMap<>();
        hm.put(id,"POST DELETED");
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(hm);
    }

}
