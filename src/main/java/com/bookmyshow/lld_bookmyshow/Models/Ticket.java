package com.bookmyshow.lld_bookmyshow.Models;

import com.bookmyshow.lld_bookmyshow.Models.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseClass{

    // 1 user : Many Tickets
    @ManyToOne
    private User user;

    private Date bookingTime;

    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;

    // 1 Ticket : 1 Movie Show
    //1 MovieShow : Many Tickets
    @ManyToOne
    private Show show;

    // 1 Ticket : Many SeatInShow
    @OneToMany(mappedBy = "ticket")
    private List<SeatInShow> seatInShows;


}
