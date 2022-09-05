package com.nseit.SocioGram.service;


import com.nseit.SocioGram.exception.ResourceNotFoundException;
import com.nseit.SocioGram.model.Post;
import com.nseit.SocioGram.model.SocioUser;
import com.nseit.SocioGram.repository.PostRepository;
import com.nseit.SocioGram.repository.UserRepository;
import com.nseit.SocioGram.request.PostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public Post add(PostRequest postRequest) {
        SocioUser socioUser = userRepository.findById(postRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist"));

        Post newPost = new Post();
        newPost.setUser(socioUser);
        newPost.setDetails(postRequest.getDetails());
        newPost.setImage(postRequest.getImage());

        return postRepository.save(newPost);
    }

    public void update(Post post) {

        postRepository.save(post);
    }

    public List<Post> viewPosts() {
        return postRepository.findAll();

    }

    public void delete(int id) {
        for (Post post : postRepository.findAll()) {
            if (id == post.getId()) {
                postRepository.delete(post);
            }
        }
    }
}