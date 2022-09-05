package com.nseit.SocioGram.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    private String image;
    private String details;
    @CreationTimestamp
    private LocalDateTime dateTime;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private SocioUser user;
    @JsonIgnore
    @ManyToMany(mappedBy = "likePost",cascade = CascadeType.ALL)
    private List<SocioUser> follower;

    public Post() {
        this.dateTime = LocalDateTime.now();
    }
}
