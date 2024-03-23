package com.bajaj.bookmyplace.controllers;

import com.bajaj.bookmyplace.models.AuthRequest;
import com.bajaj.bookmyplace.models.User;
import com.bajaj.bookmyplace.services.JWTService;
import com.bajaj.bookmyplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private  UserService userService;
    @Autowired
    private JWTService jwtService;

    @GetMapping("/")
    public String get(){
        return "Endpoint working";
    }

    @PostMapping("/")

    public User create(@RequestBody User user){
     return  userService.createUser(user);

    }

    @PostMapping("/login/")

    public String login(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(request.getUsername());
        }
        else{
            return "Something Wrong";
        }
    }

    @GetMapping("/protected")

    public String test(){
        return "All Good with Token";
    }


}
