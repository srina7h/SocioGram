package com.nseit.SocioGram.controller;


import com.nseit.SocioGram.response.APIResponse;
import com.nseit.SocioGram.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = {"http://localhost:3000/"})
@RequestMapping("/api/follower")
public class FollowerController {
    @Autowired
    private FollowerService followerService;

    @Autowired
    private APIResponse apiResponse;

//    @PostMapping
//    public ResponseEntity<APIResponse>

}
