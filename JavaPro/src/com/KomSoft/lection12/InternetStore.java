package com.KomSoft.lection12;

import java.util.Comparator;
import java.util.TreeSet;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    11. Вместо массивов используйте коллекции. Создать метод, распечатывающий товары каталога,
    отсортированные по имени, цене или рейтингу.
    Добавить возможность сортировать в обратном порядке. (Интернет-магазин)
*/
//public class InternetStore implements Comparable {
public class InternetStore {
    public enum sortMode {ORDER_NAME, ORDER_PRICE, ORDER_RATE}
    public TreeSet<StoreItem> items;
//    private boolean reverseOrder = false;
//    public orderMode sortMode;

/*
    @Override
    public int compareTo(Object o) {
        int result;
        switch (sortMode) {
            case ORDER_RATE : {
                result = this.
            }
        }

        return 0;
    }
*/
    public InternetStore() {
//        Comparator<StoreItem> comp = new ItemNameComparator(); {
        items = new TreeSet<>(new ItemNameComparator());
    }

    public void printSort(sortMode mode, boolean reverse) {
        Comparator<StoreItem> comp;
        TreeSet<StoreItem> sortedBy;
        switch (mode) {
            case ORDER_RATE: {
                comp = new ItemRateComparator();
                break;
            }
            case ORDER_PRICE: {
                comp = new ItemPriceComparator();
                break;
            }
            default: {
                comp = new ItemNameComparator();
            }
        }
        if(reverse) {
            sortedBy = new TreeSet<>(comp.reversed());
        } else {
            sortedBy = new TreeSet<>(comp);
        }
        sortedBy.addAll(items);
        for(StoreItem item : sortedBy) {
            System.out.println(item);
        }

    }

    public static void main(String[] args) {
        InternetStore store = new InternetStore();
        store.items.add(new StoreItem("Pen", 1.0f, 4.5f));
        store.items.add(new StoreItem("Pencil", 0.8f, 3f));
        store.items.add(new StoreItem("Cat", 10.0f, 4.3f));
        store.items.add(new StoreItem("Book Java", 15.0f, 4.9f));
        store.items.add(new StoreItem("Book Fantasy", 13.5f, 4.4f));
        store.items.add(new StoreItem("Book Javelin", 13.5f, 4.5f));
        store.items.add(new StoreItem("Workbook", 11.0f, 2.5f));
        store.items.add(new StoreItem("English Workbook", 12.0f, 3.4f));
//        System.out.println(store.items);
        for(StoreItem item : store.items) {
            System.out.println(item);
        }
        System.out.println();
        System.out.println("  >>>  Sorted by Name");
        store.printSort(sortMode.ORDER_NAME, false);
        System.out.println("  >>>  Sorted by Name, reversed");
        store.printSort(sortMode.ORDER_NAME, true);
        System.out.println("  >>>  Sorted by Price");
        store.printSort(sortMode.ORDER_PRICE, false);
        System.out.println("  >>>  Sorted by Price, reversed");
        store.printSort(sortMode.ORDER_PRICE, true);
        System.out.println("  >>>  Sorted by Rate");
        store.printSort(sortMode.ORDER_RATE, false);
        System.out.println("  >>>  Sorted by Rate, reversed");
        store.printSort(sortMode.ORDER_RATE, true);

    }
}
