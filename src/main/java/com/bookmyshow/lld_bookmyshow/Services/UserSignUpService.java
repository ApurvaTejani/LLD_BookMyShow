package com.bookmyshow.lld_bookmyshow.Services;

import com.bookmyshow.lld_bookmyshow.Models.User;
import com.bookmyshow.lld_bookmyshow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSignUpService {


    private UserRepository ur;

    @Autowired
    public UserSignUpService(UserRepository ur) {
        this.ur = ur;
    }

    public User signUpUser(String email, String name, String password){
        Optional<User> userOptional= ur.findUserByEmail(email);
        if(userOptional.isPresent()){
            throw new RuntimeException("User is already present");
        }
        User user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setPassword(password);

        User savedUser =ur.save(user);
        return savedUser;

    }
}
