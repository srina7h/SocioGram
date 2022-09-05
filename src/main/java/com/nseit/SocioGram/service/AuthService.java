package com.nseit.SocioGram.service;


import com.nseit.SocioGram.exception.ResourceNotFoundException;
import com.nseit.SocioGram.exception.UserExistException;
import com.nseit.SocioGram.model.Role;
import com.nseit.SocioGram.model.SocioUser;
import com.nseit.SocioGram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public SocioUser registerAsUser(SocioUser socioUser) {
        SocioUser user = userRepository.findByName(socioUser.getName());
        if (user != null) {
            throw new UserExistException("User Already Exists");
        }
        Role role = new Role();
        role.setName(Role.ROLE_USER);
        socioUser.setRoles(Set.of(role));
        socioUser.setPassword(bCryptPasswordEncoder.encode(socioUser.getPassword()));
        return userRepository.save(socioUser);
    }

    public List<SocioUser> getAllUsers() {
        return userRepository.findAll();
    }
    public SocioUser loginAsUser(SocioUser socioUser) {
        SocioUser user = userRepository.findByName(socioUser.getName());
        if (user != null && bCryptPasswordEncoder.matches(socioUser.getPassword(), user.getPassword())) {
            return user;
        } else {
            throw new ResourceNotFoundException("Invalid username or password.");
        }

    }

}
