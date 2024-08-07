package com.bookmyshow.lld_bookmyshow.Models;

import com.bookmyshow.lld_bookmyshow.Models.enums.Role;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import jakarta.persistence.Enumerated;
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
    private String password;


    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;

    @Enumerated
    @ElementCollection
    private List<Role> roles;

}
