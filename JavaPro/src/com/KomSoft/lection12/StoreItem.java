package com.KomSoft.lection12;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    11. Вместо массивов используйте коллекции. Создать метод, распечатывающий товары каталога,
    отсортированные по имени, цене или рейтингу.
    Добавить возможность сортировать в обратном порядке. (Интернет-магазин)

    Class для товара
*/
public class StoreItem {
    public String name;
    public float price;
    public float rate;

    public StoreItem(String name, float price, float rate) {
        this.name = name;
        this.price = price;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "StoreItem{'" + name + "', price=" + price + ", rate=" + rate + '}';
    }

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

}
