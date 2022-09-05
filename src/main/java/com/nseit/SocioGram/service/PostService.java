package com.nseit.SocioGram.service;


import com.nseit.SocioGram.model.Post;
import com.nseit.SocioGram.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void add(Post post) {
        postRepository.save(post);

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