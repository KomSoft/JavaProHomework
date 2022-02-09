package com.KomSoft.lection8;

import java.time.LocalDate;

public class EuropeRunner {

    public static void main(String[] args) {
        Europe euro = new Europe();
        euro.addChange("France", LocalDate.of(1900, 1, 1));
        euro.addChange("Italy", LocalDate.of(1900, 1, 4));
        euro.addChange("German", LocalDate.of(1900, 1, 5));
        euro.addChange("Netherland", LocalDate.of(1900, 1, 10));
        euro.addChange("Незалежні Кобиляки", LocalDate.of(1900, 1, 10));
        euro.addChange("Greece", LocalDate.of(1900, 1, 15));
        euro.addChange("Poland", LocalDate.of(1900, 2, 1));
        euro.addChange("Незалежні Кобиляки", LocalDate.of(1905, 3, 5));   // змінила границі
        euro.addChange("Незалежні Кобиляки", LocalDate.of(1905, 10, 14));   // змінила границі знову
        euro.delCountry("Незалежні Кобиляки", LocalDate.of(1906, 1, 10)); // влилась в Львівське Княжицтво
        euro.addChange("Hungary", LocalDate.of(1904, 2, 1));
        euro.delCountry("Netherland", LocalDate.of(1910,5,5));


        System.out.println("Unique countries: " + euro.getCountOfUniqueCountry());
        String[] strArr = euro.getUniqueCountryList();
        for(String s : strArr) {
            System.out.print(s + ", ");
        }
        System.out.println();
        strArr = euro.getFullHistory();
        for(String s : strArr) {
            System.out.println(s);
        }
        System.out.println();
/*
        strArr = euro.getHistoryOnDate(LocalDate.of(1907, 1, 1));
        for(String s : strArr) {
            System.out.println(s);
        }
*/
        System.out.println();
    }
}
