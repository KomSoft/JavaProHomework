package com.KomSoft.lection12;

import java.util.Comparator;

public class ItemPriceComparator implements Comparator<StoreItem> {

    @Override
    public int compare(StoreItem o1, StoreItem o2) {
        return Float.compare(o1.price, o2.price);
    }

    @Override
    public Comparator<StoreItem> reversed() {
        return Comparator.super.reversed();
    }
}
