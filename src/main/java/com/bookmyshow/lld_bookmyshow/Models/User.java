package com.bookmyshow.lld_bookmyshow.Models;

import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseClass{
    private String name;
    private String email;


    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;

}
