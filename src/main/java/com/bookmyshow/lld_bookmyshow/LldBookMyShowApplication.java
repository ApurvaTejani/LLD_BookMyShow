package com.bookmyshow.lld_bookmyshow;

import com.bookmyshow.lld_bookmyshow.Controllers.UserSignUpController;
import com.bookmyshow.lld_bookmyshow.Models.City;
import com.bookmyshow.lld_bookmyshow.dtos.UserRequestDTO;
import com.bookmyshow.lld_bookmyshow.dtos.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LldBookMyShowApplication implements CommandLineRunner {


    @Autowired
    private UserSignUpController usc;

    @Override
    public void run (String... arg)throws Exception{
        UserRequestDTO requestDTO= new UserRequestDTO();
        requestDTO.setEmail("apurvtejani29@gmail.com");
        requestDTO.setName("Apurva Tejani");
        requestDTO.setPassword("11232323");
        UserResponseDTO responseDTO=usc.signUpUser(requestDTO);
    }

    public static void main(String[] args) {
        SpringApplication.run(LldBookMyShowApplication.class, args);
    }

}
