package com.KomSoft.lection5.henFactory;

public enum HenBreeds {
    henUA("Україна"), henPL("Polska"), henMD("Moldova"), henBY("Беларусь");
    private String country;

    HenBreeds(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}