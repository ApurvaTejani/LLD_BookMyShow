package com.bookmyshow.lld_bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketResponseDTO {
    private Long ticketId;
    private int amount;
    private TicketResponseStatus responseStatus;
}
