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
@CrossOrigin(value = {"http://localhost:3000/"})
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private APIResponse apiResponse;

    @PostMapping("/register")
    public ResponseEntity<APIResponse> register(@RequestBody SocioUser socioUser) {
        SocioUser registeredUser = authService.registerAsUser(socioUser);
        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(registeredUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody SocioUser socioUser) {
        SocioUser loggedInUser = authService.loginAsUser(socioUser);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(loggedInUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllUsers() {
        List<SocioUser> socioUsers = authService.getAllUsers();
        if (socioUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(socioUsers);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
