package com.microservices.Blog_App_2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "comments")
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "body",nullable = false)
    private String body;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "username",nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY) //multipule comments to one post
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

}
