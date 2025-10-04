package com.microservices.Blog_App_2.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private String body;
    private String email;
    private String name;
}
