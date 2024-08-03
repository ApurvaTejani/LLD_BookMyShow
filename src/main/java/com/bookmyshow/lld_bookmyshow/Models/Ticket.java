package com.bookmyshow.lld_bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseClass{

    @ManyToOne
    private User user;

    private Date bookingTime;

    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;

    @OneToMany(mappedBy = "ticket")
    private List<SeatInShow> seatInShows;
}
