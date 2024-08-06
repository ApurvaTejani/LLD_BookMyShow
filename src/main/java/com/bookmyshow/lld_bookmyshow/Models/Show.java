package com.bookmyshow.lld_bookmyshow.Models;

import com.bookmyshow.lld_bookmyshow.Models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity(name="shows")
@Getter
@Setter
public class Show extends BaseClass{

    @ManyToOne
    private Movie movie;

    private Date startTime;
    private Date endTime;

    private int duration;

    @ManyToOne
    private Auditorium auditorium;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> requiredFeatures;

    @ManyToOne
    private Theatre theatre;

}
