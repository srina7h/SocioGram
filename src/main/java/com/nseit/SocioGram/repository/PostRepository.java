package com.nseit.SocioGram.repository;

import com.nseit.SocioGram.model.Post;
import com.nseit.SocioGram.model.SocioUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByUser(SocioUser user);
}
