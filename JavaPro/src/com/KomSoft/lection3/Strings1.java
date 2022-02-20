package com.KomSoft.lection3;

import java.util.Scanner;

/*
	Created by Volodymyr P. Komarov aka KomSoft
*/
public class Strings1 {
    public static void main(String[] args) {

/*
        Палиндром, оборотень - слово, число, набор символов, словосочетание или стихотворную строку, одинаково читается в обоих направлениях (слева направо и справа налево).
        Написать программу, которая определит ли введена строка палиндромом
        String 1: 123ACA321
        Your string: 123ACA321 is a palindrome
        String 1: 123ABC
        Your string: 123ABC is not palindrome
*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Проверка строки на палиндром.");
        System.out.print("Введите строку: ");
        String str1 = scanner.nextLine();
        boolean isPal = true;
        if ( str1.length() == 0 ) {
            System.out.println("String is empty.");
            isPal = false;
        }
        //  с использованием charAt()
        for(int i = 0; isPal && i < (str1.length() - 1) / 2; i++) {
           isPal = str1.charAt(i) == str1.charAt(str1.length()-1-i);
        }
        System.out.println(String.format("(с использованием charAt()) Строка %s - это %sпалиндром.",str1, isPal ? "" : "не "));
        // c использованием массива chars
        isPal = true;
        char [] chars = str1.toCharArray();
        for(int i = 0; isPal && i < (chars.length - 1) / 2; i++) {
            isPal = Character.toUpperCase(chars[i]) == Character.toUpperCase(chars[chars.length-1-i]);
        }
        System.out.println(String.format("(c использованием массива chars) Строка %s - это %sпалиндром (ignore case).",new String(chars), isPal ? "" : "не "));
        //  с использованием StringBuffer
        isPal = str1.equals(new StringBuffer(str1).reverse().toString());
        System.out.println(String.format("(с использованием StringBuffer) Строка %s - это %sпалиндром.", str1, isPal ? "" : "не "));

/*
        Напишите программу Java для объединения введенного строки до конца другого строки
        String 1: PHP Exercises and
        String 2: Python Exercises
        The concatenated string: PHP Exercises and Python Exercises
*/
        System.out.println("\n2. присоединяем строку к концу другой.");
        System.out.print("Введите первую строку: ");
        String str11 = scanner.nextLine();
        System.out.print("Введите вторую строку: ");
        String str12 = scanner.nextLine();
        System.out.println(str11 + str12);
        System.out.println(str11.concat(str12));
        System.out.println(String.join(" ", str11, str12));
/*
        Напишите программу java для сравнения двух строк лексикографически, не учитывая различия в раскладке
        String 1: This is exercise 1
        String 2: This is Exercise 1
        "This is exercise 1" is equal to "This is Exercise 1"
*/
        System.out.println("\n3. Сравниваем строки лексикографически.");
        System.out.print("Введите первую строку: ");
        str11 = scanner.nextLine();
        System.out.print("Введите вторую строку: ");
        str12 = scanner.nextLine();
        if ( str11.equalsIgnoreCase(str12) ) {
            System.out.println("Сроки равны лексикографически (без учета регистра).");
        } else {
            System.out.println("Сроки не равны.");
        }
/*
        4.   Напишите программу Java, чтобы вернуть новую строку, используя все символы парных позиций по данному строки.
        The given string is: test string
        The new string is: ts srn
*/
        System.out.println("\n4. Создаем строку из четных позиций.");
        System.out.print("Введите строку: ");
        String str4 = scanner.nextLine();
        char[] charsEven = new char[(str4.length() + 1) / 2];
        // Пробел - это тоже символ!
        for(int i = 0; i < charsEven.length; i++) {
            charsEven[i] = str4.charAt(i*2);
        }
        System.out.println("Результат (без разбивки по словам) - " + new String(charsEven));
        // можно разбить на слова и выбирать из слов четные буквы.
        String[] wordArray = str4.split(" ");
        int charCount = 0;
/*
        for(int j = 0; j < wordArray.length; j++) {
            charCount += (wordArray[j].length() + 1) / 2;
        }
*/
        for(String word : wordArray) {
            charCount += (word.length() + 1) / 2;
        }
        char[] charsEven2 = new char[charCount + wordArray.length - 1];
        int index = 0;
        for(int j = 0; j < wordArray.length; j++) {
            for(int i = 0; i < wordArray[j].length(); i += 2) {
                charsEven2[index++] = wordArray[j].charAt(i);
            }
            if (j < wordArray.length - 1 ) { // если не последнее слово - добавляем пробел
                charsEven2[index++] = ' ';
            }
        }
        System.out.println("Результат (с разбивкой по словам) - " + new String(charsEven2));
        // то же самое с использованием StringBuffer()
//        StringBuffer strBuffer = new StringBuffer(charCount + wordArray.length - 1);
        StringBuffer strBuffer = new StringBuffer(charCount + wordArray.length - 1);
        strBuffer.setLength(charCount + wordArray.length - 1);
        index = 0;
        for(int j = 0; j < wordArray.length; j++) {
            for(int i = 0; i < wordArray[j].length(); i += 2) {
                strBuffer.setCharAt(index++, wordArray[j].charAt(i));
            }
            if (j < wordArray.length - 1 ) { // если не последнее слово - добавляем пробел
                strBuffer.setCharAt(index++, ' ');
            }
        }
        System.out.println("Результат (с разбивкой по словам) - " + strBuffer.toString());

    }
}
