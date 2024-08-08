package com.bookmyshow.lld_bookmyshow.Exceptions;

public class NoSeatAvailableException extends Exception{
    public NoSeatAvailableException(){
        super("No Seats are available");
    }
}
