package com.microservices.Blog_App_2.mapper.PostMapper;

import com.microservices.Blog_App_2.dto.PostDTO;
import com.microservices.Blog_App_2.entity.Post;
import com.microservices.Blog_App_2.mapper.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class, componentModel = "spring", uses = PostDTO.class)
public interface DTOToEntity {
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "content", target = "content")
    Post postDTOToEntity(PostDTO post);
}
