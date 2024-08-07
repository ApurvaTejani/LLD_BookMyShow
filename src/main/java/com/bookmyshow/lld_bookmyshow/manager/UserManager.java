package com.bookmyshow.lld_bookmyshow.manager;

import com.bookmyshow.lld_bookmyshow.Controllers.UserSignUpController;
import com.bookmyshow.lld_bookmyshow.Repository.UserRepository;
import com.bookmyshow.lld_bookmyshow.dtos.UserRequestDTO;
import com.bookmyshow.lld_bookmyshow.dtos.UserResponseDTO;

import java.util.Scanner;

public class UserManager {


    public void initializeUser(UserSignUpController usc, Scanner sc) {

        while(true){
            UserRequestDTO requestDTO = new UserRequestDTO();
            System.out.println("Enter if you are Admin, Owner or Customer");
            String role=sc.nextLine();
            if(role.equals("Customer")) {
                System.out.println("Enter the EmailId: ");
                String email = sc.nextLine();
                System.out.println("Enter your name: ");
                String name = sc.nextLine();
                System.out.println("Enter your password: ");
                String pass = sc.nextLine();
                requestDTO.setEmail(email);
                requestDTO.setName(name);
                requestDTO.setPassword(pass);
            }
            System.out.println("Do you want to exit");
            String check = sc.nextLine();
            UserResponseDTO responseDTO = usc.signUpUser(requestDTO);

            if(check.equalsIgnoreCase("yes")){
                break;
            }
        }

    }
}
