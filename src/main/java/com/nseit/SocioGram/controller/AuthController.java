package com.nseit.SocioGram.controller;

import com.nseit.SocioGram.exception.ResourceNotFoundException;
import com.nseit.SocioGram.model.SocioUser;
import com.nseit.SocioGram.response.APIResponse;
import com.nseit.SocioGram.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private APIResponse apiResponse;

    @PostMapping("/register")
    public ResponseEntity<SocioUser> register(@RequestBody SocioUser socioUser) {
        APIResponse apiResponse = new APIResponse();
        SocioUser registeredUser = authService.registerAsUser(socioUser);
        if (registeredUser == null) {
            throw new ResourceNotFoundException("Unable to register User");
        }
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody SocioUser socioUser) {
        APIResponse apiResponse = new APIResponse();
        SocioUser loggedInUser = authService.loginAsUser(socioUser);
        if (loggedInUser == null) {
            throw new ResourceNotFoundException("User Not found");
        }
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(loggedInUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SocioUser>> getAllUsers() {
        List<SocioUser> socioUsers = authService.getAllUsers();
        if (socioUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(socioUsers, HttpStatus.OK);
    }


}
