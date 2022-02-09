package com.KomSoft.lection8;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    2. Создать класс Payment с внутренним классом,
    с помощью объектов которого можно сформировать покупку из нескольких товаров.
*/
public class Payment {
    private static final int MAX_RECORD = 100;

    private int countOfGoods;
    private Payment.Goods[] goods;

    protected class Goods {
        private int count;
        private int id;
        private String goodsName;
        private String goodsDescription;

        public Goods(int id) {  // без проверок на наличие такого товара
            count = 1;
            this.id = id;
            //      тут взять описание товара из базы товаров
            String str = String.format("%03d", id);
            this.goodsName = "Товар" + str;
            this.goodsDescription = "Описание Товара" + str;
        }

        public int getCount() {
            return count;
        }

        public int getId() {
            return id;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public String getGoodsDescription() {
            return goodsDescription;
        }

        public boolean goodsExists(int id) {
            return this.id == id;
        }

        public int inc() {
            return ++count;
        }

        public int dec() {
            if (count > 0 ) {
                return --count;
            } else {
                return 0;
            }
        }
    }

    public Payment() {
        this.countOfGoods = 0;
        this.goods = new Goods[MAX_RECORD];
    }

    public int getCountOfGoods() {
        return countOfGoods;
    }

    public int getTotalCountOfGoods() {
        int count = 0;
        for(int i = 0; i < countOfGoods; i++) {
            count += goods[i].getCount();
        }
        return count;
    }

    public void addGoods(int id) {  // тоже без проверок получилось или нет
        for(int i=0; i < countOfGoods; i++) {
            if(goods[i].goodsExists(id)) {
                goods[i].inc();
                return;
            }
        }
        goods[countOfGoods++] = new Goods(id);
    }

    public int add(int ind) {  // вернуть количество оставшихся штук
        return goods[ind].inc();
    }

    public int del(int ind) {  // вернуть количество оставшихся штук
        return goods[ind].dec();
    }

    public void clean(){ // очистить список от записей с количеством == 0
        int i = 0;
        while (i < countOfGoods ) {
            if(goods[i].count == 0) {
                for(int j=i; j < countOfGoods - 1; j++) {
                    goods[j] = goods[j+1];
                }
                countOfGoods--;
            } else {
                i++;
            }
        }
    }

    public void printListOfGoods() {
        for(int i=0; i < countOfGoods; i++) {
            System.out.println(goods[i].getGoodsName() + " (" + goods[i].getGoodsDescription() + "), количество - " + goods[i].count);
        }
        System.out.println();
    }

}
