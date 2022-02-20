package com.KomSoft.lection8;

import java.util.Random;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
public class PaymentRun {

    public static void main(String[] args) {
        Payment basket = new Payment();
        Random rand = new Random();
        basket.addGoods(5);
        for(int i=0; i < 25; i++) {
            basket.addGoods(rand.nextInt(10));
        }
        System.out.println("В корзину положили " + basket.getCountOfGoods() + " разных товаров");
        System.out.println("Общее количество = " + basket.getTotalCountOfGoods());
        basket.printListOfGoods();
        System.out.println("Удаляем по 3 шт. каждого товара");
        for(int i=0; i < basket.getCountOfGoods(); i++) {
            basket.del(i);
            basket.del(i);
            basket.del(i);
        }
        basket.printListOfGoods();
        System.out.println("Чистим корзину от пустых позиций.");
        basket.clean();
        basket.printListOfGoods();
    }
}
