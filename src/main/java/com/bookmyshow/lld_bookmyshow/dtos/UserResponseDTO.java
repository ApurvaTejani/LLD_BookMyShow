package com.bookmyshow.lld_bookmyshow.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private int userId;
    private UserResponseStatus responseStatus;
    private String message;
}
