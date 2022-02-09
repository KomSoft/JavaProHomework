package com.KomSoft.lection9;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
public enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SUNDAY, SATURDAY;

    public boolean isWeekDay() {
        return !isHoliday();
    }

    public boolean isHoliday() {
        return this == SUNDAY || this == SATURDAY;
    }

}
