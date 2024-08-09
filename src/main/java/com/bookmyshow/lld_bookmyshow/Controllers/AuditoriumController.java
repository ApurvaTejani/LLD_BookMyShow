package com.bookmyshow.lld_bookmyshow.Controllers;

import com.bookmyshow.lld_bookmyshow.Models.Auditorium;
import com.bookmyshow.lld_bookmyshow.Services.SeatAudiService;
import com.bookmyshow.lld_bookmyshow.dtos.AudiRequestDTO;
import com.bookmyshow.lld_bookmyshow.dtos.AudiResponseDTO;
import com.bookmyshow.lld_bookmyshow.dtos.AudiResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuditoriumController {
    private SeatAudiService sas;

    @Autowired
    public AuditoriumController(SeatAudiService sas) {
        this.sas = sas;
    }

    public AudiResponseDTO setupAudi_seats(AudiRequestDTO requestDTO){
        AudiResponseDTO responseDTO= new AudiResponseDTO();
        try{
            List<Auditorium> auditoriumList=sas.setupAudi_Seats(requestDTO.getThreatreID(), requestDTO.getNoOfAudi(), requestDTO.getRowSeat(), requestDTO.getColSeat());
            responseDTO.setAuditoriumList(auditoriumList);
            responseDTO.setResponseStatus(AudiResponseStatus.SUCCESS);
        }
        catch (Exception ex){
            responseDTO.setResponseStatus(AudiResponseStatus.FAILED);
            responseDTO.setMessage(ex.getMessage());
        }
        return responseDTO;
    }
}
