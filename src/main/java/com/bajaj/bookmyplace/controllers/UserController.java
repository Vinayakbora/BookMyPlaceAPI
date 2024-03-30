package com.bajaj.bookmyplace.controllers;

import com.bajaj.bookmyplace.models.AuthRequest;
import com.bajaj.bookmyplace.models.ErrorModel;
import com.bajaj.bookmyplace.models.LoginResponse;
import com.bajaj.bookmyplace.models.User;
import com.bajaj.bookmyplace.services.JWTService;
import com.bajaj.bookmyplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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

    @GetMapping("/test")
    public String get(){
        return "Endpoint working";
    }

    @PostMapping("/register")

    public User create(@RequestBody User user){
     return  userService.createUser(user);

    }

    @PostMapping("/login")

    public LoginResponse login(@RequestBody AuthRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        if (authentication.isAuthenticated()) {
            String authToken = jwtService.generateToken(request.getUsername());
            User user = userService.getUserBuUsername(request.getUsername());
            LoginResponse loginResponse = new LoginResponse(authToken, request.getUsername(), user.getEmail(), null);
            return  loginResponse;
        }
        else{
            ErrorModel errorModel = new ErrorModel("204","Invalid UserName Or Password");
             LoginResponse loginResponse = new LoginResponse(null, null, null,errorModel );
            return  loginResponse;
        }
    }

    @GetMapping("/protected")

    public String test(){
        return "All Good with Token";
    }


}
