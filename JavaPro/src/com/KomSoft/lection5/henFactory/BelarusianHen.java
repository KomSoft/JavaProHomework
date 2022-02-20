package com.KomSoft.lection5.henFactory;

public class BelarusianHen extends Hen {
    private final int EGGS_PER_MONTH = 20;

    public BelarusianHen() {
        super();
        this.henBreed = henBreed.henBY;
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
        return super.getDescription() + " Мая краіна - " + getCountry() + ". Я приношу " + getCountOfEggsPerMonth() + " яєць в місяць.";
    }
}
