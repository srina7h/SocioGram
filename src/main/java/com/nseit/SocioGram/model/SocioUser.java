package com.nseit.SocioGram.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class SocioUser {
    @Id
    @GeneratedValue
    public Integer id;
    public String name;
    public String password;
    public String email;
    public Long phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "socioUser")
    private Set<Follower> userId;

    @JsonIgnore
    @OneToMany(mappedBy = "followerUser")
    private Set<Follower> followerId;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> post;

    @ManyToMany
    @JsonIgnore
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JoinTable(joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "like_post",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Post> likePost;


    public SocioUser(String name, String password) {
        this.name = name;
        this.password = password;
    }


}
