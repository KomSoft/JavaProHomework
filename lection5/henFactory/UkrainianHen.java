package com.KomSoft.lection5.henFactory;

public class UkrainianHen extends Hen {
    private final int EGGS_PER_MONTH = 35;

   public UkrainianHen() {
       super();
        this.henBreed = henBreed.henUA;
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
        return super.getDescription() + " Моя країна - " + getCountry() + ". Я нясу " + getCountOfEggsPerMonth() + " яек у месяц.";
    }
}
