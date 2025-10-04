package com.microservices.Blog_App_2.mapper.CommentMapper;

import com.microservices.Blog_App_2.dto.CommentDTO;
import com.microservices.Blog_App_2.dto.PostDTO;
import com.microservices.Blog_App_2.entity.Comment;
import com.microservices.Blog_App_2.mapper.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig .class, componentModel = "spring", uses = PostDTO .class)
public interface CommentDTOToEntity {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "body", target = "body")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "name", target = "name")
    Comment commentDTOToEntity(CommentDTO comment);
}