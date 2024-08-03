package com.bookmyshow.lld_bookmyshow.Models;

import com.bookmyshow.lld_bookmyshow.Models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
public class MovieShow extends BaseClass{

    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Auditorium auditorium;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> requiredFeatures;

}
