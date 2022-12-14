package com.nseit.SocioGram.repository;

import com.nseit.SocioGram.model.SocioUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SocioUser, Integer>{
    SocioUser findByName(String name);


}