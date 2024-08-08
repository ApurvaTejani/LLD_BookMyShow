package com.bookmyshow.lld_bookmyshow;

import com.bookmyshow.lld_bookmyshow.Controllers.TheatreSetupController;
import com.bookmyshow.lld_bookmyshow.Controllers.UserSignUpController;
import com.bookmyshow.lld_bookmyshow.Models.City;
import com.bookmyshow.lld_bookmyshow.dtos.UserRequestDTO;
import com.bookmyshow.lld_bookmyshow.dtos.UserResponseDTO;
import com.bookmyshow.lld_bookmyshow.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class LldBookMyShowApplication implements CommandLineRunner {


    @Autowired
    private UserSignUpController usc;

    @Autowired
    private TheatreSetupController tsc;

    @Override
    public void run (String... arg)throws Exception{
        Scanner sc = new Scanner(System.in);
        UserManager um = new UserManager();
        um.initializeUser(usc,tsc,sc);
    }

    public static void main(String[] args) {
        SpringApplication.run(LldBookMyShowApplication.class, args);
    }

}
