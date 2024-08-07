package com.bookmyshow.lld_bookmyshow.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private String email;
    private String name;
    private String password;
}
