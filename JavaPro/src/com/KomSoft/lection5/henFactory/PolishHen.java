package com.KomSoft.lection5.henFactory;

public class PolishHen extends Hen {
    private final int EGGS_PER_MONTH = 32;

    public PolishHen() {
        super();
        this.henBreed = henBreed.henPL;
    }

    @Override
    public int getCountOfEggsPerMonth() {
        return EGGS_PER_MONTH;
    }

    public String getCountry() {
        return this.henBreed.getCountry();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Mój kraj - " + getCountry() + ". Znoszę " + getCountOfEggsPerMonth() + " jaj miesięcznie.";
    }
}
