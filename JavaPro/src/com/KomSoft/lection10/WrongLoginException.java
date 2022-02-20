package com.KomSoft.lection10;

public class WrongLoginException extends IllegalArgumentException {

    public WrongLoginException(String s) {
        super(s);
        System.out.println("Exception: " + s);
    }

    public WrongLoginException() {
    }
}
