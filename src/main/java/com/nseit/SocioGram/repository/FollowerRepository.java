package com.nseit.SocioGram.repository;

import com.nseit.SocioGram.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerRepository extends JpaRepository<Post, Integer>{

}