package com.nseit.SocioGram.service;


import com.nseit.SocioGram.exception.ResourceNotFoundException;
import com.nseit.SocioGram.model.File;
import com.nseit.SocioGram.model.Post;
import com.nseit.SocioGram.model.SocioUser;
import com.nseit.SocioGram.repository.FileRepository;
import com.nseit.SocioGram.repository.PostRepository;
import com.nseit.SocioGram.repository.UserRepository;
import com.nseit.SocioGram.request.PostRequest;
import com.nseit.SocioGram.response.PostResponse;
import com.nseit.SocioGram.utils.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileRepository fileRepository;

    public Post add(PostRequest postRequest) {
        SocioUser socioUser = userRepository.findById(postRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("User does not exist"));

        Post newPost = new Post();
        newPost.setUser(socioUser);
        newPost.setDetails(postRequest.getDetails());
        newPost.setImage(postRequest.getImage());

        File file = fileRepository.findById(postRequest.getFileId()).orElseThrow(() -> new ResourceNotFoundException("File not found"));
        newPost.setFile(file);

        return postRepository.save(newPost);
    }

    public Post editPost(PostRequest postRequest) {
        Post post = new Post();
        if (postRequest.getId() == null)
            throw new ResourceNotFoundException("No post with the id " + postRequest.getId());

        File file = fileRepository.findById(postRequest.getFileId()).orElseThrow(() -> new ResourceNotFoundException("File not found"));
        post.setFile(file);
        return postRepository.save(post);
    }

    public List<PostResponse> viewPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            PostResponse postResponse = new PostResponse();
            postResponse.setId(post.getId());
            postResponse.setDetails(post.getDetails());
            if (post.getFile() != null && post.getFile().getImage() != null) {
                postResponse.setImage(ImageUtility.decompressImage(post.getFile().getImage()));
                System.out.println(post.getFile().getImage());
            } else
                System.out.println("abcd");
            postResponses.add(postResponse);
        }
        return postResponses;
    }

    public PostResponse findPostById(Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Unable to find post with id " + postId));

        PostResponse postResponse = new PostResponse();
        postResponse.setId(post.getId());
        postResponse.setDetails(post.getDetails());
        if (post.getFile() != null && post.getFile().getImage() != null)
            postResponse.setImage(ImageUtility.decompressImage(post.getFile().getImage()));

        return postResponse;
    }

    public void deletePost(Integer id) {
        postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No posts" + id));
        postRepository.deleteById(id);
    }

    public List<PostResponse> getAllUserPost(Integer userId) {
        SocioUser user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("u d e"));
        List<Post> posts = postRepository.findAllByUser(user);

        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            PostResponse postResponse = new PostResponse();
            postResponse.setId(post.getId());
            postResponse.setDetails(post.getDetails());
            if (post.getFile() != null && post.getFile().getImage() != null)
                postResponse.setImage(ImageUtility.decompressImage(post.getFile().getImage()));
            postResponses.add(postResponse);
        }
        return postResponses;
    }
}