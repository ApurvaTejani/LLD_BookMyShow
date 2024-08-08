package com.bookmyshow.lld_bookmyshow.Exceptions;

public class UserNotFoundException extends  Exception{
    public UserNotFoundException(){
        super("User not found");
    }
}
