package com.nseit.SocioGram.controller;


import com.nseit.SocioGram.model.Post;
import com.nseit.SocioGram.model.User;
import com.nseit.SocioGram.service.PostService;
import com.nseit.SocioGram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public void add(@RequestBody Post post) {

        postService.add(post);
    }

    @PutMapping
    public void update(@RequestBody Post post) {

        postService.update(post);
    }
}
