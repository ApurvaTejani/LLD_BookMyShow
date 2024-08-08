package com.bookmyshow.lld_bookmyshow.Services;

import com.bookmyshow.lld_bookmyshow.Exceptions.NoSeatAvailableException;
import com.bookmyshow.lld_bookmyshow.Exceptions.ShowNotFoundException;
import com.bookmyshow.lld_bookmyshow.Exceptions.UserNotFoundException;
import com.bookmyshow.lld_bookmyshow.Models.*;
import com.bookmyshow.lld_bookmyshow.Models.enums.SeatStatus;
import com.bookmyshow.lld_bookmyshow.Models.enums.TicketStatus;
import com.bookmyshow.lld_bookmyshow.Repository.SeatInShowRepository;
import com.bookmyshow.lld_bookmyshow.Repository.ShowRepository;
import com.bookmyshow.lld_bookmyshow.Repository.TicketRepository;
import com.bookmyshow.lld_bookmyshow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    public TicketService(UserRepository ur, ShowRepository sr, SeatInShowRepository sisr,TicketRepository tr) {
        this.ur = ur;
        this.sr = sr;
        this.sisr = sisr;
        this.tr=tr;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> seatInShowId,int showId, int userId) throws ShowNotFoundException, UserNotFoundException, NoSeatAvailableException {
        Ticket ticket= new Ticket();
        Optional<User> userOptional=ur.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException();
        }
        ticket.setUser(userOptional.get());
        Optional<Show> showOptional=sr.findById(showId);
        if(showOptional.isEmpty()){
            throw new ShowNotFoundException();
        }

        ticket.setShow(showOptional.get());
        List<SeatInShow> seatInShowList=sisr.findAllById(seatInShowId);
        for (SeatInShow oneSeat:seatInShowList) {
            Long currentTime=System.currentTimeMillis();
            Long lockedAt=oneSeat.getStatusUpdatedAt().getTime();
            Long diff=currentTime-lockedAt/(1000*60);
           if(oneSeat.getSeatStatus().equals(SeatStatus.LOCKED)&& diff<10)
               throw new NoSeatAvailableException();
           else if (oneSeat.getSeatStatus().equals(SeatStatus.BOOKED)) {
               throw new NoSeatAvailableException();
           }
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
        Ticket savedTicket=tr.save(ticket);
        return savedTicket;
    }
}
