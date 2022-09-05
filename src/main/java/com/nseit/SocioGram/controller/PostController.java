package com.nseit.SocioGram.controller;


import com.nseit.SocioGram.model.Post;
import com.nseit.SocioGram.request.PostRequest;
import com.nseit.SocioGram.response.APIResponse;
import com.nseit.SocioGram.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private APIResponse apiResponse;

    @PostMapping
    public ResponseEntity<APIResponse> uploadPost(@RequestBody PostRequest postRequest) {
        Post post = postService.add(postRequest);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(post);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public void editPost(@RequestBody Post post) {

        postService.update(post);
    }

    @GetMapping
    public void viewPost() {
        postService.viewPosts();
    }

    @DeleteMapping
    public void deletePost(int id) {
        postService.delete(id);
    }

}
