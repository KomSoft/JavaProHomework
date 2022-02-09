package com.KomSoft.lection2;

import java.util.Locale;
import java.util.Scanner;

/*
	Created by Volodymyr P. Komarov aka KomSoft
*/
public class TaskPuzzle {

/*
    Задача-загадка №7 (циклы и переключатели оператора)
    Представляем, что у нас есть загадка: "Что это есть такое: синий, большой, с усами и полный зайцев?" Ответ: троллейбус.
    Напишите программу, которая будет считывать с консоли ответы:
    •	у пользователя есть 3 попытки. После трех ответов программа должна завершиться;
    •	если пользователь вводит "Троллейбус", мы выводим в консоль "Правильно!" и выходим из цикла;
    •	если пользователь вводит "Сдаюсь", мы выводим в консоль "Правильный ответ: "Троллейбус". и выходим из цикла;
    •	если пользователь вводит любую другую ответ, мы выводим в консоль "Подумайте еще". и продолжаем цикл.
*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Отгадайте загадку: Что это есть такое: синий, большой, с усами и полный зайцев?");
        System.out.println("У Вас есть три попытки. Если Вы сдаетесь - введите \"Сдаюсь\" (без кавычек).");
        int tryCount = 0;
        boolean isEnd = false;
        do {
            System.out.print("Введите Ваш вариант ответа (слово): ");
            String answer = scanner.nextLine().toUpperCase(Locale.ROOT);
            tryCount++;
            isEnd = tryCount >= 3;
            switch (answer) {
                case "ТРОЛЛЕЙБУС" : {
                    isEnd = true;
                    System.out.println("Правильно!");
                    break;
                }
                case "СДАЮСЬ" : {
                    System.out.println("Правильный ответ: \"Троллейбус\"");
                    isEnd = true;
                    break;
                }
                default : {
                    if (!isEnd) System.out.print("Подумайте еще. ");
                }
            }
        } while ( !isEnd );
    }
}
