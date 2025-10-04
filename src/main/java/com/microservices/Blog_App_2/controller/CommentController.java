package com.microservices.Blog_App_2.controller;

import com.microservices.Blog_App_2.dto.CommentDTO;
import com.microservices.Blog_App_2.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/comment/api")
public class CommentController {

    private CommentService commentService;

    @PostMapping("/create/{postId}")
    public ResponseEntity<CommentDTO> createComment(@PathVariable Long postId,
                                                    @RequestBody CommentDTO commentDTO) {
        CommentDTO savedComment = commentService.createComment(postId, commentDTO);
        return new ResponseEntity<>(savedComment, HttpStatus.OK);
    }


}
