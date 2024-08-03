package com.bookmyshow.lld_bookmyshow.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class City extends BaseClass {

    private String name;

    @OneToMany(mappedBy = "city")
    private List<Theatre> theatres;


}
