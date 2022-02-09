package com.KomSoft.lection12;

import java.util.Comparator;

public class ItemNameComparator implements Comparator<StoreItem> {

    @Override
    public int compare(StoreItem o1, StoreItem o2) {
        return o1.name.compareTo(o2.name);
    }

    @Override
    public Comparator<StoreItem> reversed() {
        return Comparator.super.reversed();
    }
}
