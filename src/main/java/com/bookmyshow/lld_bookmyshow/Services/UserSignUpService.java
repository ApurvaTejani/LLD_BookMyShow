package com.bookmyshow.lld_bookmyshow.Services;

import com.bookmyshow.lld_bookmyshow.Models.User;
import com.bookmyshow.lld_bookmyshow.Models.enums.Role;
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

    public User signUpUser(String email, String name, String password,String role){
        Optional<User> userOptional= ur.findUserByEmail(email);
        if(userOptional.isPresent()){
            throw new RuntimeException("User is already present");
        }
        User user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setPassword(password);
        if(role.equals("Customer")){
            user.setRoles(Role.CUSTOMER);
        } else if (role.equals("Admin")) {
            user.setRoles(Role.ADMIN);
        } else if (role.equals("Owner")) {
            user.setRoles(Role.OWNER);
        }

        User savedUser =ur.save(user);
        return savedUser;

    }
}
