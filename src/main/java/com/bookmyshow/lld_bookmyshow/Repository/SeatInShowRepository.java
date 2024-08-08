package com.bookmyshow.lld_bookmyshow.Repository;

import com.bookmyshow.lld_bookmyshow.Models.SeatInShow;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatInShowRepository extends JpaRepository<SeatInShow,Integer> {
    @Override
    @Lock(LockModeType.PESSIMISTIC_READ)
    List<SeatInShow> findAllById(Iterable<Integer> integers);
}
