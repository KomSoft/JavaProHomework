package com.KomSoft.lection2;

import java.util.Scanner;

/*
	Created by Volodymyr P. Komarov aka KomSoft
*/
public class TaskFor {

    public static void main(String[] args) {

/*      Задача №1
        Необходимо вывести в консоль цифры от 1 до 5. В консоли должно будет:
        1 2 3 4 5
*/
        System.out.println("Task 1");
        for(int i = 1; i <=5; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        /*      Задача №2
        Необходимо вывести в консоль цифры от 5 до 1. В консоли должно будет:
        5 4 3 2 1
*/
        System.out.println("Task 2");
        for(int i = 5; i > 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

/*      Задача №3
        Необходимо вывести в консоль таблицу умножения на 3. В консоли должно будет:
        3 * 1 = 3
        3 * 2 = 6
        ...
        3 * 10 = 30
*/
        System.out.println("Task 3");
        for(int i = 1; i <=10; i++) {
            System.out.println("3 * " + i + " = " + (i*3));
        }
        System.out.println("\n");

/*      Задача №4
        Напишите программу, где пользователь вводит любое целое положительное число. Программа суммирует все цифры от 1 до введенного пользователя числом.
        Например:
        если пользователь вводит число 3. Программа должна посчитать сумму от 1 до 3, то есть 1 + 2 + 3 и выдавать ответ 6.
        если пользователь вводит число 5. Программа должна посчитать сумму от 1 до 5, то есть 1 + 2 + 3 + 4 + 5 и выдавать ответ 15.
*/
        System.out.println("Task 4");
        System.out.print("Please enter a positive number bigger then 1: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if ( n > 1 ) {
            int sum = 0;
            for(int i = 1; i <=n; i++) {
                sum += i;
            }
            System.out.println("Sum of numbers from 1 to " + n + " is " + sum);
        } else {
            System.out.println("Sorry, but you has entered a wrong number - " + n);
        }
        System.out.println();

/*      Задача №5
        Необходимо, чтобы программа выводила на экран такую последовательность:
        7 14 21 28 35 42 49 56 63 70 77 84 91 98
*/
        System.out.println("Task 5.1");
        n = 14;
        for(int i = 1; i <=n; i++) {
            System.out.print((i*7) + " ");
        }
        System.out.println();
        System.out.println("Task 5.2");
//        n = 14,
        int mul = 0;
        for(int i = 1; i <=n; i++) {
            mul += 7;
            System.out.print(mul + " ");
        }
        System.out.println("\n");

/*      Задача №6
        Необходимо вывести в консоль следующую последовательность цифр:
        1 2 4 8 16 32 64 128 256 512
*/
        System.out.println("Task 6");
        n = 9;
        mul = 1;
        for(int i = 0; i < 10; i++) {
            System.out.print(mul + " ");
            mul *= 2;
//          или с применением библиотеки Math
//            System.out.print((int) Math.pow(2,i) + " ");
        }
        System.out.println("\n");
    }
}
