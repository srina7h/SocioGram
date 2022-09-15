package com.nseit.SocioGram.response;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostResponse {
    private Integer id;
    private byte[] image;
    private String details;

}
