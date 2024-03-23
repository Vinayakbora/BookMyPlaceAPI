package com.bajaj.bookmyplace.services;

import com.bajaj.bookmyplace.models.CustomUserDetails;
import com.bajaj.bookmyplace.models.User;
import com.bajaj.bookmyplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;
    public User createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       User userCreated =  userRepository.save(user);
       return userCreated;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()){
            throw new UsernameNotFoundException("User Doesnt Exist!!");
        }
        return new CustomUserDetails(userOptional.get());
    }
}
