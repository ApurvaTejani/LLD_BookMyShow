package com.bookmyshow.lld_bookmyshow.Exceptions;

public class InvalidTheatreProvidedException extends Exception {
   public InvalidTheatreProvidedException(){
       super("Theatre ID enetered is invalid");
   }
}
