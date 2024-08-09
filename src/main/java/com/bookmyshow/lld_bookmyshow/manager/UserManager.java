package com.bookmyshow.lld_bookmyshow.manager;

import com.bookmyshow.lld_bookmyshow.Controllers.AuditoriumController;
import com.bookmyshow.lld_bookmyshow.Controllers.TheatreSetupController;
import com.bookmyshow.lld_bookmyshow.Controllers.UserSignUpController;
import com.bookmyshow.lld_bookmyshow.dtos.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {


    public void initializeUser(UserSignUpController usc, TheatreSetupController tsc, AuditoriumController ac,Scanner sc) {

        while(true){
            UserRequestDTO requestDTO = new UserRequestDTO();
            TheatreSetupRequestDTO requestDTO1= new TheatreSetupRequestDTO();
            AudiRequestDTO requestDTO2= new AudiRequestDTO();
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
            } else if (role.equals("Owner")) {
                 System.out.println("Enter your Theatre Id: ");
                 int theatreId=sc.nextInt();
                 requestDTO2.setThreatreID(theatreId);
                 System.out.println("Enter how many auditoriums will your Theatre have ? ");
                 int noOfAudi=sc.nextInt();
                 requestDTO2.setNoOfAudi(noOfAudi);
                 System.out.println("Enter the number of seats dimensions you would like to have?");
                 int rowSeat=sc.nextInt();
                 requestDTO2.setRowSeat(rowSeat);
                 int colSeat=sc.nextInt();
                 requestDTO2.setColSeat(colSeat);
                 sc.nextLine();
                 System.out.println(" How many show you would like to have?");
                 List<String> showNameList=new ArrayList<>();
                while (true){
                    String showName=sc.nextLine();
                    showNameList.add(showName);
                    if(showName.equalsIgnoreCase("exit"))
                    {
                        break;
                    }
                }

             }
            System.out.println("Do you want to exit");
            String check = sc.nextLine();
            UserResponseDTO responseDTO = usc.signUpUser(requestDTO);
            if(role.equalsIgnoreCase("Admin")) {
                TheatreSetupResponseDTO responseDTO1 = tsc.setUpCity(requestDTO1);
            } else if (role.equalsIgnoreCase("Owner")) {
                AudiResponseDTO responseDTO2=ac.setupAudi_seats(requestDTO2);
            }
            if(check.equalsIgnoreCase("yes")){
                break;
            }
        }

    }
}
