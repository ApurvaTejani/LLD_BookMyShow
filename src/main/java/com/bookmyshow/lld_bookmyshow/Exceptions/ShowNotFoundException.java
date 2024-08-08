package com.bookmyshow.lld_bookmyshow.Exceptions;

public class ShowNotFoundException extends Exception {
    public ShowNotFoundException() {
        super("Show not present");
    }
}
