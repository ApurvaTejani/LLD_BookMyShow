package com.bookmyshow.lld_bookmyshow.Repository;

import com.bookmyshow.lld_bookmyshow.Models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Integer> {

    Optional<Theatre> findByName(String theatreName);
    List<Theatre> findAllByName(String cityname);

    Optional<Theatre> findById(int theatreId);

}
