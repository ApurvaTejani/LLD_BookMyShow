package com.bookmyshow.lld_bookmyshow.Repository;

import com.bookmyshow.lld_bookmyshow.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {
    @Override
    Optional<Show> findById(Integer integer);
}
