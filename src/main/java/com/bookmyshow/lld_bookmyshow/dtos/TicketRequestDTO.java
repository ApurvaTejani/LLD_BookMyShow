package com.bookmyshow.lld_bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketRequestDTO {
    private List<Integer> seatInShowId;
    private int showId;
    private int userId;

}
