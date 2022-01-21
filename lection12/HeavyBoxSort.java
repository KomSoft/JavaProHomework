package com.KomSoft.lection12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    7. Создать коллекцию, содержащую объекты HeavyBox.
    Написать метод, который перебирает элементы коллекции и проверяет вес коробок.
    Если вес коробки больше 300 гр, коробка перемещается в другую коллекцию.
*/
public class HeavyBoxSort {


    public static void main(String[] args) {
        final var BOUND_WEIGHT = 300;
        LinkedList<HeavyBox> boxes = new LinkedList<>();
        boolean offerResult = true;
        int count = 10;
        Random rand = new Random();
//        int coin;
        for(int i = 0; i < count; i++) {
//            coin = rand.nextInt(600);
            offerResult &= boxes.add(new HeavyBox(10,rand.nextInt(600)));
        }
        for(HeavyBox box : boxes) {
            System.out.println("box: " + box);
        }
        int index = 0;
        ArrayList<HeavyBox> heavyHeavyBoxes = new ArrayList<>();
        while(index < boxes.size()) {
            if(boxes.get(index).weight(BOUND_WEIGHT)) {
                heavyHeavyBoxes.add(boxes.remove(index));       // remove and add to new collection
            } else {
                index++;
            }
        }
/*
        есть интересный метод removeIf(), но он только удаляет, возвращая boolean.
        Т.е. для переноса его использовать нельзя.
*/
        System.out.println("Light boxes: " + boxes);
        System.out.println("Weight boxes: " + heavyHeavyBoxes);

    }
}
