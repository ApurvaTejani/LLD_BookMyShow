package com.bookmyshow.lld_bookmyshow.Repository;

import com.bookmyshow.lld_bookmyshow.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    @Override
   Ticket save(Ticket entity);
}
