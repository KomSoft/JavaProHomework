package com.KomSoft.lection5.henFactory;

abstract class Hen {
    protected HenBreeds henBreed;
    protected String country;

    abstract int getCountOfEggsPerMonth();
    abstract String getCountry();

    public String getDescription() {
        return "Я курица.";
    }

}
