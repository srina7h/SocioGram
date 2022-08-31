package com.nseit.SocioGram.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    public Integer id;
    public String image;
    public String details;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime dateTime;
    @ManyToMany(mappedBy = "post")
    private List<SocioUser> user;

}
