package com.nseit.SocioGram.service;

import com.nseit.SocioGram.model.Follower;
import com.nseit.SocioGram.model.SocioUser;
import com.nseit.SocioGram.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FollowerService {

    @Autowired
    private FollowerRepository followRepository;

    public void follow(SocioUser user, Follower follower){
        follower.setIsApproved(true);

    }
}
