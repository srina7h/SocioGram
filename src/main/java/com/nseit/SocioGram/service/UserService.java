package com.nseit.SocioGram.service;


import com.nseit.SocioGram.model.User;
import com.nseit.SocioGram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void add(User user){

    }
}
