package com.nseit.SocioGram.controller;

import com.nseit.SocioGram.model.Post;
import com.nseit.SocioGram.model.User;
import com.nseit.SocioGram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public void add(@RequestBody User user) {
        userService.add(user);
    }
    @PutMapping
    public void update(@RequestBody User user) {
        userService.update(user);
    }
//    @GetMapping
//    public void

}
