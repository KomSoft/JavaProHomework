package com.KomSoft.lection5.henFactory;

public class MoldovanHen extends Hen {
    private final int EGGS_PER_MONTH = 24;

    public MoldovanHen() {
        super();
        this.henBreed = henBreed.henMD;
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
        return super.getDescription() + " Az én országom - " + getCountry() + ". havonta " + getCountOfEggsPerMonth() + " tojást tojóm.";
    }
}
