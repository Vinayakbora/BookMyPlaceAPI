package com.bajaj.bookmyplace.controllers;

import com.bajaj.bookmyplace.services.ProfileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    @Autowired
    ProfileServices profileServices;

    @GetMapping("/{name}")
    public ResponseEntity<Object> getProfile(@PathVariable String name) {
        return  new ResponseController().generateResponse("User Found ", HttpStatus.OK, profileServices.getSingleUser(name));
    }
}
