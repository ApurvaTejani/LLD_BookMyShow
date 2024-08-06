package com.bookmyshow.lld_bookmyshow.Models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movie extends BaseClass{
    private String names;
}
