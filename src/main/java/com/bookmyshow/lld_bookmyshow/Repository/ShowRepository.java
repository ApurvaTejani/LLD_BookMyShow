package com.bookmyshow.lld_bookmyshow.Repository;

import com.bookmyshow.lld_bookmyshow.Models.Show;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {
    @Override
    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<Show> findById(Integer integer);
}
