package com.microservices.Blog_App_2.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.Blog_App_2.entity.Post;
import com.microservices.Blog_App_2.exception.ResourceNotFoundException;
import com.microservices.Blog_App_2.mapper.PostMapper.EntityToDTO;
import com.microservices.Blog_App_2.repository.PostRepository;
import com.microservices.Blog_App_2.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import com.microservices.Blog_App_2.dto.*;

@Slf4j
@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    private PostRepository postRepository;
    private EntityToDTO entityToDTO;

    @Override
    public Post createPost(Post post) {
        logger.info(String.format("CLASS::%s", this.getClass().getSimpleName()));
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    @Override
    public PostResponse getAllPost(int pageNo, int pageSize) {
        logger.debug(String.format("CLASS::%s METHOD::GETALLPOSTS", this.getClass().getSimpleName()));
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Post> allPosts = postRepository.findAll(pageable);
        List<Post> postList=allPosts.getContent();
        List<PostDTO> posts=postList.stream()
                .map(p->{
                    return entityToDTO.postEntityToDTO(p);
                }).toList();
        PostResponse postResponse=new PostResponse(
                allPosts.getNumber(),
                posts,
                allPosts.getSize(),
                allPosts.getTotalElements(),
                allPosts.getTotalPages(),
                allPosts.isLast()
        );
        return postResponse;
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
        hm.put(id, "POST DELETED");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(hm);
    }

}
