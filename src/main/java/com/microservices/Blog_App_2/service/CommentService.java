package com.microservices.Blog_App_2.service;

import com.microservices.Blog_App_2.dto.CommentDTO;

public interface CommentService {

    CommentDTO createComment(Long postId, CommentDTO comment);
}
