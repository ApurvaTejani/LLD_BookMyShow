package com.bookmyshow.lld_bookmyshow.Controllers;

import com.bookmyshow.lld_bookmyshow.Models.Ticket;
import com.bookmyshow.lld_bookmyshow.Services.TicketService;
import com.bookmyshow.lld_bookmyshow.dtos.TicketRequestDTO;
import com.bookmyshow.lld_bookmyshow.dtos.TicketResponseDTO;
import com.bookmyshow.lld_bookmyshow.dtos.TicketResponseStatus;

public class TicketController {
    private TicketService ts;

    public TicketResponseDTO bookTicket(TicketRequestDTO requestDTO){
        TicketResponseDTO responseDTO= new TicketResponseDTO();
        try{
            Ticket ticket=ts.bookTicket(requestDTO.getSeatInShowId(),requestDTO.getShowId(),requestDTO.getUserId());
            responseDTO.setTicketId(ticket.getId());
            responseDTO.setResponseStatus(TicketResponseStatus.SUCCESS);

        }
        catch (Exception ex){
            responseDTO.setResponseStatus(TicketResponseStatus.FAILED);
        }
    }
}
