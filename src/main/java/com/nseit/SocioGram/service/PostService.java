package com.nseit.SocioGram.service;


import com.nseit.SocioGram.model.Post;
import com.nseit.SocioGram.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
