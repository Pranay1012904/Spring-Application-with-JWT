package com.microservices.Blog_App_2.controller;

import com.microservices.Blog_App_2.dto.PostDTO;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
