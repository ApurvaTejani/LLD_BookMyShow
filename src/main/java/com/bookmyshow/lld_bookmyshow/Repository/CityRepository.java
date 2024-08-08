package com.bookmyshow.lld_bookmyshow.Repository;

import com.bookmyshow.lld_bookmyshow.Models.City;
import com.bookmyshow.lld_bookmyshow.Models.Theatre;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

  Optional<City> findByName(String name);

}
