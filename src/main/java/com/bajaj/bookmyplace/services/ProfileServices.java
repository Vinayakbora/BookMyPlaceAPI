package com.bajaj.bookmyplace.services;


import com.bajaj.bookmyplace.exceptions.CommonException;
import com.bajaj.bookmyplace.models.User;
import com.bajaj.bookmyplace.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileServices {


    @Autowired
    ProfileRepository profileRepository;

    public User getSingleUser(String name) {
        Optional<User> optionalUser = profileRepository.findByName(name);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new CommonException("User with this doest not exists");
        }
    }

}
