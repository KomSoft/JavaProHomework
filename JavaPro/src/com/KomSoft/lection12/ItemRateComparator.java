package com.KomSoft.lection12;

import java.util.Comparator;

public class ItemRateComparator implements Comparator<StoreItem> {

    @Override
    public int compare(StoreItem o1, StoreItem o2) {
        return Float.compare(o1.rate, o2.rate);
    }

    @Override
    public Comparator<StoreItem> reversed() {
        return Comparator.super.reversed();
    }
}
