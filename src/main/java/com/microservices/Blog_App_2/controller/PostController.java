package com.microservices.Blog_App_2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservices.Blog_App_2.dto.*;
import com.microservices.Blog_App_2.entity.Post;
import com.microservices.Blog_App_2.mapper.PostMapper.DTOToEntity;
import com.microservices.Blog_App_2.mapper.PostMapper.EntityToDTO;
import com.microservices.Blog_App_2.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/post/api")
@AllArgsConstructor
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    private PostService postService;
    private DTOToEntity dtoToEntity;
    private EntityToDTO entityToDTO;

    @PostMapping("/create")
    public ResponseEntity<PostDTO> createPost(@RequestBody Optional<PostDTO> post) {
        logger.debug(String.format("CLASS :: %s", this.getClass().getSimpleName()));
        if (post.isEmpty())
            throw new RuntimeException("REQUEST BODY EMPTY");
        Post savedPost = postService.createPost(dtoToEntity.postDTOToEntity(post.get()));
        return new ResponseEntity<>(entityToDTO.postEntityToDTO(savedPost), HttpStatus.OK);
    }

    @GetMapping("/getAllPosts")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNO", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize
    ) {
        PostResponse response = postService.getAllPost(pageNo, pageSize);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<PostDTO> getPostById(@RequestParam Long id) {
        Post post = postService.getPostById(id);
        PostDTO postDTO = entityToDTO.postEntityToDTO(post);
        return new ResponseEntity<>(postDTO, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePostById(@RequestParam Long id) throws JsonProcessingException {
        String response = postService.deletePostById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
