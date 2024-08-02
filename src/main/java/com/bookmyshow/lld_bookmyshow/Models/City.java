package com.bookmyshow.lld_bookmyshow.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class City {

    @Id
    private int id;
    private String name;

}
