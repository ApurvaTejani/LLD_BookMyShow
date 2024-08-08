package com.bookmyshow.lld_bookmyshow.Controllers;

import com.bookmyshow.lld_bookmyshow.Models.User;
import com.bookmyshow.lld_bookmyshow.Services.UserSignUpService;
import com.bookmyshow.lld_bookmyshow.dtos.UserRequestDTO;
import com.bookmyshow.lld_bookmyshow.dtos.UserResponseDTO;
import com.bookmyshow.lld_bookmyshow.dtos.UserResponseStatus;
import org.springframework.stereotype.Controller;


@Controller
public class UserSignUpController {
    private UserSignUpService us;

    public UserSignUpController(UserSignUpService us) {
        this.us = us;
    }

    public UserResponseDTO signUpUser(UserRequestDTO requestDTO){
        UserResponseDTO responseDTO= new UserResponseDTO();
        try{
            User user =us.signUpUser(requestDTO.getEmail(),requestDTO.getName(),requestDTO.getPassword(), requestDTO.getRole());
            responseDTO.setResponseStatus(UserResponseStatus.SUCCESS);
            responseDTO.setUserId(user.getId());
        }
        catch (Exception ex){
            responseDTO.setResponseStatus(UserResponseStatus.FAILED);
            responseDTO.setMessage(ex.getMessage());
        }
        return responseDTO;
    }

}
