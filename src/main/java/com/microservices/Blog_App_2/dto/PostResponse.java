package com.microservices.Blog_App_2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
public class PostResponse {
    public PostResponse(int pageNo, List<PostDTO> postDTOList, int pageSize, long totalElements, int totalPages, boolean last) {
        this.pageNo = pageNo;
        this.postDTOList = postDTOList;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.last = last;
    }

    private List<PostDTO> postDTOList;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
