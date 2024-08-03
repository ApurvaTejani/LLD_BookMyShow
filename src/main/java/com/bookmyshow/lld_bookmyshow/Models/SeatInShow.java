package com.bookmyshow.lld_bookmyshow.Models;

import com.bookmyshow.lld_bookmyshow.Models.enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class SeatInShow extends BaseClass{

    @ManyToOne
    private Seat seat;

    @ManyToOne
    private MovieShow movieShow;

    private Date statusUpdatedAt;

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;

    @ManyToOne
    private Ticket ticket;
}
