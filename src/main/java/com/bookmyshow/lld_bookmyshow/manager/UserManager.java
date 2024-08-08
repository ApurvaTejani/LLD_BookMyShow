package com.bookmyshow.lld_bookmyshow.manager;

import com.bookmyshow.lld_bookmyshow.Controllers.TheatreSetupController;
import com.bookmyshow.lld_bookmyshow.Controllers.UserSignUpController;
import com.bookmyshow.lld_bookmyshow.Models.enums.Role;
import com.bookmyshow.lld_bookmyshow.Repository.UserRepository;
import com.bookmyshow.lld_bookmyshow.dtos.TheatreSetupRequestDTO;
import com.bookmyshow.lld_bookmyshow.dtos.TheatreSetupResponseDTO;
import com.bookmyshow.lld_bookmyshow.dtos.UserRequestDTO;
import com.bookmyshow.lld_bookmyshow.dtos.UserResponseDTO;

import java.util.Scanner;

public class UserManager {


    public void initializeUser(UserSignUpController usc, TheatreSetupController tsc,Scanner sc) {

        while(true){
            UserRequestDTO requestDTO = new UserRequestDTO();
            TheatreSetupRequestDTO requestDTO1= new TheatreSetupRequestDTO();
            System.out.println("Enter if you are Admin, Owner or Customer");
            String role=sc.nextLine();
                System.out.println("Enter the EmailId: ");
                String email = sc.nextLine();
                System.out.println("Enter your name: ");
                String name = sc.nextLine();
                System.out.println("Enter your password: ");
                String pass = sc.nextLine();
                requestDTO.setEmail(email);
                requestDTO.setName(name);
                requestDTO.setPassword(pass);
                requestDTO.setRole(role);
             if (role.equals("Admin")) {
                System.out.println("Enter the City to be added: ");
                String city= sc.nextLine();
                requestDTO1.setCityname(city);
                System.out.println("Enter the Theatre name and address");
                String theatreName=sc.nextLine();
                requestDTO1.setTheatreName(theatreName);
                String theatreAddress=sc.nextLine();
                requestDTO1.setTheatreAddress(theatreAddress);
            }
            System.out.println("Do you want to exit");
            String check = sc.nextLine();
            UserResponseDTO responseDTO = usc.signUpUser(requestDTO);
            TheatreSetupResponseDTO responseDTO1=tsc.setUpCity(requestDTO1);

            if(check.equalsIgnoreCase("yes")){
                break;
            }
        }

    }
}
