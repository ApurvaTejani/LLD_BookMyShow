package com.bookmyshow.lld_bookmyshow.Models;

import com.bookmyshow.lld_bookmyshow.Models.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Seat extends BaseClass{
    private String number;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private int seatRow;
    private int seatCol;

    @ManyToOne
    private Auditorium auditorium;
}
