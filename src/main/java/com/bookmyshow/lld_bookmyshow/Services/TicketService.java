package com.bookmyshow.lld_bookmyshow.Services;

import com.bookmyshow.lld_bookmyshow.Models.*;
import com.bookmyshow.lld_bookmyshow.Models.enums.SeatStatus;
import com.bookmyshow.lld_bookmyshow.Models.enums.TicketStatus;
import com.bookmyshow.lld_bookmyshow.Repository.SeatInShowRepository;
import com.bookmyshow.lld_bookmyshow.Repository.ShowRepository;
import com.bookmyshow.lld_bookmyshow.Repository.TicketRepository;
import com.bookmyshow.lld_bookmyshow.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class TicketService {

    private UserRepository ur;

    private ShowRepository sr;

    private SeatInShowRepository sisr;

    private TicketRepository tr;

    public TicketService(UserRepository ur, ShowRepository sr, SeatInShowRepository sisr,TicketRepository tr) {
        this.ur = ur;
        this.sr = sr;
        this.sisr = sisr;
        this.tr=tr;
    }

    @Transactional
    public Ticket bookTicket(List<Integer> seatInShowId,int showId, int userId){
        Ticket ticket= new Ticket();
        Optional<User> userOptional=ur.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User not found");
        }
        ticket.setUser(userOptional.get());
        Optional<Show> showOptional=sr.findById(showId);
        if(showOptional.isEmpty()){
            throw  new RuntimeException("Show not Found");
        }
        ticket.setShow(showOptional.get());
        List<SeatInShow> seatInShowList=sisr.findAllById(seatInShowId);
        for (SeatInShow oneSeat:seatInShowList) {
            if(!oneSeat.getSeatStatus().equals(SeatStatus.AVAILABLE))
                throw new RuntimeException("No Seats are available");
        }
        for (SeatInShow oneSeat:seatInShowList) {
            if(oneSeat.getSeatStatus().equals(SeatStatus.AVAILABLE)) {
                oneSeat.setStatusUpdatedAt(new Date());
                oneSeat.setSeatStatus(SeatStatus.LOCKED);
                sisr.save(oneSeat);
            }
        }
        ticket.setSeatInShows(seatInShowList);
        ticket.setTicketStatus(TicketStatus.PENDING);
        ticket.setBookingTime(new Date());
        ticket.setAmount(100);
        List<Payment> paymentList= new ArrayList<>();
        ticket.setPayments(paymentList);
        return ticket;
    }
}
