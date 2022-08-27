package com.nseit.SocioGram.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
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
//    private Date joinedDate;
    public LocalDateTime dateTime;
    @ManyToMany(mappedBy = "post")
    private List<User> user;

}
