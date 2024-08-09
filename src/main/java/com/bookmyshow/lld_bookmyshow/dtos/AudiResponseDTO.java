package com.bookmyshow.lld_bookmyshow.dtos;

import com.bookmyshow.lld_bookmyshow.Models.Auditorium;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AudiResponseDTO {
    private List<Auditorium> auditoriumList;
    private AudiResponseStatus responseStatus;
    private String message;
}
