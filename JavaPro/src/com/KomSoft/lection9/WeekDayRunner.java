package com.KomSoft.lection9;

public class WeekDayRunner {

    public static void checkDay(Weekday day) {
        if (day.isWeekDay()) {
            System.out.println("День " + day.toString() + " - рабочий.");
        } else {
            System.out.println("День " + day.toString() + " - выходной.");
        }
    }

    public static void main(String[] args) {
//        WeekDayRunner wdr = new WeekDayRunner();
        for(Weekday day : Weekday.values()) {
            checkDay(day);
        }
    }
}
