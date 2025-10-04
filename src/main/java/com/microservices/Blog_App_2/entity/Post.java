package com.microservices.Blog_App_2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", cascade=CascadeType.ALL,orphanRemoval = true)
    Set<Comment> comments=new HashSet<>();
}
