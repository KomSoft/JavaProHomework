package com.KomSoft.lection12;

import java.util.*;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    6. Создать очередь, содержащую объекты класса HeavyBox. Используем класс ArrayDeque.
    Поместить объекты в очередь с помощью метода offer(). Удалить объекты методом poll().
*/
public class HeavyBoxDeque {

    public static void main(String[] args) {
        ArrayDeque<HeavyBox> boxes = new ArrayDeque<>();
        boolean offerResult = true;
        offerResult &= boxes.offerFirst(new HeavyBox(10,10));
        offerResult &= boxes.offerFirst(new HeavyBox(10,8));
        offerResult &= boxes.offerFirst(new HeavyBox(10,6));
        offerResult &= boxes.offerLast(new HeavyBox(10,8));
        offerResult &= boxes.offerLast(new HeavyBox(10,6));
        offerResult &= boxes.offerFirst(new HeavyBox(10,4));
        offerResult &= boxes.offerLast(new HeavyBox(10,4));
        if(offerResult) {
            System.out.println("All elements added successfully.");
        }
        for(HeavyBox box : boxes) {
            System.out.println("box: " + box);
        }
        HeavyBox box1;
        Random rand = new Random();
        int coin;
        do {
            coin = rand.nextInt(2);
            if(coin == 0) {
                box1 = boxes.pollFirst();
            } else box1 = boxes.pollLast();
/*
            System.out.println();
            for(HeavyBox box : boxes) {
                System.out.println("box: " + box);
            }
*/
        }
        while(box1 != null);
        if(boxes.isEmpty()) {
            System.out.println("All elements removed successfully.");
        } else {
            System.out.println("Some element(s) weren't removed.");
        }

    }
}
