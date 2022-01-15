package com.KomSoft.lection2;

import java.util.Random;

/*
	Created by Volodymyr P. Komarov aka KomSoft
*/
public class TaskArrays {

//  вывод массива строкой в консоль
    protected static void ArrayToConsole(String message, int[] a) {
        System.out.print(message);
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
/*
        1.Создайте массив с 8-ми случайных целых чисел из отрезка [1; 10]
        2.Выведите массив на экран в результате
        3.Замените каждый элемент с непарным индексом на ноль
        4.Снова выведите массив на экран
*/
        int [] arr1 = new int[8];
        Random randInt = new Random();
        for (int i=0; i < arr1.length; i++) {
            arr1[i] = randInt.nextInt(9) + 1;
        }
//      Вывод массива
        ArrayToConsole("Array 1.1: ", arr1);
/*
        System.out.print("Array 1.1: ");
        for (int x : arr1) {
            System.out.print(x + " ");
        }
        System.out.println();
*/
        for (int i=0; i < arr1.length; i++) {
            if ( i % 2 != 0) {
                arr1[i] = 0;
            };
        }
//      Вывод массива
        ArrayToConsole("Array 1.2: ", arr1);
/*
        System.out.print("Array 1.2: ");
        for (int x : arr1) {
            System.out.print(x + " ");
        }
        System.out.println("\n");
*/
        System.out.println();
/*
        Создайте массив из 12 случайных целых чисел с отрезка [-15; 15]. Определите какой элемент есть в этом массиве максимальным
          и сообщите индекс его последнего вхождения в массив.
*/
        int [] arr2 = new int[12];
        randInt = new Random();
/*      так не работает !!!
        for (int x : arr2) {
            x = randInt.nextInt(30) - 15;
*/
        for (int i=0; i < arr2.length; i++) {
            arr2[i] = randInt.nextInt(30) - 15;
        }
//      Вывод массива и нахождение максимального элемента
        ArrayToConsole("Array 2: ", arr2);
/*
        System.out.print("Array 2.1: ");
        for (int x : arr2) {
            System.out.print(x + " ");
        }
        System.out.println();
*/
        int maxElement = arr2[0], indMaxElem = 0;
        for (int i=1; i < arr2.length; i++) {
            if ( arr2[i] >= maxElement ) {
                maxElement = arr2[i];
                indMaxElem = i;
            };
        }
        System.out.println("Maximal element of array2 is " + maxElement + ". Maximal element's last index is " + indMaxElem);
        System.out.println();
/*
        1. Создайте массив из 4 случайных целых чисел с отрезка [10; 99]
        2. Выведите его на экран в строчку.
        3. Дальше определите и выведите на экран сообщение о том, есть ли массив строго растущей последовательностью.
*/
        int [] arr3 = new int[4];
        randInt = new Random();
        for (int i=0; i < arr3.length; i++) {
            arr3[i] = randInt.nextInt(89) + 10;
        }
//      Вывод массива
        ArrayToConsole("Array 3: ", arr3);
/*
        System.out.print("Array 3: ");
        for (int x : arr3) {
            System.out.print(x + " ");
        }
        System.out.println();
*/
        boolean isRising = true;
        for (int i=0; i < arr3.length-1; i++) {
            if ( arr3[i] >= arr3[i+1] ) {
                isRising = false;
            }
        }
        System.out.println("Массив " + (isRising ? "" : "не " ) + "является строго растущей последовательностью.\n");
/*
        Напишите программу, которая меняет местами элементы одномерного массива с String в обратном порядке.
        Не используйте дополнительный массив для сохранения результатов.
 */
        String[] s1 = new String[] {"Напишите", "программу,", "которая", "меняет", "местами", "элементы", "одномерного", "массива", "с", "String", "в", "обратном", "порядке."};
//      Вывод массива
        System.out.println("Source: ");
        for (String x : s1) {
            System.out.print(x + " ");
        }
        System.out.println();
        String tmp;
        for (int i=0; i < s1.length / 2; i++) {
            tmp = s1[i];
            s1[i] = s1[s1.length-i-1];
            s1[s1.length-i-1] = tmp;
        }
//      Вывод массива
        System.out.println("Target: ");
        for (String x : s1) {
            System.out.print(x + " ");
        }
        System.out.println("\n");
/*
        1. Создайте 2 массива с 5 случайных целых чисел с отрезка [0; 5] каждый
        2. Выведите массивы на экран в двух отдельных строках
        3. Посчитайте среднее арифметическое элементов каждого массива и сообщите, для какого из массивов это значение
           оказалось больше (или сообщите, что их средние арифметические равны)
*/
        int [] arrA = new int[5], arrB = new int[arrA.length];
        randInt = new Random();
        for (int i=0; i < arrA.length; i++) {
            arrA[i] = randInt.nextInt(5);
            arrB[i] = randInt.nextInt(5);
        }
//      Вывод массива
        ArrayToConsole("Array A: ", arrA);
/*
        System.out.print("Array A: ");
        for (int x : arrA) {
            System.out.print(x + " ");
        }
        System.out.println();
*/
//      Вывод массива
        ArrayToConsole("Array B: ", arrB);
/*
        System.out.print("Array B: ");
        for (int x : arrB) {
            System.out.print(x + " ");
        }
        System.out.println();
*/
        float midA = 0, midB = 0;
        for (int i=0; i < arrA.length; i++) {
            midA += arrA[i];
            midB += arrB[i];
        }
        midA /= arrA.length;
        midB /= arrB.length;
        System.out.println("Среднее арифметическое массива А: " + midA + ",    среднее арифметическое массива B: " + midB);
        if ( midA < midB ) {
            System.out.println("Среднее арифметическое массива А меньше среднего арифметического массива B.");
        } else if ( midA == midB ) {
            System.out.println("Средние арифметические обоих массивов равны.");
        } else {
            System.out.println("Среднее арифметическое массива А больше среднего арифметического массива B.");
        }
    }
}
