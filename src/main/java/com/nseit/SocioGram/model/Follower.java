package com.nseit.SocioGram.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "follower")
public class Follower {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private SocioUser socioUser;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "follower_id", referencedColumnName = "id")
    private SocioUser followerUser;

    private Boolean isApproved;
}
