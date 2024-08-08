package com.bookmyshow.lld_bookmyshow.dtos;

import com.bookmyshow.lld_bookmyshow.Models.City;
import com.bookmyshow.lld_bookmyshow.Models.Theatre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreSetupResponseDTO {
    private City city;
    private TheatreResponseStatus theatreResponseStatus;
    private String message;
}
