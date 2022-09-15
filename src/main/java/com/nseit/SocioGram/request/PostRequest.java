package com.nseit.SocioGram.request;

import lombok.Data;

@Data
public class PostRequest {
    private Integer id;
    private String image;
    private String details;
    private Integer userId;
    private Integer fileId;
}
