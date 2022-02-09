package com.KomSoft.lection10;

public class WrongPasswordException extends IllegalArgumentException {

    public WrongPasswordException(String s) {
        super(s);
        System.out.println("Exception: " + s);
    }

    public WrongPasswordException(Throwable cause) {
        super(cause);
    }
}
