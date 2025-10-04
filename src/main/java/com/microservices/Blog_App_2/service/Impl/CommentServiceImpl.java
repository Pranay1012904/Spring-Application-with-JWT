package com.microservices.Blog_App_2.service.Impl;

import com.microservices.Blog_App_2.dto.CommentDTO;
import com.microservices.Blog_App_2.entity.Comment;
import com.microservices.Blog_App_2.entity.Post;
import com.microservices.Blog_App_2.exception.ResourceNotFoundException;
import com.microservices.Blog_App_2.mapper.CommentMapper.CommentDTOToEntity;
import com.microservices.Blog_App_2.mapper.CommentMapper.CommentEntityToDTO;
import com.microservices.Blog_App_2.repository.CommentRepository;
import com.microservices.Blog_App_2.repository.PostRepository;
import com.microservices.Blog_App_2.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private CommentDTOToEntity dtoToEntity;
    private CommentEntityToDTO entityToDTO;

    @Override
    public CommentDTO createComment(Long postId, CommentDTO comment) {
        logger.info(String.format("CLASS::%s METHOD::createComment", this.getClass().getSimpleName()));
        Post fetchedPost = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException(String.format("String with ID %d not found !", postId)));
        Comment commentEntity = dtoToEntity.commentDTOToEntity(comment);
        commentEntity.setPost(fetchedPost);
        Comment savedComment = commentRepository.save(commentEntity);
        return entityToDTO.commentEntityToDTO(savedComment);
    }
}
