package com.nseit.SocioGram.controller;


import com.nseit.SocioGram.model.Post;
import com.nseit.SocioGram.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public void uploadPost(@RequestBody Post post) {
       // Post post1= new

        postService.add(post);
    }

    @PutMapping
    public void editPost(@RequestBody Post post) {

        postService.update(post);
    }
    @GetMapping
    public void viewPost(){
        postService.viewPosts();
    }

    @DeleteMapping
    public void deletePost(int id){
        postService.delete(id);
    }

}
