package com.bookmyshow.lld_bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theatre extends BaseClass{

    private String name;
    private String address;

    @OneToMany(mappedBy="theatre")
    private List<Show> shows;

    @ManyToOne
    private City city;
}
