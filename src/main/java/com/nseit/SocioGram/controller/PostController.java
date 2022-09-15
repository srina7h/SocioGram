package com.nseit.SocioGram.controller;


import com.nseit.SocioGram.model.Post;
import com.nseit.SocioGram.request.PostRequest;
import com.nseit.SocioGram.response.APIResponse;
import com.nseit.SocioGram.response.PostResponse;
import com.nseit.SocioGram.response.SuccessResponse;
import com.nseit.SocioGram.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = {"http://localhost:3000"})
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private APIResponse apiResponse;

    //    @Secured({Role.ROLE_USER})
    @PostMapping
    public ResponseEntity<APIResponse> uploadPost(@RequestBody PostRequest postRequest) {
        Post post = postService.add(postRequest);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(post);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    //    @Secured({Role.ROLE_USER})
    @PutMapping
    public ResponseEntity<APIResponse> editPost(@RequestBody PostRequest postRequest) {
        Post post = postService.editPost(postRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(post);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);

    }

    //    @Secured({Role.ROLE_USER})
    @GetMapping("/all")
    public ResponseEntity<APIResponse> viewPost() {
        List<PostResponse> posts = postService.viewPosts();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(posts);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    //    @Secured({Role.ROLE_USER})
    @GetMapping("/{userId}")
    public ResponseEntity<APIResponse> viewPostById(@PathVariable Integer userId) {
        List<PostResponse> posts = postService.getAllUserPost(userId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(posts);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    //    @Secured({Role.ROLE_USER})

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(new SuccessResponse());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


}