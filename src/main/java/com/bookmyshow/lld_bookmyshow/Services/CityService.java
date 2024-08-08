package com.bookmyshow.lld_bookmyshow.Services;

import com.bookmyshow.lld_bookmyshow.Models.City;
import com.bookmyshow.lld_bookmyshow.Models.Show;
import com.bookmyshow.lld_bookmyshow.Models.Theatre;
import com.bookmyshow.lld_bookmyshow.Repository.CityRepository;
import com.bookmyshow.lld_bookmyshow.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private TheatreRepository tr;

    private CityRepository cr;

    @Autowired
    public CityService(TheatreRepository tr, CityRepository cr) {
        this.tr = tr;
        this.cr = cr;
    }

    public City setupCity(String cityname, String theatreName, String theatreAddress){
        Optional<City> cityOptional=cr.findByName(cityname);
        Optional<Theatre> theatreOptional=tr.findByName(theatreName);
        if(cityOptional.isPresent() && theatreOptional.isPresent()){
            throw new RuntimeException("This Theatre Under City Already Present");
        }

        City city= new City();
        city.setName(cityname);
        City savedCity=cr.save(city);

        //===================================
        Theatre theatre= new Theatre();
        theatre.setName(theatreName);
        theatre.setAddress(theatreAddress);
        List<Show> showList= new ArrayList<>();
        theatre.setShows(showList);
        theatre.setCity(savedCity);
        List<Theatre> theatreList=savedCity.getTheatres();
        if(theatreList==null){
            theatreList= new ArrayList<>();
        }
        theatreList.add(theatre);
        tr.save(theatre);
        savedCity.setTheatres(theatreList);
        return savedCity;

    }
}
