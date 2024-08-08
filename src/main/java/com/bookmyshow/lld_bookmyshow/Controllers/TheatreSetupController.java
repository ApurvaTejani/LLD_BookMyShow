package com.bookmyshow.lld_bookmyshow.Controllers;


import com.bookmyshow.lld_bookmyshow.Models.City;
import com.bookmyshow.lld_bookmyshow.Services.CityService;
import com.bookmyshow.lld_bookmyshow.dtos.TheatreResponseStatus;
import com.bookmyshow.lld_bookmyshow.dtos.TheatreSetupRequestDTO;
import com.bookmyshow.lld_bookmyshow.dtos.TheatreSetupResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TheatreSetupController {
    private CityService cs;

    @Autowired
    public TheatreSetupController(CityService cs) {
        this.cs = cs;
    }

    public TheatreSetupResponseDTO setUpCity(TheatreSetupRequestDTO requestDTO){
        TheatreSetupResponseDTO responseDTO= new TheatreSetupResponseDTO();
        try{
            City city= cs.setupCity(requestDTO.getCityname(),requestDTO.getTheatreName(),requestDTO.getTheatreAddress());
            responseDTO.setCity(city);
            responseDTO.setTheatreResponseStatus(TheatreResponseStatus.SUCCESS);
        }
        catch (Exception ex){
            responseDTO.setTheatreResponseStatus(TheatreResponseStatus.FAILED);
            System.out.println(ex.getMessage());
        }
        return responseDTO;
    }
}
