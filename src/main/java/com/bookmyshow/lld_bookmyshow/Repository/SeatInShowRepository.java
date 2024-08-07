package com.bookmyshow.lld_bookmyshow.Repository;

import com.bookmyshow.lld_bookmyshow.Models.SeatInShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatInShowRepository extends JpaRepository<SeatInShow,Integer> {
    @Override
    List<SeatInShow> findAllById(Iterable<Integer> integers);
}
