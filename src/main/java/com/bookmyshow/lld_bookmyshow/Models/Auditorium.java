package com.bookmyshow.lld_bookmyshow.Models;

import com.bookmyshow.lld_bookmyshow.Models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseClass{

    private String name;

    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seats;

    @ManyToOne
    private Theatre theatre;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> supportedFeatures;

    private int maxRow;
    private int maxCol;

}
