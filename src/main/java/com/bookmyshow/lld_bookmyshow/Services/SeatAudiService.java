package com.bookmyshow.lld_bookmyshow.Services;

import com.bookmyshow.lld_bookmyshow.Exceptions.InvalidTheatreProvidedException;
import com.bookmyshow.lld_bookmyshow.Models.Auditorium;
import com.bookmyshow.lld_bookmyshow.Models.Seat;
import com.bookmyshow.lld_bookmyshow.Models.Theatre;
import com.bookmyshow.lld_bookmyshow.Models.enums.Feature;
import com.bookmyshow.lld_bookmyshow.Models.enums.SeatType;
import com.bookmyshow.lld_bookmyshow.Repository.AuditoriumRepository;
import com.bookmyshow.lld_bookmyshow.Repository.SeatRepository;
import com.bookmyshow.lld_bookmyshow.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeatAudiService {

    private TheatreRepository tr;

    private SeatRepository sr;

    private AuditoriumRepository ar;

    @Autowired
    public SeatAudiService(TheatreRepository tr, SeatRepository sr, AuditoriumRepository ar) {
        this.tr = tr;
        this.sr = sr;
        this.ar = ar;
    }

    public List<Auditorium> setupAudi_Seats(int theatreId, int noOfAudi, int rowSeat, int colSeat) throws Exception{
        Optional<Theatre> theatreOptional= tr.findById(theatreId);
        if(theatreOptional.isEmpty()){
            throw new InvalidTheatreProvidedException();
        }
        List<Auditorium> auditoriumList= new ArrayList<>();
        for (int i = 0; i < noOfAudi; i++) {
            Auditorium audi = new Auditorium();
            audi.setTheatre(theatreOptional.get());
            audi.setName("Auditorium No "+(i+1));
            audi.setMaxRow(rowSeat);
            audi.setMaxCol(colSeat);
            List<Feature> supportedFeatures= new ArrayList<>();
            supportedFeatures.add(Feature.THREE_D);
            audi.setSupportedFeatures(supportedFeatures);
            Auditorium savedAudi= ar.save(audi);
            List<Seat> seatList= new ArrayList<>();
            int j=0;
            int k=0;
            while(true) {
                Seat seat = new Seat();
                k=k%colSeat;
                seat.setSeatRow(j);
                seat.setSeatCol(k);
                seat.setSeatType(SeatType.SILVER);
                seat.setAuditorium(audi);
                seat.setNumber("Seat No: "+j+""+k);
                Seat savedSeat=sr.save(seat);
                seatList.add(savedSeat);
                if(j==rowSeat-1 && k==colSeat-1)
                    break;
                if(k==4){
                    j++;
                }
                k++;
            }
            savedAudi.setSeats(seatList);

            auditoriumList.add(savedAudi);

        }
        return auditoriumList;
    }
}
