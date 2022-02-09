package com.KomSoft.lection5.henFactory;


public class HenFactory {
    private final int MAX_HEN = 100;

    public int getHenCount() {
        return henCount;
    }

    private int henCount;
    Hen[] hens = new Hen[MAX_HEN];

    public HenFactory() {
        this.henCount = 0;
    }

/*
    enum henBreeds { henUA("Украина") , henPL("Польша"), henMD("Молдова"), henBY("Беларусь")
        private String country;
        henBreeds(String country) {
            this.country = country;
        }
        public String getCountry() {
            return country;
        }
    }
*/

    public boolean addHen(Hen hen) {
        if (henCount > MAX_HEN) {
            return false;
        } else {
            hens[henCount++] = hen;
            return true;
        }
    }

    public Hen getHenByIndex(int ind) {
        if (ind < henCount) {
            return hens[ind];
        } else return null;
    }

    public HenBreeds getHen(String country) {
        for(int i = 0; i < henCount; i++) {
            if(hens[i].getCountry().equalsIgnoreCase(country)) {
                return hens[i].henBreed;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        UkrainianHen uaHen = new UkrainianHen();
        HenFactory hens = new HenFactory();
        hens.addHen(new UkrainianHen());
        hens.addHen(new PolishHen());
        hens.addHen(new MoldovanHen());
        hens.addHen(new BelarusianHen());
        System.out.println("В курятнике (на фабрике) " + hens.getHenCount() + " кур.");
        for(int i = 0; i < hens.getHenCount(); i++) {
            System.out.println(hens.getHenByIndex(i).getDescription());
        }
        HenBreeds henB;
        henB = hens.getHen("Україна");
        if ( henB != null) {
            System.out.println(henB);
        }
        henB = hens.getHen("Polska");
        if ( henB != null) {
            System.out.println(henB);
        }
        henB = hens.getHen("Moldova");
        if ( henB != null) {
            System.out.println(henB);
        }
        // неправильное название страны
        henB = hens.getHen("Беларуссия");
        if ( henB != null) {
            System.out.println(henB);
        } else {
            System.out.println("Кур такой породы нет.");
        }
    }

}
