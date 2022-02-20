package com.KomSoft.lection10;

import java.util.regex.Pattern;

public class RegExpTest {

    public static void main(String[] args) {
        String login = "user4FileU9";
        String regex = "[a-zA-Z0-9_]+";
//        Pattern pattern = Pattern.compile(regex);
            if(login.matches(regex)) {
                System.out.println("String " + login + "       includes only " + regex);
            } else {
                System.out.println("Incorrect!");
            }
        }
}
