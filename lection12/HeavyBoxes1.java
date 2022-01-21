package com.KomSoft.lection12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    1. а) Создать динамический массив, содержащий объекты класса HeavyBox.
    б) Распечатать его содержимое используя for each.
    в) Изменить вес первого ящика на 1.
    г) Удалить последний ящик.
    д) Получить массив содержащий ящики из коллекции тремя способами и вывести на консоль.
    е) Удалить все ящики.
    2. Получить массив содержащий объекты класса HeavyBox из коллекции тремя способами и вывести на консоль.
        --> то же самое, что пункт д) ??
    3. Создать TreeSet содержащий HeavyBox. HeavyBox должен реализовать интерфейс Comparable.
    Распечатать содержимое с помощью for each.

    6. Создать очередь, содержащую объекты класса HeavyBox. Используем класс ArrayDeque.
    Поместить объекты в очередь с помощью метода offer(). Удалить объекты методом poll().
*/
public class HeavyBoxes1 {
    public static void main(String[] args) {
        ArrayList <HeavyBox> boxes = new ArrayList<>();
        boxes.add(new HeavyBox(10,3));
        boxes.add(new HeavyBox(10,5));
        boxes.add(new HeavyBox(10,6));
        boxes.add(new HeavyBox(10,1));
        boxes.add(new HeavyBox(10,7));
        boxes.add(new HeavyBox(10,2));
        boxes.add(new HeavyBox(10,1));
        boxes.add(new HeavyBox(10,9));
        for(HeavyBox box : boxes) {
            System.out.println("box: " + box);
        }
        boxes.get(0).setWeight(boxes.get(0).getWeight() + 1);
        boxes.remove(boxes.size() - 1);
        // х.з. какими именно способами.... напишем теми, что вспомню
        HeavyBox[] arrBox1 = new HeavyBox[boxes.size()];
        HeavyBox[] arrBox2 = new HeavyBox[boxes.size()];
        ArrayList <HeavyBox> arrBox3 = new ArrayList<>();
        ArrayList <HeavyBox> arrBox4 = new ArrayList<>();
        ArrayList <HeavyBox> arrBox5 = new ArrayList<>();
        ArrayList <HeavyBox> arrBox6 = new ArrayList<>();
        System.out.println("Получаем новый массив при помощи цикла for");
        for(int i = 0; i < boxes.size(); i++) {
            arrBox1[i] = boxes.get(i);
        }
        System.out.println("Получаем новый массив при помощи цикла //foreach & \"set/put by index\"");
        int i = 0;
        for(HeavyBox box : boxes) {
            arrBox2[i++] = box;
        }
        System.out.println("Получаем новый массив при помощи цикла foreach & add");
        for(HeavyBox box : boxes) {
            arrBox3.add(box);
        }
        System.out.println("Получаем новый массив при помощи Iterator");
        Iterator<HeavyBox> it = boxes.iterator();
        while(it.hasNext()) {
            arrBox4.add(it.next());
        }
        System.out.println("Получаем новый массив при помощи цикла for with Iterator");
        for(HeavyBox box : boxes) {
            arrBox5.add(box);
        }
        System.out.println("Получаем новый массив при помощи addAll(Collection c)");
        arrBox6.addAll(boxes);

        System.out.println("New arrays 1-4");
        for(i = 0; i < arrBox3.size(); i++) {
            System.out.println(String.format("%3d ", i) + arrBox1[i] + "   " + arrBox2[i] + "   " + arrBox3.get(i) + "   " + arrBox4.get(i));
        }
        System.out.println("\nNew arrays 5-..");
        for(i = 0; i < arrBox3.size(); i++) {
            System.out.println(String.format("%3d ", i) + arrBox5.get(i) + "   " + arrBox6.get(i));
        }
        System.out.println("Удаляем все ящики из новых коллекций");
        // удалить все ящики
        arrBox3.clear();
        arrBox4.clear();
        arrBox5.clear();
        arrBox6.clear();
        System.out.println("Создаем TreeSet");
        TreeSet<HeavyBox> boxTree = new TreeSet<>(boxes);
        for(HeavyBox box : boxTree) {
            System.out.println(box);
        }

    }
}
