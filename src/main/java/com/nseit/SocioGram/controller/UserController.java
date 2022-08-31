package com.nseit.SocioGram.controller;

import com.nseit.SocioGram.model.SocioUser;
import com.nseit.SocioGram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public void add(@RequestBody SocioUser user) {
        userService.add(user);
    }
    @PutMapping
    public void update(@RequestBody SocioUser user) {
        userService.update(user);
    }
//    @GetMapping
//    public void

}
